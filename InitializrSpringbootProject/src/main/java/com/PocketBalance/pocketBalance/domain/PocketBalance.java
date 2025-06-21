/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PocketBalance.pocketBalance.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import java.sql.Timestamp;

/**
 *
 * @author jstev
 */
@Data
@Entity
@Table(name = "cuentas")
public class PocketBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_transaccion;

    private int periodo;
    private String nombre;
    private int monto;
    private int cantidad;

    @Column(name = "ultima_actualizacion", insertable = false, updatable = false)
    private Timestamp ultima_actualizacion;
}
