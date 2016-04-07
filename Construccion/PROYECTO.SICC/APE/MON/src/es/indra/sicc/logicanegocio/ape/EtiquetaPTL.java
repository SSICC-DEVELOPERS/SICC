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

public class EtiquetaPTL extends AbstractEtiqueta {

    private static final int LONGITUD_NOMBRE_CLIENTE = 29;
    private static final int LONGITUD_DIRECCION = 29;
    private static final int LONGITUD_BARRIO = 22;
    private static final int LONGITUD_CIUDAD = 29;
    private static final int LONGITUD_DEPARTAMENTO = 15;
    private static final int LONGITUD_SECUENCIA_CAJA_PTL = 5;
    private static final int LONGITUD_LINEA_TEXTO_VARIABLE = 23;
    private static final int LONGITUD_LINEA_ARMADO = 20;
    
    private static String STRING_VACIO = "";

    public EtiquetaPTL() {
        this.serializador = new SerializadorPTL();
    }

   /**
    * 
    * @observaciones
    *  14/02/2007 - dmorello - Segun respuesta de DT (hmansi) el numero de secuencia de caja 
    *                  PTL se obtiene con los N ultimos digitos del consolidado (N = longitud numero etiqueta).
    *  14/03/2007 - dmorello - Completo los numeros de caja con espacios en blanco.
    *  BELC400000224 - dmorello - 20/03/2007 En TERRITORIO va region + zona + codigoSeccion.
    *  BELC400000620 - eiraola - 10/08/2007 
    *                  Contemplamos que si se intenta imprimir con el Formato "EtiquetaPTL"
    *                  alguna Etiqueta de pallets FP, el atributo "numConsolidado" del DTO de 
    *                  entrada vendra en null.
    *  BELC400000473 - SCS 
    *  Cambio APE-04 - dmorello, 10/01/2008
    *                  El dato "secuencia caja PTL" pasa a tomarse de dtoe.secuenciaCajaPTL
    *  Cambio APE-10 - dmorello, 24/06/2008
    *                  La constante LONGITUD_BARRIO queda con valor 17.
    *  Cambio 20090839 - dmorello, 16/09/2009
    *                  Cambian los datos que se pasan a la etiqueta:
    *                  - Se separa en dos lineas el texto variable
    *                  - Se agregan linea de armado y fecha de facturacion
    *                  - Se eliminan numero factura, texto primer pedido y departamento
    *                  - Se renombra boleta de entrega a consolidado
    *                  - El secuencial pasa a tener cinco digitos
    *  Incidentes cambio 20090839 - dmorello, 12/11/2009
    *                  - Se imprimen en tamaño mas pequeño los primeros 4 digitos del num consolidado
    */
    public byte[] componerEtiqueta(DTODatosImpresionEtiquetas dtoe) {
        UtilidadesLog.info("EtiquetaPTL.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Entrada");
        UtilidadesLog.debug("DTO recibido: " + dtoe);
        
        Properties datos = new Properties();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String numConsolidado = (dtoe.getNumConsolidado() != null)? dtoe.getNumConsolidado().toString() : STRING_VACIO;
        // Se completa el numero de caja con espacios en blanco
        String numCaja = (dtoe.getNumCaja() != null)? this.rellenarNumeroCaja(dtoe.getNumCaja()) : STRING_VACIO;
        String region = (dtoe.getRegion() != null)? dtoe.getRegion().toString() : STRING_VACIO;
        String zona = (dtoe.getZona() != null)? dtoe.getZona().toString() : STRING_VACIO;
        String codigoSeccion = (dtoe.getCodigoSeccion() != null)? dtoe.getCodigoSeccion().toString() : STRING_VACIO;
        String numeroTotalCajas = (dtoe.getNumeroTotalCajas() != null)? this.rellenarNumeroCaja(dtoe.getNumeroTotalCajas()) : STRING_VACIO;
        String barrio = (dtoe.getBarrio() != null)? dtoe.getBarrio() : STRING_VACIO;
        String ciudad = (dtoe.getCiudad() != null)? dtoe.getCiudad() : STRING_VACIO;
        String departamento = (dtoe.getDepartamento() != null)? dtoe.getDepartamento() : STRING_VACIO;
        String talla = (dtoe.getTalla() != null)? dtoe.getTalla() : STRING_VACIO;
        String indChequeo = (dtoe.getIndChequeo() != null)? SerializadorPTL.TEXTO_CHEQUEO : STRING_VACIO;
        String textoVariable = (dtoe.getTextoVariable() != null) ? dtoe.getTextoVariable() : STRING_VACIO;
        String descLineaArmado = (dtoe.getDescripcionLineaArmado() != null) ? dtoe.getDescripcionLineaArmado() : STRING_VACIO;
        String fechaFact = (dtoe.getFechaFacturacion() != null) ? sdf.format(dtoe.getFechaFacturacion()) : STRING_VACIO;
        
        // Cambio APE-04 - dmorello, 10/01/2008
        String secuenciaCajaPTL = STRING_VACIO;
        if (dtoe.getSecuenciaCajaPTL() != null) {
            secuenciaCajaPTL = this.rellenarCeros(dtoe.getSecuenciaCajaPTL().longValue(), LONGITUD_SECUENCIA_CAJA_PTL);
            if (secuenciaCajaPTL.length() > LONGITUD_SECUENCIA_CAJA_PTL) {
                secuenciaCajaPTL = secuenciaCajaPTL.substring(secuenciaCajaPTL.length() - LONGITUD_SECUENCIA_CAJA_PTL);
            }
        }
        
        String textoPrimerPedido = dtoe.getTextoPrimerPedido();
        if (textoPrimerPedido == null) {
            textoPrimerPedido = STRING_VACIO;
        }
        // Fin cambio APE-04 - dmorello
        
        // Van los ultimos 8 digitos del consolidado
        if (numConsolidado.length() > 8) {
            numConsolidado = numConsolidado.substring(numConsolidado.length() - 8);
        }
        
        String numConsPrimeros = numConsolidado.substring(0,4);
        String numConsUltimos = numConsolidado.substring(4);
        
        datos.setProperty(SerializadorPTL.NUMERO_CONSOLIDADO_PRIMEROS, numConsPrimeros);
        datos.setProperty(SerializadorPTL.NUMERO_CONSOLIDADO_ULTIMOS, numConsUltimos);
        datos.setProperty(SerializadorPTL.NUMERO_CAJA, numCaja);
        datos.setProperty(SerializadorPTL.NUMERO_TOTAL_CAJAS, numeroTotalCajas);
        datos.setProperty(SerializadorPTL.TERRITORIO, region + zona + codigoSeccion);
        
        datos.setProperty(SerializadorPTL.NOMBRE_CLIENTE, this.armarNombreCliente(dtoe).toUpperCase());
        datos.setProperty(SerializadorPTL.DIRECCION, this.armarDireccionCliente(dtoe).toUpperCase());
        
        if (barrio.length() > LONGITUD_BARRIO) {
            barrio = barrio.substring(0, LONGITUD_BARRIO);
        }
        datos.setProperty(SerializadorPTL.BARRIO, barrio.toUpperCase());
        
        if (ciudad.length() > LONGITUD_CIUDAD) {
            ciudad = ciudad.substring(0, LONGITUD_CIUDAD);
        }
        datos.setProperty(SerializadorPTL.CIUDAD, ciudad.toUpperCase());
        
        if (departamento.length() > LONGITUD_DEPARTAMENTO) {
            departamento = departamento.substring(0, LONGITUD_DEPARTAMENTO);
        }
        
        if (descLineaArmado.length() > LONGITUD_LINEA_ARMADO) {
            descLineaArmado = descLineaArmado.substring(0, LONGITUD_LINEA_ARMADO);
        }
        
        datos.setProperty(SerializadorPTL.DEPARTAMENTO, departamento.toUpperCase());
        datos.setProperty(SerializadorPTL.SECUENCIA_CAJA_PTL, secuenciaCajaPTL);
        datos.setProperty(SerializadorPTL.TALLA, this.armarTalla(talla));
        datos.setProperty(SerializadorPTL.CHEQUEO, indChequeo);
        datos.setProperty(SerializadorPTL.CODIGO_BARRAS, this.armarCodigoBarras(numConsolidado, dtoe.getNumCaja()));
        
        // Cambio 20090839 - dmorello, 16/09/2009
        // Separo el texto variable en dos lineas y las agrego al Properties
        String[] lineasTextoVar = this.dividirTextoVariable(textoVariable);
        datos.setProperty(SerializadorPTL.TEXTO_VARIABLE_1, lineasTextoVar[0].toUpperCase());
        datos.setProperty(SerializadorPTL.TEXTO_VARIABLE_2, lineasTextoVar[1].toUpperCase());
        
        
        // Cambio APE-04 - dmorello, 10/01/2008
        // Se elimina este dato por cambio 20090839 - dmorello, 16/09/2009
        //datos.setProperty(SerializadorPTL.TEXTO_PRIMER_PEDIDO, textoPrimerPedido);
        
        // Cambio 20090839
        datos.setProperty(SerializadorPTL.LINEA_ARMADO, descLineaArmado.toUpperCase());
        datos.setProperty(SerializadorPTL.FECHA_FACTURACION, fechaFact);
        
        
        UtilidadesLog.debug("DATOS DE LA ETIQUETA PTL");
        UtilidadesLog.debug("Num cons(prim):  " + datos.getProperty(SerializadorPTL.NUMERO_CONSOLIDADO_PRIMEROS));
        UtilidadesLog.debug("Num cons(ult):  " + datos.getProperty(SerializadorPTL.NUMERO_CONSOLIDADO_ULTIMOS));
        UtilidadesLog.debug("Linea de armado: " + datos.getProperty(SerializadorPTL.LINEA_ARMADO));
        UtilidadesLog.debug("Territorio:      " + datos.getProperty(SerializadorPTL.TERRITORIO));
        UtilidadesLog.debug("Caja:            " + datos.getProperty(SerializadorPTL.NUMERO_CAJA));
        UtilidadesLog.debug("Total cajas:     " + datos.getProperty(SerializadorPTL.NUMERO_TOTAL_CAJAS));
        UtilidadesLog.debug("Nombre cliente:  " + datos.getProperty(SerializadorPTL.NOMBRE_CLIENTE));
        UtilidadesLog.debug("Direccion:       " + datos.getProperty(SerializadorPTL.DIRECCION));
        UtilidadesLog.debug("Barrio:          " + datos.getProperty(SerializadorPTL.BARRIO));
        UtilidadesLog.debug("Ciudad:          " + datos.getProperty(SerializadorPTL.CIUDAD));
        UtilidadesLog.debug("Sec.caja PTL:    " + datos.getProperty(SerializadorPTL.SECUENCIA_CAJA_PTL));
        UtilidadesLog.debug("Talla:           " + datos.getProperty(SerializadorPTL.TALLA));
        UtilidadesLog.debug("Chequeo:         " + datos.getProperty(SerializadorPTL.CHEQUEO));
        UtilidadesLog.debug("Texto variable 1:" + datos.getProperty(SerializadorPTL.TEXTO_VARIABLE_1));
        UtilidadesLog.debug("Texto variable 2:" + datos.getProperty(SerializadorPTL.TEXTO_VARIABLE_2));
        UtilidadesLog.debug("Codigo barras:   " + datos.getProperty(SerializadorPTL.CODIGO_BARRAS));


        UtilidadesLog.info("EtiquetaPTL.componerEtiqueta(DTODatosImpresionEtiquetas dtoe): Salida");
        return this.serializador.componer(datos);
    }
    
