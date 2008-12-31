package com.asnet.luanphan.vntokenizer;

import java.io.StringReader;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.junit.Test;

import com.asnet.luanphan.lucene.FileInput_Output;
import com.asnet.luanphan.lucene.analysis.VNAnalyzer;


public class TestVNAnalyzer {
	@Test
	public void testVNAnalyzer() throws Exception {
		VNAnalyzer analyzer = new VNAnalyzer();
		String testStr = FileInput_Output.getData("test\\dataTest\\data.txt");
		System.out.println(testStr);
		TokenStream ts =analyzer.tokenStream("test\\dataTest\\stopword.txt", new StringReader(testStr));
		while(true){
			Token token = ts.next();
			if(token==null) break;
			System.out.print(" " + token);
		}
	}
	
}
