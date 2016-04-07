package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PARAM_RANKI")
@NamedQueries({
@NamedQuery(name="ParametrosRankingLocal.FindAll",query="select object(o) from ParametrosRankingLocal o"),
@NamedQuery(name="ParametrosRankingLocal.FindByUK",query="SELECT OBJECT(o) FROM ParametrosRankingLocal o WHERE o.copaOidParaGral = ?1")
})
public class ParametrosRankingLocal implements Serializable {

	public ParametrosRankingLocal() {}

	public ParametrosRankingLocal(Long oid, Long oidConcurso, Long oidPeri, Long oidPeriPrem, Long oidTipoRank, Long agraOidAgruRank)	{
	
		this.oid=oid;
                this.setCopaOidParaGral(oidConcurso);
	        this.setPerdOidPeri(oidPeri);
	        this.setPerdOidPeriPrem(oidPeriPrem);
	        this.setTprkOidTipoRank(oidTipoRank);
	        this.setAgraOidAgruRank(agraOidAgruRank);
	
	}

	@Column(name="AGRA_OID_AGRU_RANK")
	private Long agraOidAgruRank;
	@Column(name="IND_EVAL_CONS")
	private Long indEvalCons;
	@Column(name="IND_EVAL_ACTI")
	private Long indEvalActi;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long copaOidParaGral;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;
	@Column(name="PERD_OID_PERI_PREM")
	private Long perdOidPeriPrem;
	@Column(name="TPRK_OID_TIPO_RANK")
	private Long tprkOidTipoRank;
	@Id
	@Column(name="OID_PARA_RANK")
	private Long oid;

	
	public Long getAgraOidAgruRank() {return agraOidAgruRank;}
      
	public void setAgraOidAgruRank(Long agraOidAgruRank){this.agraOidAgruRank=agraOidAgruRank;}
		
	public Long getIndEvalCons() {return indEvalCons;}
      
	public void setIndEvalCons(Long indEvalCons){this.indEvalCons=indEvalCons;}
		
	public Long getIndEvalActi() {return indEvalActi;}
      
	public void setIndEvalActi(Long indEvalActi){this.indEvalActi=indEvalActi;}
		
	public Long getCopaOidParaGral() {return copaOidParaGral;}
      
	public void setCopaOidParaGral(Long copaOidParaGral){this.copaOidParaGral=copaOidParaGral;}
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
		
	public Long getPerdOidPeriPrem() {return perdOidPeriPrem;}
      
	public void setPerdOidPeriPrem(Long perdOidPeriPrem){this.perdOidPeriPrem=perdOidPeriPrem;}
		
	public Long getTprkOidTipoRank() {return tprkOidTipoRank;}
      
	public void setTprkOidTipoRank(Long tprkOidTipoRank){this.tprkOidTipoRank=tprkOidTipoRank;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
