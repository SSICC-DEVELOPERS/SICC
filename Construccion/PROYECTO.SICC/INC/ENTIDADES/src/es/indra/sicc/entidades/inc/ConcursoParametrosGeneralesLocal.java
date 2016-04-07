package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CONCU_PARAM_GENER")
@NamedQueries({
@NamedQuery(name="ConcursoParametrosGeneralesLocal.FindAll",query="select object(o) from ConcursoParametrosGeneralesLocal o"),
@NamedQuery(name="ConcursoParametrosGeneralesLocal.FindByCamposClave",query="SELECT OBJECT(o) FROM ConcursoParametrosGeneralesLocal AS o "
+ " WHERE o.numeroConcurso = ?1 AND "
+ " o.version = ?2 AND "
+ " o.pais = ?3")
})
public class ConcursoParametrosGeneralesLocal implements Serializable {

	public ConcursoParametrosGeneralesLocal() {}

	public ConcursoParametrosGeneralesLocal(Long oid, String numConc, Integer numVers, Long paisOidPais, String valNomb, Boolean indRank, Long perdOidPeriDesd, Long perdOidPeriHast, Long diriOidDiri, Long marcOidMarc, Long canaOidCana, Boolean indDuplaCyzone)	{
	
		this.oid=oid;
                this.setNumeroConcurso(numConc);
	        this.setVersion(numVers);
	        this.setPais(paisOidPais);
	        this.setNombre(valNomb);
	        this.setRanking(indRank);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setPeriodoHasta(perdOidPeriHast);
	        this.setDirigidoA(diriOidDiri);
	        this.setMarca(marcOidMarc);
	        this.setCanal(canaOidCana);
	        this.setIndDuplaCyzone(indDuplaCyzone);    
	
	}

