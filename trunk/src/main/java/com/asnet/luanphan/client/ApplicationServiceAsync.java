package com.asnet.luanphan.client;


import java.util.HashMap;

import com.asnet.luanphan.client.datamodel.FileInfo;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ApplicationServiceAsync {
	public void isExistsUser(User user, AsyncCallback<HashMap> callback);
	//public void tokenize(FileInfo fileInfo, AsyncCallback<FileInfo> callback);
	public void demo(AsyncCallback<FileInfo> callback);
	public void getAllLoginUser(AsyncCallback<HashMap> callback);
	public void isExistUserLoginname(String loginname, AsyncCallback<Boolean> callback);
	public void createNewSession(String key, String value, AsyncCallback callback);
	public void insertUser(User user, AsyncCallback callback);
}
