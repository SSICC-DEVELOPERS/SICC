package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_CONDI_EVALU_NR")
public class CondicionesEvaluacionNRLocal implements Serializable {

	public CondicionesEvaluacionNRLocal() {}

	public CondicionesEvaluacionNRLocal(Long oid, Long penr_oid_para_eval_nr, Double val_mini, Double val_esca_mini)	{
	
		this.oid=oid;
	        this.setOidParametroEvaluacionNR(penr_oid_para_eval_nr);
	        this.setValorMinimo(val_mini);
	        this.setEscalaMinima(val_esca_mini);
	
	}

	@Id
	@Column(name="OID_COND_EVAL_NR")
	private Long oid;
	@Column(name="PENR_OID_PARA_EVAL_NR")
	private Long oidParametroEvaluacionNR;
	@Column(name="VAL_MINI")
	private Double valorMinimo;
	@Column(name="VAL_MAXI")
	private Double valorMaximo;
	@Column(name="VAL_ESCA_MINI")
	private Double escalaMinima;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidParametroEvaluacionNR() {return oidParametroEvaluacionNR;}
      
	public void setOidParametroEvaluacionNR(Long oidParametroEvaluacionNR){this.oidParametroEvaluacionNR=oidParametroEvaluacionNR;}
		
	public Double getValorMinimo() {return valorMinimo;}
      
	public void setValorMinimo(Double valorMinimo){this.valorMinimo=valorMinimo;}
		
	public Double getValorMaximo() {return valorMaximo;}
      
	public void setValorMaximo(Double valorMaximo){this.valorMaximo=valorMaximo;}
		
	public Double getEscalaMinima() {return escalaMinima;}
      
	public void setEscalaMinima(Double escalaMinima){this.escalaMinima=escalaMinima;}
			
	
}
