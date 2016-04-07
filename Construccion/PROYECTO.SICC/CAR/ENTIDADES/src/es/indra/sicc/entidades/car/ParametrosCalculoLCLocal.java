package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_PARAM_CALCU_LC")
@NamedQueries({
@NamedQuery(name="ParametrosCalculoLCLocal.FindAll",query="select object(o) from ParametrosCalculoLCLocal o"),
@NamedQuery(name="ParametrosCalculoLCLocal.FindByNivelRiesgo",query="SELECT OBJECT(a) "
        + "  FROM ParametrosCalculoLCLocal AS a "
        + "  WHERE  a.niriOidNiveRies = ?1 "
        + "  ORDER BY a.valTope")
})
public class ParametrosCalculoLCLocal implements Serializable {

	public ParametrosCalculoLCLocal() {}

	public ParametrosCalculoLCLocal(Long oidParaCalcLc)	{
	
		this.oidParaCalcLc=oidParaCalcLc;
	
	}

	@Id
	@Column(name="OID_PARA_CALC_LC")
	private Long oidParaCalcLc;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long niriOidNiveRies;
	@Column(name="VAL_TOPE")
	private Double valTope;
	@Column(name="VAL_FACT_CALC")
	private Float valFactCalc;
	@Column(name="IND_VARI_LINE_CRED")
	private String indVariLineCred;

	
	public Long getOidParaCalcLc() {return oidParaCalcLc;}
      
	//public void setOidParaCalcLc(Long oidParaCalcLc){this.oidParaCalcLc=oidParaCalcLc;}
	
	public Long getPrimaryKey() {return oidParaCalcLc;}		
		
	public Long getNiriOidNiveRies() {return niriOidNiveRies;}
      
	public void setNiriOidNiveRies(Long niriOidNiveRies){this.niriOidNiveRies=niriOidNiveRies;}
		
	public Double getValTope() {return valTope;}
      
	public void setValTope(Double valTope){this.valTope=valTope;}
		
	public Float getValFactCalc() {return valFactCalc;}
      
	public void setValFactCalc(Float valFactCalc){this.valFactCalc=valFactCalc;}
		
	public String getIndVariLineCred() {return indVariLineCred;}
      
	public void setIndVariLineCred(String indVariLineCred){this.indVariLineCred=indVariLineCred;}
			
	
}
