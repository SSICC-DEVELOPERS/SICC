/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;

//import java.sql.Timestamp;

import java.util.Date;

/**
 * Autor:
 * Fecha:
 * Descripción Cambio: Se agrega atributo codigoUsuario
 * Notas:
 *       @eiraola 15/12/2005, refac. segun modelo: GCC-CCC-001_2005.11.09 GMIOTTI DT
 */
public class DTOMovimientoBancario extends DTOAuditableSICC  {

    private Long oid;
    private Long empresa;
    private Long numeroLote;
    private Date fechaPago;
    private Long cuentaCorrienteBancaria;
    private Long consecutivoTransaccion;
    private Long numeroFactura;
    private Integer digitoChequeo;
    private BigDecimal importePago;
    private Long numeroCupon;
    //modificado tipo a string por inc 21735
    private String oficinaRecaudadora;
    private String nombreOficina;
    private Long tipoTransaccion;
    private String horario;
    private String usuarioProceso;
    private String codConsultoraReal;
    private String serieDocumentoCreacion;
    private String anioDocumentoCreacion;
    private Integer numeroDocumentoCreacion;
    private String serieDocumentoAplicacion;
    private String anioDocumentoAplicacion;
    private Integer numeroDocumentoAplicacion;
    private Date fechaMovimientoAplicacion;
    private String codError;
    private Character estatusMovimientoTesoreria;
    private String identificadorProceso;
    private String numeroLoteContabilizacion;
    private Date fechaContabilizacion;
    private String observaciones;
    private Long oidConsultoraReal;
    private Long oidTipoAbonoUltimo;
    private Long subacceso;
    private BigDecimal importeAplicado;
    private BigDecimal importeSaldo;
    private Integer numeroHistoria;
    private Long oidSubprocesoMarcaUltimo; //10485
    private BigDecimal importeMovimiento;
    private Long oidMovimientoCaja; //13631
    private Boolean indConfirmaMovimientoManual;
    private String codigoUsuario; // Agregado: GCC-CCC-001
    private Long oidTipoAbonoCreacion;
    private Long oidSubprocesoMarcaCreacion;
  private Long oidMovimientoCC;
  private Date fechaProceso;
  private Date horaProceso;
  private Long oidError;
  private Long numeroDocumento;
  private Date fechaUltimoMivimiento;
  
  
  private Long oidCtaCteBria;   //scs, cambio del cambio P2
	
    public String getAnioDocumentoAplicacion() {
        return anioDocumentoAplicacion;
    }

    public void setAnioDocumentoAplicacion(String newAnioDocumentoAplicacion) {
        anioDocumentoAplicacion = newAnioDocumentoAplicacion;
    }

    public String getAnioDocumentoCreacion() {
        return anioDocumentoCreacion;
    }

    public void setAnioDocumentoCreacion(String newAnioDocumentoCreacion) {
        anioDocumentoCreacion = newAnioDocumentoCreacion;
    }

    public String getCodConsultoraReal() {
        return codConsultoraReal;
    }

    public void setCodConsultoraReal(String newCodConsultoraReal) {
        codConsultoraReal = newCodConsultoraReal;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String newCodError) {
        codError = newCodError;
    }

    public Long getConsecutivoTransaccion() {
        return consecutivoTransaccion;
    }

    public void setConsecutivoTransaccion(Long newConsecutivoTransaccion) {
        consecutivoTransaccion = newConsecutivoTransaccion;
    }

    public Long getCuentaCorrienteBancaria() {
        return cuentaCorrienteBancaria;
    }

    public void setCuentaCorrienteBancaria(Long newCuentaCorrienteBancaria) {
        cuentaCorrienteBancaria = newCuentaCorrienteBancaria;
    }

    public Integer getDigitoChequeo() {
        return digitoChequeo;
    }

    public void setDigitoChequeo(Integer newDigitoChequeo) {
        digitoChequeo = newDigitoChequeo;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long newEmpresa) {
        empresa = newEmpresa;
    }

    public Character getEstatusMovimientoTesoreria() {
        return estatusMovimientoTesoreria;
    }

