package com.pocketbalance.pocketbalance.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "salario")
public class Salario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_transaccion;

    private int salario_Actual;

    private Timestamp ultima_actualizacion;
}
