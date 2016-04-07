package es.indra.sicc.logicanegocio.pre;

public abstract class OfertaOrdenar implements Comparable {
  
  public String textoBreve;
  public Integer numeroGrupo;
  public Long oidOferta;
  public Long oidTipoEstrategia;
  public Boolean productoPrincipal;
  public Boolean indicadorCondicionado;
  public Boolean indicadorCondicionante;
  public Long oidDetalleOferta;

  public OfertaOrdenar() {
  }  

  public String getTextoBreve() {
    return textoBreve;
  }

  public void setTextoBreve(String textoBreve) {
    this.textoBreve = textoBreve;
  }

  public Integer getNumeroGrupo() {
    return numeroGrupo;
  }

  public void setNumeroGrupo(Integer numeroGrupo) {
    this.numeroGrupo = numeroGrupo;
  }

  public Long getOidOferta() {
    return oidOferta;
  }

  public void setOidOferta(Long oidOferta) {
    this.oidOferta = oidOferta;
  }

  public Long getOidTipoEstrategia() {
    return oidTipoEstrategia;
  }

  public void setOidTipoEstrategia(Long oidTipoEstrategia) {
    this.oidTipoEstrategia = oidTipoEstrategia;
  }

  public Boolean getProductoPrincipal() {
    return productoPrincipal;
  }

  public void setProductoPrincipal(Boolean productoPrincipal) {
    this.productoPrincipal = productoPrincipal;
  }

  public Boolean getIndicadorCondicionado() {
    return indicadorCondicionado;
  }

  public void setIndicadorCondicionado(Boolean indicadorCondicionado) {
    this.indicadorCondicionado = indicadorCondicionado;
  }

  public Boolean getIndicadorCondicionante() {
    return indicadorCondicionante;
  }

  public void setIndicadorCondicionante(Boolean indicadorCondicionante) {
    this.indicadorCondicionante = indicadorCondicionante;
  }

  public Long getOidDetalleOferta() {
    return oidDetalleOferta;
  }

  public void setOidDetalleOferta(Long oidDetalleOferta) {
    this.oidDetalleOferta = oidDetalleOferta;
  }
}