	@Id
	@Column(name="OID_PARA_GRAL")
	private Long oid;
	@Column(name="NUM_CONC")
	private String numeroConcurso;
	@Column(name="NUM_VERS")
	private Integer version;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="VAL_NOMB")
	private String nombre;
	@Column(name="IND_RANK")
	private Boolean ranking;
	@Column(name="IND_DEVO")
	private Boolean devoluciones;
	@Column(name="IND_ANUL")
	private Boolean anulaciones;
	@Column(name="VAL_FALT_NANU")
	private Boolean faltantesNoAnunciados;
	@Column(name="VAL_EXPR_PUNT")
	private String expresionPuntaje;
	@Column(name="IND_PRUE")
	private Boolean pruebas;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_ACTI")
	private Boolean activo;
	@Column(name="VAL_ESTA_GENE_META")
	private Character statusGeneracionMetas;
	@Column(name="IND_COMU")
	private Boolean comunicacion;
	@Column(name="COD_MENS")
	private String mensaje;
	@Column(name="PLC2_OID_PLAN_CONC")
	private Long plantilla;
	@Column(name="COIV_OID_CONC_IVR")
	private Long tipoConcursoIVR;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="TEXI_OID_TIPO_EXIG")
	private Long tipoExigencia;
	@Column(name="DIRI_OID_DIRI")
	private Long dirigidoA;
	@Column(name="BCAL_OID_BASE_CALC")
	private Long baseCalculo;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="IND_DUPL_CYZO")
	private Boolean indDuplaCyzone;
	@Column(name="ICTP_OID_TIPO_PROG")
	private Long tipoPrograma;
        // vbongiov -- Cambio 20080809 -- 7/04/2009
        @Column(name="IND_NO_GENE_PUNT")
        private Boolean indNoGeneraPunt;
       // vbongiov -- Cambio 20090930 -- 16/07/2009
        @Column(name="CCON_OID_CLAS_CONC")
        private Long oidClasificacionConcurso;

        // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
        @Column(name="TIOC_OID_TIPO_OFER_CONC")
        private Long oidTipoOfertaConcurso;
        
        // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
        @Column(name="IND_MULT_MARC")
        private Boolean indMultiMarca;
        @Column(name="NUM_PUNT_ABON")
        private Long puntosAbonar;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getNumeroConcurso() {return numeroConcurso;}
      
	public void setNumeroConcurso(String numeroConcurso){this.numeroConcurso=numeroConcurso;}
		
	public Integer getVersion() {return version;}
      
	public void setVersion(Integer version){this.version=version;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getNombre() {return nombre;}
      
	public void setNombre(String nombre){this.nombre=nombre;}
		
	public Boolean getRanking() {return ranking;}
      
	public void setRanking(Boolean ranking){this.ranking=ranking;}
		
	public Boolean getDevoluciones() {return devoluciones;}
      
	public void setDevoluciones(Boolean devoluciones){this.devoluciones=devoluciones;}
		
	public Boolean getAnulaciones() {return anulaciones;}
      
	public void setAnulaciones(Boolean anulaciones){this.anulaciones=anulaciones;}
		
	public Boolean getFaltantesNoAnunciados() {return faltantesNoAnunciados;}
      
	public void setFaltantesNoAnunciados(Boolean faltantesNoAnunciados){this.faltantesNoAnunciados=faltantesNoAnunciados;}
		
	public String getExpresionPuntaje() {return expresionPuntaje;}
      
	public void setExpresionPuntaje(String expresionPuntaje){this.expresionPuntaje=expresionPuntaje;}
		
	public Boolean getPruebas() {return pruebas;}
      
	public void setPruebas(Boolean pruebas){this.pruebas=pruebas;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Boolean getActivo() {return activo;}
      
	public void setActivo(Boolean activo){this.activo=activo;}
		
	public Character getStatusGeneracionMetas() {return statusGeneracionMetas;}
      
	public void setStatusGeneracionMetas(Character statusGeneracionMetas){this.statusGeneracionMetas=statusGeneracionMetas;}
		
	public Boolean getComunicacion() {return comunicacion;}
      
	public void setComunicacion(Boolean comunicacion){this.comunicacion=comunicacion;}
		
	public String getMensaje() {return mensaje;}
      
	public void setMensaje(String mensaje){this.mensaje=mensaje;}
		
	public Long getPlantilla() {return plantilla;}
      
	public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
		
	public Long getTipoConcursoIVR() {return tipoConcursoIVR;}
      
	public void setTipoConcursoIVR(Long tipoConcursoIVR){this.tipoConcursoIVR=tipoConcursoIVR;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getTipoExigencia() {return tipoExigencia;}
      
	public void setTipoExigencia(Long tipoExigencia){this.tipoExigencia=tipoExigencia;}
		
	public Long getDirigidoA() {return dirigidoA;}
      
	public void setDirigidoA(Long dirigidoA){this.dirigidoA=dirigidoA;}
		
	public Long getBaseCalculo() {return baseCalculo;}
      
	public void setBaseCalculo(Long baseCalculo){this.baseCalculo=baseCalculo;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public Boolean getIndDuplaCyzone() {return indDuplaCyzone;}
      
	public void setIndDuplaCyzone(Boolean indDuplaCyzone){this.indDuplaCyzone=indDuplaCyzone;}
		
	public Long getTipoPrograma() {return tipoPrograma;}
      
	public void setTipoPrograma(Long tipoPrograma){this.tipoPrograma=tipoPrograma;}
        
        // vbongiov -- Cambio 20080809 -- 7/04/2009
        public Boolean getIndNoGeneraPunt() {return indNoGeneraPunt;}
        
        public void setIndNoGeneraPunt(Boolean indNoGeneraPunt){this.indNoGeneraPunt=indNoGeneraPunt;}
			
        public Long getOidClasificacionConcurso() {return oidClasificacionConcurso;}
        
        public void setOidClasificacionConcurso(Long oidClasificacionConcurso){this.oidClasificacionConcurso=oidClasificacionConcurso;}

        public void setOidTipoOfertaConcurso(Long oidTipoOfertaConcurso) {this.oidTipoOfertaConcurso = oidTipoOfertaConcurso;}

        public Long getOidTipoOfertaConcurso() {return oidTipoOfertaConcurso;}

        public void setIndMultiMarca(Boolean indMultiMarca) {
            this.indMultiMarca = indMultiMarca;
        }
    
        public Boolean getIndMultiMarca() {
            return indMultiMarca;
        }
    
        public void setPuntosAbonar(Long puntosAbonar) {
            this.puntosAbonar = puntosAbonar;
        }
    
        public Long getPuntosAbonar() {
            return puntosAbonar;
        }
        
}
