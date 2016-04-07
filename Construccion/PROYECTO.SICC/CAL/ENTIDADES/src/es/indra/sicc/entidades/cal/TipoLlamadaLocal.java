package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_TIPO_LLAMA")
@NamedQueries({
 @NamedQuery(name="TipoLlamadaLocal.FindAll",query="SELECT OBJECT(a) FROM TipoLlamadaLocal AS a")
})
public class TipoLlamadaLocal implements Serializable {

	public TipoLlamadaLocal() {}

	public TipoLlamadaLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_TIPO_LLAM")
	private Long oid;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
