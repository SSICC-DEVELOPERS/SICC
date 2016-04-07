package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_PRIOR")
@NamedQueries({
@NamedQuery(name="PrioridadLocal.FindAll",query="select object(o) from PrioridadLocal o")
})
public class PrioridadLocal implements Serializable {

	public PrioridadLocal() {}

	public PrioridadLocal(Long oid)	{
            this.oid=oid;
	}

	@Id
	@Column(name="OID_PRIO")
	private Long oid;
	@Column(name="COD_PRIO")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
