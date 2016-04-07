package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_ESTAD_RECLA")
@NamedQueries({
@NamedQuery(name="EstadoReclamoLocal.FindAll",query="select object(o) from EstadoReclamoLocal o")
})
public class EstadoReclamoLocal implements Serializable {

	public EstadoReclamoLocal() {}

	public EstadoReclamoLocal(Long oid, String codEstado)	{
	
		this.oid=oid;
                this.codEstado=codEstado;
	
	}

	@Id
	@Column(name="OID_ESTA_RECL")
	private Long oid;
	@Column(name="COD_ESTA")
	private String codEstado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodEstado() {return codEstado;}
      
	public void setCodEstado(String codEstado){this.codEstado=codEstado;}
			
	
}
