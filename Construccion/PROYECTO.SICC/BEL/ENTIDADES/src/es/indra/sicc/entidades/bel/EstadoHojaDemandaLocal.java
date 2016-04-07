package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_ESTAD_HOJA_DEMAN")
@NamedQueries({
@NamedQuery(name="EstadoHojaDemandaLocal.FindAll",query="select object(o) from EstadoHojaDemandaLocal o")
})
public class EstadoHojaDemandaLocal implements Serializable {

	public EstadoHojaDemandaLocal() {}

	public EstadoHojaDemandaLocal(Long oid)	{
		this.oid=oid;
	}

	@Id
	@Column(name="OID_ESTA_HOJA_DEMA")
	private Long oid;
	@Column(name="COD_ESTA_HOJA_DEMA")
	private Character codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Character getCodigo() {return codigo;}
      
	public void setCodigo(Character codigo){this.codigo=codigo;}
			
	
}
