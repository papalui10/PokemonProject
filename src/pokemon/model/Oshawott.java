package pokemon.model;

public class Oshawott extends Pokemon implements WaterType
{
	public Oshawott(int num, String pokename)
	{
		super(num,pokename);
	}
	
	public void waterSplash()
	{
		
	}
	
	public void rainSplash()
	{
		
	}
	
	public Oshawott()
	{
		super(501, "Oshawott");
	}
	
	public Oshawott(String name)
	{
		super(501, name);
	}
}
