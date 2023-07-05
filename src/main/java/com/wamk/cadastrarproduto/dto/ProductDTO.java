package com.wamk.cadastrarproduto.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "productName is mandatory")
	private String productName;
	
	@NotNull(message = "value cannot be null")
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
