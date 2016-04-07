/* DTOEBuscarConsultorasTelecobranzas.java
 *
 * Created on 3 de marzo de 2005, 5:55 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

/**
 *
 * @author  Sergio Platas
 */


public class DTOEBuscarConsultorasTelecobranza extends DTOSiccPaginacion 
{
  private String usuario;
  private String codigoCliente;
  private Date fechaPago;
  private Long accionCobranza;
  private Long estadoAsignacion;

  public String getUsuario()
  {
    return usuario;
  }

  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public Date getFechaPago()
  {
    return fechaPago;
  }

  public void setFechaPago(Date fechaPago)
  {
    this.fechaPago = fechaPago;
  }

  public Long getAccionCobranza()
  {
    return accionCobranza;
  }

  public void setAccionCobranza(Long accionCobranza)
  {
    this.accionCobranza = accionCobranza;
  }

  public Long getEstadoAsignacion()
  {
    return estadoAsignacion;
  }

  public void setEstadoAsignacion(Long estadoAsignacion)
  {
    this.estadoAsignacion = estadoAsignacion;
  }
}