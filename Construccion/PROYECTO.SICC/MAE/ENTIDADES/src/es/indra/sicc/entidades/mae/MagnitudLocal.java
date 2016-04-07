package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_MAGNI")
@NamedQueries({
@NamedQuery(name="MagnitudLocal.FindAll",query="select object(o) from MagnitudLocal o"),
@NamedQuery(name="MagnitudLocal.FindByUk",query="SELECT OBJECT(m) "
+ " FROM MagnitudLocal AS m "
+ " WHERE m.codMagn=?1")
})
public class MagnitudLocal implements Serializable {

	public MagnitudLocal() {}

	public MagnitudLocal(Long oid, String codMagn)	{
            this.oid = oid;
            this.codMagn = codMagn;
	}

	@Id
	@Column(name="OID_MAGN")
	private Long oid;
	@Column(name="COD_MAGN")
	private String codMagn;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodMagn() {return codMagn;}
      
	public void setCodMagn(String codMagn){this.codMagn=codMagn;}
			
	
}
