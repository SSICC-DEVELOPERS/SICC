package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_MARCA_PRODU")
@NamedQueries({
@NamedQuery(name="MarcaProductoLocal.FindAll",query="select object(o) from MarcaProductoLocal o"),
@NamedQuery(name="MarcaProductoLocal.FindByUk",query="SELECT OBJECT(m) "
+ " FROM MarcaProductoLocal AS m"
+ " WHERE m.codigo=?1")
})
public class MarcaProductoLocal implements Serializable {

	public MarcaProductoLocal() {}

	public MarcaProductoLocal(Long oid, String codMarcProd, String desMarcProd)	{
		this.oid=oid;
		this.codigo = codMarcProd;
		this.descripcion = desMarcProd;
	}

	@Id
	@Column(name="OID_MARC_PROD")
	private Long oid;
	@Column(name="COD_MARC_PROD")
	private String codigo;
	@Column(name="DES_MARC_PROD")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
