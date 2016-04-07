package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_SUBCR_ASIGN")
public class SubcriterioAsignacionLocal implements Serializable {

	public SubcriterioAsignacionLocal() {}

	public SubcriterioAsignacionLocal(Long oid, String descripcion, Long oidCriterioAsignacion)	{
	
		this.oid=oid;
                this.descripcion=descripcion;
                this.oidCriterioAsignacion=oidCriterioAsignacion;                
	
	}

	@Id
	@Column(name="OID_SUBC")
	private Long oid;
	@Column(name="DES_SUBC")
	private String descripcion;
	@Column(name="CRAS_OID_CRIT_ASIG")
	private Long oidCriterioAsignacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Long getOidCriterioAsignacion() {return oidCriterioAsignacion;}
      
	public void setOidCriterioAsignacion(Long oidCriterioAsignacion){this.oidCriterioAsignacion=oidCriterioAsignacion;}
			
	
}
