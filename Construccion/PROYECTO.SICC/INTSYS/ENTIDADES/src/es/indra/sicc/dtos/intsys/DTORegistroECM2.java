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
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTORegistroECM2 extends DTOBelcorp
{
	private String codigoCliente;
	private String codigoPais;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String apellidoCasada;
	private String nombrePrimero;
	private String nombreSegundo;
	private Date fechaNacimiento;
	private String sexo;
	private String tipoCliente;
	private String subtipoCliente;
	private String nacionalidad;
	private String estadoCivil;
	private String numeroDocumento;
	private String tipoDocumento;
	private String tipoVia;
	private String nombreVia;
	private String numeroPrincipal;
	private String ubiGeo;
	private String codigoMarca;
	private String codigoPaisAntiguo;
	private String codigoClienteAntiguo;
	private String codigoCanalVenta;
	private String profesion;
	private String ocupacion;
	private String especialidad;
	private String centroTrabajo;
	private String cargo;
	private String nivelEstudios;
	private String centroEstudios;
	private Long numeroHijos;
	private String tipoClasificacion;
	private String clasificacion;
	private String codigoTipoComunicacion;
	private String textoMedioComunicacion;
	private String codigoTipoContacto;
	private Date fechaContacto;
	private String codigoTipoVinculo;
	private String codigoClienteVinculo;
	private Date fechaDesde;
	private Date fechaHasta;
	private String indVinculoPrincipal;
    //  Agregado por HRCS - Fecha 04/09/2007 - Cambio Sicc20070385
    private String codigoCanal;
    //  Agregado por HRCS - Fecha 13/09/2007 - Cambio Sicc20070416
    private String indCorrespondencia;
    private String indComunicacionPrincipal;
        //sb 
        private String indicadorConfirmacion;
	public DTORegistroECM2()
	{
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

	public String getApellidoPaterno()
	{
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno)
	{
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno()
	{
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno)
	{
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoCasada()
	{
		return apellidoCasada;
	}

	public void setApellidoCasada(String apellidoCasada)
	{
		this.apellidoCasada = apellidoCasada;
	}

	public String getNombrePrimero()
	{
		return nombrePrimero;
	}

	public void setNombrePrimero(String nombrePrimero)
	{
		this.nombrePrimero = nombrePrimero;
	}

	public String getNombreSegundo()
	{
		return nombreSegundo;
	}

	public void setNombreSegundo(String nombreSegundo)
	{
		this.nombreSegundo = nombreSegundo;
	}

	public Date getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getTipoCliente()
	{
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente)
	{
		this.tipoCliente = tipoCliente;
	}

	public String getSubtipoCliente()
	{
		return subtipoCliente;
	}

	public void setSubtipoCliente(String subtipoCliente)
	{
		this.subtipoCliente = subtipoCliente;
	}

	public String getNacionalidad()
	{
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}

	public String getEstadoCivil()
	{
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil)
	{
		this.estadoCivil = estadoCivil;
	}

	public String getNumeroDocumento()
	{
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento)
	{
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento()
	{
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoVia()
	{
		return tipoVia;
	}

	public void setTipoVia(String tipoVia)
	{
		this.tipoVia = tipoVia;
	}

	public String getNombreVia()
	{
		return nombreVia;
	}

	public void setNombreVia(String nombreVia)
	{
		this.nombreVia = nombreVia;
	}

	public String getNumeroPrincipal()
	{
		return numeroPrincipal;
	}

	public void setNumeroPrincipal(String numeroPrincipal)
	{
		this.numeroPrincipal = numeroPrincipal;
	}

	public String getUbiGeo()
	{
		return ubiGeo;
	}

	public void setUbiGeo(String ubiGeo)
	{
		this.ubiGeo = ubiGeo;
	}

	public String getCodigoMarca()
	{
		return codigoMarca;
	}

	public void setCodigoMarca(String codigoMarca)
	{
		this.codigoMarca = codigoMarca;
	}

	public String getCodigoPaisAntiguo()
	{
		return codigoPaisAntiguo;
	}

	public void setCodigoPaisAntiguo(String codigoPaisAntiguo)
	{
		this.codigoPaisAntiguo = codigoPaisAntiguo;
	}

	public String getCodigoClienteAntiguo()
	{
		return codigoClienteAntiguo;
	}

	public void setCodigoClienteAntiguo(String codigoClienteAntiguo)
	{
		this.codigoClienteAntiguo = codigoClienteAntiguo;
	}

	public String getCodigoCanalVenta()
	{
		return codigoCanalVenta;
	}

	public void setCodigoCanalVenta(String codigoCanalVenta)
	{
		this.codigoCanalVenta = codigoCanalVenta;
	}

	public String getProfesion()
	{
		return profesion;
	}

	public void setProfesion(String profesion)
	{
		this.profesion = profesion;
	}

	public String getOcupacion()
	{
		return ocupacion;
	}

	public void setOcupacion(String ocupacion)
	{
		this.ocupacion = ocupacion;
	}

	public String getEspecialidad()
	{
		return especialidad;
	}

	public void setEspecialidad(String especialidad)
	{
		this.especialidad = especialidad;
	}

	public String getCentroTrabajo()
	{
		return centroTrabajo;
	}

	public void setCentroTrabajo(String centroTrabajo)
	{
		this.centroTrabajo = centroTrabajo;
	}

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

	public String getNivelEstudios()
	{
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios)
	{
		this.nivelEstudios = nivelEstudios;
	}

	public String getCentroEstudios()
	{
		return centroEstudios;
	}

	public void setCentroEstudios(String centroEstudios)
	{
		this.centroEstudios = centroEstudios;
	}

	public Long getNumeroHijos()
	{
		return numeroHijos;
	}

	public void setNumeroHijos(Long numeroHijos)
	{
		this.numeroHijos = numeroHijos;
	}

	public String getTipoClasificacion()
	{
		return tipoClasificacion;
	}

	public void setTipoClasificacion(String tipoClasificacion)
	{
		this.tipoClasificacion = tipoClasificacion;
	}

	public String getClasificacion()
	{
		return clasificacion;
	}

	public void setClasificacion(String clasificacion)
	{
		this.clasificacion = clasificacion;
	}

	public String getCodigoTipoComunicacion()
	{
		return codigoTipoComunicacion;
	}

	public void setCodigoTipoComunicacion(String codigoTipoComunicacion)
	{
		this.codigoTipoComunicacion = codigoTipoComunicacion;
	}

	public String getTextoMedioComunicacion()
	{
		return textoMedioComunicacion;
	}

	public void setTextoMedioComunicacion(String textoMedioComunicacion)
	{
		this.textoMedioComunicacion = textoMedioComunicacion;
	}

	public String getCodigoTipoContacto()
	{
		return codigoTipoContacto;
	}

	public void setCodigoTipoContacto(String codigoTipoContacto)
	{
		this.codigoTipoContacto = codigoTipoContacto;
	}

	public Date getFechaContacto()
	{
		return fechaContacto;
	}

	public void setFechaContacto(Date fechaContacto)
	{
		this.fechaContacto = fechaContacto;
	}

	public String getCodigoTipoVinculo()
	{
		return codigoTipoVinculo;
	}

	public void setCodigoTipoVinculo(String codigoTipoVinculo)
	{
		this.codigoTipoVinculo = codigoTipoVinculo;
	}

	public String getCodigoClienteVinculo()
	{
		return codigoClienteVinculo;
	}

	public void setCodigoClienteVinculo(String codigoClienteVinculo)
	{
		this.codigoClienteVinculo = codigoClienteVinculo;
	}

	public Date getFechaDesde()
	{
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde)
	{
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta()
	{
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta)
	{
		this.fechaHasta = fechaHasta;
	}

	public String getIndVinculoPrincipal()
	{
		return indVinculoPrincipal;
	}

	public void setIndVinculoPrincipal(String indVinculoPrincipal)
	{
		this.indVinculoPrincipal = indVinculoPrincipal;
	}


    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
    }


    public String getCodigoCanal() {
        return codigoCanal;
    }


    public void setIndCorrespondencia(String indCorrespondencia) {
        this.indCorrespondencia = indCorrespondencia;
    }


    public String getIndCorrespondencia() {
        return indCorrespondencia;
    }


    public void setIndComunicacionPrincipal(String indComunicacionPrincipal) {
        this.indComunicacionPrincipal = indComunicacionPrincipal;
    }


    public String getIndComunicacionPrincipal() {
        return indComunicacionPrincipal;
    }

    public String getIndicadorConfirmacion() {
        return indicadorConfirmacion;
    }

    public void setIndicadorConfirmacion(String indicadorConfirmacion) {
        this.indicadorConfirmacion = indicadorConfirmacion;
    }
}