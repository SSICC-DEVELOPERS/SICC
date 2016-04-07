package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ASIGN_COBRA")
@NamedQueries({
@NamedQuery(name="AsignacionCobranzaLocal.FindAll",query="select object(o) from AsignacionCobranzaLocal o")
})
public class AsignacionCobranzaLocal implements Serializable {

	public AsignacionCobranzaLocal() {}

	public AsignacionCobranzaLocal(Long oid, Long pais, Long datosMovimientosCCC, Long sociedad, Long cartera)	{
	
		this.oid=oid;
                this.setPais(pais);
	        this.setDatosMovimientosCCC(datosMovimientosCCC);
	        this.setSociedad(sociedad);
	        this.setCartera(cartera);
	
	}

	@Id
	@Column(name="OID_ASIG_COBR")
	private Long oid;
	@Column(name="IMP_ORIG_DEUD")
	private java.math.BigDecimal importeOriginalDeuda;
	@Column(name="IMP_DEUD_ASIG")
	private java.math.BigDecimal importeDeudaAsignada;
	@Column(name="IMP_DEUD_CANC")
	private java.math.BigDecimal importeDeudaCancelada;
	@Column(name="FEC_ASIG")
	private java.sql.Date fechaAsignacion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long datosMovimientosCCC;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="CRCO_OID_CRON_COBR")
	private Long cartera;
	@Column(name="HICC_OID_HIST_COMI_COBR")
	private Long liquidacion;
	@Column(name="ESAS_OID_ESTA_ASIG")
	private Long oidEstadoAsignacion;
       @Column(name="TCAB_OID_TIPO_CARG_ABON")
       private Long oidTipoCargoAbono;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getImporteOriginalDeuda() {return importeOriginalDeuda;}
      
	public void setImporteOriginalDeuda(java.math.BigDecimal importeOriginalDeuda){this.importeOriginalDeuda=importeOriginalDeuda;}
		
	public java.math.BigDecimal getImporteDeudaAsignada() {return importeDeudaAsignada;}
      
	public void setImporteDeudaAsignada(java.math.BigDecimal importeDeudaAsignada){this.importeDeudaAsignada=importeDeudaAsignada;}
		
	public java.math.BigDecimal getImporteDeudaCancelada() {return importeDeudaCancelada;}
      
	public void setImporteDeudaCancelada(java.math.BigDecimal importeDeudaCancelada){this.importeDeudaCancelada=importeDeudaCancelada;}
		
	public java.sql.Date getFechaAsignacion() {return fechaAsignacion;}
      
	public void setFechaAsignacion(java.sql.Date fechaAsignacion){this.fechaAsignacion=fechaAsignacion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getDatosMovimientosCCC() {return datosMovimientosCCC;}
      
	public void setDatosMovimientosCCC(Long datosMovimientosCCC){this.datosMovimientosCCC=datosMovimientosCCC;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getCartera() {return cartera;}
      
	public void setCartera(Long cartera){this.cartera=cartera;}
		
	public Long getLiquidacion() {return liquidacion;}
      
	public void setLiquidacion(Long liquidacion){this.liquidacion=liquidacion;}
		
	public Long getOidEstadoAsignacion() {return oidEstadoAsignacion;}
      
	public void setOidEstadoAsignacion(Long oidEstadoAsignacion){this.oidEstadoAsignacion=oidEstadoAsignacion;}
        
        public Long getOidTipoCargoAbono() {return oidTipoCargoAbono;}
    
        public void setOidTipoCargoAbono(Long oidTipoCargoA){this.oidTipoCargoAbono=oidTipoCargoA;}		
	
}
