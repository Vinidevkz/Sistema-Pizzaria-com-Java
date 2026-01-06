package model;

import entities.Alimento;
import enums.SaboresBebida;

public final class Bebida extends Alimento {
	
	private SaboresBebida saborBebida;
	
	public Bebida() {
		
	}

	public Bebida(String nomeAlimento, Double valorAlimento, SaboresBebida saborBebida) {
		super(nomeAlimento, valorAlimento);
		this.saborBebida = saborBebida;
	}

	public SaboresBebida getSaborBebida() {
		return saborBebida;
	}

	public void setSaborBebida(SaboresBebida saborBebida) {
		this.saborBebida = saborBebida;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nNome do produto: " + this.getNomeAlimento() + "\n");
		sb.append("Preço: " + this.getValorAlimento() + "\n");
		sb.append("Sabor: " + saborBebida.toString());

		return sb.toString();
	}
	
	
	
	
	

	
	
}
