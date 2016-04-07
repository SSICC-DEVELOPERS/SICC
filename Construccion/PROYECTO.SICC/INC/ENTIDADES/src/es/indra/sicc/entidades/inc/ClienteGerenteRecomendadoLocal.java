package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_GEREN_RECOM")
@NamedQueries({
@NamedQuery(name="ClienteGerenteRecomendadoLocal.FindAll",query="select object(o) from ClienteGerenteRecomendadoLocal o"),
@NamedQuery(name="ClienteGerenteRecomendadoLocal.FindByClienteGerente",query="SELECT OBJECT(a) "
+ " FROM ClienteGerenteRecomendadoLocal AS a "
+ " WHERE a.oidCliente = ?1 "
+ " AND a.oidGerente = ?2")
})
public class ClienteGerenteRecomendadoLocal implements Serializable {

	public ClienteGerenteRecomendadoLocal() {}

	public ClienteGerenteRecomendadoLocal(Long oid, Long clieOidClie, Long perdOidPeri, Long clgeOidClieGere)	{
	
		this.oid=oid;
                this.setOidCliente(clieOidClie);
                this.setOidPeriodo(perdOidPeri);
                this.setOidGerente(clgeOidClieGere);
	
	}

	@Id
	@Column(name="OID_CLIE_GERE_RECO")
	private Long oid;
	@Column(name="IND_EFEC")
	private Boolean efectiva;
	@Column(name="IND_EVAL")
	private Boolean evaluada;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="CLGE_OID_CLIE_GERE")
	private Long oidGerente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getEfectiva() {return efectiva;}
      
	public void setEfectiva(Boolean efectiva){this.efectiva=efectiva;}
		
	public Boolean getEvaluada() {return evaluada;}
      
	public void setEvaluada(Boolean evaluada){this.evaluada=evaluada;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidGerente() {return oidGerente;}
      
	public void setOidGerente(Long oidGerente){this.oidGerente=oidGerente;}
			
	
}
