package com.bezkoder.spring.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.spring.login.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
