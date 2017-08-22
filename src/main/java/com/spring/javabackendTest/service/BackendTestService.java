package com.spring.javabackendTest.service;

import com.spring.javabackendTest.model.HooverMovingService;
import com.spring.javabackendTest.model.HooverRequest;
import com.spring.javabackendTest.model.HooverResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */

@Service
public class BackendTestService {

	private HooverMovingService hooverMoving = new HooverMovingService();


	public BackendTestService() {

	}

	public String start() {
		return "hoover app has started";
	}


	public HooverResponse move(HooverRequest hooverRequest) {

		List<Integer> coords = hooverRequest.getCoords();

		String instructions = hooverRequest.getInstructions();
		List<List<Integer>> patches = hooverRequest.getPatches();

		String[] split = instructions.split("");
		HooverResponse hooverResponse = hooverMoving.iterateThroughSplitedStringAndMove(split, coords, patches);

		return hooverResponse;
	}


}
