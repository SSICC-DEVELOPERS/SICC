package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_TIPO_PRODU")
public class TipoProductoLocal implements Serializable {

	public TipoProductoLocal() {}

	public TipoProductoLocal(Long oid, Integer cod_tipo_prod) {
	
		this.oid=oid;
                this.codigo=cod_tipo_prod;
	
	}

	@Id
	@Column(name="OID_TIPO_PROD")
	private Long oid;
	@Column(name="COD_TIPO_PROD")
	private Integer codigo;
	@Column(name="DES_TIPO_PROD")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
