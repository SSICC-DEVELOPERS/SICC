package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_PRODU")
@NamedQueries({
@NamedQuery(name="ComisionesProductosLocal.FindAll",query="select object(o) from ComisionesProductosLocal o"),
@NamedQuery(name="ComisionesProductosLocal.FindByComision",query="select object(c) from ComisionesProductosLocal c where c.comision = ?1")
})
public class ComisionesProductosLocal implements Serializable {

	public ComisionesProductosLocal() {}

	public ComisionesProductosLocal(Long oid, Integer codigo, Long comision, Long tipoProducto, Long tipoInsercionProducto)	{
	
		this.oid=oid;
                this.setCodigo(codigo);
	        this.setComision(comision);
	        this.setTipoProducto(tipoProducto);
	        this.setTipoInsercionProducto(tipoInsercionProducto);
	
	}

	@Id
	@Column(name="OID_COMI_PROD")
	private Long oid;
	@Column(name="COD_COMI_PROD")
	private Integer codigo;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long superGenerico;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="TPRO_OID_TIPO_PROD")
	private Long tipoProducto;
	@Column(name="COPR_OID_COMI_PROD")
	private Long comisionProducto;
	@Column(name="TIPS_OID_TIPO_INSE_PROD")
	private Long tipoInsercionProducto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getSuperGenerico() {return superGenerico;}
      
	public void setSuperGenerico(Long superGenerico){this.superGenerico=superGenerico;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getTipoProducto() {return tipoProducto;}
      
	public void setTipoProducto(Long tipoProducto){this.tipoProducto=tipoProducto;}
		
	public Long getComisionProducto() {return comisionProducto;}
      
	public void setComisionProducto(Long comisionProducto){this.comisionProducto=comisionProducto;}
		
	public Long getTipoInsercionProducto() {return tipoInsercionProducto;}
      
	public void setTipoInsercionProducto(Long tipoInsercionProducto){this.tipoInsercionProducto=tipoInsercionProducto;}
			
	
}
