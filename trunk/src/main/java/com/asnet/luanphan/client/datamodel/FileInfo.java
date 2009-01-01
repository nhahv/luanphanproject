/**package com.asnet.luanphan.client.datamodel;



import java.io.IOException;
import java.util.List;

import com.asnet.luanphan.client.Helper.ManipulateFile;
import com.google.gwt.user.client.rpc.IsSerializable;

public class FileInfo implements IsSerializable{
	String filename;
	List<String> fileContent;
	public FileInfo(String filename, String encoding){
		this.filename = filename;
		this.fileContent = readFile(filename, encoding);
		
	}
	private List<String> readFile(String filename, String encoding){
		List<String> listStr = null;
		try {
			listStr = ManipulateFile.readByLine(filename, encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStr;
	}
}*/
