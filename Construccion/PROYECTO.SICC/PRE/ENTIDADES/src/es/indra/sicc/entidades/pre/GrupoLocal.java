package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_GRUPO_OFERT")
@NamedQueries({
@NamedQuery(name="GrupoLocal.FindByOidOferta",query="SELECT OBJECT(a) "
+"FROM GrupoLocal AS a WHERE a.oidOferta = ?1")
})
public class GrupoLocal implements Serializable {

	public GrupoLocal() {}

	public GrupoLocal(Long oid, Long ofer_oid_ofer, Integer num_grup, Boolean ind_grup) {
	
		this.oid=oid;
                this.oidOferta=ofer_oid_ofer;
                this.numeroGrupo=num_grup;
                this.indicadorGrupo=ind_grup;
	
	}

	@Id
	@Column(name="OID_GRUP_OFER")
	private Long oid;
	@Column(name="OFER_OID_OFER")
	private Long oidOferta;
	@Column(name="NUM_GRUP")
	private Integer numeroGrupo;
	@Column(name="COD_FACT_CUAD")
	private java.math.BigDecimal factorCuadre;
	@Column(name="CUES_OID_IND_CUAD_TIPO_ESTR")
	private Long oidIndCuadTipoEstr;
	@Column(name="IND_CNDT")
	private Boolean condicionante;
	@Column(name="IND_CNDO")
	private Boolean condicionado;
	@Column(name="IND_GRUP")
	private Boolean indicadorGrupo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidOferta() {return oidOferta;}
      
	public void setOidOferta(Long oidOferta){this.oidOferta=oidOferta;}
		
	public Integer getNumeroGrupo() {return numeroGrupo;}
      
	public void setNumeroGrupo(Integer numeroGrupo){this.numeroGrupo=numeroGrupo;}
		
	public java.math.BigDecimal getFactorCuadre() {return factorCuadre;}
      
	public void setFactorCuadre(java.math.BigDecimal factorCuadre){this.factorCuadre=factorCuadre;}
		
	public Long getOidIndCuadTipoEstr() {return oidIndCuadTipoEstr;}
      
	public void setOidIndCuadTipoEstr(Long oidIndCuadTipoEstr){this.oidIndCuadTipoEstr=oidIndCuadTipoEstr;}
		
	public Boolean getCondicionante() {return condicionante;}
      
	public void setCondicionante(Boolean condicionante){this.condicionante=condicionante;}
		
	public Boolean getCondicionado() {return condicionado;}
      
	public void setCondicionado(Boolean condicionado){this.condicionado=condicionado;}
		
	public Boolean getIndicadorGrupo() {return indicadorGrupo;}
      
	public void setIndicadorGrupo(Boolean indicadorGrupo){this.indicadorGrupo=indicadorGrupo;}
			
	
}
