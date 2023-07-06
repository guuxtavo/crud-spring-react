package br.com.api.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.models.Product;

@Repository // auxilia na injeção de dependências
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
