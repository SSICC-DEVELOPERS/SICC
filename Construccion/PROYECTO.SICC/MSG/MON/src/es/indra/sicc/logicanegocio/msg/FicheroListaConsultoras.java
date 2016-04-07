/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.presentacion.subidaFichero.FicheroWrapper;
import es.indra.sicc.dtos.msg.*;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Iterator;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.StringTokenizer;
import java.util.Vector;

public class FicheroListaConsultoras extends FicheroWrapper {
    private static int CANT_LINEAS_CABECERA = 0;
    private static int CANT_LINEAS_REGISTRO = 1;
    private static int CANT_COLS_REGISTRO = 10;
    private static int CANT_MAX_COLS_REGISTRO = 11;
    private static int CANT_MIN_COLS_REGISTRO = 11;
    //private static String SEPARADOR = "##";
    private static String SEPARADOR = "\\t";
    private int longitudCliente;

    public FicheroListaConsultoras(String path, String filename, int longitudCliente) throws MareException {
        UtilidadesLog.info("FicheroListaConsultoras.FicheroListaConsultoras(String path, String filename): Entrada");
    
        cant_lineas_cabecera = CANT_LINEAS_CABECERA;
        cant_lineas_registro = CANT_LINEAS_REGISTRO;
        abrirArchivo(path, filename);
        this.longitudCliente = longitudCliente;
        UtilidadesLog.info("FicheroListaConsultoras.FicheroListaConsultoras(String path, String filename): Salida");
    }

