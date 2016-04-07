package es.indra.sicc.cmn.negocio.auditoria.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_MARCA")
@NamedQueries({
@NamedQuery(name="MarcaTestLocal.FindAll", query="SELECT Object(o) FROM MarcaTestLocal o")
})
public class MarcaTestLocal implements Serializable {

        public MarcaTestLocal() { }

	public MarcaTestLocal(Long oid, String cod_marc)	{
		this.oid=oid;
		this.cod_marc=cod_marc;
	}

	@Id
	@Column(name="OID_MARC")
	private Long oid;
	@Column(name="COD_MARC")
	private String cod_marc;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_marc() {return cod_marc;}
      
	public void setCod_marc(String cod_marc){this.cod_marc=cod_marc;}
			
	
}
