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

/**
 * 
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 */
public class DTOVentaExclusiva extends DTOAuditableSICC 
{
  private Long oidVentaExclusiva;
  private Long oidTipoCliente;
  private String descripcionTipoCliente;
  private Long oidSubtipoCliente;
  private String descripcionSubtipoCliente;
  private Long oidTipoClasificacion;
  private String descripcionTipoClasificacion;
  private Long oidClasificacion;
  private String descripcionClasificacion;
  private Long oidEstatus;
  private String descripcionEstatus;
  private String estatus2;
  private String tipoOperacion;//[1]
  private Long oidRegion;
  private Long oidZona;
  private String descripcionZona;
  private String descripcionRegion;    

  public DTOVentaExclusiva()
  {
  }

  public Long getOidVentaExclusiva()
  {
    return oidVentaExclusiva;
  }

  public void setOidVentaExclusiva(Long newOidVentaExclusiva)
  {
    oidVentaExclusiva = newOidVentaExclusiva;
  }

  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long newOidTipoCliente)
  {
    oidTipoCliente = newOidTipoCliente;
  }

  public String getDescripcionTipoCliente()
  {
    return descripcionTipoCliente;
  }

  public void setDescripcionTipoCliente(String newDescripcionTipoCliente)
  {
    descripcionTipoCliente = newDescripcionTipoCliente;
  }

  public Long getOidSubtipoCliente()
  {
    return oidSubtipoCliente;
  }

  public void setOidSubtipoCliente(Long newOidSubtipoCliente)
  {
    oidSubtipoCliente = newOidSubtipoCliente;
  }

  public String getDescripcionSubtipoCliente()
  {
    return descripcionSubtipoCliente;
  }

  public void setDescripcionSubtipoCliente(String newDescripcionSubtipoCliente)
  {
    descripcionSubtipoCliente = newDescripcionSubtipoCliente;
  }

  public Long getOidTipoClasificacion()
  {
    return oidTipoClasificacion;
  }

  public void setOidTipoClasificacion(Long newOidTipoClasificacion)
  {
    oidTipoClasificacion = newOidTipoClasificacion;
  }

  public String getDescripcionTipoClasificacion()
  {
    return descripcionTipoClasificacion;
  }

  public void setDescripcionTipoClasificacion(String newDescripcionTipoClasificacion)
  {
    descripcionTipoClasificacion = newDescripcionTipoClasificacion;
  }

  public Long getOidClasificacion()
  {
    return oidClasificacion;
  }

  public void setOidClasificacion(Long newOidClasificacion)
  {
    oidClasificacion = newOidClasificacion;
  }

  public String getDescripcionClasificacion()
  {
    return descripcionClasificacion;
  }

  public void setDescripcionClasificacion(String newDescripcionClasificacion)
  {
    descripcionClasificacion = newDescripcionClasificacion;
  }

  public Long getOidEstatus()
  {
    return oidEstatus;
  }

  public void setOidEstatus(Long newOidEstatus)
  {
    oidEstatus = newOidEstatus;
  }

  public String getDescripcionEstatus()
  {
    return descripcionEstatus;
  }

  public void setDescripcionEstatus(String newDescripcionEstatus)
  {
    descripcionEstatus = newDescripcionEstatus;
  }

  public String getEstatus2()
  {
    return estatus2;
  }

  public void setEstatus2(String newEstatus2)
  {
    estatus2 = newEstatus2;
  }
  ///*[1]
  public String getTipoOperacion(){
        return tipoOperacion;
  }

      public void setTipoOperacion(String tipoOperacion)  {
        this.tipoOperacion = tipoOperacion;
    }

  //*/[1]

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setDescripcionZona(String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }

    public String getDescripcionZona() {
        return descripcionZona;
    }

    public void setDescripcionRegion(String descripcionRegion) {
        this.descripcionRegion = descripcionRegion;
    }

    public String getDescripcionRegion() {
        return descripcionRegion;
    }
}
