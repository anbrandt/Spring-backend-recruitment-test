package com.spring.javabackendTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.javabackendTest.controller.BackendTestController;
import com.spring.javabackendTest.model.HooverRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by andrzej on 21.08.17.
 */

@Service
public class BackendTestService {

	private HooverRequest hooverRequest;

	private MovingController movingController = new MovingController();



	public BackendTestService() {


	}

	public String start() {
		return "hoover app has started";
	}


	public void move(HooverRequest hooverRequest) {

		List<Integer> coords = hooverRequest.getCoords();
		String instructions = hooverRequest.getInstructions();

		String[] split = instructions.split("");
		movingController.getInputList(coords);
		iterateThroughSplitedString(split);

	}


	private void setNewCoords(List<Integer> list) {


	}


}
