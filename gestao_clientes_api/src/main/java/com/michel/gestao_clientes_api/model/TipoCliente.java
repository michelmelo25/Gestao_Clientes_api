package com.michel.gestao_clientes_api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tipo_cliente")
public class TipoCliente {
    private String tipo;
}
