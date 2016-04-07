package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.util.ArrayList;

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
 * @date 26/04/2005
 * @author Gustavo Viñales
 */
public class PremioArticuloLote
        extends Premio
        implements Serializable {
    private ArrayList articulos;
    private Long numeroLote;
    private PremioArticulo premio;
    
    // INC 001 - gPineda - 13/01/2007
    private String descripcionLote;

    public PremioArticuloLote() {
        super();
    }

    public void setArticulos(ArrayList articulos) {
        this.articulos = articulos;
    }

    public ArrayList getArticulos() {
        return articulos;
    }

    public void setNumeroLote(Long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setPremio(PremioArticulo premio) {
        this.premio = premio;
    }

    public PremioArticulo getPremio() {
        return premio;
    }


    public void setDescripcionLote(String descripcionLote) {
        this.descripcionLote = descripcionLote;
    }


    public String getDescripcionLote() {
        return descripcionLote;
    }
}
