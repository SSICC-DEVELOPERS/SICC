package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_NIVEL_RIESG")
public class NivelesRiesgoLocal implements Serializable {

	public NivelesRiesgoLocal() {}

	public NivelesRiesgoLocal(Long oid, String cod_nive_ries)	{
	
		this.oid=oid;
                this.setCodigoNivelRiesgo(cod_nive_ries);
	
	}

	@Id
	@Column(name="OID_NIVE_RIES")
	private Long oid;
	@Column(name="COD_NIVE_RIES")
	private String codigoNivelRiesgo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoNivelRiesgo() {return codigoNivelRiesgo;}
      
	public void setCodigoNivelRiesgo(String codigoNivelRiesgo){this.codigoNivelRiesgo=codigoNivelRiesgo;}
			
	
}
