package com.klef.soa.docker.service;

import java.util.List;

import com.klef.soa.docker.dto.LaundryPickupDTO;
import com.klef.soa.docker.entity.LaundryPickupEntity;

public interface LaundryPickupService 
{
	 LaundryPickupEntity addlaundry(LaundryPickupEntity laundry);
	 
	   List<LaundryPickupEntity> displayallLaundry();
	   
	   String deleteLaundryById(Long id);
	   
	   LaundryPickupEntity displayLaundryById(Long id);

	   LaundryPickupEntity updateLaundry( Long id, LaundryPickupDTO dto);

}
