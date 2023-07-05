package com.wamk.cadastrarproduto.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productName;
	private Double value;
	
	public ProductDTO() {
	}

	public ProductDTO(String productName, Double value) {
		this.productName = productName;
		this.value = value;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
