package com.asnet.luanphan.client;

import com.asnet.luanphan.client.UI.BorderPanel;
import com.asnet.luanphan.client.UI.BottomPanel;
import com.asnet.luanphan.client.UI.CenterPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import com.gwtext.client.widgets.Panel;



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
	  CenterPanel centerPanel = new CenterPanel();
	  Panel center = centerPanel.getCenterPanel();
	  borderPanel = new BorderPanel();
	  borderPanel.addCenterPanel(center);
	  Panel border = borderPanel.getBorderPanel();
	  RootPanel.get().add(border);
  }
}
