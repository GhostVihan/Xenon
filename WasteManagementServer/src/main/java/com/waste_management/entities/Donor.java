package com.waste_management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "donor")
public class Donor {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "donor_id", nullable = false, unique = true)
	private int donorId;
	@Column(name = "donor_name")
	private String donorName;
	@Column(name = "donor_address")
	private String donorAddress;
	@Column(name = "donor_mobile")
	private String donorMobile;
	@Column(name = "donor_email")
	private String donorEmail;
	@Column(name = "donor_password")
	private String donorPassword;
	@Column(name = "donor_type")
	private String donorType;
	@Column(name = "role")
	private String role;
	
	
	@OneToMany
	private List<DonateItems> donateItemsList;
	
	@OneToMany
	private List<Orders> ordersList;
	
	
	public Donor() {
		
	}
	public Donor(int donorId, String donorName, String donorAddress, String donorMobile, String donorEmail,
			String donorPassword, String donorType, String role) {
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorAddress = donorAddress;
		this.donorMobile = donorMobile;
		this.donorEmail = donorEmail;
		this.donorPassword = donorPassword;
		this.donorType = donorType;
		this.role = role;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}
	public String getDonorMobile() {
		return donorMobile;
	}
	public void setDonorMobile(String donorMobile) {
		this.donorMobile = donorMobile;
	}
	public String getDonorEmail() {
		return donorEmail;
	}
	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}
	public String getDonorPassword() {
		return donorPassword;
	}
	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}
	public String getDonorType() {
		return donorType;
	}
	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorAddress=" + donorAddress
				+ ", donorMobile=" + donorMobile + ", donorEmail=" + donorEmail + ", donorPassword=" + donorPassword
				+ ", donorType=" + donorType + ", role=" + role + "]";
	}
//	public Donor getDonor() {
//		return donor;
//	}
//	public void setDonor(Donor donor) {
//		this.donor = donor;
//	}
	
	
	
}
