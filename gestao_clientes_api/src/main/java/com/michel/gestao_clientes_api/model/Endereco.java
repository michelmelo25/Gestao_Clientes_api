package com.michel.gestao_clientes_api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private Long numero;
    @Column(nullable = false, name = "data_criacao")
    private Timestamp dataCriacao;
    @Column(name = "data_atualizacao")
    private Timestamp dataAtualizacao;
    @Column(name = "data_remocao")
    private Timestamp dataRemocao;
}
