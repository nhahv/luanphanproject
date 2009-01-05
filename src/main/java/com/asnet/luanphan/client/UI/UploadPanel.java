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
public class UploadPanel extends Panel{
	public UploadPanel(){
		this.setBorder(false);
		init();
	}
	private void init(){		
		com.gwtext.client.widgets.form.FormPanel form = new com.gwtext.client.widgets.form.FormPanel();
		form.setFileUpload(true);
		form.setFrame(true);
		
		final FormPanel formUpload = new FormPanel();
		
		formUpload.setAction(GWT.getModuleBaseURL() + "upload");
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
				
				TokenizeWidget centerPanel = new TokenizeWidget();
				Panel panel = centerPanel.getCenterPanel();
				panel.setBorder(true);
				RootPanel.get().add(panel);
			}
		});		
		form.add(formUpload);
		this.add(form);
		
	}
}
