package com.asnet.luanphan.client.UI;

import com.asnet.luanphan.client.ApplicationServiceAsync;
import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.datamodel.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.ValidationException;
import com.gwtext.client.widgets.form.Validator;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayoutData;
public class SignUpPanel extends Panel{
	
	public SignUpPanel(){
		
		this.setBorder(false);
		this.setId("signupPanel");
		this.setMargins(15,300,300,15);
		init();
	}
	private void init(){
		Panel panel = new Panel();	
		panel.setBorder(false);
		
		Label label1 = new Label("Create new account");
		label1.setStyle("font-size:18;color:blue");
		panel.add(label1);
		
		Panel panel2 = new Panel();
		panel2.setPaddings(15);
		panel2.setBorder(true);
		
		FormPanel formPanel = new FormPanel();
		formPanel.setFrame(true);
		formPanel.setPaddings(15);		
		formPanel.setTitle("Sign up");
		formPanel.setWidth(400);
		formPanel.setLabelWidth(75);
		Label label2 = new Label("Get started with my site");
		label2.setHeight(20);
		label2.setStyle("font-size:14; color:blue;"	);
		formPanel.add(label2);
		
		
		final TextField firstname = new TextField("First Name", "firstname", 250);
		formPanel.add(firstname);
		final TextField lastname = new TextField("Last Name", "lastname", 250);
		formPanel.add(lastname);
		final TextField loginname = new TextField("Login Name", "loginname", 250);
		loginname.setId("loginname");
		loginname.setAllowBlank(false);
		loginname.addListener(new FieldListenerAdapter(){
			@Override
			public void onSpecialKey(Field field, EventObject e) {
				// TODO Auto-generated method stub
				super.onSpecialKey(field, e);
				if(e.getKey()==KeyboardListener.KEY_ENTER){
					checkAvailability(loginname);
				}
			}
		});
		formPanel.add(loginname);
		
		Button checkBtn = new Button("Check availability!");
		checkBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				final ExtElement element = Ext.get("signupPanel");
				element.mask();
				String str = loginname.getText();
				if(str.equals("") || str==null)
					MessageBox.alert("Please, type the loginname.");
				else 
					checkAvailability(loginname);
					
			}
		});
		formPanel.add(checkBtn, new BorderLayoutData(RegionPosition.WEST));
		
		
		final TextField password = new TextField("Choose a password", "password", 250);
		password.setPassword(true);
		password.setAllowBlank(false);
		formPanel.add(password);
		
		
		final TextField rePassword = new TextField("Re-enter password", "repassword", 250);
		rePassword.setPassword(true);
		rePassword.setAllowBlank(false);
		rePassword.setValidator(new Validator(){
			public boolean validate(String value) throws ValidationException {
				if(password.getText().equals(rePassword.getText())){
					return true;
				}
				return false;
			}
		});
		formPanel.add(rePassword);
		
		final Checkbox rememberMe = new Checkbox("Remember me on this computer");
		rememberMe.addListener(new CheckboxListenerAdapter(){
			@Override
			public void onSpecialKey(Field field, EventObject e) {
				// TODO Auto-generated method stub
				super.onSpecialKey(field, e);
				if(e.getKey()==KeyboardListener.KEY_ENTER){
					boolean b = !rememberMe.getValue();
					rememberMe.setChecked(b);
				}
			}
		});
		rememberMe.addListener(new CheckboxListenerAdapter(){
			public void onCheck(Checkbox field, boolean checked){
				if(checked){
					MessageBox.alert("Checked, but doing nothing!");
				}else{
					MessageBox.alert("Unchecked, but doing nothing!");
				}
			}
		});
		formPanel.add(rememberMe);
		
		final TextField email = new TextField("Email", "email", 250);
		email.setVtype(VType.EMAIL);
		formPanel.add(email);
		
		Button submitBtn = new Button("Submit");
		submitBtn.addListener( new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				User user = new User();
				user.username = firstname.getText() + " " + lastname.getText();
				user.loginname = loginname.getText();
				user.password = password.getText();
				user.useremail = email.getText();
				
				
				signUp(user);
			}
		});
		formPanel.add(submitBtn);
		panel.add(formPanel);
		this.add(panel);
		this.setFrame(true);
	}
	private void checkAvailability(final TextField loginname){
		final ApplicationServiceAsync loginService = Util.getInstance();
		ServiceDefTarget target = (ServiceDefTarget) loginService;

		String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
		target.setServiceEntryPoint(moduleRelativeURL);
		final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean result) {
				
				if (result) {
					MessageBox.alert("Please, choose another loginname because '" + loginname.getText() + "' existed" );
					loginname.setValue("");
					final ExtElement element = Ext.get("signupPanel");
					element.unmask();
				} else {
					MessageBox.alert("Valid loginname");
					final ExtElement element = Ext.get("singupPanel");
					element.unmask();
				}
			}

			public void onFailure(Throwable caught) {
				GWT.log("Error:", caught);
			}
		};
		loginService.isExistUserLoginname(loginname.getText(), callback);
	}
	public void signUp(User user){
		final ApplicationServiceAsync signUpService = Util.getInstance();
		ServiceDefTarget target = (ServiceDefTarget) signUpService;

		String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
		target.setServiceEntryPoint(moduleRelativeURL);
		final AsyncCallback callback = new AsyncCallback() {
			
			public void onSuccess(Object arg0) {
				// TODO Auto-generated method stub
				NavigationPanel.loginToSite();
				
			}
			public void onFailure(Throwable caught) {
				GWT.log("Error:", caught);
			}
		};
		signUpService.insertUser(user, callback);
	}
}
