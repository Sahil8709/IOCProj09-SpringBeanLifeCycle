package com.nt.sbeans;

import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class VoterDetails {
	
	@Value("${voter.ano}")
	private long id;
	
	@Value("${voter.name}")
	private String name;
	
	@Value("${voter.age}")
	private float age;
	
	private Date dov;
	
	public VoterDetails() {
		System.out.println("Voterdetails::0-arg constructor");
	}
	
	
	//custom init method /init life cycle method
	@PostConstruct
	public void myInit() {
		System.out.println("VoterDetails.myInit()");
		
		//initialize left over properties
		
		dov=new Date();
		
		//check whether correct values are injected to spring bean properties or not
		
		if(name==null || age<18 || age>120 || id<=0L)
			throw new IllegalArgumentException("Invalid inputs");
		
	}
	
	//b.method
	public String checkVotingEligibility() {
		System.out.println("VoterDetails.destroy())");
		if(age<18)
			return "Mr/Miss/Mrs." + name+" you are not eligible for voting --> verified on::"+dov;
		else
			return "Mr/Miss/Mrs." + name+" you are eligible for voting --> verified on::"+dov;
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("VoterDetails.destroy");
		//nullifying the spring bean properties
		dov=null;
		id=0L;
		age=0;
	}

}
