package com.waste_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waste_management.daos.DonateItemsDao;
import com.waste_management.daos.DonorDao;
import com.waste_management.daos.NgoDao;
import com.waste_management.daos.OrderDao;
import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Donor;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;

@Transactional
@Service
public class NgoServiceImpl implements NgoService{

	@Autowired
	private NgoDao ngoDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private DonorDao donorDao;
	
	@Autowired
	private DonateItemsDao donateItemsDao;
	
	
	@Override
	public List<Ngo> getAllNgos() {
		List<Ngo> ngoList = ngoDao.findAll();
		if (ngoList != null) {
			return ngoList;
		}
		return null;
	}


	@Override
	public Ngo addNgo(Ngo ngo) {
		Ngo _ngo = ngoDao.save(ngo);
		if (_ngo != null) {
			return _ngo;
		}
		return null;
	}


	@Override
	public Ngo changePassword(String email, String password) {
		Ngo ngoAccount = ngoDao.findByEmail(email);
		if (ngoAccount != null) {
			ngoAccount.setPassword(password);
			return ngoAccount;
		}
		return null;
	}


	@Override
	public Optional<Ngo> fetchProfile(int profile_id) {
		Optional<Ngo> ngo = ngoDao.findById(profile_id);
		if (ngo != null)
			return ngo;
		return null;
	}
	
	@Override
	public Orders makeOrder(Orders newOrder, int profileId, int donorId, int itemId) {
		Optional<Ngo> ngo = ngoDao.findById(profileId);
		if (!ngo.isEmpty()) {
			Optional<DonateItems> donateItems = donateItemsDao.findById(itemId);
			donateItems.get().setStatus("Claimed");
			Optional<Donor> donor = donorDao.findById(donorId);
			newOrder.setNgo(ngo.get());
			newOrder.setDonateItems(donateItems.get());
			newOrder.setDonor(donor.get());
			Orders result = orderDao.save(newOrder);
			if (result != null)
				return result;
		}
		return null;
		
	}

	@Override
	public List<Orders> getAllOrders(int ngoId) {
		Optional<Ngo> ngo = ngoDao.findById(ngoId);
		if (!ngo.isEmpty()) {
			List<Orders> orders = orderDao.findByNgo(ngo.get());
			return orders;
		}
		return null;
	}


	@Override
	public Ngo authenticate(String email, String password) {
		Ngo ngo = ngoDao.findByEmail(email);
		if (ngo != null) {
			if (ngo.getPassword().equals(password))
				return ngo;
		}
		return null;
	}


	@Override
	public List<DonateItems> getAllDonations(int ngoId) {
		Optional<Ngo> ngo = ngoDao.findById(ngoId);
		if (!ngo.isEmpty()) {
			List<DonateItems> donateItems = donateItemsDao.findAllByOrderByItemIdDesc();
			return donateItems;
		}
		return null;
	}

}
