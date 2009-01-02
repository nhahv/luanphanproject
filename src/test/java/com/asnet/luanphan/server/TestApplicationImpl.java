package com.asnet.luanphan.server;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.asnet.luanphan.client.datamodel.FileInfo;

public class TestApplicationImpl {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testDemoMethod() throws Exception {
		ApplicationImpl app = new ApplicationImpl();
		
		FileInfo file = app.demo();
		
		String filenameExpected = "data.txt";
		String filenameResult = file.getFileName();
		System.out.println(file.getListLexers());
		System.out.println(file.getListVnTokens());
	}

}
