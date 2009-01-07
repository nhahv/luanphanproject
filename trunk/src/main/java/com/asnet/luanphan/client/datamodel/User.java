package com.asnet.luanphan.client.datamodel;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable{
	public String username;
	public String loginname;
	public String password;
	public String userSess;
	public String useremail;
	public String userJoin;
	public String userLastVisit;
	public String userCurrentVisit;
	public int userBan;
	
}
