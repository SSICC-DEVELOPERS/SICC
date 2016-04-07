/* DTOCriteriosBusquedaLiquidacionCom.java 
 *
 * Created on 4 de marzo de 2005, 1:07 PM		
 */
package es.indra.sicc.dtos.cob;
import java.sql.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 *
 * @author  Sergio Platas
 */
 
public class DTOCriteriosBusquedaLiquidacionCom extends DTOSiccPaginacion 
{
  private Long etapa;
  private Long marca;
  private Long canal;
  private Long periodo;
  private Long usuarioCobranza;
  private Date fechaAsignacion;
  private String userLogin;
  private Boolean agruparPorCliente;
  private Long[] clientes;
  private String fechaAsignacionString;
  private String formatoFecha;
  Boolean simulacion;

  public Long getEtapa()
  {
    return etapa;
  }

  public void setEtapa(Long etapa)
  {
    this.etapa = etapa;
  }

  public Long getMarca()
  {
    return marca;
  }

  public void setMarca(Long marca)
  {
    this.marca = marca;
  }

  public Long getCanal()
  {
    return canal;
  }

  public void setCanal(Long canal)
  {
    this.canal = canal;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getUsuarioCobranza()
  {
    return usuarioCobranza;
  }

  public void setUsuarioCobranza(Long usuarioCobranza)
  {
    this.usuarioCobranza = usuarioCobranza;
  }

  public Date getFechaAsignacion()
  {
    return fechaAsignacion;
  }

  public void setFechaAsignacion(Date fechaAsignacion)
  {
    this.fechaAsignacion = fechaAsignacion;
  }

  public String getUserLogin()
  {
    return userLogin;
  }

  public void setUserLogin(String userLogin)
  {
    this.userLogin = userLogin;
  }

  public Boolean getAgruparPorCliente()
  {
    return agruparPorCliente;
  }

  public void setAgruparPorCliente(Boolean agruparPorCliente)
  {
    this.agruparPorCliente = agruparPorCliente;
  }

  public Long[] getClientes()
  {
    return clientes;
  }

  public void setClientes(Long[] clientes)
  {
    this.clientes = clientes;
  }

  public String getFechaAsignacionString()
  {
    return fechaAsignacionString;
  }

  public void setFechaAsignacionString(String fechaAsignacionString)
  {
    this.fechaAsignacionString = fechaAsignacionString;
  }

  public String getFormatoFecha()
  {
    return formatoFecha;
  }

  public void setFormatoFecha(String formatoFecha)
  {
    this.formatoFecha = formatoFecha;
  }

  public Boolean getSimulacion()
  {
    return simulacion;
  }

  public void setSimulacion(Boolean simulacion)
  {
    this.simulacion = simulacion;
  }
}