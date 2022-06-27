package com.nagarro.javaassignment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.javaassignment4.model.Tshirt;
import com.nagarro.javaassignment4.repository.TshirtRepository;

@Service
public class HomeService {
	
	private final TshirtRepository tshirtRepository;
	
	@Autowired
	public HomeService(TshirtRepository tshirtRepository) {
		this.tshirtRepository = tshirtRepository;
		
	}

	public List<Tshirt> getTshirtData(){
		  
		return tshirtRepository.findTshirtsOrdered();
	}
	
	public List<Tshirt> getTshirtData(UserPreferencesInput userPref){
		
		 List<Tshirt> data;
		
		 if(userPref.getoutputpref() == 1)
		  	data = tshirtRepository.findTshirtsOrderByPrice(userPref.getColour(),userPref.getSize());
		 else 
			 data = tshirtRepository.findTshirtsOrderByRating(userPref.getColour(),userPref.getSize());
			 
			 
		  return data;
	}
}



