package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_MODUL")
@NamedQueries({
@NamedQuery(name="ModuloLocal.FindAll", query="SELECT OBJECT(o) FROM ModuloLocal o")
})
public class ModuloLocal implements Serializable {

	public ModuloLocal() {}

	public ModuloLocal(Long oid, String codigo)	{
		this.oid=oid;
		this.codigo = codigo;
	}

	@Id
	@Column(name="OID_MODU")
	private Long oid;
	@Column(name="COD_MODU")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
