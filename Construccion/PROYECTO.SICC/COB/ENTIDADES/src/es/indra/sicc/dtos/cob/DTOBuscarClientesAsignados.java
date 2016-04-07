package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOBuscarClientesAsignados extends DTOSiccPaginacion 
{
  public Long etapa;
  public Long marca;
  public Long canal;
  public Long periodo;
  public Long subgerenciaVentas;
  public Long regionDesde;
  public Long regionHasta;
  public Long zonaDesde;
  public Long zonaHasta;
  public Long seccionDesde;
  public Long seccionHasta;
  public Date fechaVencimiento;
  public String territorioDesde;
  public String territorioHasta;
  public Date fechaDoc;

  public DTOBuscarClientesAsignados()
  {
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

  public Long getSubgerenciaVentas()
  {
    return subgerenciaVentas;
  }

  public void setSubgerenciaVentas(Long subgerenciaVentas)
  {
    this.subgerenciaVentas = subgerenciaVentas;
  }

  public Long getRegionDesde()
  {
    return regionDesde;
  }

  public void setRegionDesde(Long regionDesde)
  {
    this.regionDesde = regionDesde;
  }

  public Long getRegionHasta()
  {
    return regionHasta;
  }

  public void setRegionHasta(Long regionHasta)
  {
    this.regionHasta = regionHasta;
  }

  public Long getZonaDesde()
  {
    return zonaDesde;
  }

  public void setZonaDesde(Long zonaDesde)
  {
    this.zonaDesde = zonaDesde;
  }

  public Long getZonaHasta()
  {
    return zonaHasta;
  }

  public void setZonaHasta(Long zonaHasta)
  {
    this.zonaHasta = zonaHasta;
  }

  public Long getSeccionDesde()
  {
    return seccionDesde;
  }

  public void setSeccionDesde(Long seccionDesde)
  {
    this.seccionDesde = seccionDesde;
  }

  public Long getSeccionHasta()
  {
    return seccionHasta;
  }

  public void setSeccionHasta(Long seccionHasta)
  {
    this.seccionHasta = seccionHasta;
  }

  public Date getFechaVencimiento()
  {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date fechaVencimiento)
  {
    this.fechaVencimiento = fechaVencimiento;
  }

  public String getTerritorioDesde()
  {
    return territorioDesde;
  }

  public void setTerritorioDesde(String territorioDesde)
  {
    this.territorioDesde = territorioDesde;
  }

  public String getTerritorioHasta()
  {
    return territorioHasta;
  }

  public void setTerritorioHasta(String territorioHasta)
  {
    this.territorioHasta = territorioHasta;
  }

  public Date getFechaDoc()
  {
    return fechaDoc;
  }

  public void setFechaDoc(Date fechaDoc)
  {
    this.fechaDoc = fechaDoc;
  }
}