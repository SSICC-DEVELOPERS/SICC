package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BEL_MOVIM_CAJA_CABEC")
public class MovimientosDeCajaCabeceraLocal implements Serializable {

	public MovimientosDeCajaCabeceraLocal() {}

        public MovimientosDeCajaCabeceraLocal(Long oid, Long caja, Long numeroMovimiento, Timestamp fecha, String usuario) {
                this.oid=oid;
                this.caja = caja;
                this.numeroMovimiento = numeroMovimiento;
                this.fecha = fecha;
                this.usuario = usuario;
        }

	public MovimientosDeCajaCabeceraLocal(Long oid, Long caja, Long numeroMovimiento, Timestamp fecha, String usuario, String observaciones) {
		this.oid=oid;
                this.caja = caja;
                this.numeroMovimiento = numeroMovimiento;
                this.fecha = fecha;
                this.usuario = usuario;
                this.observaciones = observaciones;
	}

	@Id
	@Column(name="OID_CABE")
	private Long oid;
	@Column(name="CAJA_OID_CAJA")
	private Long caja;
	@Column(name="NUM_MOVI")
	private Long numeroMovimiento;
	@Column(name="FEC_MOVI")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fecha;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="VAL_USUA")
	private String usuario;
	@Column(name="IMP_VUEL")
	private java.math.BigDecimal diferenciaVuelto;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidSoliCabe;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCaja() {return caja;}
      
	public void setCaja(Long caja){this.caja=caja;}
		
	public Long getNumeroMovimiento() {return numeroMovimiento;}
      
	public void setNumeroMovimiento(Long numeroMovimiento){this.numeroMovimiento=numeroMovimiento;}
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public java.math.BigDecimal getDiferenciaVuelto() {return diferenciaVuelto;}
      
	public void setDiferenciaVuelto(java.math.BigDecimal diferenciaVuelto){this.diferenciaVuelto=diferenciaVuelto;}
		
	public Long getOidSoliCabe() {return oidSoliCabe;}
      
	public void setOidSoliCabe(Long oidSoliCabe){this.oidSoliCabe=oidSoliCabe;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
			
	
}
