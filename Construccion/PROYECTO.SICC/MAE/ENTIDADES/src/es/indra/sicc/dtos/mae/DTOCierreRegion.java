package es.indra.sicc.dtos.mae;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOCierreRegion extends DTOAuditableSICC implements IMareDTO {
	private Long periodo;
	private Float region;
    private Boolean indReevaluacion;
    private Long marca;
    private Long canal;

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Float getRegion() {
		return region;
	}

	public void setRegion(Float newRegion) {
		region = newRegion;
	}

  public void setIndReevaluacion(Boolean indReevaluacion) {
    this.indReevaluacion = indReevaluacion;
  }

  public Boolean getIndReevaluacion() {
    return indReevaluacion;
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
	
}