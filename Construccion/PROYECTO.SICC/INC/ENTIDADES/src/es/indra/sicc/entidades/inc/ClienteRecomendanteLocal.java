package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_RECTE")
@NamedQueries({
@NamedQuery(name="ClienteRecomendanteLocal.FindAll",query="select object(o) from ClienteRecomendanteLocal o"),
@NamedQuery(name="ClienteRecomendanteLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendanteLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.concurso = ?2"),
@NamedQuery(name="ClienteRecomendanteLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendanteLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ClienteRecomendanteLocal implements Serializable {

	public ClienteRecomendanteLocal() {}

	public ClienteRecomendanteLocal(Long oid, Long clieOidClie, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setRecomendante(clieOidClie);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_CLIE_RETE")
	private Long oid;
	@Column(name="IND_FIN_VINC")
	private Boolean finVinculo;
	@Column(name="CLIE_OID_CLIE")
	private Long recomendante;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="IND_EVAL")
	private Boolean eval;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getFinVinculo() {return finVinculo;}
      
	public void setFinVinculo(Boolean finVinculo){this.finVinculo=finVinculo;}
		
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Boolean getEval() {return eval;}
      
	public void setEval(Boolean eval){this.eval=eval;}
			
	
}
