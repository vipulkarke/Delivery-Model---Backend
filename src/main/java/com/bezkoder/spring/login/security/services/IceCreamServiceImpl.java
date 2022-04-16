package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.Icecream;
import com.bezkoder.spring.login.repository.IceCreamRepo;


@Service
public class IceCreamServiceImpl implements IceCreamService{

	@Autowired
	private IceCreamRepo IceRepo;
	
	@Override
	public List<Icecream> getAllIce() {
		return (List<Icecream>) IceRepo.findAll();
	}

	
	
	

}
