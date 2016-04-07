package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PEDID_GEREN_RECOM")
@NamedQueries({
@NamedQuery(name="PedidoGerenteRecomendadoLocal.FindAll",query="select object(o) from PedidoGerenteRecomendadoLocal o"),
@NamedQuery(name="PedidoGerenteRecomendadoLocal.FindByGerenteRecom",query="SELECT OBJECT(a) "
+ " FROM PedidoGerenteRecomendadoLocal "
+ " AS a WHERE a.oidClienteGerente = ?1 "
+ " AND a.oidClienteGerenteRecomendado = ?2 "
+ " AND a.oidConcurso = ?3 "
+ " AND a.oidPeriodo = ?4")
})
public class PedidoGerenteRecomendadoLocal implements Serializable {

	public PedidoGerenteRecomendadoLocal() {}

	public PedidoGerenteRecomendadoLocal(Long oid, Long clgeOidClieGere, Long clgrOidClieGereReco, Long perdOidPeri, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setOidClienteGerente(clgeOidClieGere);
                this.setOidClienteGerenteRecomendado(clgrOidClieGereReco);
                this.setOidPeriodo(perdOidPeri);
                this.setOidConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_PEDI_GERE_RECO")
	private Long oid;
	@Column(name="NUM_MONT_PEDI")
	private Double montoPedido;
	@Column(name="NUM_UNID_PEDI")
	private Long unidadesPedidas;
	@Column(name="IND_PEDI_VALI")
	private Boolean pedidoValido;
	@Column(name="CLGE_OID_CLIE_GERE")
	private Long oidClienteGerente;
	@Column(name="CLGR_OID_CLIE_GERE_RECO")
	private Long oidClienteGerenteRecomendado;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long oidConcurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getMontoPedido() {return montoPedido;}
      
	public void setMontoPedido(Double montoPedido){this.montoPedido=montoPedido;}
		
	public Long getUnidadesPedidas() {return unidadesPedidas;}
      
	public void setUnidadesPedidas(Long unidadesPedidas){this.unidadesPedidas=unidadesPedidas;}
		
	public Boolean getPedidoValido() {return pedidoValido;}
      
	public void setPedidoValido(Boolean pedidoValido){this.pedidoValido=pedidoValido;}
		
	public Long getOidClienteGerente() {return oidClienteGerente;}
      
	public void setOidClienteGerente(Long oidClienteGerente){this.oidClienteGerente=oidClienteGerente;}
		
	public Long getOidClienteGerenteRecomendado() {return oidClienteGerenteRecomendado;}
      
	public void setOidClienteGerenteRecomendado(Long oidClienteGerenteRecomendado){this.oidClienteGerenteRecomendado=oidClienteGerenteRecomendado;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidConcurso() {return oidConcurso;}
      
	public void setOidConcurso(Long oidConcurso){this.oidConcurso=oidConcurso;}
			
	
}
