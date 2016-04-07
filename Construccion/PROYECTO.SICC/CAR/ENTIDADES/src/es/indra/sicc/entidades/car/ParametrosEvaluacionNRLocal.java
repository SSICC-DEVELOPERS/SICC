package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_PARAM_EVALU_NR")
public class ParametrosEvaluacionNRLocal implements Serializable {

	public ParametrosEvaluacionNRLocal() {}

	public ParametrosEvaluacionNRLocal(Long oid, String cod_para)	{
	
		this.oid=oid;
                this.setCodigoParametro(cod_para);
	
	}

	@Id
	@Column(name="OID_PARA_EVAL_NR")
	private Long oid;
	@Column(name="COD_PARA")
	private String codigoParametro;
	@Column(name="VAL_PESO")
	private Float peso;
	@Column(name="DES_PARA")
	private String descripcionParametro;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoParametro() {return codigoParametro;}
      
	public void setCodigoParametro(String codigoParametro){this.codigoParametro=codigoParametro;}
		
	public Float getPeso() {return peso;}
      
	public void setPeso(Float peso){this.peso=peso;}
		
	public String getDescripcionParametro() {return descripcionParametro;}
      
	public void setDescripcionParametro(String descripcionParametro){this.descripcionParametro=descripcionParametro;}
			
	
}
