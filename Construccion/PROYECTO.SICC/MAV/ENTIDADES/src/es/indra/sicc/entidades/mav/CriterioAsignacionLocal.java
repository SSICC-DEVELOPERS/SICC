package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_CRITE_ASIGN")
public class CriterioAsignacionLocal implements Serializable {

	public CriterioAsignacionLocal() {}

	public CriterioAsignacionLocal(Long oid, String descripcion)	{
	
		this.oid=oid;
                this.descripcion= descripcion;
	
	}

	@Id
	@Column(name="OID_CRIT_ASIG")
	private Long oid;
	@Column(name="DES_CRIT_ASIG")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
