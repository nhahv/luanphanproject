package com.asnet.luanphan.server;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.HttpResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public class UploadServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpResponse reponse){
		System.out.print("fasfafserverver");
		if(!ServletFileUpload.isMultipartContent(request)){
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		List items = null;
		try{
			items  = upload.parseRequest(request);
		}catch (FileUploadException e) {
			e.printStackTrace();
			return;
		}
		
		for (Iterator iter= items.iterator(); iter.hasNext();) {
			FileItem fileItem = (FileItem) iter.next();
			
			if(fileItem.isFormField())
				continue;
			String filename = fileItem.getName();
			int slash = filename.lastIndexOf("/");
			if(slash==-1){
				slash = filename.lastIndexOf("\\");
			}
			if(slash!=-1){
				filename = filename.substring(slash+ 1);
			}
			try{
				File fileUpload = new File("C:\\" + filename);
				fileItem.write(fileUpload);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
