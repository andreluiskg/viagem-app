package com.andreluiskg.cliente;

public class Cliente {

	private Long id;
	private String nome;

	private Cliente(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	private Cliente(String nome) {
		this.nome = nome;
	}

	public static Cliente of(Long id, String nome) {
		return new Cliente(id, nome);
	}

	public static Cliente of(String nome) {
		return new Cliente(nome);
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
