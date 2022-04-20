package com.bezkoder.spring.login.security.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.Menu;

import com.bezkoder.spring.login.repository.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService{

	
	@Autowired
	private MenuRepo   menuRepo;
	
	@Override
	public Menu getMenu(Integer fk_id) {
		return menuRepo.findById(fk_id).orElseThrow();
	}

	@Override
	public List<Menu> All() {
		return (List<Menu>) menuRepo.findAll();
	}

	@Override
	public Menu AddMenu(Menu menu) {
		return menuRepo.save(menu);
	}

	

}
