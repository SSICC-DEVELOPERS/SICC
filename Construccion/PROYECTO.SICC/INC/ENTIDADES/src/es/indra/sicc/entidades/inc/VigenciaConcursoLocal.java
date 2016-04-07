package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_VIGEN_CONCU")
@NamedQueries({
@NamedQuery(name="VigenciaConcursoLocal.FindAll",query="select object(o) from VigenciaConcursoLocal o")
})
public class VigenciaConcursoLocal implements Serializable {

	public VigenciaConcursoLocal() {}

	public VigenciaConcursoLocal(Long oidVigenciaConcurso)	{
	
		this.oidVigenciaConcurso=oidVigenciaConcurso;
	
	}

	@Id
	@Column(name="OID_VIGE_CONC")
	private Long oidVigenciaConcurso;

	
	public Long getOidVigenciaConcurso() {return oidVigenciaConcurso;}
      
	//public void setOidVigenciaConcurso(Long oidVigenciaConcurso){this.oidVigenciaConcurso=oidVigenciaConcurso;}
	
	public Long getPrimaryKey() {return oidVigenciaConcurso;}		
			
	
}
