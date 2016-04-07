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
@Table(name="INC_METAS_VENTA_PROYE_SUBGE")
@NamedQueries({
@NamedQuery(name="MetasVentaProyectadaSubgerenciaVentaLocal.FindAll",query="select object(o) from MetasVentaProyectadaSubgerenciaVentaLocal o"),
@NamedQuery(name="MetasVentaProyectadaSubgerenciaVentaLocal.FindByConcurso",query="select object(o) from MetasVentaProyectadaSubgerenciaVentaLocal o where o.concurso = ?1"),
@NamedQuery(name="MetasVentaProyectadaSubgerenciaVentaLocal.FindByUk",query="select OBJECT (a) "
+ " from MetasVentaProyectadaSubgerenciaVentaLocal as a "
+ " where a.periodoCalculado = ?1 "
+ " and a.cliente = ?2 "
+ " and a.concurso= ?3 "
+ " and a.subgerencia = ?4")
})
public class MetasVentaProyectadaSubgerenciaVentaLocal implements Serializable {

	public MetasVentaProyectadaSubgerenciaVentaLocal() {}

	public MetasVentaProyectadaSubgerenciaVentaLocal(Long oid, Integer valAnioCome, Integer numActiInic, Integer numActiFina, Integer impIngr, Integer impRein, Integer impEgre, Integer numOrde, Integer numPedi, Integer numUnidVend, Integer numClie, BigDecimal impVentNetaEsta, Long clieOidClie, Long zsgvOidSubgVent, Long copaOidParaGral, Long perdOidPeri)	{
	
		this.oid=oid;
                this.setAnioComercial(valAnioCome);
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
	        this.setCliente(clieOidClie);
	        this.setSubgerencia(zsgvOidSubgVent);
	        this.setConcurso(copaOidParaGral);
	        this.setPeriodoCalculado(perdOidPeri);
	
	}

	@Id
	@Column(name="OID_META_VENT_PROY_SUBG")
	private Long oid;
	@Column(name="VAL_ANIO_COME")
	private Integer anioComercial;
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
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerencia;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoCalculado;
	@Column(name="NUM_RECI")
	private Long numeroRecibidas;
	@Column(name="NUM_ENTR")
	private Long numeroEntregadas;
	@Column(name="VAL_ROTA")
	private java.math.BigDecimal rotacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getAnioComercial() {return anioComercial;}
      
	public void setAnioComercial(Integer anioComercial){this.anioComercial=anioComercial;}
		
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
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getSubgerencia() {return subgerencia;}
      
	public void setSubgerencia(Long subgerencia){this.subgerencia=subgerencia;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoCalculado() {return periodoCalculado;}
      
	public void setPeriodoCalculado(Long periodoCalculado){this.periodoCalculado=periodoCalculado;}
		
	public Long getNumeroRecibidas() {return numeroRecibidas;}
      
	public void setNumeroRecibidas(Long numeroRecibidas){this.numeroRecibidas=numeroRecibidas;}
		
	public Long getNumeroEntregadas() {return numeroEntregadas;}
      
	public void setNumeroEntregadas(Long numeroEntregadas){this.numeroEntregadas=numeroEntregadas;}
		
	public java.math.BigDecimal getRotacion() {return rotacion;}
      
	public void setRotacion(java.math.BigDecimal rotacion){this.rotacion=rotacion;}
			
	
}
