package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_MOTIV_TIPO_CLIEN")
@NamedQueries({
 @NamedQuery(name="MotivoTipoClienteLocal.FindAll",query="SELECT OBJECT(a) FROM MotivoTipoClienteLocal AS a")
})
public class MotivoTipoClienteLocal implements Serializable {

	public MotivoTipoClienteLocal() {}

	public MotivoTipoClienteLocal(Long oid, Long ticl_oid_tipo_clie, Long moco_oid, Long pais_oid_pais)	{
	
		this.oid=oid;
	        setOidTipoCliente(ticl_oid_tipo_clie);
	        setOidMotivo(moco_oid);
	        setPais(pais_oid_pais);
	
	}

	@Id
	@Column(name="OID_MOTI_TIPO_CLIE")
	private Long oid;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long oidTipoCliente;
	@Column(name="MOCO_OID")
	private Long oidMotivo;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidTipoCliente() {return oidTipoCliente;}
      
	public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
		
	public Long getOidMotivo() {return oidMotivo;}
      
	public void setOidMotivo(Long oidMotivo){this.oidMotivo=oidMotivo;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
