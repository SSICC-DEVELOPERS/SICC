//$Id: LPConsultaImpuestos.java,v 1.1 2009/12/03 18:35:54 pecbazalar Exp $ 
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
 * Modulo:            MAE
 * Submódulo:         Materiales
 * Componente:        LP
 * Fecha:             13/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-SEG-001-202
 *                    (Subido al portal el 01/05/2003)
 * @version           1.0
 * @autor             Marta Montiel
 */ 
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;


public class LPConsultaImpuestos extends LPSICCBase {	
	
	public LPConsultaImpuestos() {
		super();
	}
	public void inicio() throws Exception {
			   pagina("contenido_impuestos_ubigeo_modificar");
			   asignarAtributoPagina("cod","0400");
	}
	

	private void logStackTrace(Throwable e) {
     ByteArrayOutputStream os = new ByteArrayOutputStream();
	 PrintStream ps = new PrintStream(os);

	 e.printStackTrace(ps);
     try {
		traza("Se produjo la excepcion: " 
			+ e.getMessage() 
			+ "\n" 
			+ "stackTrace = " 
		    + os.toString());
     }
     catch (Exception ex) {
        //traza ("Error en logStackTrace: " + ex.getMessage ());
		e.printStackTrace ();
     }
	}


public void ejecucion() throws Exception {
	setTrazaFichero();
	UtilidadesSession paisSesion = new UtilidadesSession();
	UtilidadesSession idiomaSesion = new UtilidadesSession();
	
	String accion = conectorParametroLimpia( "accion","",true );
	String casoDeUso = conectorParametroLimpia( "hidCasodeUso","",true );		

	Long pais = paisSesion.getPais(this);
	Long idioma = idiomaSesion.getIdioma(this);

	try
		{
			traza("entro por accion consultar");
			asignarAtributo("VAR", "hidCasodeUso", "valor", "consultar");	
			conectorAction("LPBusquedaImpuestos");
			conectorActionParametro("accion","");
			conectorActionParametro("hidCasodeUso", "consultar");
		}
	catch (Throwable ex)
		{
			logStackTrace(ex);
			BelcorpError belcorpError = new BelcorpError();
			DTOError dtoError = belcorpError.obtenerError(ex, ( idioma.toString() ),( pais.toString() ) );
			asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
			asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError());
			asignarAtributo("VAR", "hidCasodeUso", "valor", casoDeUso);
			/*conectorAvisoModa l("LPPantallaError");			
			conectorAvisoModalParametro("errCodigo","5");*/
			}	
		getConfiguracionMenu();			
		}

 }//fin clase