    public void setEstatusMovimientoTesoreria(Character newEstatusMovimientoTesoreria) {
        estatusMovimientoTesoreria = newEstatusMovimientoTesoreria;
    }

    public Date getFechaContabilizacion() {
        return fechaContabilizacion;
    }

    public void setFechaContabilizacion(Date newFechaContabilizacion) {
        fechaContabilizacion = newFechaContabilizacion;
    }

    public Date getFechaMovimientoAplicacion() {
        return fechaMovimientoAplicacion;
    }

    public void setFechaMovimientoAplicacion(Date newFechaMovimientoAplicacion) {
        fechaMovimientoAplicacion = newFechaMovimientoAplicacion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date newFechaPago) {
        fechaPago = newFechaPago;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String newHorario) {
        horario = newHorario;
    }

    public String getIdentificadorProceso() {
        return identificadorProceso;
    }

    public void setIdentificadorProceso(String newIdentificadorProceso) {
        identificadorProceso = newIdentificadorProceso;
    }

    public BigDecimal getImportePago() {
        return importePago;
    }

    public void setImportePago(BigDecimal newImportePago) {
        importePago = newImportePago;
    }

    public String getNombreOficina() {
        return nombreOficina;
    }

    public void setNombreOficina(String newNombreOficina) {
        nombreOficina = newNombreOficina;
    }

    public Long getNumeroCupon() {
        return numeroCupon;
    }

    public void setNumeroCupon(Long newNumeroCupon) {
        numeroCupon = newNumeroCupon;
    }

    public Integer getNumeroDocumentoAplicacion() {
        return numeroDocumentoAplicacion;
    }

    public void setNumeroDocumentoAplicacion(Integer newNumeroDocumentoAplicacion) {
        numeroDocumentoAplicacion = newNumeroDocumentoAplicacion;
    }

    public Integer getNumeroDocumentoCreacion() {
        return numeroDocumentoCreacion;
    }

    public void setNumeroDocumentoCreacion(Integer newNumeroDocumentoCreacion) {
        numeroDocumentoCreacion = newNumeroDocumentoCreacion;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long newNumeroFactura) {
        numeroFactura = newNumeroFactura;
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Long newNumeroLote) {
        numeroLote = newNumeroLote;
    }

    public String getNumeroLoteContabilizacion() {
        return numeroLoteContabilizacion;
    }

