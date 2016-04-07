package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_DESCU")
@NamedQueries({
@NamedQuery(name="PremioDescuentoLocal.FindAll",query="select object(o) from PremioDescuentoLocal o"),
@NamedQuery(name="PremioDescuentoLocal.FindByParametroNivelPremiacion",query="SELECT OBJECT(a) "
+ " FROM PremioDescuentoLocal AS a "
+ " WHERE a.nivelPremiacion = ?1"),
@NamedQuery(name="PremioDescuentoLocal.FindByUK",query="SELECT OBJECT(o) FROM PremioDescuentoLocal o WHERE o.nivelPremiacion = ?1")
})
public class PremioDescuentoLocal implements Serializable {

	public PremioDescuentoLocal() {}

	public PremioDescuentoLocal(Long oid, Integer numPrem, Long oidParaNivePrem, Long perdOidPeriDesd, Long tdscOidTipoDesc)	{
	
		this.oid=oid;
                this.setNumeroPremio(numPrem);
	        this.setNivelPremiacion(oidParaNivePrem);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setTipoDescuento(tdscOidTipoDesc);
	
	}

	@Id
	@Column(name="OID_PREM_DESC")
	private Long oid;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="VAL_CANT_DESC")
	private java.math.BigDecimal cantidadDescuento;
	@Column(name="VAL_PORC_DESC")
	private java.math.BigDecimal porcentajeDescuento;
	@Column(name="OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;
	@Column(name="PERD_OID_PERI")
	private Long periodoHasta;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="TDSC_OID_TIPO_DESC")
	private Long tipoDescuento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public java.math.BigDecimal getCantidadDescuento() {return cantidadDescuento;}
      
	public void setCantidadDescuento(java.math.BigDecimal cantidadDescuento){this.cantidadDescuento=cantidadDescuento;}
		
	public java.math.BigDecimal getPorcentajeDescuento() {return porcentajeDescuento;}
      
	public void setPorcentajeDescuento(java.math.BigDecimal porcentajeDescuento){this.porcentajeDescuento=porcentajeDescuento;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getTipoDescuento() {return tipoDescuento;}
      
	public void setTipoDescuento(Long tipoDescuento){this.tipoDescuento=tipoDescuento;}
			
	
}
