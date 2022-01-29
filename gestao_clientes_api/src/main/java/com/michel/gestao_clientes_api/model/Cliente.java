package com.michel.gestao_clientes_api.model;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "data_criacao")
    private Timestamp dataCriacao;
    @Column(name = "data_atualizacao")
    private Timestamp dataAtualizacao;
    @Column(nullable = false)
    private String nome;
    @Column(name = "data_remocao")
    private Timestamp dataRemocao;
    @Column(nullable = false)
    private TipoCliente tipo;

}
