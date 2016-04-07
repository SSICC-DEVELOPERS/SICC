package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_VENTA_DIAPR_PRODU")
@NamedQueries({
@NamedQuery(name="VentaDiaPorProductoLocal.FindAll",query="select object(o) from VentaDiaPorProductoLocal o")
})
public class VentaDiaPorProductoLocal implements Serializable {

	public VentaDiaPorProductoLocal() {}

	public VentaDiaPorProductoLocal(Long oid, Date fecha, Long subAcceso, Long periodo, Long almacen, Long tipoCliente, Long tipoSolicitud, Long sociedad, Long producto, Long cicloVida, Long tipoOferta, Long promocion, Long moneda)	{
            this.oid=oid;
	    this.fecha=fecha;
	    this.subAcceso=subAcceso;
	    this.periodo=periodo;
	    this.almacen=almacen;
	    this.tipoCliente=tipoCliente;
	    this.tipoSolicitud=tipoSolicitud;
	    this.sociedad=sociedad;
	    this.producto=producto;
	    this.cicloVida=cicloVida;
	    this.tipoOferta=tipoOferta;
	    this.condicionPromocion=promocion;
	    this.monedaTransaccion=moneda;
	}
        
	@Id
	@Column(name="OID_VENT_DIAP_PROD")
	private Long oid;
        //@Temporal(TemporalType.DATE)
        @Column(name="FEC_FECH")
	private Date fecha;
	@Column(name="COD_VENT")
	private String codVenta;
	@Column(name="IND_FLAG_VENT")
	private Boolean flagVenta;
	@Column(name="NUM_UNID_VEND")
	private Long unidadesVendidas;
	@Column(name="NUM_UNID_FALT")
	private Long unidadesFaltantes;
	@Column(name="UNID_DEVU")
	private Long unidadesDevueltas;
	@Column(name="NUM_UNID_ANUL")
	private Long unidadesAnuladas;
	@Column(name="NUM_UNID_CANJ")
	private Long unidadesCanje;
	@Column(name="NUM_UNID_TRUE")
	private Long unidadesTrueque;
	@Column(name="IMP_VENT_NETA_ATEN")
	private Float ventaNetaAtendida;
	@Column(name="IMP_VENT_NETA_FALT")
	private Float ventaNetaFaltante;
	@Column(name="IMP_VENT_NETA_DEVO")
	private Float ventaNetaDevolucion;
	@Column(name="IMP_VENT_NETA_ANUL")
	private Float ventaNetaAnulacion;
	@Column(name="IMP_VENT_NETA_CANJ")
	private Float ventaNetaCanje;
	@Column(name="IMP_VENT_NETA_TRUE")
	private Float ventaNetaTrueque;
	@Column(name="IMP_VENT_BRUT_REAL")
	private Float ventaBrutaReal;
	@Column(name="IMP_VENT_BRUT_FALT")
	private Float ventaBrutaFaltante;
	@Column(name="SBAC_OID_SBAC")
	private Long subAcceso;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="CNDP_OID_COND_PROM")
	private Long condicionPromocion;
	@Column(name="MONE_OID_MONE")
	private Long monedaTransaccion;
	@Column(name="ZORG_OID_REGI")
	private Long oidRegion;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Date getFecha() {return fecha;}
      
	public void setFecha(Date fecha){this.fecha=fecha;}
		
	public String getCodVenta() {return codVenta;}
      
	public void setCodVenta(String codVenta){this.codVenta=codVenta;}
		
	public Boolean getFlagVenta() {return flagVenta;}
      
	public void setFlagVenta(Boolean flagVenta){this.flagVenta=flagVenta;}
		
	public Long getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Long unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public Long getUnidadesFaltantes() {return unidadesFaltantes;}
      
	public void setUnidadesFaltantes(Long unidadesFaltantes){this.unidadesFaltantes=unidadesFaltantes;}
		
	public Long getUnidadesDevueltas() {return unidadesDevueltas;}
      
	public void setUnidadesDevueltas(Long unidadesDevueltas){this.unidadesDevueltas=unidadesDevueltas;}
		
	public Long getUnidadesAnuladas() {return unidadesAnuladas;}
      
	public void setUnidadesAnuladas(Long unidadesAnuladas){this.unidadesAnuladas=unidadesAnuladas;}
		
	public Long getUnidadesCanje() {return unidadesCanje;}
      
	public void setUnidadesCanje(Long unidadesCanje){this.unidadesCanje=unidadesCanje;}
		
	public Long getUnidadesTrueque() {return unidadesTrueque;}
      
	public void setUnidadesTrueque(Long unidadesTrueque){this.unidadesTrueque=unidadesTrueque;}
		
	public Float getVentaNetaAtendida() {return ventaNetaAtendida;}
      
	public void setVentaNetaAtendida(Float ventaNetaAtendida){this.ventaNetaAtendida=ventaNetaAtendida;}
		
	public Float getVentaNetaFaltante() {return ventaNetaFaltante;}
      
	public void setVentaNetaFaltante(Float ventaNetaFaltante){this.ventaNetaFaltante=ventaNetaFaltante;}
		
	public Float getVentaNetaDevolucion() {return ventaNetaDevolucion;}
      
	public void setVentaNetaDevolucion(Float ventaNetaDevolucion){this.ventaNetaDevolucion=ventaNetaDevolucion;}
		
	public Float getVentaNetaAnulacion() {return ventaNetaAnulacion;}
      
	public void setVentaNetaAnulacion(Float ventaNetaAnulacion){this.ventaNetaAnulacion=ventaNetaAnulacion;}
		
	public Float getVentaNetaCanje() {return ventaNetaCanje;}
      
	public void setVentaNetaCanje(Float ventaNetaCanje){this.ventaNetaCanje=ventaNetaCanje;}
		
	public Float getVentaNetaTrueque() {return ventaNetaTrueque;}
      
	public void setVentaNetaTrueque(Float ventaNetaTrueque){this.ventaNetaTrueque=ventaNetaTrueque;}
		
	public Float getVentaBrutaReal() {return ventaBrutaReal;}
      
	public void setVentaBrutaReal(Float ventaBrutaReal){this.ventaBrutaReal=ventaBrutaReal;}
		
	public Float getVentaBrutaFaltante() {return ventaBrutaFaltante;}
      
	public void setVentaBrutaFaltante(Float ventaBrutaFaltante){this.ventaBrutaFaltante=ventaBrutaFaltante;}
		
	public Long getSubAcceso() {return subAcceso;}
      
	public void setSubAcceso(Long subAcceso){this.subAcceso=subAcceso;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getCondicionPromocion() {return condicionPromocion;}
      
	public void setCondicionPromocion(Long condicionPromocion){this.condicionPromocion=condicionPromocion;}
		
	public Long getMonedaTransaccion() {return monedaTransaccion;}
      
	public void setMonedaTransaccion(Long monedaTransaccion){this.monedaTransaccion=monedaTransaccion;}
		
	public Long getOidRegion() {return oidRegion;}
      
	public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
			
	
}
