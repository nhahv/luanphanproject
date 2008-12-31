package com.asnet.luanphan.lucene;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;



//import com.asnet.luanphan.lucene.analysis.StopAnalyzer;

public class VietStopword {
	private static String[] stopword;
	private static Reader reader;
	private static TokenStream inputTokStr;
	public VietStopword(String stopPath, TokenStream tokStr) throws IOException{
		stopword= getFileStopword(stopPath);
		inputTokStr = tokStr;
	}
	public static TokenStream removeStopWord() throws IOException{
		TokenStream tokenStream = new StopFilter(inputTokStr, stopword);
		return tokenStream;
	}
	private static String[] getFileStopword(String filename) throws IOException{
		List<String> listOfString  = FileInput_Output.readByLine(filename, "utf-8");
		
		String[] listStopword =(String[])listOfString.toArray(new String[listOfString.size()]);
		return listStopword;
	}
}
