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
    

	@Test
	public void testProspect(){

	}
	
	
	
}
