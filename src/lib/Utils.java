package lib;

import java.util.Scanner;

import classes.Atleta;
import classes.ComiteOlimpico;
import classes.Equipe;
import classes.Tecnico;

public class Utils {

	public static Scanner entrada = new Scanner(System.in);

	public static boolean sinalizadora;

	public static void menuPrincipal() {
		System.out.println("[1] Gerenciar Comit�...........");
		System.out.println("[2] Gerenciar Equipe...........");
		System.out.println("[3] Gerenciar Atleta...........");
		System.out.println("[4] Gerenciar Comiss�o T�cnica.");
		System.out.println("[0] SAIR.......................");
	}

	public static void menu(String nome) {
		System.out.println("[1] Adicionar " + nome + ".");
		System.out.println("[2] Remover " + nome + ".");
		System.out.println("[3] Alterar " + nome + ".");
		System.out.println("[4] Listar " + nome + ".");
		System.out.println("[5] Buscar " + nome + ".");
		System.out.println("[0] VOLTAR.                  ");

	}

	public static int menuAlterarEquipe() {
		System.out.println("[1] Nome.......................");
		System.out.println("[2] Modalidade.................");
		System.out.println("[3] Comitê.....................");
		System.out.println("[4] Atleta.....................");
		System.out.println("[0] CANCELAR...................");
		try {
			System.out.printf("O que deseja alterar em equipe: ");
			return entrada.nextInt();
		} catch (Exception e) {
			System.out.println("Você só pode digitar número referentes a opção!");
			return 0;
		}
	}

	public static int escolhaComite() {
		int i = 0;
		for (ComiteOlimpico c : ComiteOlimpico.getLista_comites()) {
			System.out.printf("[%d] - %s\n", i+1, c.getNome());
			i++;
		}

		System.out.print("Digite o n�mero do comit� desejado: ");
		return entrada.nextInt();
	}

	public static int escolhaComite2(String nome) {
		int i = 0;
		for (ComiteOlimpico c : ComiteOlimpico.getLista_comites()) {
			System.out.printf("[%d] - %s\n", i+1, c.getNome());
			i++;
		}

		System.out.print("Digite o n�mero do comit� que a(o) " + nome + " pertence," + "\n"
				+ "caso o comit� n�o esteja na lista, digite '0'." + "\n" + "Sua escolha: ");
		return entrada.nextInt();
	}

	public static int escolherEquipe(int indice) {
		int i = 0;
		for (Equipe equipe : ComiteOlimpico.getLista_comites().get(indice).getEquipe()) {
			System.out.printf("[%d] - %s\n", i+1, equipe.getNome());
			i++;
		}
		System.out.println("Digite o n�mero da Equipe desejada: ");
		return Utils.entrada.nextInt();
	}

	public static int escolherAtleta(int indice1, int indice2) {
		int i = 0;
		for (Atleta atleta : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getAtletas()) {
			System.out.printf("[%d] - %s\n", i+1, atleta.getNome());
			i++;
		}
		System.out.println("Digite o n�mero do Atleta desejado: ");
		return Utils.entrada.nextInt();
	}

	public static int escolherTecnico(int indice1, int indice2) {
		int i = 0;
		for (Tecnico tecnico : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2)
				.getComissaoTecnica()) {
			System.out.printf("[%d] - %s\n", i+1, tecnico.getNome());
			i++;
		}
		System.out.println("Digite o n�mero do T�cnico desejado: ");
		return Utils.entrada.nextInt();
	}
}
