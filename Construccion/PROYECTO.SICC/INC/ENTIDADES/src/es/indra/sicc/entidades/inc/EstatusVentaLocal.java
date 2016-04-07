package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_ESTAT_VENTA")
@NamedQueries({
@NamedQuery(name="EstatusVentaLocal.FindAll",query="select object(o) from EstatusVentaLocal o"),
@NamedQuery(name="EstatusVentaLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM EstatusVentaLocal AS a "
+ " WHERE a.concurso = ?1"),
@NamedQuery(name="EstatusVentaLocal.FindByUk",query="select object(e) "
+ " from EstatusVentaLocal e "
+ " where e.concurso = ?1 "
+ " and e.estatusVenta = ?2")
})
public class EstatusVentaLocal implements Serializable {

	public EstatusVentaLocal() {}

	public EstatusVentaLocal(Long oid, Long consurso, Long estatusVenta, Long periodoDesde, Long periodoHasta)	{
	
		this.oid=oid;
                this.setConcurso(consurso);
                this.setEstatusVenta(estatusVenta);
                this.setPeriodoDesde(periodoDesde);
                this.setPeriodoHasta(periodoHasta);
	
	}

	@Id
	@Column(name="OID_ESTA_VENT")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="ESTA_OID_ESTA_CLIE")
	private Long estatusVenta;
	@Column(name="PERD_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PERD_OID_PERI_HAST")
	private Long periodoHasta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getEstatusVenta() {return estatusVenta;}
      
	public void setEstatusVenta(Long estatusVenta){this.estatusVenta=estatusVenta;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
			
	
}
