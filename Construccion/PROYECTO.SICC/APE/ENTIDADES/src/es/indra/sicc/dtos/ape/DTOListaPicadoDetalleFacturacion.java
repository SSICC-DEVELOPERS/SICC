/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOListaPicadoDetalleFacturacion extends DTOBelcorp{

    private String numeroAnaquel;    //se obtiene llendo a mapa centr. dist. detal, con el oidMapaCDDetalle.
    private Long oidMapaCDDetalle;
    private Long numeroCaja;
    private Long unidadesProducto;
    private Long oidProducto;
    private String descrProd;
    private Integer idZona;
    private String descripcionTipoCajaEmbalaje;
    
    public DTOListaPicadoDetalleFacturacion()
    {
    }


    public void setNumeroAnaquel(String numeroAnaquel)
    {
        this.numeroAnaquel = numeroAnaquel;
    }


    public String getNumeroAnaquel()
    {
        return numeroAnaquel;
    }


    public void setOidMapaCDDetalle(Long oidMapaCDDetalle)
    {
        this.oidMapaCDDetalle = oidMapaCDDetalle;
    }


    public Long getOidMapaCDDetalle()
    {
        return oidMapaCDDetalle;
    }


    public void setNumeroCaja(Long numeroCaja)
    {
        this.numeroCaja = numeroCaja;
    }


    public Long getNumeroCaja()
    {
        return numeroCaja;
    }


    public void setUnidadesProducto(Long unidadesProducto)
    {
        this.unidadesProducto = unidadesProducto;
    }


    public Long getUnidadesProducto()
    {
        return unidadesProducto;
    }


    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }


    public Long getOidProducto()
    {
        return oidProducto;
    }


    public void setDescrProd(String descrProd)
    {
        this.descrProd = descrProd;
    }


    public String getDescrProd()
    {
        return descrProd;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setDescripcionTipoCajaEmbalaje(String descripcionTipoCajaEmbalaje) {
        this.descripcionTipoCajaEmbalaje = descripcionTipoCajaEmbalaje;
    }

    public String getDescripcionTipoCajaEmbalaje() {
        return descripcionTipoCajaEmbalaje;
    }
}
