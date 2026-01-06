package model;

import entities.Alimento;
import enums.SaboresPizza;

public final class Pizza extends Alimento {

	private SaboresPizza saborPizza;


	
	public Pizza() {
	}

	public Pizza(String nomeAlimento, Double valorAlimento, SaboresPizza saborPizza) {
		super(nomeAlimento, valorAlimento);
		this.saborPizza = saborPizza;
	}

	public SaboresPizza getSaborPizza() {
		return saborPizza;
	}

	public void setSaborPizza(SaboresPizza saborPizza) {
		this.saborPizza = saborPizza;
	}
	
	
	
}
