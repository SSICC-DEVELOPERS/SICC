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
@Table(name="INT_FUENT_VENTA_PREVI_SAP")
@NamedQueries({
@NamedQuery(name="FuenteVentasPrevistaSAPLocal.FindAll",query="select object(o) from FuenteVentasPrevistaSAPLocal o"),
@NamedQuery(name="FuenteVentasPrevistaSAPLocal.FindByUK",query="select object(o) from FuenteVentasPrevistaSAPLocal o where o.zona = ?1 and o.periodo = ?2 and o.empresa = ?3 and o.centro = ?4")
})
public class FuenteVentasPrevistaSAPLocal implements Serializable {

	public FuenteVentasPrevistaSAPLocal() {}

	public FuenteVentasPrevistaSAPLocal(Long oid, Long zona, Long periodo, Long empresa, Long centro) {
            this.oid=oid;
	    this.zona=zona;
	    this.periodo=periodo;
	    this.empresa=empresa;
	    this.centro=centro;
	}

	@Id
	@Column(name="OID_FUEN_VENT_PREV")
	private Long oid;
	@Column(name="ALMC_OID_ALMA")
	private Long centro;
	@Column(name="FEC_ANYO_COME")
	private Integer annioComercial;
	@Column(name="NUM_ACTI_INIC")
	private Long activasIniciales;
	@Column(name="NUM_ACTI_FINA")
	private Long activasFinales;
	@Column(name="NUM_INGR")
	private Long ingresos;
	@Column(name="NUM_REIN")
	private Long reingresos;
	@Column(name="NUM_EGRE")
	private Long egresos;
	@Column(name="NUM_REZO_RECI")
	private Long rezonificadasRecibidas;
	@Column(name="NUM_REZO_ENTR")
	private Long rezonificadasEntregadas;
	@Column(name="NUM_ORDE")
	private Long numeroOrdenes;
	@Column(name="NUM_PEDI")
	private Long numeroPedidos;
	@Column(name="NUM_UNID_VEND")
	private Long unidadesVendidas;
	@Column(name="NUM_CLIE")
	private Long numeroClientes;
	@Column(name="VAL_VENT_NETA_ESTA")
	private Double ventaNetaEstadisticable;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_CIER")
	private Date fechaCierre;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="MONE_OID_MONE")
	private Long moneda;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="VAL_ACTI_INFL_ZONA")
	private BigDecimal actividadInfladaZona;
	@Column(name="NUM_CONS_CLIE_PRIV")
	private Long nroConsultorasClientesPrivilege;
	@Column(name="NUM_CLIE_INSC_PRIV")
	private Long nroClientesInscritosPrivilege;
	@Column(name="NUM_CLIE_TRAN_PRIV")
	private Long nroClientesTransaccionesPrivilege;
	@Column(name="VAL_RETE_2DO_PEDI")
	private Long retencion2doPedido;
	@Column(name="VAL_RETE_3ER_PEDI")
	private Long retencion3erPedido;
	@Column(name="VAL_RETE_4TO_PEDI")
	private Long retencion4toPedido;
	@Column(name="VAL_RETE_ACTI")
	private Long retencionActivas;
	@Column(name="VAL_PORC_ROTA")
	private BigDecimal porcentajeRotacion;
	@Column(name="NUM_POSI_EGRE")
	private Long posiblesEgresos;
	@Column(name="VAL_RETE_POSI_EGRE")
	private Long retencionPosiblesEgresos;
	@Column(name="VAL_PORC_EGRE")
	private BigDecimal porcentajeEgresos;
	@Column(name="VAL_PUP")
	private BigDecimal pup;
	@Column(name="VAL_PPU")
	private BigDecimal ppu;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCentro() {return centro;}
      
	public void setCentro(Long centro){this.centro=centro;}
		
	public Integer getAnnioComercial() {return annioComercial;}
      
	public void setAnnioComercial(Integer annioComercial){this.annioComercial=annioComercial;}
		
	public Long getActivasIniciales() {return activasIniciales;}
      
	public void setActivasIniciales(Long activasIniciales){this.activasIniciales=activasIniciales;}
		
	public Long getActivasFinales() {return activasFinales;}
      
	public void setActivasFinales(Long activasFinales){this.activasFinales=activasFinales;}
		
	public Long getIngresos() {return ingresos;}
      
	public void setIngresos(Long ingresos){this.ingresos=ingresos;}
		
	public Long getReingresos() {return reingresos;}
      
	public void setReingresos(Long reingresos){this.reingresos=reingresos;}
		
	public Long getEgresos() {return egresos;}
      
	public void setEgresos(Long egresos){this.egresos=egresos;}
		
	public Long getRezonificadasRecibidas() {return rezonificadasRecibidas;}
      
	public void setRezonificadasRecibidas(Long rezonificadasRecibidas){this.rezonificadasRecibidas=rezonificadasRecibidas;}
		
	public Long getRezonificadasEntregadas() {return rezonificadasEntregadas;}
      
	public void setRezonificadasEntregadas(Long rezonificadasEntregadas){this.rezonificadasEntregadas=rezonificadasEntregadas;}
		
	public Long getNumeroOrdenes() {return numeroOrdenes;}
      
	public void setNumeroOrdenes(Long numeroOrdenes){this.numeroOrdenes=numeroOrdenes;}
		
	public Long getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Long numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Long getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Long unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public Long getNumeroClientes() {return numeroClientes;}
      
	public void setNumeroClientes(Long numeroClientes){this.numeroClientes=numeroClientes;}
		
	public Double getVentaNetaEstadisticable() {return ventaNetaEstadisticable;}
      
	public void setVentaNetaEstadisticable(Double ventaNetaEstadisticable){this.ventaNetaEstadisticable=ventaNetaEstadisticable;}
		
	public Date getFechaCierre() {return fechaCierre;}
      
	public void setFechaCierre(Date fechaCierre){this.fechaCierre=fechaCierre;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getMoneda() {return moneda;}
      
	public void setMoneda(Long moneda){this.moneda=moneda;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public BigDecimal getActividadInfladaZona() {return actividadInfladaZona;}
      
	public void setActividadInfladaZona(BigDecimal actividadInfladaZona){this.actividadInfladaZona=actividadInfladaZona;}
		
	public Long getNroConsultorasClientesPrivilege() {return nroConsultorasClientesPrivilege;}
      
	public void setNroConsultorasClientesPrivilege(Long nroConsultorasClientesPrivilege){this.nroConsultorasClientesPrivilege=nroConsultorasClientesPrivilege;}
		
	public Long getNroClientesInscritosPrivilege() {return nroClientesInscritosPrivilege;}
      
	public void setNroClientesInscritosPrivilege(Long nroClientesInscritosPrivilege){this.nroClientesInscritosPrivilege=nroClientesInscritosPrivilege;}
		
	public Long getNroClientesTransaccionesPrivilege() {return nroClientesTransaccionesPrivilege;}
      
	public void setNroClientesTransaccionesPrivilege(Long nroClientesTransaccionesPrivilege){this.nroClientesTransaccionesPrivilege=nroClientesTransaccionesPrivilege;}
		
	public Long getRetencion2doPedido() {return retencion2doPedido;}
      
	public void setRetencion2doPedido(Long retencion2doPedido){this.retencion2doPedido=retencion2doPedido;}
		
	public Long getRetencion3erPedido() {return retencion3erPedido;}
      
	public void setRetencion3erPedido(Long retencion3erPedido){this.retencion3erPedido=retencion3erPedido;}
		
	public Long getRetencion4toPedido() {return retencion4toPedido;}
      
	public void setRetencion4toPedido(Long retencion4toPedido){this.retencion4toPedido=retencion4toPedido;}
		
	public Long getRetencionActivas() {return retencionActivas;}
      
	public void setRetencionActivas(Long retencionActivas){this.retencionActivas=retencionActivas;}
		
	public BigDecimal getPorcentajeRotacion() {return porcentajeRotacion;}
      
	public void setPorcentajeRotacion(BigDecimal porcentajeRotacion){this.porcentajeRotacion=porcentajeRotacion;}
		
	public Long getPosiblesEgresos() {return posiblesEgresos;}
      
	public void setPosiblesEgresos(Long posiblesEgresos){this.posiblesEgresos=posiblesEgresos;}
		
	public Long getRetencionPosiblesEgresos() {return retencionPosiblesEgresos;}
      
	public void setRetencionPosiblesEgresos(Long retencionPosiblesEgresos){this.retencionPosiblesEgresos=retencionPosiblesEgresos;}
		
	public BigDecimal getPorcentajeEgresos() {return porcentajeEgresos;}
      
	public void setPorcentajeEgresos(BigDecimal porcentajeEgresos){this.porcentajeEgresos=porcentajeEgresos;}
		
	public BigDecimal getPup() {return pup;}
      
	public void setPup(BigDecimal pup){this.pup=pup;}
		
	public BigDecimal getPpu() {return ppu;}
      
	public void setPpu(BigDecimal ppu){this.ppu=ppu;}
			
	
}
