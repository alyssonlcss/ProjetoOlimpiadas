package classes;

import interfaces.OperacoesComuns;

public class Medalha implements OperacoesComuns {
	private String material;
	private int ano;
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
		
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public void adicionar() {
		return;
	}
	
	@Override
	public boolean remover(int indice) {
		return false;
	}
	

	public static String buscar(String nome) {
  }

	
	@Override
	public void listarDados() {
		System.out.printf("Medalha de: %s, ano de conquista: %d\n", this.material, this.ano);
	}
}
