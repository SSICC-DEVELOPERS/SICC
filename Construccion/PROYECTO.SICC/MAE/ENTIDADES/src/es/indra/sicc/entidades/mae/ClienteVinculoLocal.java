package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="MAE_CLIEN_VINCU")
@NamedQueries({
@NamedQuery(name="ClienteVinculoLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM ClienteVinculoLocal AS o "
+ " WHERE o.clie_oid_clie_vnte = ?1 "
+ " AND o.clie_oid_clie_vndo = ?2 "
+ " AND o.tivc_oid_tipo_vinc = ?3"),
@NamedQuery(name="ClienteVinculoLocal.FindByClienteVinculanteTipoVinculo",query="SELECT OBJECT(o) "
+ " FROM ClienteVinculoLocal AS o "
+ " WHERE o.clie_oid_clie_vnte = ?1 "
+ " AND o.tivc_oid_tipo_vinc = ?2"),
@NamedQuery(name="ClienteVinculoLocal.FindAll",query="SELECT OBJECT(o) FROM ClienteVinculoLocal AS o ")
})
public class ClienteVinculoLocal implements Serializable {

	public ClienteVinculoLocal() {}

	public ClienteVinculoLocal(Long oid, Long clie_oid_clie_vnte, Long clie_oid_clie_vndo, Long tivc_oid_tipo_vinc, Date fec_ulti_actu) {
            this.oid=oid;
            this.clie_oid_clie_vnte = clie_oid_clie_vnte;
            this.clie_oid_clie_vndo = clie_oid_clie_vndo;
            this.tivc_oid_tipo_vinc = tivc_oid_tipo_vinc;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_VINC")
	private Long oid;
	@Column(name="FEC_DESD")
	private Timestamp fec_desd;
	@Column(name="FEC_HAST")
	private Timestamp fec_hast;
	@Column(name="CLIE_OID_CLIE_VNTE")
	private Long clie_oid_clie_vnte;
	@Column(name="CLIE_OID_CLIE_VNDO")
	private Long clie_oid_clie_vndo;
	@Column(name="TIVC_OID_TIPO_VINC")
	private Long tivc_oid_tipo_vinc;
	@Column(name="IND_VINC_PPAL")private Long ind_vinc_ppal;
	@Column(name="FEC_ULTI_ACTU")
	private Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Timestamp getFec_desd() {return fec_desd;}
      
	public void setFec_desd(Timestamp fec_desd){this.fec_desd=fec_desd;}
		
	public Timestamp getFec_hast() {return fec_hast;}
      
	public void setFec_hast(Timestamp fec_hast){this.fec_hast=fec_hast;}
		
	public Long getClie_oid_clie_vnte() {return clie_oid_clie_vnte;}
      
	public void setClie_oid_clie_vnte(Long clie_oid_clie_vnte){this.clie_oid_clie_vnte=clie_oid_clie_vnte;}
		
	public Long getClie_oid_clie_vndo() {return clie_oid_clie_vndo;}
      
	public void setClie_oid_clie_vndo(Long clie_oid_clie_vndo){this.clie_oid_clie_vndo=clie_oid_clie_vndo;}
		
	public Long getTivc_oid_tipo_vinc() {return tivc_oid_tipo_vinc;}
      
	public void setTivc_oid_tipo_vinc(Long tivc_oid_tipo_vinc){this.tivc_oid_tipo_vinc=tivc_oid_tipo_vinc;}
		
	public Long getInd_vinc_ppal() {return ind_vinc_ppal;}
      
	public void setInd_vinc_ppal(Long ind_vinc_ppal){this.ind_vinc_ppal=ind_vinc_ppal;}
		
	public Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
