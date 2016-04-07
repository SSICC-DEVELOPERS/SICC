package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_RECTE_MULTI")
@NamedQueries({
@NamedQuery(name="ClienteRecomendanteMultinivelLocal.FindAll",query="select object(o) from ClienteRecomendanteMultinivelLocal o"),
@NamedQuery(name="ClienteRecomendanteMultinivelLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendanteMultinivelLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.concurso = ?2"),
@NamedQuery(name="ClienteRecomendanteMultinivelLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendanteMultinivelLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ClienteRecomendanteMultinivelLocal implements Serializable {

	public ClienteRecomendanteMultinivelLocal() {}

	public ClienteRecomendanteMultinivelLocal(Long oid, Long oidClieRecoMult, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setRecomendante(oidClieRecoMult);
                this.setConcurso(copaOidParaGral);
	
	}

	@Column(name="CLIE_OID_CLIE")
	private Long recomendante;
	@Id
	@Column(name="OID_CLIE_RECO_MULT")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;

	
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
	
}
