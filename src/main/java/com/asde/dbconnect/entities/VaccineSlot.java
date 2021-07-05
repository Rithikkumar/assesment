package com.asde.dbconnect.entities;

public class VaccineSlot {
	
	//private int slot_id; 
	private String location_name;
	private String vaccine;
    private boolean is_available;
    private int stock;

	// public int getSlot_id() {
	// 	return slot_id;
	// }
	// public void setSlot_id(int slot_id) {
	// 	this.slot_id = slot_id;
    // }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public boolean isIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	} 
}
