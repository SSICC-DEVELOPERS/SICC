package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

@Entity
@Table(name="CCC_DETAL_DTO_RECAR_FINAN")
public class DetalleDtoRecargoLocal implements Serializable {

	public DetalleDtoRecargoLocal() {}

	public DetalleDtoRecargoLocal(Long oid, Long generadaSolicitudPedido, Long solicitud,
                                    Integer numeroLinea, Long cliente)	{
	
		this.oid=oid;
                this.generadaSolicitudPedido=generadaSolicitudPedido;
                this.solicitud=solicitud;
                this.numeroLinea=numeroLinea;
                this.cliente=cliente;
	
	}
    
        public DetalleDtoRecargoLocal(Long oid, Long generadaSolicitudPedido, Long solicitud,
                                Long cabecera, Long historico, Integer numeroLinea, Long marca, 
                                Long cliente, Integer numeroDiasCalculados, BigDecimal importePago, 
                                BigDecimal importeLiquidacionCalculado, String observaciones, 
                                Date fechaDocumento, Date fechaVencimiento, Date fechaLiquidacion,
                                BigDecimal importeLiquidacionUsuario, Double importe, 
                                String referenciaDocumentoExterno)  {
        
                this.oid=oid;
                this.generadaSolicitudPedido=generadaSolicitudPedido;
                this.solicitud=solicitud;
                this.numeroLinea=numeroLinea;
                this.cliente=cliente;            
                this.cabecera=cabecera;
                this.historico=historico;
                this.marca=marca;
                this.numeroDiasCalculados=numeroDiasCalculados;
                this.importePago=importePago;
                this.importeLiquidacionCalculado=importeLiquidacionCalculado;
                this.observaciones=observaciones;
                this.fechaDocumento=fechaDocumento;
                this.fechaVencimiento=fechaVencimiento;
                this.fechaLiquidacion=fechaLiquidacion;
                this.importeLiquidacionUsuario=importeLiquidacionUsuario;
                this.importe=importe;
                this.referenciaDocumentoExterno=referenciaDocumentoExterno;                
        
        }

	@Id
	@Column(name="OID_DETA_DTO_RECA_FINA")
	private Long oid;
	@Column(name="NUM_DIAS_CALC")
	private Integer numeroDiasCalculados;
	@Column(name="IMP_DETA")
	private Double importe;
	@Column(name="IMP_LIQU_CALC")
	private java.math.BigDecimal importeLiquidacionCalculado;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_GENE_SOLI_PEDI")
	private Long generadaSolicitudPedido;
	@Column(name="CDRF_OID_CABE_DTO_RECA_FINA")
	private Long solicitud;
	@Column(name="HMCC_OID_HIST_MOVI_CC")
	private Long historico;
	@Column(name="NUM_LINEA")
	private Integer numeroLinea;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="FEC_VENC")        
	private java.sql.Date fechaVencimiento;
	@Column(name="FEC_LIQU")        
	private java.sql.Date fechaLiquidacion;
	@Column(name="IMP_LIQU_USUA")
	private java.math.BigDecimal importeLiquidacionUsuario;
	@Column(name="IMP_PAGO")
	private java.math.BigDecimal importePago;
	@Column(name="REF_DOCU_EXTE")
	private String referenciaDocumentoExterno;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long cabecera;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimiento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroDiasCalculados() {return numeroDiasCalculados;}
      
	public void setNumeroDiasCalculados(Integer numeroDiasCalculados){this.numeroDiasCalculados=numeroDiasCalculados;}
		
	public Double getImporte() {return importe;}
      
	public void setImporte(Double importe){this.importe=importe;}
		
	public java.math.BigDecimal getImporteLiquidacionCalculado() {return importeLiquidacionCalculado;}
      
	public void setImporteLiquidacionCalculado(java.math.BigDecimal importeLiquidacionCalculado){this.importeLiquidacionCalculado=importeLiquidacionCalculado;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getGeneradaSolicitudPedido() {return generadaSolicitudPedido;}
      
	public void setGeneradaSolicitudPedido(Long generadaSolicitudPedido){this.generadaSolicitudPedido=generadaSolicitudPedido;}
		
	public Long getSolicitud() {return solicitud;}
      
	public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
		
	public Long getHistorico() {return historico;}
      
	public void setHistorico(Long historico){this.historico=historico;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public java.sql.Date getFechaVencimiento() {return fechaVencimiento;}
      
	public void setFechaVencimiento(java.sql.Date fechaVencimiento){this.fechaVencimiento=fechaVencimiento;}
		
	public java.sql.Date getFechaLiquidacion() {return fechaLiquidacion;}
      
	public void setFechaLiquidacion(java.sql.Date fechaLiquidacion){this.fechaLiquidacion=fechaLiquidacion;}
		
	public java.math.BigDecimal getImporteLiquidacionUsuario() {return importeLiquidacionUsuario;}
      
	public void setImporteLiquidacionUsuario(java.math.BigDecimal importeLiquidacionUsuario){this.importeLiquidacionUsuario=importeLiquidacionUsuario;}
		
	public java.math.BigDecimal getImportePago() {return importePago;}
      
	public void setImportePago(java.math.BigDecimal importePago){this.importePago=importePago;}
		
	public String getReferenciaDocumentoExterno() {return referenciaDocumentoExterno;}
      
	public void setReferenciaDocumentoExterno(String referenciaDocumentoExterno){this.referenciaDocumentoExterno=referenciaDocumentoExterno;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getCabecera() {return cabecera;}
      
	public void setCabecera(Long cabecera){this.cabecera=cabecera;}
		
	public Long getMovimiento() {return movimiento;}
      
	public void setMovimiento(Long movimiento){this.movimiento=movimiento;}
			
	
}
