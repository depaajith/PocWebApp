package com.animus.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animus.prospect")
public class Prospect {

	 @Id
	 @Column(name = "prospectid")
	 private long prospectid;
	 
	 @Column(name = "firstname")
	 private String firstname;
	 
	 @Column(name = "lastname")
	 private String lastname;

	public long getProspectid() {
		return prospectid;
	}

	public void setProspectid(long prospectid) {
		this.prospectid = prospectid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
