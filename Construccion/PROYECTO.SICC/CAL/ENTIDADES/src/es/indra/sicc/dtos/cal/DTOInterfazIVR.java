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

package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOInterfazIVR extends DTOBelcorp
{

  private Long oid;
  private Long telefono;
  private Date fecha;
   private Long oidCliente;
   private Long oidTipoCliente;

  public DTOInterfazIVR()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getTelefono()
  {
    return telefono;
  }

  public void setTelefono(Long telefono)
  {
    this.telefono = telefono;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public void setFecha(Date fecha)
  {
    this.fecha = fecha;
  }





   public Long getOidCliente() {
      return oidCliente;
   }

   public void setOidCliente(Long oidCliente) {
      this.oidCliente = oidCliente;
   }

   public Long getOidTipoCliente() {
      return oidTipoCliente;
   }

   public void setOidTipoCliente(Long oidTipoCliente) {
      this.oidTipoCliente = oidTipoCliente;
   }





}