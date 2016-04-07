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

public class ListaProductos implements Serializable {
    private boolean Comunicacion;
    private String mensaje;
    private ArrayList productos;

    public ListaProductos() {
    }

    public boolean getComunicacion() {
        return Comunicacion;
    }

    public void setComunicacion(boolean Comunicacion) {
        this.Comunicacion = Comunicacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }
}
