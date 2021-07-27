package main;

import lib.Utils;
import classes.ComiteOlimpico;
import classes.Equipe;

public class Main {

	public static void main(String[] args) {
		
        
        while (true) {
            Utils.menuPrincipal();
            
            System.out.println("Entre com um opção: ");
            int opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
            
            if (opcao == 0) break;
            
            switch (opcao) {
            case 1:
                
                do {
                    Utils.menu("Comitê");
                    System.out.println("Entre com um opção: ");
                    opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                    
                    switch(opcao) {
                    case 1: // ADICIONAR COMITÊ
                    	ComiteOlimpico comite = new ComiteOlimpico();
                    	comite.adicionar(false);
                        break;
                    case 2: // REMOVER COMITÊ
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
	                    	int i = 0;
	                    	System.out.println("Comitês cadastrados: ");
	                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
	                    		System.out.printf("[%d] %s\n",i,c.getNome());
	                    		i++;
	                    	}
	                    	System.out.println("Digite o número do comitê que você deseja remover: ");
	                    	
	                    	i = Utils.entrada.nextInt();
	                    	
	                    	ComiteOlimpico.getLista_comites().get(i).remover(i);
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado!");
                    	}
                        break;
                    case 3: // ALTERAR COMITÊ
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
	                    	int i = 0;
	                    	System.out.println("Comitês cadastrados: ");
	                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
	                    		System.out.printf("[%d] %s\n",i,c.getNome());
	                    		i++;
	                    	}
	                    	System.out.println("Digite o número do comitê que você deseja Alterar: ");
	                    	
	                    	i = Utils.entrada.nextInt();
	                    	
	                    	ComiteOlimpico.getLista_comites().get(i).alterarComite(i);
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado!");
                    	}
                        break;
                    case 4: // LISTAR COMITÊS
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
	                    	int i = 0;
	                    	System.out.println("Comitês cadastrados: ");
	                    	for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
	                    		System.out.printf("[%d] %s\n",i,c.getNome());
	                    		i++;
	                    	}
	                    	System.out.println("Digite o número do comitê que você deseja listar as informações: ");
	
	                    	i = Utils.entrada.nextInt();
	
	                    	ComiteOlimpico.getLista_comites().get(i).listarDados();
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado!");
                    	}
                		break;
                    case 5: // BUSCAR COMITÊ
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
	                        System.out.println("Digite o nome do comitê que você deseja buscar: ");
	                        String nome = Utils.entrada.nextLine();
	                        
	                        ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);
	                        
	                        if (result_busca!= null) {
	                        	System.out.println("Comitê encontrado!");
	                        	result_busca.listarDados();
	                        } else {
	                        	System.out.println("Comitê não encontrado!");
	                        }
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado!");
                    	}
                        break;
                    }
                } while (opcao != 0);
                break;
            case 2:
                do {
                    Utils.menu("Equipe");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                    
                    switch(opcao) {
                    case 1: // ADICIONAR EQUIPE
                    	
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
                    		Equipe equipe = new Equipe();
                    		equipe.adicionar(true);
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado. Cadastre um comitê primeiro!");
                    	}
                    	
                        break;
                    case 2: // REMOVER EQUIPE
                    	if (!ComiteOlimpico.getLista_comites().isEmpty()) {
                    			System.out.println("Equipes que podem ser removidas:");
	                    		int i;
		                    	for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
		                    		i = 0;
		                    		System.out.println("Comitê - " + comite.getNome() + " { ");
		                    		if (comite.getEquipe().isEmpty()) System.out.println("comitê não possui equipes cadastradas.");
		                    		for (Equipe equipe : comite.getEquipe()) {
		                    			System.out.printf("%d. %s",i,equipe.getNome());
		                    			i++;
		                    		}
		                    		System.out.println("\n}");
		                    	}
		                    	System.out.println("\nDigite o número da Equipe que você deseja remover: ");
		                    	
		                    	i = Utils.entrada.nextInt();
		                    	
		                    	
                    	} else {
                    		System.out.println("Você não possui nenhum comitê cadastrado. Cadastre um comitê primeiro!");
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
                    opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                    
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
        Utils.entrada.close();
    }
}
