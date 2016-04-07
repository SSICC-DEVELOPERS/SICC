/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.util.ArrayList;

public class Hijas implements Serializable {
    private Long cantidadHija;
    private ArrayList pedidos;

    public Hijas() {
    }

    public Long getCantidadHija() {
        return cantidadHija;
    }

    public void setCantidadHija(Long cantidadHija) {
        this.cantidadHija = cantidadHija;
    }

    public ArrayList getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList pedidos) {
        this.pedidos = pedidos;
    }
}
