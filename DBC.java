package week10HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBC {

	private final static String URL = "jdbc:mysql://localhost:3306/vehicle";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Waterfall1!";
	private static Connection connection;
	private static DBC instance;
	
	
	
	private DBC(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection GetConnection() {
		if(instance == null){
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBC(connection);
				System.out.println("Connection was successful");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return DBC.connection;
	}
}
