package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_VARIA_VENTA_RANKI_CONCU")
@NamedQueries({
@NamedQuery(name="VariablesVentaRankingConcursoLocal.FindAll",query="select object(o) from VariablesVentaRankingConcursoLocal o"),
@NamedQuery(name="VariablesVentaRankingConcursoLocal.FindByConcurso",query="Select OBJECT(a) "
+ " From VariablesVentaRankingConcursoLocal AS a "
+ " where a.oidConcurso = ?1")
})
public class VariablesVentaRankingConcursoLocal implements Serializable {

	public VariablesVentaRankingConcursoLocal() {}

	public VariablesVentaRankingConcursoLocal(Long oid, Long valPeso, Long valDivi, Long oidConcurso, Long oidVariVentRank, Boolean aplicable)	{
	
		this.oid=oid;
                this.setValPeso(valPeso);
	        this.setValDivi(valDivi);
	        this.setOidConcurso(oidConcurso);
	        this.setOidVariVentRank(oidVariVentRank);
	        this.setAplicable(aplicable);
	
	}

	@Column(name="VAL_PESO")
	private Long valPeso;
	@Column(name="VAL_DIVI")
	private Long valDivi;
	@Column(name="NUM_DIAS_COBR")
	private Long numDiasCobr;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long oidConcurso;
	@Column(name="IVVR_OID_VARI_VENT_RANK")
	private Long oidVariVentRank;
	@Id
	@Column(name="OID_VARI_VENT_RANK_CONC")
	private Long oid;
	@Column(name="NUM_APLI")
	private Boolean aplicable;

	
	public Long getValPeso() {return valPeso;}
      
	public void setValPeso(Long valPeso){this.valPeso=valPeso;}
		
	public Long getValDivi() {return valDivi;}
      
	public void setValDivi(Long valDivi){this.valDivi=valDivi;}
		
	public Long getNumDiasCobr() {return numDiasCobr;}
      
	public void setNumDiasCobr(Long numDiasCobr){this.numDiasCobr=numDiasCobr;}
		
	public Long getOidConcurso() {return oidConcurso;}
      
	public void setOidConcurso(Long oidConcurso){this.oidConcurso=oidConcurso;}
		
	public Long getOidVariVentRank() {return oidVariVentRank;}
      
	public void setOidVariVentRank(Long oidVariVentRank){this.oidVariVentRank=oidVariVentRank;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getAplicable() {return aplicable;}
      
	public void setAplicable(Boolean aplicable){this.aplicable=aplicable;}
			
	
}