    public Object parseRegistro(Collection reg) throws MareException {
    
        UtilidadesLog.info("FicheroListaConsultoras.parseRegistro(Collection reg): Entrada");
    
        DTORegistroFicheroConsultoras dtos = new DTORegistroFicheroConsultoras();

        StringTokenizer stk;
        String codigoError;

        UtilidadesLog.debug("el valor de reg es " + reg);

		String linea =  (String)((Vector)reg).get(0);
            
        UtilidadesLog.debug("linea " + linea);
       
        Vector vec = contadorColumnas(linea, SEPARADOR);
        
        UtilidadesLog.debug("Vector recibido: "+vec.toString());
        
        
        UtilidadesLog.debug("el tamanio " + vec.size());
   
        if (vec.size() != 0) {
           if (vec.size() >= CANT_MIN_COLS_REGISTRO && vec.size()<=CANT_MAX_COLS_REGISTRO) {
                            
              Iterator it = vec.iterator();
              /*
               * 21980 - dmorello, 31/05/2006 - Segun DT:
               * El proceso a seguir con el código de cliente es el siguiente:
               * 1 - Eliminar los blancos
               * 2 - comprobar la longitud del campo
               * 2.1 - Si es mayor que 11 recortar los n primeros caracteres
               * 2.2 - Si es menor que 11 completar con n ceros
               */
              //dtos.setCodCliente((String)it.next());
              String codCliente = ((String)it.next());
              UtilidadesLog.debug("codigoClienteRecuperado; "+codCliente);
              if (codCliente != null) {
                  codCliente = codCliente.trim();
                  int length = codCliente.length();
                  //if (length > 11) {
                  if (length > longitudCliente) {
                      // Elimino los caracteres excedentes para que queden 11
                      int n = codCliente.length() - longitudCliente;
                      codCliente = codCliente.substring(n);
                  } else if (length < longitudCliente) {
                      // Relleno con ceros hasta tener longitud 11
                      StringBuffer sb = new StringBuffer();
                      for (int i = 0; i < longitudCliente - length; i++) {
                          sb.append('0');
                      }
                      codCliente = sb.append(codCliente).toString();
                  }
              }
              dtos.setCodCliente(codCliente);
              /* Fin 21980 dmorello 31/05/2006 */
              UtilidadesLog.debug("Codigo Cliente parseado: "+codCliente);
              
              dtos.setNombreYApellido((String)it.next());
              UtilidadesLog.debug("dtos.setNombreYApellido: "+dtos.getNombreYApellido());
              if (it.hasNext()){
                  dtos.setDatoVariable2((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable2: "+dtos.getDatoVariable2());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable3((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable3: "+dtos.getDatoVariable3());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable4((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable4: "+dtos.getDatoVariable4());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable5((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable5: "+dtos.getDatoVariable5());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable6((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable6: "+dtos.getDatoVariable6());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable7((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable7: "+dtos.getDatoVariable7());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable8((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable8: "+dtos.getDatoVariable8());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable9((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable9: "+dtos.getDatoVariable9());
              }
              if (it.hasNext()){
                  dtos.setDatoVariable10((String)it.next());
                  UtilidadesLog.debug("dtos.setDatoVariable10: "+dtos.getDatoVariable10());
              }
           }
        }else{
            UtilidadesLog.debug("devolvio cero porque es un fichero incorrecto");
            
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0013));        
            /*throw new MareException(null, null,
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", 
      ErroresDeNegocio.MSG_0013)); */  
                // inc. 14016 -> " Formato de fichero incorrecto"
      /*UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", 
      es.indra.sicc.logicanegocio.zon.ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));  */
        }

        UtilidadesLog.debug("DTO a devolver: "+dtos);

        UtilidadesLog.info("FicheroListaConsultoras.parseRegistro(Collection reg): Salida");

        return dtos;
    }
    
    

    public Object parseCabecera(Collection cab) throws MareException {
        return null;
    }
    
    public Vector contadorColumnas(String linea, String separador) throws MareException {
    
        UtilidadesLog.info("FicheroListaConsultoras.contadorColumnas(String linea, String separador): Entrada");
      
        /*String separadorIndividual;
        int posicion;
        int cantColumnas;
        Vector datos;
        Vector posicionSeparadores;
        String[] cadenas;
        int cantCadenas;
        String cadenaProcesada;
            
        separadorIndividual = String.valueOf(separador.charAt(0));
        posicion = 0;
        datos = new Vector();
        int cant = 0;
        int cantSeparadores = 0;
        
        cantCadenas = tokens.countTokens();
        UtilidadesLog.debug("Cantidad de tokens: "+cantCadenas);
        cadenas = new String[cantCadenas];
        String[] cadenasModificadas = new String[cantCadenas];
        int posicionModificadas = 0;
        for (int i = 0; tokens.hasMoreTokens(); i++) {
            cadenas[i] = tokens.nextToken();
        }
        StringBuffer union = null;
        for (int i = 0, j = 1; j < cantCadenas; i++, j++) {
            union = new StringBuffer();
            union.append(cadenas[i]);
            union.append(cadenas[j]);
            if (union.toString().equals(separador)) {
                cantSeparadores++;
                i++;
                j++;
                cadenasModificadas[posicionModificadas] = String.valueOf(separador.charAt(0));
            } else {
                cadenasModificadas[posicionModificadas] = cadenas[i];
            }
            posicionModificadas++;
        }
        cantColumnas = cantSeparadores;
        StringBuffer aux = new StringBuffer();
        for (int i = 0; i < posicionModificadas; i++) {
            aux.append(cadenasModificadas[i]);
        }
        cadenaProcesada = aux.toString();
            
        if (cantColumnas != 0) {                
            UtilidadesLog.debug("Cadena Procesada: " + cadenaProcesada);
                  
            StringTokenizer tokensFinales = new StringTokenizer(cadenaProcesada, separador, true);
            String valor = null;
            if (String.valueOf(cadenaProcesada.charAt(0)).equals(
                separadorIndividual)) {
              datos.add(new String(""));
                }
            boolean flagSeparadorAnterior = false;
            while (tokensFinales.hasMoreTokens()) {
                valor = tokensFinales.nextToken();
                if (!valor.equals(separadorIndividual)) {
                    datos.add(valor);
                    flagSeparadorAnterior = false;
                } else {
                    if (flagSeparadorAnterior) {
                        datos.add(new String(""));
                    } else {
                        flagSeparadorAnterior = true;
                    }
                }
            }
        } else { 
            return datos;
        }      */
        /*StringTokenizer tokens = new StringTokenizer(linea, separador);*/
        UtilidadesLog.debug("el string recibido es: "+linea);
        UtilidadesLog.debug("el string recibido tiene el separador?: "+linea.indexOf(separador));
        UtilidadesLog.debug("El separador es: "+separador);
        
        String[] tokens = linea.split(separador);
        
        Vector datos = new Vector();
        int largo = tokens.length;
        
        UtilidadesLog.debug("columnas encontradas "+tokens.length);
        
        for (int i=0; i< largo; i++){
            String tok = tokens[i];
            UtilidadesLog.debug("Agregando el valor al vector: "+tok);
            datos.add(tok);
        }
        UtilidadesLog.debug("Vector a devolver: "+datos.toString());
        UtilidadesLog.info("FicheroListaConsultoras.contadorColumnas(String linea, String separador): Salida");          
        return datos;
    }
}
