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

/*
    INDRA/CAR/PROY
    $Id: LPModificarCalendario.java,v 1.1 2009/12/03 18:41:03 pecbazalar Exp $
    DESC
*/

import LPSICCBase;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

// Definicion de la clase
public class LPModificarCalendario extends LPSICCBase {

  // Definicion del constructor
  public LPModificarCalendario() {super();}

  public void inicio(){}

  // Definicion del metodo abstracto ejecucion
  public void ejecucion() throws Exception {
    this.conectorAction( "LPMantieneCalendario" );
    this.conectorActionParametro( "accion", "muestraModificacion" );
  }
}
