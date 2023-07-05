package com.wamk.cadastrarproduto.exceptionhandler;

import java.io.Serializable;

public class Campo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String mesage;
	
	public Campo() {
	}

	public Campo(String name, String mesage) {
		this.name = name;
		this.mesage = mesage;
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
}
