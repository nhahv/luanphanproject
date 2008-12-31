package com.asnet.luanphan.lucene;

import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.junit.Test;


public class TestStandartAnalyzer {
	@Test
	public void testname() throws Exception {
		StandardAnalyzer analyzer = new StandardAnalyzer();
		Reader reader = new StringReader("what the hell do you think you're doing.");
		TokenStream tokenStream = analyzer.tokenStream("", reader);
		while(true){
			Token token = tokenStream.next();
			if(token==null) break;
			System.out.print(" " + token);
		}
	}
}
