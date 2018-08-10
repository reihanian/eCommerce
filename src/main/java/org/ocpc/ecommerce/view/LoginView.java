package org.ocpc.ecommerce.view;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.ocpc.ecommerce.model.Authentication;
import org.ocpc.ecommerce.model.User;
import org.ocpc.ecommerce.service.LoginManagement;

@ManagedBean
public class LoginView {

	private User user;
	private Authentication authentication;
	
	private String userMessage;

	
	public void authenticate() {
		String username = authentication.getUsername();
		String password = authentication.getPassword();
		
		System.out.println("Username: " + username);
		System.out.println("Password:" + password);
		
		LoginManagement loginManagement = new LoginManagement();
		boolean resultOfAuthentication = loginManagement.isAuthenticationValid(authentication);
	
		if(resultOfAuthentication) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			userMessage = "The credential is not correct.";
		}
		
	}
	
	public User getUser() {
		if(user == null)
			user = new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Authentication getAuthentication() {
		if(authentication == null)
			authentication =  new Authentication();
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
	

}
