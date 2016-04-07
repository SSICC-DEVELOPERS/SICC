package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ACCIO_COBRA")
@NamedQueries({
@NamedQuery(name="AccionesCobranzaLocal.FindAll",query="select object(o) from AccionesCobranzaLocal o"),
@NamedQuery(name="AccionesCobranzaLocal.FindByIndicador",query="SELECT OBJECT(n) "
+ "  FROM AccionesCobranzaLocal AS n "
+ "  WHERE n.pais=?1 "
+ "  AND n.indAccionMensajeRecordatorio=?2"),
@NamedQuery(name="AccionesCobranzaLocal.FindByUK",query="SELECT OBJECT(a) from AccionesCobranzaLocal a WHERE a.codigoAccionCobranza = ?1 and a.pais = ?2")
})
public class AccionesCobranzaLocal implements Serializable {

	public AccionesCobranzaLocal() {}

	public AccionesCobranzaLocal(Long oid, String codigoAccionCobranza, String descripcion, Long pais, Long subTipoAccion)	{
	
		this.oid=oid;
                this.setCodigoAccionCobranza(codigoAccionCobranza);
	        this.setDescripcion(descripcion);
	        this.setPais(pais);
	        this.setSubTipoAccion(subTipoAccion);
	
	}

	@Id
	@Column(name="OID_ACCI_COBR")
	private Long oid;
	@Column(name="COD_ACCI_COBR")
	private String codigoAccionCobranza;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="IND_FECH_HORA_SEGU")
	private Boolean indFechaHoraSeguimiento;
	@Column(name="IND_FECH_IMPO_COMP")
	private Boolean indFechaImporteCompromiso;
	@Column(name="IND_FECH_HORA_NUEV_SEGU")
	private Boolean indFechaHoraNuevoSeguimiento;
	@Column(name="IND_APOR_PRUE")
	private Boolean indAportaPrueba;
	@Column(name="IND_DESC_PRUE")
	private Boolean indDescripcionPrueba;
	@Column(name="IND_NUME_DOCU_SOPO")
	private Boolean indNumeroDocumentoSoporte;
	@Column(name="IND_TIPO_DOCU_PAGO")
	private Boolean indTipoDocumentoPago;
	@Column(name="IND_BANC_SUCU")
	private Boolean indBancoSucursal;
	@Column(name="IND_NUEV_DIRE")
	private Boolean indNuevaDireccion;
	@Column(name="IND_NUEV_TELF")
	private Boolean indNuevoTelefono;
	@Column(name="IND_PASA_ADMI")
	private Boolean indPasaAdministrador;
	@Column(name="IND_PETI_BLOQ_ADMI")
	private Boolean indPeticionBloqueoAdministrativo;
	@Column(name="IND_PETI_DESB_ADMI")
	private Boolean indPeticionDesbloqueoAdministrativo;
	@Column(name="IND_ACCI_MENS_RECO")
	private Long indAccionMensajeRecordatorio;
	@Column(name="IND_OBSE")
	private Boolean indObservaciones;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SACC_OID_SUBT_ACCI")
	private Long subTipoAccion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoAccionCobranza() {return codigoAccionCobranza;}
      
	public void setCodigoAccionCobranza(String codigoAccionCobranza){this.codigoAccionCobranza=codigoAccionCobranza;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getIndFechaHoraSeguimiento() {return indFechaHoraSeguimiento;}
      
	public void setIndFechaHoraSeguimiento(Boolean indFechaHoraSeguimiento){this.indFechaHoraSeguimiento=indFechaHoraSeguimiento;}
		
	public Boolean getIndFechaImporteCompromiso() {return indFechaImporteCompromiso;}
      
	public void setIndFechaImporteCompromiso(Boolean indFechaImporteCompromiso){this.indFechaImporteCompromiso=indFechaImporteCompromiso;}
		
	public Boolean getIndFechaHoraNuevoSeguimiento() {return indFechaHoraNuevoSeguimiento;}
      
	public void setIndFechaHoraNuevoSeguimiento(Boolean indFechaHoraNuevoSeguimiento){this.indFechaHoraNuevoSeguimiento=indFechaHoraNuevoSeguimiento;}
		
	public Boolean getIndAportaPrueba() {return indAportaPrueba;}
      
	public void setIndAportaPrueba(Boolean indAportaPrueba){this.indAportaPrueba=indAportaPrueba;}
		
	public Boolean getIndDescripcionPrueba() {return indDescripcionPrueba;}
      
	public void setIndDescripcionPrueba(Boolean indDescripcionPrueba){this.indDescripcionPrueba=indDescripcionPrueba;}
		
	public Boolean getIndNumeroDocumentoSoporte() {return indNumeroDocumentoSoporte;}
      
	public void setIndNumeroDocumentoSoporte(Boolean indNumeroDocumentoSoporte){this.indNumeroDocumentoSoporte=indNumeroDocumentoSoporte;}
		
	public Boolean getIndTipoDocumentoPago() {return indTipoDocumentoPago;}
      
	public void setIndTipoDocumentoPago(Boolean indTipoDocumentoPago){this.indTipoDocumentoPago=indTipoDocumentoPago;}
		
	public Boolean getIndBancoSucursal() {return indBancoSucursal;}
      
	public void setIndBancoSucursal(Boolean indBancoSucursal){this.indBancoSucursal=indBancoSucursal;}
		
	public Boolean getIndNuevaDireccion() {return indNuevaDireccion;}
      
	public void setIndNuevaDireccion(Boolean indNuevaDireccion){this.indNuevaDireccion=indNuevaDireccion;}
		
	public Boolean getIndNuevoTelefono() {return indNuevoTelefono;}
      
	public void setIndNuevoTelefono(Boolean indNuevoTelefono){this.indNuevoTelefono=indNuevoTelefono;}
		
	public Boolean getIndPasaAdministrador() {return indPasaAdministrador;}
      
	public void setIndPasaAdministrador(Boolean indPasaAdministrador){this.indPasaAdministrador=indPasaAdministrador;}
		
	public Boolean getIndPeticionBloqueoAdministrativo() {return indPeticionBloqueoAdministrativo;}
      
	public void setIndPeticionBloqueoAdministrativo(Boolean indPeticionBloqueoAdministrativo){this.indPeticionBloqueoAdministrativo=indPeticionBloqueoAdministrativo;}
		
	public Boolean getIndPeticionDesbloqueoAdministrativo() {return indPeticionDesbloqueoAdministrativo;}
      
	public void setIndPeticionDesbloqueoAdministrativo(Boolean indPeticionDesbloqueoAdministrativo){this.indPeticionDesbloqueoAdministrativo=indPeticionDesbloqueoAdministrativo;}
		
	public Long getIndAccionMensajeRecordatorio() {return indAccionMensajeRecordatorio;}
      
	public void setIndAccionMensajeRecordatorio(Long indAccionMensajeRecordatorio){this.indAccionMensajeRecordatorio=indAccionMensajeRecordatorio;}
		
	public Boolean getIndObservaciones() {return indObservaciones;}
      
	public void setIndObservaciones(Boolean indObservaciones){this.indObservaciones=indObservaciones;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getSubTipoAccion() {return subTipoAccion;}
      
	public void setSubTipoAccion(Long subTipoAccion){this.subTipoAccion=subTipoAccion;}
			
	
}
