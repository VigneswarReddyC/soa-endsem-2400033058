package com.klef.soa.docker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.klef.soa.docker.dto.LaundryPickupDTO;
import com.klef.soa.docker.entity.LaundryPickupEntity;
import com.klef.soa.docker.repository.LaundryPickupRepository;
import com.klef.soa.docker.service.LaundryPickupService;

@Service
public class LaundryPickupServiceImpl implements LaundryPickupService
{
	
	@Autowired
	private LaundryPickupRepository repo;
	
	@GetMapping("/")
	public String test()
	{
		return "SOA Programming & MicroServices";
	}


	@Override
	public LaundryPickupEntity addlaundry(LaundryPickupEntity laundry) {
		
		return repo.save(laundry);
	}

	@Override
	public List<LaundryPickupEntity> displayallLaundry() {
		
		return repo.findAll();
	}

	@Override
	public String deleteLaundryById(Long id) {
		boolean status = repo.existsById(id);
		if(status) 
		{
			repo.deleteById(id);
			return "Laundry Deleted Successfully";
		}
		else
		{
			return "laundry ID Not Found";
		}
	}


	@Override
	public LaundryPickupEntity displayLaundryById(Long id) {
	    return repo.findById(id)
	            .orElseThrow(() ->
	                new RuntimeException("Laundry pickup not found: " + id));
	}

	@Override
	public LaundryPickupEntity updateLaundry(
	        Long id, LaundryPickupDTO dto) {

	    LaundryPickupEntity laundry = repo.findById(id)
	            .orElseThrow(() ->
	                new RuntimeException("Laundry pickup not found: " + id));

	    laundry.setCustomerName(dto.getCustomerName());
	    laundry.setPickupDate(dto.getPickupDate());
	    laundry.setWeightKg(dto.getWeightKg());
	    laundry.setDelivered(dto.getDelivered());

	    return repo.save(laundry);
	}
	


	
	

}
