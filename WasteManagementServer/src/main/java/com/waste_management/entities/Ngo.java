package com.waste_management.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ngo")
public class Ngo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int ngo_id;
	private String username;
	private String password;
	private int employees;
	private String email;
	private String mobile;
	private String address;
	private String ngo_proof;
	
	@OneToMany
	private List<Orders> orderList;
	
//	public List<Orders> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<Orders> orderList) {
//		this.orderList = orderList;
//	}

	public Ngo(){
		
	}
			
	public Ngo(int ngo_id, String username, String password, int employees, String email, String mobile, String address,
			String ngo_proof) {
		super();
		this.ngo_id = ngo_id;
		this.username = username;
		this.password = password;
		this.employees = employees;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.ngo_proof = ngo_proof;
	}
	
	public int getNgo_id() {
		return ngo_id;
	}

	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNgo_proof() {
		return ngo_proof;
	}

	public void setNgo_proof(String ngo_proof) {
		this.ngo_proof = ngo_proof;
	}
	
	
}
