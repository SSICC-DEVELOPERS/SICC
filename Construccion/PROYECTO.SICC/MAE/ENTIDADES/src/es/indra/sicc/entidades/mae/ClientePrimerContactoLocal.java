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
@Table(name="MAE_CLIEN_PRIME_CONTA")
@NamedQueries({
@NamedQuery(name="ClientePrimerContactoLocal.FindAll", query="SELECT OBJECT(o) FROM ClientePrimerContactoLocal AS o"),
@NamedQuery(name="ClientePrimerContactoLocal.FindByCliente", query="SELECT OBJECT(o) FROM ClientePrimerContactoLocal AS o "
+ " WHERE o.clie_oid_clie = ?1")
})
public class ClientePrimerContactoLocal implements Serializable {

	public ClientePrimerContactoLocal() {}

	public ClientePrimerContactoLocal(Long oid, Long clie_oid_clie, Long ctsu_clie_cont, Date fec_ulti_actu) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.ctsu_clie_cont = ctsu_clie_cont;
            this.fec_ulti_actu = fec_ulti_actu;
	}

	@Id
	@Column(name="OID_CLIE_PRIM_CONT")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="CTSU_CLIE_CONT")
	private Long ctsu_clie_cont;
	@Column(name="FEC_CONT")
	private java.sql.Timestamp fec_cont;
	@Column(name="FEC_SIGU_CONT")
	private java.sql.Timestamp fec_sigu_cont;
	@Column(name="COD_TIPO_CONT")
	private String cod_tipo_cont;
	@Column(name="CANA_OID_CANA")
	private Long cana_oid_cana;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="PERD_OID_PERI")
	private Long perd_oid_peri;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fec_ulti_actu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getCtsu_clie_cont() {return ctsu_clie_cont;}
      
	public void setCtsu_clie_cont(Long ctsu_clie_cont){this.ctsu_clie_cont=ctsu_clie_cont;}
		
	public java.sql.Timestamp getFec_cont() {return fec_cont;}
      
	public void setFec_cont(java.sql.Timestamp fec_cont){this.fec_cont=fec_cont;}
		
	public java.sql.Timestamp getFec_sigu_cont() {return fec_sigu_cont;}
      
	public void setFec_sigu_cont(java.sql.Timestamp fec_sigu_cont){this.fec_sigu_cont=fec_sigu_cont;}
		
	public String getCod_tipo_cont() {return cod_tipo_cont;}
      
	public void setCod_tipo_cont(String cod_tipo_cont){this.cod_tipo_cont=cod_tipo_cont;}
		
	public Long getCana_oid_cana() {return cana_oid_cana;}
      
	public void setCana_oid_cana(Long cana_oid_cana){this.cana_oid_cana=cana_oid_cana;}
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getPerd_oid_peri() {return perd_oid_peri;}
      
	public void setPerd_oid_peri(Long perd_oid_peri){this.perd_oid_peri=perd_oid_peri;}
		
	public java.sql.Date getFec_ulti_actu() {return fec_ulti_actu;}
      
	public void setFec_ulti_actu(java.sql.Date fec_ulti_actu){this.fec_ulti_actu=fec_ulti_actu;}
			
	
}
