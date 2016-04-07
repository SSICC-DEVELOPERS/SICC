package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="CCC_SITUA_INCOB")
@NamedQueries({
@NamedQuery(name="SituacionIncobrableLocal.FindAll",query="select object(o) from SituacionIncobrableLocal o")
})
public class SituacionIncobrableLocal implements Serializable {

	public SituacionIncobrableLocal() {}

	public SituacionIncobrableLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_SITU_INCO")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
