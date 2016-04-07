package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.sql.Date;

public class DTOConsultaCliente extends DTOAuditableSICC  {

        private RecordSet tiposSubtipos;
        private RecordSet identificaciones;
        private String apellido1;
        private String apellido2;
        private String apellidoCasada;
        private String nombre1;
        private String nombre2;
        private Byte tratamiento;
        private Character sexo;
        private Date fechaIngreso;
        private String formaPago;
        private Date fechaNacimiento;
        private String codigoEmpleado;
        private String nacionalidad;
        private String edad;
        private String estadoCivil;
        private String ocupacion;
        private String profesion;
        private String centroTrabajo;
        private String cargo;
        private String centro;
        private String numeroHijos;
        private String personasDependientes;
        private String NSEP;
        private String cicloVidaFamiliar;
        private Boolean deseaCorrespondencia;
        private String importeIngreso;
        private RecordSet vinculos;
        private RecordSet preferencias;
        private RecordSet observaciones;
        private String paisContactado;
        private String codigoClienteContactado;
        private String tipoClienteContactado;
        private String tipoContacto;
        private Date fechaContacto;
        private Date fechaSiguienteContacto;
        private RecordSet direcciones;
        private RecordSet comunicaciones;
        private String[] marcas;
        private RecordSet tarjetas;
        private RecordSet clasificaciones;
        private RecordSet problemasSoluciones;
        private RecordSet psicografias;
        private String nivelEstudios;
        private Long marcaContacto;
        private Long canalContacto;
        private Long periodoContacto;
       
        private String marcaContactoDesc;
        private String canalContactoDesc;
        private String periodoContactoDesc;
        
        //SICC-DMCO-MAE-GCC-006 - Cleal
        private Boolean indicadorActivo;
        
        // ssantana, 8/11/2005, inc.  BELC300021214
        private String codigoCliente;


    public String getNSEP() {
        return NSEP;
    }

    public void setNSEP(String newNSEP) {
        NSEP = newNSEP;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String newApellido1) {
        apellido1 = newApellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String newApellido2) {
        apellido2 = newApellido2;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String newApellidoCasada) {
        apellidoCasada = newApellidoCasada;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String newCargo) {
        cargo = newCargo;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String newCentro) {
        centro = newCentro;
    }

    public String getCentroTrabajo() {
        return centroTrabajo;
    }

    public void setCentroTrabajo(String newCentroTrabajo) {
        centroTrabajo = newCentroTrabajo;
    }

    public String getCicloVidaFamiliar() {
        return cicloVidaFamiliar;
    }

    public void setCicloVidaFamiliar(String newCicloVidaFamiliar) {
        cicloVidaFamiliar = newCicloVidaFamiliar;
    }

    public RecordSet getClasificaciones() {
        return clasificaciones;
    }

    public void setClasificaciones(RecordSet newClasificaciones) {
        clasificaciones = newClasificaciones;
    }

    public String getCodigoClienteContactado() {
        return codigoClienteContactado;
    }

    public void setCodigoClienteContactado(String newCodigoClienteContactado) {
        codigoClienteContactado = newCodigoClienteContactado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String newCodigoEmpleado) {
        codigoEmpleado = newCodigoEmpleado;
    }

    public RecordSet getComunicaciones() {
        return comunicaciones;
    }

    public void setComunicaciones(RecordSet newComunicaciones) {
        comunicaciones = newComunicaciones;
    }

    public Boolean getDeseaCorrespondencia() {
        return deseaCorrespondencia;
    }

    public void setDeseaCorrespondencia(Boolean newDeseaCorrespondencia) {
        deseaCorrespondencia = newDeseaCorrespondencia;
    }

    public RecordSet getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(RecordSet newDirecciones) {
        direcciones = newDirecciones;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String newEdad) {
        edad = newEdad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String newEstadoCivil) {
        estadoCivil = newEstadoCivil;
    }

    public Date getFechaContacto() {
        return fechaContacto;
    }

    public void setFechaContacto(Date newFechaContacto) {
        fechaContacto = newFechaContacto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date newFechaIngreso) {
        fechaIngreso = newFechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date newFechaNacimiento) {
        fechaNacimiento = newFechaNacimiento;
    }



