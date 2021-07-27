package main;

import java.util.Scanner;

import classes.ComiteOlimpico;
import classes.Equipe;
import lib.Utils;


public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        
        while (true) {
            Utils.menuPrincipal();
            
            System.out.println("Entre com um opção: ");
            int opcao = entrada.nextInt(); entrada.nextLine();
            
            if (opcao == 0) break;
            
            switch (opcao) {
            case 1:
                
                do {
                    Utils.menu("Comitê");
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1: // ADICIONAR COMITÊ
                    	ComiteOlimpico comite = new ComiteOlimpico();
                    	comite.adicionar();
                        break;
                    case 2: // REMOVER COMITÊ
                    	int i = 0;
                    	System.out.println("Comitês cadastrados: ");
                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
                    		System.out.printf("[%d] %s\n",i,c.getNome());
                    		i++;
                    	}
                    	System.out.println("Digite o número do comitê que você deseja remover: ");
                    	
                    	i = Utils.entrada.nextInt();
                    	
                    	ComiteOlimpico.getLista_comites().get(i).remover(i);                    	
                        break;
                    case 3: // ALTERAR COMITÊ
                    	i = 0;
                    	System.out.println("Comitês cadastrados: ");
                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
                    		System.out.printf("[%d] %s\n",i,c.getNome());
                    		i++;
                    	}
                    	System.out.println("Digite o número do comitê que você deseja Alterar: ");
                    	
                    	i = Utils.entrada.nextInt();
                    	
                    	ComiteOlimpico.getLista_comites().get(i).alterarComite(i);
                    	
                        break;
                    case 4: // LISTAR COMITÊS
                    	i = 0;
                    	System.out.println("Comitês cadastrados: ");
                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
                    		System.out.printf("[%d] %s\n",i,c.getNome());
                    		i++;
                    	}
                    	System.out.println("Digite o número do comitê que você deseja listar as informações: ");

                    	i = Utils.entrada.nextInt();

                    	ComiteOlimpico.getLista_comites().get(i).listarDados();
                		break;
                    case 5: // BUSCAR COMITÊ
                        System.out.println("Digite o nome do comitê que você deseja buscar: ");
                        String nome = Utils.entrada.nextLine();
                        
                        ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);
                        
                        if (result_busca!= null) {
                        	System.out.println("Comitê encontrado!");
                        	System.out.println(result_busca.toString());
                        } else {
                        	System.out.println("Comitê não encontrado!");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente !");
                    }
                    
                } while (opcao != 0);
                
                
                break;
            case 2:
                do {
                    Utils.menu("Equipe");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1: // ADICIONAR EQUIPE
                        int i = 0;
                        for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
                            System.out.printf("[%d] %s",i, comite.getNome());
                            i++;
                        }
                                      
                        break;
                    case 2: // REMOVER EQUIPE
                    	System.out.println("Equipes que podem ser removidas:");
                    	for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
                    		for (Equipe equipe : comite.getEquipe()) {
                    			System.out.printf("[%d] %s",i, comite);
                    		}
                    	}
                        break;
                    case 3: // ALTERAR EQUIPE
                        //
                        break;
                    case 4: // LISTAR EQUIPE
                        
                        break;
                    case 5: // BUSCAR EQUIPE
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            case 3:
                do {
                    Utils.menu("Atleta");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1:
                       
                        break;
                    case 2:
                        //
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        //						
                        break;
                    case 5:
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            case 4:
                do {
                    Utils.menu("Comissão Técnica");
                 
                    
                    switch(opcao) {
                    case 1:
                        //
                        break;
                    case 2:
                        //
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        //						
                        break;
                    case 5:
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            }
        }
        entrada.close();
    }
}
