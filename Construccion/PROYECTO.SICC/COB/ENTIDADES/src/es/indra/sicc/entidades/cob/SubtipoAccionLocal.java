package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_SUBTI_ACCIO")
@NamedQueries({
@NamedQuery(name="SubtipoAccionLocal.FindAll",query="select object(o) from SubtipoAccionLocal o")
})
public class SubtipoAccionLocal implements Serializable {

	public SubtipoAccionLocal() {}

	public SubtipoAccionLocal(Long oid, Character codigo)	{
	
		this.oid=oid;
                this.setCodigo(codigo);
	
	}

	@Id
	@Column(name="OID_SUBT_ACCI")
	private Long oid;
	@Column(name="COD_SUBT_ACCI")
	private Character codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Character getCodigo() {return codigo;}
      
	public void setCodigo(Character codigo){this.codigo=codigo;}
			
	
}
