package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_DESCU")
public class DescuentoLocal implements Serializable {

	public DescuentoLocal() {}

	public DescuentoLocal(Long oid, Long perd_oid_peri, Long cana_oid_cana, Long marc_oid_marc, Long ind_culm, Long ind_afec_fact, 
                                Long ind_ctrl_devo, Long ind_comu_part, Long ind_acti, Long ind_ctrl_anul, Long ind_desc_acumu, 
                                Long ind_afec_cc, Long ind_moro, Long ind_apro, Long ind_naci, Long pais_oid_pais, Long num_desc_corr, 
                                Long num_desc)	{
                this.oid=oid;
                setPerd_oid_peri(perd_oid_peri);
                setCana_oid_cana(cana_oid_cana);
                setMarc_oid_marc(marc_oid_marc);
                setInd_culm(ind_culm);
                setInd_afec_fact(ind_afec_fact);
                setInd_ctrl_devo(ind_ctrl_devo);
                setInd_comu_part(ind_comu_part);
                setInd_acti(ind_acti);
                setInd_ctrl_anul(ind_ctrl_anul);
                setInd_desc_acumu(ind_desc_acumu);
                setInd_afec_cc(ind_afec_cc);
                setInd_moro(ind_moro);
                setInd_apro(ind_apro);
                setInd_naci(ind_naci);
                setPais_oid_pais(pais_oid_pais);
                setNum_desc_corr(num_desc_corr);
                setNum_desc(num_desc);	
                
	
	}

	@Id
	@Column(name="OID_DESC")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long perd_oid_peri;
	@Column(name="CANA_OID_CANA")
	private Long cana_oid_cana;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="PERD_OID_PERI_LIMI_FIN")
	private Long perd_oid_peri_limi_fin;
	@Column(name="MDES_OID_TIPO_DESC")
	private Long mdes_oid_tipo_desc;
	@Column(name="IND_CULM")
	private Long ind_culm;
	@Column(name="IND_AFEC_FACT")
	private Long ind_afec_fact;
	@Column(name="IND_CTRL_DEVO")
	private Long ind_ctrl_devo;
	@Column(name="IND_COMU_PART")
	private Long ind_comu_part;
	@Column(name="IND_ACTI")
	private Long ind_acti;
	@Column(name="IND_CTRL_ANUL")
	private Long ind_ctrl_anul;
	@Column(name="IND_DESC_ACUMU")
	private Long ind_desc_acumu;
	@Column(name="IND_AFEC_CC")
	private Long ind_afec_cc;
	@Column(name="IND_MORO")
	private Long ind_moro;
	@Column(name="IND_APRO")
	private Long ind_apro;
	@Column(name="IND_NACI")
	private Long ind_naci;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="NUM_DESC_CORR")
	private Long num_desc_corr;
	@Column(name="NUM_DESC")
	private Long num_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPerd_oid_peri() {return perd_oid_peri;}
      
	public void setPerd_oid_peri(Long perd_oid_peri){this.perd_oid_peri=perd_oid_peri;}
		
	public Long getCana_oid_cana() {return cana_oid_cana;}
      
	public void setCana_oid_cana(Long cana_oid_cana){this.cana_oid_cana=cana_oid_cana;}
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getPerd_oid_peri_limi_fin() {return perd_oid_peri_limi_fin;}
      
	public void setPerd_oid_peri_limi_fin(Long perd_oid_peri_limi_fin){this.perd_oid_peri_limi_fin=perd_oid_peri_limi_fin;}
		
	public Long getMdes_oid_tipo_desc() {return mdes_oid_tipo_desc;}
      
	public void setMdes_oid_tipo_desc(Long mdes_oid_tipo_desc){this.mdes_oid_tipo_desc=mdes_oid_tipo_desc;}
		
	public Long getInd_culm() {return ind_culm;}
      
	public void setInd_culm(Long ind_culm){this.ind_culm=ind_culm;}
		
	public Long getInd_afec_fact() {return ind_afec_fact;}
      
	public void setInd_afec_fact(Long ind_afec_fact){this.ind_afec_fact=ind_afec_fact;}
		
	public Long getInd_ctrl_devo() {return ind_ctrl_devo;}
      
	public void setInd_ctrl_devo(Long ind_ctrl_devo){this.ind_ctrl_devo=ind_ctrl_devo;}
		
	public Long getInd_comu_part() {return ind_comu_part;}
      
	public void setInd_comu_part(Long ind_comu_part){this.ind_comu_part=ind_comu_part;}
		
	public Long getInd_acti() {return ind_acti;}
      
	public void setInd_acti(Long ind_acti){this.ind_acti=ind_acti;}
		
	public Long getInd_ctrl_anul() {return ind_ctrl_anul;}
      
	public void setInd_ctrl_anul(Long ind_ctrl_anul){this.ind_ctrl_anul=ind_ctrl_anul;}
		
	public Long getInd_desc_acumu() {return ind_desc_acumu;}
      
	public void setInd_desc_acumu(Long ind_desc_acumu){this.ind_desc_acumu=ind_desc_acumu;}
		
	public Long getInd_afec_cc() {return ind_afec_cc;}
      
	public void setInd_afec_cc(Long ind_afec_cc){this.ind_afec_cc=ind_afec_cc;}
		
	public Long getInd_moro() {return ind_moro;}
      
	public void setInd_moro(Long ind_moro){this.ind_moro=ind_moro;}
		
	public Long getInd_apro() {return ind_apro;}
      
	public void setInd_apro(Long ind_apro){this.ind_apro=ind_apro;}
		
	public Long getInd_naci() {return ind_naci;}
      
	public void setInd_naci(Long ind_naci){this.ind_naci=ind_naci;}
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public Long getNum_desc_corr() {return num_desc_corr;}
      
	public void setNum_desc_corr(Long num_desc_corr){this.num_desc_corr=num_desc_corr;}
		
	public Long getNum_desc() {return num_desc;}
      
	public void setNum_desc(Long num_desc){this.num_desc=num_desc;}
			
	
}
