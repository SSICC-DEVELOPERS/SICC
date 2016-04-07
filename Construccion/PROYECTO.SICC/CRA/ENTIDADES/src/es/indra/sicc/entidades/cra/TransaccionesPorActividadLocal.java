package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CRA_TRANS_ACTIV")
public class TransaccionesPorActividadLocal implements Serializable {

	public TransaccionesPorActividadLocal() {}

	public TransaccionesPorActividadLocal(Long oid, Long oidTran, Long cact_oid_acti, 
                        Date fec_tran_acti)	{
	
		this.oid=oid;
                this.oidTransaccion = oidTran;
                this.oidActividad = cact_oid_acti;
                this.fechaHora = fec_tran_acti;
	}

	@Id
	@Column(name="OID_TRAN_ACTI")
	private Long oid;
	@Column(name="TRAN_OID_TRAN")
	private Long oidTransaccion;
	@Column(name="CACT_OID_ACTI")
	private Long oidActividad;
	@Column(name="FEC_TRAN_ACTI")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaHora;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidTransaccion() {return oidTransaccion;}
      
	public void setOidTransaccion(Long oidTransaccion){this.oidTransaccion=oidTransaccion;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
//	public java.util.Date getFechaHora() {return fechaHora;}
      
//	public void setFechaHora(java.util.Date fechaHora){this.fechaHora=fechaHora;}
			
	
}
