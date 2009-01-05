package com.asnet.luanphan.client.UI;


import com.asnet.luanphan.client.Application;
import com.asnet.luanphan.client.ApplicationServiceAsync;
import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayoutData;



public class LoginWidget extends Panel{

	
	private FormPanel loginForm;
	private TextField loginName;
	private TextField password;
	private Button loginBtn;
	
	public LoginWidget(){
		
		this.setId("loginPanel");		
		loginForm = new FormPanel();
		loginName = new TextField();
		password = new TextField();
		loginBtn = new Button();
		
		initLoginWidget();
	}
	private void initLoginWidget() {
		
		loginForm.setFrame(true);
		loginForm.setTitle("Login");
		loginForm.setWidth(350);
		loginForm.setLabelWidth(75);
		loginForm.setButtonAlign(Position.CENTER);
				
	    loginName.setAllowBlank(false);
		loginName.setFieldLabel("Username");
		loginName.setName("username");
		loginName.setWidth(230);
		loginName.focus();
		
		
		
		password.setPassword(true);
		password.setFieldLabel("Password");
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
				
		loginForm.add(loginName);
		loginForm.add(password);
		loginForm.add(loginBtn);
		loginForm.add(rememberMe);
		
		FormPanel formPanel = new FormPanel();
		formPanel.setFrame(true);
		formPanel.setWidth(350);
		formPanel.setLabelWidth(75);
		formPanel.setLabelAlign(Position.CENTER);
		
		Hyperlink signUpLink = new Hyperlink("Sign up for my site", "signup");
		signUpLink.addClickListener(new ClickListener(){
			public void onClick(Widget widget){
				MessageBox.alert("Login successfully");
				RootPanel.get().clear();
				Panel borderPanel  = new Panel();
				borderPanel.add(Application.headerPanel);
				borderPanel.add(Application.navigationPanel);
				borderPanel.add(new SignUpPanel().getSignUpPanel());
				borderPanel.add(Application.footerPanel);		
				Panel mainPanel = new Panel();
				mainPanel.add(borderPanel);
				RootPanel.get().add(mainPanel);
			}
		});
		signUpLink.setStyleName("fontsize:20");
		formPanel.add(signUpLink);
		
		
		this.add(loginForm);
		this.add(formPanel, new BorderLayoutData(RegionPosition.EAST));
		
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
				
				if (result.booleanValue()) {
					
					
					final ExtElement element = Ext.get("loginPanel");
					element.unmask();
					RootPanel.get().clear();
					Panel borderPanel  = new Panel();
					borderPanel.add(Application.headerPanel);
					borderPanel.add(Application.navigationPanel);
					borderPanel.add(Application.searchPanel);
					borderPanel.add(Application.footerPanel);		
					Panel mainPanel = new Panel();
					mainPanel.add(borderPanel);
					RootPanel.get().add(mainPanel);
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
}
