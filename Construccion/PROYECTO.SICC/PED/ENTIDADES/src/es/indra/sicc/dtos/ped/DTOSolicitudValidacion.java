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

package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSolicitudValidacion 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
public class DTOSolicitudValidacion  extends DTOAuditableSICC {
    private Long oidSolicitud;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidPeriodo;
    private Long oidMoneda;
    private Long oidTipoSolPais;
    private Long oidCliente;
    private Long oidSubAcceso;
    private Boolean indSimulacion;
    private Boolean indOrdenCompra;
    private Boolean indPedGTZona;
    private Long Zona;
    private Long ubigeo;
    private Long oidModulo;
    private DTOProceso proceso;
    private Integer numDecimales;
    
	private BigDecimal tipoCambio;
  private Long oidAcceso;
  private String numSolicitud;
  private Boolean indUnionSolicitud;
  private Long Orden;
  private Long OrdenMonitor;   
  private Date fechaProceso;
  
    private Long GP;   
    private Long indNoConso;   
  private String descripcionCanal;
  private String nombrePeriodo;
    
    // gPineda - 15/01/2007 - V_PED_12
    private BigDecimal preCatalogoTotalLocal;
  private Boolean indEjecOnLine;
  private Long numeroOrden;
  private Long ordenTipificacion;
  
    //jrivas 29/1/2008 2007437
    private Boolean indDevoAnul;  
    
    // sapaza -- PER-SiCC-2011-0726 -- 08/11/2011
    private Boolean indRecepcionOnline;
    
    // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
    private Boolean indValidacionPROL;
    
    public DTOSolicitudValidacion() {
    }

    public Long getOidSolicitud()
    {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long newOidSolicitud)
    {
        oidSolicitud = newOidSolicitud;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long newOidMarca)
    {
        oidMarca = newOidMarca;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal)
    {
        oidCanal = newOidCanal;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo)
    {
        oidPeriodo = newOidPeriodo;
    }

    public Long getOidMoneda()
    {
        return oidMoneda;
    }

    public void setOidMoneda(Long newOidMoneda)
    {
        oidMoneda = newOidMoneda;
    }

    public Long getOidTipoSolPais()
    {
        return oidTipoSolPais;
    }

    public void setOidTipoSolPais(Long newOidTipoSolPais)
    {
        oidTipoSolPais = newOidTipoSolPais;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente)
    {
        oidCliente = newOidCliente;
    }

    public Long getOidSubAcceso()
    {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long newOidSubAcceso)
    {
        oidSubAcceso = newOidSubAcceso;
    }

    public Boolean getIndSimulacion()
    {
        return indSimulacion;
    }

    public void setIndSimulacion(Boolean newIndSimulacion)
    {
        indSimulacion = newIndSimulacion;
    }

    public Boolean getIndOrdenCompra()
    {
        return indOrdenCompra;
    }

    public void setIndOrdenCompra(Boolean newIndOrdenCompra)
    {
        indOrdenCompra = newIndOrdenCompra;
    }

    public Boolean getIndPedGTZona()
    {
        return indPedGTZona;
    }

    public void setIndPedGTZona(Boolean newIndPedGTZona)
    {
        indPedGTZona = newIndPedGTZona;
    }

    public Long getZona()
    {
        return Zona;
    }

    public void setZona(Long newZona)
    {
        Zona = newZona;
    }

    public Long getUbigeo()
    {
        return ubigeo;
    }

    public void setUbigeo(Long newUbigeo)
    {
        ubigeo = newUbigeo;
    }

    public Long getOidModulo()
    {
        return oidModulo;
    }

    public void setOidModulo(Long newOidModulo)
    {
        oidModulo = newOidModulo;
    }

    public DTOProceso getProceso()
    {
        return proceso;
    }

    public void setProceso(DTOProceso newProceso)
    {
        proceso = newProceso;
    }

	public Integer getNumDecimales() {
		return numDecimales;
	}

	public void setNumDecimales(Integer newNumDecimales) {
		numDecimales = newNumDecimales;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public String getNumSolicitud() {
    return numSolicitud;
  }

  public void setNumSolicitud(String newNumSolicitud) {
    numSolicitud = newNumSolicitud;
  }

  public Boolean getIndUnionSolicitud() {
    return indUnionSolicitud;
  }

  public void setIndUnionSolicitud(Boolean newIndUnionSolicitud) {
    indUnionSolicitud = newIndUnionSolicitud;
  }
  public void setOrden(Long newOrden) {
    Orden = newOrden;
  }
  
  public void setOrdenMonitor(Long newOrdenMonitor) {
    OrdenMonitor = newOrdenMonitor;
  }  
  
  public Long getOrden()
  {
      return Orden;
  }

  public Long getOrdenMonitor()
  {
      return OrdenMonitor;
  }  

  public Date getFechaProceso()
  {
    return fechaProceso;
  }

  public void setFechaProceso(Date fechaProceso)
  {
    this.fechaProceso = fechaProceso;
  }


    public void setGP(Long GP)
    {
        this.GP = GP;
    }


    public Long getGP()
    {
        return GP;
    }


    public void setIndNoConso(Long indNoConso)
    {
        this.indNoConso = indNoConso;
    }


    public Long getIndNoConso()
    {
        return indNoConso;
    }

  public String getDescripcionCanal()
  {
    return descripcionCanal;
  }

  public void setDescripcionCanal(String descripcionCanal)
  {
    this.descripcionCanal = descripcionCanal;
  }

  public String getNombrePeriodo()
  {
    return nombrePeriodo;
  }

  public void setNombrePeriodo(String nombrePeriodo)
  {
    this.nombrePeriodo = nombrePeriodo;
  }


    public void setPreCatalogoTotalLocal(BigDecimal preCatalogoTotalLocal) {
        this.preCatalogoTotalLocal = preCatalogoTotalLocal;
    }


    public BigDecimal getPreCatalogoTotalLocal() {
        return preCatalogoTotalLocal;
    }

  public Boolean getIndEjecOnLine()
  {
    return indEjecOnLine;
  }

  public void setIndEjecOnLine(Boolean indEjecOnLine)
  {
    this.indEjecOnLine = indEjecOnLine;
  }

  public Long getNumeroOrden()
  {
    return numeroOrden;
  }

  public void setNumeroOrden(Long numeroOrden)
  {
    this.numeroOrden = numeroOrden;
  }

  public Long getOrdenTipificacion()
  {
    return ordenTipificacion;
  }

  public void setOrdenTipificacion(Long ordenTipificacion)
  {
    this.ordenTipificacion = ordenTipificacion;
  }
  
    public Boolean getIndDevoAnul()
    {
        return indDevoAnul;
    }

    public void setIndDevoAnul(Boolean indDevoAnul)
    {
        this.indDevoAnul = indDevoAnul;
    }

    public void setIndRecepcionOnline(Boolean indRecepcionOnline) {
        this.indRecepcionOnline = indRecepcionOnline;
    }

    public Boolean getIndRecepcionOnline() {
        return indRecepcionOnline;
    }

    public void setIndValidacionPROL(Boolean indValidacionPROL) {
        this.indValidacionPROL = indValidacionPROL;
    }

    public Boolean getIndValidacionPROL() {
        return indValidacionPROL;
    }
}
