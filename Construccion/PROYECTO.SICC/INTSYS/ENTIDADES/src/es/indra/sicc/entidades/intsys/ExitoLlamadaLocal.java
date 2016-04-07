package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_EXITO_LLAMA")
@NamedQueries({
@NamedQuery(name="ExitoLlamadaLocal.FindAll",query="select object(o) from ExitoLlamadaLocal o")
})
public class ExitoLlamadaLocal implements Serializable {

	public ExitoLlamadaLocal() {}

	public ExitoLlamadaLocal(Long oid, String codigo)	{
            this.oid=oid;
            this.codigo=codigo;
	}

	@Id
	@Column(name="OID_EXIT_LLAM")
	private Long oid;
	@Column(name="COD_EXIT")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
