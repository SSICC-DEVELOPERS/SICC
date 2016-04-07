package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.util.UtilidadesLog;
import java.io.FileDescriptor;
import java.io.File;
import java.io.FileNotFoundException; 
import es.indra.mare.common.exception.MareException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFiles;

/**
 * Sistema:       Belcorp
 * Modulo:        ZON
 * Componente:    FileWrapper -
 * Fecha:         12/11/2003
 * Observaciones:
 * 
 * 
 * 
 * @version       1.0
 * @author        Fernando Laffaye
 */
 
public abstract class FileWrapper {
    public Object numRegistros;
    public Object regProcesados = new Long(0);
    protected File idFile;
    protected BufferedReader bufReader;
    protected int cant_lineas_cabecera = 0;
    protected int cant_lineas_registro = 0;

    public FileWrapper(){  }

    /*
     * Actualmente realiza funciones de chequeo del archivo. 
     * 
    */
    
    public void abrirArchivo(String path, String filename) throws MareException {
        UtilidadesLog.info("FileWrapper.abrirArchivo(String path, String filename): Entrada");
        String codigo;
        String fileName = path + "/" + filename;
        //String fileName = path + File.separator + filename;
        UtilidadesLog.debug("************ fileName: " + fileName);

        try {
            bufReader = UtilidadesFiles.abrirFichero(fileName);
            UtilidadesLog.info("FileWrapper.abrirArchivo(String path, String filename): Salida");
        } catch(MareException mEx) {
            UtilidadesLog.info("FileWrapper.abrirArchivo(String path, String filename): Salida");
            throw new MareException(mEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
        
        
    }

    private String leerLinea() throws MareException {
        UtilidadesLog.info("FileWrapper.leerLinea(): Entrada");

        if (bufReader!= null) { 
            try {
                // leo la linea
                String linea = bufReader.readLine();
                UtilidadesLog.debug("************* linea " + linea);
                // incremento contador de registros procesados
                regProcesados = new Long(((Long)regProcesados).longValue()+1);
                UtilidadesLog.debug("************* regProcesados " + regProcesados);
                UtilidadesLog.info("FileWrapper.leerLinea(): Salida");
                // retorno la linea
                return linea;
            }catch(FileNotFoundException fne){
                throw new MareException(fne,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            }catch(IOException ioe){
                throw new MareException(ioe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            }
        } 
        else {
            UtilidadesLog.debug("************* bufReader es null");
            UtilidadesLog.info("FileWrapper.leerLinea(): Salida");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }
    }



    public void cerrarArchivo() throws MareException
    {
        UtilidadesLog.info("FileWrapper.cerrarArchivo(): Entrada");
        
        if (this.idFile != null )
            this.idFile = null;

        /*
         * dnh 20/11/2003
         * cierro el  BuferedREader global
         */
        if ( bufReader != null ){
            try{
                bufReader.close();
                UtilidadesLog.info("FileWrapper.cerrarArchivo(): Salida");
            }catch(IOException ioe){
                throw new MareException(ioe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }
        }         
    }

    /*
     * dnh 20/11/2003
     */
    public Object leerRegistro() throws MareException {
        UtilidadesLog.info("FileWrapper.leerRegistro(): Entrada");
        Vector retorno = new Vector();
        String linea;
        
        /*
         * cargo en un collection la cantidad de lineas
         * q corresponden a la cabecera del archivo
         */

        UtilidadesLog.debug("********** cant_lineas_registro " + cant_lineas_registro);
        
        for (int i=1; i<=cant_lineas_registro;i++) {
            UtilidadesLog.debug("************ Entro al for " + i);
            if ((linea = leerLinea())!=null && ( linea.trim().length() > 0 )) {
                UtilidadesLog.debug("************* linea = leerLinea es distinto de null , blancos, tabs o enter");
                retorno.add(linea);
            }
        }

        /*
         * Valido que no me haya quedado un registro incompleto (el ultimo)
         */
        if ((retorno.size() > 0) && (retorno.size() < cant_lineas_registro)) {
            UtilidadesLog.debug("******* Entro al if - lanza una MareException");
            throw new MareException();
        }     

        Object regProcesado = parseRegistro(retorno);

        /*
         * Si es <> de null -> lo proceso
         */
        if (regProcesado!=null) {
            incRegistroProcesados();
        }

        UtilidadesLog.debug("******* regProcesado " + regProcesado);
        UtilidadesLog.info("FileWrapper.leerRegistro(): Salida");
        return regProcesado;
    }

    public Object leerCabecera() throws MareException {
        UtilidadesLog.info("FileWrapper.leerCabecera(): Entrada");
        Vector retorno = new Vector();
        String linea;
        
        /*
         * cargo en un collection la cantidad de lineas
         * q corresponden a la cabecera del archivo
         */
         
        UtilidadesLog.debug("************** cant_lineas_cabecera " + cant_lineas_cabecera);

        for (int i=1; i<=cant_lineas_cabecera;i++) {
            UtilidadesLog.debug("************** Llamando a leerLinea " + i);
            linea = leerLinea();
            //Se aniade al vector por mas que la linea sea nula o vacia
            retorno.add(linea);
        }

         /*
         * Valido que no me haya quedado un registro incompleto (el ultimo)
         */
        if ((retorno.size() > 0) && (retorno.size() < cant_lineas_cabecera)) {
            UtilidadesLog.debug("************** retorno-size es mayor a cero, retorno-size es menor que cant_lineas_cabecera");
            UtilidadesLog.debug("************** Se lanza una MareException");
            UtilidadesLog.info("FileWrapper.leerCabecera(): Salida");
            throw new MareException();
        }           
        
        UtilidadesLog.info("FileWrapper.leerCabecera(): Salida");
        return parseCabecera(retorno);
    }
    
    public abstract Object parseCabecera(Collection  cab) throws MareException;
    public abstract Object parseRegistro(Collection reg) throws MareException;

    protected void finalize() throws Throwable {
        UtilidadesLog.info("FileWrapper.finalize(): Entrada");
        cerrarArchivo();
        UtilidadesLog.info("FileWrapper.finalize(): Salida");
    }

    private void incRegistroProcesados() {
        UtilidadesLog.info("FileWrapper.incRegistroProcesados(): Entrada");
        regProcesados = new Long(((Long)regProcesados).longValue()+1);
        UtilidadesLog.info("FileWrapper.incRegistroProcesados(): Salida");
    }
}