package br.com.api.produtos.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component // auxilia na injeção de dependência
@Getter
@Setter
public class ResponseModel {
    
    private String message;
}
