package pokemon.model;

public class Mareep extends Pokemon implements ElectricType
{
	public Mareep(int num, String pokename)
	{
		super(num,pokename);
	}
	
	public int thunderJolt()
	{
		return 5;
	}
	
	public int staticShock()
	{
		return 10;
	}
	
	public Mareep()
	{
		super(179, "Mareep");
	}
	
	public Mareep(String name)
	{
		super(179, name);
	}
	
}
