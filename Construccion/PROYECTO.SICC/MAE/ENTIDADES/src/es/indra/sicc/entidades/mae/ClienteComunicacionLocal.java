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
@Table(name="MAE_CLIEN_COMUN")
@NamedQueries({
@NamedQuery(name="ClienteComunicacionLocal.FindByUK",query="SELECT OBJECT(a) FROM ClienteComunicacionLocal AS a "
+ " WHERE a.clie_oid_clie = ?1 AND a.ticm_oid_tipo_comu = ?2"),
@NamedQuery(name="ClienteComunicacionLocal.FindAll",query="SELECT OBJECT(a) FROM ClienteComunicacionLocal AS a")
})
public class ClienteComunicacionLocal implements Serializable {

	public ClienteComunicacionLocal() {}

	public ClienteComunicacionLocal(Long oid, Long clie_oid_clie, Long ticm_oid_tipo_comu, Date fec_ulti_actu)	{
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.ticm_oid_tipo_comu = ticm_oid_tipo_comu;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_COMU")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="TICM_OID_TIPO_COMU")
	private Long ticm_oid_tipo_comu;
	@Column(name="VAL_DIA_COMU")
	private String val_dia_comu;
	@Column(name="VAL_TEXT_COMU")
	private String val_text_comu;
	@Column(name="FEC_HORA_DESD")
	private java.sql.Timestamp fec_hora_desd;
	@Column(name="FEC_HORA_HAST")
	private java.sql.Timestamp fec_hora_hast;
	@Column(name="VAL_INTE_COMU")
	private Long val_inte_comu;
	@Column(name="IND_COMU_PPAL")
	private Long ind_comu_ppal;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

        @Column(name="IND_CONF_COMU")        
        private String indicadorConfirmacion;
	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getTicm_oid_tipo_comu() {return ticm_oid_tipo_comu;}
      
	public void setTicm_oid_tipo_comu(Long ticm_oid_tipo_comu){this.ticm_oid_tipo_comu=ticm_oid_tipo_comu;}
		
	public String getVal_dia_comu() {return val_dia_comu;}
      
	public void setVal_dia_comu(String val_dia_comu){this.val_dia_comu=val_dia_comu;}
		
	public String getVal_text_comu() {return val_text_comu;}
      
	public void setVal_text_comu(String val_text_comu){this.val_text_comu=val_text_comu;}
		
	public java.sql.Timestamp getFec_hora_desd() {return fec_hora_desd;}
      
	public void setFec_hora_desd(java.sql.Timestamp fec_hora_desd){this.fec_hora_desd=fec_hora_desd;}
		
	public java.sql.Timestamp getFec_hora_hast() {return fec_hora_hast;}
      
	public void setFec_hora_hast(java.sql.Timestamp fec_hora_hast){this.fec_hora_hast=fec_hora_hast;}
		
	public Long getVal_inte_comu() {return val_inte_comu;}
      
	public void setVal_inte_comu(Long val_inte_comu){this.val_inte_comu=val_inte_comu;}
		
	public Long getInd_comu_ppal() {return ind_comu_ppal;}
      
	public void setInd_comu_ppal(Long ind_comu_ppal){this.ind_comu_ppal=ind_comu_ppal;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}


    public String getIndicadorConfirmacion() {
        return indicadorConfirmacion;
    }

    public void setIndicadorConfirmacion(String indicadorConfirmacion) {
        this.indicadorConfirmacion = indicadorConfirmacion;
    }

}
