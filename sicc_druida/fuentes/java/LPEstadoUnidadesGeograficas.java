//$Id: LPEstadoUnidadesGeograficas.java,v 1.1 2009/12/03 18:42:26 pecbazalar Exp $ 
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
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.Vector;
import java.lang.Boolean;
import java.io.*;

public class LPEstadoUnidadesGeograficas extends LPSICCBase {		
	public LPEstadoUnidadesGeograficas() {	super();	}
	public void inicio() throws Exception { pagina("contenido_estado_unidades_geograficas_consultar"); }
	public void ejecucion() throws Exception {		
		String accion				= conectorParametroLimpia("hidAccion", "", true);
		// Rastreo
		if(accion.equals("")){
		  this.rastreo();
		}
      asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getDescripcionPais(this) );
	   getConfiguracionMenu();
	}
}