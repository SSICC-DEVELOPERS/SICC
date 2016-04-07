/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesProductos
 * Fecha:             15/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       DTOComisionesProductos
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOComisionesProductos extends DTOAuditableSICC 
{
  private Long oid;
  private Integer id;
  private Long oidComision;
  private Long oidTipoInsercionProductos;
  private String descTipoInsercionProductos;
  private Long oidProducto;
  private String codProducto;
  private Long oidTipoOferta;
  private String descTipoOferta;
  private Long oidCicloVida;
  private String descCicloVida;
  private Long oidMarcaProducto;
  private String descMarcaProducto;
  private Long oidUnidadNegocio;
  private String descUnidadNegocio;
  private Long oidNegocio;
  private String descNegocio;
  private Long oidSupergenerico;
  private String descSupergenerico;
  private Long oidGenerico;
  private String descGenerico;
  private Long oidTipoProducto;
  private String descTipoProducto;
  private Long oidComisionProducto;

  public DTOComisionesProductos()
  {
  }
  
  public Long getOidTipoProducto() {
    return this.oidTipoProducto;
  }
  
  public void setOidTipoProducto(Long newOidTipoProducto) {
    this.oidTipoProducto = newOidTipoProducto;
  }
  
  public String getDescTipoProducto() {
    return this.descTipoProducto;
  }
  
  public void setDescTipoProducto(String newDescTipoProducto) {
    this.descTipoProducto = newDescTipoProducto;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Long getOidComision()
  {
    return oidComision;
  }

  public void setOidComision(Long oidComision)
  {
    this.oidComision = oidComision;
  }

  public Long getOidTipoInsercionProductos()
  {
    return oidTipoInsercionProductos;
  }

  public void setOidTipoInsercionProductos(Long oidTipoInsercionProductos)
  {
    this.oidTipoInsercionProductos = oidTipoInsercionProductos;
  }

  public String getDescTipoInsercionProductos()
  {
    return descTipoInsercionProductos;
  }

  public void setDescTipoInsercionProductos(String descTipoInsercionProductos)
  {
    this.descTipoInsercionProductos = descTipoInsercionProductos;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public String getCodProducto()
  {
    return codProducto;
  }

  public void setCodProducto(String codProducto)
  {
    this.codProducto = codProducto;
  }

  public Long getOidTipoOferta()
  {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long oidTipoOferta)
  {
    this.oidTipoOferta = oidTipoOferta;
  }

  public String getDescTipoOferta()
  {
    return descTipoOferta;
  }

  public void setDescTipoOferta(String descTipoOferta)
  {
    this.descTipoOferta = descTipoOferta;
  }

  public Long getOidCicloVida()
  {
    return oidCicloVida;
  }

  public void setOidCicloVida(Long oidCicloVida)
  {
    this.oidCicloVida = oidCicloVida;
  }

  public String getDescCicloVida()
  {
    return descCicloVida;
  }

  public void setDescCicloVida(String descCicloVida)
  {
    this.descCicloVida = descCicloVida;
  }

  public Long getOidMarcaProducto()
  {
    return oidMarcaProducto;
  }

  public void setOidMarcaProducto(Long oidMarcaProducto)
  {
    this.oidMarcaProducto = oidMarcaProducto;
  }

  public String getDescMarcaProducto()
  {
    return descMarcaProducto;
  }

  public void setDescMarcaProducto(String descMarcaProducto)
  {
    this.descMarcaProducto = descMarcaProducto;
  }

  public Long getOidUnidadNegocio()
  {
    return oidUnidadNegocio;
  }

  public void setOidUnidadNegocio(Long oidUnidadNegocio)
  {
    this.oidUnidadNegocio = oidUnidadNegocio;
  }

  public String getDescUnidadNegocio()
  {
    return descUnidadNegocio;
  }

  public void setDescUnidadNegocio(String descUnidadNegocio)
  {
    this.descUnidadNegocio = descUnidadNegocio;
  }

  public Long getOidNegocio()
  {
    return oidNegocio;
  }

  public void setOidNegocio(Long oidNegocio)
  {
    this.oidNegocio = oidNegocio;
  }

  public String getDescNegocio()
  {
    return descNegocio;
  }

  public void setDescNegocio(String descNegocio)
  {
    this.descNegocio = descNegocio;
  }

  public Long getOidSupergenerico()
  {
    return oidSupergenerico;
  }

  public void setOidSupergenerico(Long oidSupergenerico)
  {
    this.oidSupergenerico = oidSupergenerico;
  }

  public String getDescSupergenerico()
  {
    return descSupergenerico;
  }

  public void setDescSupergenerico(String descSupergenerico)
  {
    this.descSupergenerico = descSupergenerico;
  }

  public Long getOidGenerico()
  {
    return oidGenerico;
  }

  public void setOidGenerico(Long oidGenerico)
  {
    this.oidGenerico = oidGenerico;
  }

  public String getDescGenerico()
  {
    return descGenerico;
  }

  public void setDescGenerico(String descGenerico)
  {
    this.descGenerico = descGenerico;
  }

  public Long getOidComisionProducto()
  {
    return oidComisionProducto;
  }

  public void setOidComisionProducto(Long oidComisionProducto)
  {
    this.oidComisionProducto = oidComisionProducto;
  }
}