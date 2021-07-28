package lib;

import java.util.Scanner;

import classes.Atleta;
import classes.ComiteOlimpico;
import classes.Equipe;
import classes.Tecnico;

public class Utils {
		
	   public static Scanner entrada  = new Scanner(System.in);
	   
	   public static boolean sinalizadora;
	   
	   public static void menuPrincipal() {
	        System.out.println("[1] Gerenciar Comitê...........");
	        System.out.println("[2] Gerenciar Equipe...........");
	        System.out.println("[3] Gerenciar Atleta...........");
	        System.out.println("[4] Gerenciar Comissão Técnica.");
	        System.out.println("[0] SAIR.......................");
	    }
	    
	    
	    public static void menu(String nome) {
	        System.out.println("[1] Adicionar " + nome + ".");
	        System.out.println("[2] Remover "   + nome + ".");
	        System.out.println("[3] Alterar "   + nome + ".");
	        System.out.println("[4] Listar "    + nome + ".");
	        System.out.println("[5] Buscar "    + nome + ".");
	        System.out.println("[0] VOLTAR.                  ");
	    }

		public static int escolhaComite() {
			int i = 0;
			for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
				System.out.printf("[%d] - %s\n",i, c.getNome());
				i++;
			}

			System.out.printf("Digite o número do comitê desejado: ");
			return entrada.nextInt();
	    }

		public static int escolhaComite2(String nome) {
			int i = 0;
			for (ComiteOlimpico c: ComiteOlimpico.getLista_comites()) {
				System.out.printf("[%d] - %s\n",i, c.getNome());
				i++;
			}

			System.out.printf("Digite o número do comitê que a(o) "+ nome +" pertence," +"\n"+
				"caso o comitê não esteja na lista, digite '0'." +"\n"+
				"Sua escolha: ");
			return entrada.nextInt();
	    }
		
		
		public static int escolherEquipe(int indice) {
			int i = 0;
			for (Equipe equipe : ComiteOlimpico.getLista_comites().get(indice).getEquipe()) {
				System.out.printf("[%d] - %s\n",i, equipe.getNome());
				i++;
			}
			System.out.println("Digite o número da Equipe desejada: ");
			return Utils.entrada.nextInt();
		}
		

		public static int escolherAtleta(int indice1, int indice2) {
			int i = 0;
			for (Atleta atleta : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getAtletas()) {
				System.out.printf("[%d] - %s\n",i, atleta.getNome());
				i++;
			}
			System.out.println("Digite o número do Atleta desejado: ");
			return Utils.entrada.nextInt();
		}
		
		public static int escolherTecnico(int indice1, int indice2) {
			int i = 0;
			for (Tecnico tecnico : ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getComissaoTecnica()) {
				System.out.printf("[%d] - %s\n",i, tecnico.getNome());
				i++;
			}
			System.out.println("Digite o número do Técnico desejado: ");
			return Utils.entrada.nextInt();
		}
}
