package Res;

import java.awt.geom.*;

public class Geo_Points extends Point2D.Float{
	
	private Ellipse2D.Float point;
	
	public Geo_Points(float x, float y){
		this.x = x;
		this.y = y;
		
		this.point = new Ellipse2D.Float(x - 1, y - 1, 1, 1);
	}
	
	public Ellipse2D.Float getShape(){
		return point;
	}
	


}
