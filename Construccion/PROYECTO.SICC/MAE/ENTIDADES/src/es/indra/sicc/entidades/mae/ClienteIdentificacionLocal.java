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
@Table(name="MAE_CLIEN_IDENT")
@NamedQueries({
@NamedQuery(name="ClienteIdentificacionLocal.FindByUK",query="select Object(c) from ClienteIdentificacionLocal c "
+ " where c.clie_oid_clie = ?1"),
@NamedQuery(name="ClienteIdentificacionLocal.FindAll",query="select Object(c) from ClienteIdentificacionLocal c ")
})
public class ClienteIdentificacionLocal implements Serializable {

	public ClienteIdentificacionLocal() {}

	public ClienteIdentificacionLocal(Long oid, Long tdoc_oid_tipo_docu, Long clie_oid_clie, String num_docu_iden,
                Long val_iden_docu_prin, Date fec_ulti_actu)	{
    
            this.oid=oid;
            this.tdoc_oid_tipo_docu = tdoc_oid_tipo_docu;
            this.clie_oid_clie = clie_oid_clie;
            this.num_docu_iden = num_docu_iden;
            this.val_iden_docu_prin = val_iden_docu_prin;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_IDEN")
	private Long oid;
	@Column(name="TDOC_OID_TIPO_DOCU")
	private Long tdoc_oid_tipo_docu;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="NUM_DOCU_IDEN")
	private String num_docu_iden;
	@Column(name="VAL_IDEN_DOCU_PRIN")
	private Long val_iden_docu_prin;
	@Column(name="VAL_IDEN_PERS_EMPR")
	private String val_iden_pers_empr;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTdoc_oid_tipo_docu() {return tdoc_oid_tipo_docu;}
      
	public void setTdoc_oid_tipo_docu(Long tdoc_oid_tipo_docu){this.tdoc_oid_tipo_docu=tdoc_oid_tipo_docu;}
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public String getNum_docu_iden() {return num_docu_iden;}
      
	public void setNum_docu_iden(String num_docu_iden){this.num_docu_iden=num_docu_iden;}
		
	public Long getVal_iden_docu_prin() {return val_iden_docu_prin;}
      
	public void setVal_iden_docu_prin(Long val_iden_docu_prin){this.val_iden_docu_prin=val_iden_docu_prin;}
		
	public String getVal_iden_pers_empr() {return val_iden_pers_empr;}
      
	public void setVal_iden_pers_empr(String val_iden_pers_empr){this.val_iden_pers_empr=val_iden_pers_empr;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
