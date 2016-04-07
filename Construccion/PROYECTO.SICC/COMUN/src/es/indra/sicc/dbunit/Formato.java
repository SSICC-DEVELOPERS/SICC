/**
 * Copyright 2003 ® por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dbunit;

public class Formato {
   public static int ANCHO_COL = 25;
   public static String ENTER = "\n";
   public static String COMILLAS = "'";

   public static String agregarEspacios(String str) {
      int cant = Formato.ANCHO_COL - str.length();

      for (int k = 1; k <= cant; k++)
         str += " ";

      return str;
   }

   public static String agregarEspacios(String str, int max) {
      int cant = 0;

      if (max > Formato.ANCHO_COL) {
         cant = Formato.ANCHO_COL;
      } else {
         cant = max - str.length();
      }

      for (int k = 1; k <= cant; k++)
         str += " ";

      return str;
   }

   public static String linea(String str) {
      return (str += Formato.ENTER);
   }

   public static String linea() {
      return (Formato.ENTER);
   }

   public static String entreComillas(String str) {
      return Formato.COMILLAS + str + Formato.COMILLAS;
   }
}
