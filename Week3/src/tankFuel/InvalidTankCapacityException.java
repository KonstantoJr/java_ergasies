package tankFuel;

public class InvalidTankCapacityException extends Exception{

	private static final long serialVersionUID = 1L;
	public InvalidTankCapacityException(String str)
	{
		super(str);
	}

}
