package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CONFI_CAMPO")
@NamedQueries({
@NamedQuery(name="ConfiguracionCamposLocal.FindAll", query="SELECT OBJECT(o) FROM ConfiguracionCamposLocal o")
})
public class ConfiguracionCamposLocal implements Serializable {

	public ConfiguracionCamposLocal() {}

	public ConfiguracionCamposLocal(Long oid, Long pais_oid_pais, Long atre_oid_atri_espe, String val_defe, Long ind_obli, Long ind_modi) {
            this.oid=oid;
            this.pais_oid_pais = pais_oid_pais;
            this.atre_oid_atri_espe = atre_oid_atri_espe;
            this.val_defe = val_defe;
            this.ind_obli = ind_obli;
            this.ind_modi = ind_modi;
	}

	@Id
	@Column(name="OID_CONF_CAMP")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;
	@Column(name="ATRE_OID_ATRI_ESPE")
	private Long atre_oid_atri_espe;
	@Column(name="VAL_DEFE")
	private String val_defe;
	@Column(name="IND_OBLI")
	private Long ind_obli;
	@Column(name="IND_MODI")
	private Long ind_modi;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
		
	public Long getAtre_oid_atri_espe() {return atre_oid_atri_espe;}
      
	public void setAtre_oid_atri_espe(Long atre_oid_atri_espe){this.atre_oid_atri_espe=atre_oid_atri_espe;}
		
	public String getVal_defe() {return val_defe;}
      
	public void setVal_defe(String val_defe){this.val_defe=val_defe;}
		
	public Long getInd_obli() {return ind_obli;}
      
	public void setInd_obli(Long ind_obli){this.ind_obli=ind_obli;}
		
	public Long getInd_modi() {return ind_modi;}
      
	public void setInd_modi(Long ind_modi){this.ind_modi=ind_modi;}
			
	
}
