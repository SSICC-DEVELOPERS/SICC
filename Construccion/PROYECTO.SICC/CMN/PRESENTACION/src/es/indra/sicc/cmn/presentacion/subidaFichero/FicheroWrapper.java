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
package es.indra.sicc.cmn.presentacion.subidaFichero;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Collection;
import java.util.Vector;


public abstract class FicheroWrapper {
    public Object numRegistros;
    public Object regProcesados = new Long(0);
    protected BufferedReader bufReader;
    protected File idFile;
    protected int cant_lineas_cabecera = 0;
    protected int cant_lineas_registro = 0;

    public FicheroWrapper() {}

    /*
     * Actualmente realiza funciones de chequeo del archivo.
     * */
    public void abrirArchivo(String path, String filename) throws MareException {
        String codigo;
        
        String fileName = path + "/" + filename;        
        try{
            bufReader = UtilidadesFiles.abrirFichero(fileName);                    
        }catch (MareException mEx){
           throw new MareException(mEx,
             UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }



       /* String codigo;
        String fileName = path + File.separator + filename;
        File file = new File(fileName);

        if (file.exists()) {
            if (file.canRead()) {
                if (file.isFile()) {
                    idFile = file;

                    try {
                        FileReader fr = new FileReader(idFile);
                        bufReader = new BufferedReader(fr);
                    } catch (FileNotFoundException fe) {
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
                    }
                } else {
                    codigo = CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO;
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigo));
                }
            } else {
                codigo = CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO;
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigo));
            }
        } else {
            codigo = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigo));
        }*/
    }

    private String leerLinea() throws MareException {
        if (bufReader != null) {
            try {
                // leo la linea
                String linea = bufReader.readLine();

                // incremento contador de registros procesados
                regProcesados = new Long(((Long) regProcesados).longValue() + 1);

                // retorno la linea
                return linea;
            } catch (FileNotFoundException fne) {
                throw new MareException(fne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            } catch (IOException ioe) {
                throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            }
        } else {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }
    }

    public void cerrarArchivo() throws MareException {
        if (this.idFile != null) {
            this.idFile = null;
        }

        if (bufReader != null) {
            try {
                bufReader.close();
            } catch (IOException ioe) {
                throw new MareException(ioe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }

            ;
        }
    }

    public Object leerRegistro() throws MareException {
        Vector retorno = new Vector();
        String linea;
        
        /*
         * cargo en un collection la cantidad de lineas
         * q corresponden a la cabecera del archivo
         */
        for (int i=1; i<=cant_lineas_registro;i++) {
            if ((linea = leerLinea())!=null) {
                retorno.add(linea);
            }
        }

        /*
         * Valido que no me haya quedado un registro incompleto (el ultimo)
         */
        if ((retorno.size() > 0) && (retorno.size() < cant_lineas_registro)) {
            throw new MareException();
        }     
            

        /*
         * Si es <> de null -> lo proceso
         */
         
        Object regProcesado;
        
        if(retorno.size() > 0){
            regProcesado = parseRegistro(retorno);
    
            if (regProcesado!=null) {
                incRegistroProcesados();
            }
        }else{
           regProcesado = null;
        
        }
        
        return regProcesado;
    }

    public Object leerCabecera() throws MareException {
        Vector retorno = new Vector();
        String linea;
        /*
         * cargo en un collection la cantidad de lineas
         * q corresponden a la cabecera del archivo
         */
        for (int i=1; i<=cant_lineas_cabecera;i++) {
            linea = leerLinea();
            if (linea!=null && !linea.equals("")) {
                retorno.add(linea);
            } else {
                /*
                 * si uno de las lineas  de la cabecera es nula tiramos exception 
                 */
                throw new MareException();         
            }
        }

         /*
         * Valido que no me haya quedado un registro incompleto (el ultimo)
         */
        if ((retorno.size() > 0) && (retorno.size() < cant_lineas_cabecera)) {
            throw new MareException();
        }           
        return parseCabecera(retorno);
    }
	
    public abstract Object parseCabecera(Collection cab) throws MareException;

    public abstract Object parseRegistro(Collection reg) throws MareException;

    protected void finalize() throws Throwable {
        cerrarArchivo();
    }

    private void incRegistroProcesados() {
        regProcesados = new Long(((Long) regProcesados).longValue() + 1);
        ;
    }
}
