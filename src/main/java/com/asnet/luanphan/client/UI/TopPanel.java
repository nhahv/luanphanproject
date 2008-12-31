package com.asnet.luanphan.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.widgets.Panel;

public class TopPanel extends Panel {
	
	public static final Images images = (Images) GWT
	.create(Images.class);
    
	public TopPanel() {	   
	   this.setHeight(70); 	   
	   
	   String pageTitle = "<h1>" + "My Google Web Tookit Demo" + "</h1><h2>"
		+ "Luan Phan" + "</h2>";

	   // Add the title and some images to the title bar
	   HorizontalPanel titlePanel = new HorizontalPanel();
	   titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	   titlePanel.add(images.gwtLogo().createImage());
	   titlePanel.add(new HTML(pageTitle));
	   
	   this.add(titlePanel);
	   
	   
	}
	

	
}

