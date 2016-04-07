package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_ESTAD_CODIG_VENTA")
@NamedQueries({
@NamedQuery(name="MatrizEstadisticaCodigoVentaLocal.FindAll",query="select object(o) from MatrizEstadisticaCodigoVentaLocal o"),
@NamedQuery(name="MatrizEstadisticaCodigoVentaLocal.FindByUK",query="SELECT OBJECT(t) FROM MatrizEstadisticaCodigoVentaLocal AS t WHERE t.matrizFacturacion = ?1")
})
public class MatrizEstadisticaCodigoVentaLocal implements Serializable {

	public MatrizEstadisticaCodigoVentaLocal() {}

	public MatrizEstadisticaCodigoVentaLocal(Long oid, Long matrizFacturacion) {
	
		this.oid=oid;
                this.matrizFacturacion=matrizFacturacion;
	
	}

	@Id
	@Column(name="OID_MATR_ESTA_CODI")
	private Long oid;
	@Column(name="MAFA_OID_MATR_FACT")
	private Long matrizFacturacion;
	@Column(name="NUM_UNID_ESTI")
	private Long unidadesEstimadas;
	@Column(name="IMP_MONT_ESTI")
	private java.math.BigDecimal montoEstimadoFacturar;
	@Column(name="NUM_UNID_FACT")
	private Long unidadesFacturadas;
	@Column(name="IMP_MONT_FACT")
	private java.math.BigDecimal montoFacturado;
	@Column(name="NUM_UNID_FALTA")
	private Long unidadesFaltantes;
	@Column(name="IMP_MONT_FALT")
	private java.math.BigDecimal montoFaltante;
	@Column(name="NUM_UNID_DEVU")
	private Long unidadesDevueltas;
	@Column(name="IMP_MONT_DEVU")
	private java.math.BigDecimal montoDevuelto;
	@Column(name="NUM_UNID_CANJ")
	private Long unidadesCanjeadas;
	@Column(name="IMP_MONT_CANJ")
	private java.math.BigDecimal montoCanjeado;
	@Column(name="NUM_UNID_ANUL")
	private Long unidadesAnuladas;
	@Column(name="IMP_MONT_ANUL")
	private java.math.BigDecimal montoAnulado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMatrizFacturacion() {return matrizFacturacion;}
      
	public void setMatrizFacturacion(Long matrizFacturacion){this.matrizFacturacion=matrizFacturacion;}
		
	public Long getUnidadesEstimadas() {return unidadesEstimadas;}
      
	public void setUnidadesEstimadas(Long unidadesEstimadas){this.unidadesEstimadas=unidadesEstimadas;}
		
	public java.math.BigDecimal getMontoEstimadoFacturar() {return montoEstimadoFacturar;}
      
	public void setMontoEstimadoFacturar(java.math.BigDecimal montoEstimadoFacturar){this.montoEstimadoFacturar=montoEstimadoFacturar;}
		
	public Long getUnidadesFacturadas() {return unidadesFacturadas;}
      
	public void setUnidadesFacturadas(Long unidadesFacturadas){this.unidadesFacturadas=unidadesFacturadas;}
		
	public java.math.BigDecimal getMontoFacturado() {return montoFacturado;}
      
	public void setMontoFacturado(java.math.BigDecimal montoFacturado){this.montoFacturado=montoFacturado;}
		
	public Long getUnidadesFaltantes() {return unidadesFaltantes;}
      
	public void setUnidadesFaltantes(Long unidadesFaltantes){this.unidadesFaltantes=unidadesFaltantes;}
		
	public java.math.BigDecimal getMontoFaltante() {return montoFaltante;}
      
	public void setMontoFaltante(java.math.BigDecimal montoFaltante){this.montoFaltante=montoFaltante;}
		
	public Long getUnidadesDevueltas() {return unidadesDevueltas;}
      
	public void setUnidadesDevueltas(Long unidadesDevueltas){this.unidadesDevueltas=unidadesDevueltas;}
		
	public java.math.BigDecimal getMontoDevuelto() {return montoDevuelto;}
      
	public void setMontoDevuelto(java.math.BigDecimal montoDevuelto){this.montoDevuelto=montoDevuelto;}
		
	public Long getUnidadesCanjeadas() {return unidadesCanjeadas;}
      
	public void setUnidadesCanjeadas(Long unidadesCanjeadas){this.unidadesCanjeadas=unidadesCanjeadas;}
		
	public java.math.BigDecimal getMontoCanjeado() {return montoCanjeado;}
      
	public void setMontoCanjeado(java.math.BigDecimal montoCanjeado){this.montoCanjeado=montoCanjeado;}
		
	public Long getUnidadesAnuladas() {return unidadesAnuladas;}
      
	public void setUnidadesAnuladas(Long unidadesAnuladas){this.unidadesAnuladas=unidadesAnuladas;}
		
	public java.math.BigDecimal getMontoAnulado() {return montoAnulado;}
      
	public void setMontoAnulado(java.math.BigDecimal montoAnulado){this.montoAnulado=montoAnulado;}
			
	
}
