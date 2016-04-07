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

public class EtiquetaMAV extends AbstractEtiqueta {

    private static final int LONGITUD_NOMBRE_CLIENTE = 30;
    private static final int LONGITUD_DIRECCION = 37;
    private static final int LONGITUD_CIUDAD = 19;
    private static final int LONGITUD_DEPARTAMENTO = 17;
    private static final int LONGITUD_BARRIO = 26;
    
    private static String STRING_VACIO = "";

    public EtiquetaMAV() {
        this.serializador = new SerializadorMAV();
    }

   /**
    * 
    * @observaciones
    *  BELC400000620 - eiraola - 10/08/2007 
    *                  Contemplamos que si se intenta imprimir con el Formato "EtiquetaMAV"
    *                  alguna Etiqueta de pallets FP, el atributo "numConsolidado" del DTO de 
    *                  entrada vendra en null.
    *  Cambio APE-10 - dmorello, 24/06/2008
    *                  Se agrega constante LONGITUD_BARRIO
    *                  Agrego el dato Barrio tomado del dtoe, limitando su
    *                  longitud al valor indicado por LONGITUD_BARRIO.
    */
    public byte[] componerEtiqueta(DTODatosImpresionEtiquetas dtoe) {
        UtilidadesLog.info("EtiquetaMAV.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Entrada");
        UtilidadesLog.debug("DTO recibido: " + dtoe);
        
        Properties datos = new Properties();
        
        String region = (dtoe.getRegion() != null)? dtoe.getRegion().toString() : STRING_VACIO;
        String zona = (dtoe.getZona() != null)? dtoe.getZona().toString() : STRING_VACIO;
        String ciudad = (dtoe.getCiudad() != null)? dtoe.getCiudad() : STRING_VACIO;
        String departamento = (dtoe.getDepartamento() != null)? dtoe.getDepartamento() : STRING_VACIO;
        String barrio = (dtoe.getBarrio() != null)? dtoe.getBarrio() : STRING_VACIO;
        
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
        datos.setProperty(SerializadorMAV.CODIGO_BARRAS, this.armarCodigoBarras(numConsTruncado, dtoe.getNumCaja()));
        
        /* dmorello, 13/03/2007: Siempre van los ultimos 8 digitos del consolidado */
        //datos.setProperty(SerializadorMAV.REMISION, numConsolidado);
        datos.setProperty(SerializadorMAV.REMISION, numConsTruncado);
        /* Fin dmorello 13/03/2007 */
        datos.setProperty(SerializadorMAV.REGION, region);
        datos.setProperty(SerializadorMAV.ZONA, zona);
        
        datos.setProperty(SerializadorMAV.NOMBRE_CLIENTE, this.armarNombreCliente(dtoe).toUpperCase());
        datos.setProperty(SerializadorMAV.DIRECCION, this.armarDireccionCliente(dtoe).toUpperCase());
        //datos.setProperty(SerializadorMAV.BARRIO, dtoe.getBarrio());
        if (barrio.length() > LONGITUD_BARRIO) {
            barrio = barrio.substring(0, LONGITUD_BARRIO);
        }
        datos.setProperty(SerializadorMAV.BARRIO, barrio);
        
        if (ciudad.length() > LONGITUD_CIUDAD) {
            ciudad = ciudad.substring(0, LONGITUD_CIUDAD);
        }
        datos.setProperty(SerializadorMAV.CIUDAD, ciudad.toUpperCase());
        
        if (departamento.length() > LONGITUD_DEPARTAMENTO) {
            departamento = departamento.substring(0, LONGITUD_DEPARTAMENTO);
        }
        datos.setProperty(SerializadorMAV.DEPARTAMENTO, departamento.toUpperCase());
        
        if (dtoe.getTelefono() != null) {
            datos.setProperty(SerializadorMAV.TELEFONO, dtoe.getTelefono());
        } else {
            datos.setProperty(SerializadorMAV.TELEFONO, "");
        }
        
        String campania = dtoe.getCampania().substring(4);
        String anio = dtoe.getCampania().substring(0,4);
        datos.setProperty(SerializadorMAV.CAMPANIA, campania);
        datos.setProperty(SerializadorMAV.ANIO, anio);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String fecha = sdf.format(dtoe.getFecha());
        datos.setProperty(SerializadorMAV.FECHA, fecha);
        
        // dmorello, 14/03/2007: completo los numeros de caja con espacios en blanco
        datos.setProperty(SerializadorMAV.NUMERO_CAJA, this.rellenarNumeroCaja(dtoe.getNumCaja()));
        datos.setProperty(SerializadorMAV.NUMERO_TOTAL_CAJAS, this.rellenarNumeroCaja(dtoe.getNumeroTotalCajas()));
        //datos.setProperty(SerializadorMAV.CARGO, dtoe.getCargo());  // Eliminado - eiraola - 10/08/2007
        datos.setProperty(SerializadorMAV.CARGO, (dtoe.getCargo() != null)? dtoe.getCargo() : ""); // Agregado - eiraola - 10/08/2007
        
        UtilidadesLog.debug("DATOS DE LA ETIQUETA MAV:");
        UtilidadesLog.debug("Codigo barras:  " + datos.getProperty(SerializadorMAV.CODIGO_BARRAS));
        UtilidadesLog.debug("Remision:       " + datos.getProperty(SerializadorMAV.REMISION));
        UtilidadesLog.debug("Region:         " + datos.getProperty(SerializadorMAV.REGION));
        UtilidadesLog.debug("Zona:           " + datos.getProperty(SerializadorMAV.ZONA));
        UtilidadesLog.debug("Nombre cliente: " + datos.getProperty(SerializadorMAV.NOMBRE_CLIENTE));
        UtilidadesLog.debug("Direccion:      " + datos.getProperty(SerializadorMAV.DIRECCION));
        UtilidadesLog.debug("Barrio:         " + datos.getProperty(SerializadorMAV.BARRIO));
        UtilidadesLog.debug("Ciudad:         " + datos.getProperty(SerializadorMAV.CIUDAD));
        UtilidadesLog.debug("Departamento:   " + datos.getProperty(SerializadorMAV.DEPARTAMENTO));
        UtilidadesLog.debug("Telefono:       " + datos.getProperty(SerializadorMAV.TELEFONO));
        UtilidadesLog.debug("Campaña:        " + datos.getProperty(SerializadorMAV.CAMPANIA));
        UtilidadesLog.debug("Año:            " + datos.getProperty(SerializadorMAV.ANIO));
        UtilidadesLog.debug("Fecha:          " + datos.getProperty(SerializadorMAV.FECHA));
        UtilidadesLog.debug("Caja:           " + datos.getProperty(SerializadorMAV.NUMERO_CAJA));
        UtilidadesLog.debug("Total cajas:    " + datos.getProperty(SerializadorMAV.NUMERO_TOTAL_CAJAS));
        UtilidadesLog.debug("Cargo:          " + datos.getProperty(SerializadorMAV.CARGO));

        UtilidadesLog.info("EtiquetaMAV.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Salida");
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

    private String armarNombreCliente(DTODatosImpresionEtiquetas dto) {
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