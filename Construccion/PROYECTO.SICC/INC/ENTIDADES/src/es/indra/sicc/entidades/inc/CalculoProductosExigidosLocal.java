package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INC_CALCU_PRODU_EXIGI")
@NamedQueries({
@NamedQuery(name="CalculoProductosExigidosLocal.FindAll",query="select object(o) from CalculoProductosExigidosLocal o"),
@NamedQuery(name="CalculoProductosExigidosLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM CalculoProductosExigidosLocal AS a "
+ " WHERE a.periodo = ?1 "
+ " AND a.productoExigido = ?2 "
+ " AND a.consultora = ?3")
})
public class CalculoProductosExigidosLocal implements Serializable {

	public CalculoProductosExigidosLocal() {}

	public CalculoProductosExigidosLocal(Long oid, Long perdOidPeri, Long pre2OidProdExig, Long clieOidClie, BigDecimal montoPedido, Integer unidadesPedido, Integer puntosPedido)	{
	
		this.oid=oid;
                this.setPeriodo(perdOidPeri);
	        this.setProductoExigido(pre2OidProdExig);
	        this.setConsultora(clieOidClie);
	        this.setMontoPedido(montoPedido);
	        this.setUnidadesPedido(unidadesPedido);
	        this.setPuntosPedido(puntosPedido);
	
	}

	@Id
	@Column(name="OID_CALC_PROD_EXIG")
	private Long oid;
	@Column(name="IMP_MONT_PEDI")
	private java.math.BigDecimal montoPedido;
	@Column(name="NUM_UNID_PEDI")
	private Integer unidadesPedido;
	@Column(name="NUM_PUNT_PEDI")
	private Integer puntosPedido;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PRE2_OID_PROD_EXIG")
	private Long productoExigido;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoPedido() {return montoPedido;}
      
	public void setMontoPedido(java.math.BigDecimal montoPedido){this.montoPedido=montoPedido;}
		
	public Integer getUnidadesPedido() {return unidadesPedido;}
      
	public void setUnidadesPedido(Integer unidadesPedido){this.unidadesPedido=unidadesPedido;}
		
	public Integer getPuntosPedido() {return puntosPedido;}
      
	public void setPuntosPedido(Integer puntosPedido){this.puntosPedido=puntosPedido;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getProductoExigido() {return productoExigido;}
      
	public void setProductoExigido(Long productoExigido){this.productoExigido=productoExigido;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
			
	
}
