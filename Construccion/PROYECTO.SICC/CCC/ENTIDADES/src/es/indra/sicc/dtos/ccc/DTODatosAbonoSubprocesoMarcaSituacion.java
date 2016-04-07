package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosAbonoSubprocesoMarcaSituacion extends DTOBelcorp  {
   public DTODatosAbonoSubprocesoMarcaSituacion() {
      super();
   }
   
   private String indicadorEmisionVctoPais;
   private Long oidCuentaContable;
   private Long oidCuentaBancaria;
   private Long oidSubProcesoCreacion;
   private Long oidSubProceso;
   private Long oidTipoAbono;
   private Long oidSubTipoAbono;
   private Long oidMarcaSituacionEntrada;
   private Long oidMarcaSituacionSalida;
   private Long oidTipoAbonoSubProceso;
   private Boolean indicadorActualizaCuota;
   //se usa para saber si viene de la tabla CCC_ASIGN_SUBPR_TIPO_SOLIC
   private Boolean indicadorAsigTipoSolic;
   private String parametroProceso;
   private Integer parametroSubProceso; 


   public void setIndicadorEmisionVctoPais(String indicadorEmisionVctoPais) {
      this.indicadorEmisionVctoPais = indicadorEmisionVctoPais;
   }


   public String getIndicadorEmisionVctoPais() {
      return indicadorEmisionVctoPais;
   }


   public void setOidCuentaContable(Long oidCuentaContable) {
      this.oidCuentaContable = oidCuentaContable;
   }


   public Long getOidCuentaContable() {
      return oidCuentaContable;
   }


   public void setOidCuentaBancaria(Long oidCuentaBancaria) {
      this.oidCuentaBancaria = oidCuentaBancaria;
   }


   public Long getOidCuentaBancaria() {
      return oidCuentaBancaria;
   }


   public void setOidSubProcesoCreacion(Long oidSubProcesoCreacion) {
      this.oidSubProcesoCreacion = oidSubProcesoCreacion;
   }


   public Long getOidSubProcesoCreacion() {
      return oidSubProcesoCreacion;
   }


   public void setOidSubProceso(Long oidSubProceso) {
      this.oidSubProceso = oidSubProceso;
   }


   public Long getOidSubProceso() {
      return oidSubProceso;
   }

   public void setOidMarcaSituacionEntrada(Long oidMarcaSituacionEntrada) {
      this.oidMarcaSituacionEntrada = oidMarcaSituacionEntrada;
   }


   public Long getOidMarcaSituacionEntrada() {
      return oidMarcaSituacionEntrada;
   }


   public void setOidMarcaSituacionSalida(Long oidMarcaSituacionSalida) {
      this.oidMarcaSituacionSalida = oidMarcaSituacionSalida;
   }


   public Long getOidMarcaSituacionSalida() {
      return oidMarcaSituacionSalida;
   }


   public void setIndicadorAsigTipoSolic(Boolean indicadorAsigTipoSolic) {
      this.indicadorAsigTipoSolic = indicadorAsigTipoSolic;
   }


   public Boolean getIndicadorAsigTipoSolic() {
      return indicadorAsigTipoSolic;
   }


   public void setOidTipoAbono(Long oidTipoAbono) {
      this.oidTipoAbono = oidTipoAbono;
   }


   public Long getOidTipoAbono() {
      return oidTipoAbono;
   }


   public void setOidSubTipoAbono(Long oidSubTipoAbono) {
      this.oidSubTipoAbono = oidSubTipoAbono;
   }


   public Long getOidSubTipoAbono() {
      return oidSubTipoAbono;
   }


   public void setOidTipoAbonoSubProceso(Long oidTipoAbonoSubProceso) {
      this.oidTipoAbonoSubProceso = oidTipoAbonoSubProceso;
   }


   public Long getOidTipoAbonoSubProceso() {
      return oidTipoAbonoSubProceso;
   }


   public void setIndicadorActualizaCuota(Boolean indicadorActualizaCuota) {
      this.indicadorActualizaCuota = indicadorActualizaCuota;
   }


   public Boolean getIndicadorActualizaCuota() {
      return indicadorActualizaCuota;
   }


   public void setParametroProceso(String parametroProceso) {
      this.parametroProceso = parametroProceso;
   }


   public String getParametroProceso() {
      return parametroProceso;
   }


   public void setParametroSubProceso(Integer parametroSubProceso) {
      this.parametroSubProceso = parametroSubProceso;
   }


   public Integer getParametroSubProceso() {
      return parametroSubProceso;
   }
   
   
   
}