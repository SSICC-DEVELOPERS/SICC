package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_PREFE")
@NamedQueries({
@NamedQuery(name="ClientePreferenciaLocal.FindAll", query="SELECT OBJECT(o) FROM ClientePreferenciaLocal AS o")
})
public class ClientePreferenciaLocal implements Serializable {

	public ClientePreferenciaLocal() {}

	public ClientePreferenciaLocal(Long oid, Long clie_oid_clie, Long tipf_oid_tipo_pref)	{
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.tipf_oid_tipo_pref = tipf_oid_tipo_pref;
	}

	@Id
	@Column(name="OID_CLIE_PREF")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TIPF_OID_TIPO_PREF")
	private Long tipf_oid_tipo_pref;
	@Column(name="DES_CLIE_PREF")
	private String des_clie_pref;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTipf_oid_tipo_pref() {return tipf_oid_tipo_pref;}
      
	public void setTipf_oid_tipo_pref(Long tipf_oid_tipo_pref){this.tipf_oid_tipo_pref=tipf_oid_tipo_pref;}
		
	public String getDes_clie_pref() {return des_clie_pref;}
      
	public void setDes_clie_pref(String des_clie_pref){this.des_clie_pref=des_clie_pref;}
			
	
}
