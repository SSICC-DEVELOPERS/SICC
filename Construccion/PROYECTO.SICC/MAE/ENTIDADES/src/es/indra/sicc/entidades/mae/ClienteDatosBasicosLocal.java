package es.indra.sicc.entidades.mae;

import es.indra.sicc.cmn.negocio.auditoria.EntidadSICCAuditableBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN")
@NamedQueries({
@NamedQuery(name="ClienteDatosBasicosLocal.FindByUK",query="select object(c) from ClienteDatosBasicosLocal c "
+ "where c.pais_oid_pais = ?1 and c.cod_clie = ?2"),
@NamedQuery(name="ClienteDatosBasicosLocal.FindByCodigoYPais",query="select object(c) from ClienteDatosBasicosLocal c "
+ "where c.pais_oid_pais = ?1 and c.cod_clie = ?2"),
@NamedQuery(name="ClienteDatosBasicosLocal.FindAll",query="select object(c) from ClienteDatosBasicosLocal c ")
})
public class ClienteDatosBasicosLocal extends EntidadSICCAuditableBean implements Serializable {

	public ClienteDatosBasicosLocal() {}

	public ClienteDatosBasicosLocal(Long oid, Long pais_oid_pais, String cod_clie, boolean indFichaInscripcion) {
            this.oid=oid;
            this.pais_oid_pais = pais_oid_pais;
            this.cod_clie = cod_clie;
            this.ind_fich_insc = new Long(indFichaInscripcion? 1 : 0);
	}

	@Column(name="COD_CLIE")
	private String cod_clie;
	@Id
	@Column(name="OID_CLIE")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="COD_DIGI_CTRL")
	private String cod_digi_ctrl;
	@Column(name="IND_FICH_INSC")
	private Long ind_fich_insc;
	@Column(name="VAL_APE1")
	private String val_ape1;
	@Column(name="VAL_APE2")
	private String val_ape2;
	@Column(name="VAL_NOM1")
	private String val_nom1;
	@Column(name="VAL_NOM2")
	private String val_nom2;
	@Column(name="VAL_TRAT")
	private String val_trat;
	@Column(name="VAL_CRIT_BUS1")
	private String val_crit_bus1;
	@Column(name="VAL_CRIT_BUS2")
	private String val_crit_bus2;
	@Column(name="COD_SEXO")
	private String cod_sexo;
	@Column(name="FEC_INGR")
	private java.sql.Timestamp fec_ingr;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long fopa_oid_form_pago;
	@Column(name="VAL_APEL_CASA")
	private String val_apel_casa;
        
        // sapaza -- PER-SiCC-2013-0918 -- 21/08/2013
        @Column(name="IND_ORIG_REGI")
        private String ind_orig;
    	
	public String getCod_clie() {return cod_clie;}
      
	public void setCod_clie(String cod_clie){this.cod_clie=cod_clie;}
		
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public String getCod_digi_ctrl() {return cod_digi_ctrl;}
      
	public void setCod_digi_ctrl(String cod_digi_ctrl){this.cod_digi_ctrl=cod_digi_ctrl;}
		
	public Long getInd_fich_insc() {return ind_fich_insc;}
      
	public void setInd_fich_insc(Long ind_fich_insc){this.ind_fich_insc=ind_fich_insc;}
		
	public String getVal_ape1() {return val_ape1;}
      
	public void setVal_ape1(String val_ape1){this.val_ape1=val_ape1;}
		
	public String getVal_ape2() {return val_ape2;}
      
	public void setVal_ape2(String val_ape2){this.val_ape2=val_ape2;}
		
	public String getVal_nom1() {return val_nom1;}
      
	public void setVal_nom1(String val_nom1){this.val_nom1=val_nom1;}
		
	public String getVal_nom2() {return val_nom2;}
      
	public void setVal_nom2(String val_nom2){this.val_nom2=val_nom2;}
		
	public String getVal_trat() {return val_trat;}
      
	public void setVal_trat(String val_trat){this.val_trat=val_trat;}
		
	public String getVal_crit_bus1() {return val_crit_bus1;}
      
	public void setVal_crit_bus1(String val_crit_bus1){this.val_crit_bus1=val_crit_bus1;}
		
	public String getVal_crit_bus2() {return val_crit_bus2;}
      
	public void setVal_crit_bus2(String val_crit_bus2){this.val_crit_bus2=val_crit_bus2;}
		
	public String getCod_sexo() {return cod_sexo;}
      
	public void setCod_sexo(String cod_sexo){this.cod_sexo=cod_sexo;}
		
	public java.sql.Timestamp getFec_ingr() {return fec_ingr;}
      
	public void setFec_ingr(java.sql.Timestamp fec_ingr){this.fec_ingr=fec_ingr;}
		
	public Long getFopa_oid_form_pago() {return fopa_oid_form_pago;}
      
	public void setFopa_oid_form_pago(Long fopa_oid_form_pago){this.fopa_oid_form_pago=fopa_oid_form_pago;}
		
	public String getVal_apel_casa() {return val_apel_casa;}
      
	public void setVal_apel_casa(String val_apel_casa){this.val_apel_casa=val_apel_casa;}
        
        /*
         * dmorello, 09/10/2008
         * Los siguientes 3 metodos se mantienen hasta finalizar la migracion
         * y luego deben ser eliminados
         */
			
        public void ejbActivate() {}
        
        public void ejbPassivate() {}
        
        public void ejbLoad() {}

        public void setInd_orig(String ind_orig) {
            this.ind_orig = ind_orig;
        }
    
        public String getInd_orig() {
            return ind_orig;
        }
}
