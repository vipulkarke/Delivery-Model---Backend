package com.bezkoder.spring.login.security.services;


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

}
