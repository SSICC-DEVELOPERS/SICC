package es.indra.sicc.util;

/*
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.util.UtilidadesLog;

public class RecuperadorIdiomaDefectoServidor 
{
    /**
     * @author Dante Castiglione
     * 2005/07/07
     */
    public static Long getIdiomaDefectoServidor() throws MareException {
        UtilidadesLog.info("RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(): Entrada");
        String idiomaPorDefecto;
        String textoError = "No se puedo recuperar el idioma por defecto. ";
        try {
            MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            idiomaPorDefecto = (String) mgc.getProperty("application.idiomaPorDefecto");        		
            UtilidadesLog.debug("gdm --> idiomaPorDefecto = " + idiomaPorDefecto);

        } catch (MareMiiServiceNotFoundException snfe) {
            UtilidadesLog.debug(textoError + snfe.getMessage());
            UtilidadesLog.error(snfe);
            throw new MareException(textoError + snfe.getMessage());
        }
        UtilidadesLog.info("RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(): Salida");
        return new Long(Long.parseLong(idiomaPorDefecto));
    }
    
}

