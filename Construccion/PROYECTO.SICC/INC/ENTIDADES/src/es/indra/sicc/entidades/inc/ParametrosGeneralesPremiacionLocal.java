package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PARAM_GENER_PREMI")
@NamedQueries({
@NamedQuery(name="ParametrosGeneralesPremiacionLocal.FindAll",query="select object(o) from ParametrosGeneralesPremiacionLocal o"),
@NamedQuery(name="ParametrosGeneralesPremiacionLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ParametrosGeneralesPremiacionLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ParametrosGeneralesPremiacionLocal implements Serializable {

	public ParametrosGeneralesPremiacionLocal() {}

	public ParametrosGeneralesPremiacionLocal(Long oid, Integer numNive, Boolean indComu, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setNumeroNiveles(numNive);
	        this.setComunicacion(indComu);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_PARA_GENE_PREM")
	private Long oid;
	@Column(name="NUM_NIVE")
	private Integer numeroNiveles;
	@Column(name="IND_NIVE_ELEG")
	private Boolean nivelElegible;
	@Column(name="IND_PREM_ACUM_NIVE")
	private Boolean premiosAcumulativosNiveles;
	@Column(name="VAL_HAST_NIVE")
	private Integer hastaNivel;
	@Column(name="IND_NIVE_ROTA")
	private Boolean nivelesRotativos;
	@Column(name="NUM_ROTA")
	private Integer numeroRotaciones;
	@Column(name="IND_ACCE_NIVE_SUPE")
	private Boolean accesoNivelSuperior;
	@Column(name="IND_PREM_ELEC")
	private Boolean premiosElectivos;
	@Column(name="IND_PERI_DESP_EXIG")
	private Boolean periodoDespachoExigido;
	@Column(name="NUM_PERI")
	private Integer numeroPeriodos;
	@Column(name="IND_COMU")
	private Boolean comunicacion;
	@Column(name="MENS_OID_MENS")
	private Long mensaje;
	@Column(name="TELE_OID_TIPO_ELEC")
	private Long tipoEleccion;
	@Column(name="TPRM_OID_TIPO_PION")
	private Long tipoPremiacion;
	@Column(name="PERD_OID_PERI")
	private Long periodoDespacho;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
        @Column(name="PERD_OID_PERI_INIC")
        private Long periodoDespachoInicio;
        
        // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
        @Column(name="IND_NOPR_DEFE")
        private Boolean sinPremioPorDefecto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroNiveles() {return numeroNiveles;}
      
	public void setNumeroNiveles(Integer numeroNiveles){this.numeroNiveles=numeroNiveles;}
		
	public Boolean getNivelElegible() {return nivelElegible;}
      
	public void setNivelElegible(Boolean nivelElegible){this.nivelElegible=nivelElegible;}
		
	public Boolean getPremiosAcumulativosNiveles() {return premiosAcumulativosNiveles;}
      
	public void setPremiosAcumulativosNiveles(Boolean premiosAcumulativosNiveles){this.premiosAcumulativosNiveles=premiosAcumulativosNiveles;}
		
	public Integer getHastaNivel() {return hastaNivel;}
      
	public void setHastaNivel(Integer hastaNivel){this.hastaNivel=hastaNivel;}
		
	public Boolean getNivelesRotativos() {return nivelesRotativos;}
      
	public void setNivelesRotativos(Boolean nivelesRotativos){this.nivelesRotativos=nivelesRotativos;}
		
	public Integer getNumeroRotaciones() {return numeroRotaciones;}
      
	public void setNumeroRotaciones(Integer numeroRotaciones){this.numeroRotaciones=numeroRotaciones;}
		
	public Boolean getAccesoNivelSuperior() {return accesoNivelSuperior;}
      
	public void setAccesoNivelSuperior(Boolean accesoNivelSuperior){this.accesoNivelSuperior=accesoNivelSuperior;}
		
	public Boolean getPremiosElectivos() {return premiosElectivos;}
      
	public void setPremiosElectivos(Boolean premiosElectivos){this.premiosElectivos=premiosElectivos;}
		
	public Boolean getPeriodoDespachoExigido() {return periodoDespachoExigido;}
      
	public void setPeriodoDespachoExigido(Boolean periodoDespachoExigido){this.periodoDespachoExigido=periodoDespachoExigido;}
		
	public Integer getNumeroPeriodos() {return numeroPeriodos;}
      
	public void setNumeroPeriodos(Integer numeroPeriodos){this.numeroPeriodos=numeroPeriodos;}
		
	public Boolean getComunicacion() {return comunicacion;}
      
	public void setComunicacion(Boolean comunicacion){this.comunicacion=comunicacion;}
		
	public Long getMensaje() {return mensaje;}
      
	public void setMensaje(Long mensaje){this.mensaje=mensaje;}
		
	public Long getTipoEleccion() {return tipoEleccion;}
      
	public void setTipoEleccion(Long tipoEleccion){this.tipoEleccion=tipoEleccion;}
		
	public Long getTipoPremiacion() {return tipoPremiacion;}
      
	public void setTipoPremiacion(Long tipoPremiacion){this.tipoPremiacion=tipoPremiacion;}
		
	public Long getPeriodoDespacho() {return periodoDespacho;}
      
	public void setPeriodoDespacho(Long periodoDespacho){this.periodoDespacho=periodoDespacho;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
        public Long getPeriodoDespachoInicio() {return periodoDespachoInicio;}
    
        public void setPeriodoDespachoInicio(Long periodoDespachoInicio){this.periodoDespachoInicio=periodoDespachoInicio;}

        public void setSinPremioPorDefecto(Boolean sinPremioPorDefecto) {this.sinPremioPorDefecto = sinPremioPorDefecto;}

        public Boolean getSinPremioPorDefecto() {return sinPremioPorDefecto;}
        
}
