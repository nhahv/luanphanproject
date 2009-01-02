package com.asnet.luanphan.client;

import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.UI.BorderPanel;
import com.asnet.luanphan.client.UI.BottomPanel;
import com.asnet.luanphan.client.UI.CenterPanel;
import com.asnet.luanphan.client.datamodel.FileInfo;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentMgr;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
	private BorderPanel borderPanel;
	
	
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() { 
	 init(); 
     
  }
  public void init(){
	  
	 Panel panel = new Panel();  
	 panel.setBorder(false);  
	 panel.setPaddings(15);  
	 panel.setAutoScroll(true);    
	 //panel.setLayout(new FitLayout());  
	     
	 final Panel wrapperPanel = new Panel();  
	 wrapperPanel.setLayout(new RowLayout());  
	 wrapperPanel.setBorder(false);  
	 //wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");  
	 wrapperPanel.setAutoScroll(true);   
	
	 Panel firstPanel = new Panel();  
	 firstPanel.setTitle("My topic");  
	 firstPanel.setClosable(true);  
	 firstPanel.setHtml("<h1>Similarity detecting.</h1>");    
	 firstPanel.setCollapsible(true);
	 firstPanel.setCollapsed(false);    
	  
	
	     
	 wrapperPanel.add(firstPanel, new RowLayoutData(50));  
	     
	 Panel secondPanel = new Panel();  
	 secondPanel.setTitle("All tools I have to learn");  
	 secondPanel.setHtml("<h2>Maven<br>" +
			 			"Google Web Toolkit<br>" +
			 			"Spring<br>" +
			 			"VnTokenizer" +
			 			"Lucene<br></h2>");  
	 secondPanel.setId("greedy");  
	 secondPanel.setCollapsible(true);  
	 secondPanel.setAutoScroll(true);  
	 secondPanel.setBodyStyle("margin-bottom:10px");  
	 secondPanel.setCollapsed(true);    
	 wrapperPanel.add(secondPanel, new RowLayoutData("50%"));  
	 
	  
	 CenterPanel centerPanel = new CenterPanel();
	
	 Panel tokenizePanel = centerPanel.getCenterPanel();
	 Panel third = new Panel();  
	 third.setTitle("Demo something");  
	 third.setId("panel3");  
	 third.setCollapsible(true);	 
	 third.add(tokenizePanel);
	 wrapperPanel.add(third, new RowLayoutData(70));  
	  
	  
	 Panel fourth = new Panel();  
	 fourth.setTitle("Content");  
	 fourth.setHtml("Content");  
	 fourth.setId("bottom");  
	 wrapperPanel.add(fourth, new RowLayoutData(60));  
	 
	 panel.add(wrapperPanel);
	 borderPanel = new BorderPanel();
	 borderPanel.addCenterPanel(panel); 
	 Panel border = borderPanel.getBorderPanel();
	 RootPanel.get().add(border);
	 
  }

}
