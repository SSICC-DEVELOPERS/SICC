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

import java.util.*;


public class Tag {
   private static String APERTURA = "<";
   private static String CIERRE = "/>";
   private static String SEPARADOR = " ";
   private String tabla = "";
   private String impresion = "";
   private Vector atributos = null;

   public Tag(String tabla) {
      this.tabla = tabla;
   }

   public Vector getAtributos() {
      return atributos;
   }

   public void setAtributos(Vector newAtributos) {
      atributos = newAtributos;
   }

   public String imprimir() {
      Iterator miIte = this.atributos.iterator();
      this.impresion = this.APERTURA + this.tabla;

      while (miIte.hasNext()) {
         this.impresion = this.impresion + this.SEPARADOR +
            ((AtributoTag) miIte.next()).imprimir();
      }

      this.impresion = this.impresion + this.SEPARADOR + this.CIERRE;

      return Formato.linea(this.impresion);
   }
}
