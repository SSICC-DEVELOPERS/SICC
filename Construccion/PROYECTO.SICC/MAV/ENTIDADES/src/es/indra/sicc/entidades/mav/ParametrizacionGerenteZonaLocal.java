package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_PARAM_GEREN_ZONA")
@NamedQueries({
@NamedQuery(name="ParametrizacionGerenteZonaLocal.FindByParametrizacion",query="SELECT OBJECT(a) "+
" FROM ParametrizacionGerenteZonaLocal AS a "+
" WHERE a.oidParametrizacionMAV = ?1")
})
public class ParametrizacionGerenteZonaLocal implements Serializable {

	public ParametrizacionGerenteZonaLocal() {}

	public ParametrizacionGerenteZonaLocal(Long oid, Long oidParametrizacionMAV, Long oidSubtipoCliente)	{
	
		this.oid=oid;
                this.oidParametrizacionMAV=oidParametrizacionMAV;
                this.oidSubtipoCliente=oidSubtipoCliente;
	
	}

	@Id
	@Column(name="OID_PARA_GERE_ZONA")
	private Long oid;
	@Column(name="PARM_OID_PARA_MAV")
	private Long oidParametrizacionMAV;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long oidSubtipoCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidParametrizacionMAV() {return oidParametrizacionMAV;}
      
	public void setOidParametrizacionMAV(Long oidParametrizacionMAV){this.oidParametrizacionMAV=oidParametrizacionMAV;}
		
	public Long getOidSubtipoCliente() {return oidSubtipoCliente;}
      
	public void setOidSubtipoCliente(Long oidSubtipoCliente){this.oidSubtipoCliente=oidSubtipoCliente;}
			
	
}
