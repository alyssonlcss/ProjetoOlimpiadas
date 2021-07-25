package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interfaces.OperacoesComuns;

public class Atleta extends CredenciadoOlimpico implements OperacoesComuns{

	private String nome;
	private String sexo;
	private List<Medalha> medalhas;
	private Equipe equipe;
	private Scanner scanner;

	Atleta() {
		medalhas = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public List<Medalha> getMedalhas() {
		return medalhas;
	}

	public void setMedalhas(List<Medalha> medalhas) {
		this.medalhas = medalhas;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	

	@Override
	public boolean verificarCredenciais(String id) {
		if(id.equals(this.getId())){
			return true;
		}else{
			return false;
		}
	}

	private void adicionarMedalhas() {
		ArrayList<Integer> n_medalhas = new ArrayList<>();
		
		scanner.nextLine();
		System.out.printf("Quantidade de ouro: ");
		n_medalhas.add(scanner.nextInt());
		System.out.printf("Quantidade de prata: ");
		n_medalhas.add(scanner.nextInt());
		System.out.printf("Quantidade de bronze: ");
		n_medalhas.add(scanner.nextInt());
		if (n_medalhas.get(0) > 0) {
			Medalha ouro = new Medalha();
			ouro.setMaterial("Ouro");
			ouro.setQuantidade(n_medalhas.get(0));
			System.out.printf("Ano: ");
			ouro.setAno(scanner.nextInt());
			medalhas.add(ouro);
		}
		if (n_medalhas.get(1) > 0) {
			Medalha prata = new Medalha();
			prata.setMaterial("prata");
			prata.setQuantidade(n_medalhas.get(1));
			System.out.printf("Ano: ");
			prata.setAno(scanner.nextInt());
			medalhas.add(prata);
		}
		if (n_medalhas.get(2) > 0) {
			Medalha bronze = new Medalha();
			bronze.setMaterial("bronze");
			bronze.setQuantidade(n_medalhas.get(2));
			System.out.printf("Ano: ");
			bronze.setAno(scanner.nextInt());
			medalhas.add(bronze);
		}

	}

	public boolean adicionarAtleta() {
		String temp;

		System.out.printf("Nome do atleta: ");
		this.nome = scanner.nextLine();
		System.out.printf("Sexo: ");
		this.sexo = scanner.nextLine();
		do {
			System.out.printf("O atleta possui medalha? digite: 'sim' ou 'não' caso contrário");
			temp = scanner.nextLine();
		} while (!(temp.equals("sim") || temp.equals("não")));
		if (temp.equals("sim")) {
			adicionarMedalhas();
		}
		return true;
	}
	
	public boolean alterarAtleta() {
		return false;
	}
	
	@Override
	public boolean remover(String nome) {
		return false;
	}

	@Override
	public String buscar(String nome) {
		return null;
	}

	@Override
	public void listarDados() {
		System.out.println(this.toString());
	}


	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", sexo='" + getSexo() + "'" +
			", medalha='" + getMedalhas() + "'" +
			", equipe='" + getEquipe() + "'" +
			"}";
	}
	
}
