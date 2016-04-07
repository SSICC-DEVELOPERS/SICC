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

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import es.indra.sicc.util.DTOBelcorp;

/**
 * Autor:
 * Fecha:
 * Descripción Cambio: Se agrega atributo movimientosBancariosCancelados
 * Notas:
 *       @eiraola 15/12/2005, refac. segun modelo: GCC-CCC-001_2005.11.09 GMIOTTI DT
 *       @pperanzola [1] 19/05/2006 se modifica según incidencia DBLG500000714 
 */
public class DTOMovimientoCuentaCompleto extends DTOBelcorp  {

    private Long oid;
    private Long empresa;
    private Long oidTipoSolicitud;
    private String numeroSerieCuota;
    private Integer numeroIdentificadorCuota;
    private String ejercicioCuota;
    private Integer numeroOrdenCuota;
    private Long subacceso;
    private Long marca;
    private Long oidSugerenciaVenta;
    private Long oidRegion;
    //private Long oidZona;
    private Long oidSeccion;
    private Long territorioAdministrativo;
    private Long tipoPeriodoDesde;
    private Long periodoDesde;
    private Long oidCliente;
    private Long tipoCliente;
    private Long oidSubtipoCliente;
    private Long oidPedidoSolicitudCab;
    private Date fechaDocumento;
    private Date fechaVencimiento;
    private Date fechaValor;
    private Double importe;
    private Double importePagado;
    private Double importePendiente;
    private Double importeMovimientoCuenta;                      //agregado por CCC04, para grabacion de reg. en historico
    private Long divisa;
    private Double importeDivisa;
    private Double importePagadoDivisa;
    private BigDecimal tipoCambio;
    private Long medioPago;
    private String usuario;
    private String observaciones;
    private String referenciaNumeroDocumentoExterno;
    private Timestamp fechaUltimoMovimiento;
    private String documentoMesSerie;
    private String documentoAnyo;
    private Integer documentoNumero;
    private String ultimoDocumentoMesSerie;
    private String ultimoDocumentoAnyo;
    private Integer ultimoDocumentoNumero;
    private Integer ultimoNumeroHistoria;
    private String numeroLoteContabilizacion;
    private Date fechaContabilizacion;
    private Boolean indicaDescuentoRecargo;
    private Long cuentaCuota;
    private Long cuentaOrigen;
    private Long marcaSituacion;
    private Long subprocesoCreacion;
    private Long subprocesoUltimo;
    private Long tipoAbonoCreacion;
    private Long tipoAbonoUltimo;
    private BigDecimal importePago;
    private BigDecimal importePagoDivisa;
    private BigDecimal importeMovimiento;
    private BigDecimal importeMovimientoDivisa;
    private Long oidMoneda;
    private Long oidTipoDocumentoLegal;
    private Integer numeroLoteFactu;
    //private String dcAplicado;
    private Long oidCanal;
    private Long oidAcceso;
    
    private DTOMovimientoBancario[] movimientosBancariosCancelados; // Agregado GCC-CCC-001
    
    private Long oidCargoAbono; // DBLG500000714 [1]
  private Long oidDocumentoReferencia;
  private Long tipoAbonoSubprocesoUltimo;
  private Long oidCuotaNueva;
  private Integer numeroLineaDetalleCargoAbono;
  
  private Long oidCtaCteBria;   //scs, cambio del cambio P2
  
    private Integer numDecimales;   //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
  
  
    public DTOMovimientoCuentaCompleto() {
    }
  
    public Long getCuentaCuota() {
        return cuentaCuota;
    }
  
    public void setCuentaCuota(Long newCuentaCuota) {
        cuentaCuota = newCuentaCuota;
    }
  
    public Long getCuentaOrigen() {
        return cuentaOrigen;
    }
  
    public void setCuentaOrigen(Long newCuentaOrigen) {
        cuentaOrigen = newCuentaOrigen;
    }
  
    public String getDocumentoAnyo() {
        return documentoAnyo;
    }
  
    public void setDocumentoAnyo(String newDocumentoAnyo) {
        documentoAnyo = newDocumentoAnyo;
    }
  
    public Long getDivisa() {
        return divisa;
    }
  
    public void setDivisa(Long newDivisa) {
        divisa = newDivisa;
    }
  
    public String getDocumentoMesSerie() {
        return documentoMesSerie;
    }
  
    public void setDocumentoMesSerie(String newDocumentoMesSerie) {
        documentoMesSerie = newDocumentoMesSerie;
    }
  
    public Integer getDocumentoNumero() {
        return documentoNumero;
    }
  
    public void setDocumentoNumero(Integer newDocumentoNumero) {
        documentoNumero = newDocumentoNumero;
    }
  
