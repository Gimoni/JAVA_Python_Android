package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpSelectPractice {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("oracle.jdbc.OracleDriver");
		// sqlplus scott/tiger 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement stmt =  conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from country");
		
		rs.next();

		
		while(rs.next()) {
			String code 	= rs.getString("code");
			String name 	= rs.getString("name"); 
			String continent 	= rs.getString("continent"); 
			String region		= rs.getString("region");
			int surface_area		= rs.getInt("surface_area");
			Integer indep_year		= rs.getObject("indep_year", Integer.class);
			Integer population		= rs.getObject("population", Integer.class);
			double life_expectancy		= rs.getDouble("life_expectancy");
			String gnp 		= rs.getString("gnp");
			Integer gnp_old		= rs.getObject("gnp_old", Integer.class);
			String local_name 		= rs.getString("local_name");
			String government_form		= rs.getString("government_form");
			String head_of_state 		= rs.getString("head_of_state");
			int capital		= rs.getInt("capital");
			String code2 		= rs.getString("code2");

			
			System.out.printf("%3s %45s %15s %26s %10d %6s %10s %3.1f %8s %8s %30s %30s %28s %4d %3s\n",
								code,
								name,
								continent,
								region,
								surface_area,
								indep_year,
								population,
								life_expectancy,
								gnp,
								gnp_old,
								local_name,
								government_form,
								head_of_state,
								capital,
								code2);
					
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		
		System.out.println("Program End...");
	
	}

}
