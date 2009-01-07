package com.asnet.luanphan.client.UI;


import java.util.HashMap;
import java.util.Iterator;

import com.asnet.luanphan.client.Application;
import com.asnet.luanphan.client.ApplicationServiceAsync;
import com.asnet.luanphan.client.ApplicationService.Util;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.QuickTipsConfig;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.menu.Menu;
public class NavigationPanel extends Panel{
	public NavigationPanel(){
		init();
	}
	private void init(){
		
		this.setBorder(false);  
		//create a toolbar and various menu items  
		Toolbar toolbar = new Toolbar();  
		   
		Menu menu = new Menu();  
		menu.setShadow(true);  
		menu.setMinWidth(10);  
		
		ToolbarButton homeButton = new ToolbarButton("Home");  
		homeButton.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				History.newItem("Home");			
				
			}
		});
		homeButton.setEnableToggle(true);  
		homeButton.setPressed(true);  
		QuickTipsConfig tipsConfig = new QuickTipsConfig();  
		tipsConfig.setText("Site similarity detecting");  
		tipsConfig.setTitle("Home");  
		homeButton.setTooltip(tipsConfig);  
		
		toolbar.addButton(homeButton);  
		
		toolbar.addSeparator();  
		ToolbarButton uploadBtn = new ToolbarButton("Upload");  
		uploadBtn.setEnableToggle(true);
		uploadBtn.setPressed(true);
		uploadBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				History.newItem("upload");				
				uploadFile();
			}
		});
		toolbar.addButton(uploadBtn);
		
		toolbar.addSeparator();  
		ToolbarButton downloadBtn = new ToolbarButton("Download");  
		downloadBtn.setEnableToggle(true);
		downloadBtn.setPressed(true);
		downloadBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				History.newItem("download");
				downloadFile();
			}
		});
		toolbar.addButton(downloadBtn);
		
			
		
		toolbar.addSeparator();
		ToolbarButton loginBtn = new ToolbarButton("Login");  
		loginBtn.setEnableToggle(true);  
		loginBtn.setPressed(true);
		loginBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				History.newItem("login");
				loginToSite();
			}
		});
		toolbar.addButton(loginBtn);
		
		toolbar.addSeparator();
		ToolbarButton demo = new ToolbarButton("Demo VnTokenize and Lucene");  
		demo.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				History.newItem("demo");
				doDemo();
				
			}
		});
		demo.setEnableToggle(true);  
		demo.setPressed(true);  
		QuickTipsConfig demoTip = new QuickTipsConfig();  
		demoTip.setText("Demo VnTokenize and Lucene");  
		demoTip.setTitle("Site similarity detecting");  
		demo.setTooltip(demoTip);  
		
		toolbar.addButton(demo); 
		
		Panel toolbarPanel = new Panel();  
		toolbarPanel.setWidth(500);  
		toolbarPanel.setHeight(400);  
		 toolbarPanel.setTopToolbar(toolbar);  
		this.add(toolbar);  
		
		 
	}	
	public static void loginToSite(){
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);		
		borderPanel.add(Application.loginPanel);
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
		
	}
	public static void signup(){		
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);
		borderPanel.add(Application.signupPanel);
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	}
	public static void uploadFile(){
		
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);
		borderPanel.add(Application.welcomePanel);
		borderPanel.add(new UploadPanel());
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	}
	public static void downloadFile(){
		session();		
		//MessageBox.alert("Download function's here, but this does nothing");
	}
	public static void doDemo(){	
		
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);
		borderPanel.add(Application.welcomePanel);
		borderPanel.add(Application.tokenizePanel);
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	}
	public static void goHome(){
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);
		borderPanel.add(Application.welcomePanel);
		borderPanel.add(Application.searchPanel);
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	}
	public static void session(){
		
		final ApplicationServiceAsync loginService = Util.getInstance();
		ServiceDefTarget target = (ServiceDefTarget) loginService;
		String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
		target.setServiceEntryPoint(moduleRelativeURL);
		final AsyncCallback<HashMap> callback = new AsyncCallback<HashMap>() {
			public void onSuccess(HashMap result) {
				
				if (result.isEmpty()) {
					MessageBox.alert("You have to login firstly");			
					NavigationPanel.loginToSite();
					
				} else {
					Iterator iterator = result.keySet().iterator();
				      
				      	String ss ="";
				      while(iterator.hasNext()) {
				        String username = (String) iterator.next();
				        String password = (String) result.get(username);				        
				        ss+="("+username+"  " + password + ")";
				      }
				      MessageBox.alert(ss);
				}
			}

			public void onFailure(Throwable caught) {
				MessageBox.alert("rpc unsuccessful");
				//GWT.log("Error:", caught);
			}
		};
		loginService.getAllLoginUser(callback);
	}
}
