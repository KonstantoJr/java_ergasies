package twoDimensionalShape;
import basicElements.*;
public class Rectangle {
	Point pLeftDownCorner;
	private double width,height=0;
	public Rectangle(Point point,double w, double h){
		pLeftDownCorner=point;
		width=w;
		height=h;
	}
	public  double getArea() {
		return width*height;		
	}
	
}
