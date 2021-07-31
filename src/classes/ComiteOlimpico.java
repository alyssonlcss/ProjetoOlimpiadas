package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;

public class ComiteOlimpico implements OperacoesComuns {

	private String nome;
	private String pais;
	private ArrayList<Equipe> equipes = new ArrayList<>();
	private static ArrayList<ComiteOlimpico> lista_comites = new ArrayList<>();

	public ComiteOlimpico() {
		lista_comites.add(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public ArrayList<Equipe> getEquipe() {
		return equipes;
	}

	public void setEquipe(ArrayList<Equipe> equipe) {
		this.equipes = equipe;
	}

	public static ArrayList<ComiteOlimpico> getLista_comites() {
		return lista_comites;
	}

	public static void setLista_comites(ArrayList<ComiteOlimpico> lista_comites) {
		ComiteOlimpico.lista_comites = lista_comites;
	}

	@Override
	public void adicionar() {
		String temporario;

		System.out.print("Digite o nome do comitê: ");
		this.nome = Utils.entrada.nextLine();
		System.out.print("Digite o País do comitê: ");
		this.pais = Utils.entrada.nextLine();

		while (true) {
			System.out.print("\nDeseja adicionar alguma equipe? [s/n]: ");
			temporario = Utils.entrada.nextLine();

			if (temporario.equalsIgnoreCase("s"))
				this.adicionarEquipeAoComite();
			else if (temporario.equalsIgnoreCase("n"))
				break;
			else
				System.out.println("Você digitou uma opção inválida! Digite novamente.");
		}
	}

	public boolean elegerEquipeOndeAddAtleta(int indice) {
		int result;
		for (int i = 0; i < lista_comites.get(indice).equipes.size(); i++) {
			System.out.printf("[%d] - %s\n", i+1, lista_comites.get(indice).equipes.get(i).getNome());
		}
		System.out.print("Digite o número da equipe que a(o) atleta pertence," + "\n"
				+ "caso a equipe não esteja na lista, digite '0'." + "\n" + "Sua escolha: ");
		result = Utils.entrada.nextInt();
		if (result == 0)
			return false;
		Utils.entrada.nextLine();
		lista_comites.get(indice).equipes.get(result-1).adicionarAtletaEmEquipe();
		return true;
	}

	public boolean elegerEquipeOndeAddTecnico(int indice) {
		int result;
		for (int i = 0; i < lista_comites.get(indice).equipes.size(); i++) {
			System.out.printf("[%d] - %s\n", i+1, lista_comites.get(indice).equipes.get(i).getNome());
		}
		System.out.print("Digite o número da equipe que a(o) técnico pertence," + "\n"
				+ "caso a equipe não esteja na lista, digite '0'." + "\n" + "Sua escolha: ");
		result = Utils.entrada.nextInt();
		if (result == 0)
			return false;
		Utils.entrada.nextLine();
		lista_comites.get(indice).equipes.get(result-1).adicionarTecnicoEmEquipe();
		return true;
	}

	public boolean removerComite(int indice) {
		return lista_comites.remove(lista_comites.get(indice));

	}

	public static ComiteOlimpico buscar(String nome) {
		for (ComiteOlimpico comite : lista_comites) {
			if (nome.equalsIgnoreCase(comite.nome)) {
				return comite;
			}
		}
		return null;
	}

	@Override
	public void listarDados() {
		System.out.println("Nome do comitê = " + this.nome + " | País do Comitê = " + this.pais);
		for (Equipe equipe : this.equipes) {
			System.out.println(
					"Equipe(s) { \nnome=" + equipe.getNome() + ", " + "\nmodalidade=" + equipe.getModalidade() + "\n");
		}
		System.out.println("}");
	}

	public void adicionarEquipeAoComite() {
		Equipe equipe = new Equipe();
		equipe.adicionar();
		this.equipes.add(equipe);
	}

	public void alterarComite(int indice) {
		ComiteOlimpico comite = lista_comites.get(indice);

		System.out.printf("Digite o novo nome do comitê: ");
		comite.setNome(Utils.entrada.nextLine());

		System.out.printf("Digite o novo país do comitê: ");
		comite.setPais(Utils.entrada.nextLine());
	}

	public boolean removerEquipeDoComite(int indice) {
		if (this.equipes.remove(indice) != null)
			return true;
		else
			return false;
	}

	public static void listarAtletasDosComites() {
		for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
			System.out.println("Comitê - " + comite.getNome());
			for (Equipe equipe : comite.getEquipe()) {
				System.out.println("\tEquipe - " + equipe.getNome());
				for (Atleta atleta : equipe.getAtletas()) {
					System.out.println("Atleta { \nnome=" + atleta.getNome());
					System.out.println("\t\tOuro -> " + atleta.getMedalhas().get(0));
					System.out.println("\t\tPrata -> " + atleta.getMedalhas().get(1));
					System.out.println("\t\tBronze -> " + atleta.getMedalhas().get(2));
				}
			}
		}
	}

}
