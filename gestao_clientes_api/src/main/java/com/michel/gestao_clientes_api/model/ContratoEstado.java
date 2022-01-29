package com.michel.gestao_clientes_api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contrato_estado")
public class ContratoEstado {
    private String estado;
}
