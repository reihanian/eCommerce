package org.ocpc.ecommerce.view;

import javax.faces.bean.ManagedBean;

import org.ocpc.ecommerce.model.User;

@ManagedBean
public class DashboardView {
	
	private User user;

	public User getUser() {
		if(user == null) {
			user = new User();
			user.setFirstName("iman");
			user.setLastName("reihanian");
			user.setEmail("iman.reih@gmail.com");
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
