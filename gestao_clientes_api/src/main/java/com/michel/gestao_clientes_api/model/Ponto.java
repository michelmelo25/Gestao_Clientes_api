package com.michel.gestao_clientes_api.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_ponto")
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "data_criacao")
    private Timestamp dataCriacao;
    @Column(name = "data_atualizacao")
    private Timestamp dataAtualizacao;
    @Column(name = "data_remocao")
    private Timestamp datraRemocao;
    @Column(nullable = false)
    @ManyToMany
    private Cliente cliente;
    @Column(nullable = false)
    @ManyToMany
    private Endereco endereco;
}
