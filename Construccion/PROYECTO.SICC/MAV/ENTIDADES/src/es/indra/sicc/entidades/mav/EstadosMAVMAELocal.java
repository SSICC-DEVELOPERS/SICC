package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ESTAD_MAV_MAE")
@NamedQueries({
@NamedQuery(name="EstadosMAVMAELocal.FindOidEstadoMAV",query="SELECT OBJECT(i) " +
" FROM EstadosMAVMAELocal AS i "+
" WHERE i.oidEstadosMAV = ?1")
})
public class EstadosMAVMAELocal implements Serializable {

	public EstadosMAVMAELocal() {}

	public EstadosMAVMAELocal(Long oid, Long oidEstadosMAV, Long oidEstatusCliente)	{
	
		this.oid=oid;
                this.oidEstadosMAV=oidEstadosMAV;
                this.oidEstatusCliente=oidEstatusCliente;                
	
	}

	@Id
	@Column(name="OID_ESTA_MAV_MAE")
	private Long oid;
	@Column(name="EMAV_OID_ESTA_MAV")
	private Long oidEstadosMAV;
	@Column(name="ESTA_OID_ESTA_CLIE")
	private Long oidEstatusCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidEstadosMAV() {return oidEstadosMAV;}
      
	public void setOidEstadosMAV(Long oidEstadosMAV){this.oidEstadosMAV=oidEstadosMAV;}
		
	public Long getOidEstatusCliente() {return oidEstatusCliente;}
      
	public void setOidEstatusCliente(Long oidEstatusCliente){this.oidEstatusCliente=oidEstatusCliente;}
			
	
}
