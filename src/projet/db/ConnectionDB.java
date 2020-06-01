package projet.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	public static Connection loadDatabase() {
		System.out.println("peace");
		Connection cn = null;
		try {
			System.out.println("hello");
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projets3?useTimezone=true&serverTimezone=UTC","root","");
			System.out.println("connected");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
		
	}
	
	

}
