package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_INDIC_VALID")
public class IndicadorValidacionLocal implements Serializable {

	public IndicadorValidacionLocal() {}

	public IndicadorValidacionLocal(Long oid, String cod_indi_vali)	{
	
		this.oid=oid;
                this.setCodigoIndicadirValidacion(cod_indi_vali);
	
	}

	@Id
	@Column(name="OID_INDI_VALI")
	private Long oid;
	@Column(name="COD_INDI_VALI")
	private String codigoIndicadirValidacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoIndicadirValidacion() {return codigoIndicadirValidacion;}
      
	public void setCodigoIndicadirValidacion(String codigoIndicadirValidacion){this.codigoIndicadirValidacion=codigoIndicadirValidacion;}
			
	
}
