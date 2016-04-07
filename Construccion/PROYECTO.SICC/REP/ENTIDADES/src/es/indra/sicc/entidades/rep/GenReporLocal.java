package es.indra.sicc.entidades.rep;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;


@Entity
@Table(name="GEN_REPOR")
@NamedQueries({
@NamedQuery(name="GenReporLocal.FindAll",query="select object(o) from GenReporLocal o"),
@NamedQuery(name="GenReporLocal.FindByCodProc",query="SELECT OBJECT(a) FROM GenReporLocal AS a WHERE a.codProc = ?1")
})
public class GenReporLocal implements Serializable {

	public GenReporLocal() {}

	public GenReporLocal(Long oid, String codProc, String valUsua, Timestamp fecRepo, String valModu, Long rrepOidRepo, String valExt)	{
            this.oid = oid;
	    this.codProc = codProc;
	    this.valUsua = valUsua;
	    this.fecRepo = fecRepo;
	    this.valModu = valModu;
	    this.rrepOidRepo = rrepOidRepo;
	    this.valExt = valExt;
        }

	@Id
	@Column(name="OID_REPO")
	private Long oid;
	@Column(name="COD_PROC")
	private String codProc;
	@Column(name="VAL_USUA")
	private String valUsua;
	@Column(name="FEC_REPO")
	private java.sql.Timestamp fecRepo;
	@Column(name="VAL_MODU")
	private String valModu;
	@Column(name="VAL_INFO")
	private byte[] valInfo;
	@Column(name="RREP_OID_REPO")
	private Long rrepOidRepo;
	@Column(name="VAL_EXTE")
	private String valExt;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodProc() {return codProc;}
      
	public void setCodProc(String codProc){this.codProc=codProc;}
		
	public String getValUsua() {return valUsua;}
      
	public void setValUsua(String valUsua){this.valUsua=valUsua;}
		
	public java.sql.Timestamp getFecRepo() {return fecRepo;}
      
	public void setFecRepo(java.sql.Timestamp fecRepo){this.fecRepo=fecRepo;}
		
	public String getValModu() {return valModu;}
      
	public void setValModu(String valModu){this.valModu=valModu;}
		
	public byte[] getValInfo() {return valInfo;}
      
	public void setValInfo(byte[] valInfo){this.valInfo=valInfo;}
		
	public Long getRrepOidRepo() {return rrepOidRepo;}
      
	public void setRrepOidRepo(Long rrepOidRepo){this.rrepOidRepo=rrepOidRepo;}
		
	public String getValExt() {return valExt;}
      
	public void setValExt(String valExt){this.valExt=valExt;}
			
	
}
