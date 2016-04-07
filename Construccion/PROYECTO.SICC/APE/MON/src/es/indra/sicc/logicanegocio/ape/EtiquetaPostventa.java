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

public class EtiquetaPostventa extends AbstractEtiqueta {

    private static int LONGITUD_NOMBRE_CLIENTE = 30;
    private static int LONGITUD_DIRECCION = 36;
    private static int LONGITUD_BARRIO = 26;
    private static int LONGITUD_CIUDAD = 16;
    private static int LONGITUD_DEPARTAMENTO = 19;
    
    private static String STRING_VACIO = "";

    public EtiquetaPostventa() {
        this.serializador = new SerializadorPostventa();
    }

   /**
    * 
    * @observaciones
    *  BELC400000620 - eiraola - 10/08/2007 
    *                  Contemplamos que si se intenta imprimir con el Formato "EtiquetaPostventa"
    *                  alguna Etiqueta de pallets FP, el atributo "numConsolidado" del DTO de 
    *                  entrada vendra en null.
    */
    public byte[] componerEtiqueta(DTODatosImpresionEtiquetas dtoe) {
        UtilidadesLog.info("EtiquetaPostventa.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Entrada");
        UtilidadesLog.debug("DTO recibido: " + dtoe);
        
        Properties datos = new Properties();
        
        String barrio = (dtoe.getBarrio() != null)? dtoe.getBarrio() : STRING_VACIO;
        String ciudad = (dtoe.getCiudad() != null)? dtoe.getCiudad() : STRING_VACIO;
        String departamento = (dtoe.getDepartamento() != null)? dtoe.getDepartamento() : STRING_VACIO;
        
        //String numConsolidado = dtoe.getNumConsolidado().toString(); // Eliminado - eiraola - 10/08/2007
        // Agregado - eiraola - 10/08/2007 [INICIO]
        String numConsolidado = (dtoe.getNumConsolidado() != null)
                                ? dtoe.getNumConsolidado().toString() 
                                : null;
        // Agregado - eiraola - 10/08/2007 [FIN]
        String numCaja = dtoe.getNumCaja().toString();
        
        // Armo el codigo de barras concatenando num. consolidado + num.caja
        // El numero de caja se completa con ceros hasta tener 3 cifras
        StringBuffer buffer = new StringBuffer();
        /*
         * BELC300024719 - dmorello, 01/03/2007
         * El numero de consolidado se trunca a 8 digitos
         */
        //buffer.append(numConsolidado);
        /* dmorello, 01/03/2007: Se asume que el nº consolidado tiene 9 o 10 cifras */
        //String numConsTruncado = numConsolidado.substring(numConsolidado.length() - 8); // Eliminado - eiraola - 10/08/2007
        // Agregado - eiraola - 10/08/2007 [INICIO]
        String numConsTruncado = "";
        if (numConsolidado != null) {
            numConsTruncado = numConsolidado.substring(numConsolidado.length() - 8);
        } 
        // Agregado - eiraola - 10/08/2007 [FIN]
        //buffer.append(numConsTruncado);
        /* Fin BELC300024719 - dmorello, 01/03/2007 */
        //if (numCaja.length() < 3) buffer.append('0');
        //if (numCaja.length() < 2) buffer.append('0');
        //buffer.append(numCaja);
        //datos.setProperty(SerializadorPostventa.CODIGO_BARRAS, buffer.toString());
        datos.setProperty(SerializadorPostventa.CODIGO_BARRAS, this.armarCodigoBarras(numConsTruncado, dtoe.getNumCaja()));
        
        /* BELC400000224 - dmorello, 20/03/2007 */
        //datos.setProperty(SerializadorPostventa.TERRITORIO, dtoe.getCodigoTerritorio());
        //datos.setProperty(SerializadorPostventa.TERRITORIO, dtoe.getRegion() + dtoe.getZona() + dtoe.getCodigoSeccion()); // Eliminado - eiraola - 10/08/2007
        // Agregado - eiraola - 10/08/2007 [INICIO]
        String codigoSeccion = (dtoe.getCodigoSeccion() != null)? dtoe.getCodigoSeccion() : "";
        String zona = (dtoe.getZona() != null)? dtoe.getZona() : "";
        datos.setProperty(SerializadorPostventa.TERRITORIO, dtoe.getRegion() + zona + codigoSeccion);
        // Agregado - eiraola - 10/08/2007 [FIN]
        /* Fin BELC400000224 dmorello 20/03/2007 */
        
        /* dmorello, 13/03/2007: Siempre van los ultimos 8 digitos del consolidado */
        //datos.setProperty(SerializadorPostventa.BOLETA_ENTREGA, numConsolidado);
        datos.setProperty(SerializadorPostventa.BOLETA_ENTREGA, numConsTruncado);
        
        datos.setProperty(SerializadorPostventa.NOMBRE_CLIENTE, this.armarNombreCliente(dtoe).toUpperCase());
        datos.setProperty(SerializadorPostventa.DIRECCION, this.armarDireccionCliente(dtoe).toUpperCase());

        if (barrio.length() > LONGITUD_BARRIO) {
            barrio = barrio.substring(0, LONGITUD_BARRIO);
        }
        datos.setProperty(SerializadorPostventa.BARRIO, barrio.toUpperCase());
        
        if (ciudad.length() > LONGITUD_CIUDAD) {
            ciudad = ciudad.substring(0, LONGITUD_CIUDAD);
        }
        datos.setProperty(SerializadorPostventa.CIUDAD, ciudad.toUpperCase());
        
        if (departamento.length() > LONGITUD_DEPARTAMENTO) {
            departamento = departamento.substring(0, LONGITUD_DEPARTAMENTO);
        }
        datos.setProperty(SerializadorPostventa.DEPARTAMENTO, departamento.toUpperCase());
        
        String campania = dtoe.getCampania().substring(4);
        String anio = dtoe.getCampania().substring(0,4);
        datos.setProperty(SerializadorPostventa.CAMPANIA, campania);
        datos.setProperty(SerializadorPostventa.ANIO, anio);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha = sdf.format(dtoe.getFecha());
        datos.setProperty(SerializadorPostventa.FECHA, fecha);

        // dmorello, 14/03/2007: completo los numeros de caja con espacios en blanco
        datos.setProperty(SerializadorPostventa.NUMERO_CAJA, this.rellenarNumeroCaja(dtoe.getNumCaja()));
        datos.setProperty(SerializadorPostventa.NUMERO_TOTAL_CAJAS, this.rellenarNumeroCaja(dtoe.getNumeroTotalCajas()));
        //datos.setProperty(SerializadorPostventa.SECCION, dtoe.getCodigoSeccion()); // Eliminado - eiraola - 10/08/2007
        datos.setProperty(SerializadorPostventa.SECCION, codigoSeccion);  // Agregado - eiraola - 10/08/2007

        
        UtilidadesLog.debug("DATOS DE LA ETIQUETA POSTVENTA:");
        UtilidadesLog.debug("Codigo barras:  " + datos.getProperty(SerializadorPostventa.CODIGO_BARRAS));
        UtilidadesLog.debug("Territorio:     " + datos.getProperty(SerializadorPostventa.TERRITORIO));
        UtilidadesLog.debug("Boleta entrega: " + datos.getProperty(SerializadorPostventa.BOLETA_ENTREGA));
        UtilidadesLog.debug("Nombre cliente: " + datos.getProperty(SerializadorPostventa.NOMBRE_CLIENTE));
        UtilidadesLog.debug("Direccion:      " + datos.getProperty(SerializadorPostventa.DIRECCION));
        UtilidadesLog.debug("Barrio:         " + datos.getProperty(SerializadorPostventa.BARRIO));
        UtilidadesLog.debug("Ciudad:         " + datos.getProperty(SerializadorPostventa.CIUDAD));
        UtilidadesLog.debug("Departamento:   " + datos.getProperty(SerializadorPostventa.DEPARTAMENTO));
        UtilidadesLog.debug("Campaña:        " + datos.getProperty(SerializadorPostventa.CAMPANIA));
        UtilidadesLog.debug("Año:            " + datos.getProperty(SerializadorPostventa.ANIO));
        UtilidadesLog.debug("Fecha:          " + datos.getProperty(SerializadorPostventa.FECHA));
        UtilidadesLog.debug("Caja:           " + datos.getProperty(SerializadorPostventa.NUMERO_CAJA));
        UtilidadesLog.debug("Total cajas:    " + datos.getProperty(SerializadorPostventa.NUMERO_TOTAL_CAJAS));
        UtilidadesLog.debug("Seccion:        " + datos.getProperty(SerializadorPostventa.SECCION));


        UtilidadesLog.info("EtiquetaPostventa.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Salida");
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
    
    /**
     * CHANGELOG
     * ---------
     * 03/09/2009 - dmorello, Cambio 20090839
     *     Si el flag indImprimirDatosBasicosCliente del DTO esta apagado,
     *     el nombre del cliente en la etiqueta sera "" (no se imprimira).
     */
    private String armarNombreCliente(DTODatosImpresionEtiquetas dto) {
        
        // Cambio 20090839
        if (! Boolean.TRUE.equals(dto.getIndImprimirDatosBasicosCliente())) {
            return "";
        }
        
        // Concateno apellidos y nombres
        StringBuffer buffer = new StringBuffer();
        if (dto.getApellido1() != null)
            buffer.append(dto.getApellido1()).append(' ');
        if (dto.getApellido2() != null)
            buffer.append(dto.getApellido2()).append(' ');
        if (dto.getNombre1() != null)
            buffer.append(dto.getNombre1()).append(' ');
        if (dto.getNombre2() != null)
            buffer.append(dto.getNombre2());
            
        // Limito la longitud para evitar desbordes en la etiqueta
        if (buffer.length() > LONGITUD_NOMBRE_CLIENTE) {
            return buffer.substring(0, LONGITUD_NOMBRE_CLIENTE);
        } else {
            return buffer.toString();
        }
    }
    
    private String armarDireccionCliente(DTODatosImpresionEtiquetas dto) {
        // Armo la direccion del cliente = nombreVia + numero
        StringBuffer buffer = new StringBuffer();
        
        if (dto.getNombreVia() != null) {
            buffer.append(dto.getNombreVia());
        }
        if (dto.getNumeroPrincipal() != null) {
            buffer.append(' ').append(dto.getNumeroPrincipal());
        }
        
        // Limito la longitud para evitar desbordes en la etiqueta
        if (buffer.length() > LONGITUD_DIRECCION) {
            return buffer.substring(0, LONGITUD_DIRECCION);
        } else {
            return buffer.toString();
        }
    }
    
    private String armarCodigoBarras(String numConsolidado, Long numCaja) {
        // Armo el codigo de barras concatenando num. consolidado + num.caja
        // Tomo del consolidado los ultimos 8 dígitos
        // El numero de caja se completa con ceros hasta tener 3 digitos

        StringBuffer buffer = new StringBuffer();
        buffer.append(numConsolidado);
        if (numCaja.longValue() < 100) buffer.append('0');
        if (numCaja.longValue() < 10) buffer.append('0');
        buffer.append(numCaja);
        
        return buffer.toString();
    }    
}