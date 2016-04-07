package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_TIPO_ERROR")
@NamedQueries({
@NamedQuery(name="TiposErrorLocal.FindByUK",query="SELECT OBJECT(t) FROM TiposErrorLocal AS t WHERE t.codigo = ?1")
})
public class TiposErrorLocal implements Serializable {

	public TiposErrorLocal() {}

	public TiposErrorLocal(Long oid, String codigo) {
	
		this.oid=oid;
                this.codigo=codigo;                
	
	}

	@Id
	@Column(name="OID_ERRO")
	private Long oid;
	@Column(name="COD_ERRO")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
