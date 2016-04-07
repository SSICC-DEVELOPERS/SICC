package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_MONET")
@NamedQueries({
@NamedQuery(name="PremioMonetarioLocal.FindAll",query="select object(o) from PremioMonetarioLocal o"),
@NamedQuery(name="PremioMonetarioLocal.FindByParametroNivelPremiacion",query="SELECT OBJECT(a) "
+ " FROM PremioMonetarioLocal AS a "
+ " WHERE a.nivelPremiacion = ?1"),
@NamedQuery(name="PremioMonetarioLocal.FindByUK",query="SELECT OBJECT(o) FROM PremioMonetarioLocal o WHERE o.nivelPremiacion = ?1")
})
public class PremioMonetarioLocal implements Serializable {

	public PremioMonetarioLocal() {}

	public PremioMonetarioLocal(Long oid, Integer numPrem, Long moneOidMone, Long panpOidParaNivePrem, Long tpmoOidTipoPremMone, Long fpagOidFormPago)	{
	
		this.oid=oid;
                this.setNumeroPremio(numPrem);
	        this.setMoneda(moneOidMone);
	        this.setNivelPremiacion(panpOidParaNivePrem);
	        this.setTipoPremioMonetario(tpmoOidTipoPremMone);
	        this.setFormaPago(fpagOidFormPago);
	
	}

	@Id
	@Column(name="OID_PREM_MONE")
	private Long oid;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="VAL_CANT")
	private java.math.BigDecimal cantidad;
	@Column(name="VAL_PORC")
	private java.math.BigDecimal porcentaje;
	@Column(name="IND_PAGO_PART")
	private Boolean pagoPartes;
	@Column(name="IND_DESC_PAGO_ANTI")
	private Boolean descontarPagosAnticipados;
	@Column(name="MONE_OID_MONE")
	private Long moneda;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;
	@Column(name="TPMO_OID_TIPO_PREM_MONE")
	private Long tipoPremioMonetario;
	@Column(name="TCUM_OID_TIPO_CUMP")
	private Long cumplimiento;
	@Column(name="FPAG_OID_FORM_PAGO")
	private Long formaPago;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public java.math.BigDecimal getCantidad() {return cantidad;}
      
	public void setCantidad(java.math.BigDecimal cantidad){this.cantidad=cantidad;}
		
	public java.math.BigDecimal getPorcentaje() {return porcentaje;}
      
	public void setPorcentaje(java.math.BigDecimal porcentaje){this.porcentaje=porcentaje;}
		
	public Boolean getPagoPartes() {return pagoPartes;}
      
	public void setPagoPartes(Boolean pagoPartes){this.pagoPartes=pagoPartes;}
		
	public Boolean getDescontarPagosAnticipados() {return descontarPagosAnticipados;}
      
	public void setDescontarPagosAnticipados(Boolean descontarPagosAnticipados){this.descontarPagosAnticipados=descontarPagosAnticipados;}
		
	public Long getMoneda() {return moneda;}
      
	public void setMoneda(Long moneda){this.moneda=moneda;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	public Long getTipoPremioMonetario() {return tipoPremioMonetario;}
      
	public void setTipoPremioMonetario(Long tipoPremioMonetario){this.tipoPremioMonetario=tipoPremioMonetario;}
		
	public Long getCumplimiento() {return cumplimiento;}
      
	public void setCumplimiento(Long cumplimiento){this.cumplimiento=cumplimiento;}
		
	public Long getFormaPago() {return formaPago;}
      
	public void setFormaPago(Long formaPago){this.formaPago=formaPago;}
			
	
}
