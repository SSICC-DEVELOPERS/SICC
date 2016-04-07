/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.fac;

import es.indra.sicc.dtos.ape.DTOListaPicadoCabeceraFacturacion;
import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;


public class DTOFACConsolidado extends DTOBelcorp {

	private DTOFACCabeceraSolicitud dtoCabecera;    
	private ArrayList listaSolicitudes;   
	private ArrayList listaPosiciones; 
	private Long IDSpool;
  private Long subaccesoUsuario;  //aniadido por incidencia 15996
  //se agrega por la incidencia 19102: Para retrasar la insercion de datos
  //despues de la llamada a insertarConsolidado
  private ArrayList datosAcumuladosImpuestos;
  private Boolean IndicadorImpuestosIncluidos;
  
  // SICC-GCC-FAC-002 - dmorello, 17/10/2006: Se agrega la percepcion
  private Float tasaImpuestoPercepcion;
    
    private Boolean indOnline;
    private Boolean indImprimirPercepcion;
    private DTOListaPicadoCabeceraFacturacion dtoCabeceraListaPicado;
    private Long oidTasaImpuestoUbigeo;
    private Float tasaImpuestoUbigeo;
    /* Agregado por Cambio FAC-001 ------ AL */
    private Boolean indicadorIVAasumido;
    private Long porcIVAasumido;
    private Long IVAasumidoEmpresa;
    private Boolean indicadorDireccionSeparada;
    /* Agregado por Cambio FAC-001 ------ AL */

    
	public DTOFACConsolidado() {
	}

	public DTOFACCabeceraSolicitud getDtoCabecera() {
		return dtoCabecera;
	}

	public void setDtoCabecera(DTOFACCabeceraSolicitud newDtoCabecera) {
		dtoCabecera = newDtoCabecera;
	}

	public ArrayList getListaPosiciones() {
		return listaPosiciones;
	}

	public void setListaPosiciones(ArrayList newListaPosiciones) {
		listaPosiciones = newListaPosiciones;
	}

	public ArrayList getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(ArrayList newListaSolicitudes) {
		listaSolicitudes = newListaSolicitudes;
	}

	public Long getIDSpool() {
		return IDSpool;
	}

	public void setIDSpool(Long newIDSpool) {
		IDSpool = newIDSpool;
	}

    public Long getSubaccesoUsuario()
    {
        return subaccesoUsuario;
    }

    public void setSubaccesoUsuario(Long subaccesoUsuario)
    {
        this.subaccesoUsuario = subaccesoUsuario;
    }
    
    public ArrayList getDatosAcumuladosImpuestos() {
        return datosAcumuladosImpuestos;
    }

    public void setDatosAcumuladosImpuestos(ArrayList datosAcumuladosImpuestos) {
        this.datosAcumuladosImpuestos = datosAcumuladosImpuestos;
    }


  public void setIndicadorImpuestosIncluidos(Boolean IndicadorImpuestosIncluidos)
  {
    this.IndicadorImpuestosIncluidos = IndicadorImpuestosIncluidos;
  }


  public Boolean getIndicadorImpuestosIncluidos()
  {
    return IndicadorImpuestosIncluidos;
  }

  public Float getTasaImpuestoPercepcion()
  {
    return tasaImpuestoPercepcion;
  }

  public void setTasaImpuestoPercepcion(Float tasaImpuestoPercepcion)
  {
    this.tasaImpuestoPercepcion = tasaImpuestoPercepcion;
  }

    public Boolean getIndOnline()
    {
        return indOnline;
    }

    public void setIndOnline(Boolean indOnline)
    {
        this.indOnline = indOnline;
    }

    public Boolean getIndImprimirPercepcion()
    {
        return indImprimirPercepcion;
    }

    public void setIndImprimirPercepcion(Boolean indImprimirPercepcion)
    {
        this.indImprimirPercepcion = indImprimirPercepcion;
    }

    public DTOListaPicadoCabeceraFacturacion getDtoCabeceraListaPicado() {
        return dtoCabeceraListaPicado;
    }

    public void setDtoCabeceraListaPicado(DTOListaPicadoCabeceraFacturacion dtoCabeceraListaPicado) {
        this.dtoCabeceraListaPicado = dtoCabeceraListaPicado;
    }

    public Long getOidTasaImpuestoUbigeo() {
        return oidTasaImpuestoUbigeo;
    }

    public void setOidTasaImpuestoUbigeo(Long oidTasaImpuestoUbigeo) {
        this.oidTasaImpuestoUbigeo = oidTasaImpuestoUbigeo;
    }

    public Float getTasaImpuestoUbigeo() {
        return tasaImpuestoUbigeo;
    }

    public void setTasaImpuestoUbigeo(Float tasaImpuestoUbigeo) {
        this.tasaImpuestoUbigeo = tasaImpuestoUbigeo;
    }
    
       public Boolean getIndicadorIVAasumido() {
        return indicadorIVAasumido;
    }

    public void setIndicadorIVAasumido(Boolean indicadorIVAasumido) {
        this.indicadorIVAasumido = indicadorIVAasumido;
    }

    public Long getPorcIVAasumido() {
        return porcIVAasumido;
    }

    public void setPorcIVAasumido(Long porcIVAasumido) {
        this.porcIVAasumido = porcIVAasumido;
    }

    public Long getIVAasumidoEmpresa() {
        return IVAasumidoEmpresa;
    }

    public void setIVAasumidoEmpresa(Long IVAasumidoEmpresa) {
        this.IVAasumidoEmpresa = IVAasumidoEmpresa;
    }

    public Boolean getIndicadorDireccionSeparada() {
        return indicadorDireccionSeparada;
    }

    public void setIndicadorDireccionSeparada(Boolean indicadorDireccionSeparada) {
        this.indicadorDireccionSeparada = indicadorDireccionSeparada;
    }
    
}