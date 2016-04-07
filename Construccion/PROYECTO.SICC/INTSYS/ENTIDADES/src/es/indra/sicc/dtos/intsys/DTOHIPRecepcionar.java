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
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;

public class DTOHIPRecepcionar extends DTOBelcorp{
  private Long oidSociedad;
  private String numLote;
  private String descripcionLote;
  private String observaciones;
    private InterfazInfo interfazInfo;
    private InterfazInfo Interfaz;

  public DTOHIPRecepcionar()
  {
  }

  public Long getOidSociedad()
  {
    return oidSociedad;
  }

  public void setOidSociedad(Long oidSociedad)
  {
    this.oidSociedad = oidSociedad;
  }

  public String getNumLote()
  {
    return numLote;
  }

  public void setNumLote(String numLote)
  {
    this.numLote = numLote;
  }

  public String getDescripcionLote()
  {
    return descripcionLote;
  }

  public void setDescripcionLote(String descripcionLote)
  {
    this.descripcionLote = descripcionLote;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

    public InterfazInfo getInterfazInfo()
    {
        return interfazInfo;
    }

    public void setInterfazInfo(InterfazInfo interfazInfo)
    {
        this.interfazInfo = interfazInfo;
    }

    public InterfazInfo getInterfaz()
    {
        return Interfaz;
    }

    public void setInterfaz(InterfazInfo Interfaz)
    {
        this.Interfaz = Interfaz;
    }
}