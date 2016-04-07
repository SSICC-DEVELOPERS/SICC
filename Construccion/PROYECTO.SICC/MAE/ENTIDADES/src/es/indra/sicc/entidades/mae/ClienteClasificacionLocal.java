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
@Table(name="MAE_CLIEN_CLASI")
@NamedQueries({
@NamedQuery(name="ClienteClasificacionLocal.FindByUK",query="select object(c) from ClienteClasificacionLocal c "
+ " where c.tccl_oid_tipo_clasi = ?1 and c.ctsu_oid_clie_tipo_subt = ?2"),
@NamedQuery(name="ClienteClasificacionLocal.FindAll",query="select object(c) from ClienteClasificacionLocal c ")
})
public class ClienteClasificacionLocal implements Serializable {

	public ClienteClasificacionLocal() {}

	public ClienteClasificacionLocal(Long oid, Long ctsu_oid_clie_tipo_subt, Long clas_oid_clas, Long perd_oid_peri, Long tccl_oid_tipo_clasi,
                Long ind_ppal, Date fec_ulti_actu)	{
                
            this.oid=oid;
            this.ctsu_oid_clie_tipo_subt = ctsu_oid_clie_tipo_subt;
            this.clas_oid_clas = clas_oid_clas;
            this.perd_oid_peri = perd_oid_peri;
            this.tccl_oid_tipo_clasi = tccl_oid_tipo_clasi;
            this.ind_ppal = ind_ppal;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_CLAS")
	private Long oid;
	@Column(name="CTSU_OID_CLIE_TIPO_SUBT")
	private Long ctsu_oid_clie_tipo_subt;
	@Column(name="CLAS_OID_CLAS")
	private Long clas_oid_clas;
	@Column(name="PERD_OID_PERI")
	private Long perd_oid_peri;
	@Column(name="TCCL_OID_TIPO_CLASI")
	private Long tccl_oid_tipo_clasi;
	@Column(name="FEC_CLAS")
	private java.sql.Timestamp fec_clas;
	@Column(name="IND_PPAL")
	private Long ind_ppal;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCtsu_oid_clie_tipo_subt() {return ctsu_oid_clie_tipo_subt;}
      
	public void setCtsu_oid_clie_tipo_subt(Long ctsu_oid_clie_tipo_subt){this.ctsu_oid_clie_tipo_subt=ctsu_oid_clie_tipo_subt;}
		
	public Long getClas_oid_clas() {return clas_oid_clas;}
      
	public void setClas_oid_clas(Long clas_oid_clas){this.clas_oid_clas=clas_oid_clas;}
		
	public Long getPerd_oid_peri() {return perd_oid_peri;}
      
	public void setPerd_oid_peri(Long perd_oid_peri){this.perd_oid_peri=perd_oid_peri;}
		
	public Long getTccl_oid_tipo_clasi() {return tccl_oid_tipo_clasi;}
      
	public void setTccl_oid_tipo_clasi(Long tccl_oid_tipo_clasi){this.tccl_oid_tipo_clasi=tccl_oid_tipo_clasi;}
		
	public java.sql.Timestamp getFec_clas() {return fec_clas;}
      
	public void setFec_clas(java.sql.Timestamp fec_clas){this.fec_clas=fec_clas;}
		
	public Long getInd_ppal() {return ind_ppal;}
      
	public void setInd_ppal(Long ind_ppal){this.ind_ppal=ind_ppal;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
