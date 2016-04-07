package es.indra.sicc.entidades.mae;

import es.indra.sicc.cmn.negocio.auditoria.EntidadSICCAuditableBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="MAE_CLIEN_DATOS_ADICI")
@NamedQueries({
@NamedQuery(name="ClienteDatosAdicionalesLocal.FindByCliente",query="SELECT OBJECT(a) FROM ClienteDatosAdicionalesLocal AS a "
+ "WHERE a.clie_oid_clie = ?1"),
@NamedQuery(name="ClienteDatosAdicionalesLocal.FindAll",query="SELECT OBJECT(a) FROM ClienteDatosAdicionalesLocal AS a ")
})
public  class  ClienteDatosAdicionalesLocal extends EntidadSICCAuditableBean implements Serializable {

	public ClienteDatosAdicionalesLocal() {}

	public ClienteDatosAdicionalesLocal(Long oid, Long clie_oid_clie, Long esta_oid_esta_clie, Date fec_ulti_actu)	{
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.esta_oid_esta_clie = esta_oid_esta_clie;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="NSEP_OID_NSEP")
	private Long nsep_oid_nsep;
	@Id
	@Column(name="OID_CLIE_DATO_ADIC")
	private Long oid;
	@Column(name="COD_EMPL")
	private String cod_empl;
	@Column(name="FEC_NACI")
	private java.sql.Date fec_naci;
	@Column(name="VAL_EDAD")
	private Long val_edad;
	@Column(name="VAL_OCUP")
	private String val_ocup;
	@Column(name="VAL_PROF")
	private String val_prof;
	@Column(name="VAL_CENT_TRAB")
	private String val_cent_trab;
	@Column(name="VAL_CARG_DESE")
	private String val_carg_dese;
	@Column(name="VAL_CENT_ESTU")
	private String val_cent_estu;
	@Column(name="VAL_NIVE_SOCI_ECO3")
	private String val_nive_soci_eco3;
	@Column(name="NUM_HIJO")
	private Long num_hijo;
	@Column(name="NUM_PERS_DEPE")
	private Long num_pers_depe;
	@Column(name="NUM_CAMP_SIN_PEDI")
	private Long num_camp_sin_pedi;
	@Column(name="IMP_INGR_FAMI")
	private Double imp_ingr_fami;
	@Column(name="IMP_MONT_LINE_CRED")
	private Double imp_mont_line_cred;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long niri_oid_nive_ries;
	@Column(name="NIED_OID_NIVE_ESTU")
	private Long nied_oid_nive_estu;
	@Column(name="SNON_OID_NACI")
	private Long snon_oid_naci;
	@Column(name="ESCV_OID_ESTA_CIVI")
	private Long escv_oid_esta_civi;
	@Column(name="PERD_OID_PERI_NIVE_RIES")
	private Long perd_oid_peri_nive_ries;
	@Column(name="PERD_OID_PERI_LINE_CRED")
	private Long perd_oid_peri_line_cred;
	@Column(name="IND_CORR")
	private Long ind_corr;
	@Column(name="IND_ACTI")
	private Long ind_acti;
	@Column(name="ESTA_OID_ESTA_CLIE")
	private Long esta_oid_esta_clie;
	@Column(name="TCLV_OID_CICL_VIDA")
	private Long tclv_oid_cicl_vida;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getNsep_oid_nsep() {return nsep_oid_nsep;}
      
	public void setNsep_oid_nsep(Long nsep_oid_nsep){this.nsep_oid_nsep=nsep_oid_nsep;}
		
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_empl() {return cod_empl;}
      
	public void setCod_empl(String cod_empl){this.cod_empl=cod_empl;}
		
	public java.sql.Date getFec_naci() {return fec_naci;}
      
	public void setFec_naci(java.sql.Date fec_naci){this.fec_naci=fec_naci;}
		
	public Long getVal_edad() {return val_edad;}
      
	public void setVal_edad(Long val_edad){this.val_edad=val_edad;}
		
	public String getVal_ocup() {return val_ocup;}
      
	public void setVal_ocup(String val_ocup){this.val_ocup=val_ocup;}
		
	public String getVal_prof() {return val_prof;}
      
	public void setVal_prof(String val_prof){this.val_prof=val_prof;}
		
	public String getVal_cent_trab() {return val_cent_trab;}
      
