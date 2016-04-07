package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_FORMA_CALCU")
@NamedQueries({
@NamedQuery(name="FormaCalculoLocal.FindAll",query="select object(o) from FormaCalculoLocal o")
})
public class FormaCalculoLocal implements Serializable {

	public FormaCalculoLocal() {}

	public FormaCalculoLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_FORM_CALC")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
