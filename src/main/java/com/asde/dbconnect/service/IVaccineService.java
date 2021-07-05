package com.asde.dbconnect.service;

import java.util.List;

import com.asde.dbconnect.entities.Vaccine;

public interface IVaccineService {

    public List<Vaccine> listAllVaccines();

    public Vaccine getVaccineDetails(String vaccine_name);
    
}
