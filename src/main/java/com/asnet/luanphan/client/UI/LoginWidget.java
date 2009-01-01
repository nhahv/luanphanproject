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
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;


public class LoginWidget {

	private Panel loginPanel;
	private FormPanel mainForm;
	private TextField loginName;
	private TextField password;
	private Button loginBtn;
	
	public LoginWidget(){
		loginPanel = new Panel();
		loginPanel.setId("loginPanel");		
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
		
		
		
		Checkbox rememberMe = new Checkbox();  
		rememberMe.setBoxLabel("Remember my ID & password");  
		rememberMe.addListener(new CheckboxListenerAdapter() {  
		           public void onCheck(Checkbox field, boolean checked) {  
		               if (checked) {  
		                   MessageBox.alert("You have checked, but this function hasn't been completed yet");
		               } else {  
		                    MessageBox.alert("You have just unchecked, but this function hasn't been completed yet!" );
		               }  
		           }  
		       });
				
		mainForm.add(loginName);
		mainForm.add(password);
		mainForm.add(loginBtn);
		mainForm.add(rememberMe);
		
		loginPanel.setBorder(false);
		loginPanel.setPaddings(15);
		loginPanel.add(mainForm);
		
	}
	private void initButton() {
		loginBtn.setText("Login");
		loginBtn.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				final ExtElement element = Ext.get("loginPanel");
				element.mask("Loading");
				loginToSite();
			}
		});
		
	}
	private void loginToSite(){
		User user = new User();
		user.loginname = loginName.getText();
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
					final ExtElement element = Ext.get("loginPanel");
					element.unmask();
					
				} else {
					MessageBox.alert("Invalid user or password. Please, try again.");
					final ExtElement element = Ext.get("loginPanel");
					element.unmask();
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
