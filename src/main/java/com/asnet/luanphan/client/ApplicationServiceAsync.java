package com.asnet.luanphan.client;

import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ApplicationServiceAsync {
	public void isExistsUser(User user, AsyncCallback<Boolean> callback);
}
