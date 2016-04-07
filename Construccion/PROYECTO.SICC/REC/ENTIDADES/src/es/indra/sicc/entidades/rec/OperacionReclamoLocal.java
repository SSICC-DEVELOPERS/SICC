package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="REC_OPERA_RECLA")
@NamedQueries({
@NamedQuery(name="OperacionReclamoLocal.FindAll",query="select object(o) from OperacionReclamoLocal o"),
@NamedQuery(name="OperacionReclamoLocal.FindByCabeceraReclamo",query="SELECT OBJECT(d) FROM OperacionReclamoLocal d WHERE d.numeroAtencion = ?1"),
@NamedQuery(name="OperacionReclamoLocal.FindByDocumentoReferencia",query="SELECT OBJECT(d) FROM OperacionReclamoLocal d WHERE d.documentoReferencia = ?1"),
@NamedQuery(name="OperacionReclamoLocal.FindByUK",query="SELECT OBJECT(d) FROM OperacionReclamoLocal d WHERE d.numeroAtencion = ?1 AND d.secuencialOperacion = ?2")
})
public class OperacionReclamoLocal implements Serializable {

	public OperacionReclamoLocal() {}

	public OperacionReclamoLocal(Long oid, Integer secuencialOperacion, Long numeroAtencion, Long periodoReclamo, Long tipoOperacion, Long documentoReferencia)	{
	
		this.oid=oid;
                this.secuencialOperacion=secuencialOperacion;
                this.numeroAtencion=numeroAtencion;
                this.periodoReclamo=periodoReclamo;
                this.tipoOperacion=tipoOperacion;
                this.documentoReferencia=documentoReferencia;
                
	}   

	@Id
	@Column(name="OID_OPER_RECL")
	private Long oid;
	@Column(name="NUM_SECU_OPER")
	private Integer secuencialOperacion;
	@Column(name="IMP_MONT_PERD")
	private BigDecimal montoPerdida;
	@Column(name="VAL_PORC_PERD")
	private Double porcentajePerdida;
	@Column(name="CARE_OID_CABE_RECL")
	private Long numeroAtencion;
	@Column(name="TIBL_OID_TIPO_BLOQ")
	private Long tipoBloqueo;
	@Column(name="MOBL_OID_MOTI_BLOQ")
	private Long motivoBloqueo;
	@Column(name="INEM_OID_INDI_ENTR_MERC")
	private Long indicativoEntregaMercaderia;
	@Column(name="ASPE_OID_ASUM_PERD")
	private Long asumePerdida;
	@Column(name="PROD_OID_PROD")
	private Long articulo;
	@Column(name="CLIE_OID_CLIE")
	private Long clienteSeguro;
	@Column(name="MRDB_OID_MOTI_RECH_DESB")
	private Long motivoRechazo;
	@Column(name="MRDB_OID_MOTI_DESB")
	private Long motivoDesbloqueo;
	@Column(name="PPER_OID_PREC_PERD")
	private Long precioPerdida;
	@Column(name="ESOP_OID_ESTA_OPER")
	private Long estadoOperacion;
	@Column(name="CLIE_OID_RESP_PERD")
	private Long responsablePerdida;
	@Column(name="TPOS_OID_TIPO_POSI")
	private Long tipoPosicionPerdida;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long documentoReferencia;
	@Column(name="PERD_OID_PERI_RECL")
	private Long periodoReclamo;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitudPerdida;
	@Column(name="TIOP_OID_TIPO_OPER")
	private Long tipoOperacion;
	@Column(name="IND_ATEN")
	private Boolean atendido;
	@Column(name="FEC_FACT")
	private Date fechaFacturacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getSecuencialOperacion() {return secuencialOperacion;}
      
	public void setSecuencialOperacion(Integer secuencialOperacion){this.secuencialOperacion=secuencialOperacion;}
		
	public BigDecimal getMontoPerdida() {return montoPerdida;}
      
