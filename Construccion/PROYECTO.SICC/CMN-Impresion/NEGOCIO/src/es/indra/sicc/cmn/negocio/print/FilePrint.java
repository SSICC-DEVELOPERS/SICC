/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.print;

import es.indra.sicc.cmn.negocio.print.FileConfiguration;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.CodigosError;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import es.indra.mare.common.exception.MareException;
import java.io.IOException;
import es.indra.sicc.cmn.negocio.print.ImpressionParameters;

public class FilePrint implements PrinterSender {

	//añadido por problemas en impresion
    private  static Long numSecuencial;
    private  static String fechaSistema;
    
    private FileConfiguration configuration = new FileConfiguration();
	
    public FilePrint() {
	}
    
    static 
    {
        numSecuencial=new Long(-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date fecha =  new Date(System.currentTimeMillis());
        fechaSistema=sdf.format(fecha); 
    }
    
	public FilePrint(ImpressionParameters config) {

		//1.- Creo un objeto de tipo FileConfiguration y rellenos sus atributos 
		//ip y port usando los atributos atributo_1 y atributo_2 respectivamente 
		//del objeto ImpresionParameters que se nos pasa por cabecera
        UtilidadesLog.debug("FilePrinter Constructor");
		
		FileConfiguration fileConfigTemp = new FileConfiguration();

		fileConfigTemp.setPath(config.getAtributo_1());
		fileConfigTemp.setFilename(config.getAtributo_2());

		this.configuration = fileConfigTemp;
		
	}
    	
	public void print (byte [] buffer)throws MareException {

        UtilidadesLog.info("FilePrint.print(): Entrada");
        
		
		//RESUMEN: Genera un archivo en disco con la información de entrada

		//1.- Genera un fichero de nombre 'filename' en 'path' 
		//(filename y path son dos atirbutos del atirbuto configuration).
        String filename = this.configuration.getFilename();
        String path = this.configuration.getPath();
        String extensionFichero =null;
        //cogemos la extension del fichero
        extensionFichero = filename.substring(filename.length()-4,filename.length());
        //le quitamos la extension al fichero
        filename=filename.substring(0,filename.length()-4);
        UtilidadesLog.debug("Path: "+path);
        
        //obtenemos el secuencial y le añadimos ceros a la izquierda hasta completar
        //con 4 dígitos
        UtilidadesLog.debug("El secuencial es: "+numSecuencial);
        String secuencial = this.ponerCeros(this.getNumSecuencial());
        
        File file = null;
        String ip = null;
        try{
            ip = InetAddress.getLocalHost().getHostAddress();
        }catch(UnknownHostException ue){
            UtilidadesLog.error("*** Error en ejbCreate.openSpool",ue);
        }
        //a la ip le quitamos los puntos
        StringTokenizer str = new StringTokenizer(ip,".");
        StringBuffer strbff = new StringBuffer();
        while(str.hasMoreTokens()){
            strbff.append(str.nextToken());
        }
        ip=strbff.toString(); 
        UtilidadesLog.debug("La IP es:" +ip);
        
		
        if(filename !=null && path != null){
		
            String parametro = path.concat(filename+"_"+fechaSistema+"_"+ip+"_"
                                          +secuencial+extensionFichero);
            UtilidadesLog.debug("El parametro es:"+parametro);
            file = new File(parametro);
            try{
                file.createNewFile();
                UtilidadesLog.debug("Se creo el fichero");
            }catch(IOException ie){
                String codigoError = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;
                this.logearError("print : IOException",ie);
                throw new MareException(ie, UtilidadesError.armarCodigoError(codigoError));
            }
            UtilidadesLog.debug("***Método print: Salida");
        }
		
        try{
            UtilidadesLog.debug("Entra a escribir en el fichero");
            FileOutputStream fileStream = new FileOutputStream(file);
            if (buffer != null){
                /*for(int i=0; i<buffer.length; i++){    
                    Byte tempByte = new Byte(buffer[i]);
                    fileStream.write(tempByte.intValue());
                }*/
                fileStream.write(buffer);
            }
            fileStream.close();
            UtilidadesLog.debug("Cierra el fichero");
        }catch(IOException ie){
      			String codigoError = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;
      			this.logearError("print : IOException",ie);
      			throw new MareException(ie, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("FilePrint.print(): Salida");
	}


	private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private void logStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out,e);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		this.logearStackTrace(e);
	}
	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			UtilidadesLog.error(out,e);
			UtilidadesLog.error(pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}

    public Long getNumSecuencial()
    {
        //return numSecuencial;
        //this.numSecuencial = numSecuencial;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date fecha =  new Date(System.currentTimeMillis());
		String sFecha = sdf.format(fecha); 
        if (fechaSistema.equals(sFecha))
        {
            numSecuencial=new Long(numSecuencial.longValue()+1);
        }else
        {
            numSecuencial=new Long(0);
            fechaSistema=sFecha;
        }
        return numSecuencial;
    }
    
    //este método añade ceros a la izquierda de la variable
    //numSecuencial para formar el nombre del fichero cuando
    //al facturar se imprimen en ficheros y no por impresora
    private String ponerCeros(Long numero){
        String num = numero.toString();
        StringBuffer strbff = new StringBuffer();
        for (int i=0; i<4-num.length();++i){
            strbff.append("0");                                    
        }
        strbff.append(num);
        return strbff.toString();

    }


}