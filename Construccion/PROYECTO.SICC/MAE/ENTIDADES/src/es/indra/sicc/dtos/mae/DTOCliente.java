package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.sql.Date;

public class DTOCliente extends DTOSiccPaginacion  {

        private DTOCrearClienteBasico base;
        private String criterioBusqueda1;
        private String criterioBusqueda2;
        private Date fechaNacimiento;
        private Long oid;
        private String codigoEmpleado;
        private Long nacionalidad;
        private Short edad;
        private Long estadoCivil;
        private String ocupacion;
        private String profesion;
        private String centroTrabajo;
        private String cargo;
        private Long nivelEstudios;
        private String centroEstudios;
        private Byte numeroHijos;
        private Byte personasDependientes;
        private Long NSEP;
        private Long cicloVida;
        private Boolean deseaCorrespondencia;
        private Double importeIngresos;
        private DTOVinculo[] vinculos;
        private DTOPreferencia[] preferencias;
        private DTOObservacion[] observaciones;
        private Long paisContactado;
        private String clienteContactado;
        private Long oidClienteContactado;
        private Long tipoClienteContactado;
        private Long tipoClienteContacto;
        private String tipoContacto;
        private Date fechaPrimerContacto;
        private Date fechaSiguienteContacto;
        private DTOComunicacion[] comunicaciones;
        private DTOTarjeta[] tarjetas;
        private DTOProblemaSolucion[] problemasSoluciones;
        private DTOPsicografia[] psicografias;     
        private Long pais;
        private Long idioma;
        private Long marcaContacto;
        private Long canalContacto;
        private Long periodoContacto;

        //SICC-DMCO-MAE-GCC-006 - Cleal  
        private Long indicadorActivo;
  private RecordSet rComunicaciones;
  private RecordSet rObservaciones;
  private RecordSet rPreferencia;
  private RecordSet rProblemaSolucion;
  private RecordSet rPsicografia;
  private RecordSet rTarjeta;
  private RecordSet rVinculo;


    public Long getNSEP() {
        return NSEP;
    }

    public void setNSEP(Long newNSEP) {
        NSEP = newNSEP;
    }

    public DTOCrearClienteBasico getBase() {
        return base;
    }

    public void setBase(DTOCrearClienteBasico newBase) {
        base = newBase;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String newCargo) {
        cargo = newCargo;
    }

    public String getCentroEstudios() {
        return centroEstudios;
    }

    public void setCentroEstudios(String newCentroEstudios) {
        centroEstudios = newCentroEstudios;
    }

    public String getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(String newCentroTrabajo) {
        centroTrabajo = newCentroTrabajo;
    }

    public Long getCicloVida() {
        return cicloVida;
    }

    public void setCicloVida(Long newCicloVida) {
        cicloVida = newCicloVida;
    }

    public String getClienteContactado() {
        return clienteContactado;
    }

    public void setClienteContactado(String newClienteContactado) {
        clienteContactado = newClienteContactado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String newCodigoEmpleado) {
        codigoEmpleado = newCodigoEmpleado;
    }

    public DTOComunicacion[] getComunicaciones() {
        return comunicaciones;
    }

    public void setComunicaciones(DTOComunicacion[] newComunicaciones) {
        comunicaciones = newComunicaciones;
    }

    public String getCriterioBusqueda1() {
        return criterioBusqueda1;
    }

    public void setCriterioBusqueda1(String newCriterioBusqueda1) {
        criterioBusqueda1 = newCriterioBusqueda1;
    }

    public String getCriterioBusqueda2() {
        return criterioBusqueda2;
    }

    public void setCriterioBusqueda2(String newCriterioBusqueda2) {
        criterioBusqueda2 = newCriterioBusqueda2;
    }

    public Boolean getDeseaCorrespondencia() {
        return deseaCorrespondencia;
    }

    public void setDeseaCorrespondencia(Boolean newDeseaCorrespondencia) {
        deseaCorrespondencia = newDeseaCorrespondencia;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short newEdad) {
        edad = newEdad;
    }

    public Long getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Long newEstadoCivil) {
        estadoCivil = newEstadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date newFechaNacimiento) {
        fechaNacimiento = newFechaNacimiento;
    }

    public Date getFechaPrimerContacto() {
        return fechaPrimerContacto;
    }

    public void setFechaPrimerContacto(Date newFechaPrimerContacto) {
        fechaPrimerContacto = newFechaPrimerContacto;
    }



    public Date getFechaSiguienteContacto() {
        return fechaSiguienteContacto;
    }

    public void setFechaSiguienteContacto(Date newFechaSiguienteContacto) {
        fechaSiguienteContacto = newFechaSiguienteContacto;
    }

    public Long getIdioma() {
        return idioma;
    }

    public void setIdioma(Long newIdioma) {
        idioma = newIdioma;
    }

    public Double getImporteIngresos() {
        return importeIngresos;
    }

    public void setImporteIngresos(Double newImporteIngresos) {
        importeIngresos = newImporteIngresos;
    }

    public Long getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Long newNacionalidad) {
        nacionalidad = newNacionalidad;
    }

    public Long getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(Long newNivelEstudios) {
        nivelEstudios = newNivelEstudios;
    }

    public Byte getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Byte newNumeroHijos) {
        numeroHijos = newNumeroHijos;
    }

    public DTOObservacion[] getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(DTOObservacion[] newObservaciones) {
        observaciones = newObservaciones;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String newOcupacion) {
        ocupacion = newOcupacion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getOidClienteContactado() {
        return oidClienteContactado;
    }

    public void setOidClienteContactado(Long newOidClienteContactado) {
        oidClienteContactado = newOidClienteContactado;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getPaisContactado() {
        return paisContactado;
    }

    public void setPaisContactado(Long newPaisContactado) {
        paisContactado = newPaisContactado;
    }

    public Byte getPersonasDependientes() {
        return personasDependientes;
    }

    public void setPersonasDependientes(Byte newPersonasDependientes) {
        personasDependientes = newPersonasDependientes;
    }

    public DTOPreferencia[] getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(DTOPreferencia[] newPreferencias) {
        preferencias = newPreferencias;
    }

    public DTOProblemaSolucion[] getProblemasSoluciones() {
        return problemasSoluciones;
    }

    public void setProblemasSoluciones(DTOProblemaSolucion[] newProblemasSoluciones) {
        problemasSoluciones = newProblemasSoluciones;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String newProfesion) {
        profesion = newProfesion;
    }

    public DTOPsicografia[] getPsicografias() {
        return psicografias;
    }

    public void setPsicografias(DTOPsicografia[] newPsicografias) {
        psicografias = newPsicografias;
    }

    public DTOTarjeta[] getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(DTOTarjeta[] newTarjetas) {
        tarjetas = newTarjetas;
    }

    public Long getTipoClienteContactado() {
        return tipoClienteContactado;
    }

    public void setTipoClienteContactado(Long newTipoClienteContactado) {
        tipoClienteContactado = newTipoClienteContactado;
    }

    public Long getTipoClienteContacto() {
        return tipoClienteContacto;
    }

    public void setTipoClienteContacto(Long newTipoClienteContacto) {
        tipoClienteContacto = newTipoClienteContacto;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }



    public DTOVinculo[] getVinculos() {
        return vinculos;
    }

    public void setVinculos(DTOVinculo[] newVinculos) {
        vinculos = newVinculos;
    }

    public void setTipoContacto(String newTipoContacto) {
        tipoContacto = newTipoContacto;
    }

  public Long getMarcaContacto()
  {
    return marcaContacto;
  }

  public void setMarcaContacto(Long newMarcaContacto)
  {
    marcaContacto = newMarcaContacto;
  }

  public Long getCanalContacto()
  {
    return canalContacto;
  }

  public void setCanalContacto(Long newCanalContacto)
  {
    canalContacto = newCanalContacto;
  }

  public Long getPeriodoContacto()
  {
    return periodoContacto;
  }

  public void setPeriodoContacto(Long newPeriodoContacto)
  {
    periodoContacto = newPeriodoContacto;
    base.setPeriodoContacto(newPeriodoContacto);
  }


    public void setIndicadorActivo(Long indicadorActivo)
    {
        this.indicadorActivo = indicadorActivo;
    }


    public Long getIndicadorActivo()
    {
        return indicadorActivo;
    }

  public RecordSet getRComunicaciones() {
    return rComunicaciones;
  }

  public void setRComunicaciones(RecordSet rComunicaciones) {
    this.rComunicaciones = rComunicaciones;
  }

  public RecordSet getRObservaciones() {
    return rObservaciones;
  }

  public void setRObservaciones(RecordSet rObservaciones) {
    this.rObservaciones = rObservaciones;
  }

  public RecordSet getRPreferencia() {
    return rPreferencia;
  }

  public void setRPreferencia(RecordSet rPreferencias) {
    this.rPreferencia = rPreferencias;
  }

  public RecordSet getRProblemaSolucion() {
    return rProblemaSolucion;
  }

  public void setRProblemaSolucion(RecordSet rProblemaSolucion) {
    this.rProblemaSolucion = rProblemaSolucion;
  }

  public RecordSet getRPsicografia() {
    return rPsicografia;
  }

  public void setRPsicografia(RecordSet rPsicografia) {
    this.rPsicografia = rPsicografia;
  }

  public RecordSet getRTarjeta() {
    return rTarjeta;
  }

  public void setRTarjeta(RecordSet rTarjeta) {
    this.rTarjeta = rTarjeta;
  }

  public RecordSet getRVinculo() {
    return rVinculo;
  }

  public void setRVinculo(RecordSet rVinculo) {
    this.rVinculo = rVinculo;
  }





}