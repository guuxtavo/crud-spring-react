package br.com.api.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.models.Product;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ResponseModel response;

    // Método para listar todos os produtos
    public Iterable<Product> listar() {
        return repository.findAll();
    }

    // Método para cadastrar produtos

    public ResponseEntity<?> cadastrar(Product p) {
        if (p.getName().equals("")) {
            response.setMessage("O nome do produto é obrigatório!");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        } else if(p.getBrand().equals("")){
            response.setMessage("O nome da marca é obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Product>(repository.save(p), HttpStatus.CREATED);
            // Product product = repository.save(p);
            // return ResponseEntity.ok(product);
        }
    }

}
