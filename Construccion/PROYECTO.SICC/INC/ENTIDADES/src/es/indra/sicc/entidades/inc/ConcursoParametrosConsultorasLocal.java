package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CONCU_PARAM_CONSU")
@NamedQueries({
@NamedQuery(name="ConcursoParametrosConsultorasLocal.FindAll",query="select object(o) from ConcursoParametrosConsultorasLocal o"),
@NamedQuery(name="ConcursoParametrosConsultorasLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ConcursoParametrosConsultorasLocal AS a "
+ " WHERE a.concurso = ?1"),
@NamedQuery(name="ConcursoParametrosConsultorasLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ConcursoParametrosConsultorasLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ConcursoParametrosConsultorasLocal implements Serializable {

	public ConcursoParametrosConsultorasLocal() {}

	public ConcursoParametrosConsultorasLocal(Long oid, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_CONC_PARA_CONS")
	private Long oid;
	@Column(name="IND_RECO_EFEC")
	private Boolean recomendacionEfectiva;
	@Column(name="VAL_PERI_EVAL")
	private Integer periodosEvaluacion;
	@Column(name="IND_CONT_RECO")
	private Boolean controlRecomendadas;
	@Column(name="NUM_MINI_PEDI")
	private Integer numeroMinimoPedidos;
	@Column(name="NUM_MINI_PEDI_RECO")
	private Integer numeroMinimoPedidosRecomendada;
	@Column(name="IMP_MONT_MINI_PEDI")
	private java.math.BigDecimal montoMinimoPedido;
	@Column(name="NUM_UNID_MINI_PEDI")
	private Integer unidadesMinimasPedido;
	@Column(name="IND_REIN_PIER_PUNT")
	private Boolean reingresoPierdePuntaje;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PERD_OID_PERI_INIC_EVAL")
	private Long periodoInicialEvaluacion;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="TVEN_OID_TIPO_VENT")
	private Long tipoVenta;
	@Column(name="IND_PREM_CAMP_EFEC")
	private Boolean premioCampEfect;
	@Column(name="IND_GENE_PUNT_A_RECO")
	private Boolean generarPuntajeARecomendadas;
	@Column(name="COPA_CONC_PUNT_RECO")
	private Long oidConcursoPuntajeRecomendada;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getRecomendacionEfectiva() {return recomendacionEfectiva;}
      
	public void setRecomendacionEfectiva(Boolean recomendacionEfectiva){this.recomendacionEfectiva=recomendacionEfectiva;}
		
	public Integer getPeriodosEvaluacion() {return periodosEvaluacion;}
      
	public void setPeriodosEvaluacion(Integer periodosEvaluacion){this.periodosEvaluacion=periodosEvaluacion;}
		
	public Boolean getControlRecomendadas() {return controlRecomendadas;}
      
	public void setControlRecomendadas(Boolean controlRecomendadas){this.controlRecomendadas=controlRecomendadas;}
		
	public Integer getNumeroMinimoPedidos() {return numeroMinimoPedidos;}
      
	public void setNumeroMinimoPedidos(Integer numeroMinimoPedidos){this.numeroMinimoPedidos=numeroMinimoPedidos;}
		
	public Integer getNumeroMinimoPedidosRecomendada() {return numeroMinimoPedidosRecomendada;}
      
	public void setNumeroMinimoPedidosRecomendada(Integer numeroMinimoPedidosRecomendada){this.numeroMinimoPedidosRecomendada=numeroMinimoPedidosRecomendada;}
		
	public java.math.BigDecimal getMontoMinimoPedido() {return montoMinimoPedido;}
      
	public void setMontoMinimoPedido(java.math.BigDecimal montoMinimoPedido){this.montoMinimoPedido=montoMinimoPedido;}
		
	public Integer getUnidadesMinimasPedido() {return unidadesMinimasPedido;}
      
	public void setUnidadesMinimasPedido(Integer unidadesMinimasPedido){this.unidadesMinimasPedido=unidadesMinimasPedido;}
		
	public Boolean getReingresoPierdePuntaje() {return reingresoPierdePuntaje;}
      
	public void setReingresoPierdePuntaje(Boolean reingresoPierdePuntaje){this.reingresoPierdePuntaje=reingresoPierdePuntaje;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getPeriodoInicialEvaluacion() {return periodoInicialEvaluacion;}
      
	public void setPeriodoInicialEvaluacion(Long periodoInicialEvaluacion){this.periodoInicialEvaluacion=periodoInicialEvaluacion;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getTipoVenta() {return tipoVenta;}
      
	public void setTipoVenta(Long tipoVenta){this.tipoVenta=tipoVenta;}
		
	public Boolean getPremioCampEfect() {return premioCampEfect;}
      
	public void setPremioCampEfect(Boolean premioCampEfect){this.premioCampEfect=premioCampEfect;}
		
	public Boolean getGenerarPuntajeARecomendadas() {return generarPuntajeARecomendadas;}
      
	public void setGenerarPuntajeARecomendadas(Boolean generarPuntajeARecomendadas){this.generarPuntajeARecomendadas=generarPuntajeARecomendadas;}
		
	public Long getOidConcursoPuntajeRecomendada() {return oidConcursoPuntajeRecomendada;}
      
	public void setOidConcursoPuntajeRecomendada(Long oidConcursoPuntajeRecomendada){this.oidConcursoPuntajeRecomendada=oidConcursoPuntajeRecomendada;}
			
	
}
