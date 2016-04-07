/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.util;

import java.io.Serializable;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:        DTO
 * Fecha:             30/05/2003
 * Observaciones:
 * Descripcion:       DTO que encapsula información de un error
 * @version           1.0
 * @autor             Agustin Palacios
 */
public class DTOError extends DTOBelcorp {
   private String codigoError;
   private String descripcionError;
   private int severidadError;

   public DTOError() {
   }

   public DTOError(String codigoError, String descripcionError, int severidad) {
      this.codigoError = codigoError;
      this.descripcionError = descripcionError;
      this.severidadError = severidad;
   }

   public DTOError(String codigoError, String descripcionError) {
      this.codigoError = codigoError;
      this.descripcionError = descripcionError;
   }

   public void setError(String codigoError, String descripcionError) {
      setCodigoError(codigoError);
      setDescripcionError(descripcionError);
   }

   public void setCodigoError(String codigoError) {
      this.codigoError = codigoError;
   }

   public String getCodigoError() {
      return codigoError;
   }

   public void setDescripcionError(String descripcionError) {
      this.descripcionError = descripcionError;
   }

   public String getDescripcionError() {
      return descripcionError;
   }

   public void setSeveridad(int severidad) {
      this.severidadError = severidad;
   }

   public int getSeveridad() {
      return this.severidadError;
   }
}
