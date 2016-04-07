package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_VALOR_ESTRU_GEOPO")
@NamedQueries({
@NamedQuery(name="ValoresEstructuraGeopoliticaLocal.FindByUbigeo",query="SELECT OBJECT(a) "
+ " FROM ValoresEstructuraGeopoliticaLocal AS a  "
+ " WHERE ( (a.orde_1 IS NULL AND ?1 IS NULL) OR (?1 IS NOT NULL AND a.orde_1 IS NOT NULL AND a.orde_1 = ?1) )"
+ "   AND ( (a.orde_2 IS NULL AND ?2 IS NULL) OR (?2 IS NOT NULL AND a.orde_2 IS NOT NULL AND a.orde_2 = ?2) )"
+ "   AND ( (a.orde_3 IS NULL AND ?3 IS NULL) OR (?3 IS NOT NULL AND a.orde_3 IS NOT NULL AND a.orde_3 = ?3) )"
+ "   AND ( (a.orde_4 IS NULL AND ?4 IS NULL) OR (?4 IS NOT NULL AND a.orde_4 IS NOT NULL AND a.orde_4 = ?4) )"
+ "   AND ( (a.orde_5 IS NULL AND ?5 IS NULL) OR (?5 IS NOT NULL AND a.orde_5 IS NOT NULL AND a.orde_5 = ?5) )"
+ "   AND ( (a.orde_6 IS NULL AND ?6 IS NULL) OR (?6 IS NOT NULL AND a.orde_6 IS NOT NULL AND a.orde_6 = ?6) )"
+ "   AND ( (a.orde_7 IS NULL AND ?7 IS NULL) OR (?7 IS NOT NULL AND a.orde_7 IS NOT NULL AND a.orde_7 = ?7) )"
+ "   AND ( (a.orde_8 IS NULL AND ?8 IS NULL) OR (?8 IS NOT NULL AND a.orde_8 IS NOT NULL AND a.orde_8 = ?8) )"
+ "   AND ( (a.orde_9 IS NULL AND ?9 IS NULL) OR (?9 IS NOT NULL AND a.orde_9 IS NOT NULL AND a.orde_9 = ?9) )"
+ "   AND a.pais_oid_pais = ?10 "
+ "   AND a.ind_borr = 0"),
@NamedQuery(name="ValoresEstructuraGeopoliticaLocal.FindByPaisUnidadGeografica",query="SELECT OBJECT(a) "
+ " FROM ValoresEstructuraGeopoliticaLocal AS a "
+ " WHERE a.pais_oid_pais = ?1 "
+ " AND a.cod_unio_geog = ?2"),
@NamedQuery(name="ValoresEstructuraGeopoliticaLocal.FindAll",query="SELECT OBJECT(a) FROM ValoresEstructuraGeopoliticaLocal AS a")
})
public class ValoresEstructuraGeopoliticaLocal implements Serializable {

	public ValoresEstructuraGeopoliticaLocal() {}

	public ValoresEstructuraGeopoliticaLocal(Long oid, String ubigeo, String nse1, String nse2,
                String desc, Long subestructura, String cp, Long oidPais, Long oidEG) {
	
            this.oid=oid;
            
	    //descompone el string ubigeo y carga en los diferentes campos
	    String ubigeoStr = ubigeo;
	    String[] ubigeoArray = new String[9];
	    int largoStr = ubigeoStr.length();
	    int a = 0;

	    //esto deberia llamar al metodo en realidad  validaUbigeo
	    for (int i = 0; i < ubigeoStr.length(); i++) {
	        ubigeoArray[a] = ubigeoStr.substring(i, i + 6);
	        i = i + 5;
	        a = a + 1;
	    }

	    if (a < 9) {
	        for (int i = a; i < 9; i++) {
	            ubigeoArray[i] = null;
	        }
	    }
	    
	    setCod_unio_geog(oid);
	    setDes_geog(desc);
	    setCod_nse1(nse1);
	    setCod_nse2(nse2);
	    setCod_post(cp);
	    setInd_acti(new Long(1));
	    setInd_asig(new Long(1));
	    setInd_borr(new Long(0));
	    setOrde_1(ubigeoArray[0]);
	    setOrde_2(ubigeoArray[1]);
	    setOrde_3(ubigeoArray[2]);
	    setOrde_4(ubigeoArray[3]);
	    setOrde_5(ubigeoArray[4]);
	    setOrde_6(ubigeoArray[5]);
	    setOrde_7(ubigeoArray[6]);
	    setOrde_8(ubigeoArray[7]);
	    setOrde_9(ubigeoArray[8]);
	    setPais_oid_pais(oidPais);
	    setSubEstruGeopo((Long)subestructura);
	    setEgeo_oid_estr_geop((Long)oidEG);
	    setFechaActualizacion(new Timestamp(System.currentTimeMillis()));
	}
        
