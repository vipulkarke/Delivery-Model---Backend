package com.bezkoder.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.OvenStory;
import com.bezkoder.spring.login.repository.OvenRepo;
@Service
public class OverServiceImpl implements OvenService {

	@Autowired
	private OvenRepo ovenRepo;

	@Override
	public List<OvenStory> getAllOven() {
		return (List<OvenStory>) ovenRepo.findAll();
	}

}
