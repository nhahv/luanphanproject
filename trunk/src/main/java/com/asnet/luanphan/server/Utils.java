package com.asnet.luanphan.server;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class Utils {
	public static HashMap getHashMapFromSession(String key, HttpSession session){
		if(session.getAttribute(key)==null){
			session.setAttribute(key, new HashMap());
		}
		return (HashMap)session.getAttribute(key);
	}
	
	public void  addSeccessfulUserToSession(String key, HttpSession session, String username, String password){
		HashMap mapOfUser = Utils.getHashMapFromSession(key, session);
		mapOfUser.put(username, password);
	}
}
