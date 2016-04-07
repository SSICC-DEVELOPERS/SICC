package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOReevaluar  extends  DTOAuditableSICC {
	
  private Long oidCliente;
	private Long oidMarca;
	private Long oidCanal;
	private Long oidPeriodo;
	private Long oidClaseSolicitud;
	

	public DTOReevaluar () {
	}


  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }


  public Long getOidCliente() {
    return oidCliente;
  }


  public void setOidMarca(Long oidMarca) {
    this.oidMarca = oidMarca;
  }


  public Long getOidMarca() {
    return oidMarca;
  }


  public void setOidCanal(Long oidCanal) {
    this.oidCanal = oidCanal;
  }


  public Long getOidCanal() {
    return oidCanal;
  }


  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }


  public Long getOidPeriodo() {
    return oidPeriodo;
  }


  public void setOidClaseSolicitud(Long oidClaseSolicitud) {
    this.oidClaseSolicitud = oidClaseSolicitud;
  }


  public Long getOidClaseSolicitud() {
    return oidClaseSolicitud;
  }

	
}