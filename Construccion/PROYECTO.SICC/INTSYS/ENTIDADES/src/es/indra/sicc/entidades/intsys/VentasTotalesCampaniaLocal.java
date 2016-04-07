package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_VENTA_TOTAL_CAMPA")
@NamedQueries({
@NamedQuery(name="VentasTotalesCampaniaLocal.FindAll",query="select object(o) from VentasTotalesCampaniaLocal o")
})
public class VentasTotalesCampaniaLocal implements Serializable {

	public VentasTotalesCampaniaLocal() {}

	public VentasTotalesCampaniaLocal(Long oid, Long periodo, Long sociedad, Long almacen, Long moneda) {
            this.oid=oid;
	    this.periodo=periodo;
	    this.sociedad=sociedad;
	    this.almacen=almacen;
	    this.monedaTransaccion=moneda;
	}

	@Id
	@Column(name="OID_VENT_TOTA_CAMP")
	private Long oid;
	@Column(name="NUM_UNID_VEND")
	private Long unidadesVendidas;
	@Column(name="NUM_UNID_FALT")
	private Long unidadesFaltantes;
	@Column(name="NUM_UNID_DEVU")
	private Long unidadesDevueltas;
	@Column(name="NUM_UNID_ANUL")
	private Long unidadesAnuladas;
	@Column(name="NUM_UNID_CANJ")
	private Long unidadesCanje;
	@Column(name="NUM_UNID_TRUE")
	private Long unidadesTrueque;
	@Column(name="IMP_VENT_NETA_ATEN")
	private BigDecimal ventaNetaAtendida;
	@Column(name="IMP_VENT_NETA_FALT")
	private BigDecimal ventaNetaFaltante;
	@Column(name="IMP_VENT_NETA_DEVO")
	private BigDecimal ventaNetaDevolucion;
	@Column(name="IMP_VENT_NETA_ANUL")
	private BigDecimal ventaNetaAnulacion;
	@Column(name="IMP_VENT_NETA_CANJ")
	private BigDecimal ventaNetaCanje;
	@Column(name="IMP_VENT_NETA_TRUE")
	private BigDecimal ventaNetaTrueque;
	@Column(name="VENT_BRUT_REAL")
	private BigDecimal ventaBrutaReal;
	@Column(name="IMP_VENT_BRUT_FALT")
	private BigDecimal ventaBrutaFaltante;
	@Column(name="NUM_ZONA")
	private Long numeroZonas;
	@Column(name="NUM_ORDE")
	private Long numeroOrdenes;
	@Column(name="NUM_PEDI")
	private Long numeroPedidos;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_CIER")
	private Date fechaCierre;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="MONE_OID_MONE")
	private Long monedaTransaccion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
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
		
	public BigDecimal getVentaNetaAtendida() {return ventaNetaAtendida;}
      
	public void setVentaNetaAtendida(BigDecimal ventaNetaAtendida){this.ventaNetaAtendida=ventaNetaAtendida;}
		
	public BigDecimal getVentaNetaFaltante() {return ventaNetaFaltante;}
      
	public void setVentaNetaFaltante(BigDecimal ventaNetaFaltante){this.ventaNetaFaltante=ventaNetaFaltante;}
		
	public BigDecimal getVentaNetaDevolucion() {return ventaNetaDevolucion;}
      
	public void setVentaNetaDevolucion(BigDecimal ventaNetaDevolucion){this.ventaNetaDevolucion=ventaNetaDevolucion;}
		
	public BigDecimal getVentaNetaAnulacion() {return ventaNetaAnulacion;}
      
	public void setVentaNetaAnulacion(BigDecimal ventaNetaAnulacion){this.ventaNetaAnulacion=ventaNetaAnulacion;}
		
	public BigDecimal getVentaNetaCanje() {return ventaNetaCanje;}
      
	public void setVentaNetaCanje(BigDecimal ventaNetaCanje){this.ventaNetaCanje=ventaNetaCanje;}
		
	public BigDecimal getVentaNetaTrueque() {return ventaNetaTrueque;}
      
	public void setVentaNetaTrueque(BigDecimal ventaNetaTrueque){this.ventaNetaTrueque=ventaNetaTrueque;}
		
	public BigDecimal getVentaBrutaReal() {return ventaBrutaReal;}
      
	public void setVentaBrutaReal(BigDecimal ventaBrutaReal){this.ventaBrutaReal=ventaBrutaReal;}
		
	public BigDecimal getVentaBrutaFaltante() {return ventaBrutaFaltante;}
      
	public void setVentaBrutaFaltante(BigDecimal ventaBrutaFaltante){this.ventaBrutaFaltante=ventaBrutaFaltante;}
		
	public Long getNumeroZonas() {return numeroZonas;}
      
	public void setNumeroZonas(Long numeroZonas){this.numeroZonas=numeroZonas;}
		
	public Long getNumeroOrdenes() {return numeroOrdenes;}
      
	public void setNumeroOrdenes(Long numeroOrdenes){this.numeroOrdenes=numeroOrdenes;}
		
	public Long getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Long numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Date getFechaCierre() {return fechaCierre;}
      
	public void setFechaCierre(Date fechaCierre){this.fechaCierre=fechaCierre;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getMonedaTransaccion() {return monedaTransaccion;}
      
	public void setMonedaTransaccion(Long monedaTransaccion){this.monedaTransaccion=monedaTransaccion;}
			
	
}
