package com.asnet.luanphan.lucene;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;


import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.util.StringHelper;

public class FileInput_Output {
	public static String getData(String filePath){
	File file = new File(filePath);
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	DataInputStream dis = null;
	String result="";
	try{
		fis = new FileInputStream(file);
		bis = new BufferedInputStream(fis);
		dis = new DataInputStream(bis);
		while(dis.available()!=0){
			result = result + " " + dis.readLine();
		}
		fis.close();
		bis.close();
		dis.close();
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return result;
	}
	public static List<String> readByLine
				(String filename, String encoding)throws IOException {

	// definr input stream to read content of file
	FileInputStream fileInput = new FileInputStream(filename);
	InputStreamReader inReader = new InputStreamReader(fileInput, encoding);
	BufferedReader buffReader = new BufferedReader(inReader);
	String line = "";
	List<String> result = new LinkedList<String>();
	while ((line = buffReader.readLine()) != null) {
	// get all lines
		result.add(line.trim());
	
	}
    // close buffer
	buffReader.close();
	inReader.close();
	fileInput.close();

	// return result
	return result;
	}
	public static void writeByLine(String filename, String encoding, TokenStream ts) throws IOException{
		FileOutputStream fileOutput = new FileOutputStream(filename);
		OutputStreamWriter outWriter = new OutputStreamWriter(fileOutput, encoding);
		BufferedWriter buffWriter = new BufferedWriter(outWriter);
		while(true){
			Token token = ts.next();
			if(token==null) break;
			buffWriter.write(token.toString());	
			buffWriter.newLine();
		}
		buffWriter.close();
		outWriter.close();
		fileOutput.close();
		
		
	}

}
