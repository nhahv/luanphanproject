package com.asnet.luanphan.server.vntokenizer;

import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import vn.hus.tokenizer.tokens.LexerToken;

public class VNTokenizer extends TokenStream{
	
	private List<LexerToken> leTosInput;// = null;
	int leading = 0;//use for identifying the start position 
	int trailing = 0;//use to identifying the end position
	
	//Contructor contructs leTosInput properties data
	public VNTokenizer(List<LexerToken> input){
		leTosInput = input;
	}
	public Token next(){
		
		for (LexerToken leTo : leTosInput) {
			String term = leTo.getText();
			//do something here to obtain the leading and trailing position of term
			Token token = new Token();
			token.setStartOffset(leading);
			trailing = leading + term.length();
			token.setEndOffset(trailing);
			token.setTermText(term);
			token.setTermLength(term.length());
			leading = trailing + 1;
			leTosInput.remove(leTo);
			return token;
		}
		return null;
	}
}
