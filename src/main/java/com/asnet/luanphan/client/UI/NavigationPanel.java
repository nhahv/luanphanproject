package com.asnet.luanphan.client.UI;


import com.asnet.luanphan.client.Application;
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
				RootPanel.get().clear();
				Panel borderPanel  = new Panel();
				borderPanel.add(Application.headerPanel);
				borderPanel.add(Application.navigationPanel);
				borderPanel.add(Application.searchPanel);
				borderPanel.add(Application.footerPanel);		
				Panel mainPanel = new Panel();
				mainPanel.add(borderPanel);
				RootPanel.get().add(mainPanel);
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
				loginToSite();
			}
		});
		toolbar.addButton(loginBtn);
		
		toolbar.addSeparator();
		ToolbarButton demo = new ToolbarButton("Demo VnTokenize and Lucene");  
		demo.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				RootPanel.get().clear();
				Panel borderPanel  = new Panel();
				borderPanel.add(Application.headerPanel);
				borderPanel.add(Application.navigationPanel);
				borderPanel.add(Application.tokenizePanel);
				borderPanel.add(Application.footerPanel);		
				Panel mainPanel = new Panel();
				mainPanel.add(borderPanel);
				RootPanel.get().add(mainPanel);
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
	private void loginToSite(){
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
	private void signup(){
		
		SignUpPanel signUpPanel = new SignUpPanel();
		Panel panel = signUpPanel.getSignUpPanel();
		BorderPanel borderPanel = new BorderPanel();
		borderPanel.addCenterPanel(panel);
		RootPanel.get().clear();
		RootPanel.get().add(borderPanel.getBorderPanel());
	}
	private void uploadFile(){
		RootPanel.get().clear();
		Panel borderPanel  = new Panel();
		borderPanel.add(Application.headerPanel);
		borderPanel.add(Application.navigationPanel);
		borderPanel.add(new UploadPanel());
		borderPanel.add(Application.footerPanel);		
		Panel mainPanel = new Panel();
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	}
	private void downloadFile(){
		MessageBox.alert("Download function's here, but this does nothing");
	}	
}
