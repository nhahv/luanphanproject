package com.asnet.luanphan.client.UI;

import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.core.EventObject;
public class SearchPanel {
	private Panel searchPanel;
	public SearchPanel(){
		searchPanel = new Panel();
		init();
	}
	private void init(){
		TopPanel topPanel = new TopPanel();
		searchPanel.add(topPanel, new BorderLayoutData(RegionPosition.NORTH));
		Image image = new Image();
		image.setUrl("images/logodhdn.jpg");
		
		searchPanel.add(image);
		
		Image icon = new Image();
		icon.setUrl("images/covw.jpg");
		searchPanel.add(icon);
		
		FormPanel formPanel = new FormPanel();
		formPanel.setBorder(true);
		formPanel.setFrame(true);
		formPanel.setPaddings(40);
		formPanel.setWidth(600);
		formPanel.setLabelWidth(75);
		
		
		formPanel.add(icon, new BorderLayoutData(RegionPosition.CENTER));
		
		TextField txtField = new TextField("Search","search",500);
		txtField.setHideLabel(true);
		txtField.setHeight(25);
		formPanel.add(txtField);
		
		
		Button searchBtn = new Button("Seach my site");
		
		searchBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button buton, EventObject e){
				MessageBox.alert("Search function's here but this hasn't been completed yet!");
			}
		});
		
		formPanel.add(searchBtn);
		Panel panel = new Panel();
		panel.setBorder(false);
		panel.setWidth(600);
		panel.setMargins(5, 100, 0, 50);
		panel.add(icon);
		panel.add(formPanel);
		
		
		
		Navigation navigation = new Navigation();
		Panel navPanel = navigation.getNavigation();
		searchPanel.add(navPanel, new BorderLayoutData(RegionPosition.CENTER));
		
		BorderLayoutData bld = new BorderLayoutData(RegionPosition.CENTER);
		bld.setMargins(5, 100, 5, 5);
		searchPanel.add(panel, bld);
		
		
		BottomPanel bottomPanel = new BottomPanel();
		Panel btmPanel = bottomPanel.getBottomPanel();
		searchPanel.add(btmPanel, new BorderLayoutData(RegionPosition.SOUTH));
	}
	public Panel getSeachPanel(){
		return searchPanel;
	}
	
}
