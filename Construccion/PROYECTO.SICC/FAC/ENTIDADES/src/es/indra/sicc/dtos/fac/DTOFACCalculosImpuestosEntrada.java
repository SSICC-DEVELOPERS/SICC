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

public class DTOFACCalculosImpuestosEntrada  extends DTOBelcorp {

    public DTOFACCalculosImpuestosEntrada() {
    }

    private DTOFACCabeceraSolicitud dtoConsolidado;     
    private ArrayList listaPosiciones;     
    private Character  indicadorCalculo;    
    private Long moneda;     
    private Float tipoCambio;  //Incidencia BELC300008454     
    private Boolean indicadorImpuestosIncluidos;  //Incidencia BELC300008616
    private Float importeFleteSinImpuestosTotalLocal;     
    private Float importeFleteSinImpuestosTotalDocumento;     
	private Long indicadorImpuestoFlete; //modificado por incidencia BELC300008724,
    private String codigoTipoProgramaConcurso;
    private Float tasaImpuestoFlete;
									    //viene en SICC-DMCO-FAC-201-364-N005-2

    public DTOFACCabeceraSolicitud getDtoConsolidado() {
        return dtoConsolidado;
    }

    public void setDtoConsolidado(DTOFACCabeceraSolicitud newDtoConsolidado) {
        dtoConsolidado = newDtoConsolidado;
    }

    public Float getImporteFleteSinImpuestosTotalDocumento() {
        return importeFleteSinImpuestosTotalDocumento;
    }

    public void setImporteFleteSinImpuestosTotalDocumento(Float newImporteFleteSinImpuestosTotalDocumento) {
        importeFleteSinImpuestosTotalDocumento = newImporteFleteSinImpuestosTotalDocumento;
    }

    public Float getImporteFleteSinImpuestosTotalLocal() {
        return importeFleteSinImpuestosTotalLocal;
    }

    public void setImporteFleteSinImpuestosTotalLocal(Float newImporteFleteSinImpuestosTotalLocal) {
        importeFleteSinImpuestosTotalLocal = newImporteFleteSinImpuestosTotalLocal;
    }

    public Character getIndicadorCalculo() {
        return indicadorCalculo;
    }

    public void setIndicadorCalculo(Character newIndicadorCalculo) {
        indicadorCalculo = newIndicadorCalculo;
    }

    public Long getIndicadorImpuestoFlete() {
		return indicadorImpuestoFlete;
    }

    public void setIndicadorImpuestoFlete(Long newIndicadorImpuestoFlete) {
		indicadorImpuestoFlete = newIndicadorImpuestoFlete;
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

    public String getCodigoTipoProgramaConcurso() {
        return codigoTipoProgramaConcurso;
    }

    public void setCodigoTipoProgramaConcurso(String codigoTipoProgramaConcurso) {
        this.codigoTipoProgramaConcurso = codigoTipoProgramaConcurso;
    }

    public Float getTasaImpuestoFlete() {
        return tasaImpuestoFlete;
    }

    public void setTasaImpuestoFlete(Float tasaImpuestoFlete) {
        this.tasaImpuestoFlete = tasaImpuestoFlete;
    }
}