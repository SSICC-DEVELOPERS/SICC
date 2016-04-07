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
import java.util.Comparator;

public class BahiaComparator  implements Comparator {
  public BahiaComparator() {
  }
  
  public int compare(Object o1, Object o2) {
    ZonasSublinea u1 = (ZonasSublinea) o1;
    ZonasSublinea u2 = (ZonasSublinea) o2;
    return u1.getBahiaDesde().compareTo(u2.getBahiaDesde());
  }

  public boolean equals(Object o) {
    return this == o;
  }
}