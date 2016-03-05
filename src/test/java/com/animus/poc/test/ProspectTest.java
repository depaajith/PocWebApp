package com.animus.poc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.animus.poc.model.Prospect;
import com.animus.poc.repositories.ProspectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
public class ProspectTest {
    
	@Autowired
	private ProspectRepository prospectRepository;
	
	@Test
	public void testProspect(){
		Prospect prospect = prospectRepository.findOne(2l);
		System.out.println("------------------------------>" + prospect.getFirstname() + " " + prospect.getLastname());
		
	}
	
	
	
}
