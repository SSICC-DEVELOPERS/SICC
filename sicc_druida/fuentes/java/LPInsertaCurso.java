/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */ 
 /*
    INDRA/EDU/PROY
    $Id: LPInsertaCurso.java,v 1.2 2010/01/14 15:21:46 peextsapaza Exp $
    DESC
 */


import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTOCurso;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import java.util.HashMap;
import java.util.TimeZone;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import es.indra.mare.common.exception.MareException;


// Definicion de la clase
public class LPInsertaCurso extends LPUtilidadesEDU {

	public LPInsertaCurso() {super();}

	private String accion		= null;
          
	public void inicio() throws Exception {
		pagina("contenido_cursos_seleccionar");
	}

	public void ejecucion() throws Exception {
		
		rastreo();

		this.accion = conectorParametroLimpia("accion", "", true);

		try {
			setTrazaFichero();
			if (accion.equals("")) {
				traza("*** Entrada - LPInsertaCurso - accion vacia XXX***");
				Long idioma = UtilidadesSession.getIdioma(this);
				asignar("VAR", "idioma", idioma.toString());
				Long pais = UtilidadesSession.getPais(this);
				asignar("VAR", "pais", pais.toString());
                           
				getConfiguracionMenu("LPInsertaCurso", "aceptar");
				traza("*** Salida - LPInsertaCurso - accion vacia ***");
			} else if (accion.equals("aceptar")) {
				/*
				 * - Llamamos oid al oid se la plantilla seleccionada y se invoca a 
				 * muestraDetalleCurso(obtieneDetallesPlantilla(oid), false); 
				 */
				traza("*** Entrada - LPInsertaCurso - accion aceptar ***");
				String oid = conectorParametroLimpia("listado1", "", true);
				// Se define la p�gina que se va a mostrar
				pagina("contenido_cursos_insertar");
				asignarAtributo("VAR", "Plantilla", "valor", oid);
                           
				//los hidden idioma y pais se necesitan para la recarga de combos
				Long pais = UtilidadesSession.getPais(this);
				Long idioma = UtilidadesSession.getIdioma(this);
				asignarAtributo("VAR", "idioma", "valor", idioma.toString());
				asignarAtributo("VAR", "pais", "valor", pais.toString());
				asignarAtributo("VAR", "casoUso", "valor", "insertar");
				
				String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
				String separadorMiles = ",";
				if (separadorDecimales.equals(",")) separadorMiles = ".";
				asignar("VAR","hid_SeparadorMiles", separadorMiles);
				asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
				asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
				this.generarHiddenFormatoFecha();
				anyadeHiddensI18N(true, "EDU_MATRI_CURSO", null, new Integer(1), "formularioInsertarCurso", "txtNombreCurso", false); //

				this.muestraDetallesCurso(this.obtieneDetallesPlantilla(Long.valueOf(oid)), new Boolean(false));

				getConfiguracionMenu("LPInsertaCurso", "guardar");
				traza("*** Salida - LPInsertaCurso - accion aceptar ***");
			} else if (accion.equals("guardar")) {
				traza("*** Entrada - LPInsertaCurso - accion guardar ***");
				pagina("salidaGenerica");
				asignar("VAR", "cerrarVentana", "true");
				//asignar("VAR", "ejecutar", "ejecutaLimpia()");
				this.guardaCurso();
				traza("***Salida - LPInsertaCurso - accion guardar ***");
			}
		} catch (Exception ex) {
			//preservaHiddensI18n(new Integer(1), "EDU_MATRI_CURSO", "formularioInsertarCurso", "txtNombreCurso", false);
			logStackTrace(ex);
			this.lanzarPaginaError(ex);   
		}
	}            	

	/*
	 * 15/02/2006 [1] pperanzola : se modifica setCursosRecibidos por setCursosExigidos
	 */
	private void guardaCurso() throws Exception {
		/*
		 * - Se instancia un DTOCurso y se rellena con toda la informaci�n que aparece en pantalla. Los campos que no aparezcan se rellenan como null. En el apartado de notas adjunto el mapeo de la pantalla al dto: 

		 * - Se crea idNegocio = "EDUInsertaCurso" 
		 * - Se invoca al conector ConectorEscribeCurso 
		 * - Si se recibe una excepci�n se muestra el detalle de la excepci�n en un mensaje. 
		 */ 
		// Se obtienen los parametros
		Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);


		DTORelacionesCurso dtoRelaciones = new DTORelacionesCurso();
		dtoRelaciones.setOidPais(pais);
		dtoRelaciones.setOidIdioma(idioma);
		DTOCurso dto = new DTOCurso();
		dto.setOidPais(pais);
		dto.setOidIdioma(idioma);
		Date fecha = null;
                           
                           //xxxx pasa a hacerse llamando a un nuevo m�todo
                   			//sdf.setTimeZone(TimeZone.getTimeZone("GMT-03:00")); //cccc sin esto a negocio le llegan fechas restando un d�a a la fecha
                   			
                           //xxxx
                          
