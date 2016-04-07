package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_PROBL")
@NamedQueries({
@NamedQuery(name="ClienteProblemaLocal.FindAll", query="SELECT OBJECT(o) FROM ClienteProblemaLocal AS o")
})
public class ClienteProblemaLocal implements Serializable {

	public ClienteProblemaLocal() {}

	public ClienteProblemaLocal(Long oid, Long clie_oid_clie, Long tipb_oid_tipo_prob, Boolean ind_solu) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.tipb_oid_tipo_prob = tipb_oid_tipo_prob;
            this.ind_solu = ind_solu;
	}

	@Id
	@Column(name="OID_CLIE_PROB")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TIPB_OID_TIPO_PROB")
	private Long tipb_oid_tipo_prob;
	@Column(name="VAL_NEGO_PROD")
	private String val_nego_prod;
	@Column(name="DES_PROB")
	private String des_prob;
	@Column(name="TSOC_OID_TIPO_SOLU")
	private Long tsoc_oid_tipo_solu;
	@Column(name="DES_SOLU")
	private String des_solu;
	@Column(name="IND_SOLU")
	private Boolean ind_solu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTipb_oid_tipo_prob() {return tipb_oid_tipo_prob;}
      
	public void setTipb_oid_tipo_prob(Long tipb_oid_tipo_prob){this.tipb_oid_tipo_prob=tipb_oid_tipo_prob;}
		
	public String getVal_nego_prod() {return val_nego_prod;}
      
	public void setVal_nego_prod(String val_nego_prod){this.val_nego_prod=val_nego_prod;}
		
	public String getDes_prob() {return des_prob;}
      
	public void setDes_prob(String des_prob){this.des_prob=des_prob;}
		
	public Long getTsoc_oid_tipo_solu() {return tsoc_oid_tipo_solu;}
      
	public void setTsoc_oid_tipo_solu(Long tsoc_oid_tipo_solu){this.tsoc_oid_tipo_solu=tsoc_oid_tipo_solu;}
		
	public String getDes_solu() {return des_solu;}
      
	public void setDes_solu(String des_solu){this.des_solu=des_solu;}
		
	public Boolean getInd_solu() {return ind_solu;}
      
	public void setInd_solu(Boolean ind_solu){this.ind_solu=ind_solu;}
			
	
}
