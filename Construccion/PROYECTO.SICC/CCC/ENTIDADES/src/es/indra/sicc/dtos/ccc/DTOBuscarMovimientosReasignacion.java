package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOBuscarMovimientosReasignacion extends DTOSiccPaginacion {
    public DTOBuscarMovimientosReasignacion() {
    }
    
    private Long oidBanco;
    private Long oidCuentaCorrienteBancaria;
    private java.sql.Date fechaPago;
    private Long numeroLote;
    private Long numeroConsecutivoTransaccion;
    private Long oidRegion;
    private Long oidZona;
    private Long oidCliente;
    private Long numeroCupon;
    private Long numeroBolFact; //numero de boleta o factura
    private BigDecimal importePagoDesde;
    private BigDecimal importePagoHasta;
    private String codigoCliente;
    private Long oidMovimientoBancario;


    public void setOidBanco(Long oidBanco) {
        this.oidBanco = oidBanco;
    }


    public Long getOidBanco() {
        return oidBanco;
    }


    public void setOidCuentaCorrienteBancaria(Long oidCuentaCorrienteBancaria) {
        this.oidCuentaCorrienteBancaria = oidCuentaCorrienteBancaria;
    }


    public Long getOidCuentaCorrienteBancaria() {
        return oidCuentaCorrienteBancaria;
    }


    public void setFechaPago(java.sql.Date fechaPago) {
        this.fechaPago = fechaPago;
    }


    public java.sql.Date getFechaPago() {
        return fechaPago;
    }


    public void setNumeroLote(Long numeroLote) {
        this.numeroLote = numeroLote;
    }


    public Long getNumeroLote() {
        return numeroLote;
    }


    public void setNumeroConsecutivoTransaccion(Long numeroConsecutivoTransaccion) {
        this.numeroConsecutivoTransaccion = numeroConsecutivoTransaccion;
    }


    public Long getNumeroConsecutivoTransaccion() {
        return numeroConsecutivoTransaccion;
    }


    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }


    public Long getOidRegion() {
        return oidRegion;
    }


    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }


    public Long getOidZona() {
        return oidZona;
    }


    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }


    public Long getOidCliente() {
        return oidCliente;
    }


    public void setNumeroCupon(Long numeroCupon) {
        this.numeroCupon = numeroCupon;
    }


    public Long getNumeroCupon() {
        return numeroCupon;
    }


    public void setNumeroBolFact(Long numeroBolFact) {
        this.numeroBolFact = numeroBolFact;
    }


    public Long getNumeroBolFact() {
        return numeroBolFact;
    }


    public void setImportePagoDesde(BigDecimal importePagoDesde) {
        this.importePagoDesde = importePagoDesde;
    }


    public BigDecimal getImportePagoDesde() {
        return importePagoDesde;
    }


    public void setImportePagoHasta(BigDecimal importePagoHasta) {
        this.importePagoHasta = importePagoHasta;
    }


    public BigDecimal getImportePagoHasta() {
        return importePagoHasta;
    }


    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }


    public String getCodigoCliente() {
        return codigoCliente;
    }


  public void setOidMovimientoBancario(Long oidMovimientoBancario)
  {
    this.oidMovimientoBancario = oidMovimientoBancario;
  }


  public Long getOidMovimientoBancario()
  {
    return oidMovimientoBancario;
  }
    
}