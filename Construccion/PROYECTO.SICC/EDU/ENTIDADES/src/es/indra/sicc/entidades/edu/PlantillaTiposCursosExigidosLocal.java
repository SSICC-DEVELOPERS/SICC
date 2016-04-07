package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_PLANT_TIPOS_CURSO_EXIGI")
@NamedQueries({
@NamedQuery(name="PlantillaTiposCursosExigidosLocal.FindAll",query="select object(o) from PlantillaTiposCursosExigidosLocal o")
})
public class PlantillaTiposCursosExigidosLocal implements Serializable {

	public PlantillaTiposCursosExigidosLocal() {}

	public PlantillaTiposCursosExigidosLocal(Long oid, Long oidDetaPlanCurs, Long oidCurs)	{
	
		this.oid=oid;
                this.oidDetaPlanCurs=oidDetaPlanCurs;
                this.oidCurs=oidCurs;
	
	}

	@Id
	@Column(name="OID_ESTA")
	private Long oid;
	@Column(name="DPCU_OID_DETA_PLAN_CURS")
	private Long oidDetaPlanCurs;
	@Column(name="TICU_OID_TIPO_CURS")
	private Long oidCurs;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidDetaPlanCurs() {return oidDetaPlanCurs;}
      
	public void setOidDetaPlanCurs(Long oidDetaPlanCurs){this.oidDetaPlanCurs=oidDetaPlanCurs;}
		
	public Long getOidCurs() {return oidCurs;}
      
	public void setOidCurs(Long oidCurs){this.oidCurs=oidCurs;}
			
	
}
