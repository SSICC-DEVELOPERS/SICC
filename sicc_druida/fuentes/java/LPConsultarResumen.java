//$Id: LPConsultarResumen.java,v 1.1 2009/12/03 18:41:40 pecbazalar Exp $

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
/**
 * Sistema:           Belcorp
 * Modulo:            COB
 * Submódulo:         Cobranzas
 * Componente:        LP
 * Fecha:             24/01/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 */
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPConsultarResumen extends LPSICCBase {



	 public void inicio() throws Exception {
			
	 }
	  
	  public void ejecucion() throws Exception {    
			setTrazaFichero();    
			try  {
			  this.rastreo();
			  traza("*********** Entre a LPConsultarResumen");
			  conectorAction("LPResumen");
			  conectorActionParametro("accion", ""); 
			}
			catch ( Exception e )  {
			  traza("Exception en LPConsultarResumen");
			  e.printStackTrace();     
			  lanzarPaginaError(e);
			}
	  }

}
/*
Llama a la LPResumen con: 
- accion=""
*/