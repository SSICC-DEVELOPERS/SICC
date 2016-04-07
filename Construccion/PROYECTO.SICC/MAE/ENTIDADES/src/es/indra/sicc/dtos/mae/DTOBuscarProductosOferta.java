package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarProductosOferta extends DTOSiccPaginacion  {

  private String codigoSAP;
  private String descripcion;
  private Long marca;
  private Long lineaProducto;  
  private Long unidadNegocio;
  private Long negocio;
  private Long generico;
  private Long supergenerico;
  
  // vbongiov -- Cambio 20090930 -- 16/07/2009
  private Boolean indPremio;

    /**
     * Construye un DTOBuscarProductosOferta
     */
  public DTOBuscarProductosOferta() {
  }

  public String getCodigoSAP() {
    return codigoSAP;
  }

  public void setCodigoSAP(String newCodigoSAP) {
    codigoSAP = newCodigoSAP;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    descripcion = newDescripcion;
  }

  public Long getMarca() {
    return marca;
  }

  public void setMarca(Long newMarca) {
    marca = newMarca;
  }

  public Long getLineaProducto() {
    return lineaProducto;
  }

  public void setLineaProducto(Long newLineaProducto) {
    lineaProducto = newLineaProducto;
  }

  public Long getUnidadNegocio() {
    return unidadNegocio;
  }

  public void setUnidadNegocio(Long newUnidadNegocio) {
    unidadNegocio = newUnidadNegocio;
  }

  public Long getNegocio() {
    return negocio;
  }

  public void setNegocio(Long newNegocio) {
    negocio = newNegocio;
  }

  public Long getGenerico() {
    return generico;
  }

  public void setGenerico(Long newGenerico) {
    generico = newGenerico;
  }

  public Long getSupergenerico() {
    return supergenerico;
  }

  public void setSupergenerico(Long newSupergenerico) {
    supergenerico = newSupergenerico;
  }
  
    public Boolean getIndPremio()
    {
      return indPremio;
    }

    public void setIndPremio(Boolean newIndPremio)
    {
      indPremio = newIndPremio;
    }
}