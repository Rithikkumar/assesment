package com.asde.dbconnect.service;

import java.util.ArrayList;
import java.util.List;

import com.asde.dbconnect.entities.VaccineSlot;
import com.asde.file.FileReadingServiceImpl;
import com.asde.file.IFileReadingService;

public class SlotService implements ISlotService {

    private IFileReadingService frs;
    private String fileName;

    public SlotService(IFileReadingService frs, String fileName) {
        this.frs = frs;
        this.fileName = fileName;
    }

    /**
     * Get all available slots that are present in the file as a list of objects 
     * containing the location for each slot as well
     */
    public List<VaccineSlot> getSlotsPresentInFile(String filename){
        // FileReadingServiceImpl read = new FileReadingServiceImpl();
        // int slotsForFirst = read.getTotalSlotsForLocation("gurugram", "covaxin");
        List<VaccineSlot> slot = new ArrayList<>();
        FileReadingServiceImpl read = new FileReadingServiceImpl();
        slot = read.readVaccinCentreData(filename);

        return slot;


    }
    @Override
    public List<VaccineSlot> getAllAvailableSlots() {
        List<VaccineSlot> slots = new ArrayList<VaccineSlot>();
        slots.add(null);
        return slots;
    }

    /**
     * Get the no of slots from the database for a specific vaccine and location
     * 
     * For example: gurgaon and covaxin
     */

    @Override
    public Integer getVaccineSlotsForLocationAndVaccine(String location, String vaccine_name) {
        // TODO Auto-generated method stub
        FileReadingServiceImpl read = new FileReadingServiceImpl();
        int ans=read.getTotalSlotsForLocation(location, vaccine_name);
        return ans;
    }

    /**
     * Get the list of all slots that are available for a particular location
     * 
     * For example: gurgaon
     */
    @Override
    public List<VaccineSlot> getVaccineSlotsForLocation(String location) {
    	List<VaccineSlot> slots = new ArrayList<VaccineSlot>();
        FileReadingServiceImpl read = new FileReadingServiceImpl();
        slots = read.readVaccinCentreData(location);

        return slots;
    }
    
}
