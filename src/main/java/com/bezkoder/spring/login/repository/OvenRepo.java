package com.bezkoder.spring.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.spring.login.models.OvenStory;

public interface OvenRepo extends CrudRepository<OvenStory, Integer>{

}
