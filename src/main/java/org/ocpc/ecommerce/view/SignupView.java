package org.ocpc.ecommerce.view;

import javax.faces.bean.ManagedBean;

import org.ocpc.ecommerce.model.Authentication;
import org.ocpc.ecommerce.model.User;
import org.ocpc.ecommerce.service.RegistrationManagement;

@ManagedBean
public class SignupView {

	private Authentication authentication;
	private User user;
	private String msg;

	public void register() {
		RegistrationManagement registrationManagement = new RegistrationManagement();
		boolean registrationResult = registrationManagement.registerUser(authentication, user);

		if (registrationResult) {
			msg = "You have registered.";
		} else {
			msg = "You couldn't register.";
		}

	}

	public Authentication getAuthentication() {
		if (authentication == null)
			authentication = new Authentication();
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public User getUser() {
		if (user == null)
			user = new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
