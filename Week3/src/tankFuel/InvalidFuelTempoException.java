package tankFuel;

public class InvalidFuelTempoException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidFuelTempoException (String str)
	{
		super(str);
	}

}
