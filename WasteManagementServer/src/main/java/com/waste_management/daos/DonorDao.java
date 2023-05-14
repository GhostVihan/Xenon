package com.waste_management.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.waste_management.entities.Donor;

public interface DonorDao extends JpaRepository<Donor, Integer>{
	
	Donor findByDonorEmail(String email);
	Donor save(Donor donor);
	
}
