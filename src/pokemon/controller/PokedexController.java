package pokemon.controller;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pokemon.model.BellSprout;
import pokemon.model.Mareep;
import pokemon.model.Oshawott;
import pokemon.model.Piplup;
import pokemon.model.Pokemon;
import pokemon.model.Wooper;
import pokemon.model.Thatrick;
import pokemon.view.PokedexFrame;

public class PokedexController
{
	private String saveFile = "backup.pokemon";
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	
	private void addPokemon()
	{
		pokemonList.add(new BellSprout());
		pokemonList.add(new Mareep());
		pokemonList.add(new Oshawott());
		pokemonList.add(new Wooper());
		pokemonList.add(new Piplup());
		pokemonList.add(new Thatrick());
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] buildPokedexText()
	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	
	public boolean isInt(String maybeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "Yes Pokemon");
		}
		
		return isValid;
	}
	
	public boolean isDouble(String mightBeDouble)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(mightBeDouble);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null,  "yee");
		}
		
		return isValid;
	}
	
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
