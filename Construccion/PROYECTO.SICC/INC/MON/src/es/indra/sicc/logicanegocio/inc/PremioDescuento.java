package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.util.ArrayList;

/**
 * <p>Copyright 2005 � por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * Espa�a<br>
 * <p>Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * @date 26/04/2005
 * @author Gustavo Vi�ales
 */
public class PremioDescuento
        extends Premio
        implements Serializable {
    private Long oidPeriodoDesde;
    private Long oidPeriodoHasta;
    private ArrayList listaProductos;

    public PremioDescuento() {
        super();
    }

    public void setOidPeriodoDesde(Long oidPeriodoDesde) {
        this.oidPeriodoDesde = oidPeriodoDesde;
    }

    public Long getOidPeriodoDesde() {
        return oidPeriodoDesde;
    }

    public void setOidPeriodoHasta(Long oidPeriodoHasta) {
        this.oidPeriodoHasta = oidPeriodoHasta;
    }

    public Long getOidPeriodoHasta() {
        return oidPeriodoHasta;
    }

    public void setListaProductos(ArrayList listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList getListaProductos() {
        return listaProductos;
    }
}
