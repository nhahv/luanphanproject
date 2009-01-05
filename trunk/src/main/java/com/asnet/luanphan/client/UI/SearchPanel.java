package com.asnet.luanphan.client.UI;

import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.BorderLayoutData;
public class SearchPanel extends Panel{
	public SearchPanel(){		
		init();
	}
	private void init(){		
		Image icon = new Image();
		icon.setUrl("images/covw.jpg");
		
		
		FormPanel formPanel = new FormPanel();
		formPanel.setBorder(true);
		formPanel.setFrame(true);
		formPanel.setPaddings(40);		
		formPanel.setLabelWidth(75);
		formPanel.add(icon, new BorderLayoutData(RegionPosition.CENTER));
		
		final TextField txtField = new TextField("Search","search",500);
		txtField.setId("searchQuery");
		txtField.setHideLabel(true);
		txtField.setHeight(25);
		formPanel.add(txtField);
		
		
		Button searchBtn = new Button("Seach my site");
		searchBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button buton, EventObject e){
				String query = txtField.getText();
				MessageBox.alert("Search query's '" + query + "', but search function hasn't been completed yet!");
			}
		});		
		formPanel.add(searchBtn);
		formPanel.setMargins(0, 210, 0, 0);
		this.setBorder(true);				
		this.add(formPanel);		
	}	
}
