package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_VENTA_HISTO")
@NamedQueries({
@NamedQuery(name="ComisionesVentaHistoricaLocal.FindAll",query="select object(o) from ComisionesVentaHistoricaLocal o"),
@NamedQuery(name="ComisionesVentaHistoricaLocal.FindByUK",query="select object(c) from ComisionesVentaHistoricaLocal c where c.comision = ?1")
})
public class ComisionesVentaHistoricaLocal implements Serializable {

	public ComisionesVentaHistoricaLocal() {}

	public ComisionesVentaHistoricaLocal(Long oid, Long comision, Long periodoFinal, Long periodoInicial)	{
	
		this.oid=oid;
                this.setComision(comision);
	        this.setPeriodoFinal(periodoFinal);
	        this.setPeriodoInicial(periodoInicial);
	
	}

	@Id
	@Column(name="OID_COMI_VENT_HIST")
	private Long oid;
	@Column(name="VAL_PORC_INCR")
	private java.math.BigDecimal porcentajeIncremento;
	@Column(name="IMP_MONT_INCR")
	private java.math.BigDecimal montoIncremento;
	@Column(name="IND_DEVO")
	private Boolean devoluciones;
	@Column(name="IND_ANUL")
	private Boolean anulaciones;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFinal;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInicial;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getPorcentajeIncremento() {return porcentajeIncremento;}
      
	public void setPorcentajeIncremento(java.math.BigDecimal porcentajeIncremento){this.porcentajeIncremento=porcentajeIncremento;}
		
	public java.math.BigDecimal getMontoIncremento() {return montoIncremento;}
      
	public void setMontoIncremento(java.math.BigDecimal montoIncremento){this.montoIncremento=montoIncremento;}
		
	public Boolean getDevoluciones() {return devoluciones;}
      
	public void setDevoluciones(Boolean devoluciones){this.devoluciones=devoluciones;}
		
	public Boolean getAnulaciones() {return anulaciones;}
      
	public void setAnulaciones(Boolean anulaciones){this.anulaciones=anulaciones;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getPeriodoFinal() {return periodoFinal;}
      
	public void setPeriodoFinal(Long periodoFinal){this.periodoFinal=periodoFinal;}
		
	public Long getPeriodoInicial() {return periodoInicial;}
      
	public void setPeriodoInicial(Long periodoInicial){this.periodoInicial=periodoInicial;}
			
	
}
