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
    $Id: LPConsultarCalendario.java,v 1.1 2009/12/03 18:35:32 pecbazalar Exp $
    DESC
*/

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.IBelcorpError;

import es.indra.mare.common.mgu.manager.Property;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cra.DTOEntradaConsultarGruposZonas;
import es.indra.sicc.dtos.cra.DTOEntradaDatosActividad;
import es.indra.sicc.dtos.cra.DTOSalidaCalendario;

import LPSICCBase;

// Definicion de la clase
public class LPConsultarCalendario extends LPSICCBase {

  public LPConsultarCalendario(){super();}

  //Definicion del metodo abstracto inicio
  public void inicio() throws Exception {}

  // Definicion del metodo abstracto ejecucion
  public void ejecucion() throws Exception {
    conectorAction("LPMantieneCalendario");
    this.conectorActionParametro( "accion", "muestraConsulta" );
	}
}
