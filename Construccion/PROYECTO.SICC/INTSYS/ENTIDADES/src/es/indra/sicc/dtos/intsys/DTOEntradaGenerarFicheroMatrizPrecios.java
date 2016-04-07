package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Autor: wchere
 * Fecha: 06/12/04
 */
 
public class DTOEntradaGenerarFicheroMatrizPrecios extends DTOAuditableSICC  {

   private Long   oidCanal;
   private Long   oidMarca;
   private Long   oidAcceso;
   private Long   oidPeriodoDesde;
   private Long   oidPeriodoHasta;
   private Long   numeroLote;
   private String descripcion;
   private String observaciones;
   
   public DTOEntradaGenerarFicheroMatrizPrecios() {
   }

   public void setOidCanal ( Long oidCanal ) {
      this.oidCanal = oidCanal;
   }

   public Long getOidCanal () {
      return this.oidCanal;
   }

   public void setOidMarca ( Long oidMarca ) {
      this.oidMarca = oidMarca;
   }

   public Long getOidMarca () {
      return this.oidMarca;
   }

   public void setOidAcceso ( Long oidAcceso ) {
      this.oidAcceso = oidAcceso;
   }

   public Long getOidAcceso () {
      return this.oidAcceso;
   }

   public void setOidPeriodoDesde ( Long oidPeriodoDesde ) {
      this.oidPeriodoDesde = oidPeriodoDesde;
   }

   public Long getOidPeriodoDesde () {
      return this.oidPeriodoDesde;
   }

   public void setOidPeriodoHasta ( Long oidPeriodoHasta ) {
      this.oidPeriodoHasta = oidPeriodoHasta;
   }

   public Long getOidPeriodoHasta () {
      return this.oidPeriodoHasta;
   }

   public void setNumeroLote ( Long numeroLote ) {
      this.numeroLote = numeroLote;
   }

   public Long getNumeroLote () {
      return this.numeroLote;      
   }

   public void setDescripcion ( String descripcion ) {
      this.descripcion = descripcion;
   }

   public String getDescripcion () {
      return this.descripcion;
   }

   public void setObservaciones ( String observaciones ) {
      this.observaciones = observaciones;
   }

   public String getObservaciones() {
      return this.observaciones;
   }

}