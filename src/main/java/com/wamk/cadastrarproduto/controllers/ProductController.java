package com.wamk.cadastrarproduto.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wamk.cadastrarproduto.dto.ProductDTO;
import com.wamk.cadastrarproduto.entities.Product;
import com.wamk.cadastrarproduto.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Product> post(@RequestBody ProductDTO productDTO) {
		var product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		product = productService.save(product);
		return ResponseEntity.ok(product);
	}
}
