package com.michel.gestao_clientes_api.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t.contrato_evento")
public class ContratoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "data_criacao")
    private Timestamp dataCriacao;
    @Column(name = "data_atualizacao")
    private Timestamp dataAtualizacao;
    @Column(nullable = false)
    @OneToOne
    private Contrato contrato;
    @Column(name = "estado_anterior",nullable = false)
    @OneToOne
    private ContratoEstado estadoAnterior;
    @Column(name = "estado_posterior",nullable = false)
    @OneToOne
    private ContratoEstado estadoPosterior;
}
