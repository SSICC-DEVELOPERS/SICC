package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_PAIS")
@NamedQueries({
@NamedQuery(name="PaisLocal.FindByUk",query="SELECT OBJECT(p) "
+ " FROM PaisLocal AS p"
+ " WHERE p.cod_pais=?1"),
@NamedQuery(name="PaisLocal.FindAll",query="SELECT OBJECT(p) FROM PaisLocal AS p")
})
public class PaisLocal implements Serializable {

	public PaisLocal() {}

	public PaisLocal(Long oid, String cod_pais, Long mone_oid_mone, String val_iden, String val_prog_ejec,
			Long val_porc_alar, Long num_dias_mora, Long ind_sald_unic, String ind_inte_gis, Long ind_comp_auto,
			Long ind_trat_acum_desc, Long val_tiem_rezo, String val_conf_secu_ccc, Long num_limi_dife_pago,
			Long val_maxi_dife_anls_comb, Long num_dias_fact, Long num_posi_nume_clie, Long mone_oid_mone_alt,
			Long ind_emis_venc, String val_form_fech, String val_sepa_mile, String val_sepa_deci, Long num_peri_egre,
			Long num_peri_reti, String val_url, String ind_flet_zona_ubig, String val_indi_secu_moni,
			String ind_secu, String ind_bala_area_cheq)	{
		
		this.oid=oid;
		this.cod_pais = cod_pais;
		this.mone_oid_mone = mone_oid_mone;
		this.val_iden = val_iden;
		this.val_prog_ejec = val_prog_ejec;
		this.val_porc_alar = val_porc_alar;
		this.num_dias_mora = num_dias_mora;
		this.ind_sald_unic = ind_sald_unic;
		this.ind_inte_gis = ind_inte_gis;
		this.ind_comp_auto = ind_comp_auto;
		this.ind_trat_acum_desc = ind_trat_acum_desc;
		this.val_tiem_rezo = val_tiem_rezo;
		this.val_conf_secu_ccc = val_conf_secu_ccc;
		this.num_limi_dife_pago = num_limi_dife_pago;
		this.val_maxi_dife_anls_comb = val_maxi_dife_anls_comb;
		this.num_dias_fact = num_dias_fact;
		this.num_posi_nume_clie = num_posi_nume_clie;
		this.mone_oid_mone_alt = mone_oid_mone_alt;
		this.ind_emis_venc = ind_emis_venc;
		this.val_form_fech = val_form_fech;
		this.val_sepa_mile = val_sepa_mile;
		this.val_sepa_deci = val_sepa_deci;
		this.num_peri_egre = num_peri_egre;
		this.num_peri_reti = num_peri_reti;
		this.val_url = val_url;
		this.ind_flet_zona_ubig = ind_flet_zona_ubig;
		this.val_indi_secu_moni = val_indi_secu_moni;
		this.ind_secu = ind_secu;
		this.ind_bala_area_cheq = ind_bala_area_cheq;
	}

