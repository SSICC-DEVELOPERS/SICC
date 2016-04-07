/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.cal;

//import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOCliente extends DTOSiccPaginacion { //Incidencia 12333
  public DTOCliente() {
    super();
  }
  
  private String codCliente;
  private Long oidCliente;     
  private Long oidTipoCliente;  
  private String codigoTipoCliente;  
  private Long oidSubtipoCliente;     
  private Long oidTipoDocumento;  
  private String codigoTipoDocumento;   
  private String docIdentidad;   
  private String apellido1;     
  private String apellido2;   
  private String apellidoCasada;
  private String nombre1;     
  private String nombre2;     
  private Long oidMarca;    
  private Long oidCanal;   
  private Long oidSubgerenciaVentas;   
  private Long oidRegion;   
  private Long oidZona;     
  private String desEstatus;     
  private String telefono;     
  private String email;     
  private String desTratamiento;   
  private String desTipoDocumento;   
  private Date fechaProximoContacto;     
  
  //se saca por COL-blo-01 (SCS-23/10/2007)
  //private String desBloqueoAdministrativo;     
  //private String desBloqueoFinanciero;   
  
  private Date fechaIngreso;     
  private String desPeriodoIngreso;   
  private Long montoLineaCredito;  
  private String desNivelRiesgo;   
  private Boolean indContacto;   
  private Long oidMotivoContacto;
  private Date fechaNacimiento;
  //Gacevedo(22/06/2007): Se implanta el pedido de cambio CAL-002
  private Date fechaUltimoPedido;
  private String descUltimaCampaniaPedido;
  private Long numeroUltimaBoletaDespacho;
  private Double montoUltimaBoletaDespacho;
  private Double saldoUnicoCCC;
  private String tipoDireccion;
  private String tipoVia;
  private String nombreVia;
  private String numeroPrincipal;
  private String observacionesDireccion;
  private String descUniGeo;
  private String Bloqueo;
  // cambio SiCC20080789
  private String indicadorActico;
  

  public String getCodCliente() {
    return this.codCliente;
  }

  public void setCodCliente(String newCodCliente) {
    this.codCliente = newCodCliente;
  }

  public String getApellido1()
  {
    return apellido1;
  }

  public void setApellido1(String apellido1)
  {
    this.apellido1 = apellido1;
  }

  public String getApellido2()
  {
    return apellido2;
  }

  public void setApellido2(String apellido2)
  {
    this.apellido2 = apellido2;
  }

  public String getApellidoCasada()
  {
    return apellidoCasada;
  }

  public void setApellidoCasada(String apellidoCasada)
  {
    this.apellidoCasada = apellidoCasada;
  }

  public String getCodigoTipoCliente()
  {
    return codigoTipoCliente;
  }

  public void setCodigoTipoCliente(String codigoTipoCliente)
  {
    this.codigoTipoCliente = codigoTipoCliente;
  }

  public String getCodigoTipoDocumento()
  {
    return codigoTipoDocumento;
  }

  public void setCodigoTipoDocumento(String codigoTipoDocumento)
  {
    this.codigoTipoDocumento = codigoTipoDocumento;
  }

  /*
  public String getDesBloqueoAdministrativo()
  {
    return desBloqueoAdministrativo;
  }

  public void setDesBloqueoAdministrativo(String desBloqueoAdministrativo)
  {
    this.desBloqueoAdministrativo = desBloqueoAdministrativo;
  }

  public String getDesBloqueoFinanciero()
  {
    return desBloqueoFinanciero;
  }

  public void setDesBloqueoFinanciero(String desBloqueoFinanciero)
  {
    this.desBloqueoFinanciero = desBloqueoFinanciero;
  }*/

  public String getDesEstatus()
  {
    return desEstatus;
  }

  public void setDesEstatus(String desEstatus)
  {
    this.desEstatus = desEstatus;
  }

  public String getDesNivelRiesgo()
  {
    return desNivelRiesgo;
  }

  public void setDesNivelRiesgo(String desNivelRiesgo)
  {
    this.desNivelRiesgo = desNivelRiesgo;
  }

  public String getDesPeriodoIngreso()
  {
    return desPeriodoIngreso;
  }

  public void setDesPeriodoIngreso(String desPeriodoIngreso)
  {
    this.desPeriodoIngreso = desPeriodoIngreso;
  }

  public String getDesTipoDocumento()
  {
    return desTipoDocumento;
  }

  public void setDesTipoDocumento(String desTipoDocumento)
  {
    this.desTipoDocumento = desTipoDocumento;
  }

  public String getDesTratamiento()
  {
    return desTratamiento;
  }

  public void setDesTratamiento(String desTratamiento)
  {
    this.desTratamiento = desTratamiento;
  }

  public String getDocIdentidad()
  {
    return docIdentidad;
  }

  public void setDocIdentidad(String docIdentidad)
  {
    this.docIdentidad = docIdentidad;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public Date getFechaIngreso()
  {
    return fechaIngreso;
  }

  public void setFechaIngreso(Date fechaIngreso)
  {
    this.fechaIngreso = fechaIngreso;
  }

  public Date getFechaProximoContacto()
  {
    return fechaProximoContacto;
  }

  public void setFechaProximoContacto(Date fechaProximoContacto)
  {
    this.fechaProximoContacto = fechaProximoContacto;
  }

  public Boolean getIndContacto()
  {
    return indContacto;
  }

  public void setIndContacto(Boolean indContacto)
  {
    this.indContacto = indContacto;
  }

  public Long getMontoLineaCredito()
  {
    return montoLineaCredito;
  }

  public void setMontoLineaCredito(Long montoLineaCredito)
  {
    this.montoLineaCredito = montoLineaCredito;
  }

  public String getNombre1()
  {
    return nombre1;
  }

  public void setNombre1(String nombre1)
  {
    this.nombre1 = nombre1;
  }

  public String getNombre2()
  {
    return nombre2;
  }

  public void setNombre2(String nombre2)
  {
    this.nombre2 = nombre2;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidMotivoContacto()
  {
    return oidMotivoContacto;
  }

  public void setOidMotivoContacto(Long oidMotivoContacto)
  {
    this.oidMotivoContacto = oidMotivoContacto;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
  }

  public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }

  public Long getOidSubtipoCliente()
  {
    return oidSubtipoCliente;
  }

  public void setOidSubtipoCliente(Long oidSubtipoCliente)
  {
    this.oidSubtipoCliente = oidSubtipoCliente;
  }

  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long oidTipoCliente)
  {
    this.oidTipoCliente = oidTipoCliente;
  }

  public Long getOidTipoDocumento()
  {
    return oidTipoDocumento;
  }

  public void setOidTipoDocumento(Long oidTipoDocumento)
  {
    this.oidTipoDocumento = oidTipoDocumento;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public String getTelefono()
  {
    return telefono;
  }

  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }


    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaUltimoPedido(Date fechaUltimoPedido) {
        this.fechaUltimoPedido = fechaUltimoPedido;
    }


    public Date getFechaUltimoPedido() {
        return fechaUltimoPedido;
    }


    public void setDescUltimaCampaniaPedido(String descUltimaCampaniaPedido) {
        this.descUltimaCampaniaPedido = descUltimaCampaniaPedido;
    }


    public String getDescUltimaCampaniaPedido() {
        return descUltimaCampaniaPedido;
    }


    public void setNumeroUltimaBoletaDespacho(Long numeroUltimaBoletaDespacho) {
        this.numeroUltimaBoletaDespacho = numeroUltimaBoletaDespacho;
    }


    public Long getNumeroUltimaBoletaDespacho() {
        return numeroUltimaBoletaDespacho;
    }


    public void setMontoUltimaBoletaDespacho(Double montoUltimaBoletaDespacho) {
        this.montoUltimaBoletaDespacho = montoUltimaBoletaDespacho;
    }


    public Double getMontoUltimaBoletaDespacho() {
        return montoUltimaBoletaDespacho;
    }


    public void setSaldoUnicoCCC(Double saldoUnicoCCC) {
        this.saldoUnicoCCC = saldoUnicoCCC;
    }


    public Double getSaldoUnicoCCC() {
        return saldoUnicoCCC;
    }


    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }


    public String getTipoDireccion() {
        return tipoDireccion;
    }


    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }


    public String getTipoVia() {
        return tipoVia;
    }


    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }


    public String getNombreVia() {
        return nombreVia;
    }


    public void setNumeroPrincipal(String numeroPrincipal) {
        this.numeroPrincipal = numeroPrincipal;
    }


    public String getNumeroPrincipal() {
        return numeroPrincipal;
    }


    public void setObservacionesDireccion(String observacionesDireccion) {
        this.observacionesDireccion = observacionesDireccion;
    }


    public String getObservacionesDireccion() {
        return observacionesDireccion;
    }


    public void setDescUniGeo(String descUniGeo) {
        this.descUniGeo = descUniGeo;
    }


    public String getDescUniGeo() {
        return descUniGeo;
    }
    
    public void setBloqueo(String Bloqueo)
    {
        this.Bloqueo = Bloqueo;
    }


    public String getBloqueo()
    {
        return Bloqueo;
    }
    public String getIndicadorActico()
     {
       return indicadorActico;
     }

     public void setIndicadorActico(String indicadorActico)
     {
       this.indicadorActico = indicadorActico;
     }

    
}