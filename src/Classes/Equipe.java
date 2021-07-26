package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interfaces.OperacoesComuns;

public class Equipe implements OperacoesComuns{
	
	private String nome;
	private String modalidade;
	private List<Atleta> atletas;
	private List<Tecnico> comissaoTecnica;
	private Scanner scanner;

	Equipe() {
		atletas = new ArrayList<Atleta>();
		comissaoTecnica = new ArrayList<Tecnico>();
		scanner = new Scanner(System.in);
	}
	
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

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	public List<Tecnico> getComissaoTecnica() {
		return comissaoTecnica;
	}

	public void setComissaoTecnica(List<Tecnico> comissaoTecnica) {
		this.comissaoTecnica = comissaoTecnica;
	}
	
	public void adicionar() {
		Atleta atleta = new Atleta();
		atleta.adicionarAtleta();
		atletas.add(atleta);
	}

	public boolean adicionarEquipe() {
		String temp;
		System.out.printf("Nome da Equipe: ");
		this.nome = scanner.nextLine();
		System.out.printf("Modalidade: ");
		this.modalidade = scanner.nextLine();
		do {
			System.out.printf("Adicionar atleta agora? digite: 'yes' ou 'no' caso contrário");
			temp = scanner.nextLine();
		} while (!(temp.equals("yes") || temp.equals("no")));
		if (temp.equals("yes")) {
			adicionar();
		}
		do {
			System.out.printf("Adicionar técnico agora? digite: 'sim' ou 'não' caso contrário");
			temp = scanner.nextLine();
		} while (!(temp.equals("sim") || temp.equals("não")));
		if (temp.equals("sim")) {
			Tecnico tecnico = new Tecnico();
			tecnico.adicionarTecnico();
		}
		
		return true;
	}
	
	public boolean alterarEquipe() {
		return false;
	}
	
	@Override
	public boolean remover(String nome) {
		if(nome.equals(this.getNome())) {
			atletas.clear();
			comissaoTecnica.clear();
			this.setModalidade(null);
			this.setNome(null);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String buscar(String nome) {
		if(nome.equals(this.getNome())) {
			listarDados();
			return nome + " foi encontrado!!!";
		}else {
			return "N�o foi encontrado!!!";
		}
		
	}

	@Override
	public void listarDados() {
		System.out.println(this.toString());
	}


	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", modalidade='" + getModalidade() + "'" +
			", atletas='" + getAtletas() + "'" +
			", comissaoTecnica='" + getComissaoTecnica() + "'" +
			"}";
	}

}
