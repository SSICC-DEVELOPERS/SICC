package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOBusqueda extends DTOSiccPaginacion {
  private Long oidCabecera;
  private String codBuzon;
  private String descripBuzon;
  private Long secActividad;
  private String descripActividad;
  private String codCliente;
  private Date fechaActividadDesde;
  private Date fechaActividadHasta;

  public DTOBusqueda() {  }

  public Long getOidCabecera() {
    return this.oidCabecera;
  }
  
  public void setOidCabecera(Long newOidCabecera) {
    this.oidCabecera = newOidCabecera;
  }

  public String getCodBuzon() { 
    return this.codBuzon;
  }
  
  public void setCodBuzon(String newCodBuzon) {
    this.codBuzon = newCodBuzon; 
  }

  public String getDescripBuzon() {
    return this.descripBuzon;
  }
  
  public void setDescripBuzon(String newDescripBuzon) { 
    this.descripBuzon = newDescripBuzon;
  }

  public Long getSecActividad() {
    return this.secActividad;
  }
  
  public void setSecActividad(Long newSecActividad) { 
    this.secActividad = newSecActividad;
  }

  public String getDescripActividad() { 
    return this.descripActividad;
  }
  
  public void setDescripActividad(String newDescripActividad) {
    this.descripActividad = newDescripActividad;
  }

  public String getCodCliente() {
    return this.codCliente;
  }

  public void setCodCliente(String newCodCliente) {
    this.codCliente = newCodCliente;
  }

  public Date getFechaActividadDesde() {
    return this.fechaActividadDesde;
  }
  
  public void setFechaActividadDesde(Date newFechaActividadDesde) { 
    this.fechaActividadDesde = newFechaActividadDesde;
  }

  public Date getFechaActividadHasta() {
    return this.fechaActividadHasta;
  }

  public void setFechaActividadHasta(Date newFechaActividadHasta) {
    this.fechaActividadHasta = newFechaActividadHasta;
  }

}