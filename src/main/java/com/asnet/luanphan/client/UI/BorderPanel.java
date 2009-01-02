package com.asnet.luanphan.client.UI;

import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.LayoutData;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class BorderPanel {
	private Panel panel;
	private Panel centerPanel; 
	public BorderPanel(){
		panel = new Panel();
		centerPanel = new Panel();
		initPanel();
	}
	private void initPanel(){
		TopPanel topPanel = new TopPanel();
		panel.add(topPanel, new BorderLayoutData(RegionPosition.NORTH));
		
		Image image = new Image();
		image.setUrl("images/logodhdn.jpg");
		Panel imagePanel = new Panel();
		imagePanel.add(image);
		addCenterPanel(imagePanel);
		
		Navigation navigation = new Navigation();
		Panel navPanel = navigation.getNavigation();
		panel.add(navPanel, new BorderLayoutData(RegionPosition.CENTER));
		
		
		
		
		centerPanel.setId("centerPanel");
		panel.add(centerPanel,new BorderLayoutData(RegionPosition.CENTER));
		
		BottomPanel bottomPanel = new BottomPanel();
		Panel btmPanel = bottomPanel.getBottomPanel();
		panel.add(btmPanel, new BorderLayoutData(RegionPosition.SOUTH));
	}
	public Panel getBorderPanel(){
		return panel;
	}
	public void addCenterPanel(Panel panel){
		this.centerPanel.add(panel);		
	}
}
