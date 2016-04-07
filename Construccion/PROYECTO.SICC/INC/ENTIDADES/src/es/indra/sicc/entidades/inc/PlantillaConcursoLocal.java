package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PLANT_CONCU")
@NamedQueries({
@NamedQuery(name="PlantillaConcursoLocal.FindAll",query="select object(o) from PlantillaConcursoLocal o")
})
public class PlantillaConcursoLocal implements Serializable {

	public PlantillaConcursoLocal() {}

	public PlantillaConcursoLocal(Long oid, Boolean valFaseCali, Long canaOidCana, Long dirigido)	{
	
		this.oid=oid;
	        this.setFaseCalificacion(valFaseCali);
	        this.setCanal(canaOidCana);
	        this.setDirigido(dirigido);
	
	}

	@Id
	@Column(name="OID_PLAN_CONC")
	private Long oid;
	@Column(name="VAL_FASE_CALI")
	private Boolean faseCalificacion;
	@Column(name="VAL_AMBI_GEOG_COMP")
	private Boolean ambitoGeograficoCompleto;
	@Column(name="VAL_PART")
	private Boolean participantesCo;
	@Column(name="IND_PROD_VALI")
	private Boolean productosValidos;
	@Column(name="IND_PROD_EXCL")
	private Boolean productosExcluidos;
	@Column(name="IND_PROD_BONI")
	private Boolean productosBonificados;
	@Column(name="IND_PROD_EXIG")
	private Boolean productosExigidos;
	@Column(name="IND_ACTI")
	private Boolean activa;
	@Column(name="IND_ACUM_NIVE")
	private Boolean acumularNivel;
	@Column(name="IND_NIVE_ROTA")
	private Boolean nivelesRotativos;
	@Column(name="IND_PREM_ELEC")
	private Boolean premiosElectivos;
	@Column(name="IND_PUNT_SERV")
	private Boolean puntajeServicio;
	@Column(name="IND_MULT")
	private Boolean multinivel;
	@Column(name="IND_INCR")
	private Boolean incremental;
	@Column(name="IND_BLOQ")
	private Boolean bloqueado;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="COIV_OID_CONC_IVR")
	private Long tipoConcursoIVR;
	@Column(name="TCAL_OID_TIPO_CALI")
	private Long tipoCalificacion;
	@Column(name="BCAL_OID_BASE_CALC")
	private Long baseCalculo;
	@Column(name="TVEN_OID_TIPO_VENT")
	private Long tipoVenta;
	@Column(name="IND_PROG_NUEV")
	private Boolean programaNuevas;
	@Column(name="DIRI_OID_DIRI")
	private Long dirigido;

        // vbongiov -- Cambio 20080811 -- 26/08/2009
         @Column(name="IND_SORT")
         private Boolean indSorteo;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getFaseCalificacion() {return faseCalificacion;}
      
	public void setFaseCalificacion(Boolean faseCalificacion){this.faseCalificacion=faseCalificacion;}
		
	public Boolean getAmbitoGeograficoCompleto() {return ambitoGeograficoCompleto;}
      
	public void setAmbitoGeograficoCompleto(Boolean ambitoGeograficoCompleto){this.ambitoGeograficoCompleto=ambitoGeograficoCompleto;}
		
	public Boolean getParticipantesCo() {return participantesCo;}
      
	public void setParticipantesCo(Boolean participantesCo){this.participantesCo=participantesCo;}
		
	public Boolean getProductosValidos() {return productosValidos;}
      
	public void setProductosValidos(Boolean productosValidos){this.productosValidos=productosValidos;}
		
	public Boolean getProductosExcluidos() {return productosExcluidos;}
      
	public void setProductosExcluidos(Boolean productosExcluidos){this.productosExcluidos=productosExcluidos;}
		
	public Boolean getProductosBonificados() {return productosBonificados;}
      
	public void setProductosBonificados(Boolean productosBonificados){this.productosBonificados=productosBonificados;}
		
	public Boolean getProductosExigidos() {return productosExigidos;}
      
	public void setProductosExigidos(Boolean productosExigidos){this.productosExigidos=productosExigidos;}
		
	public Boolean getActiva() {return activa;}
      
	public void setActiva(Boolean activa){this.activa=activa;}
		
	public Boolean getAcumularNivel() {return acumularNivel;}
      
	public void setAcumularNivel(Boolean acumularNivel){this.acumularNivel=acumularNivel;}
		
	public Boolean getNivelesRotativos() {return nivelesRotativos;}
      
	public void setNivelesRotativos(Boolean nivelesRotativos){this.nivelesRotativos=nivelesRotativos;}
		
	public Boolean getPremiosElectivos() {return premiosElectivos;}
      
	public void setPremiosElectivos(Boolean premiosElectivos){this.premiosElectivos=premiosElectivos;}
		
	public Boolean getPuntajeServicio() {return puntajeServicio;}
      
	public void setPuntajeServicio(Boolean puntajeServicio){this.puntajeServicio=puntajeServicio;}
		
	public Boolean getMultinivel() {return multinivel;}
      
	public void setMultinivel(Boolean multinivel){this.multinivel=multinivel;}
		
	public Boolean getIncremental() {return incremental;}
      
	public void setIncremental(Boolean incremental){this.incremental=incremental;}
		
	public Boolean getBloqueado() {return bloqueado;}
      
	public void setBloqueado(Boolean bloqueado){this.bloqueado=bloqueado;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public Long getTipoConcursoIVR() {return tipoConcursoIVR;}
      
	public void setTipoConcursoIVR(Long tipoConcursoIVR){this.tipoConcursoIVR=tipoConcursoIVR;}
		
	public Long getTipoCalificacion() {return tipoCalificacion;}
      
	public void setTipoCalificacion(Long tipoCalificacion){this.tipoCalificacion=tipoCalificacion;}
		
	public Long getBaseCalculo() {return baseCalculo;}
      
	public void setBaseCalculo(Long baseCalculo){this.baseCalculo=baseCalculo;}
		
	public Long getTipoVenta() {return tipoVenta;}
      
	public void setTipoVenta(Long tipoVenta){this.tipoVenta=tipoVenta;}
		
	public Boolean getProgramaNuevas() {return programaNuevas;}
      
	public void setProgramaNuevas(Boolean programaNuevas){this.programaNuevas=programaNuevas;}
		
	public Long getDirigido() {return dirigido;}
      
	public void setDirigido(Long dirigido){this.dirigido=dirigido;}
        
        public Boolean getIndSorteo() {return indSorteo;}
        
        public void setIndSorteo(Boolean indSorteo){this.indSorteo=indSorteo;}			
	
}
