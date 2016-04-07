package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INC_PRODU_EXIGI")
@NamedQueries({
@NamedQuery(name="ProductosExigidosLocal.FindAll",query="select object(o) from ProductosExigidosLocal o"),
@NamedQuery(name="ProductosExigidosLocal.FindByProducto",query="SELECT OBJECT(a) "
+ " FROM ProductosExigidosLocal AS a "
+ " WHERE a.productos = ?1")
})
public class ProductosExigidosLocal implements Serializable {

	public ProductosExigidosLocal() {}

	public ProductosExigidosLocal(Long oid, Integer numUnidExig, BigDecimal impMontExig, Integer numPuntExig, Long perdOidPeriHast, Long perdOidPeriDesd, Long prduOidProd)	{
	
		this.oid=oid;
                this.setUnidadesExigidas(numUnidExig);
	        this.setMontoExigido(impMontExig);
	        this.setPuntosExigidos(numPuntExig);
	        this.setPeriodoHasta(perdOidPeriHast);
	        this.setPeriodoDesde(perdOidPeriDesd);
	        this.setProductos(prduOidProd);
	
	}

	@Id
	@Column(name="OID_PROD_EXIG")
	private Long oid;
	@Column(name="NUM_UNID_EXIG")
	private Integer unidadesExigidas;
	@Column(name="IMP_MONT_EXIG")
	private java.math.BigDecimal montoExigido;
	@Column(name="NUM_PUNT_EXIG")
	private Integer puntosExigidos;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long supergenerico;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="PRDU_OID_PROD")
	private Long productos;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;
	@Column(name="PRE2_OID_PROD_EXIG")
	private Long productoExigidoOriginal;
        // vbongiov -- Cambio 20080807 -- 15/04/2009
        @Column(name="IND_AGRUP")
        private String indAgrup;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getUnidadesExigidas() {return unidadesExigidas;}
      
	public void setUnidadesExigidas(Integer unidadesExigidas){this.unidadesExigidas=unidadesExigidas;}
		
	public java.math.BigDecimal getMontoExigido() {return montoExigido;}
      
	public void setMontoExigido(java.math.BigDecimal montoExigido){this.montoExigido=montoExigido;}
		
	public Integer getPuntosExigidos() {return puntosExigidos;}
      
	public void setPuntosExigidos(Integer puntosExigidos){this.puntosExigidos=puntosExigidos;}
		
	public Long getSupergenerico() {return supergenerico;}
      
	public void setSupergenerico(Long supergenerico){this.supergenerico=supergenerico;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getProductos() {return productos;}
      
	public void setProductos(Long productos){this.productos=productos;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
		
	public Long getProductoExigidoOriginal() {return productoExigidoOriginal;}
      
	public void setProductoExigidoOriginal(Long productoExigidoOriginal){this.productoExigidoOriginal=productoExigidoOriginal;}
			
        public String getIndAgrup() {return indAgrup;}
        
        public void setIndAgrup(String indAgrup){this.indAgrup=indAgrup;}
	
}
