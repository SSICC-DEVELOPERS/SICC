package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_NIVEL_REDON")
public class NivelesRedondeoLocal implements Serializable {

	public NivelesRedondeoLocal() {}

	public NivelesRedondeoLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_NIVE_REDO")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
