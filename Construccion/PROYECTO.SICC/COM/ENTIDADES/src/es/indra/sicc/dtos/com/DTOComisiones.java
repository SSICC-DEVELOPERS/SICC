package es.indra.sicc.dtos.com;

import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.com.DTOComisionesVentasHistoricas;

public class DTOComisiones extends DTOAuditableSICC {
  private Long oid;
  private String codigo;
  private Integer version;
  private DTOI18nSICC[] attTraducible;
  private Integer periodosEspera;
  private String concepto;
  private Boolean comparativo;
  private Boolean tratamientoDiferencial;
  private Date fecUltimoEstado;
  private String observaciones;
  private Long oidPlantillasComisionesPais;
  private Long oidPlantillasComisionesMarca;
  private Long oidPeriodoDesde;  
  private Long oidPeriodoHasta;
  private Long oidPeriodoVigorModificacion;
  private ArrayList comisionesAccesos;
  private ArrayList comisionesProductos;
  private ArrayList comisionesCobranza;
  private DTOComisionesVentas comisionesVentas;
  private DTOComisionesVentasHistoricas comisionesVentaHistorica;
  private ArrayList comisionesClientes;
  private Long oidTipoComision;
  private Long oidEstado;
  private Long oidCanal;
  private String descCanal;
  private Long oidMarca;
  private String descMarca;
  private Long oidPlantillasComisones;
  private String indVentaCobranza;
  private DTOPlantillaDetalle plantillaDetalle;
  
  // vbongiov -- Cambio 20090913 -- 5/08/2009
  private Boolean consideraSabDomFer;
  private Boolean dsctoImpstoVtaPagos;

  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
  private Boolean comisionEscalonada;
  
  public DTOComisiones() {  }
  
  public Long getOidMarca()  {
    return this.oidMarca;
  }
  
  public void setOidMarca(Long newOidMarca) {
    this.oidMarca = newOidMarca;
  }
  
  public String getDescMarca() {
    return this.descMarca;
  }
  
  public void setDescMarca(String newDescMarca)  {
    this.descMarca = newDescMarca;
  }
  
  public Long getOid() {
    return this.oid;
  }
  
  public void setOid(Long newOid) {
    this.oid = newOid;
  }
  
  public String getCodigo() {
    return this.codigo;
  }
  
  public void setCodigo(String newCodigo)  {
    this.codigo = newCodigo;
  }
  
  public Integer getVersion() {
    return this.version;
  }
  
  public void setVersion(Integer newVersion) {
    this.version = newVersion;
  }
  
  public DTOI18nSICC[] getAttTraducible() {
    return this.attTraducible;
  }
  
  public void setAttTraducible(DTOI18nSICC[] newAttTraducible) {
    this.attTraducible = newAttTraducible;
  }
  
  public Integer getPeriodosEspera() {
    return this.periodosEspera;
  }
  
  public void setPeriodosEspera(Integer newPeriodosEspera) {
    this.periodosEspera = newPeriodosEspera;
  }
  
  public String getConcepto() {
    return this.concepto;
  }
  
  public void setConcepto(String newConcepto) {
    this.concepto = newConcepto;
  }
  
  public Boolean getComparativo() {
    return this.comparativo;
  }
  
  public void setComparativo(Boolean newComparativo) {
    this.comparativo = newComparativo;
  }
  
  public Boolean getTratamientoDiferencial()  {
    return this.tratamientoDiferencial;
  }
  
  public void setTratamientoDiferencial(Boolean newTratamientoDiferencial) {
    this.tratamientoDiferencial = newTratamientoDiferencial;
  }
  
  public Date getFecUltimoEstado() {
    return this.fecUltimoEstado;
  }
  
  public void setFecUltimoEstado(Date newFecUltimoEstado) {
    this.fecUltimoEstado = newFecUltimoEstado;
  }
  
  public String getObservaciones() {
    return this.observaciones;
  }
  
  public void setObservaciones(String newObservaciones) {
    this.observaciones = newObservaciones;
  }
  
  public Long getOidPlantillasComisionesPais()  {
    return this.oidPlantillasComisionesPais;
  }
  
  public void setOidPlantillasComisionesPais(Long newOidPlantillasComisionesPais) {
    this.oidPlantillasComisionesPais = newOidPlantillasComisionesPais;
  }
  
  public Long getOidPlantillasComisionesMarca() {
    return this.oidPlantillasComisionesMarca;
  }
  
  public void setOidPlantillasComisionesMarca(Long newOidPlantillasComisionesMarca) {
    this.oidPlantillasComisionesMarca = newOidPlantillasComisionesMarca;
  }
  
  public Long getOidPeriodoDesde() {
    return this.oidPeriodoDesde;
  }
  
  public void setOidPeriodoDesde(Long newOidPeriodoDesde) {
    this.oidPeriodoDesde = newOidPeriodoDesde;
  }
  
  public Long getOidPeriodoHasta() {
    return this.oidPeriodoHasta;
  }
  
  public void setOidPeriodoHasta(Long newOidPeriodoHasta) {
    this.oidPeriodoHasta = newOidPeriodoHasta;
  }
  
  public Long getOidPeriodoVigorModificacion() {
    return this.oidPeriodoVigorModificacion;
  }
  
  public void setOidPeriodoVigorModificacion(Long newOidPeriodoVigorModificacion) {
    this.oidPeriodoVigorModificacion = newOidPeriodoVigorModificacion;
  }
  
  public ArrayList getComisionesAccesos() {
    return this.comisionesAccesos;
  }
  
  public void setComisionesAccesos(ArrayList newComisionesAccesos) {
    this.comisionesAccesos = newComisionesAccesos;
  }
  
  public ArrayList getComisionesProductos() {
    return this.comisionesProductos;
  }
  
  public void setComisionesProductos(ArrayList newComisionesProductos) {
    this.comisionesProductos = newComisionesProductos;
  }
  
  public ArrayList getComisionesCobranza() {
    return this.comisionesCobranza;
  }
  
  public void setComisionesCobranza(ArrayList newComisionesCobranza) {
    this.comisionesCobranza = newComisionesCobranza;
  }
  
  public DTOComisionesVentas getComisionesVentas() {
    return this.comisionesVentas;
  }
  
  public void setComisionesVentas(DTOComisionesVentas newComisionesVentas) {
    this.comisionesVentas = newComisionesVentas;
  }
  
  public DTOComisionesVentasHistoricas getComisionesVentaHistorica() {
    return this.comisionesVentaHistorica;
  }
  
  public void setComisionesVentaHistorica(DTOComisionesVentasHistoricas newComisionesVentaHistorica) {
    this.comisionesVentaHistorica = newComisionesVentaHistorica;
  }
  
  public ArrayList getComisionesClientes() {
    return this.comisionesClientes;
  }
  
  public void setComisionesClientes(ArrayList newComisionesClientes) {
    this.comisionesClientes = newComisionesClientes;  
  }
  
  public Long getOidTipoComision() {
    return this.oidTipoComision;
  }
  
  public void setOidTipoComision(Long newOidTipoComision) {
    this.oidTipoComision = newOidTipoComision;
  }
  
  public Long getOidEstado() {
    return this.oidEstado;
  }
  
  public void setOidEstado(Long newOidEstado) {
    this.oidEstado = newOidEstado;
  }
  
  public Long getOidCanal() {
    return this.oidCanal;
  }
  
  public void setOidCanal(Long newOidCanal) {
    this.oidCanal = newOidCanal;
  }  
  
  public String getDescCanal() {
    return this.descCanal;
  }
  
  public void setDescCanal(String newDescCanal) {
    this.descCanal = newDescCanal;
  }  

    public Long getOidPlantillasComisones()
    {
        return oidPlantillasComisones;
    }

    public void setOidPlantillasComisones(Long oidPlantillasComisones)
    {
        this.oidPlantillasComisones = oidPlantillasComisones;
    }

    public String getIndVentaCobranza()
    {
        return indVentaCobranza;
    }

    public void setIndVentaCobranza(String indVentaCobranza)
    {
        this.indVentaCobranza = indVentaCobranza;
    }


    public void setPlantillaDetalle(DTOPlantillaDetalle plantillaDetalle)
    {
        this.plantillaDetalle = plantillaDetalle;
    }


    public DTOPlantillaDetalle getPlantillaDetalle()
    {
        return plantillaDetalle;
    }
    
    public Boolean getConsideraSabDomFer()  {
      return this.consideraSabDomFer;
    }
    
    public void setConsideraSabDomFer(Boolean newConsideraSabDomFer) {
      this.consideraSabDomFer = newConsideraSabDomFer;
    }
    
    public Boolean getDsctoImpstoVtaPagos()  {
      return this.dsctoImpstoVtaPagos;
    }
    
    public void setDsctoImpstoVtaPagos(Boolean newDsctoImpstoVtaPagos) {
      this.dsctoImpstoVtaPagos = newDsctoImpstoVtaPagos;
    }

    public void setComisionEscalonada(Boolean comisionEscalonada) {
        this.comisionEscalonada = comisionEscalonada;
    }

    public Boolean getComisionEscalonada() {
        return comisionEscalonada;
    }
}
