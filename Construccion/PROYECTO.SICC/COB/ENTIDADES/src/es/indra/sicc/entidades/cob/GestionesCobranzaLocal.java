package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_GESTI_COBRA")
@NamedQueries({
@NamedQuery(name="GestionesCobranzaLocal.FindAll",query="select object(o) from GestionesCobranzaLocal o")
})
public class GestionesCobranzaLocal implements Serializable {

	public GestionesCobranzaLocal() {}

	public GestionesCobranzaLocal(Long oid, String orden, Long cliente, Long periodo, Long etapaDeuda, Long usuarioCobranzas, Long codigoAccion)	{
	
		this.oid=oid;
                this.setOrden(orden);
	        this.setCliente(cliente);
	        this.setPeriodo(periodo);    
	        this.setEtapaDeuda(etapaDeuda);
	        this.setUsuarioCobranzas(usuarioCobranzas);
	        this.setCodigoAccion(codigoAccion);
	
	}

	@Id
	@Column(name="OID_GEST_COBR")
	private Long oid;
	@Column(name="NUM_ORDE")
	private String orden;
	@Column(name="VAL_PROC_ACTU")
	private String procesoActualiza;
	@Column(name="FEC_SEGU")
	private java.sql.Date fechaSeguimiento;
	@Column(name="VAL_HORA_SEGU")
	private String horaSeguimiento;
	@Column(name="FEC_REPR")
	private java.sql.Date fechaReprogramacion;
	@Column(name="VAL_HORA_REPR")
	private String horaReprogramacion;
	@Column(name="IND_APOR_PRUE")
	private Boolean aportaPrueba;
	@Column(name="VAL_DESC_PRUE")
	private String descripcionPrueba;
	@Column(name="NUM_DOCU_SOPO")
	private java.math.BigDecimal numeroDocumentoSoporte;
	@Column(name="VAL_NUEV_DIRE")
	private String nuevaDireccion;
	@Column(name="VAL_NUEV_TELF")
	private String nuevoTelefono;
	@Column(name="IND_PASA_ADMI")
	private Boolean pasaAdministrador;
	@Column(name="IND_PETI_BLOQ")
	private Boolean peticionBloqueo;
	@Column(name="IND_PETI_DESB")
	private Boolean peticionDesbloqueo;
	@Column(name="IND_VISA_ADMI")
	private Boolean visadoAdministrador;
	@Column(name="IND_MARC_COMI_CALC")
	private Boolean marcaComisionCalculada;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="FEC_GEST")
	private java.sql.Date fechaGestion;
	@Column(name="IND_COMP_PAGO")
	private Boolean indCompromisoPago;
	@Column(name="SUCU_OID_SUCU")
	private Long sucursal;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="MPAB_OID_MEDI_PAGO")
	private Long tipoDocumentoPago;
	@Column(name="ETDE_OID_ETAPA_DEUDA")
	private Long etapaDeuda;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuarioCobranzas;
	@Column(name="MONO_OID_MOTI_COBR")
	private Long motivoNoCobro;
	@Column(name="ACCO_OID_ACCI_COBR")
	private Long codigoAccion;
	@Column(name="EDTC_OID_ETAP_DEUD_TIPO_CARG")
	private Long oidEtapaDTipoCargo;
	@Column(name="SOCI_OID_SOCI")
	private Long oidSociedad;
	@Column(name="TIBQ_OID_TIPO_BLOQ")
	private Long oidTipoBloqueo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getOrden() {return orden;}
      
	public void setOrden(String orden){this.orden=orden;}
		
	public String getProcesoActualiza() {return procesoActualiza;}
      
	public void setProcesoActualiza(String procesoActualiza){this.procesoActualiza=procesoActualiza;}
		
	public java.sql.Date getFechaSeguimiento() {return fechaSeguimiento;}
      
	public void setFechaSeguimiento(java.sql.Date fechaSeguimiento){this.fechaSeguimiento=fechaSeguimiento;}
		
	public String getHoraSeguimiento() {return horaSeguimiento;}
      
	public void setHoraSeguimiento(String horaSeguimiento){this.horaSeguimiento=horaSeguimiento;}
		
	public java.sql.Date getFechaReprogramacion() {return fechaReprogramacion;}
      
	public void setFechaReprogramacion(java.sql.Date fechaReprogramacion){this.fechaReprogramacion=fechaReprogramacion;}
		
	public String getHoraReprogramacion() {return horaReprogramacion;}
      
	public void setHoraReprogramacion(String horaReprogramacion){this.horaReprogramacion=horaReprogramacion;}
		
	public Boolean getAportaPrueba() {return aportaPrueba;}
      
	public void setAportaPrueba(Boolean aportaPrueba){this.aportaPrueba=aportaPrueba;}
		
	public String getDescripcionPrueba() {return descripcionPrueba;}
      
	public void setDescripcionPrueba(String descripcionPrueba){this.descripcionPrueba=descripcionPrueba;}
		
	public java.math.BigDecimal getNumeroDocumentoSoporte() {return numeroDocumentoSoporte;}
      
	public void setNumeroDocumentoSoporte(java.math.BigDecimal numeroDocumentoSoporte){this.numeroDocumentoSoporte=numeroDocumentoSoporte;}
		
	public String getNuevaDireccion() {return nuevaDireccion;}
      
	public void setNuevaDireccion(String nuevaDireccion){this.nuevaDireccion=nuevaDireccion;}
		
	public String getNuevoTelefono() {return nuevoTelefono;}
      
	public void setNuevoTelefono(String nuevoTelefono){this.nuevoTelefono=nuevoTelefono;}
		
	public Boolean getPasaAdministrador() {return pasaAdministrador;}
      
	public void setPasaAdministrador(Boolean pasaAdministrador){this.pasaAdministrador=pasaAdministrador;}
		
	public Boolean getPeticionBloqueo() {return peticionBloqueo;}
      
	public void setPeticionBloqueo(Boolean peticionBloqueo){this.peticionBloqueo=peticionBloqueo;}
		
	public Boolean getPeticionDesbloqueo() {return peticionDesbloqueo;}
      
	public void setPeticionDesbloqueo(Boolean peticionDesbloqueo){this.peticionDesbloqueo=peticionDesbloqueo;}
		
	public Boolean getVisadoAdministrador() {return visadoAdministrador;}
      
	public void setVisadoAdministrador(Boolean visadoAdministrador){this.visadoAdministrador=visadoAdministrador;}
		
	public Boolean getMarcaComisionCalculada() {return marcaComisionCalculada;}
      
	public void setMarcaComisionCalculada(Boolean marcaComisionCalculada){this.marcaComisionCalculada=marcaComisionCalculada;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public java.sql.Date getFechaGestion() {return fechaGestion;}
      
	public void setFechaGestion(java.sql.Date fechaGestion){this.fechaGestion=fechaGestion;}
		
	public Boolean getIndCompromisoPago() {return indCompromisoPago;}
      
	public void setIndCompromisoPago(Boolean indCompromisoPago){this.indCompromisoPago=indCompromisoPago;}
		
	public Long getSucursal() {return sucursal;}
      
	public void setSucursal(Long sucursal){this.sucursal=sucursal;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getTipoDocumentoPago() {return tipoDocumentoPago;}
      
	public void setTipoDocumentoPago(Long tipoDocumentoPago){this.tipoDocumentoPago=tipoDocumentoPago;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
		
	public Long getUsuarioCobranzas() {return usuarioCobranzas;}
      
	public void setUsuarioCobranzas(Long usuarioCobranzas){this.usuarioCobranzas=usuarioCobranzas;}
		
	public Long getMotivoNoCobro() {return motivoNoCobro;}
      
	public void setMotivoNoCobro(Long motivoNoCobro){this.motivoNoCobro=motivoNoCobro;}
		
	public Long getCodigoAccion() {return codigoAccion;}
      
	public void setCodigoAccion(Long codigoAccion){this.codigoAccion=codigoAccion;}
		
	public Long getOidEtapaDTipoCargo() {return oidEtapaDTipoCargo;}
      
	public void setOidEtapaDTipoCargo(Long oidEtapaDTipoCargo){this.oidEtapaDTipoCargo=oidEtapaDTipoCargo;}
		
	public Long getOidSociedad() {return oidSociedad;}
      
	public void setOidSociedad(Long oidSociedad){this.oidSociedad=oidSociedad;}
		
	public Long getOidTipoBloqueo() {return oidTipoBloqueo;}
      
	public void setOidTipoBloqueo(Long oidTipoBloqueo){this.oidTipoBloqueo=oidTipoBloqueo;}
			
	
}
