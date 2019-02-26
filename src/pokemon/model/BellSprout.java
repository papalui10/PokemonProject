package pokemon.model;

public class BellSprout extends Pokemon implements GrassType
{
	public BellSprout(int num, String pokeName)
	{
		super(num,pokeName);
	}
	
	public int vineWhip()
	{
		return 5;
	}
	
	public int tackel()
	{
		return 5;
	}
	
	public BellSprout()
	{
		super(69, "BellSprout");
	}
	
	public BellSprout(String name)
	{
		super(69, name);
	}
}
