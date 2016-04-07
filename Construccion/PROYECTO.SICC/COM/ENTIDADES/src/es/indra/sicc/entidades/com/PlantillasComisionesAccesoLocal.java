package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_PLANT_COMIS_ACCES")
@NamedQueries({
@NamedQuery(name="PlantillasComisionesAccesoLocal.FindAll",query="select object(o) from PlantillasComisionesAccesoLocal o"), 
@NamedQuery(name="PlantillasComisionesAccesoLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ "  FROM PlantillasComisionesAccesoLocal AS a "
+ "  WHERE a.oidPlanComision =?1"),
@NamedQuery(name="PlantillasComisionesAccesoLocal.FindByUK",query="SELECT OBJECT(p) "
+ "  FROM PlantillasComisionesAccesoLocal AS p "
+ "  WHERE p.oidAcceso = ?1 "
+ "  and p.oidPlanComision = ?2 "
+ "  and p.oidCanal = ?3")
})
public class PlantillasComisionesAccesoLocal implements Serializable {

	public PlantillasComisionesAccesoLocal() {}

	public PlantillasComisionesAccesoLocal(Long oid, Long plcoOidPlanComi, Long acceOidAcce, Long oidCanal)	{
	
		this.oid=oid;
	        this.setOidPlanComision(plcoOidPlanComi);
	        this.setOidAcceso(acceOidAcce);
	        this.setOidCanal(oidCanal);
	        
	
	}

	@Id
	@Column(name="OID_PLAN_COMI_ACCE")
	private Long oid;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Timestamp fecUltimoEstado;
	@Column(name="PLCO_OID_PLAN_COMI")
	private Long oidPlanComision;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFecUltimoEstado() {return fecUltimoEstado;}
      
	public void setFecUltimoEstado(java.sql.Timestamp fecUltimoEstado){this.fecUltimoEstado=fecUltimoEstado;}
		
	public Long getOidPlanComision() {return oidPlanComision;}
      
	public void setOidPlanComision(Long oidPlanComision){this.oidPlanComision=oidPlanComision;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
			
	
}
