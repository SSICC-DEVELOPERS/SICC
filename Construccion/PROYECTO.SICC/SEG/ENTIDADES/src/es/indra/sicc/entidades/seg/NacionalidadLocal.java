package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_NACIO")
@NamedQueries({
@NamedQuery(name="NacionalidadLocal.FindAll",query="select object(o) from NacionalidadLocal o"),
@NamedQuery(name="NacionalidadLocal.FindByUk",query="SELECT OBJECT(n) "
+ " FROM NacionalidadLocal AS n"
+ " WHERE n.codNaci = ?1")
})
public class NacionalidadLocal implements Serializable {

	public NacionalidadLocal() {}

	public NacionalidadLocal(Long oid, String codNaci)	{
		this.oid=oid;
		this.codNaci = codNaci;	
	}

	@Id
	@Column(name="OID_NACI")
	private Long oid;
	@Column(name="COD_NACI")
	private String codNaci;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodNaci() {return codNaci;}
      
	public void setCodNaci(String codNaci){this.codNaci=codNaci;}
			
	
}
