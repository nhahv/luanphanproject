package com.asnet.luanphan.client.UI;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.RegionPosition;
public class UploadPanel {
	private Panel uploadPanel;
	public UploadPanel(){
		uploadPanel = new Panel();
		uploadPanel.setBorder(false);
		uploadPanel.setPaddings(15);
		init();
	}
	private void init(){
		TopPanel topPanel = new TopPanel();
		uploadPanel.add(topPanel, new BorderLayoutData(RegionPosition.NORTH));
		Image image = new Image();
		image.setUrl("images/logodhdn.jpg");
		
		uploadPanel.add(image);
		
		Navigation navigation = new Navigation();
		Panel navPanel = navigation.getNavigation();
		uploadPanel.add(navPanel, new BorderLayoutData(RegionPosition.CENTER));
		
		com.gwtext.client.widgets.form.FormPanel form = new com.gwtext.client.widgets.form.FormPanel();
		form.setFileUpload(true);
		form.setFrame(true);
		
		final FormPanel formUpload = new FormPanel();
		
		formUpload.setAction(GWT.getModuleBaseURL());
		formUpload.setMethod(FormPanel.METHOD_POST);
		formUpload.setEncoding(FormPanel.ENCODING_MULTIPART);
		
		VerticalPanel mainPanel = new VerticalPanel();
		Button submitBtn = new Button("Submit");
		submitBtn.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e){
				formUpload.submit();
			}
		});
		mainPanel.add(submitBtn);
		
		
		final FileUpload fileUpload = new FileUpload();
		mainPanel.add(fileUpload);
		mainPanel.add(submitBtn);
		formUpload.add(mainPanel);
		formUpload.addFormHandler(new FormHandler(){
			public void onSubmit(FormSubmitEvent event){
				String filename = fileUpload.getFilename();
				if(filename.length()==0){
					MessageBox.alert("Please specify a file");
					event.setCancelled(true);
				}else if(!filename.endsWith(".txt")){
					MessageBox.alert("Only choose a file with '.txt' extention");
					event.setCancelled(true);
				}
			}
			public void onSubmitComplete(FormSubmitCompleteEvent event){
				
				CenterPanel centerPanel = new CenterPanel();
				Panel panel = centerPanel.getCenterPanel();
				RootPanel.get().add(panel);
			}
		});
		
		BorderLayoutData bld = new BorderLayoutData(RegionPosition.CENTER);
		bld.setMargins(15, 150, 0, 5);
		
		form.add(formUpload);
		uploadPanel.add(form);
		//uploadPanel.add(formUpload, bld);
	}
	public Panel getUploadPanel(){
		return uploadPanel;
	}
}
