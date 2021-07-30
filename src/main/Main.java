package main;

import java.util.InputMismatchException;

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
                System.out.println("Você só pode digitar somente números!");
                continue;
            }

            if (opcao == 0) break;

            int result, i, j;
            switch (opcao) {
                case 1: // GERENCIAR COMITÊS [ok]
                    do {
                        Utils.menu("Comit�");
                        
                        try {
                        	System.out.println("Entre com um op��o: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                        	
                        } catch(Exception e) {
                        	System.out.println("Você pode digitar somente números!");
                        	Utils.entrada.nextLine();
                        }
                        switch (opcao) {
                            case 1: // ADICIONAR COMIT� [ok]
                                Utils.sinalizadora = false;
                                ComiteOlimpico comite = new ComiteOlimpico();
                                comite.adicionar();
                                break;
                            case 2: // REMOVER COMIT� [ok]
                                if (!ComiteOlimpico.getLista_comites().isEmpty()) {
                                    result = Utils.escolhaComite();
                                    ComiteOlimpico.getLista_comites().get(result).removerComite(result);
                                    break;
                                } else {
                                    System.out.println("Lista de comit�s vazia!");
                                }
                            case 3: // ALTERAR COMIT� [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).alterarComite(result);
                                break;
                            case 4: // LISTAR COMIT� [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result).listarDados();
                                break;
                            case 5: // BUSCAR COMIT� [ok]
                                System.out.println("Digite o nome do comit� que voc� deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                ComiteOlimpico result_busca = ComiteOlimpico.buscar(nome);

                                if (result_busca != null) {
                                    System.out.println("Comit� encontrado!");
                                    result_busca.listarDados();
                                } else {
                                    System.out.println("Comit� n�o encontrado!");
                                }
                                break;
                        }
                    } while (opcao != 0);
                    break;
                case 2: // GERENCIAR EQUIPE
                    do {
                        Utils.menu("Equipe");

                        System.out.println("Entre com um op��o: ");
                        opcao = Utils.entrada.nextInt();
                        Utils.entrada.nextLine();

                        switch (opcao) {
                            case 1: // ADICIONAR EQUIPE [ok]
                                Utils.sinalizadora = false;
                                result = Utils.escolhaComite2("equipe");
                                if (result == 0) {
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
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).alterarEquipe(result,
                                        i);
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

                        System.out.println("Entre com um opa��o: ");
                        opcao = Utils.entrada.nextInt();
                        Utils.entrada.nextLine();

                        switch (opcao) {
                            case 1: // ADICIONAR ATLETA [ok]
                                result = Utils.escolhaComite2("atleta");
                                if (result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result).elegerEquipeOndeAddAtleta(result)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("N�o foi poss�vel adicionar o atleta.");
                                break;
                            case 2: // REMOVER ATLETA [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                j = Utils.escolherAtleta(result, i);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i)
                                        .removerAtletaDeEquipe(j);
                                break;
                            case 3:
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                j = Utils.escolherAtleta(result, i);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getAtletas().get(j)
                                        .alterarAtleta();
                                break;
                            case 4:
                                // LISTAR ATLETA - Mateus
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                j = Utils.escolherAtleta(result, i);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getAtletas().get(j)
                                        .listarDados();
                                break;
                            case 5: // BUSCAR ATLETA [ok]

                                System.out.println("Digite o nome do Atleta que voc� deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                Atleta result_busca = Atleta.buscar(nome);

                                if (result_busca != null) {
                                    System.out.println("Atleta encontrado!");
                                    result_busca.listarDados();
                                } else {
                                    System.out.println("Atleta n�o encontrada!");
                                }
                                break;
                        }

                    } while (opcao != 0);

                    break;
                case 4:

                    do {
                        Utils.menu("Comiss�o T�cnica");

                        switch (opcao) {
                            case 1: // ADICIONAR T�CNICO [ok]
                                result = Utils.escolhaComite2("t�cnico");
                                if (result == 0) {
                                    opcao = 0;
                                    break;
                                }
                                if (ComiteOlimpico.getLista_comites().get(result).elegerEquipeOndeAddTecnico(result)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("N�o foi poss�vel adicionar o t�cnico.");

                                break;
                            case 2:// REMOVER T�CNICO [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                j = Utils.escolherTecnico(result, i);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i)
                                        .removerTecnicoDeEquipe(j);
                                break;
                            case 3: // ALTERAR T�CNICO [ok]
                                i = Utils.escolhaComite();
                                j = Utils.escolherEquipe(i);
                                result = Utils.escolherTecnico(i, j);
                                ComiteOlimpico.getLista_comites().get(i).getEquipe().get(j).getComissaoTecnica()
                                        .get(result).alterarTecnico(i, j, result);
                                break;
                            case 4: // LISTAR T�CNICO
                                //
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result);
                                j = Utils.escolherTecnico(result, i);
                                ComiteOlimpico.getLista_comites().get(result).getEquipe().get(i).getComissaoTecnica()
                                        .get(j).listarDados();
                                break;
                            case 5: // BUSCAR COMISS��O [ok]
                                System.out.println("Digite o nome do Tenico que voc� deseja buscar: ");
                                String nome = Utils.entrada.nextLine();
                                Tecnico result_busca = Tecnico.buscar(nome);

                                if (result_busca != null) {
                                    System.out.println("T�cnico encontrado!");
                                    result_busca.listarDados();
                                } else {
                                    System.out.println("T�cnico n�o encontrada!");
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
