package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PRODU_BONIF")
@NamedQueries({
@NamedQuery(name="ProductosBonificadosLocal.FindAll",query="select object(o) from ProductosBonificadosLocal o"),
@NamedQuery(name="ProductosBonificadosLocal.FindByProducto",query="SELECT OBJECT(a) "
+ " FROM ProductosBonificadosLocal AS a "
+ " WHERE a.productos = ?1")
})
public class ProductosBonificadosLocal implements Serializable {

	public ProductosBonificadosLocal() {}

	public ProductosBonificadosLocal(Long oid, Integer numPuntUnid, Integer valFactMult, Long perdOidPeriDesd, Long perdOidPeriHast, Long prduOidProd)	{
	
		this.oid=oid;
                this.setPuntosUnidad(numPuntUnid);
	        this.setFactorMultiplicador(valFactMult);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setPeriodoHasta(perdOidPeriHast);
	        this.setProductos(prduOidProd);
	
	}

	@Id
	@Column(name="OID_PROD_BONI")
	private Long oid;
	@Column(name="NUM_PUNT_UNID")
	private Integer puntosUnidad;
	@Column(name="VAL_FACT_MULT")
	private Integer factorMultiplicador;
	@Column(name="PRDU_OID_PROD")
	private Long productos;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long supergenerico;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getPuntosUnidad() {return puntosUnidad;}
      
	public void setPuntosUnidad(Integer puntosUnidad){this.puntosUnidad=puntosUnidad;}
		
	public Integer getFactorMultiplicador() {return factorMultiplicador;}
      
	public void setFactorMultiplicador(Integer factorMultiplicador){this.factorMultiplicador=factorMultiplicador;}
		
	public Long getProductos() {return productos;}
      
	public void setProductos(Long productos){this.productos=productos;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getSupergenerico() {return supergenerico;}
      
	public void setSupergenerico(Long supergenerico){this.supergenerico=supergenerico;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
			
	
}
