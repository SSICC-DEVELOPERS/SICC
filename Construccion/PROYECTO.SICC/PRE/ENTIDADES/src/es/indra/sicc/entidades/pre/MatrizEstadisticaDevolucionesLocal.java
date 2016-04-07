package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_ESTAD_PRODU_DEVOL")
@NamedQueries({
@NamedQuery(name="MatrizEstadisticaDevolucionesLocal.FindAll",query="select object(o) from MatrizEstadisticaDevolucionesLocal o"),
@NamedQuery(name="MatrizEstadisticaDevolucionesLocal.FindByPeriodo",query="SELECT OBJECT(t) FROM MatrizEstadisticaDevolucionesLocal AS t WHERE t.oidPeriodo = ?1")
})
public class MatrizEstadisticaDevolucionesLocal implements Serializable {

	public MatrizEstadisticaDevolucionesLocal() {}

	public MatrizEstadisticaDevolucionesLocal(Long oid, Long oidProducto,
                        Long oidTipoOperacion, Long oidPeriodo, Long oidMotivoDevolucion) {
	
		this.oid=oid;
                this.oidProducto=oidProducto;
                this.oidTipoOperacion=oidTipoOperacion;
                this.oidPeriodo=oidPeriodo;
                this.oidMotivoDevolucion=oidMotivoDevolucion;
	
	}

	@Id
	@Column(name="OID_MATR_ESTA_PROD_DEVO")
	private Long oid;
	@Column(name="PROD_OID_PROD")
	private Long oidProducto;
	@Column(name="NUM_UNID")
	private Long unidades;
	@Column(name="IMP_MONT_DEVO")
	private java.math.BigDecimal montoDevolucion;
	@Column(name="TIOP_OID_TIPO_OPER")
	private Long oidTipoOperacion;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="MODV_OID_MOTI_DEVO")
	private Long oidMotivoDevolucion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidProducto() {return oidProducto;}
      
	public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
		
	public Long getUnidades() {return unidades;}
      
	public void setUnidades(Long unidades){this.unidades=unidades;}
		
	public java.math.BigDecimal getMontoDevolucion() {return montoDevolucion;}
      
	public void setMontoDevolucion(java.math.BigDecimal montoDevolucion){this.montoDevolucion=montoDevolucion;}
		
	public Long getOidTipoOperacion() {return oidTipoOperacion;}
      
	public void setOidTipoOperacion(Long oidTipoOperacion){this.oidTipoOperacion=oidTipoOperacion;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidMotivoDevolucion() {return oidMotivoDevolucion;}
      
	public void setOidMotivoDevolucion(Long oidMotivoDevolucion){this.oidMotivoDevolucion=oidMotivoDevolucion;}
			
	
}
