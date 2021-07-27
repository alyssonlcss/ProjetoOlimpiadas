package classes;

import interfaces.OperacoesComuns;
import lib.Utils;

public class Medalha implements OperacoesComuns{
	private String material;
	private int quantidade;
	private int ano;
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public void adicionar() {
		System.out.println("Quantidade de Medalhas de " + this.material + " do Atleta: ");
		this.quantidade = Utils.entrada.nextInt();
		
		System.out.println("Ano do ganho dessa medalha de " + this.material + ": ");
		this.ano = Utils.entrada.nextInt();
	}
	
	@Override
	public boolean remover(int indice) {
		
		return false;
	}
	
	public static String buscar(String nome) {
		
		return null;
	}
	@Override
	public void listarDados() {
		
		
	}
}
