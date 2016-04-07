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
@Table(name="REC_CABEC_RECLA")
@NamedQueries({
@NamedQuery(name="CabeceraReclamoLocal.FindAll",query="select object(o) from CabeceraReclamoLocal o"),
@NamedQuery(name="CabeceraReclamoLocal.FindByUK",query="SELECT OBJECT(o) FROM CabeceraReclamoLocal AS o WHERE o.numeroAtencion = ?1 AND o.pais = ?2"),
@NamedQuery(name="CabeceraReclamoLocal.FindByNumeroAtencionInterfacePais",query="SELECT OBJECT(c) FROM CabeceraReclamoLocal AS c WHERE c.numeroAtencionInterface = ?1 AND c.pais = ?2")
})
public class CabeceraReclamoLocal implements Serializable {

	public CabeceraReclamoLocal() {}

	public CabeceraReclamoLocal(Long oid, Long numeroAtencion, Long numeroReclamo, Long pais, Long numeroDocumentoReferencia, Long periodoDocumentoReferencia, Long cliente, Long periodoReclamo, Long subTipoCliente, Long tipoDocumento, Long estadoReclamo, Long tipoCliente)	{
	
		this.oid=oid;
                this.numeroAtencion=numeroAtencion;
                this.numeroReclamo=numeroReclamo;
                this.pais=pais;
                this.numeroDocumentoReferencia=numeroDocumentoReferencia;
                this.periodoDocumentoReferencia=periodoDocumentoReferencia;
                this.cliente=cliente;
                this.periodoReclamo=periodoReclamo;
                this.subTipoCliente=subTipoCliente;
                this.tipoDocumento=tipoDocumento;
                this.estadoReclamo=estadoReclamo;
                this.tipoCliente=tipoCliente;
	
	}

	@Id
	@Column(name="OID_CABE_RECL")
	private Long oid;
	@Column(name="NUM_ATEN")
	private Long numeroAtencion;
	@Column(name="NUM_RECL")
	private Long numeroReclamo;
	@Column(name="FEC_DOCU_REFE")
	private Date fechaDocumentoReferencia;
	@Column(name="NUM_TOTA_ENVI")
	private BigDecimal totalEnvia;
	@Column(name="NUM_TOTA_DEVU")
	private BigDecimal totalDevuelve;
	@Column(name="IMP_SALD_PAGA")
	private BigDecimal saldoPagar;
	@Column(name="COD_USUA_INGR")
	private String usuarioIngreso;
	@Column(name="FEC_INGR")
	private Date fechaIngreso;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long numeroDocumentoReferencia;
	@Column(name="PERD_OID_PERI_DOCU_REFE")
	private Long periodoDocumentoReferencia;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="MRDB_OID_MOTI_RECH")
	private Long motivoRechazo;
	@Column(name="PERD_OID_PERI_RECL")
	private Long periodoReclamo;
	@Column(name="MRDB_OID_MOTI_DESB")
	private Long motivoDesbloqueo;
	@Column(name="ZTAD_OID_TERR_ADMI")
	private Long unidadAdministrativaCliente;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subTipoCliente;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumento;
	@Column(name="ESRE_OID_ESTA_RECL")
	private Long estadoReclamo;
	@Column(name="MOBL_OID_MOTI_BLOQ")
	private Long motivoBloqueo;
	@Column(name="TIIN_OID_TIPO_INGR")
	private Long tipoIngreso;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="NUM_ATEN_INTE")
	private Long numeroAtencionInterface;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroAtencion() {return numeroAtencion;}
      
	public void setNumeroAtencion(Long numeroAtencion){this.numeroAtencion=numeroAtencion;}
		
	public Long getNumeroReclamo() {return numeroReclamo;}
      
	public void setNumeroReclamo(Long numeroReclamo){this.numeroReclamo=numeroReclamo;}
		
	public Date getFechaDocumentoReferencia() {return fechaDocumentoReferencia;}
      
	public void setFechaDocumentoReferencia(Date fechaDocumentoReferencia){this.fechaDocumentoReferencia=fechaDocumentoReferencia;}
		
	public BigDecimal getTotalEnvia() {return totalEnvia;}
      
	public void setTotalEnvia(BigDecimal totalEnvia){this.totalEnvia=totalEnvia;}
		
	public BigDecimal getTotalDevuelve() {return totalDevuelve;}
      
	public void setTotalDevuelve(BigDecimal totalDevuelve){this.totalDevuelve=totalDevuelve;}
		
	public BigDecimal getSaldoPagar() {return saldoPagar;}
      
	public void setSaldoPagar(BigDecimal saldoPagar){this.saldoPagar=saldoPagar;}
		
	public String getUsuarioIngreso() {return usuarioIngreso;}
      
	public void setUsuarioIngreso(String usuarioIngreso){this.usuarioIngreso=usuarioIngreso;}
		
	public Date getFechaIngreso() {return fechaIngreso;}
      
	public void setFechaIngreso(Date fechaIngreso){this.fechaIngreso=fechaIngreso;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getNumeroDocumentoReferencia() {return numeroDocumentoReferencia;}
      
	public void setNumeroDocumentoReferencia(Long numeroDocumentoReferencia){this.numeroDocumentoReferencia=numeroDocumentoReferencia;}
		
	public Long getPeriodoDocumentoReferencia() {return periodoDocumentoReferencia;}
      
	public void setPeriodoDocumentoReferencia(Long periodoDocumentoReferencia){this.periodoDocumentoReferencia=periodoDocumentoReferencia;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getMotivoRechazo() {return motivoRechazo;}
      
	public void setMotivoRechazo(Long motivoRechazo){this.motivoRechazo=motivoRechazo;}
		
	public Long getPeriodoReclamo() {return periodoReclamo;}
      
	public void setPeriodoReclamo(Long periodoReclamo){this.periodoReclamo=periodoReclamo;}
		
	public Long getMotivoDesbloqueo() {return motivoDesbloqueo;}
      
	public void setMotivoDesbloqueo(Long motivoDesbloqueo){this.motivoDesbloqueo=motivoDesbloqueo;}
		
	public Long getUnidadAdministrativaCliente() {return unidadAdministrativaCliente;}
      
	public void setUnidadAdministrativaCliente(Long unidadAdministrativaCliente){this.unidadAdministrativaCliente=unidadAdministrativaCliente;}
		
	public Long getSubTipoCliente() {return subTipoCliente;}
      
	public void setSubTipoCliente(Long subTipoCliente){this.subTipoCliente=subTipoCliente;}
		
	public Long getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public Long getEstadoReclamo() {return estadoReclamo;}
      
	public void setEstadoReclamo(Long estadoReclamo){this.estadoReclamo=estadoReclamo;}
		
	public Long getMotivoBloqueo() {return motivoBloqueo;}
      
	public void setMotivoBloqueo(Long motivoBloqueo){this.motivoBloqueo=motivoBloqueo;}
		
	public Long getTipoIngreso() {return tipoIngreso;}
      
	public void setTipoIngreso(Long tipoIngreso){this.tipoIngreso=tipoIngreso;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getNumeroAtencionInterface() {return numeroAtencionInterface;}
      
	public void setNumeroAtencionInterface(Long numeroAtencionInterface){this.numeroAtencionInterface=numeroAtencionInterface;}
			
	
}