    public String getEjercicioCuota() {
        return ejercicioCuota;
    }
  
    public void setEjercicioCuota(String newEjercicioCuota) {
        ejercicioCuota = newEjercicioCuota;
    }
  
    public Long getEmpresa() {
        return empresa;
    }
  
    public void setEmpresa(Long newEmpresa) {
        empresa = newEmpresa;
    }
  
    public Date getFechaContabilizacion() {
        return fechaContabilizacion;
    }
  
    public void setFechaContabilizacion(Date newFechaContabilizacion) {
        fechaContabilizacion = newFechaContabilizacion;
    }
  
    public Date getFechaDocumento() {
        return fechaDocumento;
    }
  
    public void setFechaDocumento(Date newFechaDocumento) {
        fechaDocumento = newFechaDocumento;
    }
  
    public Timestamp getFechaUltimoMovimiento() {
        return fechaUltimoMovimiento;
    }
  
    public void setFechaUltimoMovimiento(Timestamp newFechaUltimoMovimiento) {
        fechaUltimoMovimiento = newFechaUltimoMovimiento;
    }
  
    public Date getFechaValor() {
        return fechaValor;
    }
  
    public void setFechaValor(Date newFechaValor) {
        fechaValor = newFechaValor;
    }
  
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
  
    public void setFechaVencimiento(Date newFechaVencimiento) {
        fechaVencimiento = newFechaVencimiento;
    }
  
    public Double getImporte() {
        return importe;
    }
  
    public void setImporte(Double newImporte) {
        importe = newImporte;
    }
  
    public Double getImporteDivisa() {
        return importeDivisa;
    }
  
    public void setImporteDivisa(Double newImporteDivisa) {
        importeDivisa = newImporteDivisa;
    }
  
    public BigDecimal getImporteMovimiento() {
        return importeMovimiento;
    }
  
    public void setImporteMovimiento(BigDecimal newImporteMovimiento) {
        importeMovimiento = newImporteMovimiento;
    }
  
    public BigDecimal getImporteMovimientoDivisa() {
        return importeMovimientoDivisa;
    }
  
    public void setImporteMovimientoDivisa(BigDecimal newImporteMovimientoDivisa) {
        importeMovimientoDivisa = newImporteMovimientoDivisa;
    }
  
    public Double getImportePagado() {
        return importePagado;
    }
  
    public void setImportePagado(Double newImportePagado) {
        importePagado = newImportePagado;
    }
  
    public Double getImportePagadoDivisa() {
        return importePagadoDivisa;
    }
  
    public void setImportePagadoDivisa(Double newImportePagadoDivisa) {
        importePagadoDivisa = newImportePagadoDivisa;
    }
  
    public BigDecimal getImportePago() {
        return importePago;
    }
  
    public void setImportePago(BigDecimal newImportePago) {
        importePago = newImportePago;
    }
  
    public BigDecimal getImportePagoDivisa() {
        return importePagoDivisa;
    }
  
    public void setImportePagoDivisa(BigDecimal newImportePagoDivisa) {
        importePagoDivisa = newImportePagoDivisa;
    }
  
    public Double getImportePendiente() {
        return importePendiente;
    }
  
    public void setImportePendiente(Double newImportePendiente) {
        importePendiente = newImportePendiente;
    }
  
    public Boolean getIndicaDescuentoRecargo() {
        return indicaDescuentoRecargo;
    }
  
    public void setIndicaDescuentoRecargo(Boolean newIndicaDescuentoRecargo) {
        indicaDescuentoRecargo = newIndicaDescuentoRecargo;
    }
  
    public Long getMarca() {
        return marca;
    }
  
    public void setMarca(Long newMarca) {
        marca = newMarca;
    }
  
    public Long getMarcaSituacion() {
        return marcaSituacion;
    }
  
    public void setMarcaSituacion(Long newMarcaSituacion) {
        marcaSituacion = newMarcaSituacion;
    }
  
    public Long getMedioPago() {
        return medioPago;
    }
  
    public void setMedioPago(Long newMedioPago) {
        medioPago = newMedioPago;
    }
  
    public Integer getNumeroIdentificadorCuota() {
        return numeroIdentificadorCuota;
    }
  
    public void setNumeroIdentificadorCuota(Integer newNumeroIdentificadorCuota) {
        numeroIdentificadorCuota = newNumeroIdentificadorCuota;
    }
  
    public String getNumeroLoteContabilizacion() {
        return numeroLoteContabilizacion;
    }
  
    public void setNumeroLoteContabilizacion(String newNumeroLoteContabilizacion) {
        numeroLoteContabilizacion = newNumeroLoteContabilizacion;
    }
  
    public Integer getNumeroOrdenCuota() {
        return numeroOrdenCuota;
    }
  
