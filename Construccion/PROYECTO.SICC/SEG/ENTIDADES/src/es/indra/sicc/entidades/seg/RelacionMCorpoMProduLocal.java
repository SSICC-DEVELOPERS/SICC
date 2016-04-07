package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_MARCA_CORPO_MARCA_PRODU")
@NamedQueries({
@NamedQuery(name="RelacionMCorpoMProduLocal.FindAll",query="select object(o) from RelacionMCorpoMProduLocal o"),
@NamedQuery(name="RelacionMCorpoMProduLocal.FindByUk",query="SELECT OBJECT(a) "
+ " FROM RelacionMCorpoMProduLocal AS a "
+ " WHERE a.oidPais = ?1 and "
+ " a.oidMarcaCorporativa = ?2 and "
+ " a.oidMarcaProducto = ?3")
})
public class RelacionMCorpoMProduLocal implements Serializable {

	public RelacionMCorpoMProduLocal() {}

	public RelacionMCorpoMProduLocal(Long oid, Long oidMarcaCorporativa, Long oidMarcaProducto, Long oidPais) {	
		this.oid=oid;
		this.oidMarcaCorporativa=oidMarcaCorporativa;
		this.oidMarcaProducto=oidMarcaProducto;
		this.oidPais=oidPais;
	}

	@Id
	@Column(name="OID_MARC_CORP_MARC_PROD")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long oidMarcaCorporativa;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long oidMarcaProducto;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidMarcaCorporativa() {return oidMarcaCorporativa;}
      
	public void setOidMarcaCorporativa(Long oidMarcaCorporativa){this.oidMarcaCorporativa=oidMarcaCorporativa;}
		
	public Long getOidMarcaProducto() {return oidMarcaProducto;}
      
	public void setOidMarcaProducto(Long oidMarcaProducto){this.oidMarcaProducto=oidMarcaProducto;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
