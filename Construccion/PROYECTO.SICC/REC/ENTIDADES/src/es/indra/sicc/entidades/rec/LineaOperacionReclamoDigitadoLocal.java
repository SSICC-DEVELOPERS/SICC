package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_LINEA_OPERA_RECLA_DIGIT")
@NamedQueries({
@NamedQuery(name="LineaOperacionReclamoDigitadoLocal.FindAll",query="select object(o) from LineaOperacionReclamoDigitadoLocal o"),
@NamedQuery(name="LineaOperacionReclamoDigitadoLocal.FindByOperacionTipoMovimiento",query="SELECT OBJECT(o) FROM LineaOperacionReclamoDigitadoLocal AS o WHERE o.operacion = ?1 AND o.tipoMovimiento = ?2"),
@NamedQuery(name="LineaOperacionReclamoDigitadoLocal.FindByOidOperacionReclamoDigitado",query="SELECT OBJECT(o) FROM LineaOperacionReclamoDigitadoLocal AS o WHERE o.operacion = ?1")
})
public class LineaOperacionReclamoDigitadoLocal implements Serializable {

	public LineaOperacionReclamoDigitadoLocal() {}

	public LineaOperacionReclamoDigitadoLocal(Long oid, Integer numeroLinea, String codigoVenta, Integer unidadesReclamadas, Long operacion, Long tipoMovimiento)	{
	
		this.oid=oid;
                this.numeroLinea=numeroLinea;
                this.codigoVenta=codigoVenta;
                this.unidadesReclamadas=unidadesReclamadas;
                this.operacion=operacion;
                this.tipoMovimiento=tipoMovimiento;
	
	}

	@Id
	@Column(name="OID_LINE_OPER_RECL_DIGI")
	private Long oid;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="COD_VENT")
	private String codigoVenta;
	@Column(name="NUM_UNID_RECL")
	private Integer unidadesReclamadas;
	@Column(name="NUM_UNID_DEVU")
	private Integer unidadesDevueltas;
	@Column(name="RODG_OID_OPER_RECL_DIGI")
	private Long operacion;
	@Column(name="MODV_OID_MOTI_DEVO")
	private Long motivoDevolucion;
	@Column(name="TIMO_OID_TIPO_MOVI")
	private Long tipoMovimiento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public String getCodigoVenta() {return codigoVenta;}
      
	public void setCodigoVenta(String codigoVenta){this.codigoVenta=codigoVenta;}
		
	public Integer getUnidadesReclamadas() {return unidadesReclamadas;}
      
	public void setUnidadesReclamadas(Integer unidadesReclamadas){this.unidadesReclamadas=unidadesReclamadas;}
		
	public Integer getUnidadesDevueltas() {return unidadesDevueltas;}
      
	public void setUnidadesDevueltas(Integer unidadesDevueltas){this.unidadesDevueltas=unidadesDevueltas;}
		
	public Long getOperacion() {return operacion;}
      
	public void setOperacion(Long operacion){this.operacion=operacion;}
		
	public Long getMotivoDevolucion() {return motivoDevolucion;}
      
	public void setMotivoDevolucion(Long motivoDevolucion){this.motivoDevolucion=motivoDevolucion;}
		
	public Long getTipoMovimiento() {return tipoMovimiento;}
      
	public void setTipoMovimiento(Long tipoMovimiento){this.tipoMovimiento=tipoMovimiento;}
			
	
}
