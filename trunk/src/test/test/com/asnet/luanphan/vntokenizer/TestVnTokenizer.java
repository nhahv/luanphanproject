package com.asnet.luanphan.vntokenizer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.junit.Test;

import vn.hus.tokenizer.tokens.LexerToken;

import com.asnet.luanphan.lucene.FileInput_Output;
import com.asnet.luanphan.lucene.analysis.VNAnalyzer;


public class TestVnTokenizer {
	@Test
	public void test_vnTokenizer() throws Exception {
		VietnameseToken vietnameseToken = new VietnameseToken();
		String filename = "test\\dataTest\\data.txt";
		List<LexerToken> listLexerToken = vietnameseToken.tokenize(filename);
		for(Iterator<LexerToken> i = listLexerToken.iterator(); i.hasNext();){
			System.out.print( "  (" + i.next().toString()+ ")");
		}
		VNTokenizer vnTokenizer = new VNTokenizer(listLexerToken);
		System.out.println();
		while(true){
			Token token = vnTokenizer.next();
			if(token==null) break;
			System.out.print(token);
		}
	}
}
