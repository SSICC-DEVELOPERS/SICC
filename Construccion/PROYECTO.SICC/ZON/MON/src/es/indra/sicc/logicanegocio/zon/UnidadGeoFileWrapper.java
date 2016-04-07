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
package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.dtos.zon.DTOUnidadGeoCabecera;
import es.indra.sicc.dtos.zon.DTOUnidadGeoRegistro;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Vector;

import java.text.*;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            ZON - Zonificacion
 * Componente:        UnidadGeoFileWrapper
 * Fecha:             13/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Viviana Bongiovanni
 */ 

public class UnidadGeoFileWrapper extends FileWrapper {

    public static String SEPARADOR = ";";
    private int CANT_LINEAS_CABECERA = 7;
    private int CANT_LINEAS_REGISTRO = 1;
    private static int CANT_COLS_REGISTRO = 9;
    
    public UnidadGeoFileWrapper() throws MareException {
    }

    public UnidadGeoFileWrapper(String path, String filename) throws MareException {
        UtilidadesLog.info("UnidadGeoFileWrapper(String path, String filename): Entrada");
        cant_lineas_cabecera = CANT_LINEAS_CABECERA;
        cant_lineas_registro = CANT_LINEAS_REGISTRO;
        abrirArchivo(path,filename);
        UtilidadesLog.info("UnidadGeoFileWrapper(String path, String filename): Salida");
    }


    private Date toDate(String date) throws MareException {
        try {
            UtilidadesLog.info("UnidadGeoFileWrapper.toDate(String date): Entrada");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
            String anio = date.substring(0,4);
            String mes  = date.substring(4,6);
            String dia = date.substring(6,8);
        
            UtilidadesLog.debug("la fecha convertida es "+anio+"-"+mes+"-"+dia);
            Date d = sdf.parse(anio+"-"+mes+"-"+dia);
            //Date db = new Date(normalizarHoras(d).getTime() + 1000*60*60*12);
            UtilidadesLog.debug("la fecha convertida es "+d);
            UtilidadesLog.info("UnidadGeoFileWrapper.toDate(String date): Salida");
            return d;       
        } catch (ParseException pe) {
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
        }
    }

    public Date normalizarHoras(Date fecha) throws ParseException {
        UtilidadesLog.info("UnidadGeoFileWrapper.normalizarHoras(Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");              
        String strFecha = sdf.format(fecha); 
        UtilidadesLog.info("UnidadGeoFileWrapper.normalizarHoras(Date fecha): Salida");
        return sdf.parse(strFecha);
    }


