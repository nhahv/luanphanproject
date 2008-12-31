package com.asnet.luanphan.server;

import com.asnet.luanphan.client.ApplicationService;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ApplicationImpl extends RemoteServiceServlet implements ApplicationService{
	public boolean isExistsUser(User user) {
		boolean accepted = false;
		DbUsers u = new DbUsers();
		if(u.isUserValid(user)){
			accepted = true;
		}
		System.out.println(accepted);
		return accepted;
	}
}
