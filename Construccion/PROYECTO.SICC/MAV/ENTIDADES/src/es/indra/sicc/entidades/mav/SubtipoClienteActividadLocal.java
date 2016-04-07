package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_SUBTI_CLIEN")
@NamedQueries({
@NamedQuery(name="SubtipoClienteActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM SubtipoClienteActividadLocal AS a "+
" WHERE a.oidActividad = ?1")
})
public class SubtipoClienteActividadLocal implements Serializable {

	public SubtipoClienteActividadLocal() {}

	public SubtipoClienteActividadLocal(Long oid, Long oidActividad, Long oidSubtipoCliente) {
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidSubtipoCliente=oidSubtipoCliente;                
	
	}

	@Id
	@Column(name="OID_SUBT_CLIE_ACTI")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long oidSubtipoCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidSubtipoCliente() {return oidSubtipoCliente;}
      
	public void setOidSubtipoCliente(Long oidSubtipoCliente){this.oidSubtipoCliente=oidSubtipoCliente;}
			
	
}
