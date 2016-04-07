package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ESTAD_MAV")
public class EstadosMAVLocal implements Serializable {

	public EstadosMAVLocal() {}

	public EstadosMAVLocal(Long oid, Long oidPais)	{
	
		this.oid=oid;
                this.oidPais=oidPais;
	
	}

	@Id
	@Column(name="OID_ESTA_MAV")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="IND_ACTI")
	private Boolean activo;
	@Column(name="IND_NO_ACTI")
	private Boolean noActivo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Boolean getActivo() {return activo;}
      
	public void setActivo(Boolean activo){this.activo=activo;}
		
	public Boolean getNoActivo() {return noActivo;}
      
	public void setNoActivo(Boolean noActivo){this.noActivo=noActivo;}
			
	
}
