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
import java.util.Vector;

public class DTODatosEstrategia extends DTOSiccPaginacion  {
 

  private Long oid;
  private String codigo;
  private Long oidTipoEstrategia;
  private String descripcionTipoEstrategia;
  private Boolean indGrupos;
  private Boolean indCondicionada;
  private Boolean indVS;
  private Boolean indPaquetes;
  private Integer maxGrupos;
  private Integer maxGruposCondicionados;
  private Integer maxGruposCondicionantes;
  private Boolean listaRanking;
  private Boolean cuadreGrupos;
  private Long oidTipoProducto;
  private Boolean cvImprimible;
  private Boolean modificableImprimible;
  private Boolean cvDespachoAutomatico;
  private Boolean modificableDespachoAutomatico;
  private Boolean cvDigitable;
  private Boolean modificableDigitable;
  private Vector attriTraducible;
    private String descripcion;
  private Integer ordenAsignacionCUV;

  public DTODatosEstrategia() {
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String newCodigo) {
    codigo = newCodigo;
  }

  public Long getOidTipoEstrategia() {
    return oidTipoEstrategia;
  }

  public void setOidTipoEstrategia(Long newOidTipoEstrategia) {
    oidTipoEstrategia = newOidTipoEstrategia;
  }

  public String getDescripcionTipoEstrategia() {
    return descripcionTipoEstrategia;
  }

  public void setDescripcionTipoEstrategia(String newDescripcionTipoEstrategia) {
    descripcionTipoEstrategia = newDescripcionTipoEstrategia;
  }

  public Boolean getIndGrupos() {
    return indGrupos;
  }

  public void setIndGrupos(Boolean newIndGrupos) {
    indGrupos = newIndGrupos;
  }

  public Boolean getIndCondicionada() {
    return indCondicionada;
  }

  public void setIndCondicionada(Boolean newIndCondicionada) {
    indCondicionada = newIndCondicionada;
  }

  public Boolean getIndVS() {
    return indVS;
  }

  public void setIndVS(Boolean newIndVS) {
    indVS = newIndVS;
  }

  public Boolean getIndPaquetes() {
    return indPaquetes;
  }

  public void setIndPaquetes(Boolean newIndPaquetes) {
    indPaquetes = newIndPaquetes;
  }

  public Integer getMaxGrupos() {
    return maxGrupos;
  }

  public void setMaxGrupos(Integer newMaxGrupos) {
    maxGrupos = newMaxGrupos;
  }

  public Integer getMaxGruposCondicionados() {
    return maxGruposCondicionados;
  }

  public void setMaxGruposCondicionados(Integer newMaxGruposCondicionados) {
    maxGruposCondicionados = newMaxGruposCondicionados;
  }

  public Integer getMaxGruposCondicionantes() {
    return maxGruposCondicionantes;
  }

  public void setMaxGruposCondicionantes(Integer newMaxGruposCondicionantes) {
    maxGruposCondicionantes = newMaxGruposCondicionantes;
  }

  public Boolean getListaRanking() {
    return listaRanking;
  }

  public void setListaRanking(Boolean newListaRanking) {
    listaRanking = newListaRanking;
  }

  public Boolean getCuadreGrupos() {
    return cuadreGrupos;
  }

  public void setCuadreGrupos(Boolean newCuadreGrupos) {
    cuadreGrupos = newCuadreGrupos;
  }

  public Long getOidTipoProducto() {
    return oidTipoProducto;
  }

  public void setOidTipoProducto(Long newOidTipoProducto) {
    oidTipoProducto = newOidTipoProducto;
  }

  public Boolean getCvImprimible() {
    return cvImprimible;
  }

  public void setCvImprimible(Boolean newCvImprimible) {
    cvImprimible = newCvImprimible;
  }

  public Boolean getModificableImprimible() {
    return modificableImprimible;
  }

  public void setModificableImprimible(Boolean newModificableImprimible) {
    modificableImprimible = newModificableImprimible;
  }

  public Boolean getCvDespachoAutomatico() {
    return cvDespachoAutomatico;
  }

  public void setCvDespachoAutomatico(Boolean newCvDespachoAutomatico) {
    cvDespachoAutomatico = newCvDespachoAutomatico;
  }

  public Boolean getModificableDespachoAutomatico() {
    return modificableDespachoAutomatico;
  }

  public void setModificableDespachoAutomatico(Boolean newModificableDespachoAutomatico) {
    modificableDespachoAutomatico = newModificableDespachoAutomatico;
  }

  public Boolean getCvDigitable() {
    return cvDigitable;
  }

  public void setCvDigitable(Boolean newCvDigitable) {
    cvDigitable = newCvDigitable;
  }

  public Boolean getModificableDigitable() {
    return modificableDigitable;
  }

  public void setModificableDigitable(Boolean newModificableDigitable) {
    modificableDigitable = newModificableDigitable;
  }

  public Vector getAttriTraducible() {
    return attriTraducible;
  }

  public void setAttriTraducible(Vector newAttriTraducible) {
    attriTraducible = newAttriTraducible;
  }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

  public Integer getOrdenAsignacionCUV() {
    return ordenAsignacionCUV;
  }

  public void setOrdenAsignacionCUV(Integer ordenAsignacionCUV) {
    this.ordenAsignacionCUV = ordenAsignacionCUV;
  }
}