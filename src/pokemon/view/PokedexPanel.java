package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class PokedexPanel extends JPanel
{
	private PokedexController appController;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox pokedexDropDown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		
		this.appController = appController;
		
		this.appLayout = new SpringLayout();
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		healthLabel = new JLabel("This pokemon health is");
		numberLabel = new JLabel("This pokemon number is");
		
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon attack level is");
		enhanceLabel = new JLabel("This pokemon enhancement level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("pokemon goes here");
		changeButton = new JLabel("Click here to change the pokevalues");
		pokedexDropDown = new JComboBox(); // stub
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.BLACK);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
