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
 */

package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;

public class DTOINTParametrosContablesCCC extends DTOBelcorp {
   
   private Long oid;
   private Long proceso;
   private Long subproceso;
   private String indicativoDebeHaber;
   private String obtencionCuenta;
   private Long cuentaDirecta;

   public DTOINTParametrosContablesCCC() {
      super();
   }

   public Long getOid() {
      return oid;
   }

   public void setOid(Long oid) {
      this.oid = oid;
   }

   public Long getProceso() {
      return proceso;
   }

   public void setProceso(Long proceso) {
      this.proceso = proceso;
   }

   public Long getSubproceso() {
      return subproceso;
   }

   public void setSubproceso(Long subproceso) {
      this.subproceso = subproceso;
   }

   public String getIndicativoDebeHaber() {
      return indicativoDebeHaber;
   }

   public void setIndicativoDebeHaber(String indicativoDebeHaber) {
      this.indicativoDebeHaber = indicativoDebeHaber;
   }

   public String getObtencionCuenta() {
      return obtencionCuenta;
   }

   public void setObtencionCuenta(String obtencionCuenta) {
      this.obtencionCuenta = obtencionCuenta;
   }

   public Long getCuentaDirecta() {
      return cuentaDirecta;
   }

   public void setCuentaDirecta(Long cuentaDirecta) {
      this.cuentaDirecta = cuentaDirecta;
   }
}