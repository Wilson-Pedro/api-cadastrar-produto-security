package com.wamk.cadastrarproduto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@GetMapping
	public String helloWorld() {
		return "<h1>Hello, World!</h1>";
	}
}
