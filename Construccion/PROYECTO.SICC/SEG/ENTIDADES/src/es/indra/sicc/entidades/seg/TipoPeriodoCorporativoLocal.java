package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_TIPO_PERIO")
@NamedQueries({
@NamedQuery(name="TipoPeriodoCorporativoLocal.FindAll",query="select object(o) from TipoPeriodoCorporativoLocal o"),
@NamedQuery(name="TipoPeriodoCorporativoLocal.FindByUk",query="SELECT OBJECT(o) "
+ " FROM TipoPeriodoCorporativoLocal AS o"
+ " WHERE o.codigoTipoPeriodo=?1")
})
public class TipoPeriodoCorporativoLocal implements Serializable {

	public TipoPeriodoCorporativoLocal() {}

	public TipoPeriodoCorporativoLocal(Long oid, String codigoTipoPeriodo, Long duracion, Long numeroPeriodosAnio)	{
		this.oid = oid;
		this.codigoTipoPeriodo = codigoTipoPeriodo;
		this.duracion = duracion;
		this.numeroPeriodosAnio = numeroPeriodosAnio;
	}

	@Id
	@Column(name="OID_TIPO_PERI")
	private Long oid;
	@Column(name="COD_TIPO_PERI")
	private String codigoTipoPeriodo;
	@Column(name="NUM_DIAS")
	private Long duracion;
	@Column(name="NUM_PERI_ANIO")
	private Long numeroPeriodosAnio;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoPeriodo() {return codigoTipoPeriodo;}
      
	public void setCodigoTipoPeriodo(String codigoTipoPeriodo){this.codigoTipoPeriodo=codigoTipoPeriodo;}
		
	public Long getDuracion() {return duracion;}
      
	public void setDuracion(Long duracion){this.duracion=duracion;}
		
	public Long getNumeroPeriodosAnio() {return numeroPeriodosAnio;}
      
	public void setNumeroPeriodosAnio(Long numeroPeriodosAnio){this.numeroPeriodosAnio=numeroPeriodosAnio;}
			
	
}
