package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_CODIG_APROB")
public class CodigosAprobacionLocal implements Serializable {

	public CodigosAprobacionLocal() {}

	public CodigosAprobacionLocal(Long oid, String cod_apro)	{
	
		this.oid=oid;
	        this.setCodigoAprobacion(cod_apro);
	
	}

	@Id
	@Column(name="OID_CODI_APRO")
	private Long oid;
	@Column(name="COD_APRO")
	private String codigoAprobacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoAprobacion() {return codigoAprobacion;}
      
	public void setCodigoAprobacion(String codigoAprobacion){this.codigoAprobacion=codigoAprobacion;}
			
	
}
