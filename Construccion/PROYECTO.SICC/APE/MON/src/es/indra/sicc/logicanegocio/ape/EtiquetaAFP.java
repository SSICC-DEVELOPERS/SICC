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

import es.indra.sicc.dtos.ape.DTODatosImpresionEtiquetas;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class EtiquetaAFP extends AbstractEtiqueta {

    private static final int LONGITUD_CONSECUTIVO = 12;
    private static final int LONGITUD_CODIGO_BARRAS_AFP = 12;

    public EtiquetaAFP() {
        this.serializador = new SerializadorEtiquetaAFP();      
    }

    public byte[] componerEtiqueta(DTODatosImpresionEtiquetas dtoe) {
        UtilidadesLog.info("EtiquetaAFP.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Entrada");
        UtilidadesLog.debug("DTO recibido: " + dtoe);

        Properties datos = new Properties();
        
        String compania = (dtoe.getCompania() != null) ? dtoe.getCompania() : " ";
        datos.setProperty(SerializadorEtiquetaAFP.COMPANIA, compania.toUpperCase());
        datos.setProperty(SerializadorEtiquetaAFP.REGION, dtoe.getRegion());
        
        String zona = (dtoe.getZona() != null) ? dtoe.getZona() : " ";
        datos.setProperty(SerializadorEtiquetaAFP.ZONA, zona);
        
        // Consecutivo = ultimos N digitos del numero de consolidado
        /* BELC400000224 - dmorello, 20/03/2007: Cambia la obtencion del consecutivo */
        //int longNumEtiq = dtoe.getLongitudNumeroEtiqueta().intValue();
        //String numSolic = dtoe.getNumConsolidado().toString();
        //String consecutivo = numSolic.substring(numSolic.length() - longNumEtiq);
        //datos.setProperty(SerializadorEtiquetaAFP.CONSECUTIVO, consecutivo);
        String strConsecutivo = this.rellenarCeros(dtoe.getNroSecuencia(), LONGITUD_CONSECUTIVO);
        datos.setProperty(SerializadorEtiquetaAFP.CONSECUTIVO, strConsecutivo);
        /* Fin BELC400000224 dmorello 20/03/2007 */
        
        datos.setProperty(SerializadorEtiquetaAFP.CAMPANIA, dtoe.getCampania());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha = sdf.format(dtoe.getFecha());
        datos.setProperty(SerializadorEtiquetaAFP.FECHA, fecha);
        
        // dmorello, 14/03/2007: completo los numeros de caja con espacios en blanco
        datos.setProperty(SerializadorEtiquetaAFP.NUMERO_CAJA, this.rellenarNumeroCaja(dtoe.getNumCaja()));
        datos.setProperty(SerializadorEtiquetaAFP.NUMERO_TOTAL_CAJAS, this.rellenarNumeroCaja(dtoe.getNumeroTotalCajas()));
        
        String seccion = (dtoe.getCodigoSeccion() != null) ? dtoe.getCodigoSeccion() : " ";
        datos.setProperty(SerializadorEtiquetaAFP.SECCION, seccion);
        
        // Codigo barras: se codifica el consecutivo
        /* BELC400000224 - dmorello, 20/03/2007: Cambio la obtencion del consecutivo */
        //datos.setProperty(SerializadorEtiquetaAFP.CODIGO_BARRAS, consecutivo);
        
        // BELC400000620 - eiraola - 09/08/2007 El codigo de barra se genera con el Codigo Lista picado
        //datos.setProperty(SerializadorEtiquetaAFP.CODIGO_BARRAS, strConsecutivo);
        String codListaPicado = dtoe.getCodigoListaPicado();
        String codigoBarras = "";
        if (codListaPicado != null) {
            codigoBarras = this.rellenarCeros(new Long(codListaPicado), LONGITUD_CODIGO_BARRAS_AFP); // Rellenamos a la longitud del campo en BBDD: NUMBER(12)
        }
        datos.setProperty(SerializadorEtiquetaAFP.CODIGO_BARRAS, codigoBarras);
        
        UtilidadesLog.debug("DATOS DE LA ETIQUETA AFP:");
        UtilidadesLog.debug("Compañia:      " + datos.getProperty(SerializadorEtiquetaAFP.COMPANIA));
        UtilidadesLog.debug("Region:        " + datos.getProperty(SerializadorEtiquetaAFP.REGION));
        UtilidadesLog.debug("Zona:          " + datos.getProperty(SerializadorEtiquetaAFP.ZONA));
        UtilidadesLog.debug("Consecutivo:   " + datos.getProperty(SerializadorEtiquetaAFP.CONSECUTIVO));
        UtilidadesLog.debug("Campaña:       " + datos.getProperty(SerializadorEtiquetaAFP.CAMPANIA));
        UtilidadesLog.debug("Fecha:         " + datos.getProperty(SerializadorEtiquetaAFP.FECHA));
        UtilidadesLog.debug("Caja:          " + datos.getProperty(SerializadorEtiquetaAFP.NUMERO_CAJA));
        UtilidadesLog.debug("Total cajas:   " + datos.getProperty(SerializadorEtiquetaAFP.NUMERO_TOTAL_CAJAS));
        UtilidadesLog.debug("Seccion:       " + datos.getProperty(SerializadorEtiquetaAFP.SECCION));
        UtilidadesLog.debug("Codigo barras: " + datos.getProperty(SerializadorEtiquetaAFP.CODIGO_BARRAS));
        
        UtilidadesLog.info("EtiquetaAFP.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Salida");
        return this.serializador.componer(datos);
    }
    
    private String rellenarNumeroCaja(Long numeroCaja) {
        if (numeroCaja.intValue() >= 100) {
            return numeroCaja.toString();
        } else {
            StringBuffer sb = new StringBuffer();
            if (numeroCaja.intValue() >= 10) {
                sb.append(' ').append(numeroCaja).append(' ');
            } else {
                sb.append("  ").append(numeroCaja).append("  ");
            }
            return sb.toString();
        }
    }
    
    private String rellenarCeros(Long numero, int cantCifras) {
        String strNumero = numero.toString();
        if (strNumero.length() >= cantCifras) {
            return strNumero;
        } else {
            StringBuffer sb = new StringBuffer();
            while (sb.length() < cantCifras - strNumero.length()) {
                sb.append('0');
            }
            return sb.append(strNumero).toString();
        }
    }
}