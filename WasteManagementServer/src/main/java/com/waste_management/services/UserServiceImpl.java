package com.waste_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waste_management.daos.DonorDao;
import com.waste_management.daos.OrderDao;
import com.waste_management.daos.DonateItemsDao;
import com.waste_management.entities.Donor;
import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;
import com.waste_management.models.DonorDTO;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private DonorDao donorDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private DonateItemsDao donateItemsDao;
	
	@Override
	public Donor authenticate(String email, String password) {
		Donor donor = donorDao.findByDonorEmail(email);
		if (donor.getDonorPassword().equals(password)) {
			return donor;
		}
		return null;
	}

	@Override
	public Donor addDonor(Donor donor) {
		Donor result = donorDao.save(donor);
		if (result != null)
			return result;
		return null;
	}
	@Override
	public Donor changePassword(String email, String password) {
		Donor donorAccount = donorDao.findByDonorEmail(email);
		if (donorAccount.getDonorEmail().equals(email)) {
			donorAccount.setDonorPassword(password);
			return donorAccount;
		}
		return null;
	}

	@Override
	public List<Donor> getDonorList() {
		List<Donor> donorList = donorDao.findAll();
		if (donorList != null) {
			return donorList;
		}
		return null;
	}

	@Override
	public Optional<Donor> fetchProfile(int profile_id) {
		Optional<Donor> donor = donorDao.findById(profile_id);
		if (!donor.isEmpty()) {
			return donor;
		}
		return null;
	}

	@Override
	public boolean addItems(DonateItems foodDetails, int profile_id) {
		Optional<Donor> donor = donorDao.findById(profile_id);
		foodDetails.setDonor(donor.get());
		DonateItems result = donateItemsDao.save(foodDetails);
		if (result != null)
			return true;
		return false;
	}

	@Override
	public List<Orders> getAllOrders(int donorId) {
		Optional<Donor> donor = donorDao.findById(donorId);
		if (!donor.isEmpty()) {
			List<Orders> orders = orderDao.findByDonor(donor.get());
			return orders;
		}
		return null;
	}

	@Override
	public boolean orderStatus(int profileId, int orderId, String status) {
		Optional<Donor> donor = donorDao.findById(profileId);
		if (!donor.isEmpty()) {
			orderDao.getById(orderId).setStatus(status);
			return true;
		}
		return false;
	}

	@Override
	public List<DonateItems> getAllDonationItems(int donorId) {
		Optional<Donor> donor = donorDao.findById(donorId);
		if (!donor.isEmpty()) {
			List<DonateItems> donations = donateItemsDao.getByDonor(donor.get());
			return donations;
		}
		return null;
	}

	@Override
	public boolean removeItems(int profile_id, int itemId) {
		Optional<Donor> donor = donorDao.findById(profile_id);
		if (!donor.isEmpty()) {
			Optional<DonateItems>  donateItems = donateItemsDao.findById(itemId);
			System.out.println(donateItems.get());
			orderDao.deleteByDonateItems(donateItems.get());
			donateItemsDao.deleteById(itemId);
			return true;
		}
		return false;
	}
	
	
}
