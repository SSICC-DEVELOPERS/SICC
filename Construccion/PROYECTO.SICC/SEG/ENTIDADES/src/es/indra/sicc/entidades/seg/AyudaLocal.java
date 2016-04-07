package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_AYUDA")
@NamedQueries({
@NamedQuery(name="AyudaLocal.FindAll", query="SELECT Object(o) FROM AyudaLocal o"),
@NamedQuery(name="AyudaLocal.FindOidFunc", query="SELECT Object(o) FROM AyudaLocal o WHERE o.oidFunc = ?1")
})
public class AyudaLocal implements Serializable {

	public AyudaLocal() {}

	public AyudaLocal(Long oid, Long oidFunc)	{
		this.oid=oid;
		this.oidFunc = oidFunc;
	}

	@Id
	@Column(name="OID_AYUD")
	private Long oid;
	@Column(name="FUNC_OID_FUNC")
	private Long oidFunc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidFunc() {return oidFunc;}
      
	public void setOidFunc(Long oidFunc){this.oidFunc=oidFunc;}
			
	
}
