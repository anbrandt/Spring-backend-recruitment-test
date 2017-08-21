package com.spring.javabackendTest.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by andrzej on 21.08.17.
 */

//hoover request is a mapping class from json - starting point. Endpoint is HooverResponse

public class HooverRequest {

	private List<Integer> roomSize;
	private List<Integer> coords;
	private List<List<Integer>> patches;
	private String instructions;

	public HooverRequest() {
	}

	public HooverRequest(List<Integer> roomSize, List<Integer> coords, List<List<Integer>> patches, String instructions) {
		this.roomSize = roomSize;
		this.coords = coords;
		this.patches = patches;
		this.instructions = instructions;
	}


	public List<Integer> getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(List<Integer> roomSize) {
		this.roomSize = roomSize;
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

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
