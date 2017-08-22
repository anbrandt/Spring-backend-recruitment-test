package com.spring.javabackendTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.javabackendTest.model.HooverRequest;
import com.spring.javabackendTest.model.HooverResponse;
import com.spring.javabackendTest.service.BackendTestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by andrzej on 22.08.17.
 */
public class BackendTestControllerTest {

	private BackendTestController backendTestController;
	private ObjectMapper objectMapper;

	@Mock
	private BackendTestService backendTestService;


	@Before
	public void setUp() {
		initMocks(this);
		backendTestController = new BackendTestController(backendTestService);
		objectMapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnResponse() throws IOException {

		HooverRequest hooverRequest = getDefaultHooverRequest();
		HooverResponse hooverResponse = getDefaultHooverResponse();

		when(backendTestService.move(hooverRequest)).thenReturn(hooverResponse);
	}


	private HooverResponse getDefaultHooverResponse() throws IOException {
		String requestAsJson = readAsString("src/main/resources/output.json");

		return objectMapper.readValue(requestAsJson, HooverResponse.class);


	}

	private HooverRequest getDefaultHooverRequest() throws IOException {

		String requestAsJson = readAsString("src/main/resources/input.json");

		HooverRequest hooverRequest = objectMapper.readValue(requestAsJson, HooverRequest.class);
		return hooverRequest;

	}

	private String readAsString(String path) throws FileNotFoundException {
		return new Scanner(new File(path)).useDelimiter("\\Z").next();

	}


}