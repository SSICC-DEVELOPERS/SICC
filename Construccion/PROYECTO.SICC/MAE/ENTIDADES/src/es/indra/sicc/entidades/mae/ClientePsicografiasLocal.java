package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_PSICO")
@NamedQueries({
@NamedQuery(name="ClientePsicografiasLocal.FindAll", query="SELECT OBJECT(o) FROM ClientePsicografiasLocal AS o")
})
public class ClientePsicografiasLocal implements Serializable {

	public ClientePsicografiasLocal() {}

	public ClientePsicografiasLocal(Long oid, Long clie_oid_clie, Long marc_oid_marc, Long tpoid_tipo_perf_psic) {
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.marc_oid_marc = marc_oid_marc;
            this.tpoid_tipo_perf_psic = tpoid_tipo_perf_psic;
	}

	@Id
	@Column(name="OID_PSIC")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="TPOID_TIPO_PERF_PSIC")
	private Long tpoid_tipo_perf_psic;
	@Column(name="COD_TEST")
	private String cod_test;
	@Column(name="FEC_PSIC")
	private java.sql.Timestamp fec_psic;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getTpoid_tipo_perf_psic() {return tpoid_tipo_perf_psic;}
      
	public void setTpoid_tipo_perf_psic(Long tpoid_tipo_perf_psic){this.tpoid_tipo_perf_psic=tpoid_tipo_perf_psic;}
		
	public String getCod_test() {return cod_test;}
      
	public void setCod_test(String cod_test){this.cod_test=cod_test;}
		
	public java.sql.Timestamp getFec_psic() {return fec_psic;}
      
	public void setFec_psic(java.sql.Timestamp fec_psic){this.fec_psic=fec_psic;}
			
	
}
