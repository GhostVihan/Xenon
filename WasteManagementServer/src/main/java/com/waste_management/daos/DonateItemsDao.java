package com.waste_management.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Donor;

public interface DonateItemsDao extends JpaRepository<DonateItems, Integer>{
	List<DonateItems> getByDonor(Donor donor);
//	@Query("select * from ")
	List<DonateItems> findAllByOrderByItemIdDesc();
}
