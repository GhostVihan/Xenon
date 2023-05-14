package com.waste_management.entities;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "donate_items")
public class DonateItems {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "cooked_time")
	private String cookedTime;
	@Column(name = "expiry_date")
	private String expiryDate;
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "donor_id", nullable=false)
	private Donor donor;
	
	@OneToMany
	private List<Orders> orders;

	public DonateItems() {}
	
	public DonateItems(int itemId, String itemName, String categoryName, String quantity, String cookedTime,
			String expiryDate, Donor donor, String status) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.cookedTime = cookedTime;
		this.expiryDate = expiryDate;
		this.donor = donor;
		this.status = status;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCookedTime() {
		return cookedTime;
	}

	public void setCookedTime(String cookedTime) {
		this.cookedTime = cookedTime;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