    public Object parseRegistro(Collection reg) throws MareException {
        UtilidadesLog.info("UnidadGeoFileWrapper.parseRegistro(Collection reg): Entrada");
        
        DTOUnidadGeoRegistro dto = new DTOUnidadGeoRegistro();
        StringTokenizer stk;

        if ((reg != null) && (reg.size()==0)) {
           UtilidadesLog.debug("**** reg es distinto de null y su tamaño es cero");
           UtilidadesLog.info("UnidadGeoFileWrapper.parseRegistro(Collection reg): Salida");
           return null;
        }
        else {
           String linea =  (String)((Vector)reg).get(0);         
           UtilidadesLog.debug("**** Entro al else - linea " + linea);

           if (!linea.equals("")) {
               UtilidadesLog.debug("********** linea es distinto de vacio");
               if (linea.charAt(linea.length()-1)==';') {
                 UtilidadesLog.debug("********** El ultimo caracter es un ;");
                 UtilidadesLog.debug("********** linea antes" + linea);
                 linea = linea + " ";  
                 UtilidadesLog.debug("******** linea despues" + linea);
               } 
           }
           else {
                UtilidadesLog.debug("********** Entro al else lanza una MareException");
                throw new MareException();
           }
           
           stk = new StringTokenizer(linea,this.SEPARADOR);
           UtilidadesLog.debug("************* stk.countTokens()  " + stk.countTokens());

           UtilidadesLog.debug("************* antes rep:" + linea);
           linea= replace(linea,";;","; ;");
           UtilidadesLog.debug("************* desp rep:" + linea);
            
           stk = new StringTokenizer(linea,this.SEPARADOR);
           UtilidadesLog.debug("************* stk.countTokens()  " + stk.countTokens());
           UtilidadesLog.debug("************* CANT_COLS_REGISTRO " + CANT_COLS_REGISTRO);
           
           if (stk.countTokens() == this.CANT_COLS_REGISTRO) {
               UtilidadesLog.debug("********** Entro al if - std-countTokens es igual a CANT_COLS_REGISTRO");
               dto.setTipoOP(stk.nextToken());
               UtilidadesLog.debug("********** getTipoOP " + dto.getTipoOP());
               dto.setDato1(stk.nextToken());
               UtilidadesLog.debug("********** getDato1 " + dto.getDato1());
               dto.setCliente(stk.nextToken());
               UtilidadesLog.debug("********** getCliente " + dto.getCliente());
               dto.setDato2(stk.nextToken());
               UtilidadesLog.debug("********** getDato2 " + dto.getDato2());
               dto.setDato3(stk.nextToken());
               UtilidadesLog.debug("********** getDato3 " + dto.getDato3());
               dto.setDato4(stk.nextToken());
               UtilidadesLog.debug("********** getDato4 " + dto.getDato4());
               dto.setDato5(stk.nextToken());
               UtilidadesLog.debug("********** getDato5 " + dto.getDato5());
               dto.setDato6(stk.nextToken());
               UtilidadesLog.debug("********** getDato6 " + dto.getDato6());
               dto.setDato7(stk.nextToken());
               UtilidadesLog.debug("********** getDato7 " + dto.getDato7());
            } else {
                UtilidadesLog.debug("********** Entro al else se lanza una MareException");
                throw new MareException();
            }

           UtilidadesLog.debug("************ dto " + dto);
           UtilidadesLog.info("UnidadGeoFileWrapper.parseRegistro(Collection reg): Salida");
           return dto;
        }
    }

    public Object parseCabecera(Collection cab) 
    throws MareException {
        UtilidadesLog.info("UnidadGeoFileWrapper.parseCabecera(Collection cab): Entrada");
        
        DTOUnidadGeoCabecera dto = new DTOUnidadGeoCabecera();

        if ((cab != null) && (cab.size()==0)) {
           return null;
        } else {
            Vector lineas = (Vector)cab;

            dto.setPais((String)lineas.get(0));
            dto.setMarca((String)lineas.get(1));
            dto.setCanal((String)lineas.get(2));
            dto.setTipoPeriodo((String)lineas.get(3));
    
            dto.setPeriodoInicio((String)lineas.get(4));
            dto.setFechaActualizacion(toDate((String)lineas.get(5)));
            dto.setFechasCreacionGIS(toDate((String)lineas.get(6)));
        }
      
        UtilidadesLog.info("UnidadGeoFileWrapper.parseCabecera(Collection cab): Salida");
        return dto;
    }


    public static String replace(String s, String s1, String s2)
    {
        UtilidadesLog.info("UnidadGeoFileWrapper.replace(String s, String s1, String s2): Entrada");
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
        while((j = s.indexOf(s1, i)) >= 0) 
        {
            if(stringbuffer == null)
            {
                stringbuffer = new StringBuffer(s.length() * 2);
            }
            stringbuffer.append(s.substring(i, j));
            stringbuffer.append(s2);
            i = j + k - 1;
        }
        if(i != 0)
        {
            stringbuffer.append(s.substring(i));
            s3 = stringbuffer.toString();
        }
        
        UtilidadesLog.info("UnidadGeoFileWrapper.replace(String s, String s1, String s2): Salida");
        return s3;
    }
	
}