package com.asnet.luanphan.client.UI;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.QuickTipsConfig;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.ToolbarMenuButton;
import com.gwtext.client.widgets.ToolbarTextItem;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.menu.Adapter;
import com.gwtext.client.widgets.menu.CheckItem;
import com.gwtext.client.widgets.menu.ColorMenu;
import com.gwtext.client.widgets.menu.DateMenu;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.MenuItem;
import com.gwtext.client.widgets.menu.TextItem;
import com.gwtext.client.widgets.menu.event.CheckItemListenerAdapter;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
public class Navigation {
	private Panel navpanel = new Panel(); 
	public Navigation(){
		navpanel = new Panel();
		init();
	}
	private void init(){
		
		navpanel.setBorder(false);  
		navpanel.setPaddings(15);  
		//create a toolbar and various menu items  
		Toolbar toolbar = new Toolbar();  
		   
		Menu menu = new Menu();  
		menu.setShadow(true);  
		menu.setMinWidth(10);  
		   
		final CheckItemListenerAdapter listener = new CheckItemListenerAdapter() {  
		     public void onCheckChange(CheckItem item, boolean checked) {  
		         System.out.println("'" + item.getText() + "' is now " +  
		                 (checked ? "checked" : "unchecked"));  
		     }  
		 };  
		   
		CheckItem checkItem = new CheckItem();  
		checkItem.setText("I like Ext");  
		checkItem.setChecked(true);  
		checkItem.addListener(listener);  
		menu.addItem(checkItem);  
		   
		CheckItem checkItem2 = new CheckItem();  
		checkItem2.setText("I also like GWT-Ext :)");  
		checkItem2.setChecked(true);  
		checkItem2.addListener(listener);  
		menu.addItem(checkItem2);  
		   
		CheckItem checkItem3 = new CheckItem();  
		checkItem3.setText("I donated");  
		checkItem3.setChecked(false);  
		checkItem3.addListener(listener);  
		menu.addItem(checkItem3);  
		   
		menu.addSeparator();  
		   
		Menu submenu = new Menu();  
		submenu.setShadow(true);  
		submenu.setMinWidth(10);  
		submenu.addItem(new TextItem("<b class=\"menu-title\">Choose a Theme</b>"));  
		   
		CheckItem checkItem4 = new CheckItem();  
		checkItem4.setText("Aero Glass");  
		checkItem4.setChecked(true);  
		checkItem4.setGroup("theme");  
		checkItem4.addListener(listener);  
		submenu.addItem(checkItem4);  
		   
		CheckItem checkItem5 = new CheckItem();  
		checkItem5.setText("Vista Black");  
		checkItem5.setGroup("theme");  
		checkItem5.addListener(listener);  
		submenu.addItem(checkItem5);  
		   
		CheckItem checkItem7 = new CheckItem();  
		checkItem7.setText("Gray Theme");  
		checkItem7.setGroup("theme");  
		checkItem7.addListener(listener);  
		submenu.addItem(checkItem7);  
		   
		CheckItem checkItem8 = new CheckItem();  
		checkItem8.setText("Default Theme");  
		checkItem8.setGroup("theme");  
		checkItem8.addListener(listener);  
		submenu.addItem(checkItem8);  
		   
		MenuItem menuItem = new MenuItem("Radio Options", submenu);  
		MenuItem dateMenuItem = new MenuItem("Choose a Date", new DateMenu());  
		MenuItem colorMenuItem = new MenuItem("Choose a Color", new ColorMenu());  
		menu.addItem(menuItem);  
		menu.addItem(dateMenuItem);  
		menu.addItem(colorMenuItem);  
		menu.addSeparator();  
		   
		Item item = new Item();  
		item.setText("Dynamically added");  
		   
		TextField textField = new TextField();  
		Adapter adapter = new Adapter(textField);  
		menu.addItem(adapter);  
		   
		Item item2 = new Item("Disabled");  
		item2.setDisabled(true);  
		menu.addItem(item);  
		menu.addItem(item2);  
		   
		ToolbarButton menuButton = new ToolbarButton("Button w/ Menu");  
		menuButton.setMenu(menu);  
		menuButton.setIconCls("bmenu");  
		toolbar.addButton(menuButton);  
		toolbar.addSeparator();  
		   
		Menu splitMenu = new Menu();  
		Item bi = new Item();  
		bi.setText("<b>Bold</b>");  
		splitMenu.addItem(bi);  
		   
		Item ii = new Item();  
		ii.setText("<i>Italic</i>");  
		splitMenu.addItem(ii);  
		   
		Item ui = new Item();  
		ui.setText("<u>Underline</u>");  
		splitMenu.addItem(ui);  
		   
		splitMenu.addSeparator();  
		   
		Menu colorMenu = new Menu();  
		colorMenu.addItem(new TextItem());  
		colorMenu.addSeparator();  
		Item moreColors = new Item();  
		moreColors.setText("More Colors...");  
		colorMenu.addItem(moreColors);  
		   
		 MenuItem colorMI = new MenuItem("Pic a Color", colorMenu);  
		splitMenu.addItem(colorMI);  
		Item excellent = new Item();  
		excellent.setText("Excellent");  
		splitMenu.addItem(excellent);  
		   
		ToolbarMenuButton button2 = new ToolbarMenuButton("Split Button", splitMenu);  
		   
		toolbar.addButton(button2);  
		 toolbar.addSeparator();  
		   
		ToolbarButton toggleButton = new ToolbarButton("Toggle Me");  
		toggleButton.setEnableToggle(true);  
		toggleButton.setPressed(true);  
		QuickTipsConfig tipsConfig = new QuickTipsConfig();  
		tipsConfig.setText("This is a quicktip with a title");  
		tipsConfig.setTitle("Tip Title");  
		toggleButton.setTooltip(tipsConfig);  
		
		ToolbarButton iconOnly = new ToolbarButton();  
		iconOnly.setIcon("images/add-feed.gif");  
		iconOnly.setCls("x-btn-icon");  
		iconOnly.setTooltip("<b>Quick Tips</b><br/>Icon only button with tooltip");  
		
		toolbar.addButton(iconOnly);  
		toolbar.addSeparator();  
		toolbar.addButton(toggleButton);  
		
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
		ToolbarButton searchBtn = new ToolbarButton("Search");  
		searchBtn.setEnableToggle(true);
		searchBtn.setPressed(true);
		searchBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				search();
			}
		});
		toolbar.addButton(searchBtn);
		
		
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
		
		Panel toolbarPanel = new Panel();  
		toolbarPanel.setWidth(500);  
		toolbarPanel.setHeight(400);  
		 toolbarPanel.setTopToolbar(toolbar);  
		navpanel.add(toolbar);  
		
		 
	}	
	private void loginToSite(){
		RootPanel.get().clear();
		BorderPanel borderPanel = new BorderPanel();
		LoginWidget loginWidget = new LoginWidget();
		Panel panel = loginWidget.getLoginPanel();
		Button signupLbl = new Button("Sign up for my site");
		signupLbl.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				signup();
			}
		});
		panel.add(signupLbl);
	    borderPanel.addCenterPanel(panel);
		Panel mainPanel = borderPanel.getBorderPanel();
		
		
				
		
		//mainPanel.add(panel, new BorderLayoutData(RegionPosition.CENTER));
		RootPanel.get().add(mainPanel);
	}
	private void signup(){
		RootPanel.get().clear();
		SignUpPanel signUpPanel = new SignUpPanel();
		Panel panel = signUpPanel.getSignUpPanel();
		
		BorderPanel borderPanel = new BorderPanel();
		borderPanel.addCenterPanel(panel);
		
		RootPanel.get().add(borderPanel.getBorderPanel());
	}
	private void uploadFile(){
		Window.alert("Upload function here");
	}
	private void downloadFile(){
		Window.alert("Download function here");
	}
	private void search(){
		RootPanel.get().clear();
		SearchPanel searchPanel = new SearchPanel();
		Panel mainPanel = searchPanel.getSeachPanel();
		RootPanel.get().add(mainPanel);
	}
	public Panel getNavigation(){
		return navpanel;
	}
}
