package com.asnet.luanphan.client.UI;

import org.junit.Test;

import com.google.gwt.user.client.ui.RootPanel;


public class TestUI {
	@Test
	public void headerTest() throws Exception {
		HeaderPanel headerPanel = new HeaderPanel();
		RootPanel.get().add(headerPanel);
	}
}
