//$Id: LPReimprimirFichasInscripcion.java,v 1.1 2009/12/03 18:34:15 pecbazalar Exp $ 
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
**/
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mae.DTOReimprimirFichasInscripcion;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;


public class LPReimprimirFichasInscripcion  extends LPSICCBase {	
	
	public LPReimprimirFichasInscripcion() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_fichas_inscripcion_reimprimir");	
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

/* 
	*  Retorna el Id de funcion.
    **/
	private String getIdFuncion() throws MareException, Exception {		
		String idFuncion = (String)conectorParametro("hidIdFuncion");
		return idFuncion;		
	}


//carga VectorLOng
private Long[] cargaVector(String clienteS) throws Exception{
			StringTokenizer stk = new StringTokenizer(clienteS,",");
			Long[] cliente = new Long[stk.countTokens()];
			int i = 0;
			 while (stk.hasMoreTokens()){
				cliente[i] = Long.valueOf(stk.nextToken());
				i++;
	        }
	return cliente;
}
public void ejecucion() throws Exception {
	//rastreo();
	setTrazaFichero();
	UtilidadesSession paisSesion = new UtilidadesSession();
	UtilidadesSession idiomaSesion = new UtilidadesSession();	
	String accion = conectorParametroLimpia( "accion","",true );
	String clienteStr = conectorParametroLimpia( "hidCliente","",true );
	String motivos	= conectorParametroLimpia( "hidMotivo","",true );
	String exitoVar	= conectorParametroLimpia( "exito","",true );
	MareBusinessID id;
	Vector paramEntrada  = new Vector();

	DruidaConector conectorObtenerFichasIns;
	DruidaConector conectorReimprimirFichas;
	Long pais = paisSesion.getPais(this);
	Long idioma = idiomaSesion.getIdioma(this);
	try	{
		
		if ( accion.equals("") ) {
			/*
			Crear un DTOBelcorp con el oid del país de entrada del usuario en sesión y el idioma. 
			IdBussines = "MAEObtenerFichasInscripcion". 
			Llamar al conector ConectorObtenerFichasInscripcion con el dto creado. 
			Se recibe un Recordset con los códigos de clientes que han utilizado fichas de inscripción en el pais del usuario. 
			La primera columna es el oid y debe quedar en un campo oculto de cada fila y la segunda es el código que debemos mostrar. 
			*/
			/*DTOBelcorp dtoBelcorp = new DTOBelcorp();
			dtoBelcorp.setOidPais(pais);
			dtoBelcorp.setOidIdioma(idioma);
			*/
			asignarAtributo("VAR","hidPais", "valor", pais.toString());	
			asignarAtributo("VAR","hidIdioma", "valor", idioma.toString());	
			asignarAtributo("VAR","exito", "valor", exitoVar);	
			/*DTOSiccPaginacion dtoPag = new DTOSiccPaginacion();
			dtoPag.setOidPais(pais);
			dtoPag.setOidIdioma(idioma);			
			id = new MareBusinessID("MAEObtenerFichasInscripcion");
			paramEntrada.addElement(dtoPag);
			paramEntrada.addElement(id);*/
			traza("antes de conectar");
			//conectorObtenerFichasIns = conectar("ConectorObtenerFichasInscripcion", paramEntrada);
			traza("despues de conectar");
			//asignar("COMBO","cbCupCliDisponibles", conectorObtenerFichasIns, "dtoSalida.resultado_ROWSET");
			
		}
		else if ( accion.equals("ReimprimirFichas") ) {
			/*
			Crear un DTOReimprimirFichasInscripcion con los oid de los clientes seleccionados por el usuario y el motivo introducido 
			IdBussines = "MAEReimprimirFichasInscripcion" 
			Activar el conector ConectorReimprimirFichasInscripcion. 

			//TODO: Falta definir como se van a reimprimir las fichas 
			*/
			traza("clienteStr  " + clienteStr );
			DTOReimprimirFichasInscripcion dtoReimprimir = new DTOReimprimirFichasInscripcion();
			dtoReimprimir.setClientes(cargaVector(clienteStr));
			dtoReimprimir.setMotivos(motivos);
			dtoReimprimir.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dtoReimprimir.setPrograma(UtilidadesSession.getFuncion(this));
			traza("dtoReimprimir  " + dtoReimprimir);
			id = new MareBusinessID("MAEReimprimirFichasInscripcion");
			paramEntrada.addElement(dtoReimprimir);
			paramEntrada.addElement(id);			
			asignarAtributo("VAR", "exito", "valor", "S");
			conectorObtenerFichasIns = conectar("ConectorReimprimirFichasIncripcion", paramEntrada);
			conectorAction("LPReimprimirFichasInscripcion");
			conectorActionParametro("exito","S");
			conectorActionParametro("accion","");			
		}

		}
	catch (Exception ex)
	{
		logStackTrace(ex);
		//BelcorpError belcorpError = new BelcorpError();
		//DTOError dtoError = belcorpError.obtenerError(ex, ( idioma==null || idioma==Long.valueOf(0)?"":idioma.toString() ),( pais==null || pais ==Long.valueOf(0) ?"":pais.toString() ) );
		/*DTOError dtoError = belcorpError.obtenerError(ex, ( idioma.toString() ),( pais.toString() ) );
		asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
		asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError());			*/
		lanzarPaginaError(ex);
	}
	getConfiguracionMenu();
}
}


