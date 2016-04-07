package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_ESTAD_CIVIL")
@NamedQueries({
@NamedQuery(name="EstadoCivilLocal.FindAll",query="select object(o) from EstadoCivilLocal o"),
@NamedQuery(name="EstadoCivilLocal.FindByUK",query="select object(e) from EstadoCivilLocal e where e.codigo = ?1")
})
public class EstadoCivilLocal implements Serializable {

	public EstadoCivilLocal() {}

	public EstadoCivilLocal(Long oid, String codigo)	{
            this.oid=oid;
            this.codigo = codigo;
	}

	@Id
	@Column(name="OID_ESTA_CIVI")
	private Long oid;
	@Column(name="COD_ESTA_CIVI")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
