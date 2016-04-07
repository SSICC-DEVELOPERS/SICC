/* DTOConsultarLiquidacionComisionesCobranza.java
 *
 * Created on 4 de marzo de 2005, 1:38 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

/**
 *
 * @author  Sergio Platas
 */

public class DTOConsultarLiquidacionComisionesCobranza extends DTOSiccPaginacion 
{
  private Long pais;
  private Long etapa;
  private Long marca;
  private Long canal;
  private Long periodo;
  private Date fechaAsignacion;
  private Long usuarioCobranza;

  public Long getPais()
  {
    return pais;
  }

  public void setPais(Long pais)
  {
    this.pais = pais;
  }

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

  public Date getFechaAsignacion()
  {
    return fechaAsignacion;
  }

  public void setFechaAsignacion(Date fechaAsignacion)
  {
    this.fechaAsignacion = fechaAsignacion;
  }

  public Long getUsuarioCobranza()
  {
    return usuarioCobranza;
  }

  public void setUsuarioCobranza(Long usuarioCobranza)
  {
    this.usuarioCobranza = usuarioCobranza;
  }
}