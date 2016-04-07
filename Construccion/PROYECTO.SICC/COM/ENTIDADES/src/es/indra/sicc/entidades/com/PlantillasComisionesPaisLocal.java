package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_PLANT_COMIS_PAIS")
@NamedQueries({
@NamedQuery(name="PlantillasComisionesPaisLocal.FindAll",query="select object(o) from PlantillasComisionesPaisLocal o"),
@NamedQuery(name="PlantillasComisionesPaisLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ "  FROM PlantillasComisionesPaisLocal AS a "
+ "  WHERE a.oidPlantillaComision =?1"),
@NamedQuery(name="PlantillasComisionesPaisLocal.FindByUK",query="SELECT OBJECT(p) "
+ "  FROM PlantillasComisionesPaisLocal AS p "
+ "  WHERE p.oidPlantillaComision = ?1 "
+ "  AND p.oidPais = ?2")
})
public class PlantillasComisionesPaisLocal implements Serializable {

	public PlantillasComisionesPaisLocal() {}

	public PlantillasComisionesPaisLocal(Long oid, Long paisOidPais, Long plcoOidPlanComi)	{
	
		this.oid=oid;
                this.setOidPais(paisOidPais);
	        this.setOidPlantillaComision(plcoOidPlanComi);
	
	}

	@Id
	@Column(name="OID_PLAN_COMI_PAIS")
	private Long oid;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Timestamp fecUltimoEstado;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="PLCO_OID_PLAN_COMI")
	private Long oidPlantillaComision;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFecUltimoEstado() {return fecUltimoEstado;}
      
	public void setFecUltimoEstado(java.sql.Timestamp fecUltimoEstado){this.fecUltimoEstado=fecUltimoEstado;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidPlantillaComision() {return oidPlantillaComision;}
      
	public void setOidPlantillaComision(Long oidPlantillaComision){this.oidPlantillaComision=oidPlantillaComision;}
			
	
}
