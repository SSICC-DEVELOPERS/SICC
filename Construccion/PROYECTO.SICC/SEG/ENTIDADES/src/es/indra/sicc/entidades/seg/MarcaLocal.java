package es.indra.sicc.entidades.seg;

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
@NamedQuery(name="MarcaLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM MarcaLocal AS o"
+ " WHERE o.cod_marc = ?1"),
@NamedQuery(name="MarcaLocal.FindAll", query="SELECT OBJECT(o) FROM MarcaLocal AS o")
})
public class MarcaLocal implements Serializable {

	public MarcaLocal() {}

	public MarcaLocal(Long oid, String cod_marc, String des_marc)	{
		this.oid=oid;
		this.cod_marc = cod_marc;
		this.des_marc = des_marc;
	}

	@Id
	@Column(name="OID_MARC")
	private Long oid;
	@Column(name="COD_MARC")
	private String cod_marc;
	@Column(name="DES_MARC")
	private String des_marc;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_marc() {return cod_marc;}
      
	public void setCod_marc(String cod_marc){this.cod_marc=cod_marc;}
		
	public String getDes_marc() {return des_marc;}
      
	public void setDes_marc(String des_marc){this.des_marc=des_marc;}
			
	
}
