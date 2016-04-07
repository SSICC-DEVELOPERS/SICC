package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_ASIGN_EJECU_CUENT")
@NamedQueries({
@NamedQuery(name="AsignacionEjecutivoCuentaLocal.FindByEjecutivo",query="SELECT OBJECT(a) "
          + "  FROM AsignacionEjecutivoCuentaLocal AS a "
          + "  WHERE a.oidEjecutivoCuenta = ?1"),
@NamedQuery(name="AsignacionEjecutivoCuentaLocal.FindBySBGRegZon",query="SELECT OBJECT(a) "
+ " FROM AsignacionEjecutivoCuentaLocal AS a "
+ " WHERE a.oidSubgerencia = ?1 "
+ " AND a.oidRegion = ?2 "
+ " AND a.oidZona = ?3"),
@NamedQuery(name="AsignacionEjecutivoCuentaLocal.FindAll",query="SELECT OBJECT(a) FROM AsignacionEjecutivoCuentaLocal AS a")
})
public class AsignacionEjecutivoCuentaLocal implements Serializable {

	public AsignacionEjecutivoCuentaLocal() {}

	public AsignacionEjecutivoCuentaLocal(Long oid,Long niri_oid_nive_ries, Long zsgv_oid_subg_vent, Long zorg_oid_regi, Long zzon_oid_zona, Long ejcu_oid_ejec_cuen)	{
	
		this.oid=oid;
	        this.setOidNivelRiesgo(niri_oid_nive_ries);
	        this.setOidSubgerencia(zsgv_oid_subg_vent);
	        this.setOidRegion(zorg_oid_regi);
	        this.setOidZona(zzon_oid_zona);
	        this.setOidEjecutivoCuenta(ejcu_oid_ejec_cuen);
	
	}

	@Id
	@Column(name="OID_ASIG_EJEC_CUEN")
	private Long oid;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long oidNivelRiesgo;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long oidSubgerencia;
	@Column(name="ZORG_OID_REGI")
	private Long oidRegion;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Column(name="EJCU_OID_EJEC_CUEN")
	private Long oidEjecutivoCuenta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidNivelRiesgo() {return oidNivelRiesgo;}
      
	public void setOidNivelRiesgo(Long oidNivelRiesgo){this.oidNivelRiesgo=oidNivelRiesgo;}
		
	public Long getOidSubgerencia() {return oidSubgerencia;}
      
	public void setOidSubgerencia(Long oidSubgerencia){this.oidSubgerencia=oidSubgerencia;}
		
	public Long getOidRegion() {return oidRegion;}
      
	public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOidEjecutivoCuenta() {return oidEjecutivoCuenta;}
      
	public void setOidEjecutivoCuenta(Long oidEjecutivoCuenta){this.oidEjecutivoCuenta=oidEjecutivoCuenta;}
			
	
}
