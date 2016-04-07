package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PRECI_ENVIA")
@NamedQueries({
@NamedQuery(name="PrecioEnviaLocal.FindAll",query="select object(o) from PrecioEnviaLocal o")
})
public class PrecioEnviaLocal implements Serializable {

	public PrecioEnviaLocal() {}

	public PrecioEnviaLocal(Long oid, String codPrecioEnvia){
	
		this.oid=oid;
                this.codPrecioEnvia=codPrecioEnvia;
	
	}

	@Id
	@Column(name="OID_PREC_ENVI")
	private Long oid;
	@Column(name="COD_PREC_ENVI")
	private String codPrecioEnvia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodPrecioEnvia() {return codPrecioEnvia;}
      
	public void setCodPrecioEnvia(String codPrecioEnvia){this.codPrecioEnvia=codPrecioEnvia;}
			
	
}
