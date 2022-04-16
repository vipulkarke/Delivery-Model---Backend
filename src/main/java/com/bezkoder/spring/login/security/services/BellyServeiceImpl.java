package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.BellyDarbar;
import com.bezkoder.spring.login.repository.BellyRepo;
@Service
public class BellyServeiceImpl implements BellyService{

	@Autowired
	private BellyRepo bellyRepo;
	
	@Override
	public List<BellyDarbar> getAllmenu() {
		return (List<BellyDarbar>) bellyRepo.findAll();
	}

}
