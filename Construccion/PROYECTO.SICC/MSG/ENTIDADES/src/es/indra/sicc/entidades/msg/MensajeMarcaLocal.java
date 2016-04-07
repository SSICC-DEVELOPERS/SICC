package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MENSA_MARCA")
@NamedQueries({
@NamedQuery(name="MensajeMarcaLocal.FindByMensajeM",query="select Object(i) from MensajeMarcaLocal as i where i.oidMensaje = ?1")
})
public class MensajeMarcaLocal implements Serializable {

	public MensajeMarcaLocal() {}

	public MensajeMarcaLocal(Long oid ,Long oid_Marca, Long oid_Mensaje)	{
	
		this.oid=oid;
                this.oidMarca=oid_Marca;
                this.oidMensaje=oid_Mensaje;
	}

	@Id
	@Column(name="OID_MENS_MARC")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="MENS_OID_MENS")
	private Long oidMensaje;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidMensaje() {return oidMensaje;}
      
	public void setOidMensaje(Long oidMensaje){this.oidMensaje=oidMensaje;}
			
	
}
