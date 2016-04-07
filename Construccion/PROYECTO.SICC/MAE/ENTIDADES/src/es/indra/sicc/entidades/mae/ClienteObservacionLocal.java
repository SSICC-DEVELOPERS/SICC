package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_OBSER")
@NamedQueries({
@NamedQuery(name="ClienteObservacionLocal.FindAll", query="SELECT OBJECT(o) FROM ClienteObservacionLocal AS o")
})
public class ClienteObservacionLocal implements Serializable {

	public ClienteObservacionLocal() {}

	public ClienteObservacionLocal(Long oid, Long marc_oid_marc, Long clie_oid_clie, Long num_obse, String val_text) {
            this.oid=oid;
            this.marc_oid_marc = marc_oid_marc;
            this.clie_oid_clie = clie_oid_clie;
            this.num_obse = num_obse;
            this.val_text = val_text;
	}

	@Id
	@Column(name="OID_OBSE")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="NUM_OBSE")
	private Long num_obse;
	@Column(name="VAL_TEXT")
	private String val_text;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getNum_obse() {return num_obse;}
      
	public void setNum_obse(Long num_obse){this.num_obse=num_obse;}
		
	public String getVal_text() {return val_text;}
      
	public void setVal_text(String val_text){this.val_text=val_text;}
			
	
}
