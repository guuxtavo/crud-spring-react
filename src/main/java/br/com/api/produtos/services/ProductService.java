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

    // Método para cadastrar ou alterar produtos

    public ResponseEntity<?> cadastrar(Product p) {
        if (p.getName().equals("")) {
            response.setMessage("O nome do produto é obrigatório!");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        } else if (p.getBrand().equals("")) {
            response.setMessage("O nome da marca é obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Product>(repository.save(p), HttpStatus.CREATED);
            // Product product = repository.save(p);
            // return ResponseEntity.ok(product);
        }

    }

    // método para atualizar
    public Product atualizar(Long id, Product obj) {
        Product entity = repository.getReferenceById(id);
        atualizarDados(entity, obj);
        // return new ResponseEntity<Product>(repository.save(entity), HttpStatus.OK);
        return repository.save(entity);
    }

    public void atualizarDados(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setBrand(obj.getBrand());
    }

    // Método para remover produtos
    public ResponseEntity<ResponseModel> remover(Long id){
        repository.deleteById(id);
        response.setMessage("O produto foi removido com sucesso!!");
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }


}
