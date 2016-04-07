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

public class DTOTextoOferta extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidCabeceraMF;
  private Long numeroOrden;
  private String texto;
    private Long oidCatalogo;

  public DTOTextoOferta()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long newOid)
  {
    oid = newOid;
  }

  public Long getOidCabeceraMF()
  {
    return oidCabeceraMF;
  }

  public void setOidCabeceraMF(Long newOidCabeceraMF)
  {
    oidCabeceraMF = newOidCabeceraMF;
  }

  public Long getNumeroOrden()
  {
    return numeroOrden;
  }

  public void setNumeroOrden(Long newNumeroOrden)
  {
    numeroOrden = newNumeroOrden;
  }

  public String getTexto()
  {
    return texto;
  }

  public void setTexto(String newTexto)
  {
    texto = newTexto;
  }

    public Long getOidCatalogo()
    {
        return oidCatalogo;
    }

    public void setOidCatalogo(Long oidCatalogo)
    {
        this.oidCatalogo = oidCatalogo;
    }
}