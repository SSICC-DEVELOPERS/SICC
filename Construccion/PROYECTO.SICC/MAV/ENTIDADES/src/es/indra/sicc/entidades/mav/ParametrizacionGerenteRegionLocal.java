package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_PARAM_GEREN_REGIO")
@NamedQueries({
@NamedQuery(name="ParametrizacionGerenteRegionLocal.FindByParametrizacion",query=" SELECT OBJECT(a) "+
" FROM ParametrizacionGerenteRegionLocal AS a "+
" WHERE a.oidParametrizacionMAV = ?1")
})
public class ParametrizacionGerenteRegionLocal implements Serializable {

	public ParametrizacionGerenteRegionLocal() {}

	public ParametrizacionGerenteRegionLocal(Long oid, Long oidParametrizacionMAV, Long oidSubtipoCliente)	{
	
		this.oid=oid;
                this.oidParametrizacionMAV=oidParametrizacionMAV;
                this.oidSubtipoCliente=oidSubtipoCliente;                
	
	}

	@Id
	@Column(name="OID_PARA_GERE_REGI")
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
