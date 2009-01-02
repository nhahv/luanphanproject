package com.asnet.luanphan.server.lucene.analysis;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

import com.asnet.luanphan.server.lucene.VietStopword;
import com.asnet.luanphan.server.vntokenizer.VNTokenizer;
import com.asnet.luanphan.server.vntokenizer.VietnameseToken;




import vn.hus.tokenizer.Tokenizer;
import vn.hus.tokenizer.tokens.LexerToken;

public class VNAnalyzer extends Analyzer {
	
	/**
	 * @param fieldName the name of stopword file
	 * @param reader contain data to analyzer
	 */
	public TokenStream tokenStream(String fieldName, Reader reader){
		TokenStream result=null;
		//tokenize reader to Vietnamese tokens
		VietnameseToken vietnameseToken = new VietnameseToken();
		VNTokenizer vntokenizer;
		List<LexerToken> lexerTokens;
		try {
			lexerTokens = vietnameseToken.tokenize("src\\test\\java\\dataTest\\data.txt");
			for(int i=0;i<lexerTokens.size();i++){
				System.out.println(lexerTokens.get(i).toString());
			}
			vntokenizer = new VNTokenizer(lexerTokens);
			//remove stopword
			VietStopword vietStopword = new VietStopword(fieldName, vntokenizer);
			result  = vietStopword.removeStopWord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}
}
