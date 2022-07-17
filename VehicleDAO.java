package week10HW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

	private Connection connection; 
	private final String DISPLAY_VEHICLES_QUERY = "SELECT * FROM vehicle";
	private final String DISPLAY_VEHICLE_BY_ID_QUERY = "SELECT * FROM vehicle WHERE id = ?";
	private final String CREATE_NEW_VEHICLE_QUERY = " INSERT INTO vehicle(make, model, year) VALUES(?,?,?)";
	private final String DELETE_VEHICLE_BY_ID = "DELETE FROM vehicle WHERE id= ?";
	
	public VehicleDAO() {
		connection = DBC.GetConnection();
	}
	
	public List<Vehicle> displayVehicles() throws SQLException{
		ResultSet rs  = connection.prepareStatement(DISPLAY_VEHICLES_QUERY).executeQuery();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while(rs.next()) {
			vehicles.add(populateVehicle(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4)));
		}
		
		return vehicles;
	}
	
	public Vehicle getVehicleByID(int id ) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DISPLAY_VEHICLE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateVehicle(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getInt(4));
	}
	
	public void createNewVehicle(String make , String model , int year ) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_VEHICLE_QUERY);
		ps.setString(1, make);
		ps.setString(2, model);
		ps.setInt(3, year);
		ps.executeUpdate();
	}
	
	public void deleteVehicleByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Vehicle populateVehicle(int id , String make , String model , int year ) {
		return new Vehicle(id , make , model, year);
	}
	
}
