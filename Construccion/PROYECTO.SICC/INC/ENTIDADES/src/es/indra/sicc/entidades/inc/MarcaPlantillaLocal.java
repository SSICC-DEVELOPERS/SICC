package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_MARCA_PLANT")
@NamedQueries({
@NamedQuery(name="MarcaPlantillaLocal.FindAll",query="select object(o) from MarcaPlantillaLocal o"),
@NamedQuery(name="MarcaPlantillaLocal.FindByPlantilla",query="SELECT OBJECT(a) "
+ " FROM MarcaPlantillaLocal AS a "
+ " WHERE a.plantilla = ?1")
})
public class MarcaPlantillaLocal implements Serializable {

	public MarcaPlantillaLocal() {}

	public MarcaPlantillaLocal(Long oid, Long marcOidMarc, Long plc2OidPlanConc)	{
	
		this.oid=oid;
	        this.setMarca(marcOidMarc);
	        this.setPlantilla(plc2OidPlanConc);
	
	}

	@Id
	@Column(name="OID_MARC_PLAN")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="PLC2_OID_PLAN_CONC")
	private Long plantilla;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getPlantilla() {return plantilla;}
      
	public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
			
	
}
