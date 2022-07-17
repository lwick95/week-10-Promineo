package week10HW;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private VehicleDAO vehicleDAO = new VehicleDAO();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Vehicles" ,
			"Display a Vehicle" , 
			"Create a Vehicle" ,
			"Delete a Vehicle");

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				
			
			if (selection.equals("1")) {
				displayVehicles();
			}else if (selection.equals("2")){
				displayVehicle();
			}else if (selection.equals("3")){
				createVehicle();
			}else if (selection.equals("4")) {
				deleteVehicle();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("<-|| Press enter to continue ||-> ");
			scanner.nextLine();
			
		}while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option \n---------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayVehicles() throws SQLException {
		List<Vehicle> vehicles = vehicleDAO.displayVehicles();
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getId() + ": " + vehicle.getMake() + ": " 
		+ vehicle.getModel() + ": " + vehicle.getYear());
		}
	}
	
	private void displayVehicle() throws SQLException {
		System.out.println("enter vehicle ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Vehicle vehicle = vehicleDAO.getVehicleByID(id);
		System.out.println(vehicle.getId() + ": " + vehicle.getMake() + ": " 
				+ vehicle.getModel() + ": " + vehicle.getYear());
	}
	
	private void createVehicle() throws SQLException {
		System.out.println("Enter the Vehicles Make: ");
		String vehicleMake = scanner.nextLine();
		System.out.println("Enter the vehicles Model: ");
		String vehicleModel = scanner.nextLine();
		System.out.println("Enter the vehicles Year: ");
		int year = Integer.parseInt(scanner.nextLine());
		
		vehicleDAO.createNewVehicle(vehicleMake, vehicleModel, year);
	}
	
	private void deleteVehicle() throws SQLException {
		System.out.println("Enter the vehicle ID that you would like to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		vehicleDAO.deleteVehicleByID(id);
	}
}
