package com.asnet.luanphan.client.UI;

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
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
public class SignUpPanel {
	private Panel mainPanel;
	public SignUpPanel(){
		mainPanel = new Panel();
		mainPanel.setBorder(false);
		mainPanel.setMargins(15,300,300,15);
		init();
	}
	private void init(){
		Panel panel = new Panel();	
		panel.setBorder(false);
		
		Label label1 = new Label("Create new account");
		label1.setStyle("color:blue");
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
		label2.setStyle("size:10; color:blue;"	);
		formPanel.add(label2);
		
		
		TextField firstname = new TextField("First Name", "firstname", 250);
		formPanel.add(firstname);
		TextField lastname = new TextField("Last Name", "lastname", 250);
		formPanel.add(lastname);
		TextField loginname = new TextField("Login Name", "loginname", 250);
		formPanel.add(loginname);
		
		Button checkBtn = new Button("Check availability!");
		checkBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				checkAvailability();
			}
		});
		formPanel.add(checkBtn, new BorderLayoutData(RegionPosition.WEST));
		
		
		TextField password = new TextField("Choose a password", "password", 250);
		formPanel.add(password);
		
		
		TextField rePassword = new TextField("Re-enter password", "repassword", 250);
		formPanel.add(rePassword);
		
		Checkbox rememberMe = new Checkbox("Remember me on this computer");
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
		
		TextField email = new TextField("Email", "email", 250);
		formPanel.add(email);
		
		Button submitBtn = new Button("Submit");
		submitBtn.addListener( new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				MessageBox.alert("Submit information here!");
			}
		});
		formPanel.add(submitBtn);
		panel.add(formPanel);
		mainPanel.add(panel);
	}
	private void checkAvailability(){
		MessageBox.alert("This function hasn't been completed yet");
	}
	public Panel getSignUpPanel(){
		return mainPanel;
	}
}
