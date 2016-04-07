package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOLoteSolicitudes extends DTOAuditableSICC {

    private Long tipoSolicitud;
    private Long periodo;
    private ArrayList clientes;
    private Boolean ok;
    private Long numeroLote;
    private Long numeroSolicitudesLote;
    private Long numeroSolicitudes;
    private Long oidLote;

  public ArrayList getClientes()
  {
    return clientes;
  }

  public void setClientes(ArrayList clientes)
  {
    this.clientes = clientes;
  }

  public Long getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(Long numeroLote)
  {
    this.numeroLote = numeroLote;
  }

  public Long getNumeroSolicitudes()
  {
    return numeroSolicitudes;
  }

  public void setNumeroSolicitudes(Long numeroSolicitudes)
  {
    this.numeroSolicitudes = numeroSolicitudes;
  }

  public Long getNumeroSolicitudesLote()
  {
    return numeroSolicitudesLote;
  }

  public void setNumeroSolicitudesLote(Long numeroSolicitudesLote)
  {
    this.numeroSolicitudesLote = numeroSolicitudesLote;
  }

  public Boolean getOk()
  {
    return ok;
  }

  public void setOk(Boolean ok)
  {
    this.ok = ok;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getTipoSolicitud()
  {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(Long tipoSolicitud)
  {
    this.tipoSolicitud = tipoSolicitud;
  }


  public void setOidLote(Long oidLote) {
    this.oidLote = oidLote;
  }


  public Long getOidLote() {
    return oidLote;
  }
    
    
}