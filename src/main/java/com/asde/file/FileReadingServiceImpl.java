package com.asde.file;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import com.asde.dbconnect.entities.VaccineSlot;

import org.apache.avro.file.FileReader;

import au.com.bytecode.opencsv.CSVReader;
import structures.ArrayList;

public class FileReadingServiceImpl implements IFileReadingService {

    @Override
    public Integer getTotalSlotsForLocation(String location, String vaccineType) {
        try (CSVReader reader = new CSVReader((Reader) new FileReader(location))) {
            List<String[]> r = reader.readAll();
            int t=0;

                String[] first = Arrays.copyOf(r[1], 4);
                t=Integer.parseInt(first[3]);
                if(vaccineType==first[0]&&location==first[1]){
                    return t;
                }

                String[] second = Arrays.copyOf(r[2],4);
                t=Integer.parseInt(second[3]);
                if(vaccineType==second[0]&&location==second[1]){
                    return t;
                }

                String[] third = Arrays.copyOf(r[3],4);
                t=Integer.parseInt(third[3]);
                if(vaccineType==third[3]&&location==third[1]){
                    return t;


            }
            return null;
        }
	
	}

	@Override
	public List<VaccineSlot> readVaccinCentreData(String filename) {
        List<VaccineSlot> vaccineSlot = new ArrayList<>();

        try(CSVReader reader = new CSVReader((Reader) new FileReader(filename))) {
         List<String[]> r = reader.readAll();
            int t=0;
            boolean b = true;
            
                String[] s=r[1];
                String[] first = Arrays.copyOf(r[1],4);
                VaccineSlot vs1 = new VaccineSlot();
                t=Integer.parseInt(first[3]);
                vs1.setStock(t);
                vs1.setLocation_name(first[1]);
                vs1.setVaccine(first[0]);
                b=Boolean.parseBoolean(first[2]);
                vs1.setIs_available(b);
                vaccineSlot.add(vs1);

                String[] second = Arrays.copyOf(r[2],4);
                VaccineSlot vs2 = new VaccineSlot();
                t=Integer.parseInt(second[3]);
                vs2.setStock(t);
                vs2.setLocation_name(second[1]);
                vs2.setVaccine(second[0]);
                b=Boolean.parseBoolean(second[2]);
                vs2.setIs_available(b);
                vaccineSlot.add(vs2);

                String[] third = Arrays.copyOf(r[3],4);
                VaccineSlot vs3 = new VaccineSlot();
                t=Integer.parseInt(third[3]);
                vs3.setStock(t);
                vs3.setLocation_name(third[1]);
                vs3.setVaccine(third[0]);
                b=Boolean.parseBoolean(third[2]);
                vs3.setIs_available(b);
                vaccineSlot.add(vs3);
                

                return vaccineSlot;
        }  

	}

   

}
