package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PRODU_DESCU")
@NamedQueries({
@NamedQuery(name="ProductoDescuentoLocal.FindAll",query="select object(o) from ProductoDescuentoLocal o"),
@NamedQuery(name="ProductoDescuentoLocal.FindByPremioDescuento",query="SELECT OBJECT(a) "
+ " FROM ProductoDescuentoLocal AS a "
+ " WHERE a.premioDescuento = ?1")
})
public class ProductoDescuentoLocal implements Serializable {

	public ProductoDescuentoLocal() {}

	public ProductoDescuentoLocal(Long oid, Long maprOidMarcProd, Long prdeOidPremDesc)	{
	
		this.oid=oid;
                this.setMarcaProducto(maprOidMarcProd);
	        this.setPremioDescuento(prdeOidPremDesc);
	
	}

	@Id
	@Column(name="OID_PROD_DESC")
	private Long oid;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long supergenerico;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="PRDE_OID_PREM_DESC")
	private Long premioDescuento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getSupergenerico() {return supergenerico;}
      
	public void setSupergenerico(Long supergenerico){this.supergenerico=supergenerico;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getPremioDescuento() {return premioDescuento;}
      
	public void setPremioDescuento(Long premioDescuento){this.premioDescuento=premioDescuento;}
			
	
}
