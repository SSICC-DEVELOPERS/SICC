package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PRECI")
@NamedQueries({
@NamedQuery(name="PreciosLocal.FindAll",query="select object(o) from PreciosLocal o")
})
public class PreciosLocal implements Serializable {

	public PreciosLocal() {}

	public PreciosLocal(Long oid, String codPrecio)	{
	
		this.oid=oid;
                this.codPrecio=codPrecio;
	
	}

	@Id
	@Column(name="OID_PREC")
	private Long oid;
	@Column(name="COD_PREC")
	private String codPrecio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodPrecio() {return codPrecio;}
      
	public void setCodPrecio(String codPrecio){this.codPrecio=codPrecio;}
			
	
}
