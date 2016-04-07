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
package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.sql.Date;

public class DTOLista extends DTOBelcorp  {
    public DTOLista() { }
    
    private Long oidSoliCabe;
    private Long oidCliente;
    private BigDecimal importeNetoOrigen;
    private BigDecimal importeNetoDestino;
    private BigDecimal importeDiferencia;
    private Long oidTipoSolicitudPais;
    private Long oidTipoOferaDestino;
    private Long oidTipoOferta;
    private Integer numeroUnidades;
    private Long oidTipoCliente;
    private Long oidSubTipoCliente;
    private Long oidTipoDocumento;
    private Long oidPeriodo;
    private Long oidTipoOperacion;
    private Long oidPeriodoReclamo;
    private Long oidTerritorioAdministrativo;
    private Long oidProductoOrigen; // BELC300020144 
    private Long oidProductoDestino; // BELC300020144 
    private Date fechaDocumentoReferencia; // BELC300022743
    private Long oidMFDestino; // BELC300022743
    private Long oidMFOrigen; //BELC300022743
    
    /* Agregado por ssantana, 19/07/2006, inc. BELC300023578  */ 
    private Long oidCanal;
    private Long oidMarca;
    private Long oidPosicionReferencia;
    private BigDecimal importeCatalogoDestino;
    private BigDecimal importeCatalogoOrigen;
   /* Fin Agregado por ssantana, 19/07/2006, inc. BELC300023578  */ 
    
    public Date getFechaDocumentoReferencia() {
      return this.fechaDocumentoReferencia;
    }
    
    public void setFechaDocumentoReferencia(Date fechaDocumentoReferencia) {
      this.fechaDocumentoReferencia = fechaDocumentoReferencia;
    }
    
    public Long getOidMFDestino() {
      return this.oidMFDestino;  
    }   
    
    public void setOidMFDestino(Long oidMFDestino) {
      this.oidMFDestino = oidMFDestino;
    }
    
    public Long getOidMFOrigen() {
      return this.oidMFOrigen;
    }
    
    public void setOidMFOrigen(Long oidMFOrigen) {
      this.oidMFOrigen = oidMFOrigen;
    }    

    public BigDecimal getImporteDiferencia() {
        return importeDiferencia;
    }

    public void setImporteDiferencia(BigDecimal importeDiferencia) {
        this.importeDiferencia = importeDiferencia;
    }

    public BigDecimal getImporteNetoDestino() {
        return importeNetoDestino;
    }

    public void setImporteNetoDestino(BigDecimal importeNetoDestino) {
        this.importeNetoDestino = importeNetoDestino;
    }

    public BigDecimal getImporteNetoOrigen() {
        return importeNetoOrigen;
    }

    public void setImporteNetoOrigen(BigDecimal importeNetoOrigen) {
        this.importeNetoOrigen = importeNetoOrigen;
    }

    public Integer getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(Integer numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodoReclamo() {
        return oidPeriodoReclamo;
    }

    public void setOidPeriodoReclamo(Long oidPeriodoReclamo) {
        this.oidPeriodoReclamo = oidPeriodoReclamo;
    }

    public Long getOidSoliCabe() {
        return oidSoliCabe;
    }

    public void setOidSoliCabe(Long oidSoliCabe) {
        this.oidSoliCabe = oidSoliCabe;
    }

    public Long getOidSubTipoCliente() {
        return oidSubTipoCliente;
    }

    public void setOidSubTipoCliente(Long oidSubTipoCliente) {
        this.oidSubTipoCliente = oidSubTipoCliente;
    }

    public Long getOidTerritorioAdministrativo() {
        return oidTerritorioAdministrativo;
    }

    public void setOidTerritorioAdministrativo(Long oidTerritorioAdministrativo) {
        this.oidTerritorioAdministrativo = oidTerritorioAdministrativo;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }

    public Long getOidTipoDocumento() {
        return oidTipoDocumento;
    }

    public void setOidTipoDocumento(Long oidTipoDocumento) {
        this.oidTipoDocumento = oidTipoDocumento;
    }

    public Long getOidTipoOferaDestino() {
        return oidTipoOferaDestino;
    }

    public void setOidTipoOferaDestino(Long oidTipoOferaDestino) {
        this.oidTipoOferaDestino = oidTipoOferaDestino;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidTipoOperacion() {
        return oidTipoOperacion;
    }

    public void setOidTipoOperacion(Long oidTipoOperacion) {
        this.oidTipoOperacion = oidTipoOperacion;
    }

    public Long getOidTipoSolicitudPais() {
        return oidTipoSolicitudPais;
    }

    public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais) {
        this.oidTipoSolicitudPais = oidTipoSolicitudPais;
    }

    public Long getOidProductoOrigen() {
        return oidProductoOrigen;
    }

    public void setOidProductoOrigen(Long oidProductoOrigen) {
        this.oidProductoOrigen = oidProductoOrigen;
    }

    public Long getOidProductoDestino() {
        return oidProductoDestino;
    }

    public void setOidProductoDestino(Long oidProductoDestino) {
        this.oidProductoDestino = oidProductoDestino;
    }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }

    public Long getOidPosicionReferencia() {
        return oidPosicionReferencia;
    }

    public void setOidPosicionReferencia(Long oidPosicionReferencia) {
        this.oidPosicionReferencia = oidPosicionReferencia;
    }

    public BigDecimal getImporteCatalogoDestino() {
        return importeCatalogoDestino;
    }

    public void setImporteCatalogoDestino(BigDecimal importeCatalogoDestino) {
        this.importeCatalogoDestino = importeCatalogoDestino;
    }

    public BigDecimal getImporteCatalogoOrigen() {
        return importeCatalogoOrigen;
    }

    public void setImporteCatalogoOrigen(BigDecimal importeCatalogoOrigen) {
        this.importeCatalogoOrigen = importeCatalogoOrigen;
    }



}