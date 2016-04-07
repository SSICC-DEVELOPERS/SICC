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

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import java.util.ArrayList;

public class DTOFACCalculosCabeceraEntrada extends DTOBelcorp {

    public DTOFACCalculosCabeceraEntrada() {
    }

    private DTOFACCabeceraSolicitud dtoConsolidado;     
    private ArrayList listaPosiciones;     
    private Character indicadorCalculo;     
    private Long moneda;     
    private Float tipoCambio;   //Incidencia BELC300008454     
    private Boolean indicadorImpuestosIncluidos; 
	
	/*** añadidos por incidencia BELC300008718:
	 *  baseImponibleDescuento3Local:Float
	 *  baseImponibleDescuento3Documento:Float
	 *	baseImponiblePrecioContableLocal:Float
     *  baseImponiblePrecioContableDocumento:Float
     *  totalBaseImponibleLocal:Float
     *  totalBaseImponibleDocumento:Float
     *  totalImpuestosLocal:Float
     *  totalImpuestosDocumento:Float
     *  totalImporteLocal:Float
     *  totalImporteDocumento:Float   	
	 ***/ 
	private Float baseImponibleDescuento3Local;
	private Float baseImponibleDescuento3Documento;
	private Float baseImponiblePrecioContableLocal;
	private Float baseImponiblePrecioContableDocumento;
	private Float totalBaseImponibleLocal;
	private Float totalBaseImponibleDocumento;
	private Float totalImpuestosLocal;
	private Float totalImpuestosDocumento;
	private Float totalImporteLocal;
	private Float totalImporteDocumento;
    private String codigoTipoProgramaConcurso;
	
	

    public DTOFACCabeceraSolicitud getDtoConsolidado() {
        return dtoConsolidado;
    }

    public void setDtoConsolidado(DTOFACCabeceraSolicitud newDtoConsolidado) {
        dtoConsolidado = newDtoConsolidado;
    }

    public Character getIndicadorCalculo() {
        return indicadorCalculo;
    }

    public void setIndicadorCalculo(Character newIndicadorCalculo) {
        indicadorCalculo = newIndicadorCalculo;
    }

    public Boolean getIndicadorImpuestosIncluidos() {
        return indicadorImpuestosIncluidos;
    }

    public void setIndicadorImpuestosIncluidos(Boolean newIndicadorImpuestosIncluidos) {
        indicadorImpuestosIncluidos = newIndicadorImpuestosIncluidos;
    }

    public ArrayList getListaPosiciones() {
        return listaPosiciones;
    }

    public void setListaPosiciones(ArrayList newListaPosiciones) {
        listaPosiciones = newListaPosiciones;
    }

    public Long getMoneda() {
        return moneda;
    }

    public void setMoneda(Long newMoneda) {
        moneda = newMoneda;
    }

    public Float getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Float newTipoCambio) {
        tipoCambio = newTipoCambio;
    }

	public Float getBaseImponibleDescuento3Local() {
		return baseImponibleDescuento3Local;
	}

	public void setBaseImponibleDescuento3Local(Float newBaseImponibleDescuento3Local) {
		baseImponibleDescuento3Local = newBaseImponibleDescuento3Local;
	}

	public Float getBaseImponibleDescuento3Documento() {
		return baseImponibleDescuento3Documento;
	}

	public void setBaseImponibleDescuento3Documento(Float newBaseImponibleDescuento3Documento) {
		baseImponibleDescuento3Documento = newBaseImponibleDescuento3Documento;
	}

	public Float getBaseImponiblePrecioContableLocal() {
		return baseImponiblePrecioContableLocal;
	}

	public void setBaseImponiblePrecioContableLocal(Float newBaseImponiblePrecioContableLocal) {
		baseImponiblePrecioContableLocal = newBaseImponiblePrecioContableLocal;
	}

	public Float getBaseImponiblePrecioContableDocumento() {
		return baseImponiblePrecioContableDocumento;
	}

	public void setBaseImponiblePrecioContableDocumento(Float newBaseImponiblePrecioContableDocumento) {
		baseImponiblePrecioContableDocumento = newBaseImponiblePrecioContableDocumento;
	}

	public Float getTotalBaseImponibleLocal() {
		return totalBaseImponibleLocal;
	}

	public void setTotalBaseImponibleLocal(Float newTotalBaseImponibleLocal) {
		totalBaseImponibleLocal = newTotalBaseImponibleLocal;
	}

	public Float getTotalBaseImponibleDocumento() {
		return totalBaseImponibleDocumento;
	}

	public void setTotalBaseImponibleDocumento(Float newTotalBaseImponibleDocumento) {
		totalBaseImponibleDocumento = newTotalBaseImponibleDocumento;
	}

	public Float getTotalImpuestosLocal() {
		return totalImpuestosLocal;
	}

	public void setTotalImpuestosLocal(Float newTotalImpuestosLocal) {
		totalImpuestosLocal = newTotalImpuestosLocal;
	}

	public Float getTotalImpuestosDocumento() {
		return totalImpuestosDocumento;
	}

	public void setTotalImpuestosDocumento(Float newTotalImpuestosDocumento) {
		totalImpuestosDocumento = newTotalImpuestosDocumento;
	}

	public Float getTotalImporteLocal() {
		return totalImporteLocal;
	}

	public void setTotalImporteLocal(Float newTotalImporteLocal) {
		totalImporteLocal = newTotalImporteLocal;
	}

	public Float getTotalImporteDocumento() {
		return totalImporteDocumento;
	}

	public void setTotalImporteDocumento(Float newTotalImporteDocumento) {
		totalImporteDocumento = newTotalImporteDocumento;
	}

    public String getCodigoTipoProgramaConcurso() {
        return codigoTipoProgramaConcurso;
    }

    public void setCodigoTipoProgramaConcurso(String codigoTipoProgramaConcurso) {
        this.codigoTipoProgramaConcurso = codigoTipoProgramaConcurso;
    }
}