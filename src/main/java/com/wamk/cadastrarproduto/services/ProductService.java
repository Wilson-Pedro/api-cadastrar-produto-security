package com.wamk.cadastrarproduto.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(UUID id) {
		return productRepository.findById(id);
	}

	public void update(Product product) {
		product.setId(product.getId());
		productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}
}
