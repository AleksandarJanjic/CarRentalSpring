package com.janja.rental.data;

import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.janja.rental.beans.BookingBean;
import com.janja.rental.beans.BookingInfoBean;
import com.janja.rental.beans.Price;

@Component
public class BookingData {
	
	@Autowired
	BookingInfoBean bookingInfoBean;
	
	public BookingInfoBean getData() {
		BookingInfoBean infoBean = new BookingInfoBean();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String sql1 = "SELECT o.name AS office, c.name AS City FROM office o " + 
				"LEFT JOIN city c ON o.cityID=c.cityID;";
		String sql2 = " SELECT v.name, dp.price, dp.DaysFrom, dp.DaysTo FROM vehiclecategory v " + 
				" LEFT JOIN dailyprice dp ON v.categoryID=dp.categoryID;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/carrentalproject?useSSL=false", "root", "janja988");) {
			PreparedStatement stmt = conn.prepareStatement(sql1);
			stmt.executeQuery();
			rs1 = stmt.getResultSet();
			while(rs1.next()) {
				infoBean.setOffices(rs1.getString("office"), rs1.getString("City"));
			}
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.executeQuery();
			rs2 = stmt2.getResultSet();
			while(rs2.next()) {
				infoBean.setPrice(rs2.getString("name"), rs2.getDouble("price"), rs2.getInt("DaysFrom"), rs2.getInt("DaysTo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return infoBean;
	}
	
	public List<Price> getPriceData() {
		List<Price> result = new ArrayList<Price>();
		ResultSet rs = null;
		String sql = "SELECT v.name, dp.price, dp.DaysFrom, dp.DaysTo FROM vehiclecategory v " + 
				"LEFT JOIN dailyprice dp ON v.categoryID=dp.categoryID ";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/carrentalproject?useSSL=false", "root", "janja988");) {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeQuery();
			rs = stmt.getResultSet();
			while (rs.next()) {
				Price price = new Price();
				price.setPrice(rs.getString("name"), rs.getDouble("price"), rs.getInt("DaysFrom"), rs.getInt("DaysTo"));
				result.add(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String createBooking(BookingBean bb) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/carrentalproject?useSSL=false", "root", "janja988");) {
			String query = "{CALL insertBooking(?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = conn.prepareCall(query);
			stmt.setInt(1, bb.getAge());
			stmt.setString(2, bb.geteMail());
			stmt.setString(3, bb.getName());
			stmt.setString(4, bb.getPhoneNum());
			stmt.setInt(5, bb.getPickupOffice());
			stmt.setInt(6, bb.getDropoffOffice());
			stmt.setString(7, bb.getPickupdate());
			stmt.setString(8, bb.getDropoffdate());
			stmt.setInt(9, bb.getStatus());
			stmt.setDouble(10, bb.getTotalPrice());
			stmt.setInt(11, bb.getCategory());
			stmt.registerOutParameter(12, java.sql.Types.INTEGER);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}
}
