package com.asnet.luanphan.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.widgets.Panel;




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
		Image image = new Image();
		image.setUrl("images/logodhdn.jpg");
		image.setWidth("1010px");
		HorizontalPanel imagePanel = new HorizontalPanel();
		imagePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		imagePanel.add(image);
		this.add(titlePanel);
		this.add(imagePanel);
	}
}
