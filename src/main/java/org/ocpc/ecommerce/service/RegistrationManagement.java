package org.ocpc.ecommerce.service;

import java.sql.SQLException;

import org.ocpc.ecommerce.dao.DBConnection;
import org.ocpc.ecommerce.model.Authentication;
import org.ocpc.ecommerce.model.User;

public class RegistrationManagement {

	
	public boolean registerUser(Authentication authentication, User user) {
		DBConnection dbConnection = null;
		try {
			dbConnection = new DBConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		try {
			dbConnection.saveAuthentication(authentication);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		
		try {
			dbConnection.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

}
