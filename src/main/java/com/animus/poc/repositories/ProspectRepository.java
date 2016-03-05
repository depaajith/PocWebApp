package com.animus.poc.repositories;

import java.util.List;

import javax.validation.Valid;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import com.animus.poc.model.Prospect;

public interface ProspectRepository extends JpaRepository<Prospect,Long>{

	public List<Prospect> findAll();
	

	
}
