package com.spring.javabackendTest.service;

import com.spring.javabackendTest.model.HooverRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */
public class MovingController {

	private int x;
	private int y;

	private final String NORTH = "N";
	private final String SOUTH = "S";
	private final String EAST = "E";
	private final String WEST = "W";


	public List<Integer> moveWest(List<Integer> coords) {
		x = coords.get(0) - 1;
		y = coords.get(1);

		coords.set(0, x);
		coords.set(1, y);
		return coords;


	}

	public List<Integer> moveEast(List<Integer> coords) {
		x = coords.get(0) + 1;
		y = coords.get(1);

		coords.set(0, x);
		coords.set(1, y);
		return coords;


	}

	public List<Integer> moveSouth(List<Integer> coords) {
		x = coords.get(0);
		y = coords.get(1) - 1;

		coords.set(0, x);
		coords.set(1, y);
		return coords;
	}

	public List<Integer> moveNorth(List<Integer> coords) {
		;
		x = coords.get(0);
		y = coords.get(1) + 1;

		coords.set(0, x);
		coords.set(1, y);
		return coords;

	}

	public List<Integer> getInputList(List<Integer> coords) {

		

	}


	public List<Integer> iterateThroughSplitedString(String[] splitedString) {

		getInputList();

		String instructions = hooverRequest.getInstructions();


		for (String s : splitedString) {
			if (s.contains(NORTH)) {
				List<Integer> integers = movingController.moveNorth(coords);
				coords.set(0, integers.get(0));
				coords.set(1, integers.get(1));

			} else if (s.contains(SOUTH)) {
				List<Integer> integersReturn = movingController.moveSouth(coords);
				coords.set(0, integersReturn.get(0));
				coords.set(1, integersReturn.get(1));

			} else if (s.contains(EAST)) {
				List<Integer> integers = movingController.moveEast(coords);
				coords.set(0, integers.get(0));
				coords.set(1, integers.get(1));

			} else if (s.contains(WEST)) {
				List<Integer> integers = movingController.moveWest(coords);
				coords.set(0, integers.get(0));
				coords.set(1, integers.get(1));

			} else {
				System.out.print("Error. You have to use only cardinal points");
			}
		}


	}
}
