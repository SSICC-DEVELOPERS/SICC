package es.indra.sicc.logicanegocio.zon;

//JAVA Files
import es.indra.sicc.util.UtilidadesLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

//ZON
import es.indra.sicc.dtos.zon.DTORezonificacionCabecera;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
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

public class RezonificacionFileWrapper extends FileWrapper  {

    private final String SEPARATOR = ";";
    private final String FORMAT_DATE = "yyyy-MM-dd";
    private final String FORMATO_FECHA_ARCHIVO = "yyyyMMdd";
    private BufferedReader reader;        
   // private int  CANTIDAD_LINEAS_CABECERA;
   // private int  CANTIDAD_LINEAS_REGISTRO;
    private static int CANT_COLS_REGISTRO_ALTA = 9;	
    private static int CANT_COLS_REGISTRO_BAJA = 2;	
    
    public RezonificacionFileWrapper() {  
            super();
            UtilidadesLog.info("RezonificacionFileWrapper(): Entrada");
            cant_lineas_cabecera = 7;
            cant_lineas_registro = 1;
            UtilidadesLog.info("RezonificacionFileWrapper(): Salida");
    }
    
    public RezonificacionFileWrapper(String path, String filename) throws MareException {
            super();
            UtilidadesLog.info("RezonificacionFileWrapper(String path, String filename): Entrada");
            cant_lineas_cabecera = 7;
            cant_lineas_registro = 1;
            abrirArchivo(path,filename);
            UtilidadesLog.info("RezonificacionFileWrapper(String path, String filename): Salida");
    }
  
