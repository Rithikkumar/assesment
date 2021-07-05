package com.asde.dbconnect.service;

import java.util.List;

import com.asde.dbconnect.entities.Vaccine;
import com.asde.file.IFileReadingService;

public class VaccineService implements IVaccineService {

	private IFileReadingService frs;
    private String fileName;

	public VaccineService(IFileReadingService frs, String fileName) {
		this.frs = frs;
        this.fileName = fileName;
	}

	public List<Vaccine> listAllVaccines() {
		return null;
	}

	@Override
	public Vaccine getVaccineDetails(String vaccine_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
