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
}
