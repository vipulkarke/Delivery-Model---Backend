package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Menu;

public interface MenuService {
	Menu getMenu(Integer fk_id);
}
