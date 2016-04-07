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
@Table(name="MAE_CLIEN_TIPO_SUBTI")
@NamedQueries({
@NamedQuery(name="ClienteTipoSubTipoLocal.FindByUK",query="Select Object(c) from ClienteTipoSubTipoLocal c "
+ "where c.clie_oid_clie = ?1 AND c.ticl_oid_tipo_clie = ?2"),
@NamedQuery(name="ClienteTipoSubTipoLocal.FindByCliente",query="Select Object(c) from ClienteTipoSubTipoLocal c "
+ "where c.clie_oid_clie = ?1"),
@NamedQuery(name="ClienteTipoSubTipoLocal.FindByClienteTipo",query="Select Object(c) from ClienteTipoSubTipoLocal c "
+ "where c.clie_oid_clie = ?1 AND c.ticl_oid_tipo_clie = ?2"),
@NamedQuery(name="ClienteTipoSubTipoLocal.FindAll",query="Select Object(c) from ClienteTipoSubTipoLocal c ")
})
public class ClienteTipoSubTipoLocal implements Serializable {

	public ClienteTipoSubTipoLocal() {}

	public ClienteTipoSubTipoLocal(Long oid, Long clie_oid_clie, Long ticl_oid_tipo_clie, Long sbti_oid_subt_clie, Long ind_ppal, Date fec_ulti_actu) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.ticl_oid_tipo_clie = ticl_oid_tipo_clie;
            this.sbti_oid_subt_clie = sbti_oid_subt_clie;
            this.ind_ppal = ind_ppal;
            this.fec_ulti_actu = fec_ulti_actu;	
	}

	@Id
	@Column(name="OID_CLIE_TIPO_SUBT")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long ticl_oid_tipo_clie;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;
	@Column(name="IND_PPAL")
	private Long ind_ppal;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTicl_oid_tipo_clie() {return ticl_oid_tipo_clie;}
      
	public void setTicl_oid_tipo_clie(Long ticl_oid_tipo_clie){this.ticl_oid_tipo_clie=ticl_oid_tipo_clie;}
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
		
	public Long getInd_ppal() {return ind_ppal;}
      
	public void setInd_ppal(Long ind_ppal){this.ind_ppal=ind_ppal;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
