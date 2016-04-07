package es.indra.sicc.dtos.ped;

import es.indra.sicc.dtos.intsys.DTOCargarOrdenesDeCompra;
import java.util.ArrayList;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
public class DTOArranqueGP extends DTOAuditableSICC {
	private ArrayList ListaSolicitudes ;
	private DTOParametroMonitor parametros;
  private DTOCargarOrdenesDeCompra dtoCargarOrdenesDeCompraOCR;
	
        // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
        private String codigoBatch;
	
	public DTOArranqueGP() {
	}

	public ArrayList getListaSolicitudes() {
		return ListaSolicitudes;
	}

	public void setListaSolicitudes(ArrayList newListaSolicitudes) {
		ListaSolicitudes = newListaSolicitudes;
	}

	public DTOParametroMonitor getParametros() {
		return parametros;
	}

	public void setParametros(DTOParametroMonitor newParametros) {
		parametros = newParametros;
	}

  public DTOCargarOrdenesDeCompra getDtoCargarOrdenesDeCompraOCR()
  {
    return dtoCargarOrdenesDeCompraOCR;
  }

  public void setDtoCargarOrdenesDeCompraOCR(DTOCargarOrdenesDeCompra dtoCargarOrdenesDeCompraOCR)
  {
    this.dtoCargarOrdenesDeCompraOCR = dtoCargarOrdenesDeCompraOCR;
  }
  
  private Boolean indTipificacion;
     public Boolean getIndTipificacion()
    {
        return indTipificacion;
    }

    public void setIndTipificacion(Boolean indTipificacion)
    {
        this.indTipificacion = indTipificacion;
    }


    public void setCodigoBatch(String codigoBatch) {
        this.codigoBatch = codigoBatch;
    }

    public String getCodigoBatch() {
        return codigoBatch;
    }
}
