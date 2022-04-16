package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bezkoder.spring.login.models.Icecream;

public interface IceCreamRepo extends JpaRepository<Icecream, Integer> {

}
