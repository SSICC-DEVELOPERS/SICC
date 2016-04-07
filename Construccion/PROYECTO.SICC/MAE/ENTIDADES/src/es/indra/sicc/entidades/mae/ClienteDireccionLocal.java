package es.indra.sicc.entidades.mae;

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="MAE_CLIEN_DIREC")
@NamedQueries({
@NamedQuery(name="ClienteDireccionLocal.FindDireccionPrincipalCliente",query="SELECT OBJECT(d) FROM ClienteDireccionLocal AS d WHERE d.clie_oid_clie = ?1 AND d.ind_dire_ppal=1"),
@NamedQuery(name="ClienteDireccionLocal.FindByClienteYTipo",query="SELECT OBJECT(d) FROM ClienteDireccionLocal AS d WHERE d.clie_oid_clie = ?1 AND d.tidc_oid_tipo_dire = ?2"),
@NamedQuery(name="ClienteDireccionLocal.FindAll",query="SELECT OBJECT(d) FROM ClienteDireccionLocal AS d ")
})
public class ClienteDireccionLocal implements Serializable {

	public ClienteDireccionLocal() {}

	public ClienteDireccionLocal(Long oid, Long clie_oid_clie, Long tidc_oid_tipo_dire, Long tivi_oid_tipo_via, Date fechaActua, String est_geop)	{
            this.oid=oid;
	    setClie_oid_clie(clie_oid_clie);
	    setTidc_oid_tipo_dire(tidc_oid_tipo_dire);
	    setTivi_oid_tipo_via(tivi_oid_tipo_via);
	    setFec_ulti_actu(fechaActua);
	    setEst_geop(est_geop);
	    setInd_elim(ConstantesMAE.IND_DIRECCION_ACTIVO); //Agregado por Sapaza, incidencia V_MAE_08 - estado: activo
	}

	@Id
	@Column(name="OID_CLIE_DIRE")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TIDC_OID_TIPO_DIRE")
	private Long tidc_oid_tipo_dire;
	@Column(name="TIVI_OID_TIPO_VIA")
	private Long tivi_oid_tipo_via;
	@Column(name="TERR_OID_TERR")
	private Long terr_oid_terr;
	@Column(name="ZVIA_OID_VIA")
	private Long zvia_oid_via;
	@Column(name="NUM_PPAL")
	private String num_ppal;
	@Column(name="VAL_NOMB_VIA")
	private String val_nomb_via;
	@Column(name="VAL_COD_POST")
	private String val_cod_post;
	@Column(name="VAL_INTE")
	private Long val_inte;
	@Column(name="VAL_MANZ")
	private Long val_manz;
	@Column(name="VAL_LOTE")
	private Long val_lote;
	@Column(name="VAL_KM")
	private Long val_km;
	@Column(name="VAL_OBSE")
	private String val_obse;
	@Column(name="VAL_NOMB_FICH")
	private String val_nomb_fich;
	@Column(name="VAL_COOR_X")
	private Long val_coor_x;
	@Column(name="VAL_COOR_Y")
	private Long val_coor_y;
	@Column(name="VAL_COOR_Z")
	private Long val_coor_z;
	@Column(name="IND_DIRE_PPAL")
	private Long ind_dire_ppal;
	@Column(name="IND_CTRL_INTE_GEOR")
	private Character ind_ctrl_inte_geor;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;
	@Column(name="COD_UNID_GEOG")
	private String est_geop;
	@Column(name="IND_ELIM")
	private Long ind_elim;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTidc_oid_tipo_dire() {return tidc_oid_tipo_dire;}
      
	public void setTidc_oid_tipo_dire(Long tidc_oid_tipo_dire){this.tidc_oid_tipo_dire=tidc_oid_tipo_dire;}
		
	public Long getTivi_oid_tipo_via() {return tivi_oid_tipo_via;}
      
	public void setTivi_oid_tipo_via(Long tivi_oid_tipo_via){this.tivi_oid_tipo_via=tivi_oid_tipo_via;}
		
	public Long getTerr_oid_terr() {return terr_oid_terr;}
      
	public void setTerr_oid_terr(Long terr_oid_terr){this.terr_oid_terr=terr_oid_terr;}
		
	public Long getZvia_oid_via() {return zvia_oid_via;}
      
	public void setZvia_oid_via(Long zvia_oid_via){this.zvia_oid_via=zvia_oid_via;}
		
	public String getNum_ppal() {return num_ppal;}
      
	public void setNum_ppal(String num_ppal){this.num_ppal=num_ppal;}
		
	public String getVal_nomb_via() {return val_nomb_via;}
      
	public void setVal_nomb_via(String val_nomb_via){this.val_nomb_via=val_nomb_via;}
		
	public String getVal_cod_post() {return val_cod_post;}
      
	public void setVal_cod_post(String val_cod_post){this.val_cod_post=val_cod_post;}
		
	public Long getVal_inte() {return val_inte;}
      
	public void setVal_inte(Long val_inte){this.val_inte=val_inte;}
		
	public Long getVal_manz() {return val_manz;}
      
	public void setVal_manz(Long val_manz){this.val_manz=val_manz;}
		
	public Long getVal_lote() {return val_lote;}
      
	public void setVal_lote(Long val_lote){this.val_lote=val_lote;}
		
	public Long getVal_km() {return val_km;}
      
	public void setVal_km(Long val_km){this.val_km=val_km;}
		
	public String getVal_obse() {return val_obse;}
      
	public void setVal_obse(String val_obse){this.val_obse=val_obse;}
		
	public String getVal_nomb_fich() {return val_nomb_fich;}
      
	public void setVal_nomb_fich(String val_nomb_fich){this.val_nomb_fich=val_nomb_fich;}
		
	public Long getVal_coor_x() {return val_coor_x;}
      
	public void setVal_coor_x(Long val_coor_x){this.val_coor_x=val_coor_x;}
		
	public Long getVal_coor_y() {return val_coor_y;}
      
	public void setVal_coor_y(Long val_coor_y){this.val_coor_y=val_coor_y;}
		
	public Long getVal_coor_z() {return val_coor_z;}
      
	public void setVal_coor_z(Long val_coor_z){this.val_coor_z=val_coor_z;}
		
	public Long getInd_dire_ppal() {return ind_dire_ppal;}
      
	public void setInd_dire_ppal(Long ind_dire_ppal){this.ind_dire_ppal=ind_dire_ppal;}
		
	public Character getInd_ctrl_inte_geor() {return ind_ctrl_inte_geor;}
      
	public void setInd_ctrl_inte_geor(Character ind_ctrl_inte_geor){this.ind_ctrl_inte_geor=ind_ctrl_inte_geor;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
		
	public String getEst_geop() {return est_geop;}
      
	public void setEst_geop(String est_geop){this.est_geop=est_geop;}
		
	public Long getInd_elim() {return ind_elim;}
      
	public void setInd_elim(Long ind_elim){this.ind_elim=ind_elim;}
			
	
}
