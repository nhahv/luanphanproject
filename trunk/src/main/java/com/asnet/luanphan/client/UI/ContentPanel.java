package com.asnet.luanphan.client.UI;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class ContentPanel extends Panel{
	private Panel north;
	private Panel south;
	private Panel west;
	private Panel east;
	public ContentPanel(){
		init();
	
	}
	
	private void init(){
		north = new Panel();
		north.setId("north");
		north.setLayout(new HorizontalLayout(15));
		south = new Panel();
		south.setId("south");
		south.setLayout(new HorizontalLayout(15));
		west = new Panel();
		west.setId("west");
		west.setLayout(new VerticalLayout(15));
		east = new Panel();
		east.setId("east");
		west.setLayout(new VerticalLayout(15));
	}
	public void addToNorth(Panel panel){
		north.add(panel);
	}
}
