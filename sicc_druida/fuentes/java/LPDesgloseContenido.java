/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       08/11/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

//import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ped.DTOCargarPaginaDesglose;
import es.indra.sicc.dtos.ped.DTOEDesglose;
import es.indra.sicc.logicanegocio.ped.ConstantesDesglosesPED;
import es.indra.sicc.util.UtilidadesSession;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Vector;



public class LPDesgloseContenido extends LPSICCBase{
	private String accion;

	public LPDesgloseContenido(){
		super();
	}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception{
		// Si acción = "" entonces 
		// -> ejecutar el método privado "cargarPagina()" 
		// Si acción = "desglose" entonces 
		// -> ejecutar el método privado "desglose()" 
		// Fin Si 
		setTrazaFichero();
        //traza("> Entrando a LPDesgloseTipoSubtipoClasificacion.ejecucion");
        accion = conectorParametroLimpia("accion", "", true);
		traza("Accion de sesion: " + accion);
		try{
			if( accion.equals("") ){
				cargarPagina();
				getConfiguracionMenu("LPDesgloseContenido", "buscar");
			}
			if( accion.equals("desglose") ){
				desglose();
			}
		} catch(Exception e){
			traza("> EXCEPCION: " + e.toString());
			//traza("Lanzando página error");
			lanzarPaginaError(e);
			//traza("--- Página lanzada ---");
		}
	}	


	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       01/11/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Realiza la carga inicial de la página.  Esto se produce
	 * 				cuando un hay acción definida.
	 */
	private void cargarPagina() throws Exception{
		// -> Asignar página "contenido_desglose_contenido_consultar" 
		pagina("contenido_desglose_contenido_consultar");
		asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
		asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
		// -> Crear variable llamada "datosDesglose" de tipo DTOEDesglose haciendo el siguiente mapeo: 
		DTOEDesglose datosDesglose = new DTOEDesglose();
		// -> datosDesglose.fechaInicio = fecha inicio de la pantalla llamante 
		// -> datosDesglose.fechaFin = fecha fin de la pantalla llamante 
		// -> datosDesglose.tipoSolicitud = tipo de solicitud de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.zona = zona de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.grupoProcesos = grupo de procesos marcado de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.tipoDesglose = ConstantesDesglosesPED.DESGLOSE_CONTENIDO 
		// -> datosDesglose.hacerPaginacion = "false" 
		String dato = conectorParametroLimpia("fechaInicio", "", true);
		
		String formatString = UtilidadesSession.getFormatoFecha(this);
  	    formatString = formatString.replace('m','M'); 
		SimpleDateFormat formato = new SimpleDateFormat(formatString);

		if( !dato.equals("") ){
			Date aux = formato.parse(dato);
			//traza("Fecha casteada");
			datosDesglose.setFechaInicio(new java.sql.Date(aux.getTime()));
		}
		dato = conectorParametroLimpia("fechaFin", "", true);
		//traza("Fecha fin: " + dato);
		if( !dato.equals("") ){
			Date aux = formato.parse(dato);
			datosDesglose.setFechaFin(new java.sql.Date(aux.getTime()));
			//traza("Fecha: " + datosDesglose.getFechaFin().toString());
		}
		dato = conectorParametroLimpia("tipoSolicitud", "", true);
		//traza("Tipo Solicitud: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setTipoSolicitud(new Long(dato));
		}
		dato = conectorParametroLimpia("zona", "", true);
		//traza("Zona: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setZona(new Long(dato));
		}
		dato = conectorParametroLimpia("gp", "", true);
		//traza("GP: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setGrupoProcesos(new Long(dato));
		}
		datosDesglose.setTipoDesglose(ConstantesDesglosesPED.DESGLOSE_CONTENIDO);
		// AGREGADO: Setear idioma y pais en datosDesglose
		datosDesglose.setOidIdioma(UtilidadesSession.getIdioma(this));
		datosDesglose.setOidPais(UtilidadesSession.getPais(this));
		datosDesglose.setHacerPaginacion(Boolean.FALSE);
		// Crear idBusiness = "PEDCargarPaginaDesgloseTSC"
		MareBusinessID id = new MareBusinessID("PEDCargarPaginaDesglose");
		// Asignar conector "ConectorCargarPaginaDesglose" con idBusiness y dto creados 
		Vector parametros = new Vector();
		parametros.add(datosDesglose);
		parametros.add(id);
		DruidaConector conector = conectar("ConectorCargarPaginaDesglose", parametros);
		// -> Recuperar "respuesta" de tipo "DTOCargarPaginaDesglose" y mapear los datos de la pantalla como sigue: 
		DTOCargarPaginaDesglose dto = (DTOCargarPaginaDesglose)conector.objeto("respuesta");
		// -> fechaInicio = respuesta.fechaInicio 
		//traza(">> DTO: " + dto);
		formato = new SimpleDateFormat("dd/MM/yyyy");
		if( datosDesglose.getFechaInicio() != null ){
			asignarAtributo("LABELC", "lblFechaIniX", "valor", formato.format(datosDesglose.getFechaInicio()) );
			asignarAtributo("VAR", "fechaInicio", "valor", formato.format(datosDesglose.getFechaInicio()) );
		}
		// -> fechaFin = respuesta.fechaFin 
		if( datosDesglose.getFechaFin() != null ){
			asignarAtributo("LABELC", "lblFechaFinX", "valor", formato.format(datosDesglose.getFechaFin()) );
			asignarAtributo("VAR", "fechaFin", "valor", formato.format(datosDesglose.getFechaFin()) );
		}
		// -> oidTipoSolicitud = respuesta.oidTipoSolicitud 
		if( dto.getOidTipoSolicitud() != null ){
			asignarAtributo("VAR", "oidTipoSolicitud", "valor", dto.getOidTipoSolicitud().toString());
		}
		// -> tipoSolicitud = respuesta.descripcionTipoSolicitud 
		if( dto.getDescripcionTipoSolicitud() != null ){
			asignarAtributo("LABELC", "lblTipoSollcitudX", "valor", dto.getDescripcionTipoSolicitud());
		}
		// AGREGADO: oidMarca = respuesta.oidMarca
			if( dto.getOidMarca() != null ){
			asignarAtributo("VAR", "oidMarca", "valor", dto.getOidMarca().toString());
		}
		// -> marca = respuesta.descripcionMarca 
		if( dto.getDescripcionMarca() != null ){
			asignarAtributo("LABELC", "lblMarcaX", "valor", dto.getDescripcionMarca());
		}
		// AGREGADO: oidCanal = respuesta.oidCanal
		if( dto.getOidCanal() != null ){
			asignarAtributo("VAR", "oidCanal", "valor", dto.getOidCanal().toString());
		}
		// -> canal = respuesta.descripcionCanal 
		if( dto.getDescripcionCanal() != null ){
			asignarAtributo("LABELC", "lblCanalX", "valor", dto.getDescripcionCanal());
		}
		// -> oidZona = respuesta.oidZona 
		if( dto.getOidZona() != null ){
			asignarAtributo("VAR", "oidZona", "valor", dto.getOidZona().toString());
		}	
		// -> zona = respuesta.descripcionZona 
		if( dto.getDescripcionZona() != null ){
			asignarAtributo("LABELC", "lblZonaX", "valor", dto.getDescripcionZona());
		}
		// -> oidGrupoProcesos = respuesta.oidGrupoProcesos 
		if( dto.getOidGrupoProcesos() != null ){
			asignarAtributo("VAR", "oidGrupoProcesos", "valor", dto.getOidGrupoProcesos().toString());
		}
		// -> grupoProcesos = respuesta.descripcionGrupoProcesos 
		if( dto.getDescripcionGrupoProcesos() != null ){
			asignarAtributo("LABELC", "lblGProcesosX", "valor", dto.getDescripcionGrupoProcesos());
		}
		// -> totalSolicitudes = respueseta.totalSolicitudes 
		if( dto.getTotalSolcitudes() != null ){
			asignarAtributo("LABELC", "lblTotalSolicitudesX", "valor", dto.getTotalSolcitudes().toString());		
		}
		// -> La lista "detalle" se alimentará a través del método "onLoad()"	
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       08/11/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Accion tomada al presionar el botón de desglose.
	 */
	private void desglose() throws Exception{
		traza(">>> Entro a desglose");
		pagina("salidaGenerica");
		traza("Salida Generica");
		// -> Crear variable "datosDesglose" de tipo DTOEDesglose y hacer el siguiente mapeo: 
		DTOEDesglose datosDesglose = new DTOEDesglose();
		// -> datosDesglose.fechaInicio = fechaInicio de pantalla 
		String dato = conectorParametroLimpia("fechaInicio", "", true);
		String formatString = UtilidadesSession.getFormatoFecha(this);
  	    formatString = formatString.replace('m','M'); 
		SimpleDateFormat formato = new SimpleDateFormat(formatString);
		if( !dato.equals("") ){
			Date aux = formato.parse(dato);
			datosDesglose.setFechaInicio( new java.sql.Date(aux.getTime()) );
			traza("Fecha inicio: " + datosDesglose.getFechaInicio().toString() );
		}
		// -> datosDesglose.fechaFin = fechaFin de pantalla 
		dato = conectorParametroLimpia("fechaFin", "", true);
		if( !dato.equals("") ){
			Date aux = formato.parse(dato);
			datosDesglose.setFechaFin(new java.sql.Date(aux.getTime()));
			traza("Fecha fin: " + datosDesglose.getFechaFin().toString());
		}
		// -> datosDesglose.tipoSolicitud = oidTipoSolicitud de pantalla 
		dato = conectorParametroLimpia("oidTipoSolicitud", "", true);
		traza("oidTipoSolicitud: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setTipoSolicitud(new Long(dato));
		}
		// -> datosDesglose.marca = oidMarca de pantalla 
		dato = conectorParametroLimpia("oidMarca", "", true);
		traza("oidMarca: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setMarca(new Long(dato));
		}
		// -> datosDesglose.canal = oidCanal de pantalla 
		dato = conectorParametroLimpia("oidCanal", "", true);
		traza("oidCanal: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setCanal(new Long(dato));
		}
		// -> datosDesglose.zona = oidZona de pantalla 
		dato = conectorParametroLimpia("oidZona", "", true);
		traza("oidZona: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setZona(new Long(dato));
		}
		// -> datosDesglose.grupoProcesos = oidGrupoProcesos de pantalla 
		dato = conectorParametroLimpia("oidGrupoProcesos", "", true);
		traza("oidGrupoProcesos: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setGrupoProcesos(new Long(dato));
		}
		// -> datosDesglose.tipoCliente = oidTipoCliente de la línea seleccionada en la lista "detalle" 
		dato = conectorParametroLimpia("oidTipoCliente", "", true);
		traza("oidTipoCliente: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setTipoCliente(new Long(dato));
		}
		// -> datosDesglose.subtipoCliente = oidSubtipoCliente de la línea seleccionada en la lista "detalle" 
		dato = conectorParametroLimpia("oidSubtipoCliente", "", true);
		traza("oidSubtipoCliente: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setSubtipoCliente(new Long(dato));
		}
		// -> datosDesglose.tipoClasificacion = oidTipoClasificacion de la línea seleccionada en la lista "detalle" 
		dato = conectorParametroLimpia("oidTipoClasificacion", "", true);
		traza("oidTipoClasificacion: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setTipoClasificacion(new Long(dato));
		}
		// -> datosDesglose.clasificacion = oidClasificacion de la línea seleccionada en la lista "detalle" 
		dato = conectorParametroLimpia("oidClasificacion", "", true);
		traza("oidClasificacion: " + dato);
		if( !dato.equals("") ){
			datosDesglose.setClasificacion(new Long(dato));
		}
		// -> Poner "datosDesglose" en la sesión en una variable con el mismo nombre 
		traza("Datos obtenidos en la pantalla: " + datosDesglose);
		traza("Seteado en sesion.");
		conectorParametroSesion("datosDesglose", datosDesglose);
		// -> Llamar a la lp "LPDesgloseNumeroSolicitud"
		traza("Llamando a LP");
		conectorAction("LPDesgloseNumeroSolicitud");		
		conectorActionParametro("accion", "contenido");
	}


}
