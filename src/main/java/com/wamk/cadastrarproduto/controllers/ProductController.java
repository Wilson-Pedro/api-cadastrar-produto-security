package com.wamk.cadastrarproduto.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wamk.cadastrarproduto.dto.ProductDTO;
import com.wamk.cadastrarproduto.entities.Product;
import com.wamk.cadastrarproduto.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable UUID id){
		Optional<Product> productO = productService.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(productO.get());
	}

	@PostMapping
	public ResponseEntity<Product> post(@RequestBody @Valid ProductDTO productDTO) {
		var product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		product = productService.save(product);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> post(@RequestBody @Valid ProductDTO productDTO,
			@PathVariable UUID id) {
		Optional<Product> productO = productService.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		BeanUtils.copyProperties(productDTO, productO.get());
		productService.update(productO.get());
		return ResponseEntity.ok(productO.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> post(@PathVariable UUID id) {
		Optional<Product> productO = productService.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productService.delete(productO.get());
		return ResponseEntity.noContent().build();
	}
}
