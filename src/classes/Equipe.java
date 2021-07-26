package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Equipe implements OperacoesComuns{
	
	private String nome;
	private String modalidade;
	private ArrayList<Atleta> atletas = new ArrayList<>();
	private ArrayList<Tecnico> comissaoTecnica = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	
	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}
	
	public void setAtletas(ArrayList<Atleta> atletas) {
		this.atletas = atletas;
	}
	
	public ArrayList<Tecnico> getComissaoTecnica() {
		return comissaoTecnica;
	}
	
	public void setComissaoTecnica(ArrayList<Tecnico> comissaoTecnica) {
		this.comissaoTecnica = comissaoTecnica;
	}

	@Override
	public void adicionar() {
		String temporario;
		
		System.out.printf("Digite o nome da Equipe: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite a modalidade da Equipe: ");
		this.modalidade = Utils.entrada.nextLine();
		
		System.out.println("Escolha um comitê para adicionar sua equipe!");
		System.out.println("Comitês disponíveis:");
		int i = 0;
		for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
			System.out.printf("[%d] %s\n",i,comite.getNome());
    		i++;
		}
		
		i = Utils.entrada.nextInt();
		
		ComiteOlimpico.getLista_comites().get(i).getEquipe().add(this);
		
		while (true) {
			System.out.printf("\nDeseja adicionar algum Atleta nessa Equipe? digite... 'sim' ou 'não' caso contrário: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("sim"))      this.adicionarAtletaEmEquipe();
			else if (temporario.equalsIgnoreCase("não")) break;
			else                                         System.out.println("Você digitou uma opção inválida! Digite novamente.");
		}
		
		while (true) {
			System.out.printf("\nVocê deseja também adicionar um Técnico agora? digite... 'sim' ou 'não' caso contrário: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("sim"))      this.adicionarTecnicoEmEquipe();
			else if (temporario.equalsIgnoreCase("não")) break;
			else                                         System.out.println("Você digitou uma opção inválida! Digite novamente.");
		}
	}

	@Override
	public boolean remover(int indice) {
		
		return false;
	}

	@Override
	public String buscar(String nome) {
		
		return null;
	}

	@Override
	public void listarDados() {
		
	}
	
	public void adicionarAtletaEmEquipe() {
		Atleta atleta = new Atleta();
		atleta.adicionar();
		this.atletas.add(atleta);
	}
	
	public void adicionarTecnicoEmEquipe() {
		Tecnico tecnico = new Tecnico();
		tecnico.adicionar();
		this.comissaoTecnica.add(tecnico);
	}
	
}
