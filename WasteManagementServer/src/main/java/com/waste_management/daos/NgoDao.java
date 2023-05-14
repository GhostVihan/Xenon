package com.waste_management.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.waste_management.entities.Donor;
import com.waste_management.entities.Ngo;

public interface NgoDao extends JpaRepository<Ngo, Integer>{
	
	Ngo findByUsername(String username);
	Ngo findByEmail(String email);
	
}
