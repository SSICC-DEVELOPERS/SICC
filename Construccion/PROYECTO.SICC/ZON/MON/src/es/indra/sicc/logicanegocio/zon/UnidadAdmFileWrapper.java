package es.indra.sicc.logicanegocio.zon;

//JAVA Files
import es.indra.sicc.util.UtilidadesLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

//ZON
import es.indra.sicc.dtos.zon.DTOUnidadAdmCabecera;
import es.indra.sicc.dtos.zon.DTOUnidadAdmRegistro;
import java.io.FileNotFoundException;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.zon.ErroresDeNegocio;

//Mare
import es.indra.mare.common.exception.MareException;

//JAVA UTIL
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Collection;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Iterator;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            ZON - Zonificacion
 * Componente:        UnidadAdmFileWrapper
 * Fecha:             20/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Fernando Laffaye
 */ 

public class UnidadAdmFileWrapper extends FileWrapper  {

    private final String SEPARATOR = ";";
    private final String FORMAT_DATE = "yyyy-MM-dd";
    private BufferedReader reader;        
    private int  CANTIDAD_LINEAS_CABECERA;
    private int  CANTIDAD_LINEAS_REGISTRO;
    private static int CANT_COLS_REGISTRO_ALTA = 9;	
    private static int CANT_COLS_REGISTRO_BAJA = 2;	
    
    public UnidadAdmFileWrapper() {  
            super();
            UtilidadesLog.info("UnidadAdmFileWrapper(): Entrada");
            cant_lineas_cabecera = 7;
            cant_lineas_registro = 1;
            UtilidadesLog.info("UnidadAdmFileWrapper(): Salida");
    }
    
    public UnidadAdmFileWrapper(String path, String filename)
    throws MareException
    {
            UtilidadesLog.info("UnidadAdmFileWrapper(String path, String filename): Entrada");
            cant_lineas_cabecera = 7;
            cant_lineas_registro = 1;
            abrirArchivo(path,filename);
            UtilidadesLog.info("UnidadAdmFileWrapper(String path, String filename)): Salida");
    }
  
    private Date toDate(String date) 
        throws MareException
    {
        UtilidadesLog.info("UnidadAdmFileWrapper.toDate(String date): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        
        String anio = date.substring(0,4);
        String mes  = date.substring(4,6);
        String dia = date.substring(6,8);

        try {
            Date d = sdf.parse(anio+"-"+mes+"-"+dia);
            //Date db = new Date(normalizarHoras(d).getTime() + 1000*60*60*12);
            UtilidadesLog.info("UnidadAdmFileWrapper.toDate(String date): Salida");
            return d;       
        } catch (ParseException pe) {
            throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
        }	 
    }

    private Date normalizarHoras(Date fecha) throws ParseException {
        UtilidadesLog.info("UnidadAdmFileWrapper.normalizarHoras(Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);              
        String strFecha = sdf.format(fecha); 
        UtilidadesLog.info("UnidadAdmFileWrapper.normalizarHoras(Date fecha): Salida");
        return sdf.parse(strFecha);
    }

    /*
     * dnh 20/11
     */
    public Object parseRegistro(Collection reg) 
    throws MareException {
        UtilidadesLog.info("UnidadAdmFileWrapper.parseRegistro(Collection reg): Entrada");
        
        DTOUnidadAdmRegistro dto = new DTOUnidadAdmRegistro();
        StringTokenizer stk;

        if ((reg != null) && (reg.size()==0)) {
           return null;
        } else {
           String linea =  (String)((Vector)reg).get(0);         

           if (!linea.equals("")) {
               if (linea.charAt(linea.length()-1)==';') {
                 linea = linea + " ";  
               } 
           }else {
				throw new MareException(null, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
           }

           UtilidadesLog.debug("linea: " + linea);
           //UtilidadesLog.debug("antes rep:" + linea);
           // dmorello, 16/06/2006: Se hace el replace al instanciar el Tokenizer
           //linea= replace(linea,";;","; ;");
           //UtilidadesLog.debug("desp rep:" + linea);
            
           // dmorello, 16/06/2006: El replace pasa a hacerse directamente acá
           stk = new StringTokenizer(replace(linea,";;","; ;"),this.SEPARATOR);
           UtilidadesLog.debug("stk.countTokens(): " +stk.countTokens());
           
           if (stk.countTokens() == this.CANT_COLS_REGISTRO_ALTA) {
               dto.setTipoOP(stk.nextToken());
               dto.setDato1(stk.nextToken());
               dto.setCliente(stk.nextToken());
               dto.setDato2(stk.nextToken());
               dto.setDato3(stk.nextToken());
               dto.setDato4(stk.nextToken());
               dto.setDato5(stk.nextToken());
               dto.setDato6(stk.nextToken());
               dto.setDato7(stk.nextToken());

				
            } else if (stk.countTokens() == this.CANT_COLS_REGISTRO_BAJA) {
               dto.setTipoOP(stk.nextToken());
               dto.setDato1(stk.nextToken());
			} else {
        UtilidadesLog.info("UnidadAdmFileWrapper.parseRegistro(Collection reg): Salida");
                // dmorello, 16/06/2006: En el message de la excepción irá el registro erróneo
				throw new MareException(linea, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
            }
          UtilidadesLog.info("UnidadAdmFileWrapper.parseRegistro(Collection reg): Salida");
           return dto;
        }
    }



    /* Este metodo se encarga de leer las lineas que representan las cabeceras del archivo.
    *  Las mismas son: Pais,Marca,Canal,Tipo Periodo,Periodo Inicio,FechaActualizacion,FechaCreacionGIS
    *  Cada campo en una linea del archivo.
    * */
    public Object parseCabecera(Collection  cab) 
        throws MareException
    {
            UtilidadesLog.info("UnidadAdmFileWrapper.parseCabecera(Collection  cab): Entrada");
            
            Iterator it = cab.iterator();
            String line = null;
            DTOUnidadAdmCabecera result = new DTOUnidadAdmCabecera();

            String pais               = (String) it.next();
            String marca              = (String) it.next();
            String canal              = (String) it.next();  
            String tipoPeriodo        = (String) it.next();
            String periodoInicio      = (String) it.next();
            String fechaActualizacion = (String) it.next();
            String fechaCreacionGIS   = (String) it.next();
            
            java.util.Date dateFA1 = toDate(fechaActualizacion);                
            java.sql.Date dateFA =   new java.sql.Date(dateFA1.getTime());
              
            java.util.Date dateFC1 = toDate(fechaCreacionGIS);
            java.sql.Date dateFC = new java.sql.Date(dateFC1.getTime());

            result.setPais(pais);
            result.setMarca(marca);
            result.setCanal(canal);
            result.setTipoPeriodo(tipoPeriodo);
            result.setPeriodoInicio(periodoInicio);
            result.setFechaActualizacion(dateFA);
            result.setFechaCreacionGIS(dateFC);
            
            UtilidadesLog.info("UnidadAdmFileWrapper.parseCabecera(Collection  cab): Salida");
            return result;                        
    }

    public static String replace(String s, String s1, String s2)
    {
        UtilidadesLog.info("UnidadAdmFileWrapper.replace(String s, String s1, String s2): Entrada");
        
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
    
        UtilidadesLog.info("UnidadAdmFileWrapper.replace(String s, String s1, String s2): Salida");
        return s3;
    }

}    