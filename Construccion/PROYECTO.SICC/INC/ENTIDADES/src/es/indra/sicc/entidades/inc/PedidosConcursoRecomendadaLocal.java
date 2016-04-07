package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PEDID_CONCU_RECOM")
@NamedQueries({
@NamedQuery(name="PedidosConcursoRecomendadaLocal.FindAll",query="select object(o) from PedidosConcursoRecomendadaLocal o"),
@NamedQuery(name="PedidosConcursoRecomendadaLocal.FindByUKGerente",query="SELECT OBJECT(a) "
+ " FROM PedidosConcursoRecomendadaLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.concurso = ?2 "
+ " AND a.recomendado = ?3 "
+ " AND a.cliente = ?4 "
+ " AND a.periodo = ?5"),
@NamedQuery(name="PedidosConcursoRecomendadaLocal.FindRecomendante",query="SELECT OBJECT(a) "
+ " FROM PedidosConcursoRecomendadaLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.concurso = ?2 "
+ " AND a.periodo = ?3 "
+ " AND a.recomendado is null"),
@NamedQuery(name="PedidosConcursoRecomendadaLocal.FindByUKConsultora",query="SELECT OBJECT(a) "
+ " FROM PedidosConcursoRecomendadaLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.concurso = ?2 "
+ " AND a.recomendado = ?3 "
+ " AND a.periodo = ?4 "
+ " AND a.cliente IS NULL"),
@NamedQuery(name="PedidosConcursoRecomendadaLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM PedidosConcursoRecomendadaLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class PedidosConcursoRecomendadaLocal implements Serializable {

	public PedidosConcursoRecomendadaLocal() {}

	public PedidosConcursoRecomendadaLocal(Long oid, Long perdOidPeri, Long copaOidParaGral, Long clr3OidClieRete, Long clreOidClieRedo, Long clieOidClie)	{
	
		this.oid=oid;
                this.setPeriodo(perdOidPeri);
	        this.setConcurso(copaOidParaGral);
	        this.setRecomendante(clr3OidClieRete);
	        this.setRecomendado(clreOidClieRedo);
	        this.setCliente(clieOidClie);
	
	}

	@Id
	@Column(name="OID_PEDI_CONC_RECO")
	private Long oid;
	@Column(name="IMP_MONT_PEDI")
	private java.math.BigDecimal montoPedido;
	@Column(name="NUM_UNID_PEDI")
	private Integer unidadesPedido;
	@Column(name="IND_PEDI_VALI")
	private Boolean pedidoValido;
	@Column(name="CLRE_OID_CLIE_REDO")
	private Long recomendado;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="CLR3_OID_CLIE_RETE")
	private Long recomendante;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoPedido() {return montoPedido;}
      
	public void setMontoPedido(java.math.BigDecimal montoPedido){this.montoPedido=montoPedido;}
		
	public Integer getUnidadesPedido() {return unidadesPedido;}
      
	public void setUnidadesPedido(Integer unidadesPedido){this.unidadesPedido=unidadesPedido;}
		
	public Boolean getPedidoValido() {return pedidoValido;}
      
	public void setPedidoValido(Boolean pedidoValido){this.pedidoValido=pedidoValido;}
		
	public Long getRecomendado() {return recomendado;}
      
	public void setRecomendado(Long recomendado){this.recomendado=recomendado;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
			
	
}
