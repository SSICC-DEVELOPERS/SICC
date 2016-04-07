//$Id: LPEliminarAsociacionNiveles.java,v 1.1 2009/12/03 18:38:30 pecbazalar Exp $ 
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
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LP
 * Fecha:             13/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-SEG-001-202
 *                    (Subido al portal el 01/05/2003)
 * @version           1.0
 * @autor             Marta Montiel
 */ 

import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.CodigosError;

import es.indra.sicc.dtos.seg.PaginaEliminarNivelesDTO;

import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;


import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;
import es.indra.sicc.dtos.seg.DTOListaAsociacionNiveles;
import es.indra.sicc.dtos.seg.FiltroPaisDTO;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;


import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;

import java.math.BigDecimal;
import es.indra.sicc.dtos.seg.PaginaEliminarNivelesDTO; 

public class LPEliminarAsociacionNiveles extends LPSICCBase {
	
	public LPEliminarAsociacionNiveles() {
		super();
	}

	public void inicio() throws Exception {
               pagina("contenido_niveles_socioeconomicos_eliminar");
			   asignarAtributoPagina("cod","047");			   
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
        } catch (Exception ex) {
            //traza ("Error en logStackTrace: " + ex.getMessage ());
            e.printStackTrace ();
        }
	}


	public void ejecucion() throws Exception {
		setTrazaFichero();
		String accion = conectorParametroLimpia( "accion","",true );
		String casoDeUso = conectorParametroLimpia( "CasoDeUso","",true );		
		String idAsociacion = conectorParametroLimpia( "hidAsociacion","",true );
		String strPais = conectorParametroLimpia( "hidPais","",true );
		String nseBelcorp = conectorParametroLimpia( "comboNSEBelcorp","",true );
		String nsePais = conectorParametroLimpia( "comboNSEPais","",true );
		String elementosSeleccionados = conectorParametroLimpia( "elementosSeleccionados","",true );
		Vector paramEntrada  = new Vector();
		Vector paramEntPais  = new Vector();
		MareBusinessID id;
		UtilidadesSession paisSesion = new UtilidadesSession();
		UtilidadesSession idiomaSesion = new UtilidadesSession();
		Long pais = paisSesion.getPais(this);
		Long idioma = idiomaSesion.getIdioma(this);

		ArrayList arrayElimina = new ArrayList();

		AsociacionNivelesDTO dtoElimina;
		DTOListaAsociacionNiveles dtoListaElimina;
		FiltroPaisDTO dtoPais;
		DTOInternacional dtoInternacional;
		
		traza("strPais  al principio de todo  " + strPais);
		try
		{
			casoDeUso = "eliminar";
			// Rastreo
			rastreo();

			if ( accion.equals("") )
			{
				//buscar los NSE asociados al pais tomado de sesion
				dtoInternacional = new DTOInternacional();
				id = new MareBusinessID("SEGBuscarAsociaciones");
				dtoInternacional.setOidPais(pais);
				dtoInternacional.setOidIdioma(idioma);
				paramEntPais.addElement(dtoInternacional);
				paramEntPais.addElement(id);

				traza("Numero vivi 1");
				DruidaConector conectorPaises = conectar("ConectorBuscarAsociacionesNiveles",paramEntPais);
        
				traza("Numero vivi 2");
				traza(conectorPaises.getXML());

				asignar("COMBO","comboPais", conectorPaises, "dtoSalida.paises_ROWSET");
				asignarAtributo("VAR", "hidPais", "valor", pais.toString());
				asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);
				asignar("LISTA","lstAsociaciones", conectorPaises, "dtoSalida.asociaciones_ROWSET");

				PaginaEliminarNivelesDTO dtoSalidaEliminarNiveles  = (PaginaEliminarNivelesDTO) conectorPaises.objeto("DTOSalidaBuscarNiveles");

                boolean noHuboDatos = dtoSalidaEliminarNiveles.getAsociaciones().esVacio();

				if (noHuboDatos) {
                    asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");       
                    getConfiguracionMenu("LPEliminarAsociacionNiveles", "" );
                    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } else {
                    getConfiguracionMenu("LPEliminarAsociacionNiveles", "BuscarAsociacion" );
                }

			}
			else if ( accion.equals("BuscarAsociacion") )
			{
				traza("pais    " + strPais);
				//buscar los NSE asociados al pais seleccionado por el usuario
				dtoInternacional = new DTOInternacional(); 							
				id = new MareBusinessID("SEGBuscarAsociaciones");
				dtoInternacional.setOidPais((strPais==null || strPais.length()==0?null:Long.valueOf(strPais)));
				dtoInternacional.setOidIdioma(idioma);
				paramEntPais.addElement(dtoInternacional);
				paramEntPais.addElement(id);
				DruidaConector conectorPaises = conectar("ConectorBuscarAsociacionesNiveles",paramEntPais);
				traza(conectorPaises.getXML());

				asignar("COMBO","comboPais", conectorPaises, "dtoSalida.paises_ROWSET");
				asignarAtributo("VAR", "hidPais", "valor", strPais);
				asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);

				PaginaEliminarNivelesDTO dtoSalidaEliminarNiveles  = (PaginaEliminarNivelesDTO) conectorPaises.objeto("DTOSalidaBuscarNiveles");

                boolean noHuboDatos = dtoSalidaEliminarNiveles.getAsociaciones().esVacio();

				if (noHuboDatos) {
                    asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");       
                    getConfiguracionMenu("LPEliminarAsociacionNiveles", "" );
                    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
				asignar("LISTA","lstAsociaciones", conectorPaises, "dtoSalida.asociaciones_ROWSET");				

                getConfiguracionMenu("LPEliminarAsociacionNiveles", "BuscarAsociacion" );

			}
			else if ( accion.equals("eliminar") )
			{
        pagina("salidaGenerica");
        
				traza("elementosSeleccionados: " + elementosSeleccionados);
				StringTokenizer stk = new StringTokenizer(elementosSeleccionados,",");
				int largo = stk.countTokens();
				dtoListaElimina = new DTOListaAsociacionNiveles();
                dtoListaElimina.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
                dtoListaElimina.setPrograma(UtilidadesSession.getFuncion(this));

				while (stk.hasMoreTokens())
				{
					dtoElimina = new AsociacionNivelesDTO();
					dtoElimina.setOidPais((strPais==null || strPais.length()==0?null:Long.valueOf(strPais)));
					StringTokenizer stk1 = new StringTokenizer(stk.nextToken(),"--");
					idAsociacion = stk1.nextToken();
					dtoElimina.setOidAsociacionNiveles( (idAsociacion==null || idAsociacion.length()==0?null:Long.valueOf(idAsociacion)) );	
					traza("dtoElimina: " + dtoElimina);
					arrayElimina.add(dtoElimina);
				}
				dtoListaElimina.setAsociaciones((AsociacionNivelesDTO[])arrayElimina.toArray(new AsociacionNivelesDTO[0]));

				id = new MareBusinessID("SEGElminarAsociacionNiveles");
				paramEntrada.addElement(dtoListaElimina);
				paramEntrada.addElement(id);

        traza("ConectorEliminarAsociacionNiveles");
				DruidaConector conectorEliminarAsociacionNiveles = conectar("ConectorEliminarAsociacionNiveles",paramEntrada);
        traza("Eliminacion concretada.");

        asignarAtributo("VAR","ejecutar","valor","elimineOk('" + pais.toString() +"');");

				/*
        asignarAtributo("VAR", "hidPais", "valor", pais.toString());
				asignarAtributo("VAR", "CasoDeUso", "valor", "eliminar");

        getConfiguracionMenu("LPEliminarAsociacionNiveles", "eliminar" );

				//buscar los NSE asociados al pais tomado de sesion
				dtoInternacional = new DTOInternacional();
				id = new MareBusinessID("SEGBuscarAsociaciones");
				dtoInternacional.setOidPais(new Long(strPais));
				dtoInternacional.setOidIdioma(idioma);
				paramEntPais.addElement(dtoInternacional);
				paramEntPais.addElement(id);

        traza("recargo, luego de eliminar con pais: " + dtoInternacional.getOidPais());

				DruidaConector conectorPaises = conectar("ConectorBuscarAsociacionesNiveles",paramEntPais);

				asignar("COMBO","comboPais", conectorPaises, "dtoSalida.paises_ROWSET");
				asignarAtributo("VAR", "hidPais", "valor", strPais);
				asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);
				
				PaginaEliminarNivelesDTO dtoSalidaEliminarNiveles  = (PaginaEliminarNivelesDTO) conectorPaises.objeto("DTOSalidaBuscarNiveles");

        boolean noHuboDatos = dtoSalidaEliminarNiveles.getAsociaciones().esVacio();

				if (noHuboDatos) {
                    asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");       
                    getConfiguracionMenu("LPEliminarAsociacionNiveles", "" );
                    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
				asignar("LISTA","lstAsociaciones", conectorPaises, "dtoSalida.asociaciones_ROWSET");				
        */

			}
			
		} catch (Exception ex ) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","ejecutarError","valor","noPersistio();");
            asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);
		} 
	}

 }//fin clase
