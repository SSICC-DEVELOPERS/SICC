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
@Table(name="INC_METAS_VENTA_PROYE_ZONA")
@NamedQueries({
@NamedQuery(name="MetasVentaProyectadaZonaLocal.FindAll",query="select object(o) from MetasVentaProyectadaZonaLocal o"),
@NamedQuery(name="MetasVentaProyectadaZonaLocal.FindByConcurso",query="SELECT OBJECT(a) FROM MetasVentaProyectadaZonaLocal AS a WHERE a.concurso = ?1"),
@NamedQuery(name="MetasVentaProyectadaZonaLocal.FindByUk",query="SELECT OBJECT (a) "
+ " FROM MetasVentaProyectadaZonaLocal AS a "
+ " WHERE a.periodoCalculado = ?1 "
+ " AND a.cliente = ?2 "
+ " AND a.concurso = ?3 "
+ " AND a.zona = ?4")
})
public class MetasVentaProyectadaZonaLocal implements Serializable {

	public MetasVentaProyectadaZonaLocal() {}

	public MetasVentaProyectadaZonaLocal(Long oid, Integer numActiInic, Integer numActiFina, Integer impIngr, Integer impRein, Integer impEgre, Integer numOrde, Integer numPedi, Integer numUnidVend, Integer numClie, BigDecimal impVentNetaEsta, Long zzonOidZona, Long clieOidClie, Long copaOidParaGral, Long perdOidPeri)	{
	
		this.oid=oid;
                this.setActivasIniciales(numActiInic);
	        this.setActivasFinales(numActiFina);
	        this.setIngresos(impIngr);
	        this.setReingresos(impRein);
	        this.setEgresos(impEgre);
	        this.setNumeroOrdenes(numOrde);
	        this.setNumeroPedidos(numPedi);
	        this.setUnidadesVendidas(numUnidVend);
	        this.setNumeroClientes(numClie);
	        this.setVentaNetaEstadisticable(impVentNetaEsta);
	        this.setZona(zzonOidZona);
	        this.setCliente(clieOidClie);
	        this.setConcurso(copaOidParaGral);
	        this.setPeriodoCalculado(perdOidPeri);
	
	}

	@Id
	@Column(name="OID_META_VENT_PROY_ZONA")
	private Long oid;
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
	@Column(name="IMP_CAPI")
	private java.math.BigDecimal capitalizacion;
	@Column(name="IMP_ACTI")
	private java.math.BigDecimal actividad;
	@Column(name="IMP_PREC_PROM_UNIT")
	private java.math.BigDecimal precioPromedioUnitario;
	@Column(name="VAL_PROM_VENT_PEDI")
	private java.math.BigDecimal promedioVentaPedido;
	@Column(name="VAL_PROM_UNID_PEDI")
	private java.math.BigDecimal promedioUnidadesPedido;
	@Column(name="VAL_PROM_ORDE_PEDI")
	private java.math.BigDecimal promedioOrdenesPedido;
	@Column(name="IMP_RETE")
	private java.math.BigDecimal retencion;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoCalculado;
	@Column(name="NUM_RECI")
	private Long numeroRecibidas;
	@Column(name="NUM_ENTR")
	private Long numeroEntregadas;
	@Column(name="VAL_ROTA")
	private java.math.BigDecimal valorRota;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
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
		
	public java.math.BigDecimal getPromedioVentaPedido() {return promedioVentaPedido;}
      
	public void setPromedioVentaPedido(java.math.BigDecimal promedioVentaPedido){this.promedioVentaPedido=promedioVentaPedido;}
		
	public java.math.BigDecimal getPromedioUnidadesPedido() {return promedioUnidadesPedido;}
      
	public void setPromedioUnidadesPedido(java.math.BigDecimal promedioUnidadesPedido){this.promedioUnidadesPedido=promedioUnidadesPedido;}
		
	public java.math.BigDecimal getPromedioOrdenesPedido() {return promedioOrdenesPedido;}
      
	public void setPromedioOrdenesPedido(java.math.BigDecimal promedioOrdenesPedido){this.promedioOrdenesPedido=promedioOrdenesPedido;}
		
	public java.math.BigDecimal getRetencion() {return retencion;}
      
	public void setRetencion(java.math.BigDecimal retencion){this.retencion=retencion;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoCalculado() {return periodoCalculado;}
      
	public void setPeriodoCalculado(Long periodoCalculado){this.periodoCalculado=periodoCalculado;}
		
	public Long getNumeroRecibidas() {return numeroRecibidas;}
      
	public void setNumeroRecibidas(Long numeroRecibidas){this.numeroRecibidas=numeroRecibidas;}
		
	public Long getNumeroEntregadas() {return numeroEntregadas;}
      
	public void setNumeroEntregadas(Long numeroEntregadas){this.numeroEntregadas=numeroEntregadas;}
		
	public java.math.BigDecimal getValorRota() {return valorRota;}
      
	public void setValorRota(java.math.BigDecimal valorRota){this.valorRota=valorRota;}
			
	
}
