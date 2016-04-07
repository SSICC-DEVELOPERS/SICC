package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="CCC_HISTO_MOVIM_CC")
@NamedQueries({
@NamedQuery(name="HistoricoMovimientosCCLocal.FindByUK",query="select Object (o) from HistoricoMovimientosCCLocal o where o.movimiento = ?1 and o.numeroHistoria = ?2")
})
public class HistoricoMovimientosCCLocal implements Serializable {

	public HistoricoMovimientosCCLocal() {}

	public HistoricoMovimientosCCLocal(Long oid, Long subproceso, Long tipoAbono,
                                Integer numeroHistoria, Timestamp fechaMovimiento, 
                                Date fechaVencimiento, Double importe, Double importePagado,
                                Long cuentaContable, Long tipoCliente, Long marcaSituacion, 
                                Long moneda, Long consultora, Double importePendiente, 
                                Long movimiento, Date fechaDocumento)	{
	
		this.oid=oid;
                this.subproceso=subproceso;
                this.tipoAbono=tipoAbono;
                this.numeroHistoria=numeroHistoria;
                this.fechaMovimiento=fechaMovimiento;
                this.fechaVencimiento=fechaVencimiento;
                this.importe=importe;
                this.importePagado=importePagado;
                this.cuentaContable=cuentaContable;
                this.tipoCliente=tipoCliente;
                this.marcaSituacion=marcaSituacion;
                this.divisa=moneda;
                this.consultora=consultora;
                this.importePendiente=importePendiente; // BELC300004457
                this.movimiento=movimiento; // BELC300007640
                this.fechaDocumento=fechaDocumento; //BELC300009345                
	
	}

         public HistoricoMovimientosCCLocal(Long oid, Long subproceso, Long tipoAbono, 
                        Integer numeroHistoria, String refNumDocExt, Timestamp fechaMovimiento, 
                        Date fechaVencimiento, Date fechaValor, Double importe, Double importePagado,
                        Double impPendiente, Double impDivisa, Double impPagDiv, String ultDocMesSerie,
                        String ultDocAnyo, Integer ultDocNum, String numLoteContab, Date fechaContab, 
                        String observs, Long cuentaContable, Long tipoCliente, Long marcaSituacion, 
                        Long moneda, Long medioPagoTeorico, Long consultora, BigDecimal tipoCambio, 
                        String usuario, BigDecimal importePago, BigDecimal importeMovimiento, 
                        BigDecimal importeMovimientoDivisa, Long movimiento, Date fechaDocumento, 
                        Boolean indicaDescuentoRecargo)   {
                
                this.oid=oid;
                this.subproceso=subproceso;
                this.tipoAbono=tipoAbono;
                this.numeroHistoria=numeroHistoria;
                this.fechaMovimiento=fechaMovimiento;
                this.fechaVencimiento=fechaVencimiento;
                this.importe=importe;
                this.importePagado=importePagado;
                this.cuentaContable=cuentaContable;
                this.tipoCliente=tipoCliente;
                this.marcaSituacion=marcaSituacion;
                this.divisa=moneda;                                                
                this.refNumDocExt=refNumDocExt;                  
                this.fechaValor=fechaValor; //modificado a Date, es fecha solo en BD                                
                this.importePendiente=impPendiente;
                this.importeDivisa=impDivisa;
                this.importePagadoDivisa=impPagDiv;
                this.ultimoDocumentoMesSerie=ultDocMesSerie;
                this.ultimoDocumentoAnyo=ultDocAnyo;
                this.ultimoDocumentoNumero=ultDocNum;
                this.numeroLoteContabilizacion=numLoteContab;
                this.fechaContabilizacion=fechaContab;
                this.observaciones=observs;                
                this.medioPagoTeorico=medioPagoTeorico;
                this.consultora=consultora;
                this.tipoCambio=tipoCambio;// BELC300007640
                this.usuario=usuario; // BELC300007640
                this.importePago=importePago;// BELC300007640
                this.importeMovimiento=importeMovimiento;// BELC300007640
                this.importeMovimientoDivisa=importeMovimientoDivisa;// BELC300007640
                this.movimiento=movimiento;// BELC300007640
                this.fechaDocumento=fechaDocumento;              
                this.indicaDescuentoRecargo=indicaDescuentoRecargo;                       
                
         }

