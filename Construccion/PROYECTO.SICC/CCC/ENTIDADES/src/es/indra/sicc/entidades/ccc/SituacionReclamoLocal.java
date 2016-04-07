package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_SITUA_RECLA")
public class SituacionReclamoLocal implements Serializable {

	public SituacionReclamoLocal() {}

	public SituacionReclamoLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_SITU_RECL")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
