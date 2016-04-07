package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_CRITE_ASIGN_ACTIV")
@NamedQueries({
@NamedQuery(name="CriterioAsignacionActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM CriterioAsignacionActividadLocal AS a "+
" WHERE a.oidActividad = ?1")
})
public class CriterioAsignacionActividadLocal implements Serializable {

	public CriterioAsignacionActividadLocal() {}

	public CriterioAsignacionActividadLocal(Long oid, Long oidActividad, Long oidCriterioAsignacion)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidCriterioDeAsignacion=oidCriterioAsignacion;	
	}

	@Id
	@Column(name="OID_CRIT_ASIG_ACTI")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="CRAS_OID_CRIT_ASIG")
	private Long oidCriterioDeAsignacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidCriterioDeAsignacion() {return oidCriterioDeAsignacion;}
      
	public void setOidCriterioDeAsignacion(Long oidCriterioDeAsignacion){this.oidCriterioDeAsignacion=oidCriterioDeAsignacion;}
			
	
}
