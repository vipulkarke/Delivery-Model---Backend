package com.bezkoder.spring.login.security.services;

import java.util.List;


import com.bezkoder.spring.login.models.Restaurant;




public interface RestaurantService {
	
	List<Restaurant> getAllUsers();
	Restaurant get_A_User(Integer id);
	Restaurant addRestaurant(Restaurant restaurant);
	void deleteRestaurant(Integer id);
	
	
		
	
	
}
