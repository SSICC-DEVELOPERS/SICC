package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_ENCUE_APLIC_CLIEN")
@NamedQueries({
@NamedQuery(name="EncuestaAplicadaPorClienteLocal.FindAll",query="select object(o) from EncuestaAplicadaPorClienteLocal o")
})
public class EncuestaAplicadaPorClienteLocal implements Serializable {

	public EncuestaAplicadaPorClienteLocal() {}

	public EncuestaAplicadaPorClienteLocal(Long oid, Long oidCliente, Long oidRespuesta) {
            this.oid = oid;
            this.oidClie = oidCliente;
            this.oidResp = oidRespuesta;
	}

	@Id
	@Column(name="OID_ENCU_APLI_CLIE")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long oidClie;
	@Column(name="REEN_OID_RESP")
	private Long oidResp;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidClie() {return oidClie;}
      
	public void setOidClie(Long oidClie){this.oidClie=oidClie;}
		
	public Long getOidResp() {return oidResp;}
      
	public void setOidResp(Long oidResp){this.oidResp=oidResp;}
			
	
}
