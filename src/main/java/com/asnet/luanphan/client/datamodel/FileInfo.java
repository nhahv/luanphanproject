package com.asnet.luanphan.client.datamodel;




import com.google.gwt.user.client.rpc.IsSerializable;

public class FileInfo implements IsSerializable{
	private String filename;
	private String fileContent;
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
	public void setFileContent(String fileContent){
		this.fileContent =fileContent;
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
	public String getFileContent(){
		return fileContent;
	}
}
