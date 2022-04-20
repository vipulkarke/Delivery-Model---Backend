package com.bezkoder.spring.login.security.services;

import java.util.List;

import com.bezkoder.spring.login.models.Menu;

public interface MenuService {
	Menu getMenu(Integer fk_id);
	List <Menu> All();
	Menu AddMenu(Menu menu);
}
