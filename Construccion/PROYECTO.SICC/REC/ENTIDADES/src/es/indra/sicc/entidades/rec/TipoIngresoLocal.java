package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_TIPO_INGRE")
@NamedQueries({
@NamedQuery(name="TipoIngresoLocal.FindAll",query="select object(o) from TipoIngresoLocal o")
})
public class TipoIngresoLocal implements Serializable {

	public TipoIngresoLocal() {}

	public TipoIngresoLocal(Long oid, String codTipoIngreso)	{
	
		this.oid=oid;
                this.codTipoIngreso=codTipoIngreso;
	
	}

	@Id
	@Column(name="OID_TIPO_INGR")
	private Long oid;
	@Column(name="COD_TIPO_INGR")
	private String codTipoIngreso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodTipoIngreso() {return codTipoIngreso;}
      
	public void setCodTipoIngreso(String codTipoIngreso){this.codTipoIngreso=codTipoIngreso;}
			
	
}
