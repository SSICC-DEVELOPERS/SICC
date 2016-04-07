package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="MAE_CLIEN_MARCA")
@NamedQueries({
@NamedQuery(name="ClienteMarcaLocal.FindByUK",query="SELECT OBJECT(d) "
+ " FROM ClienteMarcaLocal AS d "
+ " WHERE d.clie_oid_clie = ?1 AND d.marc_oid_marc = ?2"),
@NamedQuery(name="ClienteMarcaLocal.FindAll",query="SELECT OBJECT(d) FROM ClienteMarcaLocal AS d ")
})
public class ClienteMarcaLocal implements Serializable {

	public ClienteMarcaLocal() {}

	public ClienteMarcaLocal(Long oid, Long clie_oid_clie, Long marc_oid_marc, Long ind_ppal, Date fec_ulti_actu) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.marc_oid_marc = marc_oid_marc;
            this.ind_ppal = ind_ppal;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_MARC")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="IND_PPAL")
	private Long ind_ppal;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getInd_ppal() {return ind_ppal;}
      
	public void setInd_ppal(Long ind_ppal){this.ind_ppal=ind_ppal;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
