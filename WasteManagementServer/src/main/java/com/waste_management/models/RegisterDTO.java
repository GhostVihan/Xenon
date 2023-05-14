package com.waste_management.models;

public class RegisterDTO {
	private int donorId;
	private String donorName;
	private String donorAddress;
	private String donorMobile;
	private String donorEmail;
	private String donorPassword;
	private String donorType;
	private String role;
	
	public RegisterDTO() {
		
	}
	public RegisterDTO(int donorId, String donorName, String donorAddress, String donorMobile, String donorEmail,
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

}
