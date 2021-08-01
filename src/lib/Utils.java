package lib;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Atleta;
import classes.ComiteOlimpico;
import classes.Equipe;
import classes.Tecnico;

public class Utils {

	public static Scanner entrada = new Scanner(System.in);

	public static boolean sinalizadora;

	public static void menuPrincipal() {
		System.out.println("\n    JOGOS OLÍMPICOS DE TOKYO 2020    \n");
		System.out.println("[1] Gerenciar Comitê............");
		System.out.println("[2] Gerenciar Equipe............");
		System.out.println("[3] Gerenciar Atleta............");
		System.out.println("[4] Gerenciar Comissão Técnica..");
		System.out.println("[0] SAIR........................");
	}

	public static void menu(String nome) {
		System.out.println("\n[1] Adicionar " + nome + ".");
		System.out.println("[2] Remover " + nome + ".");
		System.out.println("[3] Alterar " + nome + ".");
		System.out.println("[4] Listar " + nome + ".");
		System.out.println("[5] Buscar " + nome + ".");
		System.out.println("[0] VOLTAR AO MENU PRINCIPAL");

	}

	public static int menuAlterarEquipe() {
		System.out.println("[1] Nome..............");
		System.out.println("[2] Modalidade........");
		System.out.println("[3] Atleta............");
		System.out.println("[4] Comissão Técnica..");
		System.out.println("[0] CANCELAR..........");
		try {
			System.out.printf("\nO que deseja alterar em equipe: ");
			return Integer.parseInt(entrada.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Você só pode digitar número referentes a opção.");
			return 0;
		} 
	}

	public static int menuStatus() {
		System.out.println("\nMenu de Status:");
		System.out.println("[1] MEDALISTA......");
		System.out.println("[2] DESCLASSIFICADO..");
		System.out.println("[3] EM ANDAMENTO.....");
		System.out.println("[4] CLASSIFICADO.....");

		try {
			System.out.printf("\nDigite o status da equipe: ");
			return Integer.parseInt(entrada.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Você só pode digitar número referentes a opção.");
			return 0;
		}
	}

	public static int escolhaComite() {
		int i = 1;
		try {
			System.out.println("\nComitês cadastrados: ");
			for (ComiteOlimpico c : ComiteOlimpico.getLista_comites()) {
				System.out.printf("[%d] - %s\n", i, c.getNome());
				i++;
			}
         
			System.out.print("\nDigite o número do comitê desejado: ");
			i = Integer.parseInt(entrada.nextLine());
      ComiteOlimpico.getLista_comites().get(i-1);
			return i;
		} catch(NumberFormatException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		}
	}//

	public static int escolhaComite(String nome) {
		int i = 1;
		try {
			System.out.println("\nComitês cadastrados: ");
            for (ComiteOlimpico c : ComiteOlimpico.getLista_comites()) {
                System.out.printf("[%d] - %s\n", i, c.getNome());
                i++;
            }
            if (!ComiteOlimpico.getLista_comites().isEmpty()){
                System.out.print("\nDigite o número do comitê que a(o) " + nome + " pertence," + "\n"
                    + "caso o comitê não esteja na lista, digite '0'." + "\n" + "Sua escolha: ");
                i = Integer.parseInt(entrada.nextLine());
                ComiteOlimpico.getLista_comites().get(i-1);
                return i;
            } else {
							System.out.println("Nenhum comitê cadastrado.");
							return 0;
						}
		} catch(NumberFormatException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		}
	}

	public static int escolherEquipe(int indice) {
		int i = 1;
		boolean sinalizador = true;
		while (sinalizador) {
			try {
				System.out.println("\nEquipes cadastradas do comitê "+ ComiteOlimpico.getLista_comites().get(indice).getNome() +":");
				for (Equipe equipe : ComiteOlimpico.getLista_comites().get(indice).getEquipe()) {
					System.out.printf("[%d] - %s\n", i, equipe.getNome());
					i++;
				}
				System.out.println("\nDigite o número da Equipe desejada: ");
				i = Integer.parseInt(entrada.nextLine());
				ComiteOlimpico.getLista_comites().get(indice).getEquipe().get(i-1);
				sinalizador = false;
				return i;
			} catch(NumberFormatException e) {
				System.out.println("\nDigite apenas números inteiros dentro das opções.");
				return 0;
			} catch(IndexOutOfBoundsException e) {
				System.out.println("\nDigite apenas números inteiros dentro das opções.");
				return 0;
			}
		}
		return 0;
	}

	public static int escolherAtleta(int indice1, int indice2) {
		int i = 1;
		
		try {
			System.out.println("\nAtletas cadastrados do comitê "+ ComiteOlimpico.getLista_comites().get(indice1).getNome() + " e da equipe "+ 
				ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getNome() + ": ");
			for (Atleta atleta : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getAtletas()) {
				System.out.printf("[%d] - %s\n", i, atleta.getNome());
				i++;
			}
			System.out.println("\nDigite o número do Atleta desejado: ");
			i = Integer.parseInt(entrada.nextLine());
            ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getAtletas().get(i-1);
			return i;
		} catch(NumberFormatException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		}
	}

	public static int escolherTecnico(int indice1, int indice2) {
		int i = 1;
		try {
			System.out.println("\nTécnicos cadastrados do comitê "+ ComiteOlimpico.getLista_comites().get(indice1).getNome() + " e de equipe "+ 
				ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getNome() + ": ");
			for (Tecnico tecnico : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getComissaoTecnica()) {
				System.out.printf("[%d] - %s\n", i, tecnico.getNome());
				i++;
			}
			System.out.println("\nDigite o número do técnico: ");
			i = Integer.parseInt(entrada.nextLine());
            ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getComissaoTecnica().get(i-1);
			return i;
		} catch(NumberFormatException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("\nDigite apenas números inteiros dentro das opções.");
			return 0;
		}
	}
}