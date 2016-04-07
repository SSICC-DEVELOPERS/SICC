package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_PARAM_NR")
public class ParametrosNRLocal implements Serializable {

	public ParametrosNRLocal() {}

	public ParametrosNRLocal(Long oid, Long niri_oid_nive_ries, Double val_mini)	{
	
		this.oid=oid;
	        this.setOidNivelRiesgo(niri_oid_nive_ries);
	        this.setValorMinimo(val_mini);
	
	}

	@Id
	@Column(name="OID_PARA_NR")
	private Long oid;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long oidNivelRiesgo;
	@Column(name="VAL_MINI")
	private Double valorMinimo;
	@Column(name="VAL_MAXI")
	private Double valorMaximo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidNivelRiesgo() {return oidNivelRiesgo;}
      
	public void setOidNivelRiesgo(Long oidNivelRiesgo){this.oidNivelRiesgo=oidNivelRiesgo;}
		
	public Double getValorMinimo() {return valorMinimo;}
      
	public void setValorMinimo(Double valorMinimo){this.valorMinimo=valorMinimo;}
		
	public Double getValorMaximo() {return valorMaximo;}
      
	public void setValorMaximo(Double valorMaximo){this.valorMaximo=valorMaximo;}
			
	
}
