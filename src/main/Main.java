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
                    case 1:
                    	ComiteOlimpico comite = new ComiteOlimpico();
                    	comite.adicionar();
                        break;
                    case 2:
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
                    case 3:
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
                    case 5:
                        System.out.println("Digite o nome do comitê que você deseja buscar: ");
                        String nome = Utils.entrada.nextLine();
                        
                        
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
                    case 1:
                        for(int i = 0; i < comites.size(); i++) {
                            System.out.println(i + ": " + comites.get(i).toString());
                        }
                        comites.get(0).adicionarEquipe();                       

                        break;
                    case 2:
                       
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        
                        break;
                    case 5: // buscar comitê
                        for(int i = 0; i < ComiteOlimpico.getLista_comites().size(); i++) {
                            System.out.println(i + ": " + ComiteOlimpico.getLista_comites().get(i).toString());
                        }
                            ComiteOlimpico.bu
                        //
                        break;
                    default:
                        
                        switch(opcao) {
                            case 1: // ADICIONAR EQUIPE
                                result = Utils.escolhaComite2("equipe");
                                if(result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                ComiteOlimpico.getLista_comites().get(result).adicionarEquipeAoComite(true);
                                break;
                            case 2: // REMOVER EQUIPE
                                System.out.println("Equipes que podem ser removidas:");
                                int i;
                                for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
                                    i = 0;
                                    for (Equipe equipe : comite.getEquipe()) {
                                        System.out.printf("[%d] %s",i,equipe.getNome());
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
                                System.out.println("Opção inválida, digite novamente!");
                            }
                            
                    } while (opcao != 0);
                        break;
                    case 3: // GERENCIAR ATLETA
                        do {
                            Utils.menu("Atleta");
                            
                            System.out.println("Entre com um opção: ");
                            opcao = entrada.nextInt(); entrada.nextLine();
                            
                            switch(opcao) {
                                case 1: // ADICIONAR ATLETA
                                    result = Utils.escolhaComite2("atleta");
                                    if(result == 0) {
                                        opcao = 0;
                                        break;
                                    }
                                    if (ComiteOlimpico.getLista_comites().get(result).apurarEquipes_addAtleta(result)) {
                                        opcao = 0;
                                        break;
                                    }
                                    System.out.println("Não foi possível adicionar o atleta.");
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
                                System.out.println("Opção inválida, digite novamente!");
                            }
                            
                        } while (opcao != 0);
                        break;
                    case 4:
                        int result;
                        do {
                            Utils.menu("Comissão Técnica");
                        
                            
                            switch(opcao) {
                                case 1:
                                result = Utils.escolhaComite2("técnico");
                                if(result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result).apurarEquipes_addTecnico(result)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("Não foi possível adicionar o técnico.");

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
                                    System.out.println("Opção inválida, digite novamente!");
                            }
                        
                    } while (opcao != 0);
                    break;
            }
        }
        entrada.close();
    }
}
