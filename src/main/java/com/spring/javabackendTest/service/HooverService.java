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
public class HooverService {

	private HooverMovingService hooverMoving = new HooverMovingService();


	public HooverService() {

	}

	public String start() {
		return "hoover app has started";
	}


	public HooverResponse move(HooverRequest hooverRequest) {

		List<Integer> coords = hooverRequest.getCoords();

		String instructions = hooverRequest.getInstructions();
		List<List<Integer>> patches = hooverRequest.getPatches();

		String withoutWhiteSpaces = prepareCorrectString(instructions);

		String[] split = withoutWhiteSpaces.split("");
		HooverResponse hooverResponse = hooverMoving.iterateThroughSplitedStringAndMove(split, coords, patches);

		return hooverResponse;
	}

	public String prepareCorrectString(String instructions) {
		String withoutWhiteSpaces = instructions.replaceAll("\\s", "").toUpperCase();
		String s = withoutWhiteSpaces.replaceAll("[*0-9]", "");

		return s;
	}


}
