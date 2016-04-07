package es.indra.sicc.entidades.intsys;

import es.indra.mare.common.exception.MareException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_ESTAD_DESCU")
@NamedQueries({
@NamedQuery(name="EstadoDescuentoLocal.FindAll",query="select object(o) from EstadoDescuentoLocal o")
})
public class EstadoDescuentoLocal implements Serializable {

	public EstadoDescuentoLocal() {}

	public EstadoDescuentoLocal(Long oid, String codigo) {
            this.oid=oid;
	    this.codigo=codigo;
	}

	@Id
	@Column(name="OID_ESTA_DESC")
	private Long oid;
	@Column(name="COD_ESTA_DESC")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
