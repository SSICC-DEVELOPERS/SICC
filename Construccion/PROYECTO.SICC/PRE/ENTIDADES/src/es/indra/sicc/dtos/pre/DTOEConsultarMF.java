/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 /**
  * pperanzola 16/09/2005 se agrega oidsEstrategia segun cambios por codigo unico de venta
  */
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEConsultarMF extends DTOSiccPaginacion{
    private Long oidCabeceraMF;
    private String codigoVenta;
    private String codigoProducto;
    private String descripcionProducto;
    private Long oidTipoOferta;
    private String oidsEstrategia;
    
    public DTOEConsultarMF() {}

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String newCodigoProducto) {
        codigoProducto = newCodigoProducto;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta) {
        codigoVenta = newCodigoVenta;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String newDescripcionProducto) {
        descripcionProducto = newDescripcionProducto;
    }

    public Long getOidCabeceraMF() {
        return oidCabeceraMF;
    }

    public void setOidCabeceraMF(Long newOidCabeceraMF) {
        oidCabeceraMF = newOidCabeceraMF;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long newOidTipoOferta) {
        oidTipoOferta = newOidTipoOferta;
    }

    public String getOidsEstrategia()
    {
        return oidsEstrategia;
    }

    public void setOidsEstrategia(String oidsEstrategia)
    {
        this.oidsEstrategia = oidsEstrategia;
    }

    
}