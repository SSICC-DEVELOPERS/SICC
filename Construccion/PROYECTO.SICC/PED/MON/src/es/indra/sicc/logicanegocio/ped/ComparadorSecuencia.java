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
 *
 */
 
package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Comparator;

import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
/**
 * @version 1.0 - 04 Abr 2006
 * @author SCS
 */ 

public class ComparadorSecuencia implements Comparator  
{
    public ComparadorSecuencia()
    {
    }

   /**
   * @Autor SCS
   * @return int
   * @param o2
   * @param o1
   */
      public int compare(Object o1, Object o2){
        UtilidadesLog.info("ComparadorSecuencia.compare(Object o1, Object o2): Entrada");
        
        DTOSecuenciaSolicitudes p1 = (DTOSecuenciaSolicitudes)o1; 
        DTOSecuenciaSolicitudes p2 = (DTOSecuenciaSolicitudes)o2;
        
        int secu1 = p1.getSecuencia().intValue();
        int secu2 = p2.getSecuencia().intValue();

        UtilidadesLog.info("ComparadorSecuencia.compare(Object o1, Object o2): Salida");
        
        if(secu1 < secu2) {
            return -1; 
        } else if(secu1 > secu2) {
            return 1; 
        } else if(secu1 == secu2) { 
            UtilidadesLog.debug("graviiiiisiiimoooooo, comparador de Solicitudes, compara iguales.........");
            return 0;
        }         
        
        try{
 
            return 0;
        }catch (Exception e){
            UtilidadesLog.error(e);
            return 0;
        }
        
      }    
}