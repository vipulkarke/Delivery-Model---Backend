package com.bezkoder.spring.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bezkoder.spring.login.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	Optional<Restaurant> findRestaurantById(Long id);
	void deleteRestaurantById(Integer id);
	
}
