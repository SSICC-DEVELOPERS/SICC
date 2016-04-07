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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarOfertas extends DTOSiccPaginacion 
{
  private Long oidCabeceraMF;
  private String codSAP;
  private String codVta;  
  private String descripcionSAP;
  private Long oidCatalogo;
  private Integer paginaDesde;
  private Integer paginaHasta;
  private Long oidMarca;
  private Long oidLineaProducto;
  private Long oidUnidadNegocio;
  private Long oidNegocio;
  private Long oidGenerico;
  private Long oidSupergenerico;
    private String oidsEstrategias;

  public DTOEBuscarOfertas()
  {
  }

  public Long getOidCabeceraMF()
  {
    return oidCabeceraMF;
  }

  public void setOidCabeceraMF(Long newOidCabeceraMF)
  {
    oidCabeceraMF = newOidCabeceraMF;
  }

  public String getCodSAP()
  {
    return codSAP;
  }

  public void setCodSAP(String newCodSAP)
  {
    codSAP = newCodSAP;
  }

  public String getDescripcionSAP()
  {
    return descripcionSAP;
  }

  public void setDescripcionSAP(String newDescripcionSAP)
  {
    descripcionSAP = newDescripcionSAP;
  }

  public Long getOidCatalogo()
  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long newOidCatalogo)
  {
    oidCatalogo = newOidCatalogo;
  }

  public Integer getPaginaDesde()
  {
    return paginaDesde;
  }

  public void setPaginaDesde(Integer newPaginaDesde)
  {
    paginaDesde = newPaginaDesde;
  }

  public Integer getPaginaHasta()
  {
    return paginaHasta;
  }

  public void setPaginaHasta(Integer newPaginaHasta)
  {
    paginaHasta = newPaginaHasta;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca)
  {
    oidMarca = newOidMarca;
  }

  public Long getOidLineaProducto()
  {
    return oidLineaProducto;
  }

  public void setOidLineaProducto(Long newOidLineaProducto)
  {
    oidLineaProducto = newOidLineaProducto;
  }

  public Long getOidUnidadNegocio()
  {
    return oidUnidadNegocio;
  }

  public void setOidUnidadNegocio(Long newOidUnidadNegocio)
  {
    oidUnidadNegocio = newOidUnidadNegocio;
  }

  public Long getOidNegocio()
  {
    return oidNegocio;
  }

  public void setOidNegocio(Long newOidNegocio)
  {
    oidNegocio = newOidNegocio;
  }

  public Long getOidGenerico()
  {
    return oidGenerico;
  }

  public void setOidGenerico(Long newOidGenerico)
  {
    oidGenerico = newOidGenerico;
  }

  public Long getOidSupergenerico()
  {
    return oidSupergenerico;
  }

  public void setOidSupergenerico(Long newOidSupergenerico)
  {
    oidSupergenerico = newOidSupergenerico;
  }

    public String getOidsEstrategias()
    {
        return oidsEstrategias;
    }

    public void setOidsEstrategias(String oidsEstrategias)
    {
        this.oidsEstrategias = oidsEstrategias;
    }

    public void setCodVta(String codVta) {
        this.codVta = codVta;
    }

    public String getCodVta() {
        return codVta;
    }
}
