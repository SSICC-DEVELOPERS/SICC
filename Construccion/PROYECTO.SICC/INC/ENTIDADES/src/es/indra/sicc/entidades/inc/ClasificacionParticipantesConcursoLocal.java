package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLASI_PARTI_CONCU")
@NamedQueries({
@NamedQuery(name="ClasificacionParticipantesConcursoLocal.FindAll",query="select object(o) from ClasificacionParticipantesConcursoLocal o"),
@NamedQuery(name="ClasificacionParticipantesConcursoLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ClasificacionParticipantesConcursoLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ClasificacionParticipantesConcursoLocal implements Serializable {

	public ClasificacionParticipantesConcursoLocal() {}

	public ClasificacionParticipantesConcursoLocal(Long oid, Long copaOidParaGral, Long paciOidPartConcCabe)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setParticipante(paciOidPartConcCabe);
	
	}

	@Id
	@Column(name="OID_CLAS_PART_CONC")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PACI_OID_PART_CONC_CABE")
	private Long participante;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getParticipante() {return participante;}
      
	public void setParticipante(Long participante){this.participante=participante;}
			
	
}
