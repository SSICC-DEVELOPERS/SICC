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
package es.indra.sicc.dtos.cra;
import java.util.*;
import java.util.Hashtable;

public class DTOSalidaBuscarMatrizDias  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{

  private Hashtable matrices;
  
  public DTOSalidaBuscarMatrizDias() {
  }

  public Hashtable getMatrices() {
    return matrices;
  }

  public void setMatrices(Hashtable newMatrices) {
    matrices = newMatrices;
  }
}