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
		
		while(opc != 6) {
			System.out.println("\n-------Sistema da Pizzaria Vini's-------\n");
			System.out.println("Menu: \n# 1 -> Criar um novo pedido\n# 2 -> Ver pedidos em aberto\n# 3 -> Concluir um pedido\n# 4 -> Ver pedidos já concluidos\n# 5 -> Excluir um pedido\n# 6 -> Sair");
			System.out.print("\nSelecione uma opção: ");
			opc = sc.nextInt();
			sc.nextLine();
			
			switch(opc) {
			case(1):
				criarPedido(pedidos);
				break;
			case(2):
				verPedidos(pedidos);
				break;
			case(3):
				concluirPedido(pedidos);
				break;
			case(4):
				verPedidosConcluidos(pedidos);
				break;
			case(5):
				excluirPedido(pedidos);
				break;
			}
		}
		
		sc.close();

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
						pedido.setProdutos(bebida);
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
				
				if(pedidos.size() == 1) {
					pedido.setNumPedido(1);
				}else {
					pedido.setNumPedido(pedidos.size() + 1);
				}

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
		
		if(pedidos.isEmpty()) {
			System.out.println("\n############\nNão há pedidos na lista.\n############");
		}else {
			System.out.print("Digite o numero do pedido: ");
			Integer numPedido = sc.nextInt();
			
			Pedido pedido = pedidos.stream().filter(x -> x.getNumPedido().equals(numPedido)).findFirst().orElse(null);
			
			if(pedido.equals(null)) {
				System.out.println("\n############\nNão foi possivel acha o pedido na lista.\n############");
			}else {
				pedido.setStatus(StatusPedido.CONCLUIDO);;
			}	
	}
		

	}
	
	public static void verPedidosConcluidos(List<Pedido> pedidos) {
		Scanner sc = new Scanner(System.in);
		
		if(pedidos.isEmpty()) {
			System.out.println("\n############\nNão há pedidos na lista.\n############");
		}else {
			int qtdPedidosConcluidos = 0;
			for(Pedido p : pedidos) {
				if(p.getStatus().equals(StatusPedido.CONCLUIDO)) {
					System.out.println(p);
					qtdPedidosConcluidos += 1;
				}
			}
			if(qtdPedidosConcluidos == 0) {
				System.out.println("\n############\nNão há pedidos concluidos na lista.\n############");
			}
		}
	}
	
	public static void excluirPedido(List<Pedido> pedidos) {
		Scanner sc = new Scanner(System.in);
		
		if(pedidos.isEmpty()) {
			System.out.println("\n############\nNão há pedidos na lista.\n############");
		}else {
				System.out.print("Digite o numero do pedido: ");
				Integer numPedido = sc.nextInt();
				
				Pedido pedido = pedidos.stream().filter(x -> x.getNumPedido().equals(numPedido)).findFirst().orElse(null);
				
				if(pedido.equals(null)) {
					System.out.println("\n############\nNão foi possivel achar o pedido na lista.\n############");
				}else {
					pedidos.remove(pedido);
					System.out.println("\n=========PEDIDO DE N°"+numPedido+" REMOVIDO=========\n");
				}	
		}
	}
	


}
