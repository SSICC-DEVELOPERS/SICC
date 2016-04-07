package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_OBTEN_CUENT")
@NamedQueries({
@NamedQuery(name="ObtencionCuentaLocal.FindAll",query="select object(o) from ObtencionCuentaLocal o")
})
public class ObtencionCuentaLocal implements Serializable {

	public ObtencionCuentaLocal() {}

	public ObtencionCuentaLocal(Long oid, String valCodi)	{
	
		this.oid=oid;                
                this.codigo=valCodi;                
	
	}

	@Column(name="VAL_CODI")
	private String codigo;
	@Id
	@Column(name="OID_OBTE_CUEN")
	private Long oid;

	
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
