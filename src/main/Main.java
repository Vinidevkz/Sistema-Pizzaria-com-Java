package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Alimento;
import enums.SaboresBebida;
import enums.SaboresPizza;
import enums.StatusPedido;
import model.Bebida;
import model.Pedido;
import model.Pizza;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Pedido> pedidos = new ArrayList<>();
		
		int opc = 0;
		
		while(opc != 5) {
			System.out.println("\n-------Sistema da Pizzaria Vini's-------\n");
			System.out.println("Menu: \n# 1 -> Criar um novo pedido\n# 2 -> Ver pedidos em aberto\n# 3 -> Concluir um pedido\n# 4 -> Excluir um pedido\n# 5 -> Sair");
			System.out.print("Selecione uma opção: ");
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
			case(1):
				criarPedido(pedidos);
			case(2):
				verPedidos(pedidos);
			case(3):
				concluirPedido(pedidos);
			case(4):
				excluirPedido(pedidos);
			}
		}

	}
	
	public static void criarPedido(List<Pedido> pedidos) {
		Scanner sc = new Scanner(System.in);
		
		Pedido pedido = new Pedido();
		pedidos.add(pedido);
		

		
		Boolean isFinalizado = false;
		
		while(!isFinalizado) {
			try{
				System.out.print("Digite o nome do cliente: ");
				String nomeCliente = sc.nextLine();
				
				System.out.println("Digite quantos produtos serão adicionados: ");
				int numeroProdutos = sc.nextInt();
				sc.nextLine();
				
				for(int i = 1; i <= numeroProdutos; i++) {
					
					System.out.println("\nProduto n° " + i);
					System.out.print("Que tipo de produto deseja adicionar? (p = pizza/ b = bebida):");
					char tipoProduto = sc.nextLine().charAt(0);
					
					if(tipoProduto == 'p') {
						System.out.println("Qual o nome da pizza?: ");
						String nomePizza = sc.nextLine();
						
						System.out.println("Qual o preço dela?: ");
						Double precoPizza = sc.nextDouble();
						sc.nextLine();
						
						System.out.println("Qual o sabor da pizza?: ");
						String sabor = sc.nextLine();
						
						SaboresPizza saborPizza = SaboresPizza.valueOf(sabor.toUpperCase());
						
						Pizza pizza = new Pizza(nomePizza, precoPizza, saborPizza);
						
						
						pedido.setProdutos(pizza);
					}else if(tipoProduto == 'b') {
						System.out.println("Qual o nome da bebida?: ");
						String nomeBebida = sc.nextLine();
						
						System.out.println("Qual o preço dela?: ");
						Double precoBebida = sc.nextDouble();
						sc.nextLine();
						
						System.out.println("Qual o sabor da bebida?: ");
						String sabor = sc.nextLine();
						
						SaboresBebida saborBebida = SaboresBebida.valueOf(sabor.toUpperCase());
						
						Bebida bebida = new Bebida(nomeBebida, precoBebida, saborBebida);
						
					}
				}
				
				System.out.println("Possuí cupom? (s/n):");
				
				char cupomOpc = sc.nextLine().charAt(0);
				Double valorCupom = 0.0;
				
				if(cupomOpc == 's') {
					System.out.println("Digite o valor do cupom: ");
					valorCupom = sc.nextDouble();
					sc.nextLine();
				}
				
				Double valorTotalProdutos = 0.0;
				
				for(Pedido p : pedidos) {
					for(Alimento a : p.getProdutos()) {
						valorTotalProdutos += a.getValorAlimento();
					}
				}
				
				
				Double valorTotal = pedido.valorComDesconto(valorCupom, valorTotalProdutos);
				
				pedido.setNomeCliente(nomeCliente);
				pedido.setValorPedido(valorTotal);
				pedido.setStatus(StatusPedido.AGUARDE);
				
				isFinalizado = true;
			}catch(InputMismatchException e) {
				System.out.println("Input digitado da forma errada. Tente novamente.");
				sc.nextLine();
			}
		}
		

		

		
		
	}
	
	public static void verPedidos(List<Pedido> pedidos) {
		int qtdPedidosEmAberto = 0;
		for(Pedido p : pedidos) {
			if(p.getStatus().equals(StatusPedido.AGUARDE)) {
				System.out.println(p);
				qtdPedidosEmAberto += 1;
			}
		}
		if(qtdPedidosEmAberto == 0) {
			System.out.println("\n############\nNão há pedidos em aberto na lista.\n############");
		}
	}
	
	public static void concluirPedido(List<Pedido> pedidos) {
		Scanner sc = new Scanner(System.in);
	}
	
	public static void excluirPedido(List<Pedido> pedidos) {
		Scanner sc = new Scanner(System.in);
	}
	
	

}
