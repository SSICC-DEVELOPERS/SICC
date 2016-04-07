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

import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Comparator;

public class ComparadorPosicionesOrigen implements Comparator {

    public ComparadorPosicionesOrigen()
    {
    }
    
   /**
   * @Autor ssaavedr
   * @return int
   * @param o2
   * @param o1
   */
      public int compare(Object o1, Object o2){
        UtilidadesLog.info("ComparadorSolicitud.compare(Object o1, Object o2): Entrada");
          
        try{
            DTOPosicionSolicitud p1 = (DTOPosicionSolicitud)o1; 
            DTOPosicionSolicitud p2 = (DTOPosicionSolicitud)o2;
            
            int codVta1 = (p1.getCodigoVenta() != null)?Long.valueOf(p1.getCodigoVenta().trim()).intValue():0;
            int codVta2 = (p2.getCodigoVenta() != null)?Long.valueOf(p2.getCodigoVenta().trim()).intValue():0;
                        
            int unidAten1 = (p1.getUnidadesAtendidas() != null)?p1.getUnidadesAtendidas().intValue():0;
            int unidAten2 = (p2.getUnidadesAtendidas() != null)?p2.getUnidadesAtendidas().intValue():0;
           
            int oidSoliPosi1 = (p1.getOidPosicionSolicitud()!=null)?p1.getOidPosicionSolicitud().intValue():0;
            int oidSoliPosi2 = (p2.getOidPosicionSolicitud()!=null)?p2.getOidPosicionSolicitud().intValue():0;
            
            UtilidadesLog.info("ComparadorSolicitud.compare(Object o1, Object o2): Salida");
            if(codVta1 < codVta2) {
              return -1; 
            } else if(codVta1 > codVta2) {
              return 1; 
            } else if(codVta1 == codVta2) { 
              if(unidAten1 < unidAten2) {
                return -1; 
              } else if(unidAten1 > unidAten2) {
                return 1; 
              } else if(unidAten1 == unidAten2) { 
                if(oidSoliPosi1 < oidSoliPosi2) {
                  return -1; 
                } else if(oidSoliPosi1 > oidSoliPosi2) {
                  return 1;                   
                } else if(oidSoliPosi1 == oidSoliPosi2) {
                  return 0; 
                }
              } 
            } 
            return 0;
        }catch (Exception e){
            UtilidadesLog.error(e);
            return 0;
        }
    }
}    
