package org.ocpc.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.ocpc.ecommerce.model.Authentication;
import org.ocpc.ecommerce.model.User;

public class DBConnection {

	private Connection connection;

	public DBConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecommerce", "postgres", "iman123");
		System.out.println("Opened database successfully");
	}

	public void saveUser(User user) throws SQLException {
		String sql = "INSERT INTO \"User\" (\"firstName\", \"lastName\", \"email\") VALUES (?, ?, ?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		
		ps.execute();
	}

	public void saveAuthentication(Authentication authentication) throws SQLException {
		String sql = "INSERT INTO \"Authentication\" (\"username\", \"password\") VALUES (?, ?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, authentication.getUsername());
		ps.setString(2, authentication.getPassword());
		
		ps.execute();
	}
}
