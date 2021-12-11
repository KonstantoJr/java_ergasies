package mainclass;
import tankFuel.*;

public class MainClass {
	public static void main(String[] args)
	{
		boolean fillTank = true;
		double fuelTempo = 0.2;
		
		TankFuel myTank = null;
		try {
			myTank = new TankFuel(50);
		} catch (InvalidTankCapacityException ex) {
			System.out.println(ex.getMessage());
			fillTank = false;
		}
		
		while (fillTank)
		{
			try 
			{
				myTank.fuelTank(fuelTempo);
			}
			catch (InvalidFuelTempoException ex) {
				fillTank = false;
				System.out.println(ex.getMessage());
			}
			catch (TankFuelException ex) {
				fillTank = false;
				System.out.println(ex.getMessage());
			}
		}
		if (myTank != null)
		{
			String sf1 = String.format("%1.2f",myTank.getTankFuel());
			System.out.println(sf1);
			myTank = null;
		}
	}
}
