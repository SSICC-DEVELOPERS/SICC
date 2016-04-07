package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PEDID_RECTE_MULTI")
@NamedQueries({
@NamedQuery(name="PedidoRecomendanteMultinivelLocal.FindAll",query="select object(o) from PedidoRecomendanteMultinivelLocal o")
})
public class PedidoRecomendanteMultinivelLocal implements Serializable {

	public PedidoRecomendanteMultinivelLocal() {}

	public PedidoRecomendanteMultinivelLocal(Long oid, Long periodo, Long recomendante)	{
	
		this.oid=oid;
                this.setPeriodo(periodo);
                this.setRecomendante(recomendante);
	
	}

	@Id
	@Column(name="OID_PEDI_RETE_MULT")
	private Long oid;
	@Column(name="VAL_CANT")
	private java.math.BigDecimal cantidad;
	@Column(name="VAL_PUNT_EXIG")
	private Integer puntosExigidos;
	@Column(name="IND_PEDI_VALI")
	private Boolean pedidoValido;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CLR2_CLIE_OID_CLIE")
	private Long recomendante;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getCantidad() {return cantidad;}
      
	public void setCantidad(java.math.BigDecimal cantidad){this.cantidad=cantidad;}
		
	public Integer getPuntosExigidos() {return puntosExigidos;}
      
	public void setPuntosExigidos(Integer puntosExigidos){this.puntosExigidos=puntosExigidos;}
		
	public Boolean getPedidoValido() {return pedidoValido;}
      
	public void setPedidoValido(Boolean pedidoValido){this.pedidoValido=pedidoValido;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
			
	
}
