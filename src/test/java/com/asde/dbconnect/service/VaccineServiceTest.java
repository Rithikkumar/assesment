package com.asde.dbconnect.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asde.file.FileReadingServiceImpl;

public class VaccineServiceTest {

	@Test
	public void testListAllVaccines() {
		IVaccineService vaccineService = null;
		try {
			vaccineService = new VaccineService(new FileReadingServiceImpl(), "src/resources/vaccingdata.csv");
		} catch (Exception e) {
			System.out.println("Error while getting DB connection");
		}
		assertTrue(vaccineService.listAllVaccines().size() == 4);
	}

	@Test
	public void testGetVaccineDetails() {
		IVaccineService vaccineService = null;
		try {
			vaccineService = new VaccineService(new FileReadingServiceImpl(), "src/resources/vaccingdata.csv");
		} catch (Exception e) {
			System.out.println("Error while getting DB connection");
		}
		assertTrue("covaxin".equals(vaccineService.getVaccineDetails("covaxin").getVaccine_name()));
	}

}