    public Date getFechaSiguienteContacto() {
        return fechaSiguienteContacto;
    }

    public void setFechaSiguienteContacto(Date newFechaSiguienteContacto) {
        fechaSiguienteContacto = newFechaSiguienteContacto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String newFormaPago) {
        formaPago = newFormaPago;
    }

    public RecordSet getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(RecordSet newIdentificaciones) {
        identificaciones = newIdentificaciones;
    }

    public String getImporteIngreso() {
        return importeIngreso;
    }

    public void setImporteIngreso(String newImporteIngreso) {
        importeIngreso = newImporteIngreso;
    }

    public String[] getMarcas() {
        return marcas;
    }

    public void setMarcas(String[] newMarcas) {
        marcas = newMarcas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String newNacionalidad) {
        nacionalidad = newNacionalidad;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String newNombre1) {
        nombre1 = newNombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String newNombre2) {
        nombre2 = newNombre2;
    }

    public String getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(String newNumeroHijos) {
        numeroHijos = newNumeroHijos;
    }

    public RecordSet getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(RecordSet newObservaciones) {
        observaciones = newObservaciones;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String newOcupacion) {
        ocupacion = newOcupacion;
    }

    public String getPaisContactado() {
        return paisContactado;
    }

    public void setPaisContactado(String newPaisContactado) {
        paisContactado = newPaisContactado;
    }

    public String getPersonasDependientes() {
        return personasDependientes;
    }

    public void setPersonasDependientes(String newPersonasDependientes) {
        personasDependientes = newPersonasDependientes;
    }

    public RecordSet getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(RecordSet newPreferencias) {
        preferencias = newPreferencias;
    }

    public RecordSet getProblemasSoluciones() {
        return problemasSoluciones;
    }

    public void setProblemasSoluciones(RecordSet newProblemasSoluciones) {
        problemasSoluciones = newProblemasSoluciones;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String newProfesion) {
        profesion = newProfesion;
    }

    public RecordSet getPsicografias() {
        return psicografias;
    }

    public void setPsicografias(RecordSet newPsicografias) {
        psicografias = newPsicografias;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character newSexo) {
        sexo = newSexo;
    }

    public RecordSet getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(RecordSet newTarjetas) {
        tarjetas = newTarjetas;
    }

    public String getTipoClienteContactado() {
        return tipoClienteContactado;
    }

    public void setTipoClienteContactado(String newTipoClienteContactado) {
        tipoClienteContactado = newTipoClienteContactado;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String newTipoContacto) {
        tipoContacto = newTipoContacto;
    }

    public RecordSet getTiposSubtipos() {
        return tiposSubtipos;
    }

    public void setTiposSubtipos(RecordSet newTiposSubtipos) {
        tiposSubtipos = newTiposSubtipos;
    }

    public Byte getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Byte newTratamiento) {
        tratamiento = newTratamiento;
    }

    public RecordSet getVinculos() {
        return vinculos;
    }

    public void setVinculos(RecordSet newVinculos) {
        vinculos = newVinculos;
    }


    public void setNivelEstudios(String nivelEstudios)
    {
      this.nivelEstudios = nivelEstudios;
    }

    public String getNivelEstudios()
    {
      return this.nivelEstudios;
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
  }

  public void setMarcaContactoDesc(String marcaContactoDesc)
  {
    this.marcaContactoDesc = marcaContactoDesc;
  }

  public String getMarcaContactoDesc()
  {
    return this.marcaContactoDesc;
  }

  public void setCanalContactoDesc(String canalContactoDesc)
  {
    this.canalContactoDesc = canalContactoDesc;
  }

  public String getCanalContactoDesc()
  {
    return this.canalContactoDesc;
  }

  public void setPeriodoContactoDesc(String periodoContactoDesc)
  {
    this.periodoContactoDesc = periodoContactoDesc;
  }

  public String getPeriodoContactoDesc()
  {
    return this.periodoContactoDesc;
  }


    public void setIndicadorActivo(Boolean indicadorActivo)
    {
        this.indicadorActivo = indicadorActivo;
    }


    public Boolean getIndicadorActivo()
    {
        return indicadorActivo;
    }

// ssantana, 8/11/2005, inc.  BELC300021214
  public String getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

}