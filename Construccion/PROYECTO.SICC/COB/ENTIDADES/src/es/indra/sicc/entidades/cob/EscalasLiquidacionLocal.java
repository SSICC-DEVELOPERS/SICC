package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="COB_ESCAL_LIQUI")
@NamedQueries({
@NamedQuery(name="EscalasLiquidacionLocal.FindAll",query="select object(o) from EscalasLiquidacionLocal o")
})
public class EscalasLiquidacionLocal implements Serializable {

	public EscalasLiquidacionLocal() {}

	public EscalasLiquidacionLocal(Long oid, Integer ordenEscala, BigDecimal comisionPorcentaje, BigDecimal comision, Long metodoLiquidacion)	{
	
		this.oid=oid;
                this.setOrdenEscala(ordenEscala);
	        this.setComisionPorcentaje(comisionPorcentaje);
	        this.setComision(comision);
	        this.setMetodoLiquidacion(metodoLiquidacion);
	
	}

	@Id
	@Column(name="OID_ESCA_LIQU_COBR")
	private Long oid;
	@Column(name="NUM_ORDE_ESCA")
	private Integer ordenEscala;
	@Column(name="IMP_RANG_DESD_IMPO")
	private java.math.BigDecimal rangoDesde;
	@Column(name="IMP_RANG_HAST_IMPO")
	private java.math.BigDecimal rangoHasta;
	@Column(name="VAL_RANG_DESD_PORC")
	private java.math.BigDecimal rangoDesdePorcentaje;
	@Column(name="VAL_RANG_HAST_PORC")
	private java.math.BigDecimal rangoHastaPorcentaje;
	@Column(name="IMP_COMI_PORC")
	private java.math.BigDecimal comisionPorcentaje;
	@Column(name="IMP_COMI_IMPO")
	private java.math.BigDecimal comision;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="MELC_OID_METO_LIQU_COBR")
	private Long metodoLiquidacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getOrdenEscala() {return ordenEscala;}
      
	public void setOrdenEscala(Integer ordenEscala){this.ordenEscala=ordenEscala;}
		
	public java.math.BigDecimal getRangoDesde() {return rangoDesde;}
      
	public void setRangoDesde(java.math.BigDecimal rangoDesde){this.rangoDesde=rangoDesde;}
		
	public java.math.BigDecimal getRangoHasta() {return rangoHasta;}
      
	public void setRangoHasta(java.math.BigDecimal rangoHasta){this.rangoHasta=rangoHasta;}
		
	public java.math.BigDecimal getRangoDesdePorcentaje() {return rangoDesdePorcentaje;}
      
	public void setRangoDesdePorcentaje(java.math.BigDecimal rangoDesdePorcentaje){this.rangoDesdePorcentaje=rangoDesdePorcentaje;}
		
	public java.math.BigDecimal getRangoHastaPorcentaje() {return rangoHastaPorcentaje;}
      
	public void setRangoHastaPorcentaje(java.math.BigDecimal rangoHastaPorcentaje){this.rangoHastaPorcentaje=rangoHastaPorcentaje;}
		
	public java.math.BigDecimal getComisionPorcentaje() {return comisionPorcentaje;}
      
	public void setComisionPorcentaje(java.math.BigDecimal comisionPorcentaje){this.comisionPorcentaje=comisionPorcentaje;}
		
	public java.math.BigDecimal getComision() {return comision;}
      
	public void setComision(java.math.BigDecimal comision){this.comision=comision;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getMetodoLiquidacion() {return metodoLiquidacion;}
      
	public void setMetodoLiquidacion(Long metodoLiquidacion){this.metodoLiquidacion=metodoLiquidacion;}
			
	
}
