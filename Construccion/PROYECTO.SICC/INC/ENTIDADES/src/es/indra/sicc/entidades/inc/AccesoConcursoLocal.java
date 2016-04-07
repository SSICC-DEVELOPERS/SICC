package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_ACCES_CONCU")
@NamedQueries({
@NamedQuery(name="AccesoConcursoLocal.FindAll",query="select object(o) from AccesoConcursoLocal o"),
@NamedQuery(name="AccesoConcursoLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM AccesoConcursoLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class AccesoConcursoLocal implements Serializable {

	public AccesoConcursoLocal() {}

	public AccesoConcursoLocal(Long oid, Long copaOidParaGral, Long acceOidAcce)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setAcceso(acceOidAcce);
	
	}

	@Id
	@Column(name="OID_ACCE_CONC")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
			
	
}
