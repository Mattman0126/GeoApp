package Controller;

import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import Model.*;
import Res.*;
import View.*;

public class Geo_Controller {
	
	private Geo_UI theUI;
	private Geo_Model theModel;
	
	
	public Geo_Controller(Geo_UI ui, Geo_Model model){
		this.theUI = ui;
		this.theModel = model;
		
		this.theUI.canvas.addMouseListener(new CanvasListener());
		
		
		//this.theUI.addCanvasListener(new CanvasListener());
		//this.theUI.prepareCanvas(model.gridLines);
		//this.theUI.canvas.paint(g, model.gridLines);
	}
	
	public float roundX(float x){
		if(x % 10 > 5){
			x = x + (10 - (x % 10));
		}
		else if(x % 10 <= 5){
			x = x - (x % 10);
		}
		
		return x;
	}
	
	public float roundY(float y){
		if(y % 10 > 5){
			y = y + (10 - (y % 10));
		}
		else if(y % 10 <= 5){
			y = y - (y % 10);
		}
		
		return y;
	}
	
	public ArrayList<Ellipse2D.Float> shapeExtractor(ArrayList<Geo_Points> fresh_points){
		ArrayList<Ellipse2D.Float> extracted_points = new ArrayList<Ellipse2D.Float>();
		for(Geo_Points p : fresh_points){
			extracted_points.add(p.getShape());
		}
		
		return extracted_points;
	}
	class CanvasListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//System.out.println("Canvas was clicked");
			//System.out.println("Canvas clicked: X: " + e.getX() + ", Y: " + e.getY());
			Geo_Points newPoint = new Geo_Points(roundX(e.getX()), roundY(e.getY()));
			theModel.addPoint(newPoint);
			theUI.canvas.updatePoints(shapeExtractor(theModel.getPoints()));
			theUI.canvas.update();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
