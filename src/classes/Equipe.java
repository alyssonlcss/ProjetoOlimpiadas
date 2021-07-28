package classes;

import java.util.ArrayList;


import interfaces.OperacoesComuns;
import lib.Utils;

public class Equipe implements OperacoesComuns{
	
	private String nome;
	private String modalidade;
	private ComiteOlimpico comite;
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
	
	public ComiteOlimpico getComite() {
		return comite;
	}

	public void setComite(ComiteOlimpico comite) {
		this.comite = comite;
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
		
		
		if (Utils.sinalizadora) {
			System.out.println("\nEscolha um comitê para adicionar sua equipe!");
			System.out.println("Comitês disponíveis:");
			int i = 0;
			for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
				System.out.printf("[%d] %s\n",i,comite.getNome()); 
	    		i++;
			}
			
			i = Utils.entrada.nextInt(); Utils.entrada.nextLine();
			
			ComiteOlimpico.getLista_comites().get(i).getEquipe().add(this);

		}
		
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

	public static Equipe buscar(String nome) {
		for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
			for (Equipe equipe : comite.getEquipe()) {
				if (equipe.getNome().equalsIgnoreCase(nome)) {
					return equipe;
				}
			}
		}
		return null;
	}

	@Override
	public void listarDados() {	
		System.out.println("Equipe { \nnome=" + this.getNome() + ", " + "\nmodalidade=" + this.getModalidade() + "\n");

		for (Atleta atleta : atletas) {
			System.out.println("\tAtleta { \n\tnome=" + atleta.getNome() + ", " + "\n\tSexo=" + atleta.getSexo() + "\n");
		}
		System.out.println("\n\t}");
		for (Tecnico tecnico : comissaoTecnica) {
			System.out.println("\tTécnico { \n\tnome=" + tecnico.getNome() + ", " + "\n\tCargo=" + tecnico.getCargo() + "\n");
		}
		System.out.println("\n\t}");
		System.out.println("}");
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

	public void alterarEquipe(int index, int index2) {
		int result = Utils.menuAlterarEquipe();
		if(result == 1) {
			System.out.printf("Novo nome da equipe: ");
			this.nome = Utils.entrada.nextLine();
		} else if(result == 2) {
			System.out.printf("Nova modalidade da equipe: ");
			this.modalidade = Utils.entrada.nextLine();
		} else if(result == 3) {
			atletas.get(Utils.escolherAtleta(index, index2)).alterarAtleta();
		} else if(result == 4) {
			int index3 = Utils.escolherTecnico(index, index2);
			comissaoTecnica.get(index3).alterarTecnico(index, index2, index3);
		} else {
			System.out.println("Nenhuma alteração foi feita.");
		}

	}
	
	public Atleta removerAtletaDeEquipe(int indice) {
		return this.atletas.remove(indice);
	}
	
	public Tecnico removerTecnicoDeEquipe(int indice) {
		return this.comissaoTecnica.remove(indice);
	}
}
