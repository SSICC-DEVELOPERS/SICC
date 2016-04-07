package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_HISTO_PROYE_REAL_DEMAN")
public class HistoricoProyeccionRealDemandaLocal implements Serializable {

	public HistoricoProyeccionRealDemandaLocal() {}

	public HistoricoProyeccionRealDemandaLocal(Long oid, Long pais, Long periodo, Long zona, Long producto, Integer pedidosEstimadosMarketingZona, Integer pedidosFacturadosZonas, BigDecimal proyeccionParcialProductoZona, BigDecimal pupProductoZona, BigDecimal pupCampanya, Boolean cierreZona, Boolean cierreCampanya)	{
            this.oid=oid;
	    this.pais = pais;
	    this.periodo = periodo;
	    this.zona = zona;
	    this.producto = producto;
	    this.pedidosEstimadosMarketingZona = pedidosEstimadosMarketingZona;
	    this.pedidosFacturadosZonas = pedidosFacturadosZonas;
	    this.proyeccionParcialProductoZona = proyeccionParcialProductoZona;
	    this.pupProductoZona = pupProductoZona;
	    this.pupCampanya = pupCampanya;
	    this.cierreZona = cierreZona;
	    this.cierreCampanya = cierreCampanya;	
	}

	@Id
	@Column(name="OID_HIST")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="NUM_PEDI_ESTI_MARK_ZONA")
	private Integer pedidosEstimadosMarketingZona;
	@Column(name="NUM_PEDI_FACT_ZONA")
	private Integer pedidosFacturadosZonas;
	@Column(name="VAL_PROY_PARC_PROD_ZONA")
	private java.math.BigDecimal proyeccionParcialProductoZona;
	@Column(name="VAL_PUP_PROD_ZONA")
	private java.math.BigDecimal pupProductoZona;
	@Column(name="VAL_PUP_CAMP")
	private java.math.BigDecimal pupCampanya;
	@Column(name="VAL_CIER_ZONA")
	private Boolean cierreZona;
	@Column(name="VAL_CIER_CAMP")
	private Boolean cierreCampanya;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Integer getPedidosEstimadosMarketingZona() {return pedidosEstimadosMarketingZona;}
      
	public void setPedidosEstimadosMarketingZona(Integer pedidosEstimadosMarketingZona){this.pedidosEstimadosMarketingZona=pedidosEstimadosMarketingZona;}
		
	public Integer getPedidosFacturadosZonas() {return pedidosFacturadosZonas;}
      
	public void setPedidosFacturadosZonas(Integer pedidosFacturadosZonas){this.pedidosFacturadosZonas=pedidosFacturadosZonas;}
		
	public java.math.BigDecimal getProyeccionParcialProductoZona() {return proyeccionParcialProductoZona;}
      
	public void setProyeccionParcialProductoZona(java.math.BigDecimal proyeccionParcialProductoZona){this.proyeccionParcialProductoZona=proyeccionParcialProductoZona;}
		
	public java.math.BigDecimal getPupProductoZona() {return pupProductoZona;}
      
	public void setPupProductoZona(java.math.BigDecimal pupProductoZona){this.pupProductoZona=pupProductoZona;}
		
	public java.math.BigDecimal getPupCampanya() {return pupCampanya;}
      
	public void setPupCampanya(java.math.BigDecimal pupCampanya){this.pupCampanya=pupCampanya;}
		
	public Boolean getCierreZona() {return cierreZona;}
      
	public void setCierreZona(Boolean cierreZona){this.cierreZona=cierreZona;}
		
	public Boolean getCierreCampanya() {return cierreCampanya;}
      
	public void setCierreCampanya(Boolean cierreCampanya){this.cierreCampanya=cierreCampanya;}
			
	
}
