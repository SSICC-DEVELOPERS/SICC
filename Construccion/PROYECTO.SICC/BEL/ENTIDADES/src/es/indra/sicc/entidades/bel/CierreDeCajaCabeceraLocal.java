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
@Table(name="BEL_CIERR_CAJA_CABEC")
public class CierreDeCajaCabeceraLocal implements Serializable {

	public CierreDeCajaCabeceraLocal() {}

	public CierreDeCajaCabeceraLocal(Long oid, Long movimientoCajaCabecera, Long numeroMovimiento, Character estadoCierreCaja, Timestamp fechaCierreCaja, String usuario) {
		this.oid=oid;
                this.movimientoCajaCabecera = movimientoCajaCabecera;
                this.numeroMovimiento = numeroMovimiento;
                this.estadoCierreCaja = estadoCierreCaja;
                this.fechaCierreCaja = fechaCierreCaja;
                this.usuario = usuario;
	}

	@Id
	@Column(name="OID_CABE")
	private Long oid;
	@Column(name="MCAC_OID_CABE")
	private Long movimientoCajaCabecera;
	@Column(name="NUM_MOVI")
	private Long numeroMovimiento;
	@Column(name="VAL_ESTA_CIER_CAJA")
	private Character estadoCierreCaja;
	@Column(name="FEC_CIER_CAJA")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fechaCierreCaja;
	@Column(name="VAL_USUA")
	private String usuario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMovimientoCajaCabecera() {return movimientoCajaCabecera;}
      
	public void setMovimientoCajaCabecera(Long movimientoCajaCabecera){this.movimientoCajaCabecera=movimientoCajaCabecera;}
		
	public Long getNumeroMovimiento() {return numeroMovimiento;}
      
	public void setNumeroMovimiento(Long numeroMovimiento){this.numeroMovimiento=numeroMovimiento;}
		
	public Character getEstadoCierreCaja() {return estadoCierreCaja;}
      
	public void setEstadoCierreCaja(Character estadoCierreCaja){this.estadoCierreCaja=estadoCierreCaja;}
		
	public java.sql.Timestamp getFechaCierreCaja() {return fechaCierreCaja;}
      
	public void setFechaCierreCaja(java.sql.Timestamp fechaCierreCaja){this.fechaCierreCaja=fechaCierreCaja;}
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
			
	
}
