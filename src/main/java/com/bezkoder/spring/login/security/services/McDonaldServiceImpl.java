package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.Mcdonald_menu;

import com.bezkoder.spring.login.repository.McDonaldRepo;

@Service
public class McDonaldServiceImpl implements McDonaldsService{

	@Autowired
	private McDonaldRepo mcRepo;
	
	@Override
	public List<Mcdonald_menu> getAll() {
		return (List<Mcdonald_menu>) mcRepo.findAll();
		
	}

}
