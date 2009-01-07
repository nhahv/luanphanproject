package com.asnet.luanphan.server;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;



public class DbConnectionTest {
	@Test
	public void testReturnConnection() throws Exception {
		DbConnection conn = new DbConnection();
		Connection result = conn.getConnection();
		Assert.assertNotNull(result);
	}
}
