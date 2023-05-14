package com.waste_management.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.waste_management.entities.DonateItems;
import com.waste_management.entities.Donor;
import com.waste_management.entities.Ngo;
import com.waste_management.entities.Orders;
import com.waste_management.models.DonorDTO;
import com.waste_management.models.Response;
import com.waste_management.services.NgoService;

@CrossOrigin
@RestController
public class NgoControllerImpl {
	
	@Autowired
	private NgoService ngoService;
	
	@PostMapping("/api/ngo/signin")
	public ResponseEntity<?> auth(@RequestBody DonorDTO user){
		Ngo result = ngoService.authenticate(user.getEmail(), user.getPassword());
		if (result != null)
			return Response.success(result, "Logged in successfully");
		return Response.error(null, "invalid login");
	}
	
	@PostMapping("/api/ngo/register")
	public ResponseEntity<?> register(@RequestBody Ngo newNgo){
		Ngo ngo = ngoService.addNgo(newNgo);
		if (ngo != null)
			return Response.success(null, "Registered successfully");
		return Response.error(null, "Something went wrong");
	}
	
	@PutMapping("/api/ngo/forgotPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody Map<String,String> body){
		System.out.println(body);
		Ngo ngo = ngoService.changePassword(body.get("email").toString(), body.get("password").toString());
		if (ngo != null)
			return Response.success(null, "Password changed");
		return Response.error(null, "Something went wrong");
	}
	
	@GetMapping("/api/ngo/all")
	public ResponseEntity<?> getAllNgos(){
		List<Ngo> ngoList = ngoService.getAllNgos();
		if (ngoList.size() != 0)
			return Response.success(ngoList, "Got ngos list");
		return Response.error(ngoList, "Not found");
	}
	
	@GetMapping("/api/ngo/profile/{profile_id}")
	public ResponseEntity<?> getProfile(@PathVariable("profile_id") int profile_id){
		Optional<Ngo> ngo = ngoService.fetchProfile(profile_id);
		System.out.println(ngo);
		if (!ngo.isEmpty())
			return Response.success(ngo, "got profile");
		return Response.error(null, "Not found");
	}
	
	@PostMapping("/api/ngo/order/{profile_id}/{item_id}/{donor_id}")
	public ResponseEntity<?> order(
			@RequestBody Orders newOrder,
			@PathVariable("profile_id") int profileId,
			@PathVariable("item_id") int itemId,
			@PathVariable("donor_id") int donorId){
		System.out.println("controller" + newOrder);
		Orders nOrder = ngoService.makeOrder(newOrder, profileId, donorId, itemId);
		if (nOrder != null)
			return Response.success(nOrder, "Order placed");
		return Response.error(null, "Something went wrong");
	}
	@GetMapping("/api/ngo/allDonations/{profile_id}")
	public ResponseEntity<?> getAllDonations(@PathVariable("profile_id") int profile_id){
		List<DonateItems> donateItems = ngoService.getAllDonations(profile_id);
		System.out.println(donateItems);
		if (!donateItems.isEmpty())
			return Response.success(donateItems, "got donations");
		return Response.error(null, "Not found");
	}
	@GetMapping("/api/ngo/allOrders/{profile_id}")
	public ResponseEntity<?> getOrders(@PathVariable("profile_id") int profile_id){
		List<Orders> orders = ngoService.getAllOrders(profile_id);
		System.out.println(orders);
		if (!orders.isEmpty())
			return Response.success(orders, "got orders");
		return Response.error(null, "Not found");
	}
}
