package week10HW;

public class Vehicle {
	
	private int id;
	private String make;
	private String model;
	private int year;
	
	
	public Vehicle(int id, String make , String model , int year) {
		this.setId(id);
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
				
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

}
