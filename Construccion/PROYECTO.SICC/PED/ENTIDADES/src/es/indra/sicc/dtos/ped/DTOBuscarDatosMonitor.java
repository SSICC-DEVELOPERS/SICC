package es.indra.sicc.dtos.ped;

import java.util.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOBuscarDatosMonitor extends DTOAuditableSICC  {

    private Date fechaInicio;
	private Date fechaFin;
	private Long plantilla;
  private ArrayList oidTipoSolicitudPais;
  private Long oidAcceso;
  private ArrayList oidRegiones;
  private ArrayList oidZonas;
  
  // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011
  private Long oidPeriodo;
  private Long oidPeriodoSiguiente;
  
	public DTOBuscarDatosMonitor() {
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date newFechaFin) {
		fechaFin = newFechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date newFechaInicio) {
		fechaInicio = newFechaInicio;
	}

	public Long getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Long newPlantilla) {
		plantilla = newPlantilla;
	}

  public ArrayList getOidTipoSolicitudPais()
  {
    return oidTipoSolicitudPais;
  }

  public void setOidTipoSolicitudPais(ArrayList oidTipoSolicitudPais)
  {
    this.oidTipoSolicitudPais = oidTipoSolicitudPais;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public void setOidRegiones(ArrayList oidRegiones)
  {
    this.oidRegiones = oidRegiones;
  }

  public ArrayList getOidRegiones()
  {
    return oidRegiones;
  }

  public void setOidZonas(ArrayList oidZonas)
  {
    this.oidZonas = oidZonas;
  }

  public ArrayList getOidZonas()
  {
    return oidZonas;
  }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodoSiguiente(Long oidPeriodoSiguiente) {
        this.oidPeriodoSiguiente = oidPeriodoSiguiente;
    }

    public Long getOidPeriodoSiguiente() {
        return oidPeriodoSiguiente;
    }
}
