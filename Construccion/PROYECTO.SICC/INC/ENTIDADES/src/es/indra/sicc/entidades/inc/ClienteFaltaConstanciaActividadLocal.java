package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_FALTA_CONST_ACTIV")
@NamedQueries({
@NamedQuery(name="ClienteFaltaConstanciaActividadLocal.FindAll",query="select object(o) from ClienteFaltaConstanciaActividadLocal o"),
@NamedQuery(name="ClienteFaltaConstanciaActividadLocal.FindByUk",query="SELECT OBJECT (a) "
+ " FROM ClienteFaltaConstanciaActividadLocal AS a "
+ " WHERE a.oidCliente = ?1 "
+ " AND a.oidPeriodo = ?2")
})
public class ClienteFaltaConstanciaActividadLocal implements Serializable {

	public ClienteFaltaConstanciaActividadLocal() {}

	public ClienteFaltaConstanciaActividadLocal(Long oid, Long perdOidPeri, Long clieOidClie)	{
	
		this.oid=oid;
                this.setOidPeriodo(perdOidPeri);
                this.setOidCliente(clieOidClie);
	
	}

	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Id
	@Column(name="OID_CLIE_FALT_CONS_ACTI")
	private Long oid;

	
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
