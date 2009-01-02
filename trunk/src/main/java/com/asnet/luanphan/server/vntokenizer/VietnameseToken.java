package com.asnet.luanphan.server.vntokenizer;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import vn.hus.tokenizer.Tokenizer;
import vn.hus.tokenizer.TokenizerProvider;
import vn.hus.tokenizer.tokens.LexerToken;

public class VietnameseToken {
	private static Tokenizer tokenizer;
	private static Tokenizer instance;
	/**
	 * 
	 */
	public VietnameseToken(){
		if (tokenizer==null){
			tokenizer = getInstance();
		}
	}
	//This method and VietTokenizer's constructor does the same work
	public static Tokenizer getInstance(){
		if(instance==null){
			instance = TokenizerProvider.getInstance().getTokenizer();
		}
		return instance;
	}
	/**
	 * Tokenize from file
	 * @param filename path of file to tokenize
	 * @return List of LexerToken
	 */
	public List<LexerToken> tokenize(String filename){
		tokenizer.tokenize(filename);
		return tokenizer.getResult();
	}
	/**
	 * Tokenizer from reader
	 * @param reader contain data to tokenize
	 * @return List of LexerToken
	 * @throws IOException
	 */
	public List<LexerToken> tokenize(Reader reader) throws IOException{
		tokenizer.tokenize(reader);
		return tokenizer.getResult();
	}
}
