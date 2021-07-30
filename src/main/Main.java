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
<<<<<<< HEAD
                        
                        try {
                        	System.out.println("Entre com um op��o: ");
                        	opcao = Utils.entrada.nextInt();
                        	Utils.entrada.nextLine();
                        	
                        } catch(Exception e) {
                        	System.out.println("Você pode digitar somente números!");
                        	Utils.entrada.nextLine();
=======
                        sinal = true;
                        while (sinal) {
                            try {
                                System.out.println("Entre com um op��o: ");
                                opcao = Integer.parseInt(Utils.entrada.nextLine());
                                sinal = false;
                            } catch(NumberFormatException e) {
                                System.out.println("Você pode digitar somente números!");
                            }

>>>>>>> 5236da8fb9cba6f3a8391be20c17e6dfff5c1aa8
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
                                    ComiteOlimpico.getLista_comites().get(result-1).removerComite(result-1);
                                    break;
                                } else {
                                    System.out.println("Lista de comit�s vazia!");
                                }
                            case 3: // ALTERAR COMIT� [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result-1).alterarComite(result-1);
                                break;
                            case 4: // LISTAR COMIT� [ok]
                                result = Utils.escolhaComite();
                                ComiteOlimpico.getLista_comites().get(result-1).listarDados();
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
                                ComiteOlimpico.getLista_comites().get(result-1).adicionarEquipeAoComite();
                                break;
                            case 2: // REMOVER EQUIPE [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                ComiteOlimpico.getLista_comites().get(result-1).removerEquipeDoComite(i-1);
                                break;
                            case 3: // ALTERAR EQUIPE - Alysson
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).alterarEquipe(result,
                                        i);
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
                                if (ComiteOlimpico.getLista_comites().get(result-1).elegerEquipeOndeAddAtleta(result-1)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("N�o foi poss�vel adicionar o atleta.");
                                break;
                            case 2: // REMOVER ATLETA [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1)
                                        .removerAtletaDeEquipe(j-1);
                                break;
                            case 3:
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getAtletas().get(j-1)
                                        .alterarAtleta();
                                break;
                            case 4:
                                // LISTAR ATLETA - Mateus
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherAtleta(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getAtletas().get(j-1)
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
                                if (ComiteOlimpico.getLista_comites().get(result-1).elegerEquipeOndeAddTecnico(result-1)) {
                                    opcao = 0;
                                    break;
                                }
                                System.out.println("N�o foi poss�vel adicionar o t�cnico.");

                                break;
                            case 2:// REMOVER T�CNICO [ok]
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherTecnico(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1)
                                        .removerTecnicoDeEquipe(j-1);
                                break;
                            case 3: // ALTERAR T�CNICO [ok]
                                i = Utils.escolhaComite();
                                j = Utils.escolherEquipe(i-1);
                                result = Utils.escolherTecnico(i, j);
                                ComiteOlimpico.getLista_comites().get(i-1).getEquipe().get(j-1).getComissaoTecnica()
                                        .get(result-1).alterarTecnico(i, j, result);
                                break;
                            case 4: // LISTAR T�CNICO
                                //
                                result = Utils.escolhaComite();
                                i = Utils.escolherEquipe(result-1);
                                j = Utils.escolherTecnico(result-1, i-1);
                                ComiteOlimpico.getLista_comites().get(result-1).getEquipe().get(i-1).getComissaoTecnica()
                                        .get(j-1).listarDados();
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
