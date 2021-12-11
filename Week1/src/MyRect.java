
public class MyRect {
	private float x = 0 , y = 0;
	private float width = 1 , height = 1;
	private static int numberofrect = 0;
	
	MyRect(float px , float py , float w , float h){
		x = px;
		y = py;
		width = w;
		height = h;
		numberofrect ++;
	}
	
	public boolean contains (float sx , float sy){
		boolean res = false;
		if (sx< width + x && sx > x ) {
			if (sy < height + y && sy > y) {
				res = true;
			}
		}			
		return res;
	}
	
	public double getarea() {
		return width * height;
	}
	
	public double getperimeter() {
		return 2 * width + 2 * height;
	}
	
	static void printnumberofRect() {
		System.out.println(numberofrect);
	}
	
	
	
	
	
}