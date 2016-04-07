package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;
import java.sql.Date;

public class DTOInfoMonitor extends DTOAuditableSICC  {
  private ArrayList secuencia;  //DTOSecuenciaSolicitudes[]
  private Date fechaInicio;
  private Date fechaFin;
  private Long GP;
  private Boolean indTipificacion;
  private Date fechaFacturacion;
  private Boolean indPreFacturacion;

  // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011
  private String codigoPais;
  private Long oidPeriodo;
  private String codigoPeriodo;
  private Date fechaProceso;
  private Long oidPeriodoSiguiente;

  // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
  private Boolean indOrdenesCompra;
  private String codigoBatch;
  private String codigoUsuario;  

  public DTOInfoMonitor() {
  }

  public ArrayList getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(ArrayList newSecuencia) {
    secuencia = newSecuencia;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date newFechaInicio) {
    fechaInicio = newFechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date newFechaFin) {
    fechaFin = newFechaFin;
  }

  public Long getGP() {
    return GP;
  }

  public void setGP(Long newGP) {
    GP = newGP;
  }

  public Boolean getIndTipificacion() {
    return indTipificacion;
  }

  public void setIndTipificacion(Boolean newIndTipificacion) {
    indTipificacion = newIndTipificacion;
  }

  public Date getFechaFacturacion() {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date newFechaFacturacion) {
    fechaFacturacion = newFechaFacturacion;
  }

  public Boolean getIndPreFacturacion() {
    return indPreFacturacion;
  }

  public void setIndPreFacturacion(Boolean newIndPreFacturacion) {
    indPreFacturacion = newIndPreFacturacion;
  }


    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
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

    public void setOidPeriodoSiguiente(Long oidPeriodoSiguiente) {
        this.oidPeriodoSiguiente = oidPeriodoSiguiente;
    }

    public Long getOidPeriodoSiguiente() {
        return oidPeriodoSiguiente;
    }

    public void setIndOrdenesCompra(Boolean indOrdenesCompra) {
        this.indOrdenesCompra = indOrdenesCompra;
    }

    public Boolean getIndOrdenesCompra() {
        return indOrdenesCompra;
    }

    public void setCodigoBatch(String codigoBatch) {
        this.codigoBatch = codigoBatch;
    }

    public String getCodigoBatch() {
        return codigoBatch;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }
}
