package es.indra.sicc.dtos.cob;

import java.math.BigDecimal;

public class DTOCuotasAsignacion extends es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC {
   Long oidMovCC = null;
   BigDecimal importeOriginal = null;
   BigDecimal importePendiente = null;
   Long numeroIdentificadorCuota = null;
   Long numeroOrdenCuota = null;
   Long oidCliente = null;
   Long oidEtapa = null;
   Long oidMarca = null;
   Long oidSociedad = null;
   Long oidSubAcceso = null;
   Long oidRegion = null;
   Long oidSeccion = null;
   Long oidSubGerencia = null;
   Long oidTerritorio = null;
   Boolean telefonoEtapa = null;
   Long oidTipoCargo = null;
   Boolean telefonoCliente = null;
   BigDecimal deudaTotalCliente = null;
   Long tipoBalanceoEtapa = null;
   BigDecimal importeDesdeEtapa = null;
   BigDecimal importeHastaEtapa = null;
   Long oidCartera = null;
   Long oidConograma = null;
   Long edadEtapaDesde = null;
   Long edadEtapaHasta = null;
   Long oidZona = null;
   Long nivelAsignado = null;

   public void setOidMovCC(Long oidMovCC) {
      this.oidMovCC = oidMovCC;
   }


   public Long getOidMovCC() {
      return oidMovCC;
   }


   public void setImporteOriginal(BigDecimal importeOriginal) {
      this.importeOriginal = importeOriginal;
   }


   public BigDecimal getImporteOriginal() {
      return importeOriginal;
   }


   public void setImportePendiente(BigDecimal importePendiente) {
      this.importePendiente = importePendiente;
   }


   public BigDecimal getImportePendiente() {
      return importePendiente;
   }


   public void setNumeroIdentificadorCuota(Long numeroIdentificadorCuota) {
      this.numeroIdentificadorCuota = numeroIdentificadorCuota;
   }


   public Long getNumeroIdentificadorCuota() {
      return numeroIdentificadorCuota;
   }


   public void setNumeroOrdenCuota(Long numeroOrdenCuota) {
      this.numeroOrdenCuota = numeroOrdenCuota;
   }


   public Long getNumeroOrdenCuota() {
      return numeroOrdenCuota;
   }


   public void setOidCliente(Long oidCliente) {
      this.oidCliente = oidCliente;
   }


   public Long getOidCliente() {
      return oidCliente;
   }


   public void setOidEtapa(Long oidEtapa) {
      this.oidEtapa = oidEtapa;
   }


   public Long getOidEtapa() {
      return oidEtapa;
   }


   public void setOidMarca(Long oidMarca) {
      this.oidMarca = oidMarca;
   }


   public Long getOidMarca() {
      return oidMarca;
   }


   public void setOidSociedad(Long oidSociedad) {
      this.oidSociedad = oidSociedad;
   }


   public Long getOidSociedad() {
      return oidSociedad;
   }


   public void setOidSubAcceso(Long oidSubAcceso) {
      this.oidSubAcceso = oidSubAcceso;
   }


   public Long getOidSubAcceso() {
      return oidSubAcceso;
   }


   public void setOidRegion(Long oidRegion) {
      this.oidRegion = oidRegion;
   }


   public Long getOidRegion() {
      return oidRegion;
   }


   public void setOidSeccion(Long oidSeccion) {
      this.oidSeccion = oidSeccion;
   }


   public Long getOidSeccion() {
      return oidSeccion;
   }


   public void setOidSubGerencia(Long oidSubGerencia) {
      this.oidSubGerencia = oidSubGerencia;
   }


   public Long getOidSubGerencia() {
      return oidSubGerencia;
   }


   public void setOidTerritorio(Long oidTerritorio) {
      this.oidTerritorio = oidTerritorio;
   }


   public Long getOidTerritorio() {
      return oidTerritorio;
   }


   public void setTelefonoEtapa(Boolean telefonoEtapa) {
      this.telefonoEtapa = telefonoEtapa;
   }


   public Boolean getTelefonoEtapa() {
      return telefonoEtapa;
   }


   public void setOidTipoCargo(Long oidTipoCargo) {
      this.oidTipoCargo = oidTipoCargo;
   }


   public Long getOidTipoCargo() {
      return oidTipoCargo;
   }


   public void setTelefonoCliente(Boolean telefonoCliente) {
      this.telefonoCliente = telefonoCliente;
   }


   public Boolean getTelefonoCliente() {
      return telefonoCliente;
   }


   public void setDeudaTotalCliente(BigDecimal deudaTotalCliente) {
      this.deudaTotalCliente = deudaTotalCliente;
   }


   public BigDecimal getDeudaTotalCliente() {
      return deudaTotalCliente;
   }


   public void setTipoBalanceoEtapa(Long tipoBalanceoEtapa) {
      this.tipoBalanceoEtapa = tipoBalanceoEtapa;
   }


   public Long getTipoBalanceoEtapa() {
      return tipoBalanceoEtapa;
   }


   public void setImporteDesdeEtapa(BigDecimal importeDesdeEtapa) {
      this.importeDesdeEtapa = importeDesdeEtapa;
   }


   public BigDecimal getImporteDesdeEtapa() {
      return importeDesdeEtapa;
   }


   public void setImporteHastaEtapa(BigDecimal importeHastaEtapa) {
      this.importeHastaEtapa = importeHastaEtapa;
   }


   public BigDecimal getImporteHastaEtapa() {
      return importeHastaEtapa;
   }


   public void setOidCartera(Long oidCartera) {
      this.oidCartera = oidCartera;
   }


   public Long getOidCartera() {
      return oidCartera;
   }


   public void setOidConograma(Long oidConograma) {
      this.oidConograma = oidConograma;
   }


   public Long getOidConograma() {
      return oidConograma;
   }


   public void setEdadEtapaDesde(Long edadEtapaDesde) {
      this.edadEtapaDesde = edadEtapaDesde;
   }


   public Long getEdadEtapaDesde() {
      return edadEtapaDesde;
   }


   public void setEdadEtapaHasta(Long edadEtapaHasta) {
      this.edadEtapaHasta = edadEtapaHasta;
   }


   public Long getEdadEtapaHasta() {
      return edadEtapaHasta;
   }


   public void setOidZona(Long oidZona) {
      this.oidZona = oidZona;
   }


   public Long getOidZona() {
      return oidZona;
   }


    public void setNivelAsignado(Long nivelAsignado) {
        this.nivelAsignado = nivelAsignado;
    }


    public Long getNivelAsignado() {
        return nivelAsignado;
    }


}