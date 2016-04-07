package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_TIPO_BALAN")
@NamedQueries({
@NamedQuery(name="TipoBalanceoLocal.FindAll",query="select object(o) from TipoBalanceoLocal o")
})
public class TipoBalanceoLocal implements Serializable {

	public TipoBalanceoLocal() {}

	public TipoBalanceoLocal(Long oid, Character codigo)	{
	
		this.oid=oid;
                this.setCodigo(codigo);
	
	}

	@Id
	@Column(name="OID_TIPO_BALA")
	private Long oid;
	@Column(name="COD_TIPO_BALA")
	private Character codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Character getCodigo() {return codigo;}
      
	public void setCodigo(Character codigo){this.codigo=codigo;}
			
	
}
