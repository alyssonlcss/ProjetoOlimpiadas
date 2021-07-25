package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interfaces.OperacoesComuns;

public class ComiteOlimpico implements OperacoesComuns{
	
	private String nome;
	private String pais;
	private List<Equipe> equipes;
	private Scanner scanner;
	
	public ComiteOlimpico() {
		equipes = new ArrayList<Equipe>();
		scanner = new Scanner(System.in);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Equipe> getEquipe() {
		return equipes;
	}

	public void setEquipe(List<Equipe> equipe) {
		this.equipes = equipe;
	}
	
	@Override
	public String toString() {
		return "ComiteOlimpico [nome=" + nome + ", equipe=" + equipes + "]";
	}
	
	public boolean adicionarComite() {
		String temp;
		System.out.printf("Nome do comitê: ");
		this.nome = scanner.nextLine();
		System.out.printf("País: ");
		this.pais = scanner.nextLine();
		do {
			System.out.printf("Adicionar equipe agora? digite: 'sim' ou 'não' caso contrário");
			temp = scanner.nextLine();
		} while (!(temp.equals("sim") || temp.equals("não")));
		if(temp == "sim") {
			Equipe equipe = new Equipe();
			equipe.adicionarEquipe();
		}

		return true;
	}
	
	public boolean alterarComite() {
		return false;
	}
	
	@Override
	public boolean remover(String nome) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String buscar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarDados() {
		System.out.println(this.toString());
		
	}

}
