package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_ACCES_PLANT")
@NamedQueries({
@NamedQuery(name="AccesoPlantillaLocal.FindAll",query="select object(o) from AccesoPlantillaLocal o"),
@NamedQuery(name="AccesoPlantillaLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ " FROM AccesoPlantillaLocal AS a "
+ " WHERE a.plantilla = ?1")
})
public class AccesoPlantillaLocal implements Serializable {

	public AccesoPlantillaLocal() {}

	public AccesoPlantillaLocal(Long oid, Long plc2OidPlanConc, Long acceOidAcce)	{
	
		this.oid=oid;
                this.setPlantilla(plc2OidPlanConc);
	        this.setAcceso(acceOidAcce);
	
	}

	@Id
	@Column(name="OID_ACCE_PLAN")
	private Long oid;
	@Column(name="PLC2_OID_PLAN_CONC")
	private Long plantilla;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPlantilla() {return plantilla;}
      
	public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
			
	
}
