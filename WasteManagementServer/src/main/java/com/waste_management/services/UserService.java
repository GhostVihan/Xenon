package com.waste_management.services;
import java.util.List;
import java.util.Optional;

import com.waste_management.entities.Donor;
import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;

public interface UserService {
	Donor authenticate(String email, String password);
	Donor addDonor(Donor donor);
	List<Donor> getDonorList();
	Donor changePassword(String username, String password);
	Optional<Donor> fetchProfile(int profile_id); 
	boolean addItems(DonateItems foodDetails, int profile_id);
	boolean removeItems(int profile_id, int itemId);
	List<Orders> getAllOrders(int ngoId);
	List<DonateItems> getAllDonationItems(int donorId);
	boolean orderStatus(int profileId, int orderId, String status);
}
