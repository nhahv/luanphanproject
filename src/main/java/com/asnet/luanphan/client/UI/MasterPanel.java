package com.asnet.luanphan.client.UI;

import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.BorderLayoutData;

public class MasterPanel extends Panel{
	private HeaderPanel headerPanel;
	private NavigationPanel navigationPanel;
	private ContentPanel contentPanel;
	private FooterPanel footerPanel;
	public MasterPanel(){
		init();
	}
	private void init(){
		this.setId("masterPanel");
		headerPanel = new HeaderPanel();
		navigationPanel = new NavigationPanel();
		contentPanel = new ContentPanel();
		contentPanel.setAutoWidth(true);
		footerPanel = new FooterPanel();
		this.add(headerPanel, new BorderLayoutData(RegionPosition.NORTH));
		this.add(navigationPanel, new BorderLayoutData(RegionPosition.CENTER));
		this.add(contentPanel, new BorderLayoutData(RegionPosition.CENTER));
		this.add(footerPanel, new BorderLayoutData(RegionPosition.SOUTH));
		
	}
	public void addToContentPanel(Panel panel){
		contentPanel.addToNorth(panel);
	}
}
