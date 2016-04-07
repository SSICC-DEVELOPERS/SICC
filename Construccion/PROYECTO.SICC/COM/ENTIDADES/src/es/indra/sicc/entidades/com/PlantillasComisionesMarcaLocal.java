package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_PLANT_COMIS_MARCA")
@NamedQueries({
@NamedQuery(name="PlantillasComisionesMarcaLocal.FindAll",query="select object(o) from PlantillasComisionesMarcaLocal o"), 
@NamedQuery(name="PlantillasComisionesMarcaLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ "  FROM PlantillasComisionesMarcaLocal AS a "
+ "  WHERE a.oidPlantillaComision =?1"), 
@NamedQuery(name="PlantillasComisionesMarcaLocal.FindByUk",query="SELECT OBJECT(p) "
+ "  FROM PlantillasComisionesMarcaLocal AS p "
+ "  WHERE p.oidMarca = ?1 "
+ "  and p.oidPlantillaComision = ?2")
})
public class PlantillasComisionesMarcaLocal implements Serializable {

	public PlantillasComisionesMarcaLocal() {}

	public PlantillasComisionesMarcaLocal(Long oid, Long marcOidMarc, Long plcoOidPlanComi)	{
	
		this.oid=oid;
                this.setOidMarca(marcOidMarc);
	        this.setOidPlantillaComision(plcoOidPlanComi);
	
	}

	@Id
	@Column(name="OID_PLAN_COMI_MARC")
	private Long oid;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Timestamp fecUltimoEstado;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="PLCO_OID_PLAN_COMI")
	private Long oidPlantillaComision;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFecUltimoEstado() {return fecUltimoEstado;}
      
	public void setFecUltimoEstado(java.sql.Timestamp fecUltimoEstado){this.fecUltimoEstado=fecUltimoEstado;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidPlantillaComision() {return oidPlantillaComision;}
      
	public void setOidPlantillaComision(Long oidPlantillaComision){this.oidPlantillaComision=oidPlantillaComision;}
			
	
}
