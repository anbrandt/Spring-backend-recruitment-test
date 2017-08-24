package com.spring.javabackendTest.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.javabackendTest.service.HooverService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;


/**
 * Created by andrzej on 22.08.17.
 */
public class HooverMovingServiceTest {


	private ObjectMapper objectMapper;
	private HooverService backendTestService;
	private HooverMovingService hooverMovingService;

	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		backendTestService = new HooverService();
		hooverMovingService = new HooverMovingService();

	}

	@Test
	public void shouldNotAllowWhiteSpacesInStringInstructions() throws IOException {

		HooverRequest defaultHooverRequest = getDefaultHooverRequest();

		String instructions = defaultHooverRequest.getInstructions();

		String s = backendTestService.prepareCorrectString(instructions);

		assertFalse(s.contains(" "));
	}

	@Test
	public void shouldChangeLowerCaseToUpperCase() throws IOException {
		HooverRequest hooverRequest = getDefaultHooverRequest();

		String instructions = hooverRequest.getInstructions();

		String s = backendTestService.prepareCorrectString(instructions);
		String actual = "NSESWNWW";
		assertEquals(actual, s);

	}

	@Test
	public void stringShouldNotContainIntegers() throws IOException {

		HooverRequest hooverRequest = getDefaultHooverRequest();
		String correctInstructions = "NSESWNWW";
		String instructions = hooverRequest.getInstructions();

		String s = backendTestService.prepareCorrectString(instructions);
		assertEquals(correctInstructions, s);
	}

	@Test(expected = InputMismatchException.class)
	public void stringShouldContainOnlyGeoDirections() throws IOException {
		HooverRequest hooverRequest = getDefaultHooverRequest();
		String instructions = hooverRequest.getInstructions();


	}

	//TODO String instructions input test - can't have other chars then NSEW and no other primitive data types (ints)
	//string can't be null
	/*
	TODO tests:
	COORDS
	- can't be null or empty
	- inputs have to be integers, not chars or strings
	- input list cant start out of the board [5,5] -> roomSize is determined in json file
	- input list can't have more then two elements [1,2]
	- input list can't have sub zero values
	PATCHES:
	- input can't be null or empty
	- input list of lists can't have more patches then number of the fields on the board
	- patches can't lay outside of the board
	- no more and no less then two integers inside the lists

	ALL:
	- JSON is not allowed to pass if doesn't have all the required fields (use speciific error for message)


	- może testy sparametryzowane?

*/

	@Test
	public void shouldReturnErrorWhenUseNonGeographicalDirections() throws IOException {

		HooverRequest defaultHooverRequest = getDefaultHooverRequest();

	}


	private HooverResponse getDefaultHooverResponse() throws IOException {
		String requestAsJson = readAsString("src/main/resources/output.json");

		return objectMapper.readValue(requestAsJson, HooverResponse.class);


	}

	private HooverRequest getDefaultHooverRequest() throws IOException {

		String requestAsJson = readAsString("src/main/resources/inputStringNotGeo.json");

		HooverRequest hooverRequest = objectMapper.readValue(requestAsJson, HooverRequest.class);
		return hooverRequest;

	}



	private String readAsString(String path) throws FileNotFoundException {
		return new Scanner(new File(path)).useDelimiter("\\Z").next();

	}

}