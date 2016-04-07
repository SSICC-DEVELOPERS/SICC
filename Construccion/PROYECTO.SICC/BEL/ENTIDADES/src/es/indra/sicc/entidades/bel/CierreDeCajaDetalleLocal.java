package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="BEL_CIERR_CAJA_DETAL")
public class CierreDeCajaDetalleLocal implements Serializable {

	public CierreDeCajaDetalleLocal() {}

	public CierreDeCajaDetalleLocal(Long oid, Long cierreCajaCabecera, Integer numeroLinea)	{
		this.oid=oid;
                this.cierreCajaCabecera = cierreCajaCabecera;
                this.numeroLinea = numeroLinea;
	}
        
	public CierreDeCajaDetalleLocal(Long oid, Long cierreCajaCabecera, Integer numeroLinea, BigDecimal importe, BigDecimal importeDivisa, BigDecimal importeLogico, BigDecimal importeLogicoDivisa, Long medioDePago, Long monedaAlternativa)	{
		this.oid=oid;
                this.cierreCajaCabecera = cierreCajaCabecera;
                this.numeroLinea = numeroLinea;
                this.importe = importe;
                this.importeDivisa = importeDivisa;
                this.importeLogico = importeLogico;
                this.importeLogicoDivisa = importeLogicoDivisa;
                this.medioDePago = medioDePago;
                this.monedaAlternativa = monedaAlternativa;
	}        
    
	@Id
	@Column(name="OID_DETA")
	private Long oid;
	@Column(name="CICC_OID_CABE")
	private Long cierreCajaCabecera;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="IMP_CIER")
        private java.math.BigDecimal importe;
	@Column(name="IMP_DIVI")
	private java.math.BigDecimal importeDivisa;
	@Column(name="IMP_LOGI")
	private java.math.BigDecimal importeLogico;
	@Column(name="IMP_LOGI_DIVI")
	private java.math.BigDecimal importeLogicoDivisa;
	@Column(name="MPBC_OID_MEDI_PAGO_BELC")
	private Long medioDePago;
	@Column(name="MONE_OID_MONE")
	private Long monedaAlternativa;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCierreCajaCabecera() {return cierreCajaCabecera;}
      
	public void setCierreCajaCabecera(Long cierreCajaCabecera){this.cierreCajaCabecera=cierreCajaCabecera;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public java.math.BigDecimal getImporteDivisa() {return importeDivisa;}
      
	public void setImporteDivisa(java.math.BigDecimal importeDivisa){this.importeDivisa=importeDivisa;}
		
	public java.math.BigDecimal getImporteLogico() {return importeLogico;}
      
	public void setImporteLogico(java.math.BigDecimal importeLogico){this.importeLogico=importeLogico;}
		
	public java.math.BigDecimal getImporteLogicoDivisa() {return importeLogicoDivisa;}
      
	public void setImporteLogicoDivisa(java.math.BigDecimal importeLogicoDivisa){this.importeLogicoDivisa=importeLogicoDivisa;}
		
	public Long getMedioDePago() {return medioDePago;}
      
	public void setMedioDePago(Long medioDePago){this.medioDePago=medioDePago;}
		
	public Long getMonedaAlternativa() {return monedaAlternativa;}
      
	public void setMonedaAlternativa(Long monedaAlternativa){this.monedaAlternativa=monedaAlternativa;}
			
	
}
