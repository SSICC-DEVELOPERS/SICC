package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_PLANT_COMIS")
@NamedQueries({
@NamedQuery(name="PlantillasComisionesLocal.FindAll",query="select object(o) from PlantillasComisionesLocal o")
})
public class PlantillasComisionesLocal implements Serializable {

	public PlantillasComisionesLocal() {}

	public PlantillasComisionesLocal(Long oid, Long codPlanComi, Long oidCanal)	{
	
		this.oid=oid;
                this.setOidCanal(oidCanal);
	        if(codPlanComi==null){
	          this.setCodigo(oid);
	        }else{          
	          this.setCodigo(codPlanComi);
	        }	
	}

	@Id
	@Column(name="OID_PLAN_COMI")
	private Long oid;
	@Column(name="COD_PLAN_COMI")
	private Long codigo;
	@Column(name="IND_COMP")
	private Long comparativo;
	@Column(name="IND_TRAT_DIFE")
	private Long tratamientoDiferencial;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Timestamp fecUltimoEstado;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="TPLA_OID_TIPO_PLAN")
	private Long oidTipoPlantilla;
	@Column(name="CEST_OID_ESTA")
	private Long oidEstado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigo() {return codigo;}
      
	public void setCodigo(Long codigo){this.codigo=codigo;}
		
	public Long getComparativo() {return comparativo;}
      
	public void setComparativo(Long comparativo){this.comparativo=comparativo;}
		
	public Long getTratamientoDiferencial() {return tratamientoDiferencial;}
      
	public void setTratamientoDiferencial(Long tratamientoDiferencial){this.tratamientoDiferencial=tratamientoDiferencial;}
		
	public java.sql.Timestamp getFecUltimoEstado() {return fecUltimoEstado;}
      
	public void setFecUltimoEstado(java.sql.Timestamp fecUltimoEstado){this.fecUltimoEstado=fecUltimoEstado;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidTipoPlantilla() {return oidTipoPlantilla;}
      
	public void setOidTipoPlantilla(Long oidTipoPlantilla){this.oidTipoPlantilla=oidTipoPlantilla;}
		
	public Long getOidEstado() {return oidEstado;}
      
	public void setOidEstado(Long oidEstado){this.oidEstado=oidEstado;}
			
	
}
