package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_PERIO_CORPO")
@NamedQueries({
@NamedQuery(name="PeriodoCorporativoLocal.FindByUK",query="Select Object(p) from PeriodoCorporativoLocal p "
+ " where p.codigoPeriodo = ?1"),
@NamedQuery(name="PeriodoCorporativoLocal.FindAll",query="Select Object(p) from PeriodoCorporativoLocal p")
})
public class PeriodoCorporativoLocal implements Serializable {

	public PeriodoCorporativoLocal() {}

	public PeriodoCorporativoLocal(Long oid, Long oidTipoPeriodo, String codigoPeriodo, Long anio)	{
		this.oid=oid;
		this.oidTipoPeriodo = oidTipoPeriodo;
		this.codigoPeriodo = codigoPeriodo;
		this.anio = anio;
	}

	@Id
	@Column(name="OID_PERI")
	private Long oid;
	@Column(name="TIPE_OID_TIPO_PERI")
	private Long oidTipoPeriodo;
	@Column(name="COD_PERI")
	private String codigoPeriodo;
	@Column(name="VAL_ANIO")
	private Long anio;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidTipoPeriodo() {return oidTipoPeriodo;}
      
	public void setOidTipoPeriodo(Long oidTipoPeriodo){this.oidTipoPeriodo=oidTipoPeriodo;}
		
	public String getCodigoPeriodo() {return codigoPeriodo;}
      
	public void setCodigoPeriodo(String codigoPeriodo){this.codigoPeriodo=codigoPeriodo;}
		
	public Long getAnio() {return anio;}
      
	public void setAnio(Long anio){this.anio=anio;}
			
	
}
