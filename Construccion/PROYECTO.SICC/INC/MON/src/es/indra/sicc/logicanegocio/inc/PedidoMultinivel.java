/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;

public class PedidoMultinivel implements Serializable{
    private Long cantidad;
    private Long numPuntosExigidos;

    public PedidoMultinivel() {
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getNumPuntosExigidos() {
        return numPuntosExigidos;
    }

    public void setNumPuntosExigidos(Long numPuntosExigidos) {
        this.numPuntosExigidos = numPuntosExigidos;
    }
}
