package com.asnet.luanphan.server;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import vn.hus.tokenizer.tokens.LexerToken;

import com.asnet.luanphan.client.ApplicationService;
import com.asnet.luanphan.client.datamodel.FileInfo;
import com.asnet.luanphan.client.datamodel.User;
import com.asnet.luanphan.server.lucene.FileInput_Output;
import com.asnet.luanphan.server.lucene.analysis.VNAnalyzer;
import com.asnet.luanphan.server.vntokenizer.VNTokenizer;
import com.asnet.luanphan.server.vntokenizer.VietnameseToken;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ApplicationImpl extends RemoteServiceServlet  implements ApplicationService{
	public static final String ALL_SUCCESSFUL_USER="SuccessfulUser";
	/**
	 * 
	 */
	public HashMap getAllLoginUser(){
		return Utils.getHashMapFromSession(ALL_SUCCESSFUL_USER, getSession());
	}	
	/**
	 * 
	 * @return
	 */
	private HttpSession getSession() {
		
		return this.getThreadLocalRequest().getSession();
	}

	/**
	 * 
	 */
	public boolean isExistUserLoginname(String loginname){
		DbUsers dbUser = new DbUsers(); 
		if(dbUser.isExistUserLoginname(loginname)){
			return true;
		}
		return false;
	}
	public void createNewSession(String key, String value){
		Utils.addSeccessfulUserToSession(ALL_SUCCESSFUL_USER, getSession(), key, value);
	}
	/**
	 * 
	 */

	public HashMap isExistsUser(User user) {
		HashMap hashMap = new HashMap();
		//boolean accepted = false;
		DbUsers u = new DbUsers();
		if(u.isUserValid(user)){
			//accepted = true;
			Utils.addSeccessfulUserToSession(ALL_SUCCESSFUL_USER, getSession(), user.loginname, user.password);
			hashMap.put(user.loginname, user.password);
			return hashMap;
		}		
		return null;//accepted;
	}
	//public FileInfo tokenize(FileInfo fileInfo){
		//return fileInfo;
	//
	
	public FileInfo demo(){
		FileInfo fileInfo = new FileInfo();
		String listLexers = "";
		String listVnTokens="";
		VietnameseToken vietnameseToken = new VietnameseToken();
		String filename = "src\\test\\java\\dataTest\\data.txt";
		fileInfo.setFileName("data.txt");
		List<LexerToken> listLexerToken = vietnameseToken.tokenize(filename);
		for(Iterator<LexerToken> i = listLexerToken.iterator(); i.hasNext();){
			System.out.println(i.next().toString());
		}
		fileInfo.setListLexers(listLexers);
		VNTokenizer vnTokenizer = new VNTokenizer(listLexerToken);
		
		while(true){
			Token token = vnTokenizer.next();
			if(token==null) break;
			//listVnTokens = listVnTokens + token + "<br>";//tao chuoi string dang html
	    }
		
		VNAnalyzer analyzer = new VNAnalyzer();
		String testStr="";
		try {
			testStr = FileInput_Output.getData(filename);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TokenStream ts =analyzer.tokenStream("src\\test\\java\\dataTest\\stopword.txt", new StringReader(testStr));
		while(true){
			Token token = new Token();
			try {
				token = ts.next();
				if(token==null) break;
				listVnTokens =  token + listVnTokens+ "<br>";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		fileInfo.setFileContent(testStr);
		fileInfo.setListVnTokens(listVnTokens);
		
		return fileInfo;
		
	}
	public void insertUser(User user){
		DbUsers dbUsers = new DbUsers();
		dbUsers.insertDBUser(user);
	}
}
