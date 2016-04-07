package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;
import java.util.ArrayList;

public class DTOGestionDeCobranza extends DTOAuditableSICC 
{
  Long oid;
  String observaciones;
  Long oidUsuarioCobranza;
  Long oidEtapaDeuda;
  Long oidMarca;
  Long oidCanal;
  Long oidPeriodo;
  Long oidSubgerenciaVentas;
  Long oidRegion;
  Long oidZona;
  Long oidSeccion;
  Long oidTerritorio;
  Long oidCliente;
  String codigoCliente;
  String nombre;
  String apellidos;
  Date fechaSeguimiento;
  String horaSeguimiento;
  Integer codCompromisoPago;
  Long oidCompromisoPago;
  Date fechaReprogramacion;
  String horaReprogramacion;
  Boolean aportaPrueba;
  String descripcionPrueba;
  Long oidAccion;
  Long numeroDocSoporte;
  Long oidTipoDocPago;
  String codigoBanco;
  String codigoSucursal;
  Long oidSucursal;
  String nuevaDireccion;
  String nuevoTelefono;
  Boolean pasaAdministrador;
  Boolean peticionBloqueoAdmin;
  Boolean peticionDesbloqueoAdmin;
  Boolean visadoAdministrador;
  Boolean marcaComisionCalculada;
  Long oidMotivoNoCobro;
  
  /*Atributos Agregados pero no especificados en el diseño*/
  String usuarioCobranza;
  String etapaDeuda;
  String marca;
  String canal;
  String periodo;
  String subgerenciaVentas;
  String region;
  String zona;
  String seccion;
  String territorio;
  String tipoCargo;
  String accion;
  String motivoNoCobro;
  String tipoDocPago;
  String procesoActualiza;
  private Long oidEmpresa;
  private Long oidTipoCargoAbono;
  private Long oidMedioPago;
  private ArrayList compromisosDePago;
  private Long oidTipoBloqueo;
  private String motivoBloqueo;
  private String observacionesBloqueo;
  private String observacionesDesbloqueo;
  private Boolean indAnular;

