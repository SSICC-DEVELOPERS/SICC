package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_DESTI_IMPRE")
public class DestinoImpresionLocal implements Serializable {

	public DestinoImpresionLocal() {}

	public DestinoImpresionLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_DEST")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
