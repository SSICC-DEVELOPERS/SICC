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
package es.indra.sicc.cmn.negocio.print;

import es.indra.sicc.cmn.negocio.print.ImpressionParameters;
import es.indra.sicc.cmn.negocio.print.PrinterSender;

import java.io.Serializable;

//Incidencias 11180 y BELC300011627 
public class PrinterConfiguration implements Serializable {
    private Long bufferSize;
    private boolean secuenceFlag;
	// Eliminado por la BELC300011627 
    // private Long documentType;
    private PrinterSender printType;
    private ImpressionParameters impressionParameters;
    private Long idImpresoraVirtual;
     //*****************MODIFICADO POR BELC300018607 26/05/2005************************
    private Long tecnologiaImpresion;
    private Long idQueue;

    public PrinterConfiguration() {
    }

    public ImpressionParameters getImpressionParameters() {
        return this.impressionParameters;
    }

    public void setImpressionParameters(
        ImpressionParameters newImpressionParameters) {
        this.impressionParameters = newImpressionParameters;
    }

    public PrinterSender getPrintType() {
        return this.printType;
    }

    public void setPrintType(PrinterSender newPrintType) {
        this.printType = newPrintType;
    }

    public Long getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(Long newBufferSize) {
        bufferSize = newBufferSize;
    }

    public boolean isSecuenceFlag() {
        return secuenceFlag;
    }

    public void setSecuenceFlag(boolean newSecuenceFlag) {
        secuenceFlag = newSecuenceFlag;
    }

	// Eliminado por la BELC300011627 
//    public Long getDocumentType() {
//        return documentType;
//    }
//    public void setDocumentType(Long newDocumentType) {
//        documentType = newDocumentType;
//    }

    public Long getIdImpresoraVirtual() {
        return idImpresoraVirtual;
    }

    public void setIdImpresoraVirtual(Long newIdImpresoraVirtual) {
        idImpresoraVirtual = newIdImpresoraVirtual;
    }

    public Long getTecnologiaImpresion()
    {
        return tecnologiaImpresion;
    }

    public void setTecnologiaImpresion(Long tecnologiaImpresion)
    {
        this.tecnologiaImpresion = tecnologiaImpresion;
    }

    public Long getIdQueue()
    {
        return idQueue;
    }

    public void setIdQueue(Long idQueue)
    {
        this.idQueue = idQueue;
    }
}
