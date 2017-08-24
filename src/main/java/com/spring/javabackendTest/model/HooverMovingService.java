package com.spring.javabackendTest.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */
public class HooverMovingService {

	private int x;
	private int y;

	private final String NORTH = "N";
	private final String SOUTH = "S";
	private final String EAST = "E";
	private final String WEST = "W";

	private List<Integer> list = new ArrayList<>();


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


	//TODO nazewnictwo zmiennych
	//stworzyć klasę która przekazuje trzy zmienne - Hoover Input
	//TODO set z patches zamiast iterowania po listach

	//TODO dodać test integracyjny


	public HooverResponse iterateThroughSplitedStringAndMove(String[] splitedString, List<Integer> list, List<List<Integer>> patches) {

		List<Integer> integerList = list;
		List<List<Integer>> listOfPatches = patches;
		int numberOfFoundPatches = 0;


		for (String s : splitedString) {
			if (s.equalsIgnoreCase(NORTH)) {
				List<Integer> integers = moveNorth(integerList);

				if (checkForPatches(listOfPatches, integerList)) {
					numberOfFoundPatches++;

				}
				integerList.set(0, integers.get(0));
				integerList.set(1, integers.get(1));

			} else if (s.equalsIgnoreCase(SOUTH)) {
				List<Integer> integersReturn = moveSouth(integerList);
				if (checkForPatches(listOfPatches, integerList) == true) {
					numberOfFoundPatches++;

				}
				integerList.set(0, integersReturn.get(0));
				integerList.set(1, integersReturn.get(1));

			} else if (s.equalsIgnoreCase(EAST)) {
				List<Integer> integers = moveEast(integerList);
				if (checkForPatches(listOfPatches, integerList) == true) {
					numberOfFoundPatches++;

				}
				integerList.set(0, integers.get(0));
				integerList.set(1, integers.get(1));

			} else if (s.equalsIgnoreCase(WEST)) {
				List<Integer> integers = moveWest(integerList);
				if (checkForPatches(listOfPatches, integerList) == true) {
					numberOfFoundPatches++;
				}
				integerList.set(0, integers.get(0));
				integerList.set(1, integers.get(1));

			} else {
				System.out.print("Error. You have to use only cardinal points");
			}
		}
		HooverResponse hooverResponse = new HooverResponse(integerList, numberOfFoundPatches);
		return hooverResponse;
	}

	private boolean checkForPatches(List<List<Integer>> listOfPatches, List<Integer> integerList) {

		boolean patchesOnTheRoad = true;
		Iterator<List<Integer>> iterator = listOfPatches.iterator();

		while (iterator.hasNext()) {
			List<Integer> next = iterator.next();
			if (next.equals(integerList)) {
				iterator.remove();
				patchesOnTheRoad = true;
			} else
				patchesOnTheRoad = false;
		}
		return patchesOnTheRoad;
	}


}
