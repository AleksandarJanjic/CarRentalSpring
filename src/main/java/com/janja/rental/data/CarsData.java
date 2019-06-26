package com.janja.rental.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.janja.rental.beans.Car;
import com.janja.rental.controller.SearchParamsBean;

@Component
public class CarsData {
	
	@Autowired
	Car car;
	
	public ArrayList<Car> getAllCars(String SQL, SearchParamsBean searchParam) {
		boolean whereSet = false;
		boolean nameParam = false;
		boolean cityParam = false;
		boolean carClassParam = false;
		Integer id = 1;
		ResultSet rs = null;
		String query = null;
		ArrayList<Car> result = new ArrayList<Car>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/carrentalproject?useSSL=false", "root", "janja988");) {
			StringBuilder sb = new StringBuilder();
			sb.append(SQL);
			if(searchParam.getName().isBlank() &&
			   searchParam.getCity().isBlank() &&
			   searchParam.getCarClass().isBlank())
			   {
				query = sb.toString();
			}
			if(!(searchParam.getName().isBlank())) {
				sb.append(" WHERE (vm.model LIKE ? OR vmn.name LIKE ?) ");
				nameParam = true;
				whereSet = true;
			}
			if(!(searchParam.getCity().isBlank()) && whereSet == false) {
				sb.append(" WHERE c.name LIKE ? ");
				whereSet = true;
				cityParam = true;
			} else if(!(searchParam.getCity().isBlank()) && whereSet == true) {
				sb.append(" AND c.name LIKE ? ");
				cityParam = true;
			}
			if(!(searchParam.getCarClass().isBlank()) && whereSet == false) {
				sb.append(" WHERE vc.name = ? ");
				whereSet = true;
				carClassParam = true;
			} else if(!(searchParam.getCarClass().isBlank()) && whereSet == true) {
				sb.append(" AND vc.name = ? ");
				carClassParam = true;
			}
			query = sb.toString();
			PreparedStatement stmt = conn.prepareStatement(query);
			if(nameParam == true) {
				stmt.setString(1, "%" + searchParam.getName() + "%");
				stmt.setString(2, "%" + searchParam.getName() + "%");
			} else {}
			if((cityParam == true) && (nameParam == false)) {
				stmt.setString(1, "%" + searchParam.getCity() + "%");
			} else if ((cityParam == true) && (nameParam == true)) {
				stmt.setString(3, "%" + searchParam.getCity() + "%");
			}
			if((cityParam == false) && (nameParam == false) && (carClassParam == true)) {
				stmt.setString(1, searchParam.getCarClass());
			} else if((cityParam == false) && (nameParam == true) && (carClassParam == true)) {
				stmt.setString(3, searchParam.getCarClass());
			} else if ((cityParam == true) && (nameParam == true) && (carClassParam == true)) {
				stmt.setString(4, searchParam.getCarClass());
			}
			query = sb.toString();
			stmt.executeQuery();
			rs = stmt.getResultSet();
			try {
				while(rs.next()) {
					Car car = new Car();
					car.setCarclass(rs.getString("class"));
					car.setCategoryDesc(rs.getString("Description"));
					car.setManufacturer(rs.getString("brand"));
					car.setModel(rs.getString("model"));
					car.setStatus(rs.getString("status"));
					result.add(car);
					id++;
					}
				
			} finally {
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			return result;
		}
	
	
}
