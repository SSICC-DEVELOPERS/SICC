package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PRECI_PERDI")
@NamedQueries({
@NamedQuery(name="PrecioPerdidaLocal.FindAll",query="select object(o) from PrecioPerdidaLocal o")
})
public class PrecioPerdidaLocal implements Serializable {

	public PrecioPerdidaLocal() {}

	public PrecioPerdidaLocal(Long oid, String codPrecioPerdida)	{
	
		this.oid=oid;
                this.codPrecioPerdida=codPrecioPerdida;
	
	}

	@Id
	@Column(name="OID_PREC_PERD")
	private Long oid;
	@Column(name="COD_PREC_PERD")
	private String codPrecioPerdida;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodPrecioPerdida() {return codPrecioPerdida;}
      
	public void setCodPrecioPerdida(String codPrecioPerdida){this.codPrecioPerdida=codPrecioPerdida;}
			
	
}
