/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public abstract class Serializador {

    protected String zpl;

    public byte[] componer(Properties datos) {
        StringBuffer datosSalida = new StringBuffer();
        datosSalida.append(this.zpl);
        UtilidadesLog.debug("Codigo ZPL antes de reemplazar: " + datosSalida);
        Iterator itDatos = datos.entrySet().iterator();
        while (itDatos.hasNext()) {
            Map.Entry dato = (Map.Entry)itDatos.next();
            String strReemplazar = dato.getKey().toString();
            String datoReemplazo = dato.getValue().toString();
            this.reemplazarOcurrencias(datosSalida,strReemplazar,datoReemplazo);
        }
        UtilidadesLog.debug("Codigo ZPL despues de reemplazar: " + datosSalida);
        return datosSalida.toString().getBytes();
    }
    
    private void reemplazarOcurrencias(StringBuffer sb, String original, String reemplazo) {
        int index;
        while ((index = sb.indexOf(original)) != -1) {
            sb.replace(index, index + original.length(), reemplazo);
        }
    }

}