        public ValoresEstructuraGeopoliticaLocal(Long oid, Long cod_unio_geog, Long egeo_oid_estr_geop,
                Long pais_oid_pais, Timestamp fec_actu, Long sgeo_oid_sube_geop) {
            
            this.oid = oid;
            setCod_unio_geog(cod_unio_geog);
            setEgeo_oid_estr_geop(egeo_oid_estr_geop);
            setPais_oid_pais(pais_oid_pais);
        }

	@Id
	@Column(name="OID_VALO_ESTR_GEOP")
	private Long oid;
	@Column(name="COD_UNID_GEOG")
	private Long cod_unio_geog;
	@Column(name="DES_GEOG")
	private String des_geog;
	@Column(name="COD_NSE1")
	private String cod_nse1;
	@Column(name="COD_NSE2")
	private String cod_nse2;
	@Column(name="COD_NSE3")
	private String cod_nse3;
	@Column(name="COD_POST")
	private String cod_post;
	@Column(name="IND_ACTI")
	private Long ind_acti;
	@Column(name="IND_ASIG")
	private Long ind_asig;
	@Column(name="IND_BORR")
	private Long ind_borr;
	@Column(name="ORDE_1")
	private String orde_1;
	@Column(name="ORDE_2")
	private String orde_2;
	@Column(name="ORDE_3")
	private String orde_3;
	@Column(name="ORDE_4")
	private String orde_4;
	@Column(name="ORDE_5")
	private String orde_5;
	@Column(name="ORDE_6")
	private String orde_6;
	@Column(name="ORDE_7")
	private String orde_7;
	@Column(name="ORDE_8")
	private String orde_8;
	@Column(name="ORDE_9")
	private String orde_9;
	@Column(name="EGEO_OID_ESTR_GEOP")
	private Long egeo_oid_estr_geop;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="SGEO_OID_SUBE_GEOP")
	private Long subEstruGeopo;
	@Column(name="FEC_ACTU")
	private Timestamp fechaActualizacion;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCod_unio_geog() {return cod_unio_geog;}
      
	public void setCod_unio_geog(Long cod_unio_geog){this.cod_unio_geog=cod_unio_geog;}
		
	public String getDes_geog() {return des_geog;}
      
	public void setDes_geog(String des_geog){this.des_geog=des_geog;}
		
	public String getCod_nse1() {return cod_nse1;}
      
	public void setCod_nse1(String cod_nse1){this.cod_nse1=cod_nse1;}
		
	public String getCod_nse2() {return cod_nse2;}
      
	public void setCod_nse2(String cod_nse2){this.cod_nse2=cod_nse2;}
		
	public String getCod_nse3() {return cod_nse3;}
      
	public void setCod_nse3(String cod_nse3){this.cod_nse3=cod_nse3;}
		
	public String getCod_post() {return cod_post;}
      
	public void setCod_post(String cod_post){this.cod_post=cod_post;}
		
	public Long getInd_acti() {return ind_acti;}
      
	public void setInd_acti(Long ind_acti){this.ind_acti=ind_acti;}
		
	public Long getInd_asig() {return ind_asig;}
      
	public void setInd_asig(Long ind_asig){this.ind_asig=ind_asig;}
		
	public Long getInd_borr() {return ind_borr;}
      
	public void setInd_borr(Long ind_borr){this.ind_borr=ind_borr;}
		
	public String getOrde_1() {return orde_1;}
      
	public void setOrde_1(String orde_1){this.orde_1=orde_1;}
		
	public String getOrde_2() {return orde_2;}
      
	public void setOrde_2(String orde_2){this.orde_2=orde_2;}
		
	public String getOrde_3() {return orde_3;}
      
	public void setOrde_3(String orde_3){this.orde_3=orde_3;}
		
	public String getOrde_4() {return orde_4;}
      
	public void setOrde_4(String orde_4){this.orde_4=orde_4;}
		
	public String getOrde_5() {return orde_5;}
      
	public void setOrde_5(String orde_5){this.orde_5=orde_5;}
		
	public String getOrde_6() {return orde_6;}
      
	public void setOrde_6(String orde_6){this.orde_6=orde_6;}
		
	public String getOrde_7() {return orde_7;}
      
	public void setOrde_7(String orde_7){this.orde_7=orde_7;}
		
	public String getOrde_8() {return orde_8;}
      
	public void setOrde_8(String orde_8){this.orde_8=orde_8;}
		
	public String getOrde_9() {return orde_9;}
      
	public void setOrde_9(String orde_9){this.orde_9=orde_9;}
		
	public Long getEgeo_oid_estr_geop() {return egeo_oid_estr_geop;}
      
	public void setEgeo_oid_estr_geop(Long egeo_oid_estr_geop){this.egeo_oid_estr_geop=egeo_oid_estr_geop;}
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public Long getSubEstruGeopo() {return subEstruGeopo;}
      
	public void setSubEstruGeopo(Long subEstruGeopo){this.subEstruGeopo=subEstruGeopo;}
		
	public Timestamp getFechaActualizacion() {return fechaActualizacion;}
      
	public void setFechaActualizacion(Timestamp fechaActualizacion){this.fechaActualizacion=fechaActualizacion;}
			
	
}