    public void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion) {
        numeroLoteContabilizacion = newNumeroLoteContabilizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }

    public String getOficinaRecaudadora() {
        return oficinaRecaudadora;
    }

    public void setOficinaRecaudadora(String newOficinaRecaudadora) {
        oficinaRecaudadora = newOficinaRecaudadora;
    }

    public String getSerieDocumentoAplicacion() {
        return serieDocumentoAplicacion;
    }

    public void setSerieDocumentoAplicacion(String newSerieDocumentoAplicacion) {
        serieDocumentoAplicacion = newSerieDocumentoAplicacion;
    }

    public String getSerieDocumentoCreacion() {
        return serieDocumentoCreacion;
    }

    public void setSerieDocumentoCreacion(String newSerieDocumentoCreacion) {
        serieDocumentoCreacion = newSerieDocumentoCreacion;
    }

    public Long getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Long newTipoTransaccion) {
        tipoTransaccion = newTipoTransaccion;
    }

    public String getUsuarioProceso() {
        return usuarioProceso;
    }

    public void setUsuarioProceso(String newUsuarioProceso) {
        usuarioProceso = newUsuarioProceso;
    }

    public Long getOid() {
        return oid;
    }
  
    public void setOid(Long newOid) {
        oid = newOid;
    }
  
    public Long getOidConsultoraReal() {
        return oidConsultoraReal;
    }
  
    public void setOidConsultoraReal(Long newOidConsultoraReal) {
        oidConsultoraReal = newOidConsultoraReal;
    }
  
    public Long getOidTipoAbonoUltimo()
    {
        return this.oidTipoAbonoUltimo;
    }
  
    public void setOidTipoAbonoUltimo(Long newOidTipoAbonoUltimo)
    {
        this.oidTipoAbonoUltimo = newOidTipoAbonoUltimo;
    }
  
    public Long getSubacceso() {
        return this.subacceso;
    }
  
    public void setSubacceso(Long newSubacceso) {
        this.subacceso = newSubacceso;
    }
  
    public BigDecimal getImporteAplicado() {
        return this.importeAplicado;
    }
  
    public void setImporteAplicado(BigDecimal newImporteAplicado) {
        this.importeAplicado = newImporteAplicado;
    }
  
    public BigDecimal getImporteSaldo() {
        return this.importeSaldo;
    }
  
    public void setImporteSaldo(BigDecimal newImporteSaldo) {
        this.importeSaldo = newImporteSaldo;
    }
  
    public Integer getNumeroHistoria() {
        return this.numeroHistoria;
    }
  
    public void setNumeroHistoria(Integer newNumeroHistoria) {
        this.numeroHistoria = newNumeroHistoria;
    }

    public Long getOidSubprocesoMarcaUltimo() {
        return oidSubprocesoMarcaUltimo;
    }

    public void setOidSubprocesoMarcaUltimo(Long newOidSubprocesoMarcaUltimo) {
        oidSubprocesoMarcaUltimo = newOidSubprocesoMarcaUltimo;
    }

    public BigDecimal getImporteMovimiento() {
        return importeMovimiento;
    }
  
    public void setImporteMovimiento(BigDecimal newImporteMovimiento) {
        importeMovimiento = newImporteMovimiento;
    }

    public Long getOidMovimientoCaja() {
        return oidMovimientoCaja;
    }

    public void setOidMovimientoCaja(Long newOidMovimientoCaja) {
        oidMovimientoCaja = newOidMovimientoCaja;
    }

    public Boolean getIndConfirmaMovimientoManual()
    {
        return indConfirmaMovimientoManual;
    }

    public void setIndConfirmaMovimientoManual(Boolean indConfirmaMovimientoManual)
    {
        this.indConfirmaMovimientoManual = indConfirmaMovimientoManual;
    }

    public void setCodigoUsuario(String codigoUsuario)
    {
        this.codigoUsuario = codigoUsuario;
    }
  
    public String getCodigoUsuario()
    {
        return codigoUsuario;
    }

    public Long getOidTipoAbonoCreacion()
    {
        return oidTipoAbonoCreacion;
    }

    public void setOidTipoAbonoCreacion(Long oidTipoAbonoCreacion)
    {
        this.oidTipoAbonoCreacion = oidTipoAbonoCreacion;
    }

    public Long getOidSubprocesoMarcaCreacion()
    {
        return oidSubprocesoMarcaCreacion;
    }

    public void setOidSubprocesoMarcaCreacion(Long oidSubprocesoMarcaCreacion)
    {
        this.oidSubprocesoMarcaCreacion = oidSubprocesoMarcaCreacion;
    }

  public Long getOidMovimientoCC() {
    return oidMovimientoCC;
  }

  public void setOidMovimientoCC(Long oidMovimientoCC) {
    this.oidMovimientoCC = oidMovimientoCC;
  }

  public Date getFechaProceso() {
    return fechaProceso;
  }

  public void setFechaProceso(Date fechaProceso) {
    this.fechaProceso = fechaProceso;
  }

  public Date getHoraProceso() {
    return horaProceso;
  }

  public void setHoraProceso(Date horaProceso) {
    this.horaProceso = horaProceso;
  }

  public Long getOidError() {
    return oidError;
  }

  public void setOidError(Long oidError) {
    this.oidError = oidError;
  }

  public Long getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(Long numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }


  public void setOidCtaCteBria(Long oidCtaCteBria) {
    this.oidCtaCteBria = oidCtaCteBria;
  }


  public Long getOidCtaCteBria() {
    return oidCtaCteBria;
  }


   public void setFechaUltimoMivimiento(Date fechaUltimoMivimiento) {
      this.fechaUltimoMivimiento = fechaUltimoMivimiento;
   }


   public Date getFechaUltimoMivimiento() {
      return fechaUltimoMivimiento;
   }

}