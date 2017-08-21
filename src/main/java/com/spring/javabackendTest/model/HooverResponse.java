package com.spring.javabackendTest.model;

import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */
public class HooverResponse {


	private List<Integer> coords;
	private List<List<Integer>> patches;

	public HooverResponse() {
	}

	public HooverResponse(List<Integer> coords, List<List<Integer>> patches) {
		this.coords = coords;
		this.patches = patches;
	}

	public List<Integer> getCoords() {
		return coords;
	}

	public void setCoords(List<Integer> coords) {
		this.coords = coords;
	}

	public List<List<Integer>> getPatches() {
		return patches;
	}

	public void setPatches(List<List<Integer>> patches) {
		this.patches = patches;
	}
}