    private String rellenarNumeroCaja(Long numeroCaja) {
        if (numeroCaja.intValue() >= 10) {
            return numeroCaja.toString();
        } else {
            return " " + numeroCaja + ' ';
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
    
    /**
     * Modifica (si es necesario) el dato Talla para que quede centrado
     * en el recuadro correspondiente de la etiqueta.
     * Se basa en que la longitud de este campo es, a lo sumo, 2 caracteres.
     * @author dmorello
     * @since 13-09-2007
     */
    private String armarTalla(String tallaOrig) {
        if (tallaOrig != null && tallaOrig.length() == 1) {
            return new String(new char[] { ' ', tallaOrig.charAt(0), ' ' });
        } else {
            return tallaOrig;
        }
    }
    
    private String rellenarCeros(long valor, int numDigitosFinal) {
        StringBuffer sb = new StringBuffer();
        sb.append(valor);
        while (sb.length() < numDigitosFinal) sb.insert(0,'0');
        return sb.toString();
    }
    
    /**
     * Cambio 20090839
     * Divide el string recibido en dos partes cuya longitud sera como maximo
     * LONGITUD_LINEA_TEXTO_VARIABLE
     * @author dmorello
     * @since 16-09-2009
     */
    private String[] dividirTextoVariable(String textoVar) {
    
        String[] renglones = new String[] {STRING_VACIO, STRING_VACIO};
        
        if (textoVar.length() <= LONGITUD_LINEA_TEXTO_VARIABLE) {
            // El texto cabe en la primera linea
            renglones[0] = textoVar;
            renglones[1] = STRING_VACIO;
        } else {
            // El texto no cabe en la primera linea, debo partirlo
            
            // Separo las palabras del texto
            String[] palabras = textoVar.split(" ");
            
            // Voy colocando las palabras en ambos renglones
            int renglon = 0;
            boolean primeraPalabraParte = true;
            for (int i = 0; i < palabras.length; i++) {
                if (primeraPalabraParte) {
                    // Verifico que la primera palabra quepa en la linea
                    if (palabras[i].length() <= LONGITUD_LINEA_TEXTO_VARIABLE) {
                        renglones[renglon] = palabras[i];
                        primeraPalabraParte = false;
                    } else {
                        // No cabe, debo truncarla
                        String primeraParte = palabras[i].substring(0, LONGITUD_LINEA_TEXTO_VARIABLE);
                        if (renglon == 0) {
                            // La primera parte de la palabra va al renglon 1
                            renglones[renglon] = primeraParte;
                            // La otra parte la dejo en el array para que vaya al renglon 2
                            palabras[i] = palabras[i].substring(LONGITUD_LINEA_TEXTO_VARIABLE);
                            renglon = 1;
                            i--;
                        } else { // parte == 1
                            // La primera parte de la palabra va al renglon 2
                            renglones[renglon] = primeraParte;
                            break; // Ya se que las palabras restantes no van a entrar
                        }
                    }
                } else {
                    // No es la primera palabra del renglon
                    if (renglones[renglon].length() + 1 + palabras[i].length() <= LONGITUD_LINEA_TEXTO_VARIABLE) {
                        // Hay lugar en el renglon => la concateno
                        renglones[renglon] += ' ' + palabras[i];
                    } else {
                        // No hay lugar...
                        if (renglon == 0) {
                            // Paso al segundo renglon
                            renglon = 1;
                            primeraPalabraParte = true;
                            i--;
                        } else { // parte == 1
                            // Agrego la palabra y trunco el renglon a su longitud maxima
                            renglones[renglon] += ' ' + palabras[i];
                            renglones[renglon] = renglones[renglon].substring(0, LONGITUD_LINEA_TEXTO_VARIABLE);
                        }
                    }
                }
            } // Fin for palabras del texto variable
        }
        
        return renglones;
    }
    
}