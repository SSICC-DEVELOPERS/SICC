package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_ESTAD")
@NamedQueries({
@NamedQuery(name="EstadosActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM EstadosActividadLocal AS a "+
"WHERE a.oidActividad = ?1")
})
public class EstadosActividadLocal implements Serializable {

	public EstadosActividadLocal() {}

	public EstadosActividadLocal(Long oid, Long oidActividad, Long oidEstadosMAV)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidEstadosMAV=oidEstadosMAV;                
	
	}

	@Id
	@Column(name="OID_ESTA_ACTI")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="EMAV_OID_ESTA_MAV")
	private Long oidEstadosMAV;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidEstadosMAV() {return oidEstadosMAV;}
      
	public void setOidEstadosMAV(Long oidEstadosMAV){this.oidEstadosMAV=oidEstadosMAV;}
			
	
}
