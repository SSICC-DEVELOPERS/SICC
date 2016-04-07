package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="MAE_CLIEN_BLOQU")
@NamedQueries({
@NamedQuery(name="ClienteBloqueoLocal.FindByCliente",query="SELECT OBJECT(a) FROM ClienteBloqueoLocal AS a "
+ "WHERE a.clie_oid_clie =?1"),
@NamedQuery(name="ClienteBloqueoLocal.FindByClienteTipoBloqueo",query="select object(c) from ClienteBloqueoLocal c where c.clie_oid_clie = ?1 and c.tibq_oid_tipo_bloq = ?2"),
@NamedQuery(name="ClienteBloqueoLocal.FindAll",query="select object(c) from ClienteBloqueoLocal c")
})
public class ClienteBloqueoLocal implements Serializable {

	public ClienteBloqueoLocal() {}

	public ClienteBloqueoLocal(Long oid, Long clie_oid_clie, Long tibq_oid_tipo_bloq, Timestamp fec_bloq, String val_moti_bloq,
                String val_usua_bloq, String obs_bloq)	{
	
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.tibq_oid_tipo_bloq = tibq_oid_tipo_bloq;
            this.fec_bloq = fec_bloq;
            this.val_moti_bloq = val_moti_bloq;
            this.val_usua_bloq = val_usua_bloq;
            this.obs_bloq = obs_bloq;
	}

	@Id
	@Column(name="OID_BLOQ")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TIBQ_OID_TIPO_BLOQ")
	private Long tibq_oid_tipo_bloq;
	@Column(name="FEC_BLOQ")
	private java.sql.Timestamp fec_bloq;
	@Column(name="VAL_MOTI_BLOQ")
	private String val_moti_bloq;
	@Column(name="VAL_USUA_BLOQ")
	private String val_usua_bloq;
	@Column(name="OBS_BLOQ")
	private String obs_bloq;
	@Column(name="FEC_DESB")
	private java.sql.Timestamp fec_desb;
	@Column(name="VAL_USUA_DESB")
	private String val_usua_desb;
	@Column(name="MAAB_OID_VALO_ACCI_BLOQ")
	private Long maab_oid_valo_acci_bloq;
	@Column(name="MAAB_OID_VALO_ACCI_DESB")
	private Long maab_oid_valo_acci_desb;
	@Column(name="OBS_DESB")
	private String obs_desb;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTibq_oid_tipo_bloq() {return tibq_oid_tipo_bloq;}
      
	public void setTibq_oid_tipo_bloq(Long tibq_oid_tipo_bloq){this.tibq_oid_tipo_bloq=tibq_oid_tipo_bloq;}
		
	public java.sql.Timestamp getFec_bloq() {return fec_bloq;}
      
	public void setFec_bloq(java.sql.Timestamp fec_bloq){this.fec_bloq=fec_bloq;}
		
	public String getVal_moti_bloq() {return val_moti_bloq;}
      
	public void setVal_moti_bloq(String val_moti_bloq){this.val_moti_bloq=val_moti_bloq;}
		
	public String getVal_usua_bloq() {return val_usua_bloq;}
      
	public void setVal_usua_bloq(String val_usua_bloq){this.val_usua_bloq=val_usua_bloq;}
		
	public String getObs_bloq() {return obs_bloq;}
      
	public void setObs_bloq(String obs_bloq){this.obs_bloq=obs_bloq;}
		
	public java.sql.Timestamp getFec_desb() {return fec_desb;}
      
	public void setFec_desb(java.sql.Timestamp fec_desb){this.fec_desb=fec_desb;}
		
	public String getVal_usua_desb() {return val_usua_desb;}
      
	public void setVal_usua_desb(String val_usua_desb){this.val_usua_desb=val_usua_desb;}
		
	public Long getMaab_oid_valo_acci_bloq() {return maab_oid_valo_acci_bloq;}
      
	public void setMaab_oid_valo_acci_bloq(Long maab_oid_valo_acci_bloq){this.maab_oid_valo_acci_bloq=maab_oid_valo_acci_bloq;}
		
	public Long getMaab_oid_valo_acci_desb() {return maab_oid_valo_acci_desb;}
      
	public void setMaab_oid_valo_acci_desb(Long maab_oid_valo_acci_desb){this.maab_oid_valo_acci_desb=maab_oid_valo_acci_desb;}
		
	public String getObs_desb() {return obs_desb;}
      
	public void setObs_desb(String obs_desb){this.obs_desb=obs_desb;}
			
	
}
