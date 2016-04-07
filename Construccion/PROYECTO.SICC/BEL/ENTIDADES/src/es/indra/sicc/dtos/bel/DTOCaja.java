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

package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOCaja 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOCaja extends DTOAuditableSICC {
    private Long oidCanal;
    private String codigoCanal;
    private Long oidAcceso;
    private String codigoAcceso;
    private Long oidSubacceso;
    private String codigoSubacceso;
    private Long oidCaja;
    private String codigoCaja;
    String estadoCaja;
    private Date fecha;
    private String numeroMovimiento;
    Long oidTipoCaja;

    public DTOCaja() {
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal)
    {
        oidCanal = newOidCanal;
    }

    public String getCodigoCanal()
    {
        return codigoCanal;
    }

    public void setCodigoCanal(String newCodigoCanal)
    {
        codigoCanal = newCodigoCanal;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso)
    {
        oidAcceso = newOidAcceso;
    }

    public String getCodigoAcceso()
    {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String newCodigoAcceso)
    {
        codigoAcceso = newCodigoAcceso;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long newOidSubacceso)
    {
        oidSubacceso = newOidSubacceso;
    }

    public String getCodigoSubacceso()
    {
    return codigoSubacceso;
    }

    public Long getOidCaja()
    {
        return oidCaja;
    }

    public void setOidCaja(Long newOidCaja)
    {
        oidCaja = newOidCaja;
    }

    public String getCodigoCaja()
    {
        return codigoCaja;
    }

    public void setCodigoCaja(String newCodigoCaja)
    {
        codigoCaja = newCodigoCaja;
    }

    public String getEstadoCaja()
    {
        return estadoCaja;
    }

    public void setEstadoCaja(String newEstadoCaja)
    {
        estadoCaja = newEstadoCaja;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date newFecha)
    {
        fecha = newFecha;
    }

    public String getNumeroMovimiento()
    {
        return numeroMovimiento;
    }

    public void setNumeroMovimiento(String newNumeroMovimiento)
    {
        numeroMovimiento = newNumeroMovimiento;
    }

    public Long getOidTipoCaja()
    {
        return oidTipoCaja;
    }

    public void setOidTipoCaja(Long newOidTipoCaja)
    {
        oidTipoCaja = newOidTipoCaja;
    }

  public void setCodigoSubacceso(String newCodigoSubacceso) {
    codigoSubacceso = newCodigoSubacceso;
  }
}