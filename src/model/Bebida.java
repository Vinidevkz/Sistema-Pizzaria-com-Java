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
	
	
	

	
	
}
