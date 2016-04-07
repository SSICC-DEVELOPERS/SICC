package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_COBRA_ACUMU")
@NamedQueries({
@NamedQuery(name="ComisionesCobranzasAcumuladasLocal.FindAll",query="select object(o) from ComisionesCobranzasAcumuladasLocal o")
})
public class ComisionesCobranzasAcumuladasLocal implements Serializable {

	public ComisionesCobranzasAcumuladasLocal() {}

	public ComisionesCobranzasAcumuladasLocal(Long oid, BigDecimal cantidadFacturada, Long cliente, Long comision, Long periodo)	{
	
		this.oid=oid;
                this.setCantidadFacturada(cantidadFacturada);
	        this.setCliente(cliente);
	        this.setComision(comision);
	        this.setPeriodo(periodo);   
	
	}

	@Id
	@Column(name="OID_COMI_COBR_ACUM")
	private Long oid;
	@Column(name="VAL_CANT_FACT")
	private java.math.BigDecimal cantidadFacturada;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="PERD_OID_PERI")
	private Long periodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getCantidadFacturada() {return cantidadFacturada;}
      
	public void setCantidadFacturada(java.math.BigDecimal cantidadFacturada){this.cantidadFacturada=cantidadFacturada;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
			
	
}
