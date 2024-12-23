package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PlanEntity;
import com.example.demo.service.PlanService;

@RestController
@RefreshScope
public class PlanRestController {
	
	@Value("${msg}")
	String message;
	
	@Autowired
	PlanService planService;
	
	@GetMapping( value = "/msg")
	public String getMessage() {
		return message;
	}
	@GetMapping( value = "/plans" )
	public ResponseEntity<List<PlanEntity>> getAllPlans() {
		return new ResponseEntity<>(planService.fetchAll(), HttpStatus.OK);
	}
	
	@GetMapping( value = "/plans/{id}")
	public ResponseEntity<PlanEntity>  getPlanById(@PathVariable( value = "id") String planId) {
		PlanEntity entity = planService.fetchById(planId);
		if ( entity == null ) {
			return new ResponseEntity<>(entity, HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
		
	}

}
