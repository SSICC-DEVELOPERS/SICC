package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_MULTI")
@NamedQueries({
@NamedQuery(name="MultinivelLocal.FindAll",query="select object(o) from MultinivelLocal o"),
@NamedQuery(name="MultinivelLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM MultinivelLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class MultinivelLocal implements Serializable {

	public MultinivelLocal() {}

	public MultinivelLocal(Long oid, Integer numPeriParaCalc, Integer numPeriSobrCalc, Integer numMiniReco, Boolean indActi, Long copaOidParaGral, Long perdOidPeri, Long perdOidPeriDesd, Long cpreOidCalcPrem)	{
	
		this.oid=oid;
                this.setPeriodosParaCalculo(numPeriParaCalc);
	        this.setPeriodosSobreCalculo(numPeriSobrCalc);
	        this.setNumeroMinimoRecomendadas(numMiniReco);
	        this.setActividad(indActi);
	        this.setConcurso(copaOidParaGral);
	        this.setPeriodoHasta(perdOidPeri);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setCalculoPremio(cpreOidCalcPrem);
	
	}

	@Id
	@Column(name="OID_MULT")
	private Long oid;
	@Column(name="NUM_PERI_PARA_CALC")
	private Integer periodosParaCalculo;
	@Column(name="NUM_PERI_SOBR_CALC")
	private Integer periodosSobreCalculo;
	@Column(name="NUM_MINI_RECO")
	private Integer numeroMinimoRecomendadas;
	@Column(name="IMP_MONT_MINI_PEDI_POR_HIJA")
	private java.math.BigDecimal montoMinimoPedido;
	@Column(name="IND_ACTI")
	private Boolean actividad;
	@Column(name="IMP_MONT_MINI_PEDI_HIJA")
	private java.math.BigDecimal montoMinimoPedidoHijas;
	@Column(name="NUM_UNID_MINI_PEDI_HIJA")
	private Integer unidadesMinimasPedidoHijas;
	@Column(name="IMP_MONT_MINI_RED")
	private java.math.BigDecimal montoMinimoRed;
	@Column(name="NUM_PEDI_MINI_RED")
	private Integer pedidosMinimosRed;
	@Column(name="NUM_UNID_MINI_RED")
	private Integer unidadesMinimasRed;
	@Column(name="IMP_MONT_MINI_MADR")
	private java.math.BigDecimal montoMinimoMadre;
	@Column(name="NUM_PEDI_MINI_MADR")
	private Integer pedidosMinimosMadre;
	@Column(name="NUM_UNID_MINI_MADR")
	private Integer unidadesMinimasMadre;
	@Column(name="NUM_PEDI_MINI_HIJA")
	private Integer pedidosMinimosHijas;
	@Column(name="NUM_UNID_MINI_HIJA")
	private Integer unidadesMinimasHijas;
	@Column(name="VAL_PORC_SOBR_VENT")
	private java.math.BigDecimal porcentajeSobreVenta;
	@Column(name="VAL_PORC_SOBR_COBR")
	private java.math.BigDecimal porcentajeSobreCobranza;
	@Column(name="IND_PAGO_TIEM")
	private Boolean pagoATiempo;
	@Column(name="NUM_DIAS_GRAC")
	private Integer diasGracia;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoHasta;
	@Column(name="PERD_OID_PERI_TIEM_DESD")
	private Long periodoATiempoDesde;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="CPRE_OID_CALC_PREM")
	private Long calculoPremio;
	@Column(name="PERD_OID_PERI_TIEM_HAST")
	private Long periodoATiempoHasta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getPeriodosParaCalculo() {return periodosParaCalculo;}
      
	public void setPeriodosParaCalculo(Integer periodosParaCalculo){this.periodosParaCalculo=periodosParaCalculo;}
		
	public Integer getPeriodosSobreCalculo() {return periodosSobreCalculo;}
      
	public void setPeriodosSobreCalculo(Integer periodosSobreCalculo){this.periodosSobreCalculo=periodosSobreCalculo;}
		
	public Integer getNumeroMinimoRecomendadas() {return numeroMinimoRecomendadas;}
      
	public void setNumeroMinimoRecomendadas(Integer numeroMinimoRecomendadas){this.numeroMinimoRecomendadas=numeroMinimoRecomendadas;}
		
	public java.math.BigDecimal getMontoMinimoPedido() {return montoMinimoPedido;}
      
	public void setMontoMinimoPedido(java.math.BigDecimal montoMinimoPedido){this.montoMinimoPedido=montoMinimoPedido;}
		
	public Boolean getActividad() {return actividad;}
      
	public void setActividad(Boolean actividad){this.actividad=actividad;}
		
	public java.math.BigDecimal getMontoMinimoPedidoHijas() {return montoMinimoPedidoHijas;}
      
	public void setMontoMinimoPedidoHijas(java.math.BigDecimal montoMinimoPedidoHijas){this.montoMinimoPedidoHijas=montoMinimoPedidoHijas;}
		
	public Integer getUnidadesMinimasPedidoHijas() {return unidadesMinimasPedidoHijas;}
      
	public void setUnidadesMinimasPedidoHijas(Integer unidadesMinimasPedidoHijas){this.unidadesMinimasPedidoHijas=unidadesMinimasPedidoHijas;}
		
	public java.math.BigDecimal getMontoMinimoRed() {return montoMinimoRed;}
      
	public void setMontoMinimoRed(java.math.BigDecimal montoMinimoRed){this.montoMinimoRed=montoMinimoRed;}
		
	public Integer getPedidosMinimosRed() {return pedidosMinimosRed;}
      
	public void setPedidosMinimosRed(Integer pedidosMinimosRed){this.pedidosMinimosRed=pedidosMinimosRed;}
		
	public Integer getUnidadesMinimasRed() {return unidadesMinimasRed;}
      
	public void setUnidadesMinimasRed(Integer unidadesMinimasRed){this.unidadesMinimasRed=unidadesMinimasRed;}
		
	public java.math.BigDecimal getMontoMinimoMadre() {return montoMinimoMadre;}
      
	public void setMontoMinimoMadre(java.math.BigDecimal montoMinimoMadre){this.montoMinimoMadre=montoMinimoMadre;}
		
	public Integer getPedidosMinimosMadre() {return pedidosMinimosMadre;}
      
	public void setPedidosMinimosMadre(Integer pedidosMinimosMadre){this.pedidosMinimosMadre=pedidosMinimosMadre;}
		
	public Integer getUnidadesMinimasMadre() {return unidadesMinimasMadre;}
      
	public void setUnidadesMinimasMadre(Integer unidadesMinimasMadre){this.unidadesMinimasMadre=unidadesMinimasMadre;}
		
	public Integer getPedidosMinimosHijas() {return pedidosMinimosHijas;}
      
	public void setPedidosMinimosHijas(Integer pedidosMinimosHijas){this.pedidosMinimosHijas=pedidosMinimosHijas;}
		
	public Integer getUnidadesMinimasHijas() {return unidadesMinimasHijas;}
      
	public void setUnidadesMinimasHijas(Integer unidadesMinimasHijas){this.unidadesMinimasHijas=unidadesMinimasHijas;}
		
	public java.math.BigDecimal getPorcentajeSobreVenta() {return porcentajeSobreVenta;}
      
	public void setPorcentajeSobreVenta(java.math.BigDecimal porcentajeSobreVenta){this.porcentajeSobreVenta=porcentajeSobreVenta;}
		
	public java.math.BigDecimal getPorcentajeSobreCobranza() {return porcentajeSobreCobranza;}
      
	public void setPorcentajeSobreCobranza(java.math.BigDecimal porcentajeSobreCobranza){this.porcentajeSobreCobranza=porcentajeSobreCobranza;}
		
	public Boolean getPagoATiempo() {return pagoATiempo;}
      
	public void setPagoATiempo(Boolean pagoATiempo){this.pagoATiempo=pagoATiempo;}
		
	public Integer getDiasGracia() {return diasGracia;}
      
	public void setDiasGracia(Integer diasGracia){this.diasGracia=diasGracia;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getPeriodoATiempoDesde() {return periodoATiempoDesde;}
      
	public void setPeriodoATiempoDesde(Long periodoATiempoDesde){this.periodoATiempoDesde=periodoATiempoDesde;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getCalculoPremio() {return calculoPremio;}
      
	public void setCalculoPremio(Long calculoPremio){this.calculoPremio=calculoPremio;}
		
	public Long getPeriodoATiempoHasta() {return periodoATiempoHasta;}
      
	public void setPeriodoATiempoHasta(Long periodoATiempoHasta){this.periodoATiempoHasta=periodoATiempoHasta;}
			
	
}