    private Date toDate(String date) throws MareException {
        UtilidadesLog.info("toDate(String date): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA_ARCHIVO);     // yyyyMMdd
        Date fechaSalida;

        try {
            fechaSalida = sdf.parse(date); // Parsea el String y convierte a java.util.Date
            
        } catch (ParseException pe) {
            UtilidadesLog.error("El formato de Fecha debe ser: " + FORMATO_FECHA_ARCHIVO);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
        }
        
        // Control de la conversion realizada: para ello validamos que la fecha
        // obtenida al pasarla a String coincida con la entrada
        if ( !date.equals(sdf.format(fechaSalida)) ) {
            UtilidadesLog.debug("La conversion no es correcta, formato Fecha debe ser: " + FORMATO_FECHA_ARCHIVO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
        }
        UtilidadesLog.debug("Fecha: " + date + " --> " + fechaSalida);
        UtilidadesLog.info("toDate(String date): Salida");
        return fechaSalida;       
    }

    private Date normalizarHoras(Date fecha) throws ParseException {
        UtilidadesLog.info("RezonificacionFileWrapper.normalizarHoras(Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);              
        String strFecha = sdf.format(fecha); 
        UtilidadesLog.info("RezonificacionFileWrapper.normalizarHoras(Date fecha): Salida");
        return sdf.parse(strFecha);
    }

    public Object parseRegistro(Collection reg)  throws MareException {
      UtilidadesLog.info("RezonificacionFileWrapper.parseRegistro(Collection reg): Entrada");
/*
// Este método se utiliza para leer un registro del fichero 
// La estructura del registro es la siguiente: Tipo operación;Dato1;Cliente;Dato2;Dato3;Dato4;Dato5 

Crea un DTORezonificacionRegistro y lo rellena con la información recuperada de la siguiente forma: 
- tipoOp = Tipo operacion 
- datoOrigen1 = Dato1 
- codCliente = Cliente 
- datoOrigen2 = Dato2 
- datoNuevo = Dato3 
- nse1 = Dato4 
- nse2 = Dato5 

Devuelve DTORezonificacionRegistro 
 * */
    DTORezonificacionRegistro dto = new DTORezonificacionRegistro();
        StringTokenizer stk;

        if ((reg != null) && (reg.size()==0)) {
           return null;
        } else {
           String linea =  (String)((Vector)reg).get(0);         

           if (!linea.equals("")) {
               if (linea.charAt(linea.length()-1)==';') {
                 linea = linea + " ";  
               } 
           } else {
				throw new MareException(null, null,
				  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
           }

           linea = replace(linea,";;","; ;");
            
           stk = new StringTokenizer(linea, this.SEPARATOR);
/* ¿No hay que tener esto en cuenta?
 * Dependiendo de cada tipo de operación que se reciba se deben llenar los campos del DTORezonificacionRegistro de la siguiente manera: 


TIPO DE OPERACION: P (PARTICION) 
dto.tipoOP="P" 
dto.DatoOrigen1=DATO1 
dto.Cliente=CLIENTE 
dto.DatoNuevo=DATO2 
dto.NSE1=DATO4 
dto.NSE2=DATO5 
dto.Desc=DATO7 

TIPO DE OPERACION: F (FUSIONES) 
dto.tipoOP="F" 
dto.DatoOrigen1=DATO1 
dto.DatoOrigen2=DATO2 
dto.DatoNuevo=DATO3 
dto.NSE1=DATO4 
dto.NSE2=DATO5 
dto.Desc=DATO7 

TIPO DE OPERACION: T (TRASVASE) 
dto.tipoOP="T" 
dto.DatoOrigen1=DATO1 
dto.Cliente=CLIENTE 
dto.DatoNuevo=DATO2 

 */
           if (stk.countTokens() == this.CANT_COLS_REGISTRO_ALTA) {
               dto.setTipoOp(stk.nextToken());
               dto.setDatoOrigen1(stk.nextToken());
               dto.setCodCliente(stk.nextToken());
               dto.setDatoOrigen2(stk.nextToken());
               dto.setDatoNuevo(stk.nextToken());
               dto.setNse1(stk.nextToken());
               dto.setNse2(stk.nextToken());
               // INC 21886 - dmorello, 16/12/2005
               // Se toma también la descripción, salteando un token para llegar a la misma.
               stk.nextToken();
               String desc = stk.nextToken();
               UtilidadesLog.debug("Descripción recuperada en parseRegistro(): " + desc);
               dto.setDesc(desc);
               UtilidadesLog.debug("Quedan más tokens: " + stk.hasMoreTokens());

				
            } else {
                UtilidadesLog.info("RezonificacionFileWrapper.parseRegistro(Collection reg): Salida");
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
            }
           UtilidadesLog.info("RezonificacionFileWrapper.parseRegistro(Collection reg): Salida");
           return dto;
        }
    }




    /* La cabecera va a contener, representado por los códigos asociados a cada tipo: 
        Pais 
        Marca (Puede tener el requisito general "TODOS", representado por un "*") 
        Canal 
        Tipo de Periodo 
        Periodo de Inicio 
        Fecha de actualizacion 
        Fecha de creación en el GIS.
        Cada campo en una linea del archivo
    * */
    public Object parseCabecera(Collection  cab) throws MareException {
            UtilidadesLog.info("RezonificacionFileWrapper.parseCabecera(Collection  cab): Entrada");
            
            Iterator it = cab.iterator();
            String line = null;
            DTORezonificacionCabecera result = new DTORezonificacionCabecera();

            String pais               = (String) it.next();
            String marca              = (String) it.next();
            String canal              = (String) it.next();  
            String tipoPeriodo        = (String) it.next();
            String periodoInicio      = (String) it.next();
            String fechaActualizacion = (String) it.next();
            String fechaCreacionGIS   = (String) it.next();
            
            java.util.Date dateFA1 = toDate(fechaActualizacion);                
            java.sql.Date dateFA =   new java.sql.Date(dateFA1.getTime());
              
            // vbongiov -- 29/10/2007
            java.sql.Date dateFC = null;  
            if(!fechaCreacionGIS.equals("")) {
                java.util.Date dateFC1 = toDate(fechaCreacionGIS);
                dateFC = new java.sql.Date(dateFC1.getTime());
            }

            result.setCodPais(pais);
            result.setCodMarca(marca);
            result.setCodCanal(canal);
            result.setTipoPeriodo(tipoPeriodo);
            result.setPeriodoInicio(periodoInicio);
            result.setFechaActualizacion(dateFA);
            result.setFechaCreacionGIS(dateFC);
            
            UtilidadesLog.info("RezonificacionFileWrapper.parseCabecera(Collection  cab): Salida");
            return result;                        
    }

    public static String replace(String s, String s1, String s2) {
        UtilidadesLog.info("RezonificacionFileWrapper.replace(String s, String s1, String s2): Entrada");
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
		while ((j = s.indexOf(s1, i)) >= 0) {
			if(stringbuffer == null) {
				stringbuffer = new StringBuffer(s.length() * 2);
			}
			stringbuffer.append(s.substring(i, j));
			stringbuffer.append(s2);
			i = j + k - 1;
		}
		if (i != 0) {
			stringbuffer.append(s.substring(i));
			s3 = stringbuffer.toString();
		}
        UtilidadesLog.info("RezonificacionFileWrapper.replace(String s, String s1, String s2): Salida");
        return s3;
    }


}  