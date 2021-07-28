package classes;

import java.util.ArrayList;
import interfaces.OperacoesComuns;
import lib.Utils;

public class Atleta extends CredenciadoOlimpico implements OperacoesComuns {
	
	private String nome;
	private String sexo;
	private ArrayList<Integer> medalhas = new ArrayList<>();
	
	
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
	
	public ArrayList<Integer> getMedalhas() {
		return medalhas;
	}

	public void setMedalhas(ArrayList<Integer> medalhas) {
		this.medalhas = medalhas;
	}


	@Override
	public void adicionar() {
		String temporario;
		
		System.out.printf("Digite o nome do Atleta: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o sexo do Atleta: ");
		this.sexo = Utils.entrada.nextLine(); 
		
		
		System.out.printf("\nDeseja adicionar Medalhas agora? digite... 'sim' ou 'não' caso contrário: ");
		temporario = Utils.entrada.nextLine(); 
			
		if (temporario.equalsIgnoreCase("sim")) this.adicionarMedalhasDoAtleta();
	}

	@Override
	public void listarDados() {
		
	}
	
	public void alterarAtleta() {
		
	}
	
	public static Atleta buscar(String nome) {

		for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
			for (Equipe equipe : comite.getEquipe()) {
				for (Atleta atleta : equipe.getAtletas()) {
					if (atleta.getNome().equalsIgnoreCase(nome)) {
						return atleta;
					}
				}
			}
		}
		return null;
	}

	public void adicionarMedalhasDoAtleta() {
		
		System.out.printf("Digite a quantidade da medalha de Ouro: ");
		this.medalhas.add(Utils.entrada.nextInt());
		
		System.out.printf("Digite a quantidade da medalha de Prata: ");
		this.medalhas.add(Utils.entrada.nextInt());
		
		System.out.printf("Digite a quantidade da medalha de Bronze: ");
		this.medalhas.add(Utils.entrada.nextInt());	 Utils.entrada.nextLine();
	}
}
