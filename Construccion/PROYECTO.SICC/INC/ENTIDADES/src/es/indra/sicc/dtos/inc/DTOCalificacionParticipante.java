package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOCalificacionParticipante extends DTOBelcorp 
{
  private Long oid;
  private Long oidParticipante;
  private Long oidEstatusVenta;
  private String desParticipante;
  private String desEstatusVenta;
  private BigDecimal montoMinimo;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidParticipante()
  {
    return oidParticipante;
  }

  public void setOidParticipante(Long oidParticipante)
  {
    this.oidParticipante = oidParticipante;
  }

  public Long getOidEstatusVenta()
  {
    return oidEstatusVenta;
  }

  public void setOidEstatusVenta(Long oidEstatusVenta)
  {
    this.oidEstatusVenta = oidEstatusVenta;
  }

  public String getDesParticipante()
  {
    return desParticipante;
  }

  public void setDesParticipante(String desParticipante)
  {
    this.desParticipante = desParticipante;
  }

  public String getDesEstatusVenta()
  {
    return desEstatusVenta;
  }

  public void setDesEstatusVenta(String desEstatusVenta)
  {
    this.desEstatusVenta = desEstatusVenta;
  }

  public BigDecimal getMontoMinimo()
  {
    return montoMinimo;
  }

  public void setMontoMinimo(BigDecimal montoMinimo)
  {
    this.montoMinimo = montoMinimo;
  }
}