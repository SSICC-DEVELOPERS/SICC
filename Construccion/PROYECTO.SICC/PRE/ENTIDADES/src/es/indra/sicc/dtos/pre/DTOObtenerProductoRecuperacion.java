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
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.ped.DTOTipifYUnidadAdminCliente;

public class DTOObtenerProductoRecuperacion extends DTOAuditableSICC {
    private Long periodoActual;
    private Long periodoFaltante;
    private String codigoVentaFaltante;
    private DTOTipifYUnidadAdminCliente tipifYUa;

    public DTOObtenerProductoRecuperacion() {
    }

    public Long getPeriodoActual()
    {
        return periodoActual;
    }

    public void setPeriodoActual(Long newPeriodoActual)
    {
        periodoActual = newPeriodoActual;
    }

    public Long getPeriodoFaltante()
    {
        return periodoFaltante;
    }

    public void setPeriodoFaltante(Long newPeriodoFaltante)
    {
        periodoFaltante = newPeriodoFaltante;
    }

    public String getCodigoVentaFaltante()
    {
        return codigoVentaFaltante;
    }

    public void setCodigoVentaFaltante(String newCodigoVentaFaltante)
    {
        codigoVentaFaltante = newCodigoVentaFaltante;
    }

    public void setTipifYUa(DTOTipifYUnidadAdminCliente tipifYUa) {
        this.tipifYUa = tipifYUa;
    }

    public DTOTipifYUnidadAdminCliente getTipifYUa() {
        return tipifYUa;
    }
}
