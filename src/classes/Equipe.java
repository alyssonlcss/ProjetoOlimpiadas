package classes;

import java.util.ArrayList;
import interfaces.OperacoesComuns;
import lib.Utils;
import ENUMs.Status;

public class Equipe implements OperacoesComuns{
	
	private String nome;
	private String modalidade;
	private Status status;
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
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return this.status;
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

	public int getOuro() {
		int qtt = 0;
		for(int i = 0; i < atletas.size(); i++) {
			qtt += atletas.get(i).getMedalhas().get(0);
		}
		return qtt;
	}
	public int getPrata() {
		int qtt = 0;
		for(int i = 0; i < atletas.size(); i++) {
			qtt += atletas.get(i).getMedalhas().get(1);
		}
		return qtt;
	}
	public int getBronze() {
		int qtt = 0;
		for(int i = 0; i < atletas.size(); i++) {
			qtt += atletas.get(i).getMedalhas().get(2);
		}
		return qtt;
	}

	@Override
	public void adicionar() {
		String temporario;
		
		System.out.printf("Digite o nome da equipe: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite a modalidade da equipe: ");
		this.modalidade = Utils.entrada.nextLine();
		int temp = Utils.menuStatus();
		if (temp == 1)
            		this.setStatus(Status.MEDALHISTA);
        	else if (temp == 2)
           		 this.setStatus(Status.DESCLASSIFICADO);
        	else if (temp == 3)
            		this.setStatus(Status.EM_ANDAMENTO);
       		else
            		this.setStatus(Status.CLASSIFICADO);
		
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
			System.out.printf("\nDeseja adicionar algum Atleta nessa Equipe? [s/n]: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("s"))      this.adicionarAtletaEmEquipe();
			else if (temporario.equalsIgnoreCase("n")) break;
			else                                         System.out.println("Você digitou uma opção inválida! Digite novamente.");
		}
		
		while (true) {
			System.out.printf("\nVocê deseja também adicionar um Técnico agora? [s/n]: ");
			temporario = Utils.entrada.nextLine();
			
			if (temporario.equalsIgnoreCase("s"))      this.adicionarTecnicoEmEquipe();
			else if (temporario.equalsIgnoreCase("n")) break;
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
		System.out.println("Equipe { \nNome = " + this.getNome() + ", " + "\nModalidade = " + this.getModalidade() + "\nStatus = " + this.getStatus() + "\n");
		int qttQuro = getOuro(), qttPrata = getPrata(), qttBronze = getBronze();
		System.out.println("Quantidade de medalhas de Ouro: " + qttQuro);
		System.out.println("Quantidade de medalhas de Prata: " + qttPrata);
		System.out.println("Quantidade de medalhas de Bronze: " + qttBronze);
		System.out.println("TOTAL DE MEDALHAS: " + (qttQuro + qttPrata + qttBronze) + "\n");

		for (Atleta atleta : atletas) {
			System.out.println("   Atleta { \n   nome = " + atleta.getNome() + ", " + "\n   Sexo = " + atleta.getSexo() + "\n");
		}
		System.out.println("\n\t}");
		for (Tecnico tecnico : comissaoTecnica) {
			System.out.println("   Técnico { \n   nome = " + tecnico.getNome() + ", " + "\n   Cargo = " + tecnico.getCargo() + "\n");
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
		try {
			
			if(result == 1) {
				System.out.printf("Novo nome da equipe: ");
				this.nome = Utils.entrada.nextLine();
			} else if(result == 2) {
				System.out.printf("Nova modalidade da equipe: ");
				this.modalidade = Utils.entrada.nextLine();
			} else if(result == 3) {
				result = Utils.escolherAtleta(index, index2);
				this.atletas.get(result-1).alterarAtleta();
			} else if(result == 4) {
				result = Utils.escolherTecnico(index, index2);
				this.comissaoTecnica.get(result-1).alterarTecnico();
			} else if(result == 0) {
				System.out.println("Nenhuma alteração foi feita.");
			}
		} catch(IndexOutOfBoundsException e) {
				System.out.println("Digite apenas números inteiros dentro das opções.");
		}
		if(result > 0 && result < 5)
			System.out.println("Alteração realizada com sucesso!");
	}
	
	public boolean removerAtletaDeEquipe(int indice) {
		if (this.atletas.remove(indice) != null)
			return true;
		else                                     
			return false;	
	}
	
	public boolean removerTecnicoDeEquipe(int indice) {
		if(this.comissaoTecnica.remove(indice) != null)
			return true;
		else
			return false;
	}
}
