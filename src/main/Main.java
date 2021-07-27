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
                int result;
                case 1: // GERENCIAR COMITÊS
                    do {
                        Utils.menu("Comitê");
                        System.out.println("Entre com um opção: ");
                        opcao = entrada.nextInt(); entrada.nextLine();
                        switch(opcao) {
                            case 1: // ADICIONAR COMITÊ
                                ComiteOlimpico comite = new ComiteOlimpico();
                                comite.adicionar(false);
                                ComiteOlimpico.getLista_comites().add(comite);
                                break;
                            case 2: // REMOVER COMITÊ
                                if(!ComiteOlimpico.getLista_comites().isEmpty()) {
                                    result = Utils.escolhaComite();
                                    ComiteOlimpico.getLista_comites().get(result).remover(result);                    	
                                    break;
                                } else{
                                    System.out.println("Lista de comitês vazia!");
                                }
                            case 3: // ALTERAR COMITÊ
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).alterarComite(result);
                                break;
                            case 4: // LISTAR COMITÊS
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).listarDados(); // toString????
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
                                System.out.println("Opção inválida, digite novamente!");
                        }
                    } while (opcao != 0);
                    break;
                case 2: // GERENCIAR EQUIPE
                    do {
                        Utils.menu("Equipe");
                        
                        System.out.println("Entre com um opção: ");
                        opcao = entrada.nextInt(); entrada.nextLine();
                        
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
