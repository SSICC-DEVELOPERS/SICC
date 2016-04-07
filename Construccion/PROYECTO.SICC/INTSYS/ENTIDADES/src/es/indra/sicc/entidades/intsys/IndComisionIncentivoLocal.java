package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_COMIS_INCEN")
@NamedQueries({
@NamedQuery(name="IndComisionIncentivoLocal.FindAll",query="select object(o) from IndComisionIncentivoLocal o")
})
public class IndComisionIncentivoLocal implements Serializable {

	public IndComisionIncentivoLocal() {}

	public IndComisionIncentivoLocal(Long oid, String codigo)	{
            this.oid=oid;
	    this.codigo=codigo;
	}

	@Id
	@Column(name="OID_COMI_INCE")
	private Long oid;
	@Column(name="COD_COMI_INCE")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
