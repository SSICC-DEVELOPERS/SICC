package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PEDID_RECDA_MULTI")
@NamedQueries({
@NamedQuery(name="PedidoRecomendadoMultinivelLocal.FindAll",query="select object(o) from PedidoRecomendadoMultinivelLocal o")
})
public class PedidoRecomendadoMultinivelLocal implements Serializable {

	public PedidoRecomendadoMultinivelLocal() {}

	public PedidoRecomendadoMultinivelLocal(Long oid, Long periodo, Long clierecomendado)	{
	
		this.oid=oid;
                this.setPeriodo(periodo);
	        this.setRecomendado(clierecomendado);
	
	}

	@Id
	@Column(name="OID_PEDI_RECO_MULT")
	private Long oid;
	@Column(name="NUM_CANT")
	private java.math.BigDecimal cantidad;
	@Column(name="NUM_PUNT_EXIG")
	private Integer puntosExigidos;
	@Column(name="IND_PEDI_VALI")
	private Boolean pedidoValido;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CLRM_OID_CLIE_RECO_MULT")
	private Long recomendado;

	
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
		
	public Long getRecomendado() {return recomendado;}
      
	public void setRecomendado(Long recomendado){this.recomendado=recomendado;}
			
	
}
