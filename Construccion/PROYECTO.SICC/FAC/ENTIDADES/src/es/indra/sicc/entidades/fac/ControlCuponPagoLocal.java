package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_CONTR_CUPON_PAGO")
public class ControlCuponPagoLocal implements Serializable {

	public ControlCuponPagoLocal() {}

	public ControlCuponPagoLocal(Long oid, Long cliente, Date fechaGrabacion, Date fechaUltimoMovimiento, String estadoCuentaAnterior)	{
            this.oid = oid;
	    this.cliente = cliente;
	    this.fechaGrabacion = fechaGrabacion;
	    this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	    this.estadoCuentaAnterior = estadoCuentaAnterior;
	}

	@Id
	@Column(name="OID_CTRL_CUPO_PAGO")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="FEC_GRAB")
        private java.sql.Date fechaGrabacion;
	@Column(name="FEC_ULTI_MOVI")
	private java.sql.Date fechaUltimoMovimiento;
	@Column(name="VAL_ESTA_CUEN_ANTE")
	private String estadoCuentaAnterior;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public java.sql.Date getFechaGrabacion() {return fechaGrabacion;}
      
	public void setFechaGrabacion(java.sql.Date fechaGrabacion){this.fechaGrabacion=fechaGrabacion;}
		
	public java.sql.Date getFechaUltimoMovimiento() {return fechaUltimoMovimiento;}
      
	public void setFechaUltimoMovimiento(java.sql.Date fechaUltimoMovimiento){this.fechaUltimoMovimiento=fechaUltimoMovimiento;}
		
	public String getEstadoCuentaAnterior() {return estadoCuentaAnterior;}
      
	public void setEstadoCuentaAnterior(String estadoCuentaAnterior){this.estadoCuentaAnterior=estadoCuentaAnterior;}
			
	
}
