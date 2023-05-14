package com.waste_management.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "ngo_id")
	private Ngo ngo;
	
	@ManyToOne
	@JoinColumn(name = "donor_id")
	private Donor donor;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private DonateItems donateItems;

	
	public Orders() {
		
	}
	public Orders(int orderId, String status, Ngo ngo, DonateItems donateItems, Donor donor) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.ngo = ngo;
		this.donateItems = donateItems;
		this.donor = donor;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Ngo getNgo() {
		return ngo;
	}
	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}
	public DonateItems getDonateItems() {
		return donateItems;
	}
	public void setDonateItems(DonateItems donateItems) {
		this.donateItems = donateItems;
	}	
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	
}
