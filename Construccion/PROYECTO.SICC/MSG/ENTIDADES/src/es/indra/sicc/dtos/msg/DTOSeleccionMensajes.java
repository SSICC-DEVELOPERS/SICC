package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOSeleccionMensajes extends DTOAuditableSICC {

	private Long oidPatron;
	private Long oidCliente;
	private String codigoCliente;
	private Long oidPeriodo;
	private Long numeroLoteImpresion;
	private String fechaImpresion;	
  private Long oidSubacceso;


	public DTOSeleccionMensajes() {
	}

	public void setOidPatron(Long newOidPatron) {
        oidPatron = newOidPatron;
    }

    public Long getOidPatron() {
        return oidPatron;
    }

	public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

	public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

	public void setOidPeriodo(Long newOidPeriodo) {
        oidPeriodo = newOidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

	public void setNumeroLoteImpresion(Long newNumeroLoteImpresion) {
        numeroLoteImpresion = newNumeroLoteImpresion;
    }

    public Long getNumeroLoteImpresion() {
        return numeroLoteImpresion;
    }

	public void setFechaImpresion(String newFechaImpresion) {
        fechaImpresion = newFechaImpresion;
    }

    public String getFechaImpresion() {
        return fechaImpresion;
    }   

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }
}