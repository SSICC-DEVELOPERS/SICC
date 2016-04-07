package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_REQUI_PREMI")
@NamedQueries({
@NamedQuery(name="RequisitosPremiacionLocal.FindAll",query="select object(o) from RequisitosPremiacionLocal o"),
@NamedQuery(name="RequisitosPremiacionLocal.FindByUK",query="SELECT OBJECT(a)  "
+ " FROM RequisitosPremiacionLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class RequisitosPremiacionLocal implements Serializable {

	public RequisitosPremiacionLocal() {}

	public RequisitosPremiacionLocal(Long oid, Boolean indPediPeri, Boolean indPagoTiem, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setPedidoEnPeriodo(indPediPeri);
	        this.setPagoATiempo(indPagoTiem);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_REQU_PREM")
	private Long oid;
	@Column(name="VAL_MONT_MINI_CONC")
	private java.math.BigDecimal montoMinimoConcurso;
	@Column(name="NUM_PEDI")
	private Integer numeroPedidos;
	@Column(name="VAL_CUOT_INGR")
	private Integer cuotaIngreso;
	@Column(name="IND_PEDI_PERI")
	private Boolean pedidoEnPeriodo;
	@Column(name="VAL_MONT_MINI_PEDI")
	private java.math.BigDecimal montoMinimoPedido;
	@Column(name="IND_PAGO_TIEM")
	private Boolean pagoATiempo;
	@Column(name="NUM_DIAS_GRAC")
	private Integer diasGracia;
	@Column(name="IND_ASIS_CURS")
	private Boolean asistenciaCurso;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoHasta;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
    //Agregado por cambio 20090929        
       @Column(name="NUM_PERI_ESPE_PAGO")
       private Long numPerioEspe;
       @Column(name="PERD_OID_PERI_MAXI")
       private Long periodoMaxi;
       @Column(name="VADE_OID_VALI_DEUD")
       private Long oidValidaDeuda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoMinimoConcurso() {return montoMinimoConcurso;}
      
	public void setMontoMinimoConcurso(java.math.BigDecimal montoMinimoConcurso){this.montoMinimoConcurso=montoMinimoConcurso;}
		
	public Integer getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Integer numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Integer getCuotaIngreso() {return cuotaIngreso;}
      
	public void setCuotaIngreso(Integer cuotaIngreso){this.cuotaIngreso=cuotaIngreso;}
		
	public Boolean getPedidoEnPeriodo() {return pedidoEnPeriodo;}
      
	public void setPedidoEnPeriodo(Boolean pedidoEnPeriodo){this.pedidoEnPeriodo=pedidoEnPeriodo;}
		
	public java.math.BigDecimal getMontoMinimoPedido() {return montoMinimoPedido;}
      
	public void setMontoMinimoPedido(java.math.BigDecimal montoMinimoPedido){this.montoMinimoPedido=montoMinimoPedido;}
		
	public Boolean getPagoATiempo() {return pagoATiempo;}
      
	public void setPagoATiempo(Boolean pagoATiempo){this.pagoATiempo=pagoATiempo;}
		
	public Integer getDiasGracia() {return diasGracia;}
      
	public void setDiasGracia(Integer diasGracia){this.diasGracia=diasGracia;}
		
	public Boolean getAsistenciaCurso() {return asistenciaCurso;}
      
	public void setAsistenciaCurso(Boolean asistenciaCurso){this.asistenciaCurso=asistenciaCurso;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
        
    //Agregado por cambio 20090929
         
        public Long getNumPerioEspe() {return numPerioEspe;}
          
        public void setNumPerioEspe(Long numPerioEspe){this.numPerioEspe=numPerioEspe;}
          
        public Long getPeriodoMaxi() {return periodoMaxi;}
         
        public void setPeriodoMaxi(Long periodoMaxi){this.periodoMaxi=periodoMaxi;}
     
        public Long getOidValidaDeuda() {return oidValidaDeuda;}
         
        public void setOidValidaDeuda(Long oidValidaDeuda){this.oidValidaDeuda=oidValidaDeuda;}

			
	
}
