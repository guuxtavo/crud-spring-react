package br.com.api.produtos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.Product;
import br.com.api.produtos.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Método para listar todos os produtos
    public List<Product> listar(){
        return repository.findAll();
    }
    
}
