//$Id: LPConsultarNivelesSocioeconomicos.java,v 1.1 2009/12/03 18:37:27 pecbazalar Exp $ 
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

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.CodigosError;

import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;


import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;
import es.indra.sicc.dtos.seg.DTOListaAsociacionNiveles;
import es.indra.sicc.dtos.seg.FiltroPaisDTO;
import es.indra.sicc.dtos.seg.DTOInternacional;

import es.indra.sicc.dtos.seg.PaginaEliminarNivelesDTO;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesError;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;

import java.math.BigDecimal;

public class LPConsultarNivelesSocioeconomicos extends LPSICCBase {	
	
	public LPConsultarNivelesSocioeconomicos() {
		super();
	}

	public void inicio() throws Exception {
               pagina("contenido_niveles_socioeconomicos_eliminar");
			   asignarAtributoPagina("cod","046");
			  
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
		traza("strPais    " + strPais);
		UtilidadesSession paisSesion = new UtilidadesSession();
		UtilidadesSession idiomaSesion = new UtilidadesSession();

		Long pais = paisSesion.getPais(this);
		Long idioma = idiomaSesion.getIdioma(this);

		ArrayList arrayElimina = new ArrayList();


		AsociacionNivelesDTO dtoElimina;
		DTOListaAsociacionNiveles dtoListaElimina;
		FiltroPaisDTO dtoPais;
		DTOInternacional dtoInternacional;
		casoDeUso="consultar";
				
		try
		{
			// Rastreo
			rastreo();
			
			if ( accion.equals("") )
			{				
				//buscar los NSE asociados al pais tomado de sesion
				traza("accion null");
				dtoInternacional = new DTOInternacional();
				id = new MareBusinessID("SEGBuscarAsociaciones");
				dtoInternacional.setOidPais(pais);
				dtoInternacional.setOidIdioma(idioma);
				paramEntPais.addElement(dtoInternacional);
				paramEntPais.addElement(id);
				DruidaConector conectorPaises = conectar("ConectorBuscarAsociacionesNiveles",paramEntPais);

				asignar("COMBO","comboPais", conectorPaises, "dtoSalida.paises_ROWSET");
				asignar("LISTA","lstAsociaciones", conectorPaises, "dtoSalida.asociaciones_ROWSET");
				asignarAtributo("VAR", "hidPais", "valor", pais.toString());
				asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);
				asignarAtributo("COMBO", "comboNSEBelcorp", "req", "N");
				asignarAtributo("COMBO", "comboNSEPais", "req", "N");
							
			}
			else if ( accion.equals("BuscarAsociacion") )
			{
				//buscar los NSE asociados al pais seleccionado por el usuario
				traza("accion buscar asociacion");
				dtoInternacional = new DTOInternacional(); 							
				id = new MareBusinessID("SEGBuscarAsociaciones");
				dtoInternacional.setOidPais((strPais==null || strPais.length()==0?null:Long.valueOf(strPais)));
				dtoInternacional.setOidIdioma(idioma);
				paramEntPais.addElement(dtoInternacional);
				paramEntPais.addElement(id);
				DruidaConector conectorPaises = conectar("ConectorBuscarAsociacionesNiveles",paramEntPais);

				asignar("COMBO","comboPais", conectorPaises, "dtoSalida.paises_ROWSET");
				asignarAtributo("VAR", "hidPais", "valor", strPais);
				asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);

				PaginaEliminarNivelesDTO dtoSalidaEliminarNiveles  = (PaginaEliminarNivelesDTO) conectorPaises.objeto("DTOSalidaBuscarNiveles");

                boolean noHuboDatos = dtoSalidaEliminarNiveles.getAsociaciones().esVacio();

				if (noHuboDatos) {
					   asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");       
					   throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }

				asignar("LISTA","lstAsociaciones", conectorPaises, "dtoSalida.asociaciones_ROWSET");
				asignarAtributo("COMBO", "comboNSEBelcorp", "req", "N");
				asignarAtributo("COMBO", "comboNSEPais", "req", "N");
			}
			else {
				traza("por aca no deberia pasar si todo anda bien");
			}
			 
		}
		catch (Exception ex) {

			this.lanzarPaginaError(ex);

			asignarAtributo("VAR", "CasoDeUso", "valor", casoDeUso);
  		asignarAtributo("COMBO", "comboNSEBelcorp", "req", "N");
  		asignarAtributo("COMBO", "comboNSEPais", "req", "N");
			/*conectorAvisoModa l("LPPantallaE rror");			
			conectorAvisoModalParameto("errCodigo","5");*/
		}
		getConfiguracionMenu();
	}

 }//fin clase
