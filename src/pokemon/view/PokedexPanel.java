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
	
	private JButton saveButton;
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
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		saveButton = new JButton("Save");
		this.appController = appController;
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass(). getResource("/pokemon/view/images/mareep.png"));
		
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
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		
		changeButton = new JButton("Click here to change the pokevalues");
		pokedexDropDown = new JComboBox<String>();
		
		setupDropDown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void updateFields(int index)
	{
		String [] data = appController.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
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
		
		this.add(saveButton);
		this.add(changeButton);
		this.add(pokedexDropDown);
		this.setBackground(Color.CYAN);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, evolveField, -345, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 17, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, 0, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 6, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -23, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 12, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -16, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 12, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 198, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -19, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -91, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 6, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 22, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 37, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, 29, SpringLayout.SOUTH, imageLabel);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, -508, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropDown, 1, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropDown, 6, SpringLayout.EAST, changeButton);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropDown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropDown.getSelectedItem().toString();
				changeImageDisplay(name);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.savePokedex();
			}
		});
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropDown.getSelectedIndex();
		
		if(appController.isInt(attackField.getText()) && appController.isDouble(enhancementField.getText()) && appController.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			appController.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path =  "/pokemon/view/images/";
		String defaultName = "mareep";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		
	
		
		repaint();
	}

}
