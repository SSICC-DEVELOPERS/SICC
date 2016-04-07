package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_CONFI_REPAR")
@NamedQueries({
@NamedQuery(name="ConfirmacionRepartoLARLocal.FindAll",query="select object(o) from ConfirmacionRepartoLARLocal o")
})
public class ConfirmacionRepartoLARLocal implements Serializable {

	public ConfirmacionRepartoLARLocal() {}

	public ConfirmacionRepartoLARLocal(Long oid, Integer numSecu, Date fecFact, String valChip, Date fecRepa, String valHoraRepa, Long zzonOidZona, Long tdreOidTipoDireRepa)	{
            this.oid=oid;
	    this.secuencia=numSecu;
	    this.fechaFacturacion=fecFact;
	    this.chip=valChip;
	    this.fechaReparto=fecRepa;
	    this.horaReparto=valHoraRepa;
	    this.zona=zzonOidZona;
	    this.tipoDireccionReparto=tdreOidTipoDireRepa;
	}

	@Id
	@Column(name="OID_CONF_REPA")
	private Long oid;
	@Column(name="NUM_SECU")
	private Integer secuencia;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_FACT")
	private java.util.Date fechaFacturacion;
	@Column(name="VAL_CHIP")
	private String chip;
        @Temporal(TemporalType.DATE)
        @Column(name="FEC_REPA")
	private java.util.Date fechaReparto;
	@Column(name="VAL_HORA_REPA")
	private String horaReparto;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="TDRE_OID_TIPO_DIRE_REPA")
	private Long tipoDireccionReparto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getSecuencia() {return secuencia;}
      
	public void setSecuencia(Integer secuencia){this.secuencia=secuencia;}
		
	public java.util.Date getFechaFacturacion() {return fechaFacturacion;}
      
	public void setFechaFacturacion(java.util.Date fechaFacturacion){this.fechaFacturacion=fechaFacturacion;}
		
	public String getChip() {return chip;}
      
	public void setChip(String chip){this.chip=chip;}
		
	public java.util.Date getFechaReparto() {return fechaReparto;}
      
	public void setFechaReparto(java.util.Date fechaReparto){this.fechaReparto=fechaReparto;}
		
	public String getHoraReparto() {return horaReparto;}
      
	public void setHoraReparto(String horaReparto){this.horaReparto=horaReparto;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getTipoDireccionReparto() {return tipoDireccionReparto;}
      
	public void setTipoDireccionReparto(Long tipoDireccionReparto){this.tipoDireccionReparto=tipoDireccionReparto;}
			
	
}