	@Id
	@Column(name="OID_PAIS")
	private Long oid;
	@Column(name="COD_PAIS")
	private String cod_pais;
	@Column(name="MONE_OID_MONE")
	private Long mone_oid_mone;
	@Column(name="VAL_IDEN")
	private String val_iden;
	@Column(name="VAL_PROG_EJEC")
	private String val_prog_ejec;
	@Column(name="VAL_PORC_ALAR")
	private Long val_porc_alar;
	@Column(name="NUM_DIAS_MORA")
	private Long num_dias_mora;
	@Column(name="IND_SALD_UNIC")
	private Long ind_sald_unic;
	@Column(name="IND_INTE_GIS")
	private String ind_inte_gis;
	@Column(name="IND_COMP_AUTO")
	private Long ind_comp_auto;
	@Column(name="IND_TRAT_ACUM_DESC")
	private Long ind_trat_acum_desc;
	@Column(name="VAL_TIEM_REZO")
	private Long val_tiem_rezo;
	@Column(name="VAL_CONF_SECU_CCC")
	private String val_conf_secu_ccc;
	@Column(name="NUM_LIMI_DIFE_PAGO")
	private Long num_limi_dife_pago;
	@Column(name="VAL_MAXI_DIFE_ANLS_COMB")
	private Long val_maxi_dife_anls_comb;
	@Column(name="NUM_DIAS_FACT")
	private Long num_dias_fact;
	@Column(name="NUM_POSI_NUME_CLIE")
	private Long num_posi_nume_clie;
	@Column(name="MONE_OID_MONE_ALT")
	private Long mone_oid_mone_alt;
	@Column(name="IND_EMIS_VENC")
	private Long ind_emis_venc;
	@Column(name="VAL_FORM_FECH")
	private String val_form_fech;
	@Column(name="VAL_SEPA_MILE")
	private String val_sepa_mile;
	@Column(name="VAL_SEPA_DECI")
	private String val_sepa_deci;
	@Column(name="NUM_PERI_EGRE")
	private Long num_peri_egre;
	@Column(name="NUM_PERI_RETI")
	private Long num_peri_reti;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long fopa_oid_form_pago;
	@Column(name="VAL_COMP_TELE")
	private String val_comp_tele;
	@Column(name="VAL_URL")
	private String val_url;
	@Column(name="IND_FLET_ZONA_UBIG")
	private String ind_flet_zona_ubig;
	@Column(name="VAL_INDI_SECU_MONI")
	private String val_indi_secu_moni;
	@Column(name="IND_SECU")
	private String ind_secu;
	@Column(name="IND_BALA_AREA_CHEQ")
	private String ind_bala_area_cheq;
	@Column(name="IND_IMPU_INCL")
	private Boolean ind_impu_incl;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_pais() {return cod_pais;}
      
	public void setCod_pais(String cod_pais){this.cod_pais=cod_pais;}
		
	public Long getMone_oid_mone() {return mone_oid_mone;}
      
	public void setMone_oid_mone(Long mone_oid_mone){this.mone_oid_mone=mone_oid_mone;}
		
	public String getVal_iden() {return val_iden;}
      
	public void setVal_iden(String val_iden){this.val_iden=val_iden;}
		
	public String getVal_prog_ejec() {return val_prog_ejec;}
      
	public void setVal_prog_ejec(String val_prog_ejec){this.val_prog_ejec=val_prog_ejec;}
		
	public Long getVal_porc_alar() {return val_porc_alar;}
      
	public void setVal_porc_alar(Long val_porc_alar){this.val_porc_alar=val_porc_alar;}
		
	public Long getNum_dias_mora() {return num_dias_mora;}
      
	public void setNum_dias_mora(Long num_dias_mora){this.num_dias_mora=num_dias_mora;}
		
	public Long getInd_sald_unic() {return ind_sald_unic;}
      
	public void setInd_sald_unic(Long ind_sald_unic){this.ind_sald_unic=ind_sald_unic;}
		
	public String getInd_inte_gis() {return ind_inte_gis;}
      
	public void setInd_inte_gis(String ind_inte_gis){this.ind_inte_gis=ind_inte_gis;}
		
	public Long getInd_comp_auto() {return ind_comp_auto;}
      
	public void setInd_comp_auto(Long ind_comp_auto){this.ind_comp_auto=ind_comp_auto;}
		
	public Long getInd_trat_acum_desc() {return ind_trat_acum_desc;}
      
	public void setInd_trat_acum_desc(Long ind_trat_acum_desc){this.ind_trat_acum_desc=ind_trat_acum_desc;}
		
	public Long getVal_tiem_rezo() {return val_tiem_rezo;}
      
	public void setVal_tiem_rezo(Long val_tiem_rezo){this.val_tiem_rezo=val_tiem_rezo;}
		
	public String getVal_conf_secu_ccc() {return val_conf_secu_ccc;}
      
	public void setVal_conf_secu_ccc(String val_conf_secu_ccc){this.val_conf_secu_ccc=val_conf_secu_ccc;}
		
	public Long getNum_limi_dife_pago() {return num_limi_dife_pago;}
      
	public void setNum_limi_dife_pago(Long num_limi_dife_pago){this.num_limi_dife_pago=num_limi_dife_pago;}
		
	public Long getVal_maxi_dife_anls_comb() {return val_maxi_dife_anls_comb;}
      
	public void setVal_maxi_dife_anls_comb(Long val_maxi_dife_anls_comb){this.val_maxi_dife_anls_comb=val_maxi_dife_anls_comb;}
		
	public Long getNum_dias_fact() {return num_dias_fact;}
      
	public void setNum_dias_fact(Long num_dias_fact){this.num_dias_fact=num_dias_fact;}
		
	public Long getNum_posi_nume_clie() {return num_posi_nume_clie;}
      
	public void setNum_posi_nume_clie(Long num_posi_nume_clie){this.num_posi_nume_clie=num_posi_nume_clie;}
		
	public Long getMone_oid_mone_alt() {return mone_oid_mone_alt;}
      
	public void setMone_oid_mone_alt(Long mone_oid_mone_alt){this.mone_oid_mone_alt=mone_oid_mone_alt;}
		
	public Long getInd_emis_venc() {return ind_emis_venc;}
      
	public void setInd_emis_venc(Long ind_emis_venc){this.ind_emis_venc=ind_emis_venc;}
		
	public String getVal_form_fech() {return val_form_fech;}
      
	public void setVal_form_fech(String val_form_fech){this.val_form_fech=val_form_fech;}
		
	public String getVal_sepa_mile() {return val_sepa_mile;}
      
	public void setVal_sepa_mile(String val_sepa_mile){this.val_sepa_mile=val_sepa_mile;}
		
	public String getVal_sepa_deci() {return val_sepa_deci;}
      
	public void setVal_sepa_deci(String val_sepa_deci){this.val_sepa_deci=val_sepa_deci;}
		
	public Long getNum_peri_egre() {return num_peri_egre;}
      
	public void setNum_peri_egre(Long num_peri_egre){this.num_peri_egre=num_peri_egre;}
		
	public Long getNum_peri_reti() {return num_peri_reti;}
      
	public void setNum_peri_reti(Long num_peri_reti){this.num_peri_reti=num_peri_reti;}
		
	public Long getFopa_oid_form_pago() {return fopa_oid_form_pago;}
      
	public void setFopa_oid_form_pago(Long fopa_oid_form_pago){this.fopa_oid_form_pago=fopa_oid_form_pago;}
		
	public String getVal_comp_tele() {return val_comp_tele;}
      
	public void setVal_comp_tele(String val_comp_tele){this.val_comp_tele=val_comp_tele;}
		
	public String getVal_url() {return val_url;}
      
	public void setVal_url(String val_url){this.val_url=val_url;}
		
	public String getInd_flet_zona_ubig() {return ind_flet_zona_ubig;}
      
	public void setInd_flet_zona_ubig(String ind_flet_zona_ubig){this.ind_flet_zona_ubig=ind_flet_zona_ubig;}
		
	public String getVal_indi_secu_moni() {return val_indi_secu_moni;}
      
	public void setVal_indi_secu_moni(String val_indi_secu_moni){this.val_indi_secu_moni=val_indi_secu_moni;}
		
	public String getInd_secu() {return ind_secu;}
      
	public void setInd_secu(String ind_secu){this.ind_secu=ind_secu;}
		
	public String getInd_bala_area_cheq() {return ind_bala_area_cheq;}
      
	public void setInd_bala_area_cheq(String ind_bala_area_cheq){this.ind_bala_area_cheq=ind_bala_area_cheq;}
		
	public Boolean getInd_impu_incl() {return ind_impu_incl;}
      
	public void setInd_impu_incl(Boolean ind_impu_incl){this.ind_impu_incl=ind_impu_incl;}
			
	
}
