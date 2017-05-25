package Model;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import Res.*;

public class Geo_Model {

	public ArrayList<Geo_Points> points = new ArrayList<Geo_Points>();
	//public ArrayList<Geo_Gridline> drawnLines = new ArrayList<Geo_Gridline>();
	
	public void addPoint(Geo_Points newPoint){
		points.add(newPoint);
	}
	
	public Geo_Points addPoint(float x, float y){
		points.add(new Geo_Points(x, y));
		return new Geo_Points(x, y);
	}
	
	public ArrayList<Geo_Points> getPoints(){
		return points;
	}
}
