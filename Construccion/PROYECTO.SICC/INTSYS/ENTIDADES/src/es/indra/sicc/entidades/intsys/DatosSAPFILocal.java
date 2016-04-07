package es.indra.sicc.entidades.intsys;

import es.indra.mare.common.exception.MareException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_DATOS_SAPFI")
@NamedQueries({
@NamedQuery(name="DatosSAPFILocal.FindAll",query="select object(o) from DatosSAPFILocal o")
})
public class DatosSAPFILocal implements Serializable {

	public DatosSAPFILocal() {}

	public DatosSAPFILocal(Long oid, String indicadorFacturaCCC, String numeroLote, Date fechaContable, String tipoAsiento, Long tipoMovimientoSAPFI, String glosa, String indicadorDebeHaber, BigDecimal importe, String periodoContable, Short ejercicioContable, Long subacceso, Long moneda, Long sociedad) {
            this.oid=oid;
	    this.indicadorFacturaCCC=indicadorFacturaCCC;
	    this.numeroLote=numeroLote;
	    this.fechaContable=fechaContable;
	    this.tipoAsiento=tipoAsiento;
	    this.tipoMovimientoSAPFI=tipoMovimientoSAPFI;
	    this.glosa=glosa;
	    this.indicadorDebeHaber=indicadorDebeHaber;
	    this.importe=importe;
	    this.periodoContable=periodoContable;
	    this.ejercicioContable=ejercicioContable;
	    this.indicadorDebeHaber=indicadorDebeHaber;
	    this.subacceso=subacceso;
            this.moneda=moneda;
	    this.sociedad=sociedad;
	}

	@Id
	@Column(name="OID_DATO_SAP")
	private Long oid;
	@Column(name="IND_FACT_CCC")
	private String indicadorFacturaCCC;
	@Column(name="NUM_LOTE")
	private String numeroLote;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_CONT")
	private java.util.Date fechaContable;
	@Column(name="VAL_EJER_COME")
	private Short ejercicioComercial;
	@Column(name="VAL_TIPO_ASIE")
	private String tipoAsiento;
	@Column(name="CUCO_OID_CUEN_CONT")
	private Long tipoMovimientoSAPFI;
	@Column(name="NUM_DOCU_RUC")
	private String numeroDocumentoRUC;
	@Column(name="VAL_GLOS")
	private String glosa;
	@Column(name="INDI_DEBE_HABE")
	private String indicadorDebeHaber;
	@Column(name="IND_GRUP_ARTI")
	private String grupoArticulos;
	@Column(name="IMP_DATO_SAP")
	private BigDecimal importe;
	@Column(name="VAL_PERI_CONT")
	private String periodoContable;
	@Column(name="VAL_EJER_CONT")
	private Short ejercicioContable;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_DOCU")
	private Date fechaDocumento;
        @Temporal(TemporalType.DATE)
	@Column(name="FEC_PAGO_BANC")
        private Date fechaPagoBanco;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_VALO_BANC")
	private Date fechaValorBanco;
	@Column(name="NUM_COMP")
	private String numeroComprobante;
	@Column(name="VAL_RECA_SUCU")
	private String recaudadoraSucursal;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="MONE_OID_MONE")
	private Long moneda;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="IPCF_OID_PARA_CONT_FACT")
	private Long codigoApunte;
	@Column(name="PERI_OID_PERI")
	private Long periodoComercial;
	@Column(name="CCBA_OID_CUEN_CORR_BANC")
	private Long codigoBancoSICC;
	@Column(name="IMCF_OID_IMPO_CONT_FACT")
	private Long importeAContabilizar;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getIndicadorFacturaCCC() {return indicadorFacturaCCC;}
      
	public void setIndicadorFacturaCCC(String indicadorFacturaCCC){this.indicadorFacturaCCC=indicadorFacturaCCC;}
		
	public String getNumeroLote() {return numeroLote;}
      
	public void setNumeroLote(String numeroLote){this.numeroLote=numeroLote;}
		
	public java.util.Date getFechaContable() {return fechaContable;}
      
	public void setFechaContable(java.util.Date fechaContable){this.fechaContable=fechaContable;}
		
	public Short getEjercicioComercial() {return ejercicioComercial;}
      
	public void setEjercicioComercial(Short ejercicioComercial){this.ejercicioComercial=ejercicioComercial;}
		
	public String getTipoAsiento() {return tipoAsiento;}
      
	public void setTipoAsiento(String tipoAsiento){this.tipoAsiento=tipoAsiento;}
		
	public Long getTipoMovimientoSAPFI() {return tipoMovimientoSAPFI;}
      
	public void setTipoMovimientoSAPFI(Long tipoMovimientoSAPFI){this.tipoMovimientoSAPFI=tipoMovimientoSAPFI;}
		
	public String getNumeroDocumentoRUC() {return numeroDocumentoRUC;}
      
	public void setNumeroDocumentoRUC(String numeroDocumentoRUC){this.numeroDocumentoRUC=numeroDocumentoRUC;}
		
	public String getGlosa() {return glosa;}
      
	public void setGlosa(String glosa){this.glosa=glosa;}
		
	public String getIndicadorDebeHaber() {return indicadorDebeHaber;}
      
	public void setIndicadorDebeHaber(String indicadorDebeHaber){this.indicadorDebeHaber=indicadorDebeHaber;}
		
	public String getGrupoArticulos() {return grupoArticulos;}
      
	public void setGrupoArticulos(String grupoArticulos){this.grupoArticulos=grupoArticulos;}
		
	public BigDecimal getImporte() {return importe;}
      
	public void setImporte(BigDecimal importe){this.importe=importe;}
		
	public String getPeriodoContable() {return periodoContable;}
      
	public void setPeriodoContable(String periodoContable){this.periodoContable=periodoContable;}
		
	public Short getEjercicioContable() {return ejercicioContable;}
      
	public void setEjercicioContable(Short ejercicioContable){this.ejercicioContable=ejercicioContable;}
		
	public Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Date getFechaPagoBanco() {return fechaPagoBanco;}
      
	public void setFechaPagoBanco(Date fechaPagoBanco){this.fechaPagoBanco=fechaPagoBanco;}
		
	public Date getFechaValorBanco() {return fechaValorBanco;}
      
	public void setFechaValorBanco(Date fechaValorBanco){this.fechaValorBanco=fechaValorBanco;}
		
	public String getNumeroComprobante() {return numeroComprobante;}
      
	public void setNumeroComprobante(String numeroComprobante){this.numeroComprobante=numeroComprobante;}
		
	public String getRecaudadoraSucursal() {return recaudadoraSucursal;}
      
	public void setRecaudadoraSucursal(String recaudadoraSucursal){this.recaudadoraSucursal=recaudadoraSucursal;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getMoneda() {return moneda;}
      
	public void setMoneda(Long moneda){this.moneda=moneda;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getCodigoApunte() {return codigoApunte;}
      
	public void setCodigoApunte(Long codigoApunte){this.codigoApunte=codigoApunte;}
		
	public Long getPeriodoComercial() {return periodoComercial;}
      
	public void setPeriodoComercial(Long periodoComercial){this.periodoComercial=periodoComercial;}
		
	public Long getCodigoBancoSICC() {return codigoBancoSICC;}
      
	public void setCodigoBancoSICC(Long codigoBancoSICC){this.codigoBancoSICC=codigoBancoSICC;}
		
	public Long getImporteAContabilizar() {return importeAContabilizar;}
      
	public void setImporteAContabilizar(Long importeAContabilizar){this.importeAContabilizar=importeAContabilizar;}
			
	
}
