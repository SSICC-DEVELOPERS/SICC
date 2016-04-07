package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PRODU_EXIGI_PREMI")
@NamedQueries({
@NamedQuery(name="ProductosExigidosPremiacionLocal.FindAll",query="select object(o) from ProductosExigidosPremiacionLocal o"),
@NamedQuery(name="ProductosExigidosPremiacionLocal.FindByRequisito",query="SELECT OBJECT(a) "
+ " FROM ProductosExigidosPremiacionLocal AS a "
+ " WHERE a.requisitos = ?1")
})
public class ProductosExigidosPremiacionLocal implements Serializable {

	public ProductosExigidosPremiacionLocal() {}

	public ProductosExigidosPremiacionLocal(Long oid, Long reprOidRequPrem, Long maprOidMarcProd)	{
	
		this.oid=oid;
                this.setRequisitos(reprOidRequPrem);
	        this.setMarcaProducto(maprOidMarcProd);
	
	}

	@Id
	@Column(name="OID_PROD_EXIG_PREM")
	private Long oid;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="REPR_OID_REQU_PREM")
	private Long requisitos;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long supergenerico;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getRequisitos() {return requisitos;}
      
	public void setRequisitos(Long requisitos){this.requisitos=requisitos;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getSupergenerico() {return supergenerico;}
      
	public void setSupergenerico(Long supergenerico){this.supergenerico=supergenerico;}
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
			
	
}
