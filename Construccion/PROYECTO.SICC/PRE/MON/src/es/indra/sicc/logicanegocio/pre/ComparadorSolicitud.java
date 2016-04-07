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
package es.indra.sicc.logicanegocio.pre;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Comparator;

/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class ComparadorSolicitud implements Comparator {

    public ComparadorSolicitud() {
    }
   
   /**
   * @Autor Cortaberria
   * @return int
   * @param o2
   * @param o1
   */
      public int compare(Object o1, Object o2){
        UtilidadesLog.info("ComparadorSolicitud.compare(Object o1, Object o2): Entrada");
          
        try{
            DTOPosicionSolicitud p1 = (DTOPosicionSolicitud)o1; 
            DTOPosicionSolicitud p2 = (DTOPosicionSolicitud)o2;
            //suponemos que la solicitud siempre tiene numero oferta y grupo

            //jrivas 21/3/2006 Como el Numero de oferta se repite se ordena por OID.
            //int oferta1 = p1.getNumeroOferta().intValue();
            //int oferta2 = p2.getNumeroOferta().intValue();
            int oferta1 = p1.getOidOferta().intValue();
            int oferta2 = p2.getOidOferta().intValue();
                        
            int detalle1 = (p1.getOidDetalleOferta() != null)?p1.getOidDetalleOferta().intValue():0;
            int detalle2 = (p2.getOidDetalleOferta() != null)?p2.getOidDetalleOferta().intValue():0;
           
            int grupo1 = (p1.getGrupo()!=null)?p1.getGrupo().intValue():0;
            int grupo2 = (p2.getGrupo()!=null)?p2.getGrupo().intValue():0;
            
            UtilidadesLog.info("ComparadorSolicitud.compare(Object o1, Object o2): Salida");
            if(oferta1 < oferta2) {
              return -1; 
            } else if(oferta1 > oferta2) {
              return 1; 
            } else if(oferta1 == oferta2) { 
              if(grupo1 < grupo2) {
                return -1; 
              } else if(grupo1 > grupo2) {
                return 1; 
              } else if(grupo1 == grupo2) { 
                if(detalle1 < detalle2) {
                  return -1; 
                } else if(detalle1 > detalle2) {
                  return 1;                   
                } else if(detalle1 == detalle2) {
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