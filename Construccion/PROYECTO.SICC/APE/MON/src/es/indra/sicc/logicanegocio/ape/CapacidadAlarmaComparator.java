/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 * vbongiov -- BELC400000567 -- 13/07/2007
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.dtos.ape.DTOTipoCajaEmbalaje;
import java.util.Comparator;

public class CapacidadAlarmaComparator implements Comparator {
  public CapacidadAlarmaComparator() {
  }
  
  public int compare(Object o1, Object o2) {
    DTOTipoCajaEmbalaje u1 = (DTOTipoCajaEmbalaje) o1;
    DTOTipoCajaEmbalaje u2 = (DTOTipoCajaEmbalaje) o2;
    
     if(u1.getCapacidad().compareTo(u2.getCapacidad())!=0){
        return (-1)*(u1.getCapacidad().compareTo(u2.getCapacidad()));
    } else {
        return (-1)*(u1.getCapacidadMinima().compareTo(u2.getCapacidadMinima()));
    }
  }

  public boolean equals(Object o) {
    return this == o;
  }
}