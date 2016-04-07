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
 */

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;

import java.math.BigDecimal;

import java.sql.Date;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOHistoricoDescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOHistoricoDescuento extends DTOAuditableSICC {

    private BigDecimal baseCalculo;
    private BigDecimal baseCalculoAcumulada;
    private Long unidadesDemandadas;
    private BigDecimal importeVentaReal;
    private BigDecimal porcentaje;
    private BigDecimal importeFijo;
    private BigDecimal importeDescuentoAplicado;
    private Boolean facturacion;
    private Boolean cuentaCorriente;
    private Date fechaProceso;
    private Long numeroBuzonMensaje;
    private Long oidDescuento;
    private Long oidMatrizFacturacion;
    private Long oidSolicitud;
    private Long oidCliente;
    private Long oidHistoricoDescuento;
    private DTOBuzonMensajes dtoBuzonMensajes;

    public DTOHistoricoDescuento() {
    }

    public BigDecimal getBaseCalculo()
    {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal newBaseCalculo)
    {
        baseCalculo = newBaseCalculo;
    }

    public BigDecimal getBaseCalculoAcumulada()
    {
        return baseCalculoAcumulada;
    }

    public void setBaseCalculoAcumulada(BigDecimal newBaseCalculoAcumulada)
    {
        baseCalculoAcumulada = newBaseCalculoAcumulada;
    }

    public Long getUnidadesDemandadas()
    {
        return unidadesDemandadas;
    }

    public void setUnidadesDemandadas(Long newUnidadesDemandadas)
    {
        unidadesDemandadas = newUnidadesDemandadas;
    }

    public BigDecimal getImporteVentaReal()
    {
        return importeVentaReal;
    }

    public void setImporteVentaReal(BigDecimal newImporteVentaReal)
    {
        importeVentaReal = newImporteVentaReal;
    }

    public BigDecimal getPorcentaje()
    {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal newPorcentaje)
    {
        porcentaje = newPorcentaje;
    }

    public BigDecimal getImporteFijo()
    {
        return importeFijo;
    }

    public void setImporteFijo(BigDecimal newImporteFijo)
    {
        importeFijo = newImporteFijo;
    }

    public BigDecimal getImporteDescuentoAplicado()
    {
        return importeDescuentoAplicado;
    }

    public void setImporteDescuentoAplicado(BigDecimal newImporteDescuentoAplicado)
    {
        importeDescuentoAplicado = newImporteDescuentoAplicado;
    }

    public Boolean getFacturacion()
    {
        return facturacion;
    }

    public void setFacturacion(Boolean newFacturacion)
    {
        facturacion = newFacturacion;
    }

    public Boolean getCuentaCorriente()
    {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(Boolean newCuentaCorriente)
    {
        cuentaCorriente = newCuentaCorriente;
    }

    public Date getFechaProceso()
    {
        return fechaProceso;
    }

    public void setFechaProceso(Date newFechaProceso)
    {
        fechaProceso = newFechaProceso;
    }

    public Long getNumeroBuzonMensaje()
    {
        return numeroBuzonMensaje;
    }

    public void setNumeroBuzonMensaje(Long newNumeroBuzonMensaje)
    {
        numeroBuzonMensaje = newNumeroBuzonMensaje;
    }

    public Long getOidDescuento()
    {
        return oidDescuento;
    }

    public void setOidDescuento(Long newOidDescuento)
    {
        oidDescuento = newOidDescuento;
    }

    public Long getOidMatrizFacturacion()
    {
        return oidMatrizFacturacion;
    }

    public void setOidMatrizFacturacion(Long newOidMatrizFacturacion)
    {
        oidMatrizFacturacion = newOidMatrizFacturacion;
    }

    public Long getOidSolicitud()
    {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long newOidSolicitud)
    {
        oidSolicitud = newOidSolicitud;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente)
    {
        oidCliente = newOidCliente;
    }

    public Long getOidHistoricoDescuento()
    {
        return oidHistoricoDescuento;
    }

    public void setOidHistoricoDescuento(Long oidHistoricoDescuento)
    {
        this.oidHistoricoDescuento = oidHistoricoDescuento;
    }

    public DTOBuzonMensajes getDtoBuzonMensajes()
    {
        return dtoBuzonMensajes;
    }

    public void setDtoBuzonMensajes(DTOBuzonMensajes dtoBuzonMensajes)
    {
        this.dtoBuzonMensajes = dtoBuzonMensajes;
    }
}