package main;

import classes.Atleta;
import classes.ComiteOlimpico;
import classes.Equipe;
import classes.Tecnico;
import lib.Utils;

public class Main {

	public static void main(String[] args) {
		
        while (true) {
            Utils.menuPrincipal();
            
            System.out.println("Entre com um opção: ");
            int opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
            
            if (opcao == 0) break;
            
            int result;
            switch (opcao) {
                case 1: // GERENCIAR COMITÊS [ok]
                    do {
                        Utils.menu("Comitê");
                        System.out.println("Entre com um opção: ");
                        opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                        switch(opcao) {
                            case 1: // ADICIONAR COMITÊ [ok]
                            	Utils.sinalizadora = false;
                                ComiteOlimpico comite = new ComiteOlimpico();
                                comite.adicionar();
                                break;
                            case 2: // REMOVER COMITÊ [ok]
                                if(!ComiteOlimpico.getLista_comites().isEmpty()) {
                                    result = Utils.escolhaComite();
                                    ComiteOlimpico.getLista_comites().get(result).removerComite(result);                    	
                                    break;
                                } else{
                                    System.out.println("Lista de comitês vazia!");
                                }
                            case 3: // ALTERAR COMITÊ [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).alterarComite(result);
                                break;
                            case 4: // LISTAR COMITÊS [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).listarDados(); 
                                break;
                            case 5: // BUSCAR COMITÊ [ok]
                                System.out.println("Digite o nome do comitê que você deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);
                                
                                if (result_busca!= null) {
                                    System.out.println("Comitê encontrado!");
                                    result_busca.listarDados();
                                } else {
                                    System.out.println("Comitê não encontrado!");
                                }
                                break;
                        }
                    } while (opcao != 0);
                    break;
                case 2: // GERENCIAR EQUIPE
                    do {
                        Utils.menu("Equipe");
                        
                        System.out.println("Entre com um opção: ");
                        opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                        
                        switch(opcao) {
                            case 1: // ADICIONAR EQUIPE [ok]
                                Utils.sinalizadora = false;
                            	result = Utils.escolhaComite2("equipe");
                                if(result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                ComiteOlimpico.getLista_comites().get(result).adicionarEquipeAoComite();
                                break;
                            case 2: // REMOVER EQUIPE [ok]
                                result = Utils.escolhaComite();
                                int i = Utils.escolherEquipe(result);
                                ComiteOlimpico.getLista_comites().get(result).removerEquipeDoComite(i);
                                break;
                            case 3: // ALTERAR EQUIPE - Alysson
                            result = Utils.escolhaComite();
                            i = Utils.escolherEquipe(result);
                            ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).alterarEquipe();
                                break;
                            case 4: // LISTAR EQUIPE [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).listarDados();
                                break;
                            case 5: // BUSCAR EQUIPE [ok]
                            	 System.out.println("Digite o nome da Equipe que você deseja buscar: ");
                                 String nome = Utils.entrada.nextLine();
                                 Equipe result_busca = Equipe.buscar(nome);
                                 
                                 if (result_busca != null) {
                                     System.out.println("Equipe encontrada!");
                                     result_busca.listarDados();
                                 } else {
                                     System.out.println("Equipe não encontrada!");
                                 }
                                break;
                            }
                            
                    } while (opcao != 0);
                        break;
                    case 3: // GERENCIAR ATLETA
                        do {
                            Utils.menu("Atleta");
                            
                            System.out.println("Entre com um opção: ");
                            opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                            
                            switch(opcao) {
                                case 1: // ADICIONAR ATLETA [ok]
                                    result = Utils.escolhaComite2("atleta");
                                    if(result == 0) {
                                        opcao = 0;
                                        break;
                                    }
                                    if (ComiteOlimpico.getLista_comites().get(result).elegerEquipeOndeAddAtleta(result)) {
                                        opcao = 0;
                                        break;
                                    }
                                    System.out.println("Não foi possível adicionar o atleta.");
                                    break;
                                case 2: // REMOVER ATLETA [ok]
                                	result = Utils.escolhaComite();
                                    int i = Utils.escolherEquipe(result);
                                    int j = Utils.escolherAtleta(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).removerAtletaDeEquipe(j);
                                    break;
                                case 3:
                                    // ALTERAR ATLETA - Yan
                                    break;
                                case 4:
                                    // LISTAR ATLETA - Alysson
                                    
                                    

                                    break;
                                case 5: // BUSCAR ATLETA [ok]

                                	 System.out.println("Digite o nome do Atleta que você deseja buscar: ");
                                     String nome = Utils.entrada.nextLine();
                                     Atleta result_busca = Atleta.buscar(nome);
                                     
                                     if (result_busca != null) {
                                         System.out.println("Atleta encontrado!");
                                         result_busca.listarDados();
                                     } else {
                                         System.out.println("Atleta não encontrada!");
                                     }
                                    break;
                            }
                            
                        } while (opcao != 0);

                        break;
                    case 4:
    
                        do {
                            Utils.menu("Comissão Técnica");
                        
                            switch(opcao) {
                                case 1: // ADICIONAR TECNICO [ok]
                                result = Utils.escolhaComite2("técnico");
                                if(result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result).elegerEquipeOndeAddTecnico(result)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("Não foi possível adicionar o técnico.");

                                    break;
                                case 2:// REMOVER TECNICO [ok]
                                	result = Utils.escolhaComite();
                                    int i = Utils.escolherEquipe(result);
                                    int j = Utils.escolherTecnico(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).removerTecnicoDeEquipe(j);
                                    break;
                                case 3: // ALTERAR TECNICO - Mateus
                                    //
                                    break;
                                case 4: // LISTAR TECNICO - Bruno
                                    //						
                                    break;
                                case 5: // BUSCAR TECNICO [ok]
                                	System.out.println("Digite o nome do Tenico que você deseja buscar: ");
                                    String nome = Utils.entrada.nextLine();
                                    Tecnico result_busca = Tecnico.buscar(nome);
                                    
                                    if (result_busca != null) {
                                        System.out.println("Técnico encontrado!");
                                        result_busca.listarDados();
                                    } else {
                                        System.out.println("Técnico não encontrada!");
                                    }
                                    break;
                            }
                        
                    } while (opcao != 0);
                    break;
        	}
        }
        Utils.entrada.close();
	}
}
