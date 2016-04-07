package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_TARJE")
@NamedQueries({
@NamedQuery(name="ClienteTarjetaLocal.FindAll", query="SELECT OBJECT(o) FROM ClienteTarjetaLocal AS o")
})
public class ClienteTarjetaLocal implements Serializable {

	public ClienteTarjetaLocal() {}

	public ClienteTarjetaLocal(Long oid, Long clie_oid_clie, Long titr_oid_tipo_tarj) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.titr_oid_tipo_tarj = titr_oid_tipo_tarj;
	}

	@Id
	@Column(name="OID_CLIE_TARJ")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TITR_OID_TIPO_TARJ")
	private Long titr_oid_tipo_tarj;
	@Column(name="CLTA_OID_CLAS_TARJ")
	private Long clta_oid_clas_tarj;
	@Column(name="CBAN_OID_BANC")
	private Long cban_oid_banc;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTitr_oid_tipo_tarj() {return titr_oid_tipo_tarj;}
      
	public void setTitr_oid_tipo_tarj(Long titr_oid_tipo_tarj){this.titr_oid_tipo_tarj=titr_oid_tipo_tarj;}
		
	public Long getClta_oid_clas_tarj() {return clta_oid_clas_tarj;}
      
	public void setClta_oid_clas_tarj(Long clta_oid_clas_tarj){this.clta_oid_clas_tarj=clta_oid_clas_tarj;}
		
	public Long getCban_oid_banc() {return cban_oid_banc;}
      
	public void setCban_oid_banc(Long cban_oid_banc){this.cban_oid_banc=cban_oid_banc;}
			
	
}
