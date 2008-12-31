package com.asnet.luanphan.client.UI;


import com.asnet.luanphan.client.ApplicationServiceAsync;
import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.core.EventObject;


public class LoginWidget {

	private Panel loginPanel;
	private FormPanel mainForm;
	private TextField loginName;
	private TextField password;
	private Button loginBtn;
	
	public LoginWidget(){
		loginPanel = new Panel();
		mainForm = new FormPanel();
		loginName = new TextField();
		password = new TextField();
		loginBtn = new Button();
		
		initLoginWidget();
	}
	private void initLoginWidget() {
		mainForm.setFrame(true);
		mainForm.setTitle("Login");
		mainForm.setWidth(350);
		mainForm.setLabelWidth(75);
		
		
		loginName.setAllowBlank(false);
		loginName.setFieldLabel("Username:");
		loginName.setName("username");
		loginName.setWidth(230);
		loginName.focus();
		
		
		
		password.setPassword(true);
		password.setFieldLabel("Password:");
		password.setName("password");
		password.setWidth(230);
		
		initButton();
		
		
		mainForm.add(loginName);
		mainForm.add(password);
		mainForm.add(loginBtn);
		
		loginPanel.setBorder(false);
		loginPanel.setPaddings(5);
		loginPanel.add(mainForm);
		
	}
	private void initButton() {
		loginBtn.setText("Login");
		loginBtn.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				loginToSite();
			}
		});
		
	}
	private void loginToSite(){
		User user = new User();
		user.username = loginName.getText();
		user.password = password.getText();
		final ApplicationServiceAsync loginService = Util.getInstance();
		ServiceDefTarget target = (ServiceDefTarget) loginService;

		String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
		target.setServiceEntryPoint(moduleRelativeURL);
		final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean result) {
				// boolean ok = Boolean.valueOf(result.toString());
				if (result.booleanValue()) {
					//RootPanel.get().clear();
					//ContentPage contentPage = new ContentPage();
					
					//Panel panel = contentPage.setMainPanel(fName.getText());
					//Viewport viewport = new Viewport(panel);
					MessageBox.alert("Login successful");
					//
					
				} else {
					MessageBox.alert("Invalid user or password. Please, try again.");
				}
			}

			public void onFailure(Throwable caught) {
				GWT.log("Error:", caught);
			}
		};
		loginService.isExistsUser(user, callback);
	}
	
	
	public Panel getLoginPanel(){
		return loginPanel;
	}
}
