package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_INDIC_CUADR_TIPO_ESTRA")
public class IndicadorCuadrePorTipoEstrategiaLocal implements Serializable {

	public IndicadorCuadrePorTipoEstrategiaLocal() {}

	public IndicadorCuadrePorTipoEstrategiaLocal(Long oid, Long indc_oid_indi_cuad, Long ties_oid_tipo_estr) {
	
		this.oid=oid;
                this.oidIndiCuad=indc_oid_indi_cuad;
                this.oidTipoEstr=ties_oid_tipo_estr;
	
	}

	@Id
	@Column(name="OID_IND_CUAD_TIPO_ESTR")
	private Long oid;
	@Column(name="INDC_OID_INDI_CUAD")
	private Long oidIndiCuad;
	@Column(name="TIES_OID_TIPO_ESTR")
	private Long oidTipoEstr;
	@Column(name="IND_OFER_MONO_GRUP")
	private Boolean monoGrupos;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidIndiCuad() {return oidIndiCuad;}
      
	public void setOidIndiCuad(Long oidIndiCuad){this.oidIndiCuad=oidIndiCuad;}
		
	public Long getOidTipoEstr() {return oidTipoEstr;}
      
	public void setOidTipoEstr(Long oidTipoEstr){this.oidTipoEstr=oidTipoEstr;}
		
	public Boolean getMonoGrupos() {return monoGrupos;}
      
	public void setMonoGrupos(Boolean monoGrupos){this.monoGrupos=monoGrupos;}
			
	
}
