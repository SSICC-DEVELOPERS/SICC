/* DTOCompromisoDePago.java
 *
 * Created on 3 de marzo de 2005, 5:42 PM		
 */

package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author  Sergio Platas
 */


public class DTOCompromisoDePago extends DTOAuditableSICC 
{
  private Date fechaPago;
  private BigDecimal importePago;
  private Date fechaSeguimientoPrevisto;
  private Long banco;
  private Long sucursal;
  private String observaciones;
  private Date fechaCompromisoPago;

  public Date getFechaPago()
  {
    return fechaPago;
  }

  public void setFechaPago(Date fechaPago)
  {
    this.fechaPago = fechaPago;
  }

  public BigDecimal getImportePago()
  {
    return importePago;
  }

  public void setImportePago(BigDecimal importePago)
  {
    this.importePago = importePago;
  }

  public Date getFechaSeguimientoPrevisto()
  {
    return fechaSeguimientoPrevisto;
  }

  public void setFechaSeguimientoPrevisto(Date fechaSeguimientoPrevisto)
  {
    this.fechaSeguimientoPrevisto = fechaSeguimientoPrevisto;
  }

  public Long getBanco()
  {
    return banco;
  }

  public void setBanco(Long banco)
  {
    this.banco = banco;
  }

  public Long getSucursal()
  {
    return sucursal;
  }

  public void setSucursal(Long sucursal)
  {
    this.sucursal = sucursal;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Date getFechaCompromisoPago()
  {
    return fechaCompromisoPago;
  }

  public void setFechaCompromisoPago(Date fechaCompromisoPago)
  {
    this.fechaCompromisoPago = fechaCompromisoPago;
  }
}