  public DTOGestionDeCobranza()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }

  public Long getOidUsuarioCobranza()
  {
    return oidUsuarioCobranza;
  }

  public void setOidUsuarioCobranza(Long oidUsuarioCobranza)
  {
    this.oidUsuarioCobranza = oidUsuarioCobranza;
  }

  public Long getOidEtapaDeuda()
  {
    return oidEtapaDeuda;
  }

  public void setOidEtapaDeuda(Long oidEtapaDeuda)
  {
    this.oidEtapaDeuda = oidEtapaDeuda;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
  }

  public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }

  public String getApellidos()
  {
    return apellidos;
  }

  public void setApellidos(String apellidos)
  {
    this.apellidos = apellidos;
  }

  public Date getFechaSeguimiento()
  {
    return fechaSeguimiento;
  }

  public void setFechaSeguimiento(Date fechaSeguimiento)
  {
    this.fechaSeguimiento = fechaSeguimiento;
  }

  public String getHoraSeguimiento()
  {
    return horaSeguimiento;
  }

  public void setHoraSeguimiento(String horaSeguimiento)
  {
    this.horaSeguimiento = horaSeguimiento;
  }

  public Integer getCodCompromisoPago()
  {
    return codCompromisoPago;
  }

  public void setCodCompromisoPago(Integer codCompromisoPago)
  {
    this.codCompromisoPago = codCompromisoPago;
  }

  public Long getOidCompromisoPago()
  {
    return oidCompromisoPago;
  }

  public void setOidCompromisoPago(Long oidCompromisoPago)
  {
    this.oidCompromisoPago = oidCompromisoPago;
  }

  public Date getFechaReprogramacion()
  {
    return fechaReprogramacion;
  }

  public void setFechaReprogramacion(Date fechaReprogramacion)
  {
    this.fechaReprogramacion = fechaReprogramacion;
  }

  public String getHoraReprogramacion()
  {
    return horaReprogramacion;
  }

  public void setHoraReprogramacion(String horaReprogramacion)
  {
    this.horaReprogramacion = horaReprogramacion;
  }

  public Boolean getAportaPrueba()
  {
    return aportaPrueba;
  }

  public void setAportaPrueba(Boolean aportaPrueba)
  {
    this.aportaPrueba = aportaPrueba;
  }

  public String getDescripcionPrueba()
  {
    return descripcionPrueba;
  }

  public void setDescripcionPrueba(String descripcionPrueba)
  {
    this.descripcionPrueba = descripcionPrueba;
  }

  public Long getOidAccion()
  {
    return oidAccion;
  }

  public void setOidAccion(Long oidAccion)
  {
    this.oidAccion = oidAccion;
  }

  public Long getNumeroDocSoporte()
  {
    return numeroDocSoporte;
  }

  public void setNumeroDocSoporte(Long numeroDocSoporte)
  {
    this.numeroDocSoporte = numeroDocSoporte;
  }

  public Long getOidTipoDocPago()
  {
    return oidTipoDocPago;
  }

  public void setOidTipoDocPago(Long oidTipoDocPago)
  {
    this.oidTipoDocPago = oidTipoDocPago;
  }

  public String getCodigoBanco()
  {
    return codigoBanco;
  }

  public void setCodigoBanco(String codigoBanco)
  {
    this.codigoBanco = codigoBanco;
  }

  public String getCodigoSucursal()
  {
    return codigoSucursal;
  }

  public void setCodigoSucursal(String codigoSucursal)
  {
    this.codigoSucursal = codigoSucursal;
  }

  public Long getOidSucursal()
  {
    return oidSucursal;
  }

  public void setOidSucursal(Long oidSucursal)
  {
    this.oidSucursal = oidSucursal;
  }

  public String getNuevaDireccion()
  {
    return nuevaDireccion;
  }

  public void setNuevaDireccion(String nuevaDireccion)
  {
    this.nuevaDireccion = nuevaDireccion;
  }

  public String getNuevoTelefono()
  {
    return nuevoTelefono;
  }

  public void setNuevoTelefono(String nuevoTelefono)
  {
    this.nuevoTelefono = nuevoTelefono;
  }

  public Boolean getPasaAdministrador()
  {
    return pasaAdministrador;
  }

  public void setPasaAdministrador(Boolean pasaAdministrador)
  {
    this.pasaAdministrador = pasaAdministrador;
  }

  public Boolean getPeticionBloqueoAdmin()
  {
    return peticionBloqueoAdmin;
  }

  public void setPeticionBloqueoAdmin(Boolean peticionBloqueoAdmin)
  {
    this.peticionBloqueoAdmin = peticionBloqueoAdmin;
  }

  public Boolean getPeticionDesbloqueoAdmin()
  {
    return peticionDesbloqueoAdmin;
  }

  public void setPeticionDesbloqueoAdmin(Boolean peticionDesbloqueoAdmin)
  {
    this.peticionDesbloqueoAdmin = peticionDesbloqueoAdmin;
  }

  public Boolean getVisadoAdministrador()
  {
    return visadoAdministrador;
  }

  public void setVisadoAdministrador(Boolean visadoAdministrador)
  {
    this.visadoAdministrador = visadoAdministrador;
  }

  public Boolean getMarcaComisionCalculada()
  {
    return marcaComisionCalculada;
  }

  public void setMarcaComisionCalculada(Boolean marcaComisionCalculada)
  {
    this.marcaComisionCalculada = marcaComisionCalculada;
  }

  public Long getOidMotivoNoCobro()
  {
    return oidMotivoNoCobro;
  }

  public void setOidMotivoNoCobro(Long oidMotivoNoCobro)
  {
    this.oidMotivoNoCobro = oidMotivoNoCobro;
  }
  
  
  
  
  /*Método de atributos fuera de diseño*/
    public String getUsuarioCobranza()
    {
        return usuarioCobranza;
    }
    
    public void setUsuarioCobranza(String sUsuarioCobranza)
    {
        this.usuarioCobranza = sUsuarioCobranza;
    }
    
    public String getEtapaDeuda()
    {
        return etapaDeuda;
    }
    
    public void setEtapaDeuda(String sEtapaDeuda)
    {
        this.etapaDeuda = sEtapaDeuda;
    }
    
    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String sMarca)
    {
        this.marca = sMarca;
    }
    
    public String getCanal()
    {
        return canal;
    }
    
    public void setCanal(String sCanal)
    {
        this.canal = sCanal;
    }
    
    public String getPeriodo()
    {
        return periodo;
    }
    
    public void setPeriodo(String sPeriodo)
    {
        this.periodo = sPeriodo;
    }
    
    public String getSubgerenciaVentas()
    {
        return subgerenciaVentas;
    }

    public void setSubgerenciaVentas(String sSubgerenciaVentas)
    {
        this.subgerenciaVentas = sSubgerenciaVentas;
    }
    
    public String getRegion()
    {
        return region;
    }
    
    public void setRegion(String sRegion)
    {
        this.region = sRegion;
    }
    
    public String getZona()
    {
        return zona;
    }
    
    public void setZona(String sZona)
    {
        this.zona = sZona;
    }

    public String getSeccion()
    {
        return seccion;
    }
    
    public void setSeccion(String sSeccion)
    {
        this.seccion = sSeccion;
    }
    
    public String getTerritorio()
    {
        return territorio;
    }
    
    public void setTerritorio(String sTerritorio)
    {
        this.territorio = sTerritorio;
    }
  
    public String getTipoCargo()
    {
        return tipoCargo;
    }

    public void setTipoCargo(String sTipoCargo)
    {
        this.tipoCargo = sTipoCargo;
    }
    
    public String getAccion()
    {
        return accion;
    }
    
    public void setAccion(String sAccion)
    {
        this.accion = sAccion;
    }
    
    public String getMotivoNoCobro()
    {
        return motivoNoCobro;
    }
    
    public void setMotivoNoCobro(String sMotivoNoCobro)
    {
        this.motivoNoCobro = sMotivoNoCobro;
    }
    
    public String getTipoDocPago()
    {
    return tipoDocPago;
    }
    
    public void setTipoDocPago(String sTipoDocPago)
    {
        this.tipoDocPago = sTipoDocPago;
    }

  public String getProcesoActualiza()
  {
    return procesoActualiza;
  }

  public void setProcesoActualiza(String procesoActualiza)
  {
    this.procesoActualiza = procesoActualiza;
  }

  public Long getOidEmpresa()
  {
    return oidEmpresa;
  }

  public void setOidEmpresa(Long oidEmpresa)
  {
    this.oidEmpresa = oidEmpresa;
  }

  public Long getOidTipoCargoAbono()
  {
    return oidTipoCargoAbono;
  }

  public void setOidTipoCargoAbono(Long oidTipoCargoAbono)
  {
    this.oidTipoCargoAbono = oidTipoCargoAbono;
  }

  public Long getOidMedioPago()
  {
    return oidMedioPago;
  }

  public void setOidMedioPago(Long oidMedioPago)
  {
    this.oidMedioPago = oidMedioPago;
  }

  public ArrayList getCompromisosDePago()
  {
    return compromisosDePago;
  }

  public void setCompromisosDePago(ArrayList compromisosDePago)
  {
    this.compromisosDePago = compromisosDePago;
  }

  public Long getOidTipoBloqueo()
  {
    return oidTipoBloqueo;
  }

  public void setOidTipoBloqueo(Long oidTipoBloqueo)
  {
    this.oidTipoBloqueo = oidTipoBloqueo;
  }

  public String getMotivoBloqueo()
  {
    return motivoBloqueo;
  }

  public void setMotivoBloqueo(String motivoBloqueo)
  {
    this.motivoBloqueo = motivoBloqueo;
  }

  public String getObservacionesBloqueo()
  {
    return observacionesBloqueo;
  }

  public void setObservacionesBloqueo(String observacionesBloqueo)
  {
    this.observacionesBloqueo = observacionesBloqueo;
  }

  public String getObservacionesDesbloqueo()
  {
    return observacionesDesbloqueo;
  }

  public void setObservacionesDesbloqueo(String observacionesDesbloqueo)
  {
    this.observacionesDesbloqueo = observacionesDesbloqueo;
  }

  public Boolean getIndAnular()
  {
    return indAnular;
  }

  public void setIndAnular(Boolean indAnular)
  {
    this.indAnular = indAnular;
  }
  
}