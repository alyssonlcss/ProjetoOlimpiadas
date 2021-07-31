package classes;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Tecnico extends CredenciadoOlimpico implements OperacoesComuns {
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

		System.out.printf("Digite o nome do Técnico: ");
		this.nome = Utils.entrada.nextLine();
		System.out.printf("Digite o cargo do Técnico: ");
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
		System.out.println("Tecnico { \nnome=" + this.getNome() + ", " + "\ncargo=" + this.getCargo() + "\n");
	}

	public void alterarTecnico() {

		System.out.println("Digite o novo nome do técnico: ");
		this.setNome(Utils.entrada.nextLine());

		System.out.println("Digite o novo cargo do técnico: ");
		this.setCargo(Utils.entrada.nextLine());
	}

}