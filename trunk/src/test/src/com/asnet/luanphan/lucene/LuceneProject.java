package com.asnet.luanphan.lucene;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class LuceneProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dataToString=null;
		File file = new File("C:\\data.txt");
		if(!file.exists()){
			System.out.println(file.getAbsolutePath());
			try{
			System.out.println(file.getCanonicalPath());
			}catch(IOException e){
				
			}
			System.out.println("The file does not exist");
		}
		else{
			
			try{
				byte[] buffer =null;
				FileInputStream fis = new FileInputStream(file);
				int length = (int)file.length();
				buffer = new byte[length];
				fis.read(buffer);
				fis.close();
				dataToString  = new String(buffer);
			}catch(IOException e){
				System.out.println(e);
			}
		}
		
		Analyzer analyzer = new StandardAnalyzer();
		TokenStream ts=null;
		if(dataToString!=null){
			ts = analyzer.tokenStream("myfield", new StringReader(dataToString));
		}
		try {
			Token token = ts.next();
			while (token!=null) {
				System.out.println("token:" + token);
				token= ts.next();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
