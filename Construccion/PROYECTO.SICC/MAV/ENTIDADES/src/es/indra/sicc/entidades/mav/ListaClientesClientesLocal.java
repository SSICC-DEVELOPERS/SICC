package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_LISTA_CLIEN_CLIEN")
public class ListaClientesClientesLocal implements Serializable {

	public ListaClientesClientesLocal() {}

	public ListaClientesClientesLocal(Long oid, Long oidListaCliente, Long oidCliente)	{
	
		this.oid=oid;
                this.oidListaClientes=oidListaCliente;
                this.oidCliente=oidCliente;                
	
	}

	@Id
	@Column(name="OID_LIST_CLIE_CLIE")
	private Long oid;
	@Column(name="LICL_OID_LISTA_CLIE")
	private Long oidListaClientes;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidListaClientes() {return oidListaClientes;}
      
	public void setOidListaClientes(Long oidListaClientes){this.oidListaClientes=oidListaClientes;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
			
	
}
