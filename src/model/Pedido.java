package model;

import java.util.ArrayList;
import java.util.List;

import entities.Alimento;
import enums.StatusPedido;

public class Pedido {

	private Integer numPedido;
	private String nomeCliente;
	private Double valorPedido = 0.0;
	private StatusPedido status;
	private List<Alimento> produtos = new ArrayList<>();
	
	public Pedido() {
		this.produtos = new ArrayList<>();
	    this.status = StatusPedido.AGUARDE;
	}

	public Pedido(Integer numPedido, String nomeCliente, Double valorPedido, Integer qtdProdutos, List<Alimento> produtos) {
		super();
		this.numPedido = numPedido;
		this.nomeCliente = nomeCliente;
		this.valorPedido = valorPedido;
		this.produtos = produtos;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public List<Alimento> getProdutos() {
		return produtos;
	}

	public void setProdutos(Alimento produto) {
		this.produtos.add(produto);
	}
	
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	
	
	
	
	//metodos
	


	public Integer getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}

	public Double valorComDesconto(Double valorCupom ,Double somaValorProdutos) {
		Double valorTotal = somaValorProdutos - (somaValorProdutos * (valorCupom / 100.0));
		
		return valorTotal;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("======= PEDIDO =======\n");
	    sb.append("Cliente: ").append(nomeCliente).append("\n");
	    sb.append("Status: ").append(status).append("\n");
	    sb.append("Quantidade de produtos: ").append(produtos.size()).append("\n");
	    sb.append("\n--- Produtos ---\n");

	    for (Alimento alimento : produtos) {
	        sb.append(alimento).append("\n");
	    }

	    sb.append("\nValor total do pedido: R$ ")
	      .append(String.format("%.2f", valorPedido))
	      .append("\n");

	    sb.append("======================");

	    return sb.toString();
	}

	
	
}
