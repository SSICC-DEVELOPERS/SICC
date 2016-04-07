package es.indra.sicc.dtos.ped;
import  es.indra.sicc.util.DTOBelcorp;
import  es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOSeguimientoPedidos  extends DTOSiccPaginacion
{
  private Long solicitud;
  private Long consolidado;
  private Long hitoSeguimiento;
  private Long tipoDocumento;
  private String numeroDocumento;
  private Date fecha;
  private Boolean indCompleto;

  public DTOSeguimientoPedidos() {
  }

  public Long getSolicitud() {
    return solicitud;
  }

  public void setSolicitud(Long newSolicitud) {
    solicitud = newSolicitud;
  }

  public Long getConsolidado() {
    return consolidado;
  }

  public void setConsolidado(Long newConsolidado) {
    consolidado = newConsolidado;
  }

  public Long getHitoSeguimiento() {
    return hitoSeguimiento;
  }

  public void setHitoSeguimiento(Long newHitoSeguimiento) {
    hitoSeguimiento = newHitoSeguimiento;
  }

  public Long getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(Long newTipoDocumento) {
    tipoDocumento = newTipoDocumento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String newNumeroDocumento) {
    numeroDocumento = newNumeroDocumento;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date newFecha) {
    fecha = newFecha;
  }

  public Boolean getIndCompleto() {
    return indCompleto;
  }

  public void setIndCompleto(Boolean newIndCompleto) {
    indCompleto = newIndCompleto;
  }
}