
/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.Contexto;
import es.indra.druida.DruidaBase;

import es.indra.druida.parser.ParserBase;

import es.indra.druida.util.MultipartRequest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



import java.util.StringTokenizer;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Sistema:          Belcorp - SICC
 * Modulo:           GLOBAL
 * Componente:       LPObjetoFicheroUpload
 * Fecha:            28/07/2003
 * Dcoumentacion:    Este componente se construyó descompilando la clase de Druida ObjetoFichero
 *                   e implementando la nueva funcionalidad, que es renombrar el archivo subido con
 *                   un nombre unico.
 *
 * @version          1.0
 * @author           Diego Grigna
 */ 

public class LPObjetoFicheroUpload extends DruidaBase {
    private String strDirTemp;
    private String strDirDest;
    private String strFichero;
    private File oFiche;

    public LPObjetoFicheroUpload() throws Exception {
		setTrazaFichero();
		System.out.println("LPObjetoFicheroUpload, inicio ....SCS1");
        strDirTemp = new String();
        strDirDest = null;
        strFichero = "archivoPrincipal";
        strDirTemp = Contexto.getPropiedad("TMP.UPLOAD");
        try	{
            strDirDest = Contexto.getPropiedad("TMP.UPLOAD2");
        } catch(Exception e) {
            strDirDest = strDirTemp;
        }
    }

    public void inicio() throws Exception {
        setParsear();
		setTrazaFichero();
		System.out.println("LPObjetoFicheroUpload, inicio ....SCS2");
    }

    public void ejecucion() throws Exception {
        System.out.println("LPObjetoFicheroUpload, inicio ....SCS3_v"); 		
        String s = "";
        String fileName = "";
        String fsName = "";
        boolean bComprimir = false;
        boolean bDescomprimir = false;
        
        try {
            String comprimirStr = conectorParametro("comprimir");
            String descomprimirStr = conectorParametro("descomprimir");
            String drPathStr = conectorParametro("drpath");
            
            if(comprimirStr != null && comprimirStr.toUpperCase()
               .equals("SI")) {
                bComprimir = true;
            }
            if(descomprimirStr != null && descomprimirStr.toUpperCase()
               .equals("SI")) {
                bDescomprimir = true;
            }
            if(drPathStr != null && drPathStr.trim().length() > 0) {
                strDirDest += File.separator + drPathStr;
            }

           System.out.println("LPObjetoFicheroUpload, inicio ....v2"); 	
            
           MultipartRequest multipartRequest = new
                    MultipartRequest(
                            getRequest(), 
                            strDirTemp, 
                            strDirDest,
                            0x6a000000,
                            bComprimir,
                            bDescomprimir);
            
            if(multipartRequest.getParameter("comprimir") != null 
				&& multipartRequest.getParameter("comprimir").toUpperCase().equals("SI")) 
			{
               multipartRequest.setComprimir(true);
            }
            
            if(multipartRequest.getParameter("descomprimir") != null &&
               multipartRequest.getParameter("descomprimir").toUpperCase()
               .equals("SI")) {
               multipartRequest.setDescomprimir(true);
            }

		    System.out.println("LPObjetoFicheroUpload, inicio ....v3"); 	 

            fsName   = multipartRequest.getFilesystemName(strFichero);
            fileName = multipartRequest.getParameter("fichero_nombre");

            String pathInicial = strDirTemp;
            String nombreInicial = fsName;
            String Separador = File.separator;
            String identificador = fechaHora();
            String pathFinal = strDirDest;

            System.out.println("LPObjetoFicheroUpload, inicio ....v4"); 	 
            File archivo = new File(pathInicial + Separador + nombreInicial);
            FileInputStream entrada = new FileInputStream(archivo);

				System.out.println("Archivo inicial: "+pathInicial + Separador + nombreInicial);

            StringTokenizer tok = new StringTokenizer(archivo.getName(),".");
            StringBuffer buf = new StringBuffer();

            int cantidadTok = tok.countTokens();
            int posicion = 1;
            if(cantidadTok == 1){
               buf.append(tok.nextToken());
               buf.append(identificador);
            }else{
               while(tok.hasMoreTokens()){
                  buf.append(tok.nextToken());
                  if(posicion == cantidadTok-1){
                     buf.append(identificador);
                  }
                  if(tok.hasMoreTokens()){
                     buf.append(".");
                  }
                  posicion++;
               }            
            }

            fsName = buf.toString();

			// vbongiov - Inc 21588
            fsName = eliminaBlancos(fsName);
         
            FileOutputStream salida = new FileOutputStream(pathFinal + Separador + fsName);
            
				System.out.println("Archivo final: "+pathFinal + Separador + fsName);

            int largo = entrada.available();
            byte[] buffer = new byte[largo];
            entrada.read(buffer);
            salida.write(buffer);
            salida.getFD().sync();
        } catch(Exception e) {
            traza("********************************************************************************");
            traza("********************************************************************************");
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("EL STACK ES COMO SIGUE : " + pila.toString());
            traza("********************************************************************************");
            traza("********************************************************************************");
        }
        String opener = "opener." + fileName + ".onload('" + s + "',getValorFic())";
        
//      String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>";
        String xml =
              "<PAGINA onload=\"" + opener + "\">" +
              "<SCRIPT>" +
              "<![CDATA[ function getValorFic(){return '" + fsName + "';} ]]>" +
              "</SCRIPT>" +
              "</PAGINA>";
        
        org.w3c.dom.Document document = getParser().convierte(xml);

		System.out.println("antes de: setXML");
        setXML( document);
		System.out.println("luego de: setXML");
    }

	private String fechaHora() throws Exception {
		

        Date fecha = new java.util.Date(System.currentTimeMillis());

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd 'at' HH:mm:ss");
        
        String dateString = formatter.format(fecha);

        String anio = dateString.substring(0,4);       
        String mes  = dateString.substring(5,7);
        String dia = dateString.substring(8,10);

        int index = dateString.indexOf(":");

        String hora = dateString.substring((index-2),index);        
        String minutos  = dateString.substring((index+1),(index+3));
        String segundos = dateString.substring((index+4),(index+6));

        String fechaHora = dia + mes + anio + hora + minutos + segundos;


		//return  fileName.substring(0,sep) + fechaHora + fileName.substring(sep);
		return  fechaHora ;
	}


	 // vbongiov - Inc 21588
	 public String eliminaBlancos(String s) {

		  int k = s.length();
		  String a = "";
		  StringBuffer stringbuffer = new StringBuffer();

		  for(int i=0; i<k; i++){
				   a=s.substring(i,i+1);

				   if(!a.equals(" ")){
							stringbuffer.append(a);
				   } 
		  }	

		  return stringbuffer.toString();
	 }

}
