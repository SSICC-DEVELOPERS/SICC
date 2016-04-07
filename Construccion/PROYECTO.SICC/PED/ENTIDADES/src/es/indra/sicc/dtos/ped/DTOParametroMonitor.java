package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;
import java.util.ArrayList;
public class DTOParametroMonitor extends DTOAuditableSICC{

  private Long oidGrupoProceso;
  private Date fechaFacturacion;
  private String modoFacturacion;
  private String IDProc;
  private ArrayList secuencia;
  private String grupoReversion;
  //pperez 17/08/2005 incidencia 16500
  private String codCaja;
  
    // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
    private Boolean indOrdenesCompra;
    private String codigoUsuario;
    
	public DTOParametroMonitor() {
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date newFechaFacturacion) {
		fechaFacturacion = newFechaFacturacion;
	}

	public String getModoFacturacion() {
		return modoFacturacion;
	}

	public void setModoFacturacion(String newModoFacturacion) {
		modoFacturacion = newModoFacturacion;
	}

	public Long getOidGrupoProceso() {
		return oidGrupoProceso;
	}

	public void setOidGrupoProceso(Long newOidGrupoProceso) {
		oidGrupoProceso = newOidGrupoProceso;
	}

  public String getIDProc() {
    return IDProc;
  }

  public void setIDProc(String newIDProc) {
    IDProc = newIDProc;
  }

  public ArrayList getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(ArrayList newSecuencia) {
    secuencia = newSecuencia;
  }
  
	public String getGrupoReversion() {
		return grupoReversion;
	}

	public void setGrupoReversion(String newGrupoReversion) {
		grupoReversion = newGrupoReversion;
	}  


    public void setCodCaja(String codCaja) {
        this.codCaja = codCaja;
    }


    public String getCodCaja() {
        return codCaja;
    }

    public void setIndOrdenesCompra(Boolean indOrdenesCompra) {
        this.indOrdenesCompra = indOrdenesCompra;
    }

    public Boolean getIndOrdenesCompra() {
        return indOrdenesCompra;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }
}
