package com.asnet.luanphan.client.datamodel;




import java.util.List;


import com.google.gwt.user.client.rpc.IsSerializable;

public class FileInfo implements IsSerializable{
	private String filename;
	private String listLexers;
	private String listVnTokens;
	public FileInfo(){		
	}
	public void setFileName(String filename){
		this.filename = filename;
	}
	public void setListLexers(String listLexers){
		this.listLexers = listLexers;
	}
	public void setListVnTokens(String listVnTokens){
		this.listVnTokens = listVnTokens;
	}
	public String getFileName(){
		return filename;
	}
	public String getListLexers(){
		return listLexers;
	}
	public String getListVnTokens(){
		return listVnTokens;
	}
}
