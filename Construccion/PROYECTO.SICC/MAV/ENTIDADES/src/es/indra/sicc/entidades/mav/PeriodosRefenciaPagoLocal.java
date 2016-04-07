package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_PERIO_REFER_PAGOS")
public class PeriodosRefenciaPagoLocal implements Serializable {

	public PeriodosRefenciaPagoLocal() {}

	public PeriodosRefenciaPagoLocal(Long oid, Long perd_oid_peri, Long repi_oid_resu_pago_inte)	{
	
		this.oid=oid;
                this.oidPeriodo=perd_oid_peri;
                this.oidResumenPagoInter=repi_oid_resu_pago_inte;
	
	}

	@Id
	@Column(name="OID_PERI_REFE_PAGO")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="REPI_OID_RESU_PAGO_INTE")
	private Long oidResumenPagoInter;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidResumenPagoInter() {return oidResumenPagoInter;}
      
	public void setOidResumenPagoInter(Long oidResumenPagoInter){this.oidResumenPagoInter=oidResumenPagoInter;}
			
	
}
