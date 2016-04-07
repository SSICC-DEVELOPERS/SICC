package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_ESTAD_CAMPA")
@NamedQueries({
@NamedQuery(name="MatrizEstadisticaCampanyaLocal.FindAll",query="select object(o) from MatrizEstadisticaCampanyaLocal o"),
@NamedQuery(name="MatrizEstadisticaCampanyaLocal.FindByUK",query="SELECT OBJECT(t) FROM MatrizEstadisticaCampanyaLocal AS t WHERE t.cabeceraMF = ?1")
})
public class MatrizEstadisticaCampanyaLocal implements Serializable {

	public MatrizEstadisticaCampanyaLocal() {}

	public MatrizEstadisticaCampanyaLocal(Long oid, Long cabecera) {
	
		this.oid=oid;
                this.cabeceraMF=cabecera;
	
	}

	@Id
	@Column(name="OID_MATR_ESTA_CAMP")
	private Long oid;
	@Column(name="MFCA_OID_CABE")
	private Long cabeceraMF;
	@Column(name="NUM_PEDI_ESTI")
	private Long numeroEstimadoPedidos;
	@Column(name="NUM_UNID_ESTI")
	private Long numeroEstimadoUnidades;
	@Column(name="NUM_CLIE_ESTI")
	private Long numeroEstimadoClientes;
	@Column(name="IMP_MONT_ESTI")
	private java.math.BigDecimal montoEstimadoLocal;
	@Column(name="IMP_MONT_ESTI_DOLA")
	private java.math.BigDecimal montoEstimadoDolares;
	@Column(name="NUM_PEDI")
	private Long numeroRealPedidos;
	@Column(name="NUM_UNID")
	private Long numeroRealUnidades;
	@Column(name="NUM_CLIE")
	private Long numeroRealClientes;
	@Column(name="IMP_MONT_FACT_LOCA")
	private java.math.BigDecimal montoFacturadoLocal;
	@Column(name="IMP_MONT_FACT_DOLA")
	private java.math.BigDecimal montoFacturadoDolares;
	@Column(name="IMP_MONT_PEDI_ANUL")
	private Long numeroPedidosAnulados;
	@Column(name="IMP_MONT_ANUL_LOCA")
	private java.math.BigDecimal montoLocalAnulaciones;
	@Column(name="NUM_REAL_PEDI_DEVU")
	private Long numeroPedidosDevueltos;
	@Column(name="IMP_MONT_REAL_MONE_LOCA_DEVO")
	private java.math.BigDecimal montoLocalDevoluciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCabeceraMF() {return cabeceraMF;}
      
	public void setCabeceraMF(Long cabeceraMF){this.cabeceraMF=cabeceraMF;}
		
	public Long getNumeroEstimadoPedidos() {return numeroEstimadoPedidos;}
      
	public void setNumeroEstimadoPedidos(Long numeroEstimadoPedidos){this.numeroEstimadoPedidos=numeroEstimadoPedidos;}
		
	public Long getNumeroEstimadoUnidades() {return numeroEstimadoUnidades;}
      
	public void setNumeroEstimadoUnidades(Long numeroEstimadoUnidades){this.numeroEstimadoUnidades=numeroEstimadoUnidades;}
		
	public Long getNumeroEstimadoClientes() {return numeroEstimadoClientes;}
      
	public void setNumeroEstimadoClientes(Long numeroEstimadoClientes){this.numeroEstimadoClientes=numeroEstimadoClientes;}
		
	public java.math.BigDecimal getMontoEstimadoLocal() {return montoEstimadoLocal;}
      
	public void setMontoEstimadoLocal(java.math.BigDecimal montoEstimadoLocal){this.montoEstimadoLocal=montoEstimadoLocal;}
		
	public java.math.BigDecimal getMontoEstimadoDolares() {return montoEstimadoDolares;}
      
	public void setMontoEstimadoDolares(java.math.BigDecimal montoEstimadoDolares){this.montoEstimadoDolares=montoEstimadoDolares;}
		
	public Long getNumeroRealPedidos() {return numeroRealPedidos;}
      
	public void setNumeroRealPedidos(Long numeroRealPedidos){this.numeroRealPedidos=numeroRealPedidos;}
		
	public Long getNumeroRealUnidades() {return numeroRealUnidades;}
      
	public void setNumeroRealUnidades(Long numeroRealUnidades){this.numeroRealUnidades=numeroRealUnidades;}
		
	public Long getNumeroRealClientes() {return numeroRealClientes;}
      
	public void setNumeroRealClientes(Long numeroRealClientes){this.numeroRealClientes=numeroRealClientes;}
		
	public java.math.BigDecimal getMontoFacturadoLocal() {return montoFacturadoLocal;}
      
	public void setMontoFacturadoLocal(java.math.BigDecimal montoFacturadoLocal){this.montoFacturadoLocal=montoFacturadoLocal;}
		
	public java.math.BigDecimal getMontoFacturadoDolares() {return montoFacturadoDolares;}
      
	public void setMontoFacturadoDolares(java.math.BigDecimal montoFacturadoDolares){this.montoFacturadoDolares=montoFacturadoDolares;}
		
	public Long getNumeroPedidosAnulados() {return numeroPedidosAnulados;}
      
	public void setNumeroPedidosAnulados(Long numeroPedidosAnulados){this.numeroPedidosAnulados=numeroPedidosAnulados;}
		
	public java.math.BigDecimal getMontoLocalAnulaciones() {return montoLocalAnulaciones;}
      
	public void setMontoLocalAnulaciones(java.math.BigDecimal montoLocalAnulaciones){this.montoLocalAnulaciones=montoLocalAnulaciones;}
		
	public Long getNumeroPedidosDevueltos() {return numeroPedidosDevueltos;}
      
	public void setNumeroPedidosDevueltos(Long numeroPedidosDevueltos){this.numeroPedidosDevueltos=numeroPedidosDevueltos;}
		
	public java.math.BigDecimal getMontoLocalDevoluciones() {return montoLocalDevoluciones;}
      
	public void setMontoLocalDevoluciones(java.math.BigDecimal montoLocalDevoluciones){this.montoLocalDevoluciones=montoLocalDevoluciones;}
			
	
}
