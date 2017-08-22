package com.spring.javabackendTest.model;

import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */
public class HooverResponse {


	private List<Integer> coords;
	private int patches;

	public HooverResponse() {
	}

	public HooverResponse(List<Integer> coords, int numberOfCleanedPatches) {
		this.coords = coords;

		this.patches = numberOfCleanedPatches;
	}

	public int getPatches() {
		return patches;
	}

	public void setPatches(int patches) {
		this.patches = patches;
	}

	public List<Integer> getCoords() {
		return coords;
	}

	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

}
