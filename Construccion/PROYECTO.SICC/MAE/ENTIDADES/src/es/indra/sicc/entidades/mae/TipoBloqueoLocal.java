package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_BLOQU")
@NamedQueries({
@NamedQuery(name="TipoBloqueoLocal.FindAll",query="SELECT Object(o) FROM TipoBloqueoLocal o"),
@NamedQuery(name="TipoBloqueoLocal.FindByCodigo",query="SELECT Object(o) FROM TipoBloqueoLocal o WHERE o.cod_tipo_bloq = ?1")
})
public class TipoBloqueoLocal implements Serializable {

	public TipoBloqueoLocal() {}

	public TipoBloqueoLocal(Long oid, String cod_tipo_bloq, Integer ind_bloq_fina, Integer num_nive_grav_bloq,
                Long stmr_oid_moti_rech, Long maab_oid_valo_acci_bloq, Long maab_oid_valo_acci_desb) {
	
            this.oid=oid;
            this.cod_tipo_bloq = cod_tipo_bloq;
            this.ind_bloq_fina = ind_bloq_fina;
            this.num_nive_grav_bloq = num_nive_grav_bloq;
            this.stmr_oid_moti_rech = stmr_oid_moti_rech;
            this.maab_oid_valo_acci_bloq = maab_oid_valo_acci_bloq;
            this.maab_oid_valo_acci_desb = maab_oid_valo_acci_desb;
	}

	@Id
	@Column(name="OID_TIPO_BLOQ")
	private Long oid;
	@Column(name="COD_TIPO_BLOQ")
	private String cod_tipo_bloq;
	@Column(name="IND_BLOQ_FINA")
	private Integer ind_bloq_fina;
	@Column(name="NUM_NIVE_GRAV_BLOQ")
	private Integer num_nive_grav_bloq;
	@Column(name="STMR_OID_MOTI_RECH")
	private Long stmr_oid_moti_rech;
	@Column(name="MAAB_OID_VALO_ACCI_BLOQ")
	private Long maab_oid_valo_acci_bloq;
	@Column(name="MAAB_OID_VALO_ACCI_DESB")
	private Long maab_oid_valo_acci_desb;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_tipo_bloq() {return cod_tipo_bloq;}
      
	public void setCod_tipo_bloq(String cod_tipo_bloq){this.cod_tipo_bloq=cod_tipo_bloq;}
		
	public Integer getInd_bloq_fina() {return ind_bloq_fina;}
      
	public void setInd_bloq_fina(Integer ind_bloq_fina){this.ind_bloq_fina=ind_bloq_fina;}
		
	public Integer getNum_nive_grav_bloq() {return num_nive_grav_bloq;}
      
	public void setNum_nive_grav_bloq(Integer num_nive_grav_bloq){this.num_nive_grav_bloq=num_nive_grav_bloq;}
		
	public Long getStmr_oid_moti_rech() {return stmr_oid_moti_rech;}
      
	public void setStmr_oid_moti_rech(Long stmr_oid_moti_rech){this.stmr_oid_moti_rech=stmr_oid_moti_rech;}
		
	public Long getMaab_oid_valo_acci_bloq() {return maab_oid_valo_acci_bloq;}
      
	public void setMaab_oid_valo_acci_bloq(Long maab_oid_valo_acci_bloq){this.maab_oid_valo_acci_bloq=maab_oid_valo_acci_bloq;}
		
	public Long getMaab_oid_valo_acci_desb() {return maab_oid_valo_acci_desb;}
      
	public void setMaab_oid_valo_acci_desb(Long maab_oid_valo_acci_desb){this.maab_oid_valo_acci_desb=maab_oid_valo_acci_desb;}
			
	
}
