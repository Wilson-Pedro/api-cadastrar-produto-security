package com.wamk.cadastrarproduto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wamk.cadastrarproduto.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{
}
