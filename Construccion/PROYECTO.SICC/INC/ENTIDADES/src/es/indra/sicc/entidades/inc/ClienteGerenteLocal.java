package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_GEREN")
@NamedQueries({
@NamedQuery(name="ClienteGerenteLocal.FindAll",query="select object(o) from ClienteGerenteLocal o"),
@NamedQuery(name="ClienteGerenteLocal.FindByGerenteConcurso",query="SELECT OBJECT(a) FROM ClienteGerenteLocal AS a "
+ " WHERE a.gerente = ?1 "
+ " AND a.concurso = ?2"),
@NamedQuery(name="ClienteGerenteLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ClienteGerenteLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ClienteGerenteLocal implements Serializable {

	public ClienteGerenteLocal() {}

	public ClienteGerenteLocal(Long oid, Long copaOidParaGral, Long oidClieGere)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
                this.setGerente(oidClieGere);
	
	}

	@Id
	@Column(name="OID_CLIE_GERE")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="CLIE_OID_CLIE")
	private Long gerente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getGerente() {return gerente;}
      
	public void setGerente(Long gerente){this.gerente=gerente;}
			
	
}
