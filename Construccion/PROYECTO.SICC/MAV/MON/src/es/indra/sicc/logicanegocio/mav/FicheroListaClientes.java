package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTORegistro;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.Vector;


public class FicheroListaClientes extends FicheroWraper {
    public static String SEPARADOR = ",";
    private static int CANT_COLS_REGISTRO = 2;
    private int CANT_LINEAS_CABECERA = 7;
    private int CANT_LINEAS_REGISTRO = 1;

    public FicheroListaClientes() throws MareException {}

    public FicheroListaClientes(String path, String filename)
        throws MareException {
        cant_lineas_cabecera = CANT_LINEAS_CABECERA;
        cant_lineas_registro = CANT_LINEAS_REGISTRO;
        abrirArchivo(path, filename);
    }

    public Object parseRegistro(Collection reg) throws MareException {
        UtilidadesLog.info("FicheroListaClientes.parseRegistro(Collection reg):Entrada");
        DTORegistro dto = new DTORegistro();
        StringTokenizer stk;

        if((reg != null) && (reg.size() == 0))
            return null;
        else {
            String linea = (String)((Vector)reg).get(0);
            UtilidadesLog.debug("Linea original: " + linea);

            if(!linea.equals("")) {
                if(linea.charAt(linea.length() - 1) == ';')
                    linea = linea + " ";
            } else {
                UtilidadesLog.debug("Linea es '' - Lanza excepcion");
                throw new MareException();
            }

            linea = replace(linea, ";;", "; ;");
            UtilidadesLog.debug("Linea 3: " + linea);

            stk = new StringTokenizer(linea, this.SEPARADOR);
            UtilidadesLog.debug("stk.countTokens(): " + stk.countTokens());

            if(stk.countTokens() == this.CANT_COLS_REGISTRO) {
                UtilidadesLog.debug(" Cant. de campos correcta, genera el DTO");
                dto.setPais(stk.nextToken());            
                dto.setCodigoCliente(stk.nextToken());
            } else {
                UtilidadesLog.debug("Difiere en cant. de campos para el registro - Lanza excepcion");
                UtilidadesLog.debug("El formato del Fichero es Incorrecto");
                throw new MareException("El formato del Fichero es Incorrecto - Esta incompleto en cantidad de lineas", 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, 
                                                              "",
                                                              ErroresNegocio.MAV_0016));
            }
              
            UtilidadesLog.info("FicheroListaClientes.parseRegistro(Collection reg):Salida");
            return dto;
        }
    }

    public Object parseCabecera(Collection cab) throws MareException {
        return null;
    }

    public static String replace(String s, String s1, String s2) {
        UtilidadesLog.info("FicheroListaClientes.replace(String s, String s1, String s2):Entrada");
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;

        while((j = s.indexOf(s1, i)) >= 0) {
            if(stringbuffer == null)
                stringbuffer = new StringBuffer(s.length() * 2);

            stringbuffer.append(s.substring(i, j));
            stringbuffer.append(s2);
            i = (j + k) - 1;
        }

        if(i != 0) {
            stringbuffer.append(s.substring(i));
            s3 = stringbuffer.toString();
        }
        UtilidadesLog.info("FicheroListaClientes.replace(String s, String s1, String s2):Salida");
        return s3;
    }
}