package com.asnet.luanphan.vntokenizer;

import java.util.Iterator;
import java.util.List;

import vn.hus.tokenizer.Tokenizer;
import vn.hus.tokenizer.TokenizerProvider;
import vn.hus.tokenizer.VietTokenizer;
import vn.hus.tokenizer.tokens.LexerToken;

public class UseVnTokenizer {
	private static Tokenizer tokenizer;
	
	public UseVnTokenizer() {
		tokenizer = TokenizerProvider.getInstance().getTokenizer();
	}
	
	public void tokenize(String inputFile, String outputFile) {
		tokenizer.tokenize(inputFile);
		tokenizer.exportResult(outputFile);
		List<LexerToken> list = tokenizer.getResult();
		for(Iterator<LexerToken> iterator = list.iterator(); iterator.hasNext();){
			String s = ((LexerToken)iterator.next()).toString();
			System.out.println(s);
		}
	}
	public void tokenize(String inputFile){
		tokenizer.tokenize(inputFile);
	}
	public List<LexerToken> getVnToken(){
		return tokenizer.getResult();
	}
}
