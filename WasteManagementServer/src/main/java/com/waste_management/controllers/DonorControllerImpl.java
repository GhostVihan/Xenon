package com.waste_management.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.waste_management.entities.Donor;
import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;
import com.waste_management.models.DonorDTO;
import com.waste_management.models.RegisterDTO;
import com.waste_management.models.Response;
import com.waste_management.services.UserService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DonorControllerImpl {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/donor/signin")
	public ResponseEntity<?> auth(@RequestBody DonorDTO user){
		Donor result = userService.authenticate(user.getEmail(), user.getPassword());
		if (result != null)
			return Response.success(result, "Logged in successfully");
		return Response.error(null, "invalid login");
	}
	@PostMapping("/api/donor/register")
	public ResponseEntity<?> register(@RequestBody Donor newUser){
		System.out.println(newUser);
		Donor donor = userService.addDonor(newUser);
		if (donor != null)
			return Response.success(null, "Registered successfully");
		return Response.error(null, "Something went wrong");
	}
	
	@PutMapping("/api/donor/forgotPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody Map<String,String> body){
		System.out.println(body);
		Donor donor = userService.changePassword(body.get("email").toString(), body.get("password").toString());
		if (donor != null)
			return Response.success(null, "Password changed");
		return Response.error(null, "Something went wrong");
	}
	
	@GetMapping("/api/donors/all")
	public ResponseEntity<?> listAllDonors(){
		List<Donor> donorList = userService.getDonorList();
		if (donorList.size() != 0)
			return Response.success(donorList, "got donor list");
		return Response.error(null, "Not found");
		
	}
	@GetMapping("/api/donor/profile/{profile_id}")
	public ResponseEntity<?> getProfile(@PathVariable("profile_id") int profile_id){
		Optional<Donor> donor = userService.fetchProfile(profile_id);
		if (donor != null)
			return Response.success(donor, "got profile");
		return Response.error(null, "Not found");
	}
	
	@PostMapping("/api/donor/add/items/{profile_id}")
	public ResponseEntity<?> addNewItem(@RequestBody DonateItems newFoodDetails, @PathVariable("profile_id") int profile_id){
		System.out.println("controller" + newFoodDetails);
		boolean result = userService.addItems(newFoodDetails, profile_id);
		if (result)
			return Response.success(result, "new item added");
		return Response.error(null, "Something went wrong");
	}
	
	@DeleteMapping("/api/donor/delete/item/{profile_id}/{item_id}")
	public ResponseEntity<?> addNewItem(@PathVariable("profile_id") int profile_id, @PathVariable("item_id") int itemId){
		
		boolean result = userService.removeItems(profile_id, itemId);
		if (result)
			return Response.success(result, "Item removed");
		return Response.error(null, "Something went wrong");
	}
	
	@GetMapping("/api/donor/allOrders/{profile_id}")
	public ResponseEntity<?> getOrders(@PathVariable("profile_id") int profile_id){
		List<Orders> orders = userService.getAllOrders(profile_id);
		if (!orders.isEmpty())
			return Response.success(orders, "got orders");
		return Response.error(null, "Not found");
	}
	
	@GetMapping("/api/donor/allDonations/{profile_id}")
	public ResponseEntity<?> getAllDonations(@PathVariable("profile_id") int profile_id){
		List<DonateItems> donateItems = userService.getAllDonationItems(profile_id);
		if (!donateItems.isEmpty())
			return Response.success(donateItems, "got donations");
		return Response.error(null, "Not found");
	}
	
	@PutMapping("/api/donor/orderStatus")
	public ResponseEntity<?> changeOrderStatus(@RequestBody Map<String, String> obj ){
		int profileId = Integer.parseInt(obj.get("profile_id").toString());
		int orderId = Integer.parseInt(obj.get("order_id").toString());
		String newStatus = obj.get("newStatus").toString();
		boolean orders = userService.orderStatus(profileId, orderId, newStatus);
		if (orders)
			return Response.success(orders, "Order status changed");
		return Response.error(null, "Not found");
	}
}
