package br.com.api.produtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.models.Product;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // @GetMapping("/")
    // public String rota(){
    // return "api de produtos funcionando";
    // }

    @GetMapping("/listar")
    public Iterable<Product> listar() {
        return service.listar();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Product p) {
        return service.cadastrar(p);
    }

    // @PutMapping("/alterar")
    // public ResponseEntity<?> alterar(@RequestBody Product p) {
    //     return service.cadastrarAlterar(p, "alterar");
    // }

    @PutMapping(value = "/alterar/{id}")
    public ResponseEntity<Product> atualizar(@PathVariable Long id, @RequestBody Product p) {
        p = service.atualizar(id, p);
        return ResponseEntity.ok().body(p);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<ResponseModel> remover(@PathVariable Long id){
        return service.remover(id);
    }

}
