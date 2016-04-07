/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
//import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.NumberFormat;

public class Redondear {
    private Redondear(){
    }
    private static NumberFormat nf;
      
    public synchronized static Float redondearFloat(Float flotante, Integer numeroDecimales) throws MareException{
        //UtilidadesLog.info("Redondear.redondearFloat(Float flotante, Integer numeroDecimales): Entrada");
        Float retornoFloat = null;
        
        if(nf== null){
           nf = NumberFormat.getInstance(java.util.Locale.US);
           nf.setGroupingUsed(false);
        }
            
        if(flotante == null){
            flotante = new Float(0);
        }
            
        try{
            nf.setMaximumFractionDigits(numeroDecimales.intValue());
            String  retorno = ( (nf.format(flotante)).toString());
            retornoFloat = new Float(retorno);
            //retornoFloat = new Float(Math.round(retornoFloat.floatValue()));
        }catch(Exception e){
            UtilidadesLog.error("*** Excepcion en redondearFloat ***",e);
            throw new MareException(e);//,UtilidadesError.armarCodigoError(e.getMessage()));
        }
        //UtilidadesLog.info("Redondear.redondearFloat(Float flotante, Integer numeroDecimales): Salida");
        return retornoFloat;  
    }

}