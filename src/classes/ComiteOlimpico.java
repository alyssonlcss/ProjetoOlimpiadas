package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;


public class ComiteOlimpico implements OperacoesComuns{
	
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
		
		System.out.printf("Digite o nome do comitê: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o País do comitê: ");
		this.pais = Utils.entrada.nextLine();
		
		while (true) {
			System.out.printf("\nDeseja adicionar equipe agora? digite... 'sim' ou 'não' caso contrário: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("sim"))      this.adicionarEquipeAoComite();
			else if (temporario.equalsIgnoreCase("não")) break;
			else                                         System.out.println("Você digitou uma opção inválida! Digite novamente.");
		}
	}
	
	@Override
	public boolean remover(int indice) { 
		return lista_comites.remove(lista_comites.get(indice));
	}

	@Override
	public String buscar(String nome) {
		
		return null;
	}

	@Override
	public void listarDados() {
		System.out.println("Nome do comitê = " + this.nome + " País do Comitê = " + this.pais);
		System.out.println("Equipes deste comitê: ");
		for (Equipe equipe : this.equipes) {
			System.out.println("Equipe - nome = " + equipe.getNome() + ", " + " modalidade = " + equipe.getModalidade());
		}
	}

	
	public void adicionarEquipeAoComite() {
		Equipe equipe = new Equipe();
		equipe.adicionar();
		this.equipes.add(equipe);
	}
	
	public void alterarComite(int indice) {
		ComiteOlimpico comite = lista_comites.get(indice);
		
		System.out.println("Digite o novo nome do comitê: ");
		comite.setNome(Utils.entrada.nextLine());
		
		System.out.println("Digite o novo país do comitê: ");
		comite.setPais(Utils.entrada.nextLine());
	}
}
