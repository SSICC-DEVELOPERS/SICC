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
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.dtos.ape.DTOVolumenProducto;
import java.util.Comparator;

public class VolumenComparator implements Comparator {
  public VolumenComparator() {
  }
  
  public int compare(Object o1, Object o2) {
    DTOVolumenProducto u1 = (DTOVolumenProducto) o1;
    DTOVolumenProducto u2 = (DTOVolumenProducto) o2;
    
    if(u1.getNumeroOrdenBalanceo().compareTo(u2.getNumeroOrdenBalanceo())!=0){
        return u1.getNumeroOrdenBalanceo().compareTo(u2.getNumeroOrdenBalanceo());
    } else {
        return (-1)*(u1.getVolumen().compareTo(u2.getVolumen()));
    }
  }

  public boolean equals(Object o) {
    return this == o;
  }
}