package org.ocpc.ecommerce.service;

import org.ocpc.ecommerce.model.Authentication;

public class LoginManagement {
	
	public boolean isAuthenticationValid(Authentication authentication) {
		
//		if(authentication.getUsername().equals("iman") &&
//				authentication.getPassword().equals("amir")) {
//			return true;
//		}
//		
//		return false;
		
		
		return (authentication.getUsername().equals("iman") && authentication.getPassword().equals("amir"));
	}

}