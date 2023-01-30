package dev.fujioka.pedrobarros.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String cpf;



}
