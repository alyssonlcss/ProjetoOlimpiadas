package classes;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Tecnico implements OperacoesComuns{
	private String nome;
	private String cargo;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public void adicionar() {
		
		System.out.printf("Digite o nome do T�cnico: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o cargo do T�cnico: ");
		this.cargo = Utils.entrada.nextLine(); 
		
	}
	
	public static Tecnico buscar(String nome) {
	
		for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
			for (Equipe equipe : comite.getEquipe()) {
				for (Tecnico tecnico : equipe.getComissaoTecnica()) {
					if (tecnico.getNome().equalsIgnoreCase(nome)) {
						return tecnico;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void listarDados() {
			
	}
	
	public void alterarTecnico(int indice1, int indice2, int indice3) {
		Tecnico tecnico = ComiteOlimpico.getLista_comites().get(indice1).getEquipe().get(indice2).getComissaoTecnica().get(indice3);
		
		System.out.println("Digite o novo nome do t�cnico: "); Utils.entrada.nextLine();
		tecnico.setNome(Utils.entrada.nextLine());
		
		System.out.println("Digite o novo cargo do t�cnico: "); Utils.entrada.nextLine();
		tecnico.setCargo(Utils.entrada.nextLine());
	}
	
}
