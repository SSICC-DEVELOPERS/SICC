package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTODatosMontoMinimo extends DTOAuditableSICC  {
  private Long oidMontoMinimo;
  private BigDecimal nivel1;
  private BigDecimal nivel2;
  private BigDecimal nivel3;
  private BigDecimal recargo;
  private BigDecimal montoMinimoNomi;
  private BigDecimal solPreCatalogoTotalLocal;

  public DTODatosMontoMinimo() {
  }

  public Long getOidMontoMinimo() {
    return oidMontoMinimo;
  }

  public void setOidMontoMinimo(Long newOidMontoMinimo) {
    oidMontoMinimo = newOidMontoMinimo;
  }

  public BigDecimal getNivel1() {
    return nivel1;
  }

  public void setNivel1(BigDecimal newNivel1) {
    nivel1 = newNivel1;
  }

  public BigDecimal getNivel2() {
    return nivel2;
  }

  public void setNivel2(BigDecimal newNivel2) {
    nivel2 = newNivel2;
  }

  public BigDecimal getNivel3() {
    return nivel3;
  }

  public void setNivel3(BigDecimal newNivel3) {
    nivel3 = newNivel3;
  }

  public BigDecimal getRecargo() {
    return recargo;
  }

  public void setRecargo(BigDecimal newRecargo) {
    recargo = newRecargo;
  }

  public BigDecimal getMontoMinimoNomi() {
    return montoMinimoNomi;
  }

  public void setMontoMinimoNomi(BigDecimal newMontoMinimoNomi) {
    montoMinimoNomi = newMontoMinimoNomi;
  }

  public BigDecimal getSolPreCatalogoTotalLocal() {
    return solPreCatalogoTotalLocal;
  }

  public void setSolPreCatalogoTotalLocal(BigDecimal newSolPreCatalogoTotalLocal) {
    solPreCatalogoTotalLocal = newSolPreCatalogoTotalLocal;
  }
}