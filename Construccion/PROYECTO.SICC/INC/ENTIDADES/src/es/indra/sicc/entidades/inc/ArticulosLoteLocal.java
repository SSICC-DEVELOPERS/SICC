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
@Table(name="INC_ARTIC_LOTE")
@NamedQueries({
@NamedQuery(name="ArticulosLoteLocal.FindAll",query="select object(o) from ArticulosLoteLocal o"),
@NamedQuery(name="ArticulosLoteLocal.FindByLotePremioArticulo",query="SELECT OBJECT(a) "
+ " FROM ArticulosLoteLocal AS a "
+ " WHERE a.lote = ?1")
})
public class ArticulosLoteLocal implements Serializable {

	public ArticulosLoteLocal() {}

	public ArticulosLoteLocal(Long oid, Boolean indDesp, BigDecimal impPrecPubl, Integer numUnid, String codVentFict, Long prodOidProd, Long lopaOidLotePremArti, Boolean indCentroServGar, String indTipoEntrega)	{
	
		this.oid=oid;
                this.setDespacha(indDesp);
	        this.setPrecioPublico(impPrecPubl);
	        this.setNumeroUnidades(numUnid);
	        this.setCodigoVentaFicticio(codVentFict);
	        this.setProducto(prodOidProd);
	        this.setLote(lopaOidLotePremArti);
	        this.setIndCentroServGar(indCentroServGar);
	        this.setIndTipoEntrega(indTipoEntrega);
	
	}

	@Id
	@Column(name="OID_ARTI_LOTE")
	private Long oid;
	@Column(name="IND_DESP")
	private Boolean despacha;
	@Column(name="IMP_PREC_PUBL")
	private java.math.BigDecimal precioPublico;
	@Column(name="NUM_UNID")
	private Integer numeroUnidades;
	@Column(name="COD_VENT_FICT")
	private String codigoVentaFicticio;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="LOPA_OID_LOTE_PREM_ARTI")
	private Long lote;
	@Column(name="IND_CENT_DIST_GARA")
	private Boolean indCentroServGar;
	@Column(name="CESE_OID_CESE_GARA")
	private Long oidCentroServGar;
	@Column(name="NUM_MESE_GARA")
	private Integer numMeses;
	@Column(name="OBS_CENT_DIST")
	private String observaciones;
	@Column(name="IND_TIPO_ENTR_PREM")
	private String indTipoEntrega;
	@Column(name="CESE_OID_CESE_ENTR")
	private Long oidCentroServEntrega;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getDespacha() {return despacha;}
      
	public void setDespacha(Boolean despacha){this.despacha=despacha;}
		
	public java.math.BigDecimal getPrecioPublico() {return precioPublico;}
      
	public void setPrecioPublico(java.math.BigDecimal precioPublico){this.precioPublico=precioPublico;}
		
	public Integer getNumeroUnidades() {return numeroUnidades;}
      
	public void setNumeroUnidades(Integer numeroUnidades){this.numeroUnidades=numeroUnidades;}
		
	public String getCodigoVentaFicticio() {return codigoVentaFicticio;}
      
	public void setCodigoVentaFicticio(String codigoVentaFicticio){this.codigoVentaFicticio=codigoVentaFicticio;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getLote() {return lote;}
      
	public void setLote(Long lote){this.lote=lote;}
		
	public Boolean getIndCentroServGar() {return indCentroServGar;}
      
	public void setIndCentroServGar(Boolean indCentroServGar){this.indCentroServGar=indCentroServGar;}
		
	public Long getOidCentroServGar() {return oidCentroServGar;}
      
	public void setOidCentroServGar(Long oidCentroServGar){this.oidCentroServGar=oidCentroServGar;}
		
	public Integer getNumMeses() {return numMeses;}
      
	public void setNumMeses(Integer numMeses){this.numMeses=numMeses;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getIndTipoEntrega() {return indTipoEntrega;}
      
	public void setIndTipoEntrega(String indTipoEntrega){this.indTipoEntrega=indTipoEntrega;}
		
	public Long getOidCentroServEntrega() {return oidCentroServEntrega;}
      
	public void setOidCentroServEntrega(Long oidCentroServEntrega){this.oidCentroServEntrega=oidCentroServEntrega;}
			
	
}
