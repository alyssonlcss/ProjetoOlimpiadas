package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Atleta implements OperacoesComuns {
	
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
	
	public void adicionarMedalhasDoAtleta() {
		Medalha medalha = new Medalha();
		String strMedalha;
		int ano;
	
		System.out.printf("Digite a medalha do atleta: ");
		strMedalha = Utils.entrada.nextLine();
		medalha.setMaterial(strMedalha);

		System.out.printf("Digite o ano de aquisição da medalha: ");
		ano = Utils.entrada.nextInt();
		medalha.setAno(ano);

		this.medalhas.add(medalha);
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
	
	public void listarMedalhasAtleta(String tipo) {
		int count = 0;
		for(int i = 0; i < this.medalhas.size(); i++) {
			if(tipo == this.medalhas.get(i).getMaterial()) {
				System.out.printf("Medalha: %s, ano: %d\n", this.medalhas.get(i).getMaterial(), this.medalhas.get(i).getAno());
				count++;
			}
		}
		System.out.printf("Quantidade de medalhas de %s ganhas pelo atetla: %d\n", tipo, count);
	}

	@Override
	public void adicionar() {
		String temporario;
		
		System.out.printf("Digite o nome do Atleta: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o sexo do Atleta: ");
		this.sexo = Utils.entrada.nextLine();
		
		while (true) {
			System.out.printf("\nDeseja adicionar Medalhas agora? digite... 'sim' ou 'não' caso contrário: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("sim"))      
				this.adicionarMedalhasDoAtleta();
			else if (temporario.equalsIgnoreCase("não")) 
				break;
			else                   
				System.out.println("Você digitou uma opção inválida! Digite novamente.");
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
		return;
	}
}
