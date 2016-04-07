package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

@Entity
@Table(name="CCC_CABEC_DTO_RECAR_FINAN")
public class CabeceraDtoRecargLocal implements Serializable {

	public CabeceraDtoRecargLocal() {}

	public CabeceraDtoRecargLocal(Long oid, Integer diasCadencia, Integer diasCorte,
                                BigDecimal tipoInteres, Integer numero, String anio, 
                                String periodoMes, Date fechaDocumento, String situacion,
                                Long pais, Long empresa, Long subProceso, Long tipoAbono) {
	
		this.oid=oid;
                setDiasCadencia(diasCadencia);
                setDiasCorte(diasCorte);
                setTipoInteres(tipoInteres);
                setNumero(numero);
                setAnio(anio);
                setPeriodoMes(periodoMes);
                setFechaDocumento(fechaDocumento);
                setSituacion(situacion);
                setPais(pais);
                setEmpresa(empresa);
                setSubProceso(subProceso);
                setTipoAbono(tipoAbono);                
	
	}
        
        public CabeceraDtoRecargLocal(Long oid, Long producto, Long cc, Integer diasCadencia,
                                Integer diasCorte, BigDecimal tipoInteres, Integer numero, 
                                String anio, String periodoMes, Date fechaDocumento, String situacion, 
                                Long pais, Long empresa, Long subProceso, Long tipoAbono, Long marca) {
        
                this.oid=oid;
                setProducto(producto);
                setCc(cc);
                setDiasCadencia(diasCadencia);
                setDiasCorte(diasCorte);
                setTipoInteres(tipoInteres);
                setNumero(numero);
                setAnio(anio);
                setPeriodoMes(periodoMes);
                setFechaDocumento(fechaDocumento);
                setSituacion(situacion);                
                setPais(pais);
                setEmpresa(empresa);
                setSubProceso(subProceso);
                setTipoAbono(tipoAbono);
                setMarca(marca);        
        }        

	@Id
	@Column(name="OID_CABE_DTO_RECA_FINA")
	private Long oid;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="CCBA_CUEN_CORR_BANC")
	private Long cc;
	@Column(name="NUM_DIAS_CADE")
	private Integer diasCadencia;
	@Column(name="NUM_DIAS_CORT")
	private Integer diasCorte;
	@Column(name="VAL_TIPO_INTE")
	private java.math.BigDecimal tipoInteres;
	@Column(name="NUM_CABE")
	private Integer numero;
	@Column(name="VAL_ANIO")
	private String anio;
	@Column(name="VAL_PERI_MES")
	private String periodoMes;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="VAL_REFE_EXTE")
	private String referenciaExterna;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="FEC_DOCU_DESD")        
	private java.sql.Date fechaDocumentoDesde;
	@Column(name="FEC_DOCU_HAST")        
	private java.sql.Date fechaDocumentoHasta;
	@Column(name="FEC_VENC_DESD")        
	private java.sql.Date fechaVtoDesde;
	@Column(name="FEC_VENC_HAST")        
	private java.sql.Date fechaVtoHasta;
	@Column(name="VAL_SITU")
	private String situacion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="IMP_DESC_RECA")
	private java.math.BigDecimal importeDescuentoRecargo;
	@Column(name="CLIE_OID_CLIE")
	private Long clienteDesde;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="SBAC_OID_SBAC")
	private Long subAcceso;
	@Column(name="SUBP_OID_SUBP")
	private Long subProceso;
	@Column(name="CLIE_OID_CLIE_CARGA_HASTA")
	private Long clienteHasta;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoAbono;
	@Column(name="MARC_OID_MARC")
	private Long marca;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getCc() {return cc;}
      
	public void setCc(Long cc){this.cc=cc;}
		
	public Integer getDiasCadencia() {return diasCadencia;}
      
	public void setDiasCadencia(Integer diasCadencia){this.diasCadencia=diasCadencia;}
		
	public Integer getDiasCorte() {return diasCorte;}
      
	public void setDiasCorte(Integer diasCorte){this.diasCorte=diasCorte;}
		
	public java.math.BigDecimal getTipoInteres() {return tipoInteres;}
      
	public void setTipoInteres(java.math.BigDecimal tipoInteres){this.tipoInteres=tipoInteres;}
		
	public Integer getNumero() {return numero;}
      
	public void setNumero(Integer numero){this.numero=numero;}
		
	public String getAnio() {return anio;}
      
	public void setAnio(String anio){this.anio=anio;}
		
	public String getPeriodoMes() {return periodoMes;}
      
	public void setPeriodoMes(String periodoMes){this.periodoMes=periodoMes;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public String getReferenciaExterna() {return referenciaExterna;}
      
	public void setReferenciaExterna(String referenciaExterna){this.referenciaExterna=referenciaExterna;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public java.sql.Date getFechaDocumentoDesde() {return fechaDocumentoDesde;}
      
	public void setFechaDocumentoDesde(java.sql.Date fechaDocumentoDesde){this.fechaDocumentoDesde=fechaDocumentoDesde;}
		
	public java.sql.Date getFechaDocumentoHasta() {return fechaDocumentoHasta;}
      
	public void setFechaDocumentoHasta(java.sql.Date fechaDocumentoHasta){this.fechaDocumentoHasta=fechaDocumentoHasta;}
		
	public java.sql.Date getFechaVtoDesde() {return fechaVtoDesde;}
      
	public void setFechaVtoDesde(java.sql.Date fechaVtoDesde){this.fechaVtoDesde=fechaVtoDesde;}
		
	public java.sql.Date getFechaVtoHasta() {return fechaVtoHasta;}
      
	public void setFechaVtoHasta(java.sql.Date fechaVtoHasta){this.fechaVtoHasta=fechaVtoHasta;}
		
	public String getSituacion() {return situacion;}
      
	public void setSituacion(String situacion){this.situacion=situacion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public java.math.BigDecimal getImporteDescuentoRecargo() {return importeDescuentoRecargo;}
      
	public void setImporteDescuentoRecargo(java.math.BigDecimal importeDescuentoRecargo){this.importeDescuentoRecargo=importeDescuentoRecargo;}
		
	public Long getClienteDesde() {return clienteDesde;}
      
	public void setClienteDesde(Long clienteDesde){this.clienteDesde=clienteDesde;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getSubAcceso() {return subAcceso;}
      
	public void setSubAcceso(Long subAcceso){this.subAcceso=subAcceso;}
		
	public Long getSubProceso() {return subProceso;}
      
	public void setSubProceso(Long subProceso){this.subProceso=subProceso;}
		
	public Long getClienteHasta() {return clienteHasta;}
      
	public void setClienteHasta(Long clienteHasta){this.clienteHasta=clienteHasta;}
		
	public Long getTipoAbono() {return tipoAbono;}
      
	public void setTipoAbono(Long tipoAbono){this.tipoAbono=tipoAbono;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
			
	
}
