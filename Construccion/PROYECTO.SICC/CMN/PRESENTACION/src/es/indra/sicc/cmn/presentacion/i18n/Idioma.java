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
 */

package es.indra.sicc.cmn.presentacion.i18n;


/**
 * Sistema:           Belcorp
 * Modulo:            CMN - Requisitos Generales
 * Componente:        Clase Idioma
 * Fecha:             05/12/2003
 * Observaciones:     Basado en Modelo de Componentes SICC-DMCO-GEN-201-310
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */

public class Idioma {

    private Long oid;
    private String codigo;
    private String descripcion;
    private String codigoISO;
    private Boolean indicadorTraducible;

    public Idioma() {
        super();
    }

    public Idioma(Long oid, String codigo, String descripcion) {
        super();
        this.setOid(oid);
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
    }


    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String newCodigo) {
        codigo = newCodigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

    public String getCodigoISO()
    {
        return codigoISO;
    }

    public void setCodigoISO(String newCodigoISO)
    {
        codigoISO = newCodigoISO;
    }

    public Boolean getIndicadorTraducible()
    {
        return indicadorTraducible;
    }

    public void setIndicadorTraducible(Boolean newIndicadorTraducible)
    {
        indicadorTraducible = newIndicadorTraducible;
    }

}