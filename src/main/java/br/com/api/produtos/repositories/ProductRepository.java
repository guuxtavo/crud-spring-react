package br.com.api.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.produtos.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
