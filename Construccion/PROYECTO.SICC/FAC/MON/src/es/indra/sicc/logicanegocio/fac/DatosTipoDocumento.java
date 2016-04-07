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

package es.indra.sicc.logicanegocio.fac;

import java.util.ArrayList;
import java.io.Serializable;

//Incidencia 9487
public class DatosTipoDocumento implements Serializable {

	private String codigoFormulario;
	private Integer numeroLineasPorPagina;
	//private String tipoNumeracionDocumento; eliminado por la incidencia 8964
    private Boolean esNumeracionOficial;
	private ArrayList listaPosiciones;
	private String serieDocumentoLegal; 
	private Integer limiteNumeroDocumentoLegal; 
	private Integer ejercicioDocumentoInterno;
	private Integer numeroDocumentoInterno;
	private Integer numeroDocumentoLegal;
	private Long oidFormulario;
    private Boolean monoPagina; //añadido por incidencia 17248
    private Long oidTipoDocumento;
    private Long oidTipoConcursoPrograma;
    private String codigoTipoConcursoPrograma;
    private String codigoTipoDocumento;
    private String observaciones; // Agregado por SICC20070410 - Rafael Romero - 11/09/2007
    
    // Cambio 20090908 - dmorello, 06/07/2009
    private Long oidDocumentoLegalReferencia;

    
	
	public DatosTipoDocumento() {
	}

	public String getCodigoFormulario() {
		return codigoFormulario;
	}

	public void setCodigoFormulario(String newCodigoFormulario) {
		codigoFormulario = newCodigoFormulario;
	}

	public Integer getEjercicioDocumentoInterno() {
		return ejercicioDocumentoInterno;
	}

	public void setEjercicioDocumentoInterno(Integer newEjercicioDocumentoInterno) {
		ejercicioDocumentoInterno = newEjercicioDocumentoInterno;
	}

	public Integer getLimiteNumeroDocumentoLegal() {
		return limiteNumeroDocumentoLegal;
	}

	public void setLimiteNumeroDocumentoLegal(Integer newLimiteNumeroDocumentoLegal) {
		limiteNumeroDocumentoLegal = newLimiteNumeroDocumentoLegal;
	}

	public ArrayList getListaPosiciones() {
		return listaPosiciones;
	}

	public void setListaPosiciones(ArrayList newListaPosiciones) {
		listaPosiciones = newListaPosiciones;
	}

	public Integer getNumeroDocumentoInterno() {
		return numeroDocumentoInterno;
	}

	public void setNumeroDocumentoInterno(Integer newNumeroDocumentoInterno) {
		numeroDocumentoInterno = newNumeroDocumentoInterno;
	}

	public Integer getNumeroDocumentoLegal() {
		return numeroDocumentoLegal;
	}

	public void setNumeroDocumentoLegal(Integer newNumeroDocumentoLegal) {
		numeroDocumentoLegal = newNumeroDocumentoLegal;
	}

	public Long getOidFormulario() {
		return oidFormulario;
	}

	public void setOidFormulario(Long newOidFormulario) {
		oidFormulario = newOidFormulario;
	}

	public String getSerieDocumentoLegal() {
		return serieDocumentoLegal;
	}

	public void setSerieDocumentoLegal(String newSerieDocumentoLegal) {
		serieDocumentoLegal = newSerieDocumentoLegal;
	}



	public Integer getNumeroLineasPorPagina() {
		return numeroLineasPorPagina;
	}

	public void setNumeroLineasPorPagina(Integer newNumeroLineasPorPagina) {
		numeroLineasPorPagina = newNumeroLineasPorPagina;
	}

    public Boolean getEsNumeracionOficial() {
        return esNumeracionOficial;
    }

    public void setEsNumeracionOficial(Boolean newEsNumeracionOficial) {
        esNumeracionOficial = newEsNumeracionOficial;
    }
    // *********** añadido por incidencia 17248
    public Boolean getMonoPagina()
    {
        return monoPagina;
    }

    public void setMonoPagina(Boolean monoPagina)
    {
        this.monoPagina = monoPagina;
    }

    public Long getOidTipoDocumento() {
        return oidTipoDocumento;
    }

    public void setOidTipoDocumento(Long oidTipoDocumento) {
        this.oidTipoDocumento = oidTipoDocumento;
    }

    public Long getOidTipoConcursoPrograma() {
        return oidTipoConcursoPrograma;
    }

    public void setOidTipoConcursoPrograma(Long oidTipoConcursoPrograma) {
        this.oidTipoConcursoPrograma = oidTipoConcursoPrograma;
    }

    public String getCodigoTipoConcursoPrograma() {
        return codigoTipoConcursoPrograma;
    }

    public void setCodigoTipoConcursoPrograma(String codigoTipoConcursoPrograma) {
        this.codigoTipoConcursoPrograma = codigoTipoConcursoPrograma;
    }

    public String getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(String codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public String getObservaciones() {
        return observaciones;
    }


	// ****************************

    public void setOidDocumentoLegalReferencia(Long oidDocumentoLegalReferencia) {
        this.oidDocumentoLegalReferencia = oidDocumentoLegalReferencia;
    }

    public Long getOidDocumentoLegalReferencia() {
        return oidDocumentoLegalReferencia;
    }
}
