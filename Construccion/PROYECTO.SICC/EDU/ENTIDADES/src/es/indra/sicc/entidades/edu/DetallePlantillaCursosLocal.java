package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_PLANT_CURSO_DETAL")
@NamedQueries({
@NamedQuery(name="DetallePlantillaCursosLocal.FindByPlantilla",query="SELECT OBJECT(a) FROM DetallePlantillaCursosLocal AS a WHERE a.plantilla=?1")
})
public class DetallePlantillaCursosLocal implements Serializable {

	public DetallePlantillaCursosLocal() {}

	public DetallePlantillaCursosLocal(Long oid, Long plantilla, Boolean visible, Boolean modificable, Boolean obligatorio, Long parametro, String valor)	{
	
		this.oid=oid;
                this.plantilla=plantilla;
                this.visible=visible;
                this.modificable=modificable;
                this.obligatorio=obligatorio;
                this.parametro=parametro;
                this.valor=valor;                
                
	
	}

	@Column(name="CPLC_OID_CABE")
	private Long plantilla;
	@Column(name="VAL_DETA")
	private String valor;
	@Column(name="IND_VISI")
	private Boolean visible;
	@Column(name="IND_MODI")
	private Boolean modificable;
	@Column(name="IND_OBLI")
	private Boolean obligatorio;
	@Column(name="PAED_OID_PARA")
	private Long parametro;
	@Id
	@Column(name="OID_DETA_PLAN_CURS")
	private Long oid;

	
	public Long getPlantilla() {return plantilla;}
      
	public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
		
	public String getValor() {return valor;}
      
	public void setValor(String valor){this.valor=valor;}
		
	public Boolean getVisible() {return visible;}
      
	public void setVisible(Boolean visible){this.visible=visible;}
		
	public Boolean getModificable() {return modificable;}
      
	public void setModificable(Boolean modificable){this.modificable=modificable;}
		
	public Boolean getObligatorio() {return obligatorio;}
      
	public void setObligatorio(Boolean obligatorio){this.obligatorio=obligatorio;}
		
	public Long getParametro() {return parametro;}
      
	public void setParametro(Long parametro){this.parametro=parametro;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
