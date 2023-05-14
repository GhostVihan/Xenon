package com.waste_management.services;

import java.util.List;
import java.util.Optional;

import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Donor;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;

public interface NgoService {
	Ngo authenticate(String email, String password);
	List<Ngo> getAllNgos();
	Ngo addNgo(Ngo ngo);
	Ngo changePassword(String email, String password);
	Optional<Ngo> fetchProfile(int profile_id);
	Orders makeOrder(Orders newOrder, int profileId, int donorId, int itemId);
	List<Orders> getAllOrders(int ngoId);
	List<DonateItems> getAllDonations(int ngoId);
}
