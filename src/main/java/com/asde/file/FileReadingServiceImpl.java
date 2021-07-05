package com.asde.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

//import com.asde.dbconnect.entities.Vaccine;
import com.asde.dbconnect.entities.VaccineSlot;

//import org.apache.avro.file.FileReader;

//import au.com.bytecode.opencsv.CSVReader;
import structures.ArrayList;

public class FileReadingServiceImpl implements IFileReadingService {

     @Override
     public Integer getTotalSlotsForLocation(String location, String vaccineType) {
         
    //     try (CSVReader reader = new CSVReader((Reader) new FileReader(location))) {
    //         List<String[]> r = reader.readAll();
    //         int t=0;

    //             String[] first = Arrays.copyOf(r[1], 4);
    //             t=Integer.parseInt(first[3]);
    //             if(vaccineType==first[0]&&location==first[1]){
    //                 return t;
    //             }

    //             String[] second = Arrays.copyOf(r[2],4);
    //             t=Integer.parseInt(second[3]);
    //             if(vaccineType==second[0]&&location==second[1]){
    //                 return t;
    //             }

    //             String[] third = Arrays.copyOf(r[3],4);
    //             t=Integer.parseInt(third[3]);
    //             if(vaccineType==third[3]&&location==third[1]){
    //                 return t;


    //         }
    //         return null;
    //     }
        return null;
	
	}

	@Override
	public List<VaccineSlot> readVaccinCentreData(String filename) {
        List<VaccineSlot> vaccineSlot = new ArrayList<>();

          
        try{
            BufferedReader buffer = new BufferedReader((Reader) new FileReader(filename));
            List<List<String>> data = new ArrayList<>();
            String delimeter = ",";
            String line;
            while((line=buffer.readLine())!=null){
                String[] values = line.split(delimeter);
                data.add(Arrays.asList(values));
            }
            for(int i=1;i<data.size();i++){
                VaccineSlot vs = new VaccineSlot();
                vs.setVaccine(data.get(i).get(0));
                vs.setLocation_name(data.get(i).get(1));
                boolean check = Boolean.parseBoolean(data.get(i).get(2));
                vs.setIs_available(check);
                int s=Integer.parseInt(data.get(i).get(3));
                vs.setStock(s);
                vaccineSlot.add(vs);
            }

        }
        catch(IOException e){
            System.out.println("error");
        }
        return vaccineSlot;

	}

    
    

}
