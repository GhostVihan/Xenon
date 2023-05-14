package com.waste_management.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Donor;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{
	List<Orders> findByNgo(Ngo ngo);
	List<Orders> findByDonor(Donor donor);
	int deleteByDonateItems(DonateItems donateItems);
}
