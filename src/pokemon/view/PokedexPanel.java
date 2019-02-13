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
	
	private JLabel changeButton;
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
		pokedexDropDown = new JComboBox();
		
		
		setupDropDown();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupDropDown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(appController.buildPokedexText());
		pokedexDropDown.setModel(temp);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.add(healthField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		this.add(imageLabel);
		this.add(changeButton);
		this.add(pokedexDropDown);
		this.setBackground(Color.CYAN);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 79, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 36, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 139, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 245, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 38, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 43, SpringLayout.EAST, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -18, SpringLayout.WEST, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 158, SpringLayout.EAST, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 65, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 205, SpringLayout.EAST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 221, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 45, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 207, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -180, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 22, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 88, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 16, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 20, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropDown, -4, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropDown, 0, SpringLayout.EAST, nameLabel);
	}
	
	private void setupListeners()
	{
		
	}
}
