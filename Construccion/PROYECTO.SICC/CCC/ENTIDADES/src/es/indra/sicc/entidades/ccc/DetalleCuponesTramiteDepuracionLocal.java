package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

@Entity
@Table(name="CCC_DETAL_CUPON_TRAMI_DEPUR")
public class DetalleCuponesTramiteDepuracionLocal implements Serializable {

	public DetalleCuponesTramiteDepuracionLocal() {}

	public DetalleCuponesTramiteDepuracionLocal(Long oid, Long cliente, Long movimientoCC, 
                                                            Long movimientoBanc, BigDecimal importe, 
                                                            Long cc, Date fechaDigitacion, 
                                                            Long cabeceraCuponesTramiteDepuracion, 
                                                            Long empresa)	{
	
		this.oid=oid;
                this.cliente=cliente;
                this.movimientoCC=movimientoCC;
                this.movimientoBanc=movimientoBanc;
                this.importe=importe;
                this.cc=cc;
                this.fechaDigitacion=fechaDigitacion;
                this.cabeceraCuponesTramiteDepuracion=cabeceraCuponesTramiteDepuracion;
                this.empresa=empresa;                
	
	}

        public DetalleCuponesTramiteDepuracionLocal(Long oid, Long cliente, Long movimientoCC, 
                                                    Long movimientoBanc, BigDecimal importe, 
                                                    Long cc, Date fechaDigitacion, 
                                                    Long cabeceraCuponesTramiteDepuracion, 
                                                    Long empresa, Long periodo, 
                                                    Integer numeroLinea, Date fechaDocumento, 
                                                    String referenciaExterna, String observaciones, 
                                                    Long situacion, Integer numeroCupon, 
                                                    Date fechaMovimientoBancario, 
                                                    Long banco)       {
        
                this.oid=oid;
                this.cliente=cliente;
                this.movimientoCC=movimientoCC;
                this.movimientoBanc=movimientoBanc;
                this.importe=importe;
                this.cc=cc;
                this.fechaDigitacion=fechaDigitacion;
                this.cabeceraCuponesTramiteDepuracion=cabeceraCuponesTramiteDepuracion;
                this.empresa=empresa;
                this.periodo=periodo;
                this.numeroLinea=numeroLinea;
                this.fechaDocumento=fechaDocumento;
                this.referenciaExterna=referenciaExterna;
                this.observaciones=observaciones;
                this.situacion=situacion;
                this.numeroCupon=numeroCupon;
                this.fechaMovimientoBancario=fechaMovimientoBancario;
                this.banco=banco;                
        
        }        

	@Id
	@Column(name="OID_DETA_CUPO_TRAM_DEPU")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimientoCC;
	@Column(name="CMBA_OID_MOVI_BANC")
	private Long movimientoBanc;
	@Column(name="IMP_DETA")
	private java.math.BigDecimal importe;
	@Column(name="CCBA_OID_CC_BANC")
	private Long cc;
	@Column(name="FEC_DIGI")        
	private java.sql.Date fechaDigitacion;
	@Column(name="PERI_OID_PERI")
	private Long periodo;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="REF_EXTE")
	private String referenciaExterna;
	@Column(name="OBS_DETA_CUPO")
	private String observaciones;
	@Column(name="SICU_OID_SITU_CUPO")
	private Long situacion;
	@Column(name="NUM_CUPO")
	private Integer numeroCupon;
	@Column(name="FEC_MOVI_BANC")        
	private java.sql.Date fechaMovimientoBancario;
	@Column(name="CTDE_OID_CUPO_TRAM_DEPU")
	private Long cabeceraCuponesTramiteDepuracion;
	@Column(name="CBAN_OID_BANC")
	private Long banco;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getMovimientoCC() {return movimientoCC;}
      
	public void setMovimientoCC(Long movimientoCC){this.movimientoCC=movimientoCC;}
		
	public Long getMovimientoBanc() {return movimientoBanc;}
      
	public void setMovimientoBanc(Long movimientoBanc){this.movimientoBanc=movimientoBanc;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public Long getCc() {return cc;}
      
	public void setCc(Long cc){this.cc=cc;}
		
	public java.sql.Date getFechaDigitacion() {return fechaDigitacion;}
      
	public void setFechaDigitacion(java.sql.Date fechaDigitacion){this.fechaDigitacion=fechaDigitacion;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public String getReferenciaExterna() {return referenciaExterna;}
      
	public void setReferenciaExterna(String referenciaExterna){this.referenciaExterna=referenciaExterna;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getSituacion() {return situacion;}
      
	public void setSituacion(Long situacion){this.situacion=situacion;}
		
	public Integer getNumeroCupon() {return numeroCupon;}
      
	public void setNumeroCupon(Integer numeroCupon){this.numeroCupon=numeroCupon;}
		
	public java.sql.Date getFechaMovimientoBancario() {return fechaMovimientoBancario;}
      
	public void setFechaMovimientoBancario(java.sql.Date fechaMovimientoBancario){this.fechaMovimientoBancario=fechaMovimientoBancario;}
		
	public Long getCabeceraCuponesTramiteDepuracion() {return cabeceraCuponesTramiteDepuracion;}
      
	public void setCabeceraCuponesTramiteDepuracion(Long cabeceraCuponesTramiteDepuracion){this.cabeceraCuponesTramiteDepuracion=cabeceraCuponesTramiteDepuracion;}
		
	public Long getBanco() {return banco;}
      
	public void setBanco(Long banco){this.banco=banco;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
			
	
}
