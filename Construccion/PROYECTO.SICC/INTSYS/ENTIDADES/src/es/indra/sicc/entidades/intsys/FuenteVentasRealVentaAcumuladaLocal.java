package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_FUENT_VENTA_REAL_VACUM")
@NamedQueries({
@NamedQuery(name="FuenteVentasRealVentaAcumuladaLocal.FindAll",query="select object(o) from FuenteVentasRealVentaAcumuladaLocal o")
})
public class FuenteVentasRealVentaAcumuladaLocal implements Serializable {

	public FuenteVentasRealVentaAcumuladaLocal() {}

	public FuenteVentasRealVentaAcumuladaLocal(Long oid, Long tipoSolicitud, Long tipoCliente, Long region, Long sociedad, Long zona, Long almacen, Long pais, Long periodo, Long territorio)	{
            this.oid=oid;
	    this.tipoSolicitud=tipoSolicitud;
	    this.tipoCliente=tipoCliente;
	    this.region=region;
	    this.sociedad=sociedad;
	    this.zona=zona;
	    this.almacen=almacen;
	    this.pais=pais;
	    this.periodo=periodo;
	    this.territorio=territorio;
	}

	@Id
	@Column(name="OID_FUEN_VENT_REAL_VACU")
	private Long oid;
	@Column(name="NUM_ORDE")
	private Long numeroOrdenes;
	@Column(name="NUM_PEDI")
	private Long numeroPedidos;
	@Column(name="NUM_UNID_VEND")
	private Long unidadesVendidas;
	@Column(name="NUM_CLIE")
	private Long numeroClientes;
	@Column(name="IMP_VENT_NETA_ESTA")
	private Double ventaNetaEstadisticable;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_CIER")
	private Date fechaCierre;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="TERR_OID_TERR")
	private Long territorio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
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
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
			
	
}
