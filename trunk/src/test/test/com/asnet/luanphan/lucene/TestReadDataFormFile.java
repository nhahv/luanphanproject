package com.asnet.luanphan.lucene;

import org.junit.Test;

import junit.framework.TestCase;

public class TestReadDataFormFile extends TestCase {
	@Test
	public void testReadDataFromFile() throws Exception {
		String filePath="C:\\testLucene\\data.txt";
		FileInput_Output.getData(filePath);
		
		
		
		
	}
}
