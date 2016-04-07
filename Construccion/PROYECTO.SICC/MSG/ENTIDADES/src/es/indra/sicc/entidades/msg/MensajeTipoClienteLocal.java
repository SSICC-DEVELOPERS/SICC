package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MENSA_TIPO_CLIEN")
@NamedQueries({
@NamedQuery(name="MensajeTipoClienteLocal.FindByMensaje",query="select Object(i) from MensajeTipoClienteLocal as i where i.mens_oid_mens = ?1")
})
public class MensajeTipoClienteLocal implements Serializable {

	public MensajeTipoClienteLocal() {}

	public MensajeTipoClienteLocal(Long oid, Long mens_oid_mens, Long ticl_oid_tipo_clie)	{
	
		this.oid=oid;
                this.mens_oid_mens=mens_oid_mens;
                this.ticl_oid_tipo_clie=ticl_oid_tipo_clie;
	
	}

	@Id
	@Column(name="OID_MENS_TIPO_CLIE")
	private Long oid;
	@Column(name="MENS_OID_MENS")
	private Long mens_oid_mens;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long ticl_oid_tipo_clie;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tccl_oid_tipo_clas;
	@Column(name="CLAS_OID_CLAS")
	private Long clas_oid_clas;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMens_oid_mens() {return mens_oid_mens;}
      
	public void setMens_oid_mens(Long mens_oid_mens){this.mens_oid_mens=mens_oid_mens;}
		
	public Long getTicl_oid_tipo_clie() {return ticl_oid_tipo_clie;}
      
	public void setTicl_oid_tipo_clie(Long ticl_oid_tipo_clie){this.ticl_oid_tipo_clie=ticl_oid_tipo_clie;}
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
		
	public Long getTccl_oid_tipo_clas() {return tccl_oid_tipo_clas;}
      
	public void setTccl_oid_tipo_clas(Long tccl_oid_tipo_clas){this.tccl_oid_tipo_clas=tccl_oid_tipo_clas;}
		
	public Long getClas_oid_clas() {return clas_oid_clas;}
      
	public void setClas_oid_clas(Long clas_oid_clas){this.clas_oid_clas=clas_oid_clas;}
			
	
}
