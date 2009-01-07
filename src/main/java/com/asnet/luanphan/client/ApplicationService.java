package com.asnet.luanphan.client;

//import com.asnet.luanphan.client.datamodel.FileInfo;
import java.util.HashMap;

import com.asnet.luanphan.client.datamodel.FileInfo;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("applicationService")
public interface ApplicationService extends RemoteService{
	public static class Util {

		public static ApplicationServiceAsync getInstance() {

			return GWT.create(ApplicationService.class);
		}
	}
	public HashMap isExistsUser(User user);
	//public FileInfo tokenize(FileInfo fileInfo);
	public FileInfo demo();
	public HashMap getAllLoginUser();
	public boolean isExistUserLoginname(String loginname);
	public void createNewSession(String key, String value);
	public void insertUser(User user);
}
