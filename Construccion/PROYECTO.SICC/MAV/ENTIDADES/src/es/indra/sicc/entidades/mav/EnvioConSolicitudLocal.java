package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ENVIO_SOLIC")
public class EnvioConSolicitudLocal implements Serializable {

	public EnvioConSolicitudLocal() {}

	public EnvioConSolicitudLocal(Long oid, String descripcion)	{
	
		this.oid=oid;
                this.descripcion = descripcion;
	
	}

	@Id
	@Column(name="OID_ENVI_SOLI")
	private Long oid;
	@Column(name="DES_ENVI_SOLI")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
