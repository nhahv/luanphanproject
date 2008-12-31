package com.asnet.luanphan.vntokenizer;

import java.io.File;

import org.junit.Test;


public class TestUseVnTokenizer {
	@Test
	public void testUseVnTokenizer() throws Exception {
		UseVnTokenizer useVnTokenier = new UseVnTokenizer();
		String inputFile ="C:\\testLucene\\data.txt";
		String outputFile="C:\\testLucene\\dataOut.txt";
		
		useVnTokenier.tokenize(inputFile, outputFile);
		
	}
}
