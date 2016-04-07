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
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;

public class FormateadorMatricial implements FormateadorDeDocumentos {
    public FormateadorMatricial() {
    }
    
    protected char[] finDePagina = {'\f'};
    public byte[] formatearDocumento (RecordSet documentos) throws MareException {
        UtilidadesLog.info("FormateadorMatricial.formatearDocumento(): Entrada");

        StringBuffer documento = new StringBuffer("");
        
        /*
         * dmorello, 13/10/2006: Los siguientes caracteres van al inicio del archivo
         *  - ESC + 0: Seteo LPI = 8 en la impresora
         *  - ESC + P: Seteo CPI = 10 en la impresora
         *  - FF: Salto de página
         */
         
         MareMGC mgc = new MareMGC();
         mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
         String tipoCabecera = (String) mgc.getProperty("application.paisPorDefecto");
        
         if  ((tipoCabecera == null) || (tipoCabecera.equals("")) || (tipoCabecera.equals("PE"))) {
            char[] iniciales = {'\u001B', '0', '\u001B', 'P', '\f'};  
            documento.append(iniciales);                                             // Configuracion para PERU
         } else if (tipoCabecera.equals("EC")) {
            char[] iniciales = {'\u0012', '\u001B', 'C', 'B', '\u001B', 'M'};               
            documento.append(iniciales);                                            // Configuracion para ECUADOR    
         }        
        
        for (int i=0; i<documentos.getRowCount(); i++) {
            //documento.append(documentos.getValueAt(i, "VAL_BUFF"));
            documento.append(documentos.getValueAt(i, 5));
                documento.append(finDePagina);
        }

        if  ((tipoCabecera != null) || (tipoCabecera.equals("EC"))) {
            char[] finDeDocumento = {'\u001B', 'C', 'B', '\u0012'};                 // Configuracion para ECUADOR    
            documento.append(finDeDocumento);        
        }
        String aux = new String(documento.toString());
        
        UtilidadesLog.info("FormateadorMatricial.formatearDocumento(): Salida");
        return aux.getBytes();
    }    
}