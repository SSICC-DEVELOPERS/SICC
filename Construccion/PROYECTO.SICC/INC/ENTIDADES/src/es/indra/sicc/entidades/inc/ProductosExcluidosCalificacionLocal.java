package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PRODU_EXCLU_CALIF")
@NamedQueries({
@NamedQuery(name="ProductosExcluidosCalificacionLocal.FindAll",query="select object(o) from ProductosExcluidosCalificacionLocal o"),
@NamedQuery(name="ProductosExcluidosCalificacionLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM ProductosExcluidosCalificacionLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ProductosExcluidosCalificacionLocal implements Serializable {

	public ProductosExcluidosCalificacionLocal() {}

	public ProductosExcluidosCalificacionLocal(Long oid, Long copaOidParaGral, Long maprOidMarcProd, Long oidPeri, Long oidPeriHasta)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setMarcaProducto(maprOidMarcProd);
	        this.setPeriodoDesde(oidPeri);
	        this.setPeriodoHasta(oidPeriHasta);
	
	}

	@Id
	@Column(name="OID_PROD_EXCL_CALI")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long unidadNegocio;
	@Column(name="PERD_OID_PERI")
	private Long periodoDesde;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long supergenerico;
	@Column(name="PERD_OID_PERI_HASTA")
	private Long periodoHasta;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="GENE_OID_GENE")
	private Long generico;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getUnidadNegocio() {return unidadNegocio;}
      
	public void setUnidadNegocio(Long unidadNegocio){this.unidadNegocio=unidadNegocio;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getSupergenerico() {return supergenerico;}
      
	public void setSupergenerico(Long supergenerico){this.supergenerico=supergenerico;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getGenerico() {return generico;}
      
	public void setGenerico(Long generico){this.generico=generico;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
			
	
}
