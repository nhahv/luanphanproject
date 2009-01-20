package com.asnet.luanphan.client.UI;




import com.asnet.luanphan.client.ApplicationServiceAsync;
import com.asnet.luanphan.client.ApplicationService.Util;
import com.asnet.luanphan.client.datamodel.FileInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
public class TokenizePanel extends Panel{
	private String filename ="no file to tokenize";
	private String listLexer ="There is no Lexer";
	private String listVnToken = "There is no vntoken";
	private String fileContent="no content";
	public TokenizePanel(){
		initCenterPanel();
	}
	public void initCenterPanel(){
		
		
		this.setBorder(false);  
	    this.setPaddings(15);  
	    
	    final Button button = new Button("Demo VnTokenize and Lucene");  
	    button.addListener(new ButtonListenerAdapter() {  
	    	public void onClick(Button button1, EventObject e) {
	    		
	    		final ApplicationServiceAsync demoService = Util.getInstance();
					ServiceDefTarget target = (ServiceDefTarget) demoService;
					String moduleRelativeURL = GWT.getModuleBaseURL() + "applicationService";
					target.setServiceEntryPoint(moduleRelativeURL);
					
					final AsyncCallback<FileInfo> callback = new AsyncCallback<FileInfo>() {
						public void onSuccess(FileInfo result) {
							setFilename(result.getFileName());
							setListLexer(result.getListLexers());
							setListVnTokens(result.getListVnTokens());	
							setFileContent(result.getFileContent());
							//center panel  
						    TabPanel tabPanel = new TabPanel();  
						    tabPanel.setActiveTab(0);  
						      
						    Panel allTokens = new Panel();  
						    allTokens.setTitle("All Tokens");  
						    allTokens.setHtml(listLexer);  
						    allTokens.setAutoScroll(true);  
						      
						    Panel removeStopword = new Panel();  
						    removeStopword.setTitle("Remove Stopword");  
						    removeStopword.setHtml(listVnToken);  
						    removeStopword.setAutoScroll(true);  
						   
						      
						    tabPanel.add(allTokens);  
						    tabPanel.add(removeStopword);  
						   
						      
						            //west panel  
						    Panel navPanel = new Panel();  
						    navPanel.setTitle("File content");
						    
							navPanel.setHtml(filename + "<br>" + fileContent);
							
							
							
						    navPanel.setWidth(350);  
						    navPanel.setCollapsible(false);  
						      
						    BorderLayoutData centerData = new BorderLayoutData(RegionPosition.CENTER);  
						    centerData.setMargins(3, 0, 3, 3);  
						      
						    BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);  
						    westData.setSplit(true);  
						    westData.setMargins(3, 3, 0, 3);  
						    westData.setCMargins(3, 3, 3, 3);  
						      
						         
					        
						    
						    final Window window = new Window();  
						    window.setTitle("Simple tokenizer");  
						    window.setClosable(true);  
						    window.setWidth(600);  
						    window.setHeight(350);  
						    window.setPlain(true);  
						    window.setLayout(new BorderLayout());  
						    window.add(tabPanel, centerData);  
						    window.add(navPanel, westData);
						    window.setCloseAction(Window.HIDE);
						    window.show(button.getId()); 	   				
						}

						public void onFailure(Throwable caught) {
							MessageBox.alert("Call rpc unsuccessful");
							GWT.log("Error:", caught);
						}
					};
					demoService.demo(callback);
					 
	    	}  
	    }); 
	       
	         
	    Panel main = new Panel();
	    main.setFrame(true);
	    main.setLayout(new HorizontalLayout(5));
	    
	    TabPanel tabPanel = new TabPanel();
	    tabPanel.setHeight(300);
	    tabPanel.setWidth(450);
	    tabPanel.setActiveItem(0);
	    
	    Panel panel1 = new Panel();
	    panel1.setTitle("All tokens");
	    
	    TextField allField = new TextField();
	    allField.setHeight(300);
	    allField.setAutoHeight(true);
	    panel1.add(allField);
	    
	    Panel panel2 = new Panel();
	    panel2.setTitle("Remove stopwords");
	    
	    TextField remField = new TextField();
	    remField.setHeight(300);
	    remField.setAutoHeight(true);
	    panel2.add(remField);
	    
	    tabPanel.add(panel1);
	    tabPanel.add(panel2);
	    
	    
	    Panel panel = new Panel();	   
	    panel.setBorder(false);  
	    panel.setPaddings(15);  
	       
	    FormPanel formPanel = new FormPanel();  
	    formPanel.setFrame(true);  
	    formPanel.setTitle("Content");  
	    formPanel.setPaddings(5, 5, 5, 0);  
	    formPanel.setWidth(460);  
	    formPanel.setLabelAlign(Position.TOP);  
	  
	  
	    //add a HtmlEditor below the 2-column top panel  
	    HtmlEditor htmlEditor = new HtmlEditor("Biography", "bio");  
	    htmlEditor.setHeight(100);  
	     formPanel.add(htmlEditor, new AnchorLayoutData("98%"));  
	      
	            //add a couple of buttons to the form  
	    formPanel.addButton(new Button("Tokenize"));   
	    panel.add(formPanel); 	   
	   
	    
	    main.add(panel);
	    main.add(tabPanel);
	    this.add(main);
	    this.add(button); 
	    
	     
	      
	    	    
	}
	public void setFileContent(String fileContent){
		this.fileContent = fileContent;
	}
	public void setFilename(String filename){
		this.filename = filename;
	}
	public void setListLexer(String listLexer){
		this.listLexer = listLexer;
	}
	public void setListVnTokens(String listVnTokens){
		this.listVnToken = listVnTokens;
	}
}
