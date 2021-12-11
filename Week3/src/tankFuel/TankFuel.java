package tankFuel;
import java.lang.Math;
public class TankFuel {
	private final double gasolineTankCapacity;
	private double tankFuel;
	
	public TankFuel(double gasolineTankCapacity) throws InvalidTankCapacityException{
		if (gasolineTankCapacity <= 0.00d) throw new InvalidTankCapacityException("Tank capacity must be above zero.");
		else
		{
			this.gasolineTankCapacity = gasolineTankCapacity ;
			tankFuel = 0.0d;
		}
	}
	
	public double getTankFuel()
	{
		return this.tankFuel;
	}
	
	public double getTankCapacity() {
		return this.gasolineTankCapacity;
	}
	
	public void fuelTank(double fuelTempo) throws InvalidFuelTempoException , TankFuelException
	{
		if ((fuelTempo != 0.2) && (fuelTempo != 0.1)) throw new InvalidFuelTempoException("Sorry. Fuel tempo is not supported.");
		if (this.gasolineTankCapacity - fuelTempo <= Math.pow(10, -5)) throw new TankFuelException("Thank You.");
		if (this.gasolineTankCapacity - this.tankFuel<= Math.pow(10, -5)) throw new TankFuelException("Thank You.");
		else
		{
			this.tankFuel += fuelTempo;
		}
	}
	
}
