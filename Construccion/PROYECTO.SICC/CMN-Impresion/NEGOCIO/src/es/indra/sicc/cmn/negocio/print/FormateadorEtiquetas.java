/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;

public class FormateadorEtiquetas implements FormateadorDeDocumentos {

    public byte[] formatearDocumento (RecordSet documentos) throws MareException {
        UtilidadesLog.info("FormateadorEtiquetas.formatearDocumento(): Entrada");

        StringBuffer documento = new StringBuffer();
        for (int i=0; i<documentos.getRowCount(); i++) {
            documento.append(documentos.getValueAt(i, 5));
        }
        
        this.normalizarASCII(documento);
        
        UtilidadesLog.info("FormateadorEtiquetas.formatearDocumento(): Salida");
        return documento.toString().getBytes();
    }
    
    /**
     * Convierte los caracteres del StringBuffer a los correspondientes de ASCII
     * Es necesario para imprimir en las impresoras Zebra
     * @param sb StringBuffer donde se reemplazaran los caracteres en cuesti�n
     * @author dmorello
     * @since 13-03-2007
     */
    private void normalizarASCII(StringBuffer sb) {
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < CHARS_REEMPLAZO.length; j++) {
                char c = sb.charAt(i);
                if ((c > 127) && (c == CHARS_REEMPLAZO[j][0])) {
                    sb.setCharAt(i, CHARS_REEMPLAZO[j][1]);
                    j = CHARS_REEMPLAZO.length;
                }
            }
        }
    }
    
    
    
    private static final char[][] CHARS_REEMPLAZO
        = {
            {'�', 'A'}, {'�', 'E'}, {'�', 'I'}, {'�', 'O'}, {'�', 'U'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', 'u'},
            
            {'�', '�'}, {'�', '�'}, {'�', 'A'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', 'i'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', 'O'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, {'�', '�'}, {'�', '�'},
            {'�', '�'}, {'�', '�'}, 
            {'�', '�'}, {'�', 'u'}, 
            {'�', '�'}, {'�', '�'}, 
            
        };
}