package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_CICLO_VIDA")
@NamedQueries({
@NamedQuery(name="CicloVidaActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
"FROM CicloVidaActividadLocal AS a "+
"WHERE a.oidActividad = ?1")
})
public class CicloVidaActividadLocal implements Serializable {

	public CicloVidaActividadLocal() {}

	public CicloVidaActividadLocal(Long oid, Long oidActividad, Long oidCicloVida)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidCicloVida=oidCicloVida;                
	
	}

	@Id
	@Column(name="OID_ACTI_CICL_VIDA")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long oidCicloVida;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidCicloVida() {return oidCicloVida;}
      
	public void setOidCicloVida(Long oidCicloVida){this.oidCicloVida=oidCicloVida;}
			
	
}
