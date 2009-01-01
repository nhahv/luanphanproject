package com.asnet.luanphan.client.UI;

import com.gwtext.client.widgets.Panel;

public class BottomPanel extends Panel{
	private Panel panel;
	public BottomPanel(){
		panel = new Panel();
		panel.setTitle("Google web toolkit");
		panel.setHtml("<p1>Author: Phan Tan Luan<p1>");
		panel.setHeight(50);
		panel.setClosable(true);
		panel.setCollapsible(true);
		panel.setCollapsed(true);
	}
	public Panel getBottomPanel(){
		return panel;
	}
}
