package com.asnet.luanphan.client;

import com.asnet.luanphan.client.UI.FooterPanel;
import com.asnet.luanphan.client.UI.HeaderPanel;
import com.asnet.luanphan.client.UI.LoginWidget;
import com.asnet.luanphan.client.UI.NavigationPanel;
import com.asnet.luanphan.client.UI.SearchPanel;
import com.asnet.luanphan.client.UI.TokenizePanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.layout.BorderLayoutData;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
	public static Panel mainPanel;	
	public static Panel borderPanel;
	public static Panel headerPanel;
	public static Panel footerPanel;
	public static Panel centerPanel;
	public static Panel navigationPanel;
	public static LoginWidget loginPanel;
	public static SearchPanel searchPanel;
	public static TokenizePanel tokenizePanel;
	
	
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() { 
	  loginPanel = new LoginWidget();
	  tokenizePanel = new TokenizePanel();
	  
	  
	  
	 init(); 
     
  }
  public void init(){
	  	mainPanel = new Panel();
		mainPanel.setBorder(false);		
		//mainPanel.setLayout(new FitLayout());
		borderPanel = new Panel();
		//borderPanel.setLayout(new BorderLayout());

		// add top panel
		headerPanel = new HeaderPanel();
		headerPanel.setBorder(false);
		borderPanel.add(headerPanel, new BorderLayoutData(
				RegionPosition.NORTH));
		//navigation
		navigationPanel = new NavigationPanel();
		//Search
		searchPanel = new SearchPanel();
		centerPanel = new Panel();
		centerPanel.setId("centerPanel");
		centerPanel.add(navigationPanel);
		centerPanel.add(searchPanel);
		borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));
		//footer
		footerPanel = new FooterPanel();
		BorderLayoutData bld = new BorderLayoutData(
				RegionPosition.SOUTH);
		bld.setMinSize(100);
		bld.setMaxSize(200);
		bld.setMargins(new Margins(0, 0, 0, 0));
		bld.setSplit(true);
		borderPanel.add(footerPanel, bld);
		
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
	
	 
  }

}
