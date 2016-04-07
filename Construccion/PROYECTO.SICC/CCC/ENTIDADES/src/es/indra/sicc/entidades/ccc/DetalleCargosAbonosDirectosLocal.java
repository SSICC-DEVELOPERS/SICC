package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

@Entity
@Table(name="CCC_DETAL_CARGO_ABONO_DIREC")
@NamedQueries({
@NamedQuery(name="DetalleCargosAbonosDirectosLocal.FindByTipoAbonoSubproceso",query="SELECT OBJECT(d) FROM DetalleCargosAbonosDirectosLocal AS d WHERE d.tipoAbonoSubproceso = ?1 AND d.numeroHistoriaGenera = 0"),
@NamedQuery(name="DetalleCargosAbonosDirectosLocal.FindByMovCC",query="SELECT OBJECT(d) FROM DetalleCargosAbonosDirectosLocal AS d WHERE d.movimiento = ?1")
})
public class DetalleCargosAbonosDirectosLocal implements Serializable {

	public DetalleCargosAbonosDirectosLocal() {}

	public DetalleCargosAbonosDirectosLocal(Long oid, Long cabecera, Integer numeroLinea,
                                                String codigoUsuario, Long empresa, 
                                                Long tipoAbonoSubproceso) {
	
		this.oid=oid;
                this.cabecera=cabecera;
                this.numeroLinea=numeroLinea;
                this.codigoUsuario=codigoUsuario;
                this.empresa=empresa;
                this.tipoAbonoSubproceso=tipoAbonoSubproceso;                
	
	}

        public DetalleCargosAbonosDirectosLocal(Long oid, Long cabecera, Long consultora, 
                                    Integer numeroLinea, Integer numeroHistoriaGenera, 
                                    Date fechaMovimiento, BigDecimal importeMoneda, 
                                    BigDecimal importe, String referenciaNumeroDocumento, 
                                    String observaciones, String glosaContable, Long moneda, 
                                    Long movimientoBancario, Long medioPago, Long cuotaAnterior, 
                                    Long cuotaNueva, Long movimiento, Long cuentaCorriente, 
                                    Date fechaPagoEnBancos, String codigoUsuario, 
                                    Long empresa, Long tipoAbonoSubproceso) {
        
                this.oid=oid;
                this.cabecera=cabecera;
                this.numeroLinea=numeroLinea;
                this.codigoUsuario=codigoUsuario;
                this.empresa=empresa;
                this.tipoAbonoSubproceso=tipoAbonoSubproceso;                     
                this.consultora=consultora;             
                this.numeroHistoriaGenera=numeroHistoriaGenera;
                this.fechaMovimiento=fechaMovimiento; 
                this.importeMoneda=importeMoneda; 
                this.importe=importe;  
                this.referenciaNumeroDocumento=referenciaNumeroDocumento; 
                this.observaciones=observaciones;
                this.glosaContable=glosaContable; 
                this.moneda=moneda; 
                this.movimientoBancario=movimientoBancario; 
                this.medioPago=medioPago;
                this.cuotaAnterior=cuotaAnterior;
                this.cuotaNueva=cuotaNueva;
                this.movimiento=movimiento; 
                this.cuentaCorriente=cuentaCorriente; 
                this.fechaPagoEnBancos=fechaPagoEnBancos;
        
        }
    
        public DetalleCargosAbonosDirectosLocal(Long oid, Long cabecera, Integer numeroLinea, 
                                        Long cuotaAnterior, Long cuotaNueva, String codigoUsuario,
                                        Long empresa, Long tipoAbonoSubproceso) {
        
                this.oid=oid;
                this.cabecera=cabecera;
                this.numeroLinea=numeroLinea;
                this.codigoUsuario=codigoUsuario;
                this.empresa=empresa;
                this.tipoAbonoSubproceso=tipoAbonoSubproceso;                
                this.cuotaAnterior=cuotaAnterior;
                this.cuotaNueva=cuotaNueva;
        
        }