		String parametro = conectorParametroLimpia("Plantilla", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPlantilla(Long.valueOf(parametro));  

		parametro = conectorParametroLimpia("cbMarca", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidMarca(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbCanal", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidCanal(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbTipoCurso", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidTipoCurso(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtObjetivoCurso", "", true);
		if(!parametro.equals(""))
			dto.setObjetivo(parametro);

		parametro = conectorParametroLimpia("txtContenidoCurso", "", true);
		if(!parametro.equals(""))
			dto.setContenido(parametro);

		parametro = conectorParametroLimpia("cbAccesoInfo", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidAcceso(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("rbAccesoSeleccion", "", true);
		dto.setAccesoDataMart(this.obtieneBoolean(parametro));

		/*parametro = conectorParametroLimpia("txtPath", "", true);
		if(!parametro.equals(""))
			dto.setPathFichero(parametro);*/

		parametro = conectorParametroLimpia("cbFrecuenciaDictado", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidFrecuencia(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtFechaDisponible", "", true);
		if(!parametro.equals(""))
			dto.setFechaDisponible(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("txtFechaLanzamiento", "", true);
		if(!parametro.equals(""))
			dto.setFechaLanzamiento(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("txtFechaFinalizacion", "", true);
		if(!parametro.equals(""))
			dto.setFechaFin(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("rbAlcanceGeoNacional", "", true);
		dto.setAlcance(this.obtieneBoolean(parametro));

		parametro = conectorParametroLimpia("cbSubVentas", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidSubgerencia(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbRegion", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidRegion(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbZona", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidZona(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbSeccion", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidSeccion(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbTerritorio", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidTerritorio(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtOptimoParticipantes", "", true);
		if(!parametro.equals(""))
			dto.setNumeroParticipantes(Integer.valueOf(parametro));

		parametro = conectorParametroLimpia("rbBloqueo", "", true);
		dto.setBloqueoExtemporaneas(this.obtieneBoolean(parametro));

		parametro = conectorParametroLimpia("txtMaterialAEmplear", "", true);
		if(!parametro.equals(""))
			dto.setRelacionMaterial(parametro);

		parametro = conectorParametroLimpia("cbCapacitador", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidCapacitador(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtNOrdenes", "", true);
		if(!parametro.equals(""))
			dto.setNumeroOrdenes(Integer.valueOf(parametro));

		//Cursos requeridos
		Long cursosRequeridos[] =null;
		parametro = conectorParametroLimpia("cbCursosExigidos", "", true);
		if(!parametro.equals("")) {
			java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, "|");
			if (st.countTokens() > 0){
				cursosRequeridos = new Long[st.countTokens()];
                                             
				for (int i = 0; i < cursosRequeridos.length; i++) {
					cursosRequeridos[i] = Long.valueOf (st.nextToken());
				}
			}
		}

		parametro = conectorParametroLimpia("txtMontoVentasComp", "", true);
		if(!parametro.equals(""))
			dto.setMontoVentas( new BigDecimal(this.quitaSeparadorMiles(parametro)));

		parametro = conectorParametroLimpia("txtFechaUltimo", "", true);
		if(!parametro.equals(""))
			dto.setFechaUltimo(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("rbCondicionPedido", "", true);
		dto.setCondicionPedido(this.obtieneBoolean(parametro));

		parametro = conectorParametroLimpia("rbControlMorosidad", "", true);
		dto.setControlMorosidad(this.obtieneBoolean(parametro));

		parametro = conectorParametroLimpia("areaDescDetallada", "", true);
		if(!parametro.equals(""))
			dto.setDescripcion(parametro);

		parametro = conectorParametroLimpia("cbTipoCliente", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidTipoCliente(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbSubtipoCliente", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidSubtipoCliente(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbClasificacion", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidClasificacion(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbTipoClasificacion", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidTipoClasificacion(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbEstatusCli", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidStatusCliente(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbPerConstInicio", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPeriodoIniConstancia(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbPerConstFin", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPeriodoFinConstancia(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbPerVentInicio", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPeriodoIniComparativo(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbPerVentFin", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPeriodoFinComparativo(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("cbPerIngresoCondicion", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidPeriodoIngreso(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtFechaIngresoCondicion", "", true);
		if(!parametro.equals(""))
			dto.setFechaIngreso(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this))).getTime()));

		parametro = conectorParametroLimpia("txtNPeriodosCondicion", "", true);
		if(!parametro.equals(""))
			dto.setNumeroCampanyas(Integer.valueOf(parametro));

		parametro = conectorParametroLimpia("cbProductoAEntregar", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidRegalo(Long.valueOf(parametro));

		parametro = conectorParametroLimpia("txtUniRegalo", "", true);
		if(!parametro.equals(""))
			dto.setNumeroUnidades(Integer.valueOf(parametro));

		parametro = conectorParametroLimpia("cbMomentoEntrega", "", true);
		if(!parametro.equals(""))
			dtoRelaciones.setOidMomentoEntrega(Long.valueOf(parametro));

		dto.setRelacion(dtoRelaciones);
		dto.setCursosExigidos(cursosRequeridos); //[1]

		Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));
		DTOI18nSICC idiomas [] = null;
		if (vIdiomas != null){
			idiomas = new DTOI18nSICC[vIdiomas.size()];
			for (int i = 0; i < vIdiomas.size(); i++){
				idiomas [i] = (DTOI18nSICC)vIdiomas.get(i);
			}
		} 
                           
		dto.setAttriTraducible(idiomas);
          
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("EDUInsertaCurso"));
          
		DruidaConector conector = conectar("ConectorEscribeCurso", paramEntrada);
                          
	}
                  
	private Boolean obtieneBoolean(String parametro) {
		if(parametro.equals("N"))
			return new Boolean(false);
		else if (parametro.equals("S")) 
			return new Boolean(true);
		return null;
	}

	private String quitaSeparadorMiles(String parametro) {
		String resultado = "";
		String separadorMiles = ",";
		if ((UtilidadesSession.getSeparadorDecimales(this)).equals(",")) separadorMiles = ".";

		if (parametro != null) {
			//quitar separador miles
			java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, separadorMiles);
			while (st.countTokens() > 0){
				resultado += st.nextToken();
			}
			//Convertir separador decimal a '.' si es necesario
			if (UtilidadesSession.getSeparadorDecimales(this).equals(","))
				resultado = resultado.replace(',', '.' );

			return resultado;
		}else return null;
	}
             	
}

