package com.asnet.luanphan.client;

import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.UI.FooterPanel;
import com.asnet.luanphan.client.UI.HeaderPanel;
import com.asnet.luanphan.client.UI.LoginWidget;
import com.asnet.luanphan.client.UI.NavigationPanel;
import com.asnet.luanphan.client.UI.SearchPanel;
import com.asnet.luanphan.client.UI.SignUpPanel;
import com.asnet.luanphan.client.UI.TokenizePanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.layout.BorderLayoutData;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint, HistoryListener {
	public static Panel mainPanel;	
	public static Panel borderPanel;
	public static Panel headerPanel;
	public static Panel footerPanel;
	public static Panel centerPanel;
	public static Panel navigationPanel;
	public static LoginWidget loginPanel;
	public static SearchPanel searchPanel;
	public static TokenizePanel tokenizePanel;
	public static String oldToken;
	public static Panel signupPanel;
	public static Panel welcomePanel;
	public static Label welcomeLabel; 
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  mainPanel = new Panel();
	  borderPanel = new Panel();
	  headerPanel = new HeaderPanel();
	  centerPanel = new Panel();
	  footerPanel = new FooterPanel();
	  loginPanel = new LoginWidget();
	  tokenizePanel = new TokenizePanel();	  
	  signupPanel = new SignUpPanel();
	  welcomePanel = new Panel();	  
	  welcomeLabel = new Label();	
	  navigationPanel = new NavigationPanel();
	  searchPanel = new SearchPanel();
	  init();
	  History.addHistoryListener(this);
     
  }
  public void init(){
	  
	  
	  welcomeLabel.setStyle("font-size:13; color:blue;");
	  //create welcome string 	  
	  String sessionID = Cookies.getCookie("iid");	  
	  if ( sessionID != null ){
		  String[] strs = sessionID.split(";");
		  welcomeLabel.setText("Welcome, " + strs[0]);
		  final ApplicationServiceAsync createSession = Util.getInstance();
			ServiceDefTarget target = (ServiceDefTarget) createSession;

			String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
			target.setServiceEntryPoint(moduleRelativeURL);
			AsyncCallback callback = new AsyncCallback(){
				public void onFailure(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}
				public void onSuccess(Object arg0) {
					// TODO Auto-generated method stub
					
				}
			};
			createSession.createNewSession(strs[0], strs[1], callback);
	  }else
		  welcomeLabel.setText("Welcome");
	
	 
	  welcomePanel.setFrame(true);	  
	  welcomePanel.add(welcomeLabel);	  
	  //create history token	  
	  String initHistoryToken;
	  initHistoryToken =History.getToken();
	  if(initHistoryToken.length()==0)
		  initHistoryToken = "Home";
	  History.newItem(initHistoryToken);	  	
	  	
			
		
		

		// add top panel		
		headerPanel.setBorder(false);
		borderPanel.add(headerPanel);//, new BorderLayoutData(
				//RegionPosition.NORTH));
		
		
		
		centerPanel.setId("centerPanel");
		centerPanel.add(navigationPanel);
		centerPanel.add(welcomePanel);
		centerPanel.add(searchPanel);
		borderPanel.add(centerPanel);//, new BorderLayoutData(RegionPosition.CENTER));
		//footer
		
		BorderLayoutData bld = new BorderLayoutData(
				RegionPosition.SOUTH);
		bld.setMinSize(100);
		bld.setMaxSize(200);
		bld.setMargins(new Margins(0, 0, 0, 0));
		bld.setSplit(true);
		borderPanel.add(footerPanel);//, bld);
		
		
		mainPanel.setBorder(false);	
		mainPanel.add(borderPanel);
		RootPanel.get().add(mainPanel);
		
	
	 
  }
 
  public void onHistoryChanged(String historyToken) {	 
	  String newToken = History.getToken();
	 
	  if(oldToken!=null && newToken.equals(oldToken)) return;
	 
	  oldToken = newToken;
	  if(newToken.equals("download")){
		  NavigationPanel.downloadFile();		  
	  }
	  if(newToken.equals("upload")){
		  NavigationPanel.uploadFile();
		  
	  }	
	  if(newToken.equals("login")){
		  NavigationPanel.loginToSite();
	  }
	  if(newToken.equals("signup")){
		  NavigationPanel.signup();
	  }
	  if(newToken.equals("Home")){
		 NavigationPanel.goHome();
	  }
	  if(newToken.endsWith("demo")){
		  NavigationPanel.doDemo();
	  }
  }
}
