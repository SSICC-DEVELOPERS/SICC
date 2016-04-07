package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CONCU_PARAM_GEREN")
@NamedQueries({
@NamedQuery(name="ConcursoParametrosGerentesLocal.FindAll",query="select object(o) from ConcursoParametrosGerentesLocal o"),
@NamedQuery(name="ConcursoParametrosGerentesLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM ConcursoParametrosGerentesLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ConcursoParametrosGerentesLocal implements Serializable {

	public ConcursoParametrosGerentesLocal() {}

	public ConcursoParametrosGerentesLocal(Long oid, Long copaOidParaGral, Long fcalOidFormCalc)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setFormaCalculo(fcalOidFormCalc);        
	
	}

	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="VAL_RECO_EFEC")
	private Boolean recomendacionEfectiva;
	@Column(name="VAL_PERI_EVAL")
	private Integer periodosEvaluacion;
	@Column(name="NUM_MINI_PEDI")
	private Integer numeroMinimoPedidos;
	@Column(name="NUM_MINI_PEDI_RECO")
	private Integer numeroMinimoPedidosRecomendada;
	@Id
	@Column(name="OID_CONC_PARA_GERE")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long periodoInicialEvaluacion;
	@Column(name="TVEN_OID_TIPO_VENT")
	private Long tipoVenta;
	@Column(name="FCAL_OID_FORM_CALC")
	private Long formaCalculo;

	
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Boolean getRecomendacionEfectiva() {return recomendacionEfectiva;}
      
	public void setRecomendacionEfectiva(Boolean recomendacionEfectiva){this.recomendacionEfectiva=recomendacionEfectiva;}
		
	public Integer getPeriodosEvaluacion() {return periodosEvaluacion;}
      
	public void setPeriodosEvaluacion(Integer periodosEvaluacion){this.periodosEvaluacion=periodosEvaluacion;}
		
	public Integer getNumeroMinimoPedidos() {return numeroMinimoPedidos;}
      
	public void setNumeroMinimoPedidos(Integer numeroMinimoPedidos){this.numeroMinimoPedidos=numeroMinimoPedidos;}
		
	public Integer getNumeroMinimoPedidosRecomendada() {return numeroMinimoPedidosRecomendada;}
      
	public void setNumeroMinimoPedidosRecomendada(Integer numeroMinimoPedidosRecomendada){this.numeroMinimoPedidosRecomendada=numeroMinimoPedidosRecomendada;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPeriodoInicialEvaluacion() {return periodoInicialEvaluacion;}
      
	public void setPeriodoInicialEvaluacion(Long periodoInicialEvaluacion){this.periodoInicialEvaluacion=periodoInicialEvaluacion;}
		
	public Long getTipoVenta() {return tipoVenta;}
      
	public void setTipoVenta(Long tipoVenta){this.tipoVenta=tipoVenta;}
		
	public Long getFormaCalculo() {return formaCalculo;}
      
	public void setFormaCalculo(Long formaCalculo){this.formaCalculo=formaCalculo;}
			
	
}