	@Id
	@Column(name="OID_HIST_MOVI")
	private Long oid;
	@Column(name="SUBP_OID_SUBP")
	private Long subproceso;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoAbono;
	@Column(name="NUM_HIST")
	private Integer numeroHistoria;
	@Column(name="VAL_REFE_NUME_DOCU_EXTE")
	private String refNumDocExt;
	@Column(name="FEC_MOVI")
	private java.sql.Timestamp fechaMovimiento;
	@Column(name="FEC_VENC")        
	private java.sql.Date fechaVencimiento;
	@Column(name="FEC_VALO")        
	private java.sql.Date fechaValor;
	@Column(name="IMP")
	private Double importe;
	@Column(name="IMP_PAGA")
	private Double importePagado;
	@Column(name="IMP_PEN")
	private Double importePendiente;
	@Column(name="IMP_DIVI")
	private Double importeDivisa;
	@Column(name="IMP_PAGA_DIVI")
	private Double importePagadoDivisa;
	@Column(name="VAL_ULTI_DOCU_MES_SERI")
	private String ultimoDocumentoMesSerie;
	@Column(name="VAL_ULTI_DOCU_ANIO")
	private String ultimoDocumentoAnyo;
	@Column(name="VAL_ULTI_DOCU_NUME")
	private Integer ultimoDocumentoNumero;
	@Column(name="VAL_NUME_LOTE_CONT")
	private String numeroLoteContabilizacion;
	@Column(name="FEC_CONT")        
	private java.sql.Date fechaContabilizacion;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="CUCO_OID_CUEN_CONT")
	private Long cuentaContable;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="MASI_OID_MARC_SITU")
	private Long marcaSituacion;
	@Column(name="MONE_OID_MONE")
	private Long divisa;
	@Column(name="MPAB_OID_MEDI_PAGO_TEOR")
	private Long medioPagoTeorico;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimiento;
	@Column(name="IMP_MOVI_DIVI")
	private java.math.BigDecimal importeMovimientoDivisa;
	@Column(name="IMP_MOVI")
	private java.math.BigDecimal importeMovimiento;
	@Column(name="IMP_PAGO")
	private java.math.BigDecimal importePago;
	@Column(name="VAL_TIPO_CAMB")
	private BigDecimal tipoCambio;
	@Column(name="COD_USUA")
	private String usuario;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="IND_DESC_CARG_APLI")
	private Boolean indicaDescuentoRecargo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubproceso() {return subproceso;}
      
	public void setSubproceso(Long subproceso){this.subproceso=subproceso;}
		
	public Long getTipoAbono() {return tipoAbono;}
      
	public void setTipoAbono(Long tipoAbono){this.tipoAbono=tipoAbono;}
		
	public Integer getNumeroHistoria() {return numeroHistoria;}
      
	public void setNumeroHistoria(Integer numeroHistoria){this.numeroHistoria=numeroHistoria;}
		
	public String getRefNumDocExt() {return refNumDocExt;}
      
	public void setRefNumDocExt(String refNumDocExt){this.refNumDocExt=refNumDocExt;}
		
	public java.sql.Timestamp getFechaMovimiento() {return fechaMovimiento;}
      
	public void setFechaMovimiento(java.sql.Timestamp fechaMovimiento){this.fechaMovimiento=fechaMovimiento;}
		
	public java.sql.Date getFechaVencimiento() {return fechaVencimiento;}
      
	public void setFechaVencimiento(java.sql.Date fechaVencimiento){this.fechaVencimiento=fechaVencimiento;}
		
	public java.sql.Date getFechaValor() {return fechaValor;}
      
	public void setFechaValor(java.sql.Date fechaValor){this.fechaValor=fechaValor;}
		
	public Double getImporte() {return importe;}
      
	public void setImporte(Double importe){this.importe=importe;}
		
	public Double getImportePagado() {return importePagado;}
      
	public void setImportePagado(Double importePagado){this.importePagado=importePagado;}
		
	public Double getImportePendiente() {return importePendiente;}
      
	public void setImportePendiente(Double importePendiente){this.importePendiente=importePendiente;}
		
	public Double getImporteDivisa() {return importeDivisa;}
      
	public void setImporteDivisa(Double importeDivisa){this.importeDivisa=importeDivisa;}
		
	public Double getImportePagadoDivisa() {return importePagadoDivisa;}
      
	public void setImportePagadoDivisa(Double importePagadoDivisa){this.importePagadoDivisa=importePagadoDivisa;}
		
	public String getUltimoDocumentoMesSerie() {return ultimoDocumentoMesSerie;}
      
	public void setUltimoDocumentoMesSerie(String ultimoDocumentoMesSerie){this.ultimoDocumentoMesSerie=ultimoDocumentoMesSerie;}
		
	public String getUltimoDocumentoAnyo() {return ultimoDocumentoAnyo;}
      
	public void setUltimoDocumentoAnyo(String ultimoDocumentoAnyo){this.ultimoDocumentoAnyo=ultimoDocumentoAnyo;}
		
	public Integer getUltimoDocumentoNumero() {return ultimoDocumentoNumero;}
      
	public void setUltimoDocumentoNumero(Integer ultimoDocumentoNumero){this.ultimoDocumentoNumero=ultimoDocumentoNumero;}
		
	public String getNumeroLoteContabilizacion() {return numeroLoteContabilizacion;}
      
	public void setNumeroLoteContabilizacion(String numeroLoteContabilizacion){this.numeroLoteContabilizacion=numeroLoteContabilizacion;}
		
	public java.sql.Date getFechaContabilizacion() {return fechaContabilizacion;}
      
	public void setFechaContabilizacion(java.sql.Date fechaContabilizacion){this.fechaContabilizacion=fechaContabilizacion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getCuentaContable() {return cuentaContable;}
      
	public void setCuentaContable(Long cuentaContable){this.cuentaContable=cuentaContable;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getMarcaSituacion() {return marcaSituacion;}
      
	public void setMarcaSituacion(Long marcaSituacion){this.marcaSituacion=marcaSituacion;}
		
	public Long getDivisa() {return divisa;}
      
	public void setDivisa(Long divisa){this.divisa=divisa;}
		
	public Long getMedioPagoTeorico() {return medioPagoTeorico;}
      
	public void setMedioPagoTeorico(Long medioPagoTeorico){this.medioPagoTeorico=medioPagoTeorico;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
		
	public Long getMovimiento() {return movimiento;}
      
	public void setMovimiento(Long movimiento){this.movimiento=movimiento;}
		
	public java.math.BigDecimal getImporteMovimientoDivisa() {return importeMovimientoDivisa;}
      
	public void setImporteMovimientoDivisa(java.math.BigDecimal importeMovimientoDivisa){this.importeMovimientoDivisa=importeMovimientoDivisa;}
		
	public java.math.BigDecimal getImporteMovimiento() {return importeMovimiento;}
      
	public void setImporteMovimiento(java.math.BigDecimal importeMovimiento){this.importeMovimiento=importeMovimiento;}
		
	public java.math.BigDecimal getImportePago() {return importePago;}
      
	public void setImportePago(java.math.BigDecimal importePago){this.importePago=importePago;}
		
	public BigDecimal getTipoCambio() {return tipoCambio;}
      
	public void setTipoCambio(BigDecimal tipoCambio){this.tipoCambio=tipoCambio;}
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Boolean getIndicaDescuentoRecargo() {return indicaDescuentoRecargo;}
      
	public void setIndicaDescuentoRecargo(Boolean indicaDescuentoRecargo){this.indicaDescuentoRecargo=indicaDescuentoRecargo;}
			
	
}
