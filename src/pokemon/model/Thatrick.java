package pokemon.model;
import javax.swing.JOptionPane;

public class Thatrick extends Pokemon implements Psychic
{
	public Thatrick()
	{
		super(9999, "Thatrick");
	}
	
	public Thatrick(String name)
	{
		super(9999, name);
	}
	
	public Thatrick(int num, String name)
	{
		super(num, name);
	}
	
	public void snap()
	{
		for (int index = 0; index < 10; index++)
		{
			JOptionPane.showMessageDialog(null, "You should've aimed for the head.");
		}
	}
	
	public int joshAttack()
	{
		return 999 * 12345;
	}
}
