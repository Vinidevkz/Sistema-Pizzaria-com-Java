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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nPizza:\n");
		sb.append("\nNome do produto: " + this.getNomeAlimento() + "\n");
		sb.append("Preço: " + this.getValorAlimento() + "\n");
		sb.append("Sabor: " + saborPizza.toString());

		return sb.toString();
	}
	
	
	
}
