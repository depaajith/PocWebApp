package com.animus.poc.restapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.animus.poc.model.Prospect;
import com.animus.poc.repositories.ProspectRepository;
import com.wordnik.swagger.annotations.ApiOperation;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("/prospect")
public class ProspectREST {
   
	private static final Logger logger = LogManager.getLogger(ProspectREST.class);
	
	@Autowired
	private ProspectRepository prospectRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Prospect> list() {
		logger.info("Getting all the prospects");
		logger.error("test");
		return prospectRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Prospect create(@RequestBody @Valid Prospect prospect){
		logger.info("----------------------------------------------");
		logger.info("prospect.getFirstname()=" + prospect.getFirstname());
		logger.info("prospect.getLastname()=" + prospect.getLastname());
		logger.info("----------------------------------------------");
		return this.prospectRepository.save(prospect);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Prospect get(@PathVariable("id") long id ){
		logger.info("Getting the prospects with id " + id);
		return this.prospectRepository.findOne(id);
		
	}
	
    @ApiOperation(value = "Update a Prospect")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Prospect update(@PathVariable("id") long id, @RequestBody @Valid Prospect Prospect) {
    	logger.info("Updating the prospect with " + id);
      return this.prospectRepository.save(Prospect);
    }

   

    @ApiOperation(value = "Delete a prospect")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
      this.prospectRepository.delete(id);
      logger.info("Deleting the  prospect with id" + id);
      return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
	
}
