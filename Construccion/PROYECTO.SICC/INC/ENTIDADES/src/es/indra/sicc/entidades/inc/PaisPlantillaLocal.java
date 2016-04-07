package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PAIS_PLANT")
@NamedQueries({
@NamedQuery(name="PaisPlantillaLocal.FindAll",query="select object(o) from PaisPlantillaLocal o"),
@NamedQuery(name="PaisPlantillaLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ " FROM PaisPlantillaLocal AS a "
+ " WHERE a.plantilla = ?1") 
})
public class PaisPlantillaLocal implements Serializable {

	public PaisPlantillaLocal() {}

	public PaisPlantillaLocal(Long oid, Long paisOidPais, Long plc2OidPlanConc)	{
	
		this.oid=oid;
	        this.setPais(paisOidPais);
	        this.setPlantilla(plc2OidPlanConc);
	
	}

	@Id
	@Column(name="OID_PAIS_PLAN")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PLC2_OID_PLAN_CONC")
	private Long plantilla;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPlantilla() {return plantilla;}
      
	public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
			
	
}
