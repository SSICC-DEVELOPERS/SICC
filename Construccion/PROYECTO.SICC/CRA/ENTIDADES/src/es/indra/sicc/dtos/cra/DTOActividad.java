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

package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;
import java.sql.Date;

/**
 * Sistema:       Belcorp
 * Modulo:        CRA - Cronograma de Actividades
 * Componente:    DTOActividad 
 * Fecha:         05/11/2003
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOActividad extends DTOSiccPaginacion {

    Long oidAcceso;
    Long oidMarca;
    Long oidCanal;
    Long oidDepartamento;
    Long oidActividadOrigen;
    String codigoActividad;
    String nombreActividad;
    Integer tipoActividad;
    Boolean ebelNoticias;
    Boolean laborales;
    Integer diasDesplazamiento;
    Long oid;
    Long tipoDireccion;
    Integer campanyasAntelacion;
    Long oidPais;
    Boolean festivos;
    Vector procesosAsignados;
    Date fechaInicioActividad;
    String codigoActividadOrigen;
    Long oidPeriodo;
    Long oidMensaje;
    
  private Long oidClasificacion;
  private Vector vectorConTraducciones;
  
  // **** Agregados por sssantana, 5/4/2005, por inc. MAV-12 (inc. 15881)
  private Long oidZona;
  private Long oidSeccion;
  private Long oidTipoFacturacion;
  private Integer campanyasDesplazamiento;
  // **** Fin Agregado por ssantana
    

    public DTOActividad() {
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso)
    {
        oidAcceso = newOidAcceso;
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

    public Long getOidDepartamento()
    {
        return oidDepartamento;
    }

    public void setOidDepartamento(Long newOidDepartamento)
    {
        oidDepartamento = newOidDepartamento;
    }

    public Long getOidActividadOrigen()
    {
        return oidActividadOrigen;
    }

    public void setOidActividadOrigen(Long newOidActividadOrigen)
    {
        oidActividadOrigen = newOidActividadOrigen;
    }

    public String getCodigoActividad()
    {
        return codigoActividad;
    }

    public void setCodigoActividad(String newCodigoActividad)
    {
        codigoActividad = newCodigoActividad;
    }

    public String getNombreActividad()
    {
        return nombreActividad;
    }

    public void setNombreActividad(String newNombreActividad)
    {
        nombreActividad = newNombreActividad;
    }

    public Integer getTipoActividad()
    {
        return tipoActividad;
    }

    public void setTipoActividad(Integer newTipoActividad)
    {
        tipoActividad = newTipoActividad;
    }

    public Boolean getEbelNoticias()
    {
        return ebelNoticias;
    }

    public void setEbelNoticias(Boolean newEbelNoticias)
    {
        ebelNoticias = newEbelNoticias;
    }

    public Boolean getLaborales()
    {
        return laborales;
    }

    public void setLaborales(Boolean newLaborales)
    {
        laborales = newLaborales;
    }

    public Integer getDiasDesplazamiento()
    {
        return diasDesplazamiento;
    }

    public void setDiasDesplazamiento(Integer newDiasDesplazamiento)
    {
        diasDesplazamiento = newDiasDesplazamiento;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long newOid)
    {
        oid = newOid;
    }

    public Long getTipoDireccion()
    {
        return tipoDireccion;
    }

    public void setTipoDireccion(Long newTipoDireccion)
    {
        tipoDireccion = newTipoDireccion;
    }

    public Integer getCampanyasAntelacion()
    {
        return campanyasAntelacion;
    }

    public void setCampanyasAntelacion(Integer newCampanyasAntelacion)
    {
        campanyasAntelacion = newCampanyasAntelacion;
    }

    public Long getOidPais()
    {
        return oidPais;
    }

    public void setOidPais(Long newOidPais)
    {
        oidPais = newOidPais;
    }

    public Boolean getFestivos()
    {
        return festivos;
    }

    public void setFestivos(Boolean newFestivos)
    {
        festivos = newFestivos;
    }

  public Vector getProcesosAsignados() {
    return procesosAsignados;
  }

  public void setProcesosAsignados(Vector newProcesosAsignados) {
    procesosAsignados = newProcesosAsignados;
  }

  public Date getFechaInicioActividad() {
    return fechaInicioActividad;
  }

  public void setFechaInicioActividad(Date newFechaInicioActividad) {
    fechaInicioActividad = newFechaInicioActividad;
  }

  public String getCodigoActividadOrigen() {
    return codigoActividadOrigen;
  }

  public void setCodigoActividadOrigen(String newCodigoActividadOrigen) {
    codigoActividadOrigen = newCodigoActividadOrigen;
  }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo) {
        oidPeriodo = newOidPeriodo;
    }

  public Long getOidClasificacion() {
    return oidClasificacion;
  }

  public void setOidClasificacion(Long newOidClasificacion) {
    oidClasificacion = newOidClasificacion;
  }

  public Vector getVectorConTraducciones() {
    return vectorConTraducciones;
  }

  public void setVectorConTraducciones(Vector newVectorConTraducciones) {
    vectorConTraducciones = newVectorConTraducciones;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidTipoFacturacion()
  {
    return oidTipoFacturacion;
  }

  public void setOidTipoFacturacion(Long oidTipoFacturacion)
  {
    this.oidTipoFacturacion = oidTipoFacturacion;
  }

  public Integer getCampanyasDesplazamiento()
  {
    return campanyasDesplazamiento;
  }

  public void setCampanyasDesplazamiento(Integer campanyasDesplazamiento)
  {
    this.campanyasDesplazamiento = campanyasDesplazamiento;
  }
  
    public void setOidMensaje(Long oidMensaje)
    {
      this.oidMensaje = oidMensaje;
    }
    
    public Long getOidMensaje()
    {
      return oidMensaje;
    }
}