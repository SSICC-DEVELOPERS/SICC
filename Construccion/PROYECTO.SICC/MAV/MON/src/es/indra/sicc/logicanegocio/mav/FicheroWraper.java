package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpAuthenticator;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

import java.util.Collection;
import java.util.Vector;
//
// -------------------------------------------------------------------------------
// ssantana



public abstract class FicheroWraper {
    public Object numRegistros;
    public Object regProcesados = new Long(0);
    protected File idFile;
    protected BufferedReader bufReader;
    protected int cant_lineas_cabecera = 0;
    protected int cant_lineas_registro = 0;

    public FicheroWraper() {
        ;
    }

    public void abrirArchivo(String path, String filename) throws MareException {
    
        UtilidadesLog.info("FicheroWraper.abrirArchivo(String path, String filename):Entrada");
        
        String codigo;
        UtilidadesLog.debug("path: " + path);
        UtilidadesLog.debug("fileName: " + filename);

        String fileName = path + "/" + filename;
        UtilidadesLog.debug("fileNameNuevo: " + fileName);

        try {
            bufReader = UtilidadesFiles.abrirFichero(fileName);
        } catch(MareException mEx) {
            throw mEx;
        }
        UtilidadesLog.info("FicheroWraper.abrirArchivo(String path, String filename):Salida");

    }

    private String leerLinea() throws MareException {
        UtilidadesLog.info("FicheroWraper.leerLinea():Entrada");
        if(bufReader != null) {
            try {
                // leo la linea
                UtilidadesLog.debug(" **** leo la linea");

                String linea = bufReader.readLine();

                // incremento contador de registros procesados
                //UtilidadesLog.debug(" **** incremento contador de registros procesados");
                //regProcesados = new Long(((Long)regProcesados).longValue() + 1);
                UtilidadesLog.debug(" **** retorno la linea ");
                UtilidadesLog.debug(linea);
                
                UtilidadesLog.info("FicheroWraper.leerLinea():Salida");
                // retorno la linea
                return linea;
            } catch(FileNotFoundException fne) {
                throw new MareException(fne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            } catch(IOException ioe) {
                throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            }
        } else
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
    }

    public void cerrarArchivo() throws MareException {
        UtilidadesLog.info("FicheroWraper.cerrarArchivo():Entrada");
        if(this.idFile != null)
            this.idFile = null;

        if(bufReader != null) {
            try {
                bufReader.close();
            } catch(IOException ioe) {
                throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }

            ;
        }
        UtilidadesLog.info("FicheroWraper.cerrarArchivo():Salida");
    }

    public Object leerRegistro() throws MareException {
        UtilidadesLog.info("FicheroWraper.cerrarArchivo():Entrada");
        Object regProcesado = null; // A retornar. 
        Vector retorno = new Vector();
        String linea;

        for(int i = 1; i <= cant_lineas_registro; i++) {
            if((linea = leerLinea()) != null) {
                retorno.add(linea);
            }
        }
        
        UtilidadesLog.debug("Vector con lineas de Registro: " + retorno);
        
        
        // Si todas las filas correspondientes a un registro estan en NULL
        // entonces se llego a fin de fichero. by ssantana, 9/8/2005.
        Boolean sonTodosNulos = Boolean.TRUE;
        for ( int i = 0; i < retorno.size(); i++) {
            if ( retorno.get(i) != null) {
               sonTodosNulos = Boolean.FALSE;
            }
        }
        
        if ( !sonTodosNulos.booleanValue() ) {
           // El registro no es correcto. Esta incompleto en cantidad de lineas.
           if( (retorno.size() > 0) && (retorno.size() < cant_lineas_registro) ) {
              //throw new MareException();
              UtilidadesLog.debug("El formato del Fichero es Incorrecto");
              throw new MareException("El formato del Fichero es Incorrecto - Esta incompleto en cantidad de lineas", 
                                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, 
                                                                 "",
                                                                 ErroresNegocio.MAV_0016));
           }

           regProcesado = parseRegistro(retorno);

           if(regProcesado != null)
              incRegistroProcesados();
        }
        
        UtilidadesLog.info("FicheroWraper.cerrarArchivo():Salida");
        return regProcesado;
    }

    public Object leerCabecera() throws MareException {
        UtilidadesLog.info("FicheroWraper.leerCabecera():Entrada");
        Vector retorno = new Vector();
        String linea;

        for(int i = 1; i <= cant_lineas_cabecera; i++) {
            linea = leerLinea();

            if((linea != null) && !linea.equals(""))
                retorno.add(linea);
            else
                throw new MareException();
        }

        if((retorno.size() > 0) && (retorno.size() < cant_lineas_cabecera))
            throw new MareException();
            
        UtilidadesLog.info("FicheroWraper.leerCabecera():Salida");
        return parseCabecera(retorno);
    }

    public abstract Object parseCabecera(Collection cab) throws MareException;

    public abstract Object parseRegistro(Collection reg) throws MareException;

    protected void finalize() throws Throwable {
        UtilidadesLog.info("FicheroWraper.finalize():Entrada");
        cerrarArchivo();
        UtilidadesLog.info("FicheroWraper.finalize():Salida");
    }

    private void incRegistroProcesados() {
        UtilidadesLog.info("FicheroWraper.incRegistroProcesados():Entrada");
        regProcesados = new Long(((Long)regProcesados).longValue() + 1);
        UtilidadesLog.info("FicheroWraper.incRegistroProcesados():Salida");
        
    }
    

}