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
package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.FormateadorDeDocumentos;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;

public class FormateadorXerox implements FormateadorDeDocumentos {
    public FormateadorXerox() {
    }
    
    protected char linefeed[] = {'\n','\r'};
    protected String MSG_BLANK = new String(linefeed);
    
    public byte[] formatearDocumento (RecordSet documentos) throws MareException {
        UtilidadesLog.info("FormateadorXerox.formatearDocumento(): Entrada");

        MareMGC mgc = null;
        try {
            mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));    
        } catch (MareMiiServiceNotFoundException e) {
            String error = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            String msjError = "FormateadorXerox.formatearDocumento: No se pudo encontrar el archivo de configuración.";
            UtilidadesLog.error(msjError, e);
            throw new MareException(msjError, e, UtilidadesError.armarCodigoError(error));
        }
        String cabecera = (String)mgc.getProperty("Xerox.cabecera");
        String spool = (String)mgc.getProperty("Xerox.spool");
        String paqueteDocumentario = (String)mgc.getProperty("Xerox.paqueteDocumentario");        
        
        StringBuffer documento = new StringBuffer("");
        documento.append(cabecera+"<"+spool+">");
        documento.append(this.MSG_BLANK);
        //int documentosSinDatos = 0;
        int rowCount = documentos.getRowCount();
        for (int i=0; i<rowCount; i++) {
            documento.append("<"+paqueteDocumentario+">");
            //String buffer = documentos.getValueAt(i, "VAL_BUFF").toString();
            String buffer = documentos.getValueAt(i, 5).toString();
            /*if (buffer.length()<1){
                documentosSinDatos++;
            }*/
            documento.append(buffer);
            documento.append("</"+paqueteDocumentario+">");
            documento.append(this.MSG_BLANK);
        }
        
        /*if (documentosSinDatos == (rowCount-1)){
            return null;
        }*/

        documento.append("</"+spool+">");

        String aux = documento.toString();
        
        UtilidadesLog.info("FormateadorXerox.formatearDocumento(): Salida");
        return aux.getBytes();
    }
    
    public byte[] formatearDocumentoColombia (RecordSet documentos) throws MareException {
        UtilidadesLog.info("FormateadorXerox.formatearDocumentoColombia(): Entrada");

        MareMGC mgc = null;
        try {
            mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));    
        } catch (MareMiiServiceNotFoundException e) {
            String error = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            String msjError = "FormateadorXerox.formatearDocumento: No se pudo encontrar el archivo de configuración.";
            UtilidadesLog.error(msjError, e);
            throw new MareException(msjError, e, UtilidadesError.armarCodigoError(error));
        }
        String cabecera = (String)mgc.getProperty("Xerox.cabecera");
        String spool = (String)mgc.getProperty("Xerox.spool");
        String paqueteDocumentario = (String)mgc.getProperty("Xerox.paqueteDocumentario");        
        
        Integer numeroSecuenciaAnterior = new Integer(1);
        StringBuffer agrupaDocumentos = new StringBuffer();
        int rowCount = documentos.getRowCount();
        ArrayList documentosAgrupados = new ArrayList();
        for (int i=0; i<rowCount; i++) {
           Integer numeroSecuencia = UtilidadesBD.convertirAInteger(documentos.getValueAt(i, 2));           
           if (numeroSecuenciaAnterior.intValue() != numeroSecuencia.intValue()) {
                if (agrupaDocumentos.length() > 0) {
                   documentosAgrupados.add(agrupaDocumentos);                    
                   agrupaDocumentos = new StringBuffer();
                }     
                numeroSecuenciaAnterior = new Integer(numeroSecuencia.intValue());
                String conReemplazos = new String(documentos.getValueAt(i, 5).toString().replaceAll("&","&amp;"));
                agrupaDocumentos.append(conReemplazos.toString());
           } else {
              String conReemplazos = new String(documentos.getValueAt(i, 5).toString().replaceAll("&","&amp;"));
              agrupaDocumentos.append(conReemplazos.toString());   
           }
        }
        
        if (agrupaDocumentos.length() > 0) {
            documentosAgrupados.add(agrupaDocumentos);                    
        }

        StringBuffer documento = new StringBuffer("");
        documento.append(cabecera+"<"+spool+">");
        documento.append(this.MSG_BLANK);
        
        
        int longArray = documentosAgrupados.size();
        for (int i = 0; i < longArray; i++) {            
            documento.append("<"+paqueteDocumentario+">");             
            documento.append(documentosAgrupados.get(i).toString());
            documento.append("</"+paqueteDocumentario+">");
            documento.append(this.MSG_BLANK);
        }
        documento.append("</"+spool+">");
        String aux = documento.toString();
        
        UtilidadesLog.info("FormateadorXerox.formatearDocumentoColombia(): Salida");
        return aux.getBytes();
    }

}