package com.asnet.luanphan.client;

import com.asnet.luanphan.client.UI.CenterPanel;
import com.asnet.luanphan.client.UI.LoginWidget;
import com.asnet.luanphan.client.UI.Navigation;
import com.asnet.luanphan.client.UI.TopPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.BorderLayoutData;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
	LoginWidget loginWidget = new LoginWidget();
	TopPanel topPanel = new TopPanel();
	Panel borderPanel = new Panel();
	CenterPanel centerPanel = new CenterPanel();
	static Panel navPanel = new Panel();
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() { 
	 navPanel = Navigation.getNavigation();
	 Panel contentPanel = centerPanel.getCenterPanel();
	 Panel loginPanel = loginWidget.getLoginPanel();
	 topPanel.setBorder(false);
	 borderPanel.add(topPanel, new BorderLayoutData(
				RegionPosition.NORTH));
	 RootPanel.get().add(borderPanel);
	 RootPanel.get().add(navPanel);
	 RootPanel.get().add(contentPanel);
     RootPanel.get().add(new Label ("My googlewebtoolkit demo"));
     RootPanel.get().add(loginPanel);
  }
}
