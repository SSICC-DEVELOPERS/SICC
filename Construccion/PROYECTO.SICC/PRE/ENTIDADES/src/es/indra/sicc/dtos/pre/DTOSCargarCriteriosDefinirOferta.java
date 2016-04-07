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
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * 
 * pperanzola - 20/10/2005 - se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
 */

public class DTOSCargarCriteriosDefinirOferta extends DTOAuditableSICC 
{
  private RecordSet accesos;
  private RecordSet argumentosVenta;
  private RecordSet indicadoresCuadre;
  private RecordSet tiposCliente;
  private RecordSet estatus;
  private RecordSet formasPago;
  private DTOTipoEstrategia tipoEstrategia;
  private DTOEstrategia estrategia;
  private Long oidMoneda;
  private String descripcionMoneda;
  private RecordSet condiciones;
  private RecordSet tiposOferta;
  private RecordSet ciclosVida;
  ///*[1]
  private RecordSet programaFidelizacion;
  private RecordSet variantes;
  //*/[1]
  private Long oidMarca;
  private Long oidCanal;   

  public DTOSCargarCriteriosDefinirOferta()
  {
  }

  public RecordSet getAccesos()
  {
    return accesos;
  }

  public void setAccesos(RecordSet newAccesos)
  {
    accesos = newAccesos;
  }

  public RecordSet getArgumentosVenta()
  {
    return argumentosVenta;
  }

  public void setArgumentosVenta(RecordSet newArgumentosVenta)
  {
    argumentosVenta = newArgumentosVenta;
  }

  public RecordSet getIndicadoresCuadre()
  {
    return indicadoresCuadre;
  }

  public void setIndicadoresCuadre(RecordSet newIndicadoresCuadre)
  {
    indicadoresCuadre = newIndicadoresCuadre;
  }

  public RecordSet getTiposCliente()
  {
    return tiposCliente;
  }

  public void setTiposCliente(RecordSet newTiposCliente)
  {
    tiposCliente = newTiposCliente;
  }

  public RecordSet getEstatus()
  {
    return estatus;
  }

  public void setEstatus(RecordSet newEstatus)
  {
    estatus = newEstatus;
  }

  public RecordSet getFormasPago()
  {
    return formasPago;
  }

  public void setFormasPago(RecordSet newFormasPago)
  {
    formasPago = newFormasPago;
  }

  public DTOTipoEstrategia getTipoEstrategia()
  {
    return tipoEstrategia;
  }

  public void setTipoEstrategia(DTOTipoEstrategia newTipoEstrategia)
  {
    tipoEstrategia = newTipoEstrategia;
  }

  public DTOEstrategia getEstrategia()
  {
    return estrategia;
  }

  public void setEstrategia(DTOEstrategia newEstrategia)
  {
    estrategia = newEstrategia;
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long newOidMoneda)
  {
    oidMoneda = newOidMoneda;
  }

  public String getDescripcionMoneda()
  {
    return descripcionMoneda;
  }

  public void setDescripcionMoneda(String newDescripcionMoneda)
  {
    descripcionMoneda = newDescripcionMoneda;
  }

  public RecordSet getCondiciones()
  {
    return condiciones;
  }

  public void setCondiciones(RecordSet newCondiciones)
  {
    condiciones = newCondiciones;
  }

  public RecordSet getTiposOferta()
  {
    return tiposOferta;
  }

  public void setTiposOferta(RecordSet newTiposOferta)
  {
    tiposOferta = newTiposOferta;
  }

  public RecordSet getCiclosVida()
  {
    return ciclosVida;
  }

  public void setCiclosVida(RecordSet newCiclosVida)
  {
    ciclosVida = newCiclosVida;
  }

  ///*[1]
  public RecordSet getProgramaFidelizacion(){
    return programaFidelizacion;
  }

  public void setProgramaFidelizacion(RecordSet programaFidelizacion){
    this.programaFidelizacion = programaFidelizacion;
  }

  public RecordSet getVariantes(){
    return variantes;
  }

  public void setVariantes(RecordSet variantes){
    this.variantes = variantes;
  }
  //*/[1]

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }
}
