package com.gft.avaliacao.avaliacaogft;

import java.util.Scanner;

import com.gft.avaliacao.commons.Pedido;
import com.gft.avaliacao.service.PedidoImpressao;
import com.gft.avaliacao.service.PedidoService;


/**
 * Classe principal para execucao do programa
 * @author rafab
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	boolean continuarSistema = true;

    	Scanner interacaoUsuario = new Scanner(System.in);
    	while(continuarSistema){
	    	
	    	System.out.println("Bem vindo ao sistema de pedidos, siga as instrucoes abaixo\n\n");
	    	System.out.println("Para realizar os pedido voce deve informar o periodo (manha ou noite) "
	    			+ "e o numeros dos itens conforme menu abaixo:\n\n");
	    	
	    	System.out.println("Tipo Prato        | Manha         | Noite  |");
	    	System.out.println("--------------------------------------------");
	    	System.out.println("1 Entrada         | Ovos          | Bife   |");
	    	System.out.println("2 Acompanhamento  | Torrada       | Batata |");
	    	System.out.println("3 Bebida          | Café          | Vinho  |");
	    	System.out.println("4 Sobremesa       | Indisponível  | Bolo   |");
	    	

	    	System.out.println("\nATENCAO: Você deve inserir uma lista delimitada por vírgulas de tipos de pratos com pelo menos uma selecao");
	    	System.out.println("\nExemplo de entrada: manha, 1, 2, 3");
	    	
	    	
	    	System.out.println("\n\n Informe seu pedido: ");
			String entrada = interacaoUsuario.nextLine();
			
			entrada = tratarAcentosEsperados(entrada);
			PedidoService cardapioService = new PedidoService();
			Pedido pedido = cardapioService.retornarPedido(entrada);
			
			
			System.out.println("\nResultado pedido");
			System.out.println(PedidoImpressao.imprimirPedido(pedido));
			
			
			
			boolean respostaIncorreta = true;
			while(respostaIncorreta){
				System.out.println("\n\n Deseja fazer um novo pedido? (Sim - Nao) ");
				String novoPedido = interacaoUsuario.nextLine();
				
				if("SIM".equalsIgnoreCase(novoPedido)){
					continuarSistema = true;
					respostaIncorreta = false;
				}else if("NAO".equalsIgnoreCase(novoPedido) || "NÃO".equalsIgnoreCase(novoPedido)){
					continuarSistema = false;
					respostaIncorreta = false;
					System.out.println("\n\n OBRIGADO POR UTILIZAR NOSSO SISTEMA");
				}
			}
			
    	}
    	interacaoUsuario.close();
			
    }

    /**
     * Metodo utilitario para remover acentos
     * @param entrada
     * @return string entrada sem acento
     */
	private static String tratarAcentosEsperados(String entrada) {
		String entradaTratada = entrada;
		entradaTratada = entradaTratada.replaceAll("ã", "a");
		return entradaTratada;
	}

}
