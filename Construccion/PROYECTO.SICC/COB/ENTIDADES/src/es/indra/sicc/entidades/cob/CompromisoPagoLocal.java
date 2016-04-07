package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

import java.io.Serializable;

@Entity
@Table(name="COB_COMPR_PAGO")
@NamedQueries({
@NamedQuery(name="CompromisoPagoLocal.FindAll",query="select object(o) from CompromisoPagoLocal o")
})
public class CompromisoPagoLocal implements Serializable {

	public CompromisoPagoLocal() {}

	public CompromisoPagoLocal(Long oid,Long codigoCompromisoPago, Date fechaPago, BigDecimal importePago, Date fechaSeguimientoPrevisto, Long sucursal, Long orden)	{
	
		this.oid=oid;
                this.setCodigoCompromisoPago(codigoCompromisoPago);
	        this.setFechaPago(fechaPago);
	        this.setImportePago(importePago);
	        this.setFechaSeguimientoPrevisto(fechaSeguimientoPrevisto);
	        this.setSucursal(sucursal);
	        this.setOrden(orden);

	
	}

	@Id
	@Column(name="OID_COMP_PAGO")
	private Long oid;
	@Column(name="COD_COMP_PAGO")
	private Long codigoCompromisoPago;
	@Column(name="FEC_PAGO")
	private java.sql.Date fechaPago;
	@Column(name="IMP_PAGO")
	private java.math.BigDecimal importePago;
	@Column(name="FEC_SEGU_PREV")
	private java.sql.Date fechaSeguimientoPrevisto;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="FEC_COMP")
	private java.sql.Date fechaCompromiso;
	@Column(name="SUCU_OID_SUCU")
	private Long sucursal;
	@Column(name="GECO_OID_GEST_COBR")
	private Long orden;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoCompromisoPago() {return codigoCompromisoPago;}
      
	public void setCodigoCompromisoPago(Long codigoCompromisoPago){this.codigoCompromisoPago=codigoCompromisoPago;}
		
	public java.sql.Date getFechaPago() {return fechaPago;}
      
	public void setFechaPago(java.sql.Date fechaPago){this.fechaPago=fechaPago;}
		
	public java.math.BigDecimal getImportePago() {return importePago;}
      
	public void setImportePago(java.math.BigDecimal importePago){this.importePago=importePago;}
		
	public java.sql.Date getFechaSeguimientoPrevisto() {return fechaSeguimientoPrevisto;}
      
	public void setFechaSeguimientoPrevisto(java.sql.Date fechaSeguimientoPrevisto){this.fechaSeguimientoPrevisto=fechaSeguimientoPrevisto;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public java.sql.Date getFechaCompromiso() {return fechaCompromiso;}
      
	public void setFechaCompromiso(java.sql.Date fechaCompromiso){this.fechaCompromiso=fechaCompromiso;}
		
	public Long getSucursal() {return sucursal;}
      
	public void setSucursal(Long sucursal){this.sucursal=sucursal;}
		
	public Long getOrden() {return orden;}
      
	public void setOrden(Long orden){this.orden=orden;}
			
	
}
