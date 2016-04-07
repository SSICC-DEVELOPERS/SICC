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
 * @author Viviana Bongiovanni
 * @fecha: 23/03/2006
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;

public class IncetivosHelper {
  public IncetivosHelper() {
  }
  
  public static Boolean contieneConcursos(ArrayList arrayConcursos) throws MareException {
      UtilidadesLog.info("IncetivosHelper.contieneConcursos(ArrayList arrayConcursos):Entrada");
      
      if(arrayConcursos.size()==0){
          UtilidadesLog.debug("No existen concursos activos para el proceso actual");
          UtilidadesLog.info("IncetivosHelper.contieneConcursos(ArrayList arrayConcursos):Salida");
          return Boolean.FALSE;
          
      } else {
          UtilidadesLog.info("IncetivosHelper.contieneConcursos(ArrayList arrayConcursos):Salida");
          return Boolean.TRUE;
      }
  }
}