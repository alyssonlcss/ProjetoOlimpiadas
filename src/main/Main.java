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

            int opcao = 0;

            try {
                System.out.println("Entre com um opção: ");
                opcao = Integer.parseInt(Utils.entrada.nextLine());
                
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros dentro das opções!");
                continue;
            }

            if (opcao == 0) break;
            int result, i, j;
            switch (opcao) {
                case 1: // GERENCIAR COMITÊS [ok]
                    do {
                        Utils.menu("Comitê");
                        
                        try {
                        	System.out.println("Entre com um opção: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                            if (opcao != 1 && ComiteOlimpico.getLista_comites().isEmpty()) {
                                System.out.println("Lista de comitês vazia.");
                                break;
                            }
                        	
                        } catch(Exception e) {
                        	System.out.println("Digite apenas números inteiros dentro das opções.");
                        	Utils.entrada.nextLine();
                        	continue;
                        }
                        switch (opcao) {
                            case 1: // ADICIONAR COMITÊ [ok]
                                Utils.sinalizadora = false;
                                ComiteOlimpico comite = new ComiteOlimpico();
                                comite.adicionar();
                                System.out.println("Comitê adicionado com sucesso!");
                                break;
                            case 2: // REMOVER COMITÊ [ok]
                                if (!ComiteOlimpico.getLista_comites().isEmpty()) {
                                    result = Utils.escolhaComite();
                                    if (ComiteOlimpico.getLista_comites().get(result-1).removerComite(result-1))
                                        System.out.println("Comitê removido com sucesso!");
                                    else
                                        System.out.println("Comitê não removido!");
                                    
                                    break;
                                } else {
                                    System.out.println("Lista de comitês vazia.");
                                }
                            case 3: // ALTERAR COMITÊ [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result-1).alterarComite(result-1);
                                break;
                            case 4: // LISTAR COMITÊ [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result-1).listarDados();
                                break;
                            case 5: // BUSCAR COMITÊ [ok]
                                System.out.println("Digite o nome do comitê que você deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);

                                if (result_busca != null) {
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
                        try {
                        	System.out.println("Entre com um opção: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                            if (opcao != 1 && ComiteOlimpico.getLista_comites().isEmpty()) {
                                System.out.println("Lista de comitês vazia.");
                                break;
                            }
                        	
                        } catch(Exception e) {
                        	System.out.println("Digite apenas números inteiros dentro das opções.");
                        	Utils.entrada.nextLine();
                        	continue;
                        }

                        switch (opcao) {
                            case 1: // ADICIONAR EQUIPE [ok]
                                Utils.sinalizadora = false;
                                result = Utils.escolhaComite("equipe");
                                if (result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                ComiteOlimpico.getLista_comites().get(result-1).adicionarEquipeAoComite();
                                System.out.println("Equipe adicionada com sucesso!");
                                break;
                            case 2: // REMOVER EQUIPE [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                if(ComiteOlimpico.getLista_comites().get(result-1).removerEquipeDoComite(i-1))
                                    System.out.println("Equipe removida com sucesso!");
                                else
                                    System.out.println("Equipe não removida!");
                                break;
                            case 3: // ALTERAR EQUIPE - Alysson
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).alterarEquipe(result-1, i-1);
                                break;
                            case 4: // LISTAR EQUIPE [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).listarDados();
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
                        
                        try {
                        	System.out.println("Entre com um opção: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                        } catch(Exception e) {
                        	System.out.println("Digite apenas números inteiros dentro das opções.");
                        	Utils.entrada.nextLine();
                        	continue;
                        }
                        if(opcao != 5 && opcao != 0) 
                            result = Utils.escolhaComite("atleta");
                        else
                            result = 0;
                        if (result == 5 && (result != 0 || ComiteOlimpico.getLista_comites().isEmpty() || 
                            ComiteOlimpico.getLista_comites().get(result-1).getEquipe().isEmpty())) {
                            System.out.println("Nenhuma Equipe cadastrada.");
                            break;
                        }
                        switch (opcao) {
                            case 1: // ADICIONAR ATLETA [ok]
                                if (result == 0 || opcao == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result-1).elegerEquipeOndeAddAtleta(result-1)) {
                                    opcao = 0;
                                    System.out.println("Adicionado com sucesso!");
                                    break;
                                }
                                System.out.println("Não foi possível adicionar o atleta.");
                                break;
                            case 2: // REMOVER ATLETA [ok]
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                if(ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).removerAtletaDeEquipe(j-1))
                                    System.out.println("Atleta removido com sucesso!");
                                else
                                    System.out.println("Atleta não removido!");
                                break;
                            case 3: // ALTERAR ATLETA [ok]
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getAtletas().get(j-1)
                                        .alterarAtleta();
                                break;
                            case 4:
                                // LISTAR ATLETA - Mateus
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getAtletas().get(j-1).listarDados();
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
                        Utils.menu("Técnico");
                        try {
                        	System.out.println("Entre com um opção: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                        } catch(Exception e) {
                        	System.out.println("Digite apenas números inteiros dentro das opções.");
                        	Utils.entrada.nextLine();
                        	continue;
                        }
                        if(opcao != 5 && opcao != 0) 
                            result = Utils.escolhaComite("técnico");
                        else
                            result = 0;
                        if (result == 5 && (ComiteOlimpico.getLista_comites().isEmpty() || 
                            ComiteOlimpico.getLista_comites().get(result-1).getEquipe().isEmpty())) {
                            System.out.println("Nenhuma Equipe cadastrada.");
                            break;
                        }
                        switch (opcao) {
                            case 1: // ADICIONAR Técnico [ok]
                                if (result == 0 || opcao == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result-1).elegerEquipeOndeAddTecnico(result-1)) {
                                    opcao = 0;
                                    System.out.println("Técnico adicionado com sucesso!");
                                    break;
                                }
                                System.out.println("Não foi possível adicionar o técnico.");

                                break;
                            case 2:// REMOVER Técnico [ok]
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherTecnico(result-1, i-1);
                                if (ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).removerTecnicoDeEquipe(j-1))
                                    System.out.println("Técnico removido com sucesso!");
                                else
                                    System.out.println("Técnico não foi removido!");
                                break;
                            case 3: // ALTERAR Técnico [ok]
                                j = Utils.escolherEquipe(result-1);
                                result = Utils.escolherTecnico(result-1, j-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(j-1).getComissaoTecnica()
                                        .get(result-1).alterarTecnico();
                                break;
                            case 4: // LISTAR Técnico
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherTecnico(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getComissaoTecnica()
                                        .get(j-1).listarDados();
                                break;
                            case 5: // BUSCAR COMISSÃO [ok]
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