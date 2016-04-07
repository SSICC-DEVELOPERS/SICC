package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CONCU_VARIA_VENTA_GEREN")
@NamedQueries({
@NamedQuery(name="ConcursoVariablesVentaGerentesLocal.FindAll",query="select object(o) from ConcursoVariablesVentaGerentesLocal o"),
@NamedQuery(name="ConcursoVariablesVentaGerentesLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ConcursoVariablesVentaGerentesLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ConcursoVariablesVentaGerentesLocal implements Serializable {

	public ConcursoVariablesVentaGerentesLocal() {}

	public ConcursoVariablesVentaGerentesLocal(Long oid, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_CONC_VARI_VENT_GERE")
	private Long oid;
	@Column(name="IND_ACVA")
	private Boolean activas;
	@Column(name="IND_INGR")
	private Boolean ingreso;
	@Column(name="IND_REIN")
	private Boolean reingreso;
	@Column(name="IND_EGRE")
	private Boolean egresos;
	@Column(name="IND_ENTR")
	private Boolean entregadas;
	@Column(name="IND_RECI")
	private Boolean recibidas;
	@Column(name="IND_CAPI")
	private Boolean capitalizacion;
	@Column(name="IND_ACTI_FINA")
	private Boolean activasFinales;
	@Column(name="IND_ADAD")
	private Boolean actividad;
	@Column(name="IND_NUME_PEDI")
	private Boolean numeroPedidos;
	@Column(name="IND_PREC_PROM_UNIT")
	private Boolean precioPromedioUnitario;
	@Column(name="IND_PROM_VENT_PEDI")
	private Boolean promedioVentaPedido;
	@Column(name="IND_PROM_ORDE_PEDI")
	private Boolean promedioOrdenesPedido;
	@Column(name="IND_RETE")
	private Boolean retencion;
	@Column(name="IND_VENT_ESTA")
	private Boolean ventaEstadisticable;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="IND_PROM_UNID_PEDI")
	private Boolean promedioUnidadesPedido;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getActivas() {return activas;}
      
	public void setActivas(Boolean activas){this.activas=activas;}
		
	public Boolean getIngreso() {return ingreso;}
      
	public void setIngreso(Boolean ingreso){this.ingreso=ingreso;}
		
	public Boolean getReingreso() {return reingreso;}
      
	public void setReingreso(Boolean reingreso){this.reingreso=reingreso;}
		
	public Boolean getEgresos() {return egresos;}
      
	public void setEgresos(Boolean egresos){this.egresos=egresos;}
		
	public Boolean getEntregadas() {return entregadas;}
      
	public void setEntregadas(Boolean entregadas){this.entregadas=entregadas;}
		
	public Boolean getRecibidas() {return recibidas;}
      
	public void setRecibidas(Boolean recibidas){this.recibidas=recibidas;}
		
	public Boolean getCapitalizacion() {return capitalizacion;}
      
	public void setCapitalizacion(Boolean capitalizacion){this.capitalizacion=capitalizacion;}
		
	public Boolean getActivasFinales() {return activasFinales;}
      
	public void setActivasFinales(Boolean activasFinales){this.activasFinales=activasFinales;}
		
	public Boolean getActividad() {return actividad;}
      
	public void setActividad(Boolean actividad){this.actividad=actividad;}
		
	public Boolean getNumeroPedidos() {return numeroPedidos;}
      
	public void setNumeroPedidos(Boolean numeroPedidos){this.numeroPedidos=numeroPedidos;}
		
	public Boolean getPrecioPromedioUnitario() {return precioPromedioUnitario;}
      
	public void setPrecioPromedioUnitario(Boolean precioPromedioUnitario){this.precioPromedioUnitario=precioPromedioUnitario;}
		
	public Boolean getPromedioVentaPedido() {return promedioVentaPedido;}
      
	public void setPromedioVentaPedido(Boolean promedioVentaPedido){this.promedioVentaPedido=promedioVentaPedido;}
		
	public Boolean getPromedioOrdenesPedido() {return promedioOrdenesPedido;}
      
	public void setPromedioOrdenesPedido(Boolean promedioOrdenesPedido){this.promedioOrdenesPedido=promedioOrdenesPedido;}
		
	public Boolean getRetencion() {return retencion;}
      
	public void setRetencion(Boolean retencion){this.retencion=retencion;}
		
	public Boolean getVentaEstadisticable() {return ventaEstadisticable;}
      
	public void setVentaEstadisticable(Boolean ventaEstadisticable){this.ventaEstadisticable=ventaEstadisticable;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Boolean getPromedioUnidadesPedido() {return promedioUnidadesPedido;}
      
	public void setPromedioUnidadesPedido(Boolean promedioUnidadesPedido){this.promedioUnidadesPedido=promedioUnidadesPedido;}
			
	
}
