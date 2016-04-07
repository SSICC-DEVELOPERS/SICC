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
 */
package es.indra.sicc.dtos.rec;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.math.BigDecimal;

public class DTODetallePreRec extends DTOSiccPaginacion {

    private Long oidPeriodo;    
    private Long oidSubAcceso;  
    private ArrayList arrayTipoSolicitud;                 
    private String stringSolicitudes;                     
    private Long oidPrecioEnvia;
    private BigDecimal preciocatalogoDestino;
    private String codigoVentaAnterior; // BELC300019830
    private Long detalleOfertaAnterior; // BELC300019830
    
    public DTODetallePreRec()
    {
    }

    public ArrayList getArrayTipoSolicitud()
    {
        return arrayTipoSolicitud;
    }

    public void setArrayTipoSolicitud(ArrayList arrayTipoSolicitud)
    {
        this.arrayTipoSolicitud = arrayTipoSolicitud;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPrecioEnvia()
    {
        return oidPrecioEnvia;
    }

    public void setOidPrecioEnvia(Long oidPrecioEnvia)
    {
        this.oidPrecioEnvia = oidPrecioEnvia;
    }

    public Long getOidSubAcceso()
    {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long oidSubAcceso)
    {
        this.oidSubAcceso = oidSubAcceso;
    }

    public String getStringSolicitudes()
    {
        return stringSolicitudes;
    }

    public void setStringSolicitudes(String stringSolicitudes)
    {
        this.stringSolicitudes = stringSolicitudes;
    }

    public BigDecimal getPreciocatalogoDestino()
    {
        return preciocatalogoDestino;
    }

    public void setPreciocatalogoDestino(BigDecimal preciocatalogoDestino)
    {
        this.preciocatalogoDestino = preciocatalogoDestino;
    }

    public String getCodigoVentaAnterior() {
        return codigoVentaAnterior;
    }

    public void setCodigoVentaAnterior(String codigoVentaAnterior) {
        this.codigoVentaAnterior = codigoVentaAnterior;
    }

    public Long getDetalleOfertaAnterior() {
        return detalleOfertaAnterior;
    }

    public void setDetalleOfertaAnterior(Long detalleOfertaAnterior) {
        this.detalleOfertaAnterior = detalleOfertaAnterior;
    }
}