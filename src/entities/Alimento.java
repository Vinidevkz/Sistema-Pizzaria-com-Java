package entities;

public abstract class Alimento {
	
	private String nomeAlimento;
	private Double valorAlimento;
	
	
	public Alimento() {
		
	}

	public Alimento(String nomeAlimento, Double valorAlimento) {
		super();
		this.nomeAlimento = nomeAlimento;
		this.valorAlimento = valorAlimento;
	}

	public String getNomeAlimento() {
		return nomeAlimento;
	}

	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}

	public Double getValorAlimento() {
		return valorAlimento;
	}

	public void setValorAlimento(Double valorAlimento) {
		this.valorAlimento = valorAlimento;
	}


	
	

}
