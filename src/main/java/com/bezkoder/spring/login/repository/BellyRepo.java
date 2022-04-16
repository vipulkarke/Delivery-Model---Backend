package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bezkoder.spring.login.models.BellyDarbar;

public interface BellyRepo extends JpaRepository<BellyDarbar, Integer>{

}
