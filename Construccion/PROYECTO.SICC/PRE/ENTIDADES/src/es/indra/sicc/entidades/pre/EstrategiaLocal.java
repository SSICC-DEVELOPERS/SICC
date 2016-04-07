package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_ESTRA")
@NamedQueries({
@NamedQuery(name="EstrategiaLocal.FindByOidPais",query="SELECT OBJECT(i) "
+"FROM EstrategiaLocal AS i WHERE i.oidPais = ?1"),
@NamedQuery(name="EstrategiaLocal.FindByUK",query="SELECT OBJECT(e) "
+" FROM EstrategiaLocal AS e WHERE e.codigo = ?1 and e.oidPais = ?2")
})
public class EstrategiaLocal implements Serializable {

	public EstrategiaLocal() {}

	public EstrategiaLocal(Long oid, Long pais_oid_pais, Long ties_oid_tipo_estr, String cod_estr) {
	
		this.oid=oid;
                this.oidPais=pais_oid_pais;
                this.oidTipoEstr=ties_oid_tipo_estr;
                this.codigo=cod_estr;
	
	}

	@Id
	@Column(name="OID_ESTR")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="TIES_OID_TIPO_ESTR")
	private Long oidTipoEstr;
	@Column(name="COD_ESTR")
	private String codigo;
	@Column(name="NUM_MAXI_GRUP")
	private Integer maxGrupos;
	@Column(name="NUM_MAXI_GRUP_CNDT")
	private Integer maxGruposCondicionantes;
	@Column(name="NUM_MAXI_GRUP_CNDO")
	private Integer maxGruposCondicionados;
	@Column(name="IND_LIST_RANK")
	private Boolean listaRanking;
	@Column(name="IND_CUAD_GRUP")
	private Boolean cuadreGrupos;
	@Column(name="TIPR_OID_TIPO_PROD")
	private Long oidTipoProd;
	@Column(name="IND_CV_IMPR")
	private Boolean cvImprimible;
	@Column(name="IND_MODI_IMPR")
	private Boolean modificableImprimible;
	@Column(name="IND_CV_DIGI")
	private Boolean cvDigitable;
	@Column(name="IND_MODI_DIGI")
	private Boolean modificableDigitable;
	@Column(name="IND_CV_DESP_AUTO")
	private Boolean cvDespachoAutomatico;
	@Column(name="IND_MODI_DESP")
	private Boolean modificableDespachoAutomatico;
	@Column(name="NUM_ORDE_ASIG_CUV")
	private Integer ordenAsignacionCUV;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidTipoEstr() {return oidTipoEstr;}
      
	public void setOidTipoEstr(Long oidTipoEstr){this.oidTipoEstr=oidTipoEstr;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Integer getMaxGrupos() {return maxGrupos;}
      
	public void setMaxGrupos(Integer maxGrupos){this.maxGrupos=maxGrupos;}
		
	public Integer getMaxGruposCondicionantes() {return maxGruposCondicionantes;}
      
	public void setMaxGruposCondicionantes(Integer maxGruposCondicionantes){this.maxGruposCondicionantes=maxGruposCondicionantes;}
		
	public Integer getMaxGruposCondicionados() {return maxGruposCondicionados;}
      
	public void setMaxGruposCondicionados(Integer maxGruposCondicionados){this.maxGruposCondicionados=maxGruposCondicionados;}
		
	public Boolean getListaRanking() {return listaRanking;}
      
	public void setListaRanking(Boolean listaRanking){this.listaRanking=listaRanking;}
		
	public Boolean getCuadreGrupos() {return cuadreGrupos;}
      
	public void setCuadreGrupos(Boolean cuadreGrupos){this.cuadreGrupos=cuadreGrupos;}
		
	public Long getOidTipoProd() {return oidTipoProd;}
      
	public void setOidTipoProd(Long oidTipoProd){this.oidTipoProd=oidTipoProd;}
		
	public Boolean getCvImprimible() {return cvImprimible;}
      
	public void setCvImprimible(Boolean cvImprimible){this.cvImprimible=cvImprimible;}
		
	public Boolean getModificableImprimible() {return modificableImprimible;}
      
	public void setModificableImprimible(Boolean modificableImprimible){this.modificableImprimible=modificableImprimible;}
		
	public Boolean getCvDigitable() {return cvDigitable;}
      
	public void setCvDigitable(Boolean cvDigitable){this.cvDigitable=cvDigitable;}
		
	public Boolean getModificableDigitable() {return modificableDigitable;}
      
	public void setModificableDigitable(Boolean modificableDigitable){this.modificableDigitable=modificableDigitable;}
		
	public Boolean getCvDespachoAutomatico() {return cvDespachoAutomatico;}
      
	public void setCvDespachoAutomatico(Boolean cvDespachoAutomatico){this.cvDespachoAutomatico=cvDespachoAutomatico;}
		
	public Boolean getModificableDespachoAutomatico() {return modificableDespachoAutomatico;}
      
	public void setModificableDespachoAutomatico(Boolean modificableDespachoAutomatico){this.modificableDespachoAutomatico=modificableDespachoAutomatico;}
		
	public Integer getOrdenAsignacionCUV() {return ordenAsignacionCUV;}
      
	public void setOrdenAsignacionCUV(Integer ordenAsignacionCUV){this.ordenAsignacionCUV=ordenAsignacionCUV;}
			
	
}
