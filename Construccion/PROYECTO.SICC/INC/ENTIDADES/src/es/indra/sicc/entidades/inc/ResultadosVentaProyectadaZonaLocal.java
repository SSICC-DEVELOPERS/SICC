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
@Table(name="INC_RESUL_VENTA_PROYE_ZONA")
@NamedQueries({
@NamedQuery(name="ResultadosVentaProyectadaZonaLocal.FindAll",query="select object(o) from ResultadosVentaProyectadaZonaLocal o")
})
public class ResultadosVentaProyectadaZonaLocal implements Serializable {

	public ResultadosVentaProyectadaZonaLocal() {}

	public ResultadosVentaProyectadaZonaLocal(Long oidVPZona, Integer activasIniciales, Integer activasFinales, Integer ingresos, Integer reingresos, Integer egresos, Integer numeroOrdenes, Integer numeroPedidos, Integer unidadesVendidas, Integer numeroClientes, BigDecimal ventaNetaEstadisticable, Long meta, Long periodoCalculado)	{
	
		this.oidVPZona=oidVPZona;
                this.setActivasIniciales(activasIniciales);
	        this.setActivasFinales(activasFinales);
	        this.setIngresos(ingresos);
	        this.setReingresos(reingresos);
	        this.setEgresos(egresos);
	        this.setNumeroOrdenes(numeroOrdenes);
	        this.setNumeroPedidos(numeroPedidos); 
	        this.setUnidadesVendidas(unidadesVendidas);
	        this.setNumeroClientes(numeroClientes);
	        this.setVentaNetaEstadisticable(ventaNetaEstadisticable);
	        this.setMeta(meta);
	        this.setPeriodoCalculado(periodoCalculado);
	        
	
	}

	@Id
	@Column(name="OID_RESU_VENT_PROY")
	private Long oidVPZona;
	@Column(name="NUM_ACTI_INIC")
	private Integer activasIniciales;
	@Column(name="NUM_ACTI_FINA")
	private Integer activasFinales;
	@Column(name="IMP_INGR")
	private Integer ingresos;
	@Column(name="IMP_REIN")
	private Integer reingresos;
	@Column(name="IMP_EGRE")
	private Integer egresos;
	@Column(name="NUM_ORDE")
	private Integer numeroOrdenes;
	@Column(name="NUM_PEDI")
	private Integer numeroPedidos;
	@Column(name="NUM_UNID_VEND")
	private Integer unidadesVendidas;
	@Column(name="NUM_CLIE")
	private Integer numeroClientes;
	@Column(name="IMP_VENT_NETA_ESTA")
	private java.math.BigDecimal ventaNetaEstadisticable;
	@Column(name="VAL_CAPI")
	private java.math.BigDecimal capitalizacion;
	@Column(name="VAL_ACTI")
	private java.math.BigDecimal actividad;
	@Column(name="IMP_PREC_MEDI_UNIT")
	private java.math.BigDecimal precioPromedioUnitario;
	@Column(name="VAL_PROM_VENT_PEDI")
	private java.math.BigDecimal promedioVentaPedidos;
	@Column(name="VAL_PROM_UNID_PEDI")
	private java.math.BigDecimal promedioUnidadesPedido;
	@Column(name="VAL_PROM_ORDE_PEDI")
	private java.math.BigDecimal promedioOrdenesPedido;
	@Column(name="VAL_RETE")
	private java.math.BigDecimal retencion;
	@Column(name="MVPZ_OID_META_VENT_PROY_ZONA")
	private Long meta;
	@Column(name="PERD_OID_PERI")
	private Long periodoCalculado;
	@Column(name="VAL_ROTA")
	private java.math.BigDecimal rotacion;
	@Column(name="NUM_ENTR")
	private Integer entregadas;
	@Column(name="NUM_RECI")
	private Integer recibidas;

	
	public Long getOidVPZona() {return oidVPZona;}
      
	//public void setOidVPZona(Long oidVPZona){this.oidVPZona=oidVPZona;}
	
