/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;

public class DTOInsertarLineaArmado extends DTOBelcorp {

  DTOLineaArmado dtoLineaArmado;
  DTOTipoSolicitudLinea dtoTipoSolicitudLinea[];
  DTOUsuarioAlarmaLineas dtoUsuarioAlarmaLineas[];
  Long oidsSolicitudEliminados[];
  Long oidsUsuariosEliminados[];
  Vector attrTraducible;
  
  
  public DTOInsertarLineaArmado()
  {
  }


  public void setDtoLineaArmado(DTOLineaArmado dtoLineaArmado)
  {
    this.dtoLineaArmado = dtoLineaArmado;
  }


  public DTOLineaArmado getDtoLineaArmado()
  {
    return dtoLineaArmado;
  }


  public void setDtoTipoSolicitudLinea(DTOTipoSolicitudLinea[] dtoTipoSolicitudLinea)
  {
    this.dtoTipoSolicitudLinea = dtoTipoSolicitudLinea;
  }


  public DTOTipoSolicitudLinea[] getDtoTipoSolicitudLinea()
  {
    return dtoTipoSolicitudLinea;
  }


  public void setDtoUsuarioAlarmaLineas(DTOUsuarioAlarmaLineas[] dtoUsuarioAlarmaLineas)
  {
    this.dtoUsuarioAlarmaLineas = dtoUsuarioAlarmaLineas;
  }


  public DTOUsuarioAlarmaLineas[] getDtoUsuarioAlarmaLineas()
  {
    return dtoUsuarioAlarmaLineas;
  }


  public void setOidsSolicitudEliminados(Long[] oidsSolicitudEliminados)
  {
    this.oidsSolicitudEliminados = oidsSolicitudEliminados;
  }


  public Long[] getOidsSolicitudEliminados()
  {
    return oidsSolicitudEliminados;
  }


  public void setOidsUsuariosEliminados(Long[] oidsUsuariosEliminados)
  {
    this.oidsUsuariosEliminados = oidsUsuariosEliminados;
  }


  public Long[] getOidsUsuariosEliminados()
  {
    return oidsUsuariosEliminados;
  }


  public void setAttrTraducible(Vector attrTraducible)
  {
    this.attrTraducible = attrTraducible;
  }


  public Vector getAttrTraducible()
  {
    return attrTraducible;
  }
}