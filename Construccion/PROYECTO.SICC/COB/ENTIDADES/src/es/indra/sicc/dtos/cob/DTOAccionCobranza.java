/* DTOAccionCobranza.java  
 *
 * Created on 3 de marzo de 2005, 5:58 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 *
 * @author  Sergio Platas
 */

public class DTOAccionCobranza extends DTOAuditableSICC 
{
  private Long oid;
  private String codigoAccionCobranza;
  private String descripcion;
  private String descSubtipoAccion;
  
    /*agregado ciglesias incidencia 24442 inicio*/
    private Boolean indFechaHoraSeguimiento;
    private Boolean indFechaImporteCompromiso;
    private Boolean indFechaHoraNuevoSeguimiento;
    private Boolean indAportaPrueba;
    private Boolean indDescripcionPrueba;
    private Boolean indNumeroDocumentoSoporte;
    private Boolean indTipoDocumentoPago;
    private Boolean indBancoSucursal;
    private Boolean indNuevaDireccion;
    private Boolean indNuevoTelefono;
    private Boolean indPasaAdministrador;
    private Boolean indPeticionBloqueoAdministrativo;
    private Boolean indPeticionDesbloqueoAdministrativo;
    private Long indAccionMensajeRecordatorio;
    private Boolean indObservaciones;
    private String observaciones;


    public void setOid(Long oid)
    {
        this.oid = oid;
    }


    public Long getOid()
    {
        return oid;
    }


    public void setCodigoAccionCobranza(String codigoAccionCobranza)
    {
        this.codigoAccionCobranza = codigoAccionCobranza;
    }


    public String getCodigoAccionCobranza()
    {
        return codigoAccionCobranza;
    }


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }


    public String getDescripcion()
    {
        return descripcion;
    }


    public void setDescSubtipoAccion(String descSubtipoAccion)
    {
        this.descSubtipoAccion = descSubtipoAccion;
    }


    public String getDescSubtipoAccion()
    {
        return descSubtipoAccion;
    }


    public void setIndFechaHoraSeguimiento(Boolean indFechaHoraSeguimiento)
    {
        this.indFechaHoraSeguimiento = indFechaHoraSeguimiento;
    }


    public Boolean getIndFechaHoraSeguimiento()
    {
        return indFechaHoraSeguimiento;
    }


    public void setIndFechaImporteCompromiso(Boolean indFechaImporteCompromiso)
    {
        this.indFechaImporteCompromiso = indFechaImporteCompromiso;
    }


    public Boolean getIndFechaImporteCompromiso()
    {
        return indFechaImporteCompromiso;
    }


    public void setIndFechaHoraNuevoSeguimiento(Boolean indFechaHoraNuevoSeguimiento)
    {
        this.indFechaHoraNuevoSeguimiento = indFechaHoraNuevoSeguimiento;
    }


    public Boolean getIndFechaHoraNuevoSeguimiento()
    {
        return indFechaHoraNuevoSeguimiento;
    }


    public void setIndAportaPrueba(Boolean indAportaPrueba)
    {
        this.indAportaPrueba = indAportaPrueba;
    }


    public Boolean getIndAportaPrueba()
    {
        return indAportaPrueba;
    }


    public void setIndDescripcionPrueba(Boolean indDescripcionPrueba)
    {
        this.indDescripcionPrueba = indDescripcionPrueba;
    }


    public Boolean getIndDescripcionPrueba()
    {
        return indDescripcionPrueba;
    }


    public void setIndNumeroDocumentoSoporte(Boolean indNumeroDocumentoSoporte)
    {
        this.indNumeroDocumentoSoporte = indNumeroDocumentoSoporte;
    }


    public Boolean getIndNumeroDocumentoSoporte()
    {
        return indNumeroDocumentoSoporte;
    }


    public void setIndTipoDocumentoPago(Boolean indTipoDocumentoPago)
    {
        this.indTipoDocumentoPago = indTipoDocumentoPago;
    }


    public Boolean getIndTipoDocumentoPago()
    {
        return indTipoDocumentoPago;
    }


    public void setIndBancoSucursal(Boolean indBancoSucursal)
    {
        this.indBancoSucursal = indBancoSucursal;
    }


    public Boolean getIndBancoSucursal()
    {
        return indBancoSucursal;
    }


    public void setIndNuevaDireccion(Boolean indNuevaDireccion)
    {
        this.indNuevaDireccion = indNuevaDireccion;
    }


    public Boolean getIndNuevaDireccion()
    {
        return indNuevaDireccion;
    }


    public void setIndNuevoTelefono(Boolean indNuevoTelefono)
    {
        this.indNuevoTelefono = indNuevoTelefono;
    }


    public Boolean getIndNuevoTelefono()
    {
        return indNuevoTelefono;
    }


    public void setIndPasaAdministrador(Boolean indPasaAdministrador)
    {
        this.indPasaAdministrador = indPasaAdministrador;
    }


    public Boolean getIndPasaAdministrador()
    {
        return indPasaAdministrador;
    }


    public void setIndPeticionBloqueoAdministrativo(Boolean indPeticionBloqueoAdministrativo)
    {
        this.indPeticionBloqueoAdministrativo = indPeticionBloqueoAdministrativo;
    }


    public Boolean getIndPeticionBloqueoAdministrativo()
    {
        return indPeticionBloqueoAdministrativo;
    }


    public void setIndPeticionDesbloqueoAdministrativo(Boolean indPeticionDesbloqueoAdministrativo)
    {
        this.indPeticionDesbloqueoAdministrativo = indPeticionDesbloqueoAdministrativo;
    }


    public Boolean getIndPeticionDesbloqueoAdministrativo()
    {
        return indPeticionDesbloqueoAdministrativo;
    }

    public void setIndObservaciones(Boolean indObservaciones)
    {
        this.indObservaciones = indObservaciones;
    }


    public Boolean getIndObservaciones()
    {
        return indObservaciones;
    }


    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }


    public String getObservaciones()
    {
        return observaciones;
    }


    public void setIndAccionMensajeRecordatorio(Long indAccionMensajeRecordatorio)
    {
        this.indAccionMensajeRecordatorio = indAccionMensajeRecordatorio;
    }


    public Long getIndAccionMensajeRecordatorio()
    {
        return indAccionMensajeRecordatorio;
    }
    /*agregado ciglesias incidencia 24442 fin*/
   



}