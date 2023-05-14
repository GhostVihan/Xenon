package com.waste_management.models;

import org.springframework.beans.BeanUtils;

import com.waste_management.entities.Donor;


public class DonorDTO {
	private String email;
	private String password;
	
	public DonorDTO() {
		
	}
	public DonorDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
//	public static DonorDTO fromEntity(Donor entity) {
//		DonorDTO dto = new DonorDTO();
//		BeanUtils.copyProperties(entity, dto);
//		dto.setEmail(entity.getDonor().getDonorEmail());
//		dto.setPassword(entity.getDonor().getDonorPassword());
//		return dto;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
