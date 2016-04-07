package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CANDI_GANAD")
@NamedQueries({
@NamedQuery(name="CandidataGanadoraLocal.FindAll",query="select object(o) from CandidataGanadoraLocal o"),
@NamedQuery(name="CandidataGanadoraLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM CandidataGanadoraLocal AS a "
+ " WHERE a.concurso = ?1 "
+ " AND a.ganadora = ?2 "
+ " AND a.periodo = ?3"),
@NamedQuery(name="CandidataGanadoraLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM CandidataGanadoraLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class CandidataGanadoraLocal implements Serializable {

	public CandidataGanadoraLocal() {}

	public CandidataGanadoraLocal(Long oid, Boolean indMetaSupe, Boolean valRequPremSupe, Long perdOidPeri, Long copaOidParaGral, Long clieOidClie)	{
	
		this.oid=oid;
                this.setMetasSuperadas(indMetaSupe);
	        this.setRequisitosPremiacionSuperados(valRequPremSupe);
	        this.setPeriodo(perdOidPeri);
	        this.setConcurso(copaOidParaGral);
	        this.setGanadora(clieOidClie);
	
	}

	@Id
	@Column(name="OID_CAND_GANA")
	private Long oid;
	@Column(name="IND_META_SUPE")
	private Boolean metasSuperadas;
	@Column(name="VAL_REQU_PREM_SUPE")
	private Boolean requisitosPremiacionSuperados;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="BINC_OID_BASE_INCU")
	private Long baseIncumplida;
	@Column(name="PERD_OID_PERI_EVAL")
	private Long ultimoPeriodoEvaluado;
	@Column(name="CLIE_OID_CLIE")
	private Long ganadora;
	@Column(name="NUM_PERI_EVAL")
	private Integer numeroPeiodosEvaluados;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getMetasSuperadas() {return metasSuperadas;}
      
	public void setMetasSuperadas(Boolean metasSuperadas){this.metasSuperadas=metasSuperadas;}
		
	public Boolean getRequisitosPremiacionSuperados() {return requisitosPremiacionSuperados;}
      
	public void setRequisitosPremiacionSuperados(Boolean requisitosPremiacionSuperados){this.requisitosPremiacionSuperados=requisitosPremiacionSuperados;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getBaseIncumplida() {return baseIncumplida;}
      
	public void setBaseIncumplida(Long baseIncumplida){this.baseIncumplida=baseIncumplida;}
		
	public Long getUltimoPeriodoEvaluado() {return ultimoPeriodoEvaluado;}
      
	public void setUltimoPeriodoEvaluado(Long ultimoPeriodoEvaluado){this.ultimoPeriodoEvaluado=ultimoPeriodoEvaluado;}
		
	public Long getGanadora() {return ganadora;}
      
	public void setGanadora(Long ganadora){this.ganadora=ganadora;}
		
	public Integer getNumeroPeiodosEvaluados() {return numeroPeiodosEvaluados;}
      
	public void setNumeroPeiodosEvaluados(Integer numeroPeiodosEvaluados){this.numeroPeiodosEvaluados=numeroPeiodosEvaluados;}
			
	
}
