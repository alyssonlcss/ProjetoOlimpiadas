package Classes;

public abstract class CredenciadoOlimpico {
	
	private String nome;
	private String id;
	
	public abstract boolean verificarCredenciais(String id);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
