package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.inc.DTOPremioArticulo;
import es.indra.sicc.dtos.inc.DTOPremioPuntos;
import es.indra.sicc.dtos.inc.DTOPremioDescuento;
import es.indra.sicc.dtos.inc.DTOPremioMonetario;

public class DTONivelPremiacion extends DTOBelcorp 
{
  private Long oid;
  private String descripcion;
  private Integer numeroNivel;
  private Boolean indNivelSelectivo;
  private Integer cantidadFijaPuntos;
  private Integer cantidadDesde;
  private Integer cantidadHasta;
  private Integer puntajeServicio;
  private Long oidTipoPremio;
  private Integer numeroAspirantes;
  private Integer puntosProductosExigidos;
  private DTOPremioPuntos premioPuntos;
  private Boolean indPremiosPuntos;
  private DTOPremioMonetario premioMonetario;
  private Boolean indPremiosMonetarios;
  private DTOPremioArticulo premioArticulo;
  private Boolean indPremiosArticulos;
  private DTOPremioDescuento premioDescuento;
  private Boolean indPremiosDescuento;
  // vbongiov -- Cambio 20090930 -- 16/07/2009
  private String descripcionNivel;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public Integer getNumeroNivel()
  {
    return numeroNivel;
  }

  public void setNumeroNivel(Integer numeroNivel)
  {
    this.numeroNivel = numeroNivel;
  }

  public Boolean getIndNivelSelectivo()
  {
    return indNivelSelectivo;
  }

  public void setIndNivelSelectivo(Boolean indNivelSelectivo)
  {
    this.indNivelSelectivo = indNivelSelectivo;
  }

  public Integer getCantidadFijaPuntos()
  {
    return cantidadFijaPuntos;
  }

  public void setCantidadFijaPuntos(Integer cantidadFijaPuntos)
  {
    this.cantidadFijaPuntos = cantidadFijaPuntos;
  }

  public Integer getCantidadDesde()
  {
    return cantidadDesde;
  }

  public void setCantidadDesde(Integer cantidadDesde)
  {
    this.cantidadDesde = cantidadDesde;
  }

  public Integer getCantidadHasta()
  {
    return cantidadHasta;
  }

  public void setCantidadHasta(Integer cantidadHasta)
  {
    this.cantidadHasta = cantidadHasta;
  }

  public Integer getPuntajeServicio()
  {
    return puntajeServicio;
  }

  public void setPuntajeServicio(Integer puntajeServicio)
  {
    this.puntajeServicio = puntajeServicio;
  }

  public Long getOidTipoPremio()
  {
    return oidTipoPremio;
  }

  public void setOidTipoPremio(Long oidTipoPremio)
  {
    this.oidTipoPremio = oidTipoPremio;
  }

  public Integer getNumeroAspirantes()
  {
    return numeroAspirantes;
  }

  public void setNumeroAspirantes(Integer numeroAspirantes)
  {
    this.numeroAspirantes = numeroAspirantes;
  }

  public Integer getPuntosProductosExigidos() {
    return puntosProductosExigidos;
  }

  public void setPuntosProductosExigidos(Integer puntosProductosExigidos) {
    this.puntosProductosExigidos = puntosProductosExigidos;
  }

  public DTOPremioPuntos getPremioPuntos() {
    return premioPuntos;
  }

  public void setPremioPuntos(DTOPremioPuntos premioPuntos) {
    this.premioPuntos = premioPuntos;
  }

  public Boolean getIndPremiosPuntos() {
    return indPremiosPuntos;
  }

  public void setIndPremiosPuntos(Boolean indPremiosPuntos) {
    this.indPremiosPuntos = indPremiosPuntos;
  }

  public DTOPremioMonetario getPremioMonetario() {
    return premioMonetario;
  }

  public void setPremioMonetario(DTOPremioMonetario premioMonetario) {
    this.premioMonetario = premioMonetario;
  }

  public Boolean getIndPremiosMonetarios() {
    return indPremiosMonetarios;
  }

  public void setIndPremiosMonetarios(Boolean indPremiosMonetarios) {
    this.indPremiosMonetarios = indPremiosMonetarios;
  }

  public DTOPremioArticulo getPremioArticulo() {
    return premioArticulo;
  }

  public void setPremioArticulo(DTOPremioArticulo premioArticulo) {
    this.premioArticulo = premioArticulo;
  }

  public Boolean getIndPremiosArticulos() {
    return indPremiosArticulos;
  }

  public void setIndPremiosArticulos(Boolean indPremiosArticulos) {
    this.indPremiosArticulos = indPremiosArticulos;
  }

  public DTOPremioDescuento getPremioDescuento() {
    return premioDescuento;
  }

  public void setPremioDescuento(DTOPremioDescuento premioDescuento) {
    this.premioDescuento = premioDescuento;
  }

  public Boolean getIndPremiosDescuento() {
    return indPremiosDescuento;
  }

  public void setIndPremiosDescuento(Boolean indPremiosDescuento) {
    this.indPremiosDescuento = indPremiosDescuento;
  }
  
  public String getDescripcionNivel()
  {
    return descripcionNivel;
  }
    
  public void setDescripcionNivel(String descripcionNivel)
  {
    this.descripcionNivel = descripcionNivel;
  }
}