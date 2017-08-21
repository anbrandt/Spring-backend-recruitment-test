package com.spring.javabackendTest.controller;

import com.spring.javabackendTest.model.HooverRequest;
import com.spring.javabackendTest.service.BackendTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */

@RestController
public class BackendTestController {

	private BackendTestService backendTestService;

	@Autowired
	public BackendTestController(BackendTestService backendTestService){
		this.backendTestService = backendTestService;
	}

	@RequestMapping("/hoover")
	public String start() {

		return backendTestService.start();
	}

	@RequestMapping(value = "/hoover/start", method = RequestMethod.POST)
	public ResponseEntity<HooverRequest> getFromJson(@RequestBody HooverRequest hooverStart) {
			//request body is mapping json (using jackson) to object
			//TODO move

		ResponseEntity<HooverRequest> hooverRequestResponseEntity = new ResponseEntity<>(hooverStart, HttpStatus.OK);

		//here we will be returning the final hooverrepsonse object
		return hooverRequestResponseEntity;
	}

	@RequestMapping(value = "hoover/launch", method = RequestMethod.POST)
	public List<Integer> launchApp(@RequestBody HooverRequest hooverRequest) {

		backendTestService.move(hooverRequest);

		return hooverRequest.getCoords();
	}







}
