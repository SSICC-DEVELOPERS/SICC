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

public class AtributoTag {
   private String nombre = "";
   private String valor = "";
   public int tipo = 0;
   private int largo = 0;

   public AtributoTag(String nombre, int tipo, int largo) {
      this.setNombre(nombre);
      this.setTipo(tipo);
      this.setLargo(largo);
      this.setValor("");
   }

   public AtributoTag(String nombre, int tipo, int largo, String valor) {
      this.setNombre(nombre);
      this.setTipo(tipo);
      this.setLargo(largo);
      this.setValor(valor);
   }

   public String imprimir() {
      return this.nombre + "=" +
      Formato.entreComillas(Formato.agregarEspacios(this.valor, this.largo));
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String newNombre) {
      nombre = newNombre;
   }

   public int getTipo() {
      return tipo;
   }

   public void setTipo(int newTipo) {
      tipo = newTipo;
   }

   public String getValor() {
      return valor;
   }

   public void setValor(String newValor) {
      valor = newValor;
   }

   public int getLargo() {
      return largo;
   }

   public void setLargo(int newLargo) {
      largo = newLargo;
   }
}
