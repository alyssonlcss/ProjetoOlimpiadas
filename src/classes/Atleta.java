package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Atleta implements OperacoesComuns{
	
	private String nome;
	private String sexo;
	private ArrayList<Medalha> medalhas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public ArrayList<Medalha> getMedalhas() {
		return medalhas;
	}
	
	public void setMedalhas(ArrayList<Medalha> medalhas) {
		this.medalhas = medalhas;
	}

	public Medalha removerMedalha(int ano) {
		Medalha medalhaRemovida = null;
		for(int i = 0; i < this.medalhas.size(); i++) {
			if(this.medalhas.get(i).getAno() == ano) {
				medalhaRemovida = this.medalhas.remove(i);
			}
		}
		return medalhaRemovida;
	} 

	@Override
	public void adicionar() {
		
		String temporario;
		
		System.out.printf("Digite o nome do Atleta: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o sexo do Atleta: ");
		this.sexo = Utils.entrada.nextLine();
		
		while (true) {
			System.out.printf("Deseja adicionar Medalhas agora? digite... 'sim' ou 'não' caso contrário: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("sim"))      this.adicionarMedalhasDoAtleta();
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
	
	public void adicionarMedalhasDoAtleta() {
		String existeOuro, existePrata, existeBronze;
		
		System.out.printf("Atleta possui medalha de Ouro ? [sim ou não]");
		existeOuro = Utils.entrada.nextLine();
		System.out.printf("Atleta possui medalha de Prata ? [sim ou não]");
		existePrata = Utils.entrada.nextLine();
		System.out.printf("Atleta possui medalha de Bronze ? [sim ou não]");
		existeBronze = Utils.entrada.nextLine();
		
		if (existeOuro.equalsIgnoreCase("sim")) {
			Medalha ouro = new Medalha();
			ouro.setMaterial("Ouro");
			ouro.adicionar();
			this.medalhas.add(ouro);
		}
		
		if (existePrata.equalsIgnoreCase("sim")) {
			Medalha prata= new Medalha();
			prata.setMaterial("Prata");
			prata.adicionar();
			this.medalhas.add(prata);
		}
		
		if (existeBronze.equalsIgnoreCase("sim")) {
			Medalha bronze = new Medalha();
			bronze.setMaterial("Bronze");
			bronze.adicionar();
			this.medalhas.add(bronze);
		}
	}
}
