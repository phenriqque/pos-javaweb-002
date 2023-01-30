package dev.fujioka.pedrobarros.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class Vendas implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String idcliente;

    private String idproduto;

    private String datavenda;



}
