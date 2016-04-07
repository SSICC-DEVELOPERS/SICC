package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODatosEtiqueta extends DTOSiccPaginacion {
    private Long oidFormatoEtiqueta;
    private Long oidCentroDistribucion;
    private Long oidLineaArmado;
    private Long oidSublineaArmado;
    private String formato;
    
    /* BELC300024733 - dmorello, 11/04/2007 */
    private Long oidProgramaEtiqueta;

    public DTODatosEtiqueta() { }
    
    public void setOidFormatoEtiqueta(Long oidFormatoEtiqueta) {
        this.oidFormatoEtiqueta = oidFormatoEtiqueta;
    }
    
    public Long getOidFormatoEtiqueta() {
        return this.oidFormatoEtiqueta;
    }
    
    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }
    
    public Long getOidCentroDistribucion() {
        return this.oidCentroDistribucion;
    }
    
    public void setOidLineaArmado(Long oidLineaArmado) {
        this.oidLineaArmado = oidLineaArmado;
    }
    
    public Long getOidLineaArmado() {
        return this.oidLineaArmado;
    }
    
    public void setOidSublineaArmado(Long oidSublineaArmado) {
        this.oidSublineaArmado = oidSublineaArmado;
    }
    
    public Long getOidSublineaArmado() {
        return this.oidSublineaArmado;
    }
    
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public String getFormato() {
        return this.formato;
    }    

  public Long getOidProgramaEtiqueta()
  {
    return oidProgramaEtiqueta;
  }

  public void setOidProgramaEtiqueta(Long oidProgramaEtiqueta)
  {
    this.oidProgramaEtiqueta = oidProgramaEtiqueta;
  }
}