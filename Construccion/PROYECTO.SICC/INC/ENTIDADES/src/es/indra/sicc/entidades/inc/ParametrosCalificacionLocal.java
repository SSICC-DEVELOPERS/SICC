package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PARAM_CALIF")
@NamedQueries({
@NamedQuery(name="ParametrosCalificacionLocal.FindAll",query="select object(o) from ParametrosCalificacionLocal o"),
@NamedQuery(name="ParametrosCalificacionLocal.FindByUK",query="select object(o) from ParametrosCalificacionLocal o where o.concurso = ?1")
})
public class ParametrosCalificacionLocal implements Serializable {

	public ParametrosCalificacionLocal() {}

	public ParametrosCalificacionLocal(Long oid, Boolean indDevo, Boolean indAnul, Boolean indFaltNoAnun, Boolean indMetaModi, Boolean indMetaBloq, Boolean indComuCali, Long perdOidPeriDesd, Long perdOidPeriHast, Long tvcaOidTipoVentCali, Long diriOidDiri, Long copaOidParaGral, Long fcmeOidFormCalcMeta)	{
	
		this.oid=oid;
                this.setDevoluciones(indDevo);
	        this.setAnulaciones(indAnul);
	        this.setFaltantesNoAnunciados(indFaltNoAnun);
	        this.setMetasModificables(indMetaModi);
	        this.setMetasBloqueadas(indMetaBloq);
	        this.setComunicacionCalificacion(indComuCali);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setPeriodoHasta(perdOidPeriHast);
	        this.setTipoVentaCalificacion(tvcaOidTipoVentCali);
	        this.setDirigidoA(diriOidDiri);
	        this.setConcurso(copaOidParaGral);
	        this.setFormaCalculo(fcmeOidFormCalcMeta);
	
	}

	@Id
	@Column(name="OID_PARA_CALI")
	private Long oid;
	@Column(name="IND_DEVO")
	private Boolean devoluciones;
	@Column(name="IND_ANUL")
	private Boolean anulaciones;
	@Column(name="IND_FALT_NO_ANUN")
	private Boolean faltantesNoAnunciados;
	@Column(name="IND_META_MODI")
	private Boolean metasModificables;
	@Column(name="IND_META_BLOQ")
	private Boolean metasBloqueadas;
	@Column(name="IND_COMU_CALI")
	private Boolean comunicacionCalificacion;
	@Column(name="MENS_OID_MENS")
	private Long mensaje;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="TINC_OID_TIPO_INCR")
	private Long tipoIncremento;
	@Column(name="TVCA_OID_TIPO_VENT_CALI")
	private Long tipoVentaCalificacion;
	@Column(name="DIRI_OID_DIRI")
	private Long dirigidoA;
	@Column(name="TVEN_OID_TIPO_VENT")
	private Long tipoVentaHistorica;
	@Column(name="TVIN_OID_TIPO_VENT_INCR")
	private Long tipoVentaIncremental;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="FCME_OID_FORM_CALC_META")
	private Long formaCalculo;
	@Column(name="AGRU_OID_AGRU")
	private Long agrupacion;
	@Column(name="TIDM_OID_TIPO_DETE_META")
	private Long tipoDeterminacionMetas;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getDevoluciones() {return devoluciones;}
      
	public void setDevoluciones(Boolean devoluciones){this.devoluciones=devoluciones;}
		
	public Boolean getAnulaciones() {return anulaciones;}
      
	public void setAnulaciones(Boolean anulaciones){this.anulaciones=anulaciones;}
		
	public Boolean getFaltantesNoAnunciados() {return faltantesNoAnunciados;}
      
	public void setFaltantesNoAnunciados(Boolean faltantesNoAnunciados){this.faltantesNoAnunciados=faltantesNoAnunciados;}
		
	public Boolean getMetasModificables() {return metasModificables;}
      
	public void setMetasModificables(Boolean metasModificables){this.metasModificables=metasModificables;}
		
	public Boolean getMetasBloqueadas() {return metasBloqueadas;}
      
	public void setMetasBloqueadas(Boolean metasBloqueadas){this.metasBloqueadas=metasBloqueadas;}
		
	public Boolean getComunicacionCalificacion() {return comunicacionCalificacion;}
      
	public void setComunicacionCalificacion(Boolean comunicacionCalificacion){this.comunicacionCalificacion=comunicacionCalificacion;}
		
	public Long getMensaje() {return mensaje;}
      
	public void setMensaje(Long mensaje){this.mensaje=mensaje;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getTipoIncremento() {return tipoIncremento;}
      
	public void setTipoIncremento(Long tipoIncremento){this.tipoIncremento=tipoIncremento;}
		
	public Long getTipoVentaCalificacion() {return tipoVentaCalificacion;}
      
	public void setTipoVentaCalificacion(Long tipoVentaCalificacion){this.tipoVentaCalificacion=tipoVentaCalificacion;}
		
	public Long getDirigidoA() {return dirigidoA;}
      
	public void setDirigidoA(Long dirigidoA){this.dirigidoA=dirigidoA;}
		
	public Long getTipoVentaHistorica() {return tipoVentaHistorica;}
      
	public void setTipoVentaHistorica(Long tipoVentaHistorica){this.tipoVentaHistorica=tipoVentaHistorica;}
		
	public Long getTipoVentaIncremental() {return tipoVentaIncremental;}
      
	public void setTipoVentaIncremental(Long tipoVentaIncremental){this.tipoVentaIncremental=tipoVentaIncremental;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getFormaCalculo() {return formaCalculo;}
      
	public void setFormaCalculo(Long formaCalculo){this.formaCalculo=formaCalculo;}
		
	public Long getAgrupacion() {return agrupacion;}
      
	public void setAgrupacion(Long agrupacion){this.agrupacion=agrupacion;}
		
	public Long getTipoDeterminacionMetas() {return tipoDeterminacionMetas;}
      
	public void setTipoDeterminacionMetas(Long tipoDeterminacionMetas){this.tipoDeterminacionMetas=tipoDeterminacionMetas;}
			
	
}
