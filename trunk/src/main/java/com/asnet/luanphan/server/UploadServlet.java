package com.asnet.luanphan.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("uploadServlet")
public class UploadServlet extends HttpServlet implements Servlet{
	    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		
		System.out.println(1);
		
		 response.setContentType("text/plain");

		    FileItem uploadItem = getFileItem(request);
		    if (uploadItem == null) {
		    	System.out.println(2);
		    	response.getWriter().write("NO-SCRIPT-DATA");
		      return;
		    }

		    byte[] fileContents = uploadItem.get();
		    //TODO: add code to process file contents here. We will just print it.
		    System.out.println(new String(fileContents));
		    response.getWriter().write(new String(fileContents));
		    System.out.println(3);
		  }

		  private FileItem getFileItem(HttpServletRequest request) {
		    FileItemFactory factory = new DiskFileItemFactory();
		    ServletFileUpload upload = new ServletFileUpload(factory);

		    try {
		    	System.out.println(4);
		      List items = upload.parseRequest(request);
		      Iterator it = items.iterator();
		      while (it.hasNext()) {
		    	  System.out.println(5);
		        FileItem item = (FileItem) it.next();
		        if (!item.isFormField()
		            && "uploadFormElement".equals(item.getFieldName())) {
		        	System.out.println(6);
		          return item;
		        }
		      }
		    } catch (FileUploadException e) {
		    	System.out.println(7);
		      return null;
		    }
		    System.out.println(8);
		    return null;
		  
		
		
		
		
		/**
		
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
		System.out.println(items.size());
		System.out.println(reponse.toString());
		
		for (Iterator iter= items.iterator(); iter.hasNext();) {
			System.out.println(3);
			FileItem fileItem = (FileItem) iter.next();			
			if(fileItem.isFormField())				
				continue;
			String filename = fileItem.getName();
			int slash = filename.lastIndexOf("/");
			if(slash==-1){
				System.out.println(4);
				slash = filename.lastIndexOf("\\");
			}
			if(slash!=-1){
				System.out.println(5);
				filename = filename.substring(slash + 1);
			}
			try{
				System.out.println(6);
				File fileUpload = new File("C:\\" + filename);
				fileItem.write(fileUpload);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
	}
}
