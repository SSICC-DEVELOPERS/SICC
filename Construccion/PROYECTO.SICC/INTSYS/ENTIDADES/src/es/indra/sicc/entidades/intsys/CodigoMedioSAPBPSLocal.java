package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_CODIG_MEDIO_SAPBP")
@NamedQueries({
@NamedQuery(name="CodigoMedioSAPBPSLocal.FindAll",query="select object(o) from CodigoMedioSAPBPSLocal o"),
@NamedQuery(name="CodigoMedioSAPBPSLocal.FindByUk",query="SELECT OBJECT(o) FROM  CodigoMedioSAPBPSLocal AS o WHERE o.pais = ?1 AND o.subAcceso = ?2")
})
public class CodigoMedioSAPBPSLocal implements Serializable {

	public CodigoMedioSAPBPSLocal() {}

	public CodigoMedioSAPBPSLocal(Long oid, String medio, Long pais, Long subAcceso) {
            this.oid=oid;
	    this.medio=medio;
	    this.pais=pais;
	    this.subAcceso=subAcceso;
	}

	@Id
	@Column(name="OID_CODI_MEDI_SAPB")
	private Long oid;
	@Column(name="VAL_MEDI")
	private String medio;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SBAC_OID_SBAC")
	private Long subAcceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getMedio() {return medio;}
      
	public void setMedio(String medio){this.medio=medio;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getSubAcceso() {return subAcceso;}
      
	public void setSubAcceso(Long subAcceso){this.subAcceso=subAcceso;}
			
	
}
