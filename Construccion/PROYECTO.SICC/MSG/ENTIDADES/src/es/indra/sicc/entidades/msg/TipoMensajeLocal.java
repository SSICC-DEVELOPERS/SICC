package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_TIPO_MENSA")
public class TipoMensajeLocal implements Serializable {

	public TipoMensajeLocal() {}

	public TipoMensajeLocal(Long oid,String newCodigoTipoMensaje)	{
	
		this.oid=oid;
	        this.codigoTipoMensaje=newCodigoTipoMensaje;
	}

	@Id
	@Column(name="OID_TIPO_MENS")
	private Long oid;
	@Column(name="COD_TIPO_MENS")
	private String codigoTipoMensaje;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoMensaje() {return codigoTipoMensaje;}
      
	public void setCodigoTipoMensaje(String codigoTipoMensaje){this.codigoTipoMensaje=codigoTipoMensaje;}
			
	
}
