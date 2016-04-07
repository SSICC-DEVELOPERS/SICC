/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.util.DTOBelcorp;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DTORegistroAbastecimiento extends DTOBelcorp {
  public DTORegistroAbastecimiento(){
    
  }
   private Long oid;     
   private Long nSolicitud;  
   private Timestamp fechaCreado;     
   private Timestamp fechaEnviado;     
   private Timestamp fechaConfirmado;     
   private Timestamp fechaIngresado;     
   private Boolean indicadorSAP;   
   private Long oidEstadoHojaDemanda;   
   private Long oidPeriodo;   
   private Long oidMarca;   
   private String descripcionMarca;   
   private Long oidCanal;     
   private String descripcionCanal;     
   private String descripcionAcceso;   
   private Long oidSubacceso;   
   private String descripcionSubacceso;   
   private Long oidAlmacen;   
   private String descripcionAlmacen;   
   private Long oidAgrupacionStock;   
   private ArrayList detalle;   
   private Boolean opcionCrearRegistro;
   private Long oidAcceso; // añadido por incidencia BELC300011916
   private String observaciones; // añadido por incidencia BELC300011950

  public String getDescripcionAcceso()
  {
    return descripcionAcceso;
  }

  public void setDescripcionAcceso(String descripcionAcceso)
  {
    this.descripcionAcceso = descripcionAcceso;
  }

  public String getDescripcionAlmacen()
  {
    return descripcionAlmacen;
  }

  public void setDescripcionAlmacen(String descripcionAlmacen)
  {
    this.descripcionAlmacen = descripcionAlmacen;
  }

  public String getDescripcionCanal()
  {
    return descripcionCanal;
  }

  public void setDescripcionCanal(String descripcionCanal)
  {
    this.descripcionCanal = descripcionCanal;
  }

  public String getDescripcionMarca()
  {
    return descripcionMarca;
  }

  public void setDescripcionMarca(String descripcionMarca)
  {
    this.descripcionMarca = descripcionMarca;
  }

  public String getDescripcionSubacceso()
  {
    return descripcionSubacceso;
  }

  public void setDescripcionSubacceso(String descripcionSubacceso)
  {
    this.descripcionSubacceso = descripcionSubacceso;
  }

  public ArrayList getDetalle()
  {
    return detalle;
  }

  public void setDetalle(ArrayList detalle)
  {
    this.detalle = detalle;
  }

  public Timestamp getFechaConfirmado()
  {
    return fechaConfirmado;
  }

  public void setFechaConfirmado(Timestamp fechaConfirmado)
  {
    this.fechaConfirmado = fechaConfirmado;
  }

  public Timestamp getFechaCreado()
  {
    return fechaCreado;
  }

  public void setFechaCreado(Timestamp fechaCreado)
  {
    this.fechaCreado = fechaCreado;
  }

  public Timestamp getFechaEnviado()
  {
    return fechaEnviado;
  }

  public void setFechaEnviado(Timestamp fechaEnviado)
  {
    this.fechaEnviado = fechaEnviado;
  }

  public Timestamp getFechaIngresado()
  {
    return fechaIngresado;
  }

  public void setFechaIngresado(Timestamp fechaIngresado)
  {
    this.fechaIngresado = fechaIngresado;
  }

  public Boolean getIndicadorSAP()
  {
    return indicadorSAP;
  }

  public void setIndicadorSAP(Boolean indicadorSAP)
  {
    this.indicadorSAP = indicadorSAP;
  }

  public Long getNSolicitud()
  {
    return nSolicitud;
  }

  public void setNSolicitud(Long nSolicitud)
  {
    this.nSolicitud = nSolicitud;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidAgrupacionStock()
  {
    return oidAgrupacionStock;
  }

  public void setOidAgrupacionStock(Long oidAgrupacionStock)
  {
    this.oidAgrupacionStock = oidAgrupacionStock;
  }

  public Long getOidAlmacen()
  {
    return oidAlmacen;
  }

  public void setOidAlmacen(Long oidAlmacen)
  {
    this.oidAlmacen = oidAlmacen;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidEstadoHojaDemanda()
  {
    return oidEstadoHojaDemanda;
  }

  public void setOidEstadoHojaDemanda(Long oidEstadoHojaDemanda)
  {
    this.oidEstadoHojaDemanda = oidEstadoHojaDemanda;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Boolean getOpcionCrearRegistro()
  {
    return opcionCrearRegistro;
  }

  public void setOpcionCrearRegistro(Boolean opcionCrearRegistro)
  {
    this.opcionCrearRegistro = opcionCrearRegistro;
  }

   public Long getOidAcceso()
   {
      return oidAcceso;
   }

   public void setOidAcceso(Long oidAcceso)
   {
      this.oidAcceso = oidAcceso;
   }

   public String getObservaciones() {
      return observaciones;
   }

   public void setObservaciones(String observaciones) {
      this.observaciones = observaciones;
   }
  
   
}