import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Δώσε ύψος και πλάτος του ορθογωνίου.");
		
		String height_width = input.nextLine();
		String [] arrofHW = height_width.split(" ");
		Float height = Float.parseFloat(arrofHW[0]);
		Float width = Float.parseFloat(arrofHW[1]);
		System.out.println("Δώσε τις συντεταγμένες της κάτω αριστερής γωνίας του ορθογωνίου.");
		String x_y = input.nextLine();
		String [] arrofXY = x_y.split(" ");
		Float x = Float.parseFloat(arrofXY[0]);
		Float y = Float.parseFloat(arrofXY[1]);
		
		//System.out.println(String.format("%f %f %f %f",height , width , x , y));
		MyRect objRect = new MyRect(x , y , width , height );
		
		System.out.println(String.format("Το ορθογώνιο που ορίσατε έχει περίμετρο %f και εμβαδόν %f \n"
				+ "Δώστε τις συντεταγμένες (x,y) που θέλετε να ελέγξετε αν ανήκουν μέσα στο ορθογώνιο", objRect.getperimeter() , objRect.getarea()));
		String px_py = input.nextLine();
		String [] arrofPXPY = px_py.split(" ");
		Float px = Float.parseFloat(arrofPXPY[0]);
		Float py = Float.parseFloat(arrofPXPY[1]);
		if (objRect.contains(px, py)) {
			System.out.println("IN");
		}
		else {
			System.out.println("OUT");
		}
		input.close();
		System.out.println("Τα αντικείμενα της κλάσης MyRect είναι:");
		MyRect.printnumberofRect();
		
		
	}

}
