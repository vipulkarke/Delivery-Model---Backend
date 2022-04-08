package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.Restaurant;
import com.bezkoder.spring.login.repository.RestaurantRepository;


@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restRepo;
	
	
	@Override
	public List<Restaurant> getAllUsers() {
		return (List<Restaurant>) restRepo.findAll();
	}

}
