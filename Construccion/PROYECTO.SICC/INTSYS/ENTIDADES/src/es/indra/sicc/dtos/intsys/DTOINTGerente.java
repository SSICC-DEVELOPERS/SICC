package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOINTGerente extends DTOBelcorp
{
    public DTOINTGerente()
    {
    }
        private String codigoGerente;
        private String nombreGerente;
        private String codigoGerenteComoConsultora;
        private String codigoRegionGerente;
        private String nombreDepartamentoGeografico;
        private String nombreProvinciaGeografica;
        private String nombreDistritoGeografico;
        private String direccionGerente;
        private String descripcionTipoCentroPoblado;
        private String codigoTipoCentroPoblado;
        private String codigoCentroPoblado;
        private String codigoUbigeo;
        private String telefonoDomicilio;
        private String faxDomicilio;
        private String numeroTelefonoCelular;
        private String estadoCivil;
        private String tipoDocumentoIdentidad;
        private String numeroDocumentoIdentidad;
        private Date fechaNacimiento;
        private String email;
        private Date fechaInicioContrato;
        private Date fechaFinContrato;
        private String flagTipoAccion;
        private String codigoZonaGerente;
        private String descripcionCentroPoblado; // Incidencia BELC300015412 
        private String numPasaporte; //Incidencia BELC300018338 
        private String codigoConsultora; //Incidencia SiCC-20070283

    public String getCodigoCentroPoblado()
    {
        return codigoCentroPoblado;
    }

    public void setCodigoCentroPoblado(String codigoCentroPoblado)
    {
        this.codigoCentroPoblado = codigoCentroPoblado;
    }

    public String getCodigoGerenteComoConsultora()
    {
        return codigoGerenteComoConsultora;
    }

    public void setCodigoGerenteComoConsultora(String codigoGerenteComoConsultora)
    {
        this.codigoGerenteComoConsultora = codigoGerenteComoConsultora;
    }

    public String getCodigoGerente()
    {
        return codigoGerente;
    }

    public void setCodigoGerente(String codigoGerente)
    {
        this.codigoGerente = codigoGerente;
    }

    public String getCodigoRegionGerente()
    {
        return codigoRegionGerente;
    }

    public void setCodigoRegionGerente(String codigoRegionGerente)
    {
        this.codigoRegionGerente = codigoRegionGerente;
    }

    public String getCodigoTipoCentroPoblado()
    {
        return codigoTipoCentroPoblado;
    }

    public void setCodigoTipoCentroPoblado(String codigoTipoCentroPoblado)
    {
        this.codigoTipoCentroPoblado = codigoTipoCentroPoblado;
    }

    public String getCodigoUbigeo()
    {
        return codigoUbigeo;
    }

    public void setCodigoUbigeo(String codigoUbigeo)
    {
        this.codigoUbigeo = codigoUbigeo;
    }

    public String getDescripcionTipoCentroPoblado()
    {
        return descripcionTipoCentroPoblado;
    }

    public void setDescripcionTipoCentroPoblado(String descripcionTipoCentroPoblado)
    {
        this.descripcionTipoCentroPoblado = descripcionTipoCentroPoblado;
    }

    public String getDireccionGerente()
    {
        return direccionGerente;
    }

    public void setDireccionGerente(String direccionGerente)
    {
        this.direccionGerente = direccionGerente;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }

    public String getFaxDomicilio()
    {
        return faxDomicilio;
    }

    public void setFaxDomicilio(String faxDomicilio)
    {
        this.faxDomicilio = faxDomicilio;
    }

    public Date getFechaFinContrato()
    {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato)
    {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaInicioContrato()
    {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato)
    {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFlagTipoAccion()
    {
        return flagTipoAccion;
    }

    public void setFlagTipoAccion(String flagTipoAccion)
    {
        this.flagTipoAccion = flagTipoAccion;
    }

    public String getNombreDepartamentoGeografico()
    {
        return nombreDepartamentoGeografico;
    }

    public void setNombreDepartamentoGeografico(String nombreDepartamentoGeografico)
    {
        this.nombreDepartamentoGeografico = nombreDepartamentoGeografico;
    }

    public String getNombreDistritoGeografico()
    {
        return nombreDistritoGeografico;
    }

    public void setNombreDistritoGeografico(String nombreDistritoGeografico)
    {
        this.nombreDistritoGeografico = nombreDistritoGeografico;
    }

    public String getNombreGerente()
    {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente)
    {
        this.nombreGerente = nombreGerente;
    }

    public String getNombreProvinciaGeografica()
    {
        return nombreProvinciaGeografica;
    }

    public void setNombreProvinciaGeografica(String nombreProvinciaGeografica)
    {
        this.nombreProvinciaGeografica = nombreProvinciaGeografica;
    }

    public String getNumeroDocumentoIdentidad()
    {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad)
    {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public String getNumeroTelefonoCelular()
    {
        return numeroTelefonoCelular;
    }

    public void setNumeroTelefonoCelular(String numeroTelefonoCelular)
    {
        this.numeroTelefonoCelular = numeroTelefonoCelular;
    }

    public String getTelefonoDomicilio()
    {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio)
    {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getTipoDocumentoIdentidad()
    {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad)
    {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getCodigoZonaGerente() {
        return codigoZonaGerente;
    }

    public void setCodigoZonaGerente(String codigoZonaGerente) {
        this.codigoZonaGerente = codigoZonaGerente;
    }

    public String getDescripcionCentroPoblado() {
        return descripcionCentroPoblado;
    }

    public void setDescripcionCentroPoblado(String descripcionCentroPoblado) {
        this.descripcionCentroPoblado = descripcionCentroPoblado;
    }

    public String getNumPasaporte()
    {
        return numPasaporte;
    }

    public void setNumPasaporte(String numPasaporte)
    {
        this.numPasaporte = numPasaporte;
    }


  public void setCodigoConsultora(String codigoConsultora)
  {
    this.codigoConsultora = codigoConsultora;
  }


  public String getCodigoConsultora()
  {
    return codigoConsultora;
  }
}