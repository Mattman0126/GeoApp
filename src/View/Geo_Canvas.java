package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

import Res.*;

public class Geo_Canvas extends Canvas{
	
	public static int space = 10;
	public static int zero = 0;
	private int width, height;
	private boolean gridVisible = true;
	private Dimension maxSize;
	
	//private Graphics g = new Graphics();
	private ArrayList<Geo_Gridline> gridLines = new ArrayList<Geo_Gridline>();
	private ArrayList<Ellipse2D.Float> points = new ArrayList<Ellipse2D.Float>();
	

	public Geo_Canvas(int canvas_width, int canvas_height){
		this.width = canvas_width;
		this.height = canvas_height;
		maxSize = new Dimension(this.width, this.height);
		this.setBackground(Color.black);
		this.setMaximumSize(maxSize);
		
		gridLines = prepareGrid();
		
		
	}
	
	public void update(){
		repaint();
	}
	
	@Override	
	public void paint(Graphics g){
		//super.paint(g);
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		graphicSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphicSettings.setStroke(new BasicStroke(2));
		
		Iterator<Geo_Gridline> lineCounter = gridLines.iterator();
		Iterator<Ellipse2D.Float> pointCounter = points.iterator();
		
		
		
		if(gridLines != null){
			graphicSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
			
			for(Geo_Gridline l : gridLines){
				graphicSettings.setPaint(Color.gray);
				graphicSettings.draw(l);
			
			}
			//gridVisible = true;
		}//End Gridline loop
		
		if(points != null){
			
			graphicSettings.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
			
			for(Ellipse2D.Float p : points){
				graphicSettings.setPaint(Color.white);
				graphicSettings.draw(p);
				graphicSettings.fill(p);
				
			}
		}
		
		//graphicSettings.drawString("Hey", width/2, height/2);
	}//End overloaded Paint() method
	
	public ArrayList<Geo_Gridline> prepareGrid(){
		ArrayList<Geo_Gridline> lines = new ArrayList<Geo_Gridline>();
		float maxY = height;
		float maxX = width;
		//prepare vertical lines
		for(int i = 0; i < (width/space); i++){
			
			Geo_Gridline vertLine = new Geo_Gridline(zero + (i * space), zero, zero + (i * space), maxY);
			
			lines.add(vertLine);
		}
		
		//prepare horizontal lines
		for(int i = 0; i < (height/space); i++){
			Geo_Gridline horizontalLine = new Geo_Gridline(zero, zero + (i * space), maxX, zero + (i * space));
			
			lines.add(horizontalLine);
		}
		
		return lines;
	}//End prepareGrid()
	
	public void addPoint(Ellipse2D.Float p){
		System.out.println("New Point Added");
		this.points.add(p);
		
	}
	
	public void updatePoints(ArrayList<Ellipse2D.Float> new_points){
		points = new_points;
	}
	
	public void addCanvasMouseListener(MouseListener listenForMouse){
		this.addMouseListener(listenForMouse);
	}

	
	//public void fill

	/*
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Canvas was clicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