	@Id
	@Column(name="OID_DETA_CARG_ABON_DIRE")
	private Long oid;
	@Column(name="CCAD_OID_CABE_CARG")
	private Long cabecera;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="NUM_HIST_GENE")
	private Integer numeroHistoriaGenera;
	@Column(name="FEC_MOVI")        
	private java.sql.Date fechaMovimiento;        
	@Column(name="IMP_MONE")
	private java.math.BigDecimal importeMoneda;
	@Column(name="IMP")
	private java.math.BigDecimal importe;
	@Column(name="VAL_REFE")
	private String referenciaNumeroDocumento;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="VAL_GLOS_CONT")
	private String glosaContable;
	@Column(name="MONE_OID_MONE")
	private Long moneda;
	@Column(name="CMBA_OID_MOVI_BANC")
	private Long movimientoBancario;
	@Column(name="MPAB_OID_MEDI_PAGO")
	private Long medioPago;
	@Column(name="CUCO_OID_CUEN_CONT_CUOT_ANTE")
	private Long cuotaAnterior;
	@Column(name="CUCO_OID_CUEN_CONT_CUOT_NUEV")
	private Long cuotaNueva;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimiento;
	@Column(name="CCBA_OID_CUEN_CORR_BANC")
	private Long cuentaCorriente;
	@Column(name="FEC_PAGO_BANC")        
	private java.sql.Date fechaPagoEnBancos;
	@Column(name="COD_USUA")
	private String codigoUsuario;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="TASP_OID_TIPO_ABON_SUBP")
	private Long tipoAbonoSubproceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCabecera() {return cabecera;}
      
	public void setCabecera(Long cabecera){this.cabecera=cabecera;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public Integer getNumeroHistoriaGenera() {return numeroHistoriaGenera;}
      
	public void setNumeroHistoriaGenera(Integer numeroHistoriaGenera){this.numeroHistoriaGenera=numeroHistoriaGenera;}
		
	public java.sql.Date getFechaMovimiento() {return fechaMovimiento;}
      
	public void setFechaMovimiento(java.sql.Date fechaMovimiento){this.fechaMovimiento=fechaMovimiento;}
		
	public java.math.BigDecimal getImporteMoneda() {return importeMoneda;}
      
	public void setImporteMoneda(java.math.BigDecimal importeMoneda){this.importeMoneda=importeMoneda;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public String getReferenciaNumeroDocumento() {return referenciaNumeroDocumento;}
      
	public void setReferenciaNumeroDocumento(String referenciaNumeroDocumento){this.referenciaNumeroDocumento=referenciaNumeroDocumento;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getGlosaContable() {return glosaContable;}
      
	public void setGlosaContable(String glosaContable){this.glosaContable=glosaContable;}
		
	public Long getMoneda() {return moneda;}
      
	public void setMoneda(Long moneda){this.moneda=moneda;}
		
	public Long getMovimientoBancario() {return movimientoBancario;}
      
	public void setMovimientoBancario(Long movimientoBancario){this.movimientoBancario=movimientoBancario;}
		
	public Long getMedioPago() {return medioPago;}
      
	public void setMedioPago(Long medioPago){this.medioPago=medioPago;}
		
	public Long getCuotaAnterior() {return cuotaAnterior;}
      
	public void setCuotaAnterior(Long cuotaAnterior){this.cuotaAnterior=cuotaAnterior;}
		
	public Long getCuotaNueva() {return cuotaNueva;}
      
	public void setCuotaNueva(Long cuotaNueva){this.cuotaNueva=cuotaNueva;}
		
	public Long getMovimiento() {return movimiento;}
      
	public void setMovimiento(Long movimiento){this.movimiento=movimiento;}
		
	public Long getCuentaCorriente() {return cuentaCorriente;}
      
	public void setCuentaCorriente(Long cuentaCorriente){this.cuentaCorriente=cuentaCorriente;}
		
	public java.sql.Date getFechaPagoEnBancos() {return fechaPagoEnBancos;}
      
	public void setFechaPagoEnBancos(java.sql.Date fechaPagoEnBancos){this.fechaPagoEnBancos=fechaPagoEnBancos;}
		
	public String getCodigoUsuario() {return codigoUsuario;}
      
	public void setCodigoUsuario(String codigoUsuario){this.codigoUsuario=codigoUsuario;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getTipoAbonoSubproceso() {return tipoAbonoSubproceso;}
      
	public void setTipoAbonoSubproceso(Long tipoAbonoSubproceso){this.tipoAbonoSubproceso=tipoAbonoSubproceso;}
			
	
}
