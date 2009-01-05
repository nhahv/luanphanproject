package com.asnet.luanphan.client.UI;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtextux.client.widgets.image.Image;



public class HeaderPanel extends Panel{
	public static final Images images = (Images) GWT
	.create(Images.class);
	public HeaderPanel(){
		init();
	}
	private void init(){
		this.setId("headerPanel");
		String pageTitle = "<h1>AsnetCompany---" + "Luan Phan's Google Web Tookit Demo" + "</h1><h2>"
			 + "</h2>";

		// Add the title and some images to the title bar
		HorizontalPanel titlePanel = new HorizontalPanel();
		titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		titlePanel.add(images.gwtLogo().createImage());
		titlePanel.add(new HTML(pageTitle));
		Image image = new Image("Da Nang University", "images/logodhdn.jpg");
		image.setWidth(1010);
		HorizontalPanel imagePanel = new HorizontalPanel();
		imagePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		imagePanel.add(image);
		this.add(titlePanel);
		this.add(imagePanel);
	}
}