	public Long getPrimaryKey() {return oidVPZona;}		
		
	public Integer getActivasIniciales() {return activasIniciales;}
      
	public void setActivasIniciales(Integer activasIniciales){this.activasIniciales=activasIniciales;}
		
	public Integer getActivasFinales() {return activasFinales;}
      
	public void setActivasFinales(Integer activasFinales){this.activasFinales=activasFinales;}
		
	public Integer getIngresos() {return ingresos;}
      
	public void setIngresos(Integer ingresos){this.ingresos=ingresos;}
		
	public Integer getReingresos() {return reingresos;}
      
	public void setReingresos(Integer reingresos){this.reingresos=reingresos;}
		
	public Integer getEgresos() {return egresos;}
      
	public void setEgresos(Integer egresos){this.egresos=egresos;}
		
	public Integer getNumeroOrdenes() {return numeroOrdenes;}
      
	public void setNumeroOrdenes(Integer numeroOrdenes){this.numeroOrdenes=numeroOrdenes;}
		
	public Integer getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Integer numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Integer getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Integer unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public Integer getNumeroClientes() {return numeroClientes;}
      
	public void setNumeroClientes(Integer numeroClientes){this.numeroClientes=numeroClientes;}
		
	public java.math.BigDecimal getVentaNetaEstadisticable() {return ventaNetaEstadisticable;}
      
	public void setVentaNetaEstadisticable(java.math.BigDecimal ventaNetaEstadisticable){this.ventaNetaEstadisticable=ventaNetaEstadisticable;}
		
	public java.math.BigDecimal getCapitalizacion() {return capitalizacion;}
      
	public void setCapitalizacion(java.math.BigDecimal capitalizacion){this.capitalizacion=capitalizacion;}
		
	public java.math.BigDecimal getActividad() {return actividad;}
      
	public void setActividad(java.math.BigDecimal actividad){this.actividad=actividad;}
		
	public java.math.BigDecimal getPrecioPromedioUnitario() {return precioPromedioUnitario;}
      
	public void setPrecioPromedioUnitario(java.math.BigDecimal precioPromedioUnitario){this.precioPromedioUnitario=precioPromedioUnitario;}
		
	public java.math.BigDecimal getPromedioVentaPedidos() {return promedioVentaPedidos;}
      
	public void setPromedioVentaPedidos(java.math.BigDecimal promedioVentaPedidos){this.promedioVentaPedidos=promedioVentaPedidos;}
		
	public java.math.BigDecimal getPromedioUnidadesPedido() {return promedioUnidadesPedido;}
      
	public void setPromedioUnidadesPedido(java.math.BigDecimal promedioUnidadesPedido){this.promedioUnidadesPedido=promedioUnidadesPedido;}
		
	public java.math.BigDecimal getPromedioOrdenesPedido() {return promedioOrdenesPedido;}
      
	public void setPromedioOrdenesPedido(java.math.BigDecimal promedioOrdenesPedido){this.promedioOrdenesPedido=promedioOrdenesPedido;}
		
	public java.math.BigDecimal getRetencion() {return retencion;}
      
	public void setRetencion(java.math.BigDecimal retencion){this.retencion=retencion;}
		
	public Long getMeta() {return meta;}
      
	public void setMeta(Long meta){this.meta=meta;}
		
	public Long getPeriodoCalculado() {return periodoCalculado;}
      
	public void setPeriodoCalculado(Long periodoCalculado){this.periodoCalculado=periodoCalculado;}
		
	public java.math.BigDecimal getRotacion() {return rotacion;}
      
	public void setRotacion(java.math.BigDecimal rotacion){this.rotacion=rotacion;}	
		
	public Integer getEntregadas() {return entregadas;}
      
	public void setEntregadas(Integer entregadas){this.entregadas=entregadas;}
		
	public Integer getRecibidas() {return recibidas;}
      
	public void setRecibidas(Integer recibidas){this.recibidas=recibidas;}
			
	
}
