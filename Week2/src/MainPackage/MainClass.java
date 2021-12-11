package MainPackage;
import basicElements.*;
import twoDimensionalShape.*;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); 
		System.out.println("Δώσε τις συντεταγμένες του σημείου χωρισμένες με ένα κενό");
		String x_y = in.nextLine();
		String [] xy = x_y.split(" ");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		Point p=new Point(x,y);
		
		while(true)
		{
			System.out.println("Διάλαξε \"Κύκλος\" ή \"Ορθογώνιο\"");
			String shape = in.nextLine();
			if (shape.equals("Κύκλος"))
			{
				System.out.println("Δώσε την ακτίνα:");
				int radius = in.nextInt();
				Circle objCircle=new Circle(p,radius);
				System.out.println("Εμβαδόν κύκλου:"+objCircle.getArea());
				System.out.println("Κέντρο κύκλου:"+x + " " + y);
				break;
			}
			else if (shape.equals("Ορθογώνιο"))
			{
				System.out.println("Δώσε ύψος και πλάτος του ορθογωνίου χωρισμένα με ένα κενό");
				String height_width = in.nextLine();
				String [] hw = height_width.split(" ");
				double height = Double.parseDouble(hw[0]);
				double width = Double.parseDouble(hw[1]);
				Rectangle objRect=new Rectangle(p,width,height);
				System.out.println("Εμβαδόν Ορθογωνίου:"+objRect.getArea());
				System.out.println("Κάτω αριστερή γωνία ορθογωνίου: "+x + " " + y);
				break;
			}
			else
			{
				System.out.println("To σχήμα που δώσατε δεν υπάρχει.");
			}
		}
		in.close();
	}

}
