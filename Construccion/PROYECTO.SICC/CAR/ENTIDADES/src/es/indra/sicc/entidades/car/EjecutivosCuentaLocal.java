package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_EJECU_CUENT")
public class EjecutivosCuentaLocal implements Serializable {

	public EjecutivosCuentaLocal() {}

	public EjecutivosCuentaLocal(Long oid, Long pais_oid_pais, Long cod_ejec_cuen)	{
	
		this.oid=oid;
	        this.setOidPais(pais_oid_pais);
	        this.setCodigoEjecutivoCuenta(cod_ejec_cuen);
	
	}

	@Id
	@Column(name="OID_EJEC_CUEN")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="USER_EJEC_CUEN")
	private Long codigoEjecutivoCuenta;
	@Column(name="JERA_OID_JERA")
	private Long oidJerarquia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getCodigoEjecutivoCuenta() {return codigoEjecutivoCuenta;}
      
	public void setCodigoEjecutivoCuenta(Long codigoEjecutivoCuenta){this.codigoEjecutivoCuenta=codigoEjecutivoCuenta;}
		
	public Long getOidJerarquia() {return oidJerarquia;}
      
	public void setOidJerarquia(Long oidJerarquia){this.oidJerarquia=oidJerarquia;}
			
	
}