    public void setNumeroOrdenCuota(Integer newNumeroOrdenCuota) {
        numeroOrdenCuota = newNumeroOrdenCuota;
    }
  
    public String getNumeroSerieCuota() {
        return numeroSerieCuota;
    }
  
    public void setNumeroSerieCuota(String newNumeroSerieCuota) {
        numeroSerieCuota = newNumeroSerieCuota;
    }
  
    public String getObservaciones() {
        return observaciones;
    }
  
    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }
  
    public Long getOid() {
        return oid;
    }
  
    public void setOid(Long newOid) {
        oid = newOid;
    }
  
    public Long getOidCliente() {
        return oidCliente;
    }
  
    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }
  
    public Long getOidMoneda() {
        return oidMoneda;
    }
  
    public void setOidMoneda(Long newOidMoneda) {
        oidMoneda = newOidMoneda;
    }
  
    public Long getOidPedidoSolicitudCab() {
        return oidPedidoSolicitudCab;
    }
  
    public void setOidPedidoSolicitudCab(Long newOidPedidoSolicitudCab) {
        oidPedidoSolicitudCab = newOidPedidoSolicitudCab;
    }
  
    public Long getOidRegion() {
        return oidRegion;
    }
  
    public void setOidRegion(Long newOidRegion) {
        oidRegion = newOidRegion;
    }
  
    public Long getOidSeccion() {
        return oidSeccion;
    }
  
    public void setOidSeccion(Long newOidSeccion) {
        oidSeccion = newOidSeccion;
    }
  
    public Long getOidSubtipoCliente() {
        return oidSubtipoCliente;
    }
  
    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        oidSubtipoCliente = newOidSubtipoCliente;
    }
  
    public Long getOidSugerenciaVenta() {
        return oidSugerenciaVenta;
    }
  
    public void setOidSugerenciaVenta(Long newOidSugerenciaVenta) {
        oidSugerenciaVenta = newOidSugerenciaVenta;
    }
  
    public Long getOidTipoSolicitud() {
        return oidTipoSolicitud;
    }
  
    public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
        oidTipoSolicitud = newOidTipoSolicitud;
    }
  
    /*public Long getOidZona() {
        return oidZona;
    }
  
    public void setOidZona(Long newOidZona) {
        oidZona = newOidZona;
    }*/
  
    public Long getPeriodoDesde() {
        return periodoDesde;
    }
  
    public void setPeriodoDesde(Long newPeriodoDesde) {
        periodoDesde = newPeriodoDesde;
    }
  
    public String getReferenciaNumeroDocumentoExterno() {
        return referenciaNumeroDocumentoExterno;
    }
  
    public void setReferenciaNumeroDocumentoExterno(String newReferenciaNumeroDocumentoExterno) {
        referenciaNumeroDocumentoExterno = newReferenciaNumeroDocumentoExterno;
    }
  
    public Long getSubacceso() {
        return subacceso;
    }
  
    public void setSubacceso(Long newSubacceso) {
        subacceso = newSubacceso;
    }
  
    public Long getSubprocesoCreacion() {
        return subprocesoCreacion;
    }
  
    public void setSubprocesoCreacion(Long newSubprocesoCreacion) {
        subprocesoCreacion = newSubprocesoCreacion;
    }
  
    public Long getSubprocesoUltimo() {
        return subprocesoUltimo;
    }
  
    public void setSubprocesoUltimo(Long newSubprocesoUltimo) {
        subprocesoUltimo = newSubprocesoUltimo;
    }
  
    public Long getTerritorioAdministrativo() {
        return territorioAdministrativo;
    }
  
    public void setTerritorioAdministrativo(Long newTerritorioAdministrativo) {
        territorioAdministrativo = newTerritorioAdministrativo;
    }
  
    public Long getTipoAbonoCreacion() {
        return tipoAbonoCreacion;
    }
  
    public void setTipoAbonoCreacion(Long newTipoAbonoCreacion) {
        tipoAbonoCreacion = newTipoAbonoCreacion;
    }
  
    public Long getTipoAbonoUltimo() {
        return tipoAbonoUltimo;
    }
  
    public void setTipoAbonoUltimo(Long newTipoAbonoUltimo) {
        tipoAbonoUltimo = newTipoAbonoUltimo;
    }
  
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }
  
    public void setTipoCambio(BigDecimal newTipoCambio) {
        tipoCambio = newTipoCambio;
    }
  
    public Long getTipoCliente() {
        return tipoCliente;
    }
  
    public void setTipoCliente(Long newTipoCliente) {
        tipoCliente = newTipoCliente;
    }
  
    public Long getTipoPeriodoDesde() {
        return tipoPeriodoDesde;
    }
  
    public void setTipoPeriodoDesde(Long newTipoPeriodoDesde) {
        tipoPeriodoDesde = newTipoPeriodoDesde;
    }
  
    public String getUltimoDocumentoAnyo() {
        return ultimoDocumentoAnyo;
    }
  
    public void setUltimoDocumentoAnyo(String newUltimoDocumentoAnyo) {
        ultimoDocumentoAnyo = newUltimoDocumentoAnyo;
    }
  
    public String getUltimoDocumentoMesSerie() {
        return ultimoDocumentoMesSerie;
    }
  
    public void setUltimoDocumentoMesSerie(String newUltimoDocumentoMesSerie) {
        ultimoDocumentoMesSerie = newUltimoDocumentoMesSerie;
    }
  
    public Integer getUltimoDocumentoNumero() {
        return ultimoDocumentoNumero;
    }
  
    public void setUltimoDocumentoNumero(Integer newUltimoDocumentoNumero) {
        ultimoDocumentoNumero = newUltimoDocumentoNumero;
    }
  
    public Integer getUltimoNumeroHistoria() {
        return ultimoNumeroHistoria;
    }
  
    public void setUltimoNumeroHistoria(Integer newUltimoNumeroHistoria) {
        ultimoNumeroHistoria = newUltimoNumeroHistoria;
    }
  
    public String getUsuario() {
        return usuario;
    }
  
    public void setUsuario(String newUsuario) {
        usuario = newUsuario;
    }
  
    /*public String getDcAplicado() {
        return dcAplicado;
    }
  
    public void setDcAplicado(String newDcAplicado) {
        dcAplicado = newDcAplicado;
    }*/
  
    public Integer getNumeroLoteFactu() {
        return numeroLoteFactu;
    }
  
    public void setNumeroLoteFactu(Integer newNumeroLoteFactu) {
        numeroLoteFactu = newNumeroLoteFactu;
    }
  
    public Long getOidTipoDocumentoLegal() {
        return oidTipoDocumentoLegal;
    }
  
    public void setOidTipoDocumentoLegal(Long newOidTipoDocumentoLegal) {
        oidTipoDocumentoLegal = newOidTipoDocumentoLegal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal) {
        oidCanal = newOidCanal;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso) {
        oidAcceso = newOidAcceso;
    }

    public void setMovimientosBancariosCancelados(DTOMovimientoBancario[] movimientosBancariosCancelados)
    {
        this.movimientosBancariosCancelados = movimientosBancariosCancelados;
    }
  
    public DTOMovimientoBancario[] getMovimientosBancariosCancelados()
    {
        return movimientosBancariosCancelados;
    }
    
    public void setOidCargoAbono(Long  oidCargoAbono){
        this.oidCargoAbono = oidCargoAbono;
    }
  
    public Long getOidCargoAbono()    {
        return oidCargoAbono;
    }

  public Long getOidDocumentoReferencia()
  {
    return oidDocumentoReferencia;
  }

  public void setOidDocumentoReferencia(Long oidDocumentoReferencia)
  {
    this.oidDocumentoReferencia = oidDocumentoReferencia;
  }

  public Long getTipoAbonoSubprocesoUltimo() {
    return tipoAbonoSubprocesoUltimo;
  }

  public void setTipoAbonoSubprocesoUltimo(Long tipoAbonoSubprocesoUltimo) {
    this.tipoAbonoSubprocesoUltimo = tipoAbonoSubprocesoUltimo;
  }

  public Long getOidCuotaNueva() {
    return oidCuotaNueva;
  }

  public void setOidCuotaNueva(Long oidCuotaNueva) {
    this.oidCuotaNueva = oidCuotaNueva;
  }

  public Integer getNumeroLineaDetalleCargoAbono() {
    return numeroLineaDetalleCargoAbono;
  }

  public void setNumeroLineaDetalleCargoAbono(Integer numeroLineaDetalleCargoAbono) {
    this.numeroLineaDetalleCargoAbono = numeroLineaDetalleCargoAbono;
  }


  public void setOidCtaCteBria(Long oidCtaCteBria) {
    this.oidCtaCteBria = oidCtaCteBria;
  }


  public Long getOidCtaCteBria() {
    return oidCtaCteBria;
  }


  public void setImporteMovimientoCuenta(Double importeMovimientoCuenta) {
    this.importeMovimientoCuenta = importeMovimientoCuenta;
  }


  public Double getImporteMovimientoCuenta() {
    return importeMovimientoCuenta;
  }


    public void setNumDecimales(Integer numDecimales)
    {
        this.numDecimales = numDecimales;
    }


    public Integer getNumDecimales()
    {
        return numDecimales;
    }

}