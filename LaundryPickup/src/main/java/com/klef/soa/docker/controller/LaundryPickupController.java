package com.klef.soa.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.docker.dto.LaundryPickupDTO;
import com.klef.soa.docker.entity.LaundryPickupEntity;
import com.klef.soa.docker.service.LaundryPickupService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/laundrypickup")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
 public class LaundryPickupController 
{
	
	
	@Autowired
	private LaundryPickupService service;

	@GetMapping("/")
	public String test()
	{
		return "Laundry Pickup Service is running";
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<LaundryPickupEntity> addLaundry(
	        @Valid @RequestBody LaundryPickupEntity p) {

	    LaundryPickupEntity laundry = service.addlaundry(p);

	    return ResponseEntity.status(201).body(laundry);
	}
		
		@GetMapping("/displayall")
		public ResponseEntity<List<LaundryPickupEntity>> displayAllPatients()
		{
			List<LaundryPickupEntity> laundry = service.displayallLaundry(); 
			return ResponseEntity.status(200).body(laundry);
		}
	
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteLaundryById(
		        @PathVariable Long id) {

		    boolean exists = service.deleteLaundryById(id)
		            .equals("Laundry Deleted Successfully");

		    if (exists) {
		        return ResponseEntity.ok(
		                "Laundry Deleted Successfully");
		    }

		    return ResponseEntity.status(404)
		            .body("Laundry ID Not Found");
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<LaundryPickupEntity> displayById(
		        @PathVariable Long id) {

		    return ResponseEntity.ok(service.displayLaundryById(id));
		}

		@PutMapping("/update/{id}")
		public ResponseEntity<LaundryPickupEntity> updateLaundry(
		        @PathVariable Long id,
		        @RequestBody LaundryPickupDTO dto) {

		    return ResponseEntity.ok(service.updateLaundry(id, dto));
		}
}
