package com.asnet.luanphan.server;
import org.junit.Assert;
import org.junit.Test;

import com.asnet.luanphan.client.datamodel.User;
import com.asnet.luanphan.server.DbUsers;


public class DbUsersTest {
	@Test
	public void testIsValidUser() throws Exception{
		DbUsers dbUser = new DbUsers();
		User user = new User();
		user.password = "abc123";
		user.loginname = "admin";
		Boolean result = dbUser.isUserValid(user);
		Boolean expectedResult = true;
		Assert.assertEquals(expectedResult, result);
		
		
		
		user.password ="abc123";
		user.loginname ="luanphan";
		
		expectedResult = true;
		result = dbUser.isUserValid(user);
		
		Assert.assertEquals(expectedResult, result);
		
		
		user.password="";
		user.password="";
		expectedResult = false;
		result = dbUser.isUserValid(user);
		Assert.assertEquals(expectedResult, result);
	}
	

	
}
