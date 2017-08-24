package com.spring.javabackendTest.controller;

import com.spring.javabackendTest.model.HooverRequest;
import com.spring.javabackendTest.model.HooverResponse;
import com.spring.javabackendTest.service.HooverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrzej on 21.08.17.
 */

@RestController
public class HooverController {

	//TODO dodać interfesj w kontrolerze HooverMover o metodzie launchApp
	//TODO https://www.dashingd3js.com/svg-basic-shapes-and-d3js interfejs GUI


	private HooverService backendTestService;

	@Autowired
	public HooverController(HooverService backendTestService){
		this.backendTestService = backendTestService;
	}

	@RequestMapping("/")
	public String start() {

		return backendTestService.start();
	}


	//nadmiarowe metody TODO
	@RequestMapping(value = "/hoover/start", method = RequestMethod.POST)
	public ResponseEntity<HooverRequest> getFromJson(@RequestBody HooverRequest hooverStart) {
			//request body is mapping json (using jackson) to object

		ResponseEntity<HooverRequest> hooverRequestResponseEntity = new ResponseEntity<>(hooverStart, HttpStatus.OK);

		//here we will be returning the final hooverrepsonse object
		return hooverRequestResponseEntity;
	}

	@RequestMapping(value = "hoover/launch", method = RequestMethod.POST)
	public HooverResponse launchApp(@RequestBody HooverRequest hooverRequest) {

		HooverResponse move = backendTestService.move(hooverRequest);

		return move;
	}







}
