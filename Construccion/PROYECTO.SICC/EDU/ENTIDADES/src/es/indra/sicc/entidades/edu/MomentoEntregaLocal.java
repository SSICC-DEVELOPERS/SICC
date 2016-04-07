package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_MOMEN_ENTRE")
public class MomentoEntregaLocal implements Serializable {

	public MomentoEntregaLocal() {}

	public MomentoEntregaLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_MOME_ENTR")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
