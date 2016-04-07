package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_TIPO_ACTUA")
@NamedQueries({
@NamedQuery(name="TipoActuacionLocal.FindAll",query="select object(o) from TipoActuacionLocal o")
})
public class TipoActuacionLocal implements Serializable {

	public TipoActuacionLocal() {}

	public TipoActuacionLocal(Long oid)	{
		this.oid=oid;
	}

	@Id
	@Column(name="OID_TIPO_ACTU")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
