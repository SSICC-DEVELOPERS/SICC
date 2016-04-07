package es.indra.sicc.dtos.ped;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.sql.Date;

public class DTOCargaInicialMonitor extends DTOAuditableSICC  {
  private Boolean usaPlantillas;
	private RecordSet plantillas;

    // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011
    private String codigoPais;
    private String codigoPeriodo;
    private Date fechaProceso;  //fecha Proceso de Facturacion
    private Long oidPeriodo;    //periodo de Facturacion
    private Long oidPeriodoSiguiente;
    private Date fechaFinPeriodoSiguiente;
    
	public DTOCargaInicialMonitor() {
	}

	public Boolean getUsaPlantillas() {
		return usaPlantillas;
	}

	public void setUsaPlantillas(Boolean newUsaPlantillas) {
		usaPlantillas = newUsaPlantillas;
	}

	public RecordSet getPlantillas() {
		return plantillas;
	}

	public void setPlantillas(RecordSet newPlantillas) {
		plantillas = newPlantillas;
	}


    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Date getFechaProceso() {
        return fechaProceso;
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

    public void setFechaFinPeriodoSiguiente(Date fechaFinPeriodoSiguiente) {
        this.fechaFinPeriodoSiguiente = fechaFinPeriodoSiguiente;
    }

    public Date getFechaFinPeriodoSiguiente() {
        return fechaFinPeriodoSiguiente;
    }
}
