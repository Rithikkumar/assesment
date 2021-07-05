package com.asde.dbconnect.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.asde.file.FileReadingServiceImpl;

public class SlotServiceTest {

	@Test
	public void testGetAllAvailableSlots() {
		ISlotService slotService = new SlotService(new FileReadingServiceImpl(), "src/resources/vaccinecentredata.csv");
		assertTrue(slotService.getAllAvailableSlots().size() == 5);
	}

	@Test
	public void testGetVaccineSlotsForLocationAndVaccine() {
		ISlotService slotService = new SlotService(new FileReadingServiceImpl(), "src/resources/vaccinecentredata.csv");
		assertTrue(slotService.getVaccineSlotsForLocationAndVaccine("gurgaon", "covaxin") == 50);
	}

	@Test
	public void testGetVaccineSlotsForLocation() {
		ISlotService slotService = new SlotService(new FileReadingServiceImpl(), "src/resources/vaccinecentredata.csv");
		assertTrue(slotService.getVaccineSlotsForLocation("gurgaon").size() == 1);
	}

}
