package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.sql.Date;



public class DTOCrearClienteBasico extends DTOAuditableSICC  {

        private DTOTipoSubtipoCliente[] tiposSubtipos;      
        private DTOIdentificacion[] identificaciones;       
        private String codigoCliente;
        private String digitoControl;
        private String apellido1;
        private String apellido2;
        private String apellidoCasada;
        private String nombre1;
        private String nombre2;
        private String tratamiento;
        private String sexo;
        private Date fechaIngreso;
        private Long formaPago;
        private DTODireccion[] direcciones;
        private DTOClienteMarca[] marcas;              
        private DTOClasificacionCliente[] clasificaciones; 
        private Boolean usaGeoreferenciador;
        private String tratamientoDesc;
        private Long periodoContacto;
        
  private RecordSet rClasificacionCliente;
  private RecordSet rDireccionCliente;
  private RecordSet rIdentificacionCliente;
  private RecordSet rClienteMarca;
  private RecordSet rTipoSubtipoCliente;

  public Long getPeriodoContacto()
  {
    return periodoContacto;
  }

  public void setPeriodoContacto(Long newPeriodoContacto)
  {
    periodoContacto = newPeriodoContacto;
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

    public DTOClasificacionCliente[] getClasificaciones() {
        return clasificaciones;
    }

    public void setClasificaciones(DTOClasificacionCliente[] newClasificaciones) {
        clasificaciones = newClasificaciones;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public String getDigitoControl() {
        return digitoControl;
    }

    public void setDigitoControl(String newDigitoControl) {
        digitoControl = newDigitoControl;
    }

    public DTODireccion[] getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(DTODireccion[] newDirecciones) {
        direcciones = newDirecciones;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date newFechaIngreso) {
        fechaIngreso = newFechaIngreso;
    }

    public Long getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Long newFormaPago) {
        formaPago = newFormaPago;
    }

    public DTOIdentificacion[] getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(DTOIdentificacion[] newIdentificaciones) {
        identificaciones = newIdentificaciones;
    }

    public DTOClienteMarca[] getMarcas() {
        return marcas;
    }

    public void setMarcas(DTOClienteMarca[] newMarcas) {
        marcas = newMarcas;
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

    public DTOTipoSubtipoCliente[] getTiposSubtipos() {
        return tiposSubtipos;
    }

    public void setTiposSubtipos(DTOTipoSubtipoCliente[] newTiposSubtipos) {
        tiposSubtipos = newTiposSubtipos;
    }

    public Boolean getUsaGeoreferenciador() {
        return usaGeoreferenciador;
    }

    public void setUsaGeoreferenciador(Boolean newUsaGeoreferenciador) {
        usaGeoreferenciador = newUsaGeoreferenciador;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String newSexo) {
        sexo = newSexo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String newTratamiento) {
        tratamiento = newTratamiento;
    }

    public String getTratamientoDesc() {
        return tratamientoDesc;
    }

    public void setTratamientoDesc(String newTratamientoDesc) {
        tratamientoDesc = newTratamientoDesc;
    }

  public RecordSet getRClasificacionCliente() {
    return rClasificacionCliente;
  }

  public void setRClasificacionCliente(RecordSet rClasificacionCliente) {
    this.rClasificacionCliente = rClasificacionCliente;
  }

  public RecordSet getRDireccionCliente() {
    return rDireccionCliente;
  }

  public RecordSet getRIdentificacionCliente() {
    return rIdentificacionCliente;
  }

  public void setRIdentificacionCliente(RecordSet rIdentificacionCliente) {
    this.rIdentificacionCliente = rIdentificacionCliente;
  }

  public RecordSet getRClienteMarca() {
    return rClienteMarca;
  }

  public void setRClienteMarca(RecordSet rClienteMarca) {
    this.rClienteMarca = rClienteMarca;
  }

  public RecordSet getRTipoSubtipoCliente() {
    return rTipoSubtipoCliente;
  }

  public void setRTipoSubtipoCliente(RecordSet rTipoSubtipoCliente) {
    this.rTipoSubtipoCliente = rTipoSubtipoCliente;
  }





}