package com.asnet.luanphan.lucene;


import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.junit.Test;

import vn.hus.tokenizer.tokens.LexerToken;

import com.asnet.luanphan.vntokenizer.VNTokenizer;
import com.asnet.luanphan.vntokenizer.VietnameseToken;




public class removeStopword {
	public void setUp(){
		
	}
	@Test
	public void testGetStopWord() throws Exception {
		//StandardAnalyzer analyzer  = new StandardAnalyzer();
		//TokenStream inputTokStr = analyzer.tokenStream("", new StringReader("Toi thi khong thich em, toi thi thich co ta"));
		VietnameseToken vietnameseToken = new VietnameseToken();
		String filename = "test\\dataTest\\data.txt";
		List<LexerToken> listLexerToken = vietnameseToken.tokenize(filename);
		VNTokenizer vnTokenizer = new VNTokenizer(listLexerToken);
		//while(true){
			//Token token = vnTokenizer.next();
			//if(token==null) break;
			//System.out.print(token + "");
		//}
		VietStopword vietStopword = new VietStopword("test\\dataTest\\stopword.txt", vnTokenizer);
		TokenStream toStream = vietStopword.removeStopWord();
		TokenStream toStream1 = toStream;
		FileInput_Output.writeByLine("test\\dataTest\\outData.txt", "utf-8", toStream);
		
		while(true){
			Token token = toStream1.next();
			if(token==null) break;
			System.out.println("remove stopword " + token);
		}
		
	}
}
