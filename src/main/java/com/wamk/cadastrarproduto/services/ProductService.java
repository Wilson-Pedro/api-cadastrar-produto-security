package com.wamk.cadastrarproduto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wamk.cadastrarproduto.entities.Product;
import com.wamk.cadastrarproduto.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
}