	public void setVal_cent_trab(String val_cent_trab){this.val_cent_trab=val_cent_trab;}
		
	public String getVal_carg_dese() {return val_carg_dese;}
      
	public void setVal_carg_dese(String val_carg_dese){this.val_carg_dese=val_carg_dese;}
		
	public String getVal_cent_estu() {return val_cent_estu;}
      
	public void setVal_cent_estu(String val_cent_estu){this.val_cent_estu=val_cent_estu;}
		
	public String getVal_nive_soci_eco3() {return val_nive_soci_eco3;}
      
	public void setVal_nive_soci_eco3(String val_nive_soci_eco3){this.val_nive_soci_eco3=val_nive_soci_eco3;}
		
	public Long getNum_hijo() {return num_hijo;}
      
	public void setNum_hijo(Long num_hijo){this.num_hijo=num_hijo;}
		
	public Long getNum_pers_depe() {return num_pers_depe;}
      
	public void setNum_pers_depe(Long num_pers_depe){this.num_pers_depe=num_pers_depe;}
		
	public Long getNum_camp_sin_pedi() {return num_camp_sin_pedi;}
      
	public void setNum_camp_sin_pedi(Long num_camp_sin_pedi){this.num_camp_sin_pedi=num_camp_sin_pedi;}
		
	public Double getImp_ingr_fami() {return imp_ingr_fami;}
      
	public void setImp_ingr_fami(Double imp_ingr_fami){this.imp_ingr_fami=imp_ingr_fami;}
		
	public Double getImp_mont_line_cred() {return imp_mont_line_cred;}
      
	public void setImp_mont_line_cred(Double imp_mont_line_cred){this.imp_mont_line_cred=imp_mont_line_cred;}
		
	public Long getNiri_oid_nive_ries() {return niri_oid_nive_ries;}
      
	public void setNiri_oid_nive_ries(Long niri_oid_nive_ries){this.niri_oid_nive_ries=niri_oid_nive_ries;}
		
	public Long getNied_oid_nive_estu() {return nied_oid_nive_estu;}
      
	public void setNied_oid_nive_estu(Long nied_oid_nive_estu){this.nied_oid_nive_estu=nied_oid_nive_estu;}
		
	public Long getSnon_oid_naci() {return snon_oid_naci;}
      
	public void setSnon_oid_naci(Long snon_oid_naci){this.snon_oid_naci=snon_oid_naci;}
		
	public Long getEscv_oid_esta_civi() {return escv_oid_esta_civi;}
      
	public void setEscv_oid_esta_civi(Long escv_oid_esta_civi){this.escv_oid_esta_civi=escv_oid_esta_civi;}
		
	public Long getPerd_oid_peri_nive_ries() {return perd_oid_peri_nive_ries;}
      
	public void setPerd_oid_peri_nive_ries(Long perd_oid_peri_nive_ries){this.perd_oid_peri_nive_ries=perd_oid_peri_nive_ries;}
		
	public Long getPerd_oid_peri_line_cred() {return perd_oid_peri_line_cred;}
      
	public void setPerd_oid_peri_line_cred(Long perd_oid_peri_line_cred){this.perd_oid_peri_line_cred=perd_oid_peri_line_cred;}
		
	public Long getInd_corr() {return ind_corr;}
      
	public void setInd_corr(Long ind_corr){this.ind_corr=ind_corr;}
		
	public Long getInd_acti() {return ind_acti;}
      
	public void setInd_acti(Long ind_acti){this.ind_acti=ind_acti;}
		
	public Long getEsta_oid_esta_clie() {return esta_oid_esta_clie;}
      
	public void setEsta_oid_esta_clie(Long esta_oid_esta_clie){this.esta_oid_esta_clie=esta_oid_esta_clie;}
		
	public Long getTclv_oid_cicl_vida() {return tclv_oid_cicl_vida;}
      
	public void setTclv_oid_cicl_vida(Long tclv_oid_cicl_vida){this.tclv_oid_cicl_vida=tclv_oid_cicl_vida;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
        /*
         * dmorello, 09/10/2008
         * Los siguientes 3 metodos se mantienen hasta finalizar la migracion
         * y luego deben ser eliminados
         */
                        
	public void ejbActivate() {}
        
        public void ejbPassivate() {}
        
        public void ejbLoad() {}
}
