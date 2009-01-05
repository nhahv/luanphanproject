package com.asnet.luanphan.server;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

//import vn.hus.tokenizer.tokens.LexerToken;

import com.asnet.luanphan.client.ApplicationService;
import com.asnet.luanphan.client.datamodel.FileInfo;
import com.asnet.luanphan.client.datamodel.User;
import com.asnet.luanphan.server.lucene.FileInput_Output;
import com.asnet.luanphan.server.lucene.analysis.VNAnalyzer;
import com.asnet.luanphan.server.vntokenizer.VNTokenizer;
import com.asnet.luanphan.server.vntokenizer.VietnameseToken;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ApplicationImpl extends RemoteServiceServlet  implements ApplicationService{
	public boolean isExistsUser(User user) {
		boolean accepted = false;
		DbUsers u = new DbUsers();
		if(u.isUserValid(user)){
			accepted = true;
		}
		System.out.println(accepted);
		return accepted;
	}
	//public FileInfo tokenize(FileInfo fileInfo){
		//return fileInfo;
	//
	
	public FileInfo demo(){
		FileInfo fileInfo = new FileInfo();
		String listLexers = null;
		String listVnTokens=null;
		VietnameseToken vietnameseToken = new VietnameseToken();
		String filename = "src\\test\\java\\dataTest\\data.txt";
		fileInfo.setFileName("data.txt");
		List<LexerToken> listLexerToken = vietnameseToken.tokenize(filename);
		for(Iterator<LexerToken> i = listLexerToken.iterator(); i.hasNext();){
			listLexers = listLexers + i.next().toString() + "<br>";
		}
		fileInfo.setListLexers(listLexers);
		VNTokenizer vnTokenizer = new VNTokenizer(listLexerToken);
		
		while(true){
			Token token = vnTokenizer.next();
			if(token==null) break;
			//listVnTokens = listVnTokens + token + "<br>";//tao chuoi string dang html
	    }
		
		VNAnalyzer analyzer = new VNAnalyzer();
		String testStr = FileInput_Output.getData(filename);
		TokenStream ts =analyzer.tokenStream("src\\test\\java\\dataTest\\stopword.txt", new StringReader(testStr));
		while(true){
			Token token;
			try {
				token = ts.next();
				if(token==null) break;
				listVnTokens = listVnTokens + token + "<br>";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		fileInfo.setListVnTokens(listVnTokens);
		System.out.println(listVnTokens);
		return fileInfo;
		
	}
}
