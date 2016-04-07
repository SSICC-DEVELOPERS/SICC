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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.util.UtilidadesLog;

public class FactoriaFormateadores  {
    private UtilidadesLog log = new UtilidadesLog();
    
    public FactoriaFormateadores() {
    }
    
    /**
     * Modificado por dmorello, 13/03/2007
     * Se incorpora el manejo de la tecnologia de impresion "ETIQUETAS"
     */
    public byte[] formater (Long tecnologia, RecordSet documentos) throws MareException{
        UtilidadesLog.debug("*** Metodo FactoriaFormateadores.FactoriaFormateadoresTemporal: Entrada ");
        UtilidadesLog.debug("*** tecnologia = "+tecnologia);

        byte[] documentosArray = null;
        if(tecnologia.equals(ConstantesCMN.TECNOLOGIA_LASER)) {
            FormateadorXerox xerox = new FormateadorXerox();
            documentosArray = xerox.formatearDocumento(documentos);
        } else if(tecnologia.equals(ConstantesCMN.TECNOLOGIA_MATRICIAL)) {
            FormateadorMatricial matricial = new FormateadorMatricial();
            documentosArray = matricial.formatearDocumento(documentos);
        } else if (tecnologia.equals(ConstantesCMN.TECNOLOGIA_ETIQUETAS)) {
            FormateadorEtiquetas etiquetas = new FormateadorEtiquetas();
            documentosArray = etiquetas.formatearDocumento(documentos);
        }
        
        if (documentosArray != null){
            // Log necesario para probar los documentos generados con tag xml
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("Documento generado:"+(new String(documentosArray)));
        }
                
        UtilidadesLog.debug("*** Metodo FactoriaFormateadores.FactoriaFormateadoress: Salida ");
        
        return documentosArray;
    }
    
    public byte[] formatearColombia (Long tecnologia, RecordSet documentos) throws MareException{
        UtilidadesLog.debug("*** Metodo FactoriaFormateadores.FactoriaFormateadoresTemporal: (Modelo Colombia) Entrada ");
        UtilidadesLog.debug("*** tecnologia = "+tecnologia);

        byte[] documentosArray = null;
        if(tecnologia.equals(ConstantesCMN.TECNOLOGIA_LASER)) {
            FormateadorXerox xerox = new FormateadorXerox();
            documentosArray = xerox.formatearDocumentoColombia(documentos);
        } else if(tecnologia.equals(ConstantesCMN.TECNOLOGIA_MATRICIAL)) {
            FormateadorMatricial matricial = new FormateadorMatricial();
            documentosArray = matricial.formatearDocumento(documentos);
        } else if (tecnologia.equals(ConstantesCMN.TECNOLOGIA_ETIQUETAS)) {
            FormateadorEtiquetas etiquetas = new FormateadorEtiquetas();
            documentosArray = etiquetas.formatearDocumento(documentos);
        }
        
        if (documentosArray != null){
            // Log necesario para probar los documentos generados con tag xml
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("Documento generado:"+(new String(documentosArray)));
        }
                
        UtilidadesLog.debug("*** Metodo FactoriaFormateadores.FactoriaFormateadoress: (Modelo Colombia) Salida ");
        
        return documentosArray;
    }

}