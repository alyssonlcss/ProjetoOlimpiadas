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
            
            System.out.println("Entre com um opÃ§Ã£o: ");
            int opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
            
            if (opcao == 0) break;
            
            int result, i , j;
            switch (opcao) {
                case 1: // GERENCIAR COMITÃŠS [ok]
                    do {
                        Utils.menu("Comitï¿½");
                        System.out.println("Entre com um opï¿½ï¿½o: ");
                        opcao = Utils.entrada.nextInt(); Utils.entrada.nextLine();
                        switch(opcao) {
                            case 1: // ADICIONAR COMITï¿½ [ok]
                            	Utils.sinalizadora = false;
                                ComiteOlimpico comite = new ComiteOlimpico();
                                comite.adicionar();
                                break;
                            case 2: // REMOVER COMITï¿½ [ok]
                                if(!ComiteOlimpico.getLista_comites().isEmpty()) {
                                    result = Utils.escolhaComite();
                                    ComiteOlimpico.getLista_comites().get(result).removerComite(result);                    	
                                    break;
                                } else{
                                    System.out.println("Lista de comitï¿½s vazia!");
                                }
                            case 3: // ALTERAR COMITï¿½ [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).alterarComite(result);
                                break;
                            case 4: // LISTAR COMITï¿½ [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).listarDados(); 
                                break;
                            case 5: // BUSCAR COMITï¿½ [ok]
                                System.out.println("Digite o nome do comitï¿½ que vocï¿½ deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);
                                
                                if (result_busca!= null) {
                                    System.out.println("Comitï¿½ encontrado!");
                                    result_busca.listarDados();
                                } else {
                                    System.out.println("Comitï¿½ nï¿½o encontrado!");
                                }
                                break;
                        }
                    } while (opcao != 0);
                    break;
                case 2: // GERENCIAR EQUIPE
                    do {
                        Utils.menu("Equipe");
                        
                        System.out.println("Entre com um opï¿½ï¿½o: ");
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
                                i = Utils.escolherEquipe(result);
                                ComiteOlimpico.getLista_comites().get(result).removerEquipeDoComite(i);
                                break;
                            case 3: // ALTERAR EQUIPE - Alysson
                            result = Utils.escolhaComite();
                            i = Utils.escolherEquipe(result);
                            ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).alterarEquipe(result,i);
                                break;
                            case 4: // LISTAR EQUIPE [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).listarDados();
                                break;
                            case 5: // BUSCAR EQUIPE [ok]
                            	 System.out.println("Digite o nome da Equipe que vocÃª deseja buscar: ");
                                 String nome = Utils.entrada.nextLine();
                                 Equipe result_busca = Equipe.buscar(nome);
                                 
                                 if (result_busca != null) {
                                     System.out.println("Equipe encontrada!");
                                     result_busca.listarDados();
                                 } else {
                                     System.out.println("Equipe nÃ£o encontrada!");
                                 }
                                break;
                        }         
                    } while (opcao != 0);
                        break;
                    case 3: // GERENCIAR ATLETA
                        do {
                            Utils.menu("Atleta");
                            
                            System.out.println("Entre com um opaï¿½ï¿½o: ");
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
                                    System.out.println("Nï¿½o foi possï¿½vel adicionar o atleta.");
                                    break;
                                case 2: // REMOVER ATLETA [ok]
                                	result = Utils.escolhaComite();
                                    i = Utils.escolherEquipe(result);
                                    j = Utils.escolherAtleta(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).removerAtletaDeEquipe(j);
                                    break;
                                case 3:
                                    result = Utils.escolhaComite();
                                    i = Utils.escolherEquipe(result);
                                    j = Utils.escolherAtleta(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getAtletas().get(j).alterarAtleta();
                                    break;
                                case 4:
                                    // LISTAR ATLETA - Mateus
                                	result = Utils.escolhaComite();
                                    i = Utils.escolherEquipe(result);
                                    j = Utils.escolherAtleta(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getAtletas().get(j).listarDados();
                                    break;
                                case 5: // BUSCAR ATLETA [ok]

                                	 System.out.println("Digite o nome do Atleta que vocï¿½ deseja buscar: ");
                                     String nome = Utils.entrada.nextLine();
                                     Atleta result_busca = Atleta.buscar(nome);
                                     
                                     if (result_busca != null) {
                                         System.out.println("Atleta encontrado!");
                                         result_busca.listarDados();
                                     } else {
                                         System.out.println("Atleta nï¿½o encontrada!");
                                     }
                                    break;
                            }
                            
                        } while (opcao != 0);

                        break;
                    case 4:
    
                        do {
                            Utils.menu("Comissï¿½o Tï¿½cnica");
                        
                            switch(opcao) {
                                case 1: // ADICIONAR Tï¿½CNICO [ok]
                                result = Utils.escolhaComite2("tï¿½cnico");
                                if(result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result).elegerEquipeOndeAddTecnico(result)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("Nï¿½o foi possï¿½vel adicionar o tï¿½cnico.");

                                    break;
                                case 2:// REMOVER Tï¿½CNICO [ok]
                                	result = Utils.escolhaComite();
                                    i = Utils.escolherEquipe(result);
                                    j = Utils.escolherTecnico(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).removerTecnicoDeEquipe(j);
                                    break;
                                case 3: // ALTERAR Tï¿½CNICO [ok]
                                	i = Utils.escolhaComite();
                                	j = Utils.escolherEquipe(i);
                                    result = Utils.escolherTecnico(i, j);
                                    ComiteOlimpico.getLista_comites().get(i).getEquipe().get(j).getComissaoTecnica().get(result).alterarTecnico(i, j, result);
                                    break;
                                case 4: // LISTAR TÉCNICO
                                    //
                                	result = Utils.escolhaComite();
                                    i = Utils.escolherEquipe(result);
                                    j = Utils.escolherTecnico(result, i);
                                    ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getComissaoTecnica().get(j).listarDados();
                                    break;
                                case 5: // BUSCAR COMISSÇÃO [ok]
                                	System.out.println("Digite o nome do Tenico que vocï¿½ deseja buscar: ");
                                    String nome = Utils.entrada.nextLine();
                                    Tecnico result_busca = Tecnico.buscar(nome);
                                    
                                    if (result_busca != null) {
                                        System.out.println("Tï¿½cnico encontrado!");
                                        result_busca.listarDados();
                                    } else {
                                        System.out.println("Tï¿½cnico nï¿½o encontrada!");
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
