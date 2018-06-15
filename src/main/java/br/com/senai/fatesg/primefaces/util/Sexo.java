package br.com.senai.fatesg.primefaces.util;

public enum Sexo {
	MASCULINO,
	FEMININO;
	
	public Sexo[] getSexos() {
		return  values();
	}
	
	public String toString() {
		String old = super.toString();
		return old.substring(1 , 2) + old.substring(1).toLowerCase();
		
	}
}
