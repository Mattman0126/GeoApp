package Res;

import java.awt.geom.*;

public class Geo_Gridline extends Line2D.Float{
	
	public Geo_Gridline(float x1, float y1, float x2, float y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Geo_Gridline(Point2D p1, Point2D p2){
		//point 1
		this.x1 = (float) p1.getX();
		this.y1 = (float) p1.getY();
		//point 2
		this.x2 = (float) p2.getX();
		this.x2 = (float) p2.getY();
	}

}
