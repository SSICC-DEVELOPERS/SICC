package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_CANAL_BPS")
@NamedQueries({
@NamedQuery(name="CanalBPSLocal.FindAll",query="select object(o) from CanalBPSLocal o"),
@NamedQuery(name="CanalBPSLocal.FindByUk",query="SELECT OBJECT(o) FROM  CanalBPSLocal o WHERE o.tipoCliente = ?1 AND o.tipoSolicitudPais = ?2")
})
public class CanalBPSLocal implements Serializable {

	public CanalBPSLocal() {}

	public CanalBPSLocal(Long oid, String canalBPS, Long tipoCliente, Long tipoSolicitud)	{
            this.oid=oid;
            this.canalBPS = canalBPS;
	    this.tipoCliente = tipoCliente;
	    this.tipoSolicitudPais = tipoSolicitud;
	}

	@Id
	@Column(name="OID_CANA_BPS")
	private Long oid;
	@Column(name="VAL_CANA_BPS")
	private String canalBPS;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitudPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCanalBPS() {return canalBPS;}
      
	public void setCanalBPS(String canalBPS){this.canalBPS=canalBPS;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getTipoSolicitudPais() {return tipoSolicitudPais;}
      
	public void setTipoSolicitudPais(Long tipoSolicitudPais){this.tipoSolicitudPais=tipoSolicitudPais;}
			
	
}