	public void setMontoPerdida(BigDecimal montoPerdida){this.montoPerdida=montoPerdida;}
		
	public Double getPorcentajePerdida() {return porcentajePerdida;}
      
	public void setPorcentajePerdida(Double porcentajePerdida){this.porcentajePerdida=porcentajePerdida;}
		
	public Long getNumeroAtencion() {return numeroAtencion;}
      
	public void setNumeroAtencion(Long numeroAtencion){this.numeroAtencion=numeroAtencion;}
		
	public Long getTipoBloqueo() {return tipoBloqueo;}
      
	public void setTipoBloqueo(Long tipoBloqueo){this.tipoBloqueo=tipoBloqueo;}
		
	public Long getMotivoBloqueo() {return motivoBloqueo;}
      
	public void setMotivoBloqueo(Long motivoBloqueo){this.motivoBloqueo=motivoBloqueo;}
		
	public Long getIndicativoEntregaMercaderia() {return indicativoEntregaMercaderia;}
      
	public void setIndicativoEntregaMercaderia(Long indicativoEntregaMercaderia){this.indicativoEntregaMercaderia=indicativoEntregaMercaderia;}
		
	public Long getAsumePerdida() {return asumePerdida;}
      
	public void setAsumePerdida(Long asumePerdida){this.asumePerdida=asumePerdida;}
		
	public Long getArticulo() {return articulo;}
      
	public void setArticulo(Long articulo){this.articulo=articulo;}
		
	public Long getClienteSeguro() {return clienteSeguro;}
      
	public void setClienteSeguro(Long clienteSeguro){this.clienteSeguro=clienteSeguro;}
		
	public Long getMotivoRechazo() {return motivoRechazo;}
      
	public void setMotivoRechazo(Long motivoRechazo){this.motivoRechazo=motivoRechazo;}
		
	public Long getMotivoDesbloqueo() {return motivoDesbloqueo;}
      
	public void setMotivoDesbloqueo(Long motivoDesbloqueo){this.motivoDesbloqueo=motivoDesbloqueo;}
		
	public Long getPrecioPerdida() {return precioPerdida;}
      
	public void setPrecioPerdida(Long precioPerdida){this.precioPerdida=precioPerdida;}
		
	public Long getEstadoOperacion() {return estadoOperacion;}
      
	public void setEstadoOperacion(Long estadoOperacion){this.estadoOperacion=estadoOperacion;}
		
	public Long getResponsablePerdida() {return responsablePerdida;}
      
	public void setResponsablePerdida(Long responsablePerdida){this.responsablePerdida=responsablePerdida;}
		
	public Long getTipoPosicionPerdida() {return tipoPosicionPerdida;}
      
	public void setTipoPosicionPerdida(Long tipoPosicionPerdida){this.tipoPosicionPerdida=tipoPosicionPerdida;}
		
	public Long getDocumentoReferencia() {return documentoReferencia;}
      
	public void setDocumentoReferencia(Long documentoReferencia){this.documentoReferencia=documentoReferencia;}
		
	public Long getPeriodoReclamo() {return periodoReclamo;}
      
	public void setPeriodoReclamo(Long periodoReclamo){this.periodoReclamo=periodoReclamo;}
		
	public Long getTipoSolicitudPerdida() {return tipoSolicitudPerdida;}
      
	public void setTipoSolicitudPerdida(Long tipoSolicitudPerdida){this.tipoSolicitudPerdida=tipoSolicitudPerdida;}
		
	public Long getTipoOperacion() {return tipoOperacion;}
      
	public void setTipoOperacion(Long tipoOperacion){this.tipoOperacion=tipoOperacion;}
		
	public Boolean getAtendido() {return atendido;}
      
	public void setAtendido(Boolean atendido){this.atendido=atendido;}
		
	public Date getFechaFacturacion() {return fechaFacturacion;}
      
	public void setFechaFacturacion(Date fechaFacturacion){this.fechaFacturacion=fechaFacturacion;}
			
	
}
