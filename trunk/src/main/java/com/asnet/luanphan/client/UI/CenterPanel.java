package com.asnet.luanphan.client.UI;




import com.gwtext.client.widgets.Panel;
import com.gwtext.client.core.EventObject;  
import com.gwtext.client.core.RegionPosition;  
import com.gwtext.client.widgets.Button;  
import com.gwtext.client.widgets.TabPanel;  
import com.gwtext.client.widgets.Window;  
import com.gwtext.client.widgets.event.ButtonListenerAdapter;  
import com.gwtext.client.widgets.layout.BorderLayout;  
import com.gwtext.client.widgets.layout.BorderLayoutData; 
public class CenterPanel extends Panel{
	private Panel panel = new Panel();
	public CenterPanel(){
		initCenterPanel();
	}
	public void initCenterPanel(){
		  
	    panel.setBorder(false);  
	    panel.setPaddings(15);  
	      
	     //center panel  
	    TabPanel tabPanel = new TabPanel();  
	    tabPanel.setActiveTab(0);  
	      
	    Panel allTokens = new Panel();  
	    allTokens.setTitle("All Tokens");  
	    allTokens.setHtml(getBogusMarkup());  
	    allTokens.setAutoScroll(true);  
	      
	    Panel removeStopword = new Panel();  
	    removeStopword.setTitle("Remove Stopword");  
	    removeStopword.setHtml(getBogusMarkup());  
	    removeStopword.setAutoScroll(true);  
	   
	      
	    tabPanel.add(allTokens);  
	    tabPanel.add(removeStopword);  
	   
	      
	            //west panel  
	    Panel navPanel = new Panel();  
	    navPanel.setTitle("File content");
	    
		navPanel.setHtml(getBogusMarkup());
		
		Button loadbtn = new Button("LoadFile");
		navPanel.setTopToolbar(loadbtn);
	    navPanel.setWidth(200);  
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
	      
	    Button button = new Button("Tokenize");  
	    button.addListener(new ButtonListenerAdapter() {  
	    	public void onClick(Button button, EventObject e) {  
	    		window.show(button.getId());  
	    	}  
	    });  
	    panel.add(button);  
	    	    
	}
	
	public Panel getCenterPanel(){
		return panel;
	}
	private static String getBogusMarkup() {  
		return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +  
		"Sed metus nibh, sodales a, porta at, vulputate eget, dui.  " +  
		"In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, " +  
		"cursus a, fringilla vel, urna.";  
	}  
}
