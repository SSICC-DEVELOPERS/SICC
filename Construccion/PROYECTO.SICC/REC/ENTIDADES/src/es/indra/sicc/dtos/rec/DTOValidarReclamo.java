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
package es.indra.sicc.dtos.rec;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.util.Date;

public class DTOValidarReclamo extends DTOBelcorp
{
    private Long oidReclamo;
    private String codigoPais;
    private Long numeroReclamo;
    private Long oidTipoIngreso;
    private String codigoUsuario;
    private Date fechaIngreso;
    private Long oidDocumentoReferencia;
    private Long oidMarca;   
    private Long oidCanal;
    private String codigoCanal;
    private Long oidAcceso;
    private String codigoAcceso;
    private Long oidSubacceso;
    private String codigoSubacceso;
    private Date fechaEmision;
    private Long oidCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoCliente;
    private Long oidTerritorioAdm;
    private Long oidPeriodoSolicitud;
    private Long oidTipoDocumentoLegal;
    private String codigoCliente;
    private Long numeroDocumentoRefrencia;
    private Long oidPeriodoReclamo;
    private Long oidResultadoChequeo;
    private boolean error;
    private ArrayList operaciones;
    private Long oidConcursoParametros;
    private Long estado;// Añadido por la BELC300014866
    private Long numeroAtencion; // Añadido por la BELC300014954
    private Long oidPosicionReferencia;
  private String numeroRecojo;
    
    public DTOValidarReclamo()
    {
    }

    public String getCodigoAcceso()
    {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso)
    {
        this.codigoAcceso = codigoAcceso;
    }

    public String getCodigoCanal()
    {
        return codigoCanal;
    }

    public void setCodigoCanal(String codigoCanal)
    {
        this.codigoCanal = codigoCanal;
    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoPais()
    {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais)
    {
        this.codigoPais = codigoPais;
    }

    public String getCodigoSubacceso()
    {
        return codigoSubacceso;
    }

    public void setCodigoSubacceso(String codigoSubacceso)
    {
        this.codigoSubacceso = codigoSubacceso;
    }

    public String getCodigoUsuario()
    {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario)
    {
        this.codigoUsuario = codigoUsuario;
    }

    public boolean getError()
    {
        return error;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public Date getFechaEmision()
    {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision)
    {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getNumeroDocumentoRefrencia()
    {
        return numeroDocumentoRefrencia;
    }

    public void setNumeroDocumentoRefrencia(Long numeroDocumentoRefrencia)
    {
        this.numeroDocumentoRefrencia = numeroDocumentoRefrencia;
    }

    public Long getNumeroReclamo()
    {
        return numeroReclamo;
    }

    public void setNumeroReclamo(Long numeroReclamo)
    {
        this.numeroReclamo = numeroReclamo;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
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

    public Long getOidConcursoParametros()
    {
        return oidConcursoParametros;
    }

    public void setOidConcursoParametros(Long oidConcursoParametros)
    {
        this.oidConcursoParametros = oidConcursoParametros;
    }

    public Long getOidDocumentoReferencia()
    {
        return oidDocumentoReferencia;
    }

    public void setOidDocumentoReferencia(Long oidDocumentoReferencia)
    {
        this.oidDocumentoReferencia = oidDocumentoReferencia;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidPeriodoReclamo()
    {
        return oidPeriodoReclamo;
    }

    public void setOidPeriodoReclamo(Long oidPeriodoReclamo)
    {
        this.oidPeriodoReclamo = oidPeriodoReclamo;
    }

    public Long getOidPeriodoSolicitud()
    {
        return oidPeriodoSolicitud;
    }

    public void setOidPeriodoSolicitud(Long oidPeriodoSolicitud)
    {
        this.oidPeriodoSolicitud = oidPeriodoSolicitud;
    }

    public Long getOidReclamo()
    {
        return oidReclamo;
    }

    public void setOidReclamo(Long oidReclamo)
    {
        this.oidReclamo = oidReclamo;
    }

    public Long getOidResultadoChequeo()
    {
        return oidResultadoChequeo;
    }

    public void setOidResultadoChequeo(Long oidResultadoChequeo)
    {
        this.oidResultadoChequeo = oidResultadoChequeo;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long oidSubacceso)
    {
        this.oidSubacceso = oidSubacceso;
    }

    public Long getOidSubtipoCliente()
    {
        return oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long oidSubtipoCliente)
    {
        this.oidSubtipoCliente = oidSubtipoCliente;
    }

    public Long getOidTerritorioAdm()
    {
        return oidTerritorioAdm;
    }

    public void setOidTerritorioAdm(Long oidTerritorioAdm)
    {
        this.oidTerritorioAdm = oidTerritorioAdm;
    }

    public Long getOidTipoCliente()
    {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente)
    {
        this.oidTipoCliente = oidTipoCliente;
    }

    public Long getOidTipoDocumentoLegal()
    {
        return oidTipoDocumentoLegal;
    }

    public void setOidTipoDocumentoLegal(Long oidTipoDocumentoLegal)
    {
        this.oidTipoDocumentoLegal = oidTipoDocumentoLegal;
    }

    public Long getOidTipoIngreso()
    {
        return oidTipoIngreso;
    }

    public void setOidTipoIngreso(Long oidTipoIngreso)
    {
        this.oidTipoIngreso = oidTipoIngreso;
    }

    public ArrayList getOperaciones()
    {
        return operaciones;
    }

    public void setOperaciones(ArrayList operaciones)
    {
        this.operaciones = operaciones;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

   public Long getNumeroAtencion() {
      return numeroAtencion;
   }

   public void setNumeroAtencion(Long numeroAtencion) {
      this.numeroAtencion = numeroAtencion;
   }

    public Long getOidPosicionReferencia() {
        return oidPosicionReferencia;
    }

    public void setOidPosicionReferencia(Long oidPosicionReferencia) {
        this.oidPosicionReferencia = oidPosicionReferencia;
    }

  public String getNumeroRecojo()
  {
    return numeroRecojo;
  }

  public void setNumeroRecojo(String numeroRecojo)
  {
    this.numeroRecojo = numeroRecojo;
  }
}