/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesCobranzaTipoParticipante
 * Fecha:             07/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-DTO-201-334-N024-1
 * Descripcion:       DTOComisionesCobranzaTipoParticipante
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOComisionesCobranzaTipoParticipante extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidComisionesCobranzas;
  private Integer nivelTramo;
  private Integer diasComision;
  private BigDecimal porcentajeRecuperacion;
  private BigDecimal porcentajeComision;
  // vbongiov -- Cambio 20090913 -- 5/08/2009
  private BigDecimal porcentajeActividad;

  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
  private BigDecimal porcentajeComisionActividad;

  public DTOComisionesCobranzaTipoParticipante()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidComisionesCobranzas()
  {
    return oidComisionesCobranzas;
  }

  public void setOidComisionesCobranzas(Long oidComisionesCobranzas)
  {
    this.oidComisionesCobranzas = oidComisionesCobranzas;
  }

  public Integer getNivelTramo()
  {
    return nivelTramo;
  }

  public void setNivelTramo(Integer nivelTramo)
  {
    this.nivelTramo = nivelTramo;
  }

  public Integer getDiasComision()
  {
    return diasComision;
  }

  public void setDiasComision(Integer diasComision)
  {
    this.diasComision = diasComision;
  }

  public BigDecimal getPorcentajeRecuperacion()
  {
    return porcentajeRecuperacion;
  }

  public void setPorcentajeRecuperacion(BigDecimal porcentajeRecuperacion)
  {
    this.porcentajeRecuperacion = porcentajeRecuperacion;
  }

  public BigDecimal getPorcentajeComision()
  {
    return porcentajeComision;
  }

  public void setPorcentajeComision(BigDecimal porcentajeComision)
  {
    this.porcentajeComision = porcentajeComision;
  }
  
  public BigDecimal getPorcentajeActividad()
  {
    return porcentajeActividad;
  }
  
  public void setPorcentajeActividad(BigDecimal porcentajeActividad)
  {
    this.porcentajeActividad = porcentajeActividad;
  }

  public void setPorcentajeComisionActividad(BigDecimal porcentajeComisionActividad) {
    this.porcentajeComisionActividad = porcentajeComisionActividad;
  }

  public BigDecimal getPorcentajeComisionActividad() {
    return porcentajeComisionActividad;
  }
}
