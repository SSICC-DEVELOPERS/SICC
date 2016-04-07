package es.indra.sicc.dtos.com;

/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTODatosCalculosComision
 * Fecha:             06/04/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334-N034
 * Descripcion:       DTODatosCalculosComision
 * @version           1.0
 * @autor             pcabrera
 */



import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTODatosCalculosComision extends DTOAuditableSICC
{
  
  private ArrayList gerentes;
  private Long[] oidAccesos;
  private Long oidSubacceso;
  private Integer version;
  private Long oidComision;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPlantilla;
  private Long oidTipoPlantilla;
  private Long oidPeriodo;
  private Long oidSV;
  private Long oidRegion;
  private Long oidZona;
  private Long oidTerritorio;
  private Long oidSeccion;
  private String codigoEmpleado;

  public DTODatosCalculosComision()
  {
  }

  public ArrayList getGerentes()
  {
    return gerentes;
  }

  public void setGerentes(ArrayList gerentes)
  {
    this.gerentes = gerentes;
  }

  public Long[] getOidAccesos()
  {
    return oidAccesos;
  }

  public void setOidAccesos(Long[] oidAccesos)
  {
    this.oidAccesos = oidAccesos;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Integer getVersion()
  {
    return version;
  }

  public void setVersion(Integer version)
  {
    this.version = version;
  }

  public Long getOidComision()
  {
    return oidComision;
  }

  public void setOidComision(Long oidComision)
  {
    this.oidComision = oidComision;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidSV()
  {
    return oidSV;
  }

  public void setOidSV(Long oidSV)
  {
    this.oidSV = oidSV;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

    public Long getOidTipoPlantilla()
    {
        return oidTipoPlantilla;
    }

    public void setOidTipoPlantilla(Long oidTipoPlantilla)
    {
        this.oidTipoPlantilla = oidTipoPlantilla;
    }

    public String getCodigoEmpleado()
    {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado)
    {
        this.codigoEmpleado = codigoEmpleado;
    }
}