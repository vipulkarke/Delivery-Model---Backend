package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.models.OvenStory;

public interface OvenRepo extends JpaRepository<OvenStory, Integer>{

}
