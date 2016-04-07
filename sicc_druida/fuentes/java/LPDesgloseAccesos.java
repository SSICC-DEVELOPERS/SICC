/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       04/11/2004
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

public class LPDesgloseAccesos extends LPSICCBase{
	SimpleDateFormat formato;
	private String accion;
    
	public LPDesgloseAccesos(){
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
        //traza("> Entrando a LPDesgloseAccesos.ejecucion");
		accion = conectorParametroLimpia("accion", "", true);
		traza("Accion de sesion: " + accion);
		try{
		    
			if( accion.equals("") ){
				cargarPagina();
   			    getConfiguracionMenu("LPDesgloseAccesos", "buscar");

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
	 * Fecha:       04/11/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Realiza la carga inicial de la página.  Esto se produce
	 * 				cuando un hay acción definida.
	 */
	private void cargarPagina() throws Exception{
		// Asignar página "contenido_desglose_acceso_consultar" 
		pagina("contenido_desglose_acceso_consultar");
		asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
		asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
		// Crear variable llamada "datosDesglose" de tipo DTOEDesglose haciendo el siguiente mapeo: 
		DTOEDesglose datosDesglose = new DTOEDesglose();
		// -> datosDesglose.fechaInicio = fecha inicio de la pantalla llamante 
		// -> datosDesglose.fechaFin = fecha fin de la pantalla llamante 
		// -> datosDesglose.tipoSolicitud = tipo de solicitud de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.zona = zona de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.grupoProcesos = grupo de procesos marcado de la línea seleccionada en la pantalla llamante 
		// -> datosDesglose.tipoDesglose = ConstantesDesglosesPED.DESGLOSE_ACCESO 
		// -> datosDesglose.hacerPaginacion = "false" 

		String dato = conectorParametroLimpia("fechaInicio", "", true);
		//traza("Fecha inicio: " + dato);

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
		datosDesglose.setTipoDesglose(ConstantesDesglosesPED.DESGLOSE_ACCESO);
		// AGREGADO: Setear idioma y pais en datosDesglose
		datosDesglose.setOidIdioma(UtilidadesSession.getIdioma(this));
		datosDesglose.setOidPais(UtilidadesSession.getPais(this));
		datosDesglose.setHacerPaginacion(Boolean.FALSE);
		// -> Crear idBusiness = "PEDCargarPaginaDesglose
		MareBusinessID id = new MareBusinessID("PEDCargarPaginaDesglose");
		// Asignar conector "ConectorCargarPaginaDesglose" con idBusiness y dto creados 
		Vector parametros = new Vector();
		parametros.add(datosDesglose);
		parametros.add(id);
		// -> Asignar conector "ConectorCargarPaginaDesglose" con idBusiness y dto creados 
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


	private void desglose() throws Exception{
		//traza(">>> Entro a desglose");
		// -> Crear variable "datosDesglose" de tipo DTOEDesglose y hacer el siguiente mapeo: 
		DTOEDesglose datosDesglose = new DTOEDesglose();
		//traza("21");
		// -> datosDesglose.fechaInicio = fechaInicio de pantalla 
		String dato = conectorParametroLimpia("fechaInicio", "", true);
		//traza("22");
       // SimpleDateFormat formato = new SimpleDateFormat(UtilidadesSession.getFormatoFecha(this));
		
		String formatString = UtilidadesSession.getFormatoFecha(this);
  	    formatString = formatString.replace('m','M'); 
		SimpleDateFormat formato = new SimpleDateFormat(formatString);

		//traza("23");
		if( !dato.equals("") ){
		//traza("24");
			Date aux = formato.parse(dato);
		//traza("25");
			datosDesglose.setFechaInicio( new java.sql.Date(aux.getTime()) );
		//traza("26");
			//traza("Fecha inicio: " + datosDesglose.getFechaInicio().toString() );
		}
		// -> datosDesglose.fechaFin = fechaFin de pantalla 
		//traza("27");
		dato = conectorParametroLimpia("fechaFin", "", true);
		//traza("28");
		if( !dato.equals("") ){
		//traza("29");
			Date aux = formato.parse(dato);
		//traza("30");
			datosDesglose.setFechaFin(new java.sql.Date(aux.getTime()));
		//traza("31");
			//traza("Fecha fin: " + datosDesglose.getFechaFin().toString());
		}
		// -> datosDesglose.tipoSolicitud = oidTipoSolicitud de pantalla 
		//traza("32");
		dato = conectorParametroLimpia("oidTipoSolicitud", "", true);
		//traza("33");
		//traza("oidTipoSolicitud: " + dato);
		//traza("34");
		if( !dato.equals("") ){
     		//traza("35");
			datosDesglose.setTipoSolicitud(new Long(dato));
		}
		// -> datosDesglose.marca = oidMarca de pantalla 
			//traza("36");
		dato = conectorParametroLimpia("oidMarca", "", true);
		//traza("37");
		//traza("oidMarca: " + dato);
		//traza("38");
		if( !dato.equals("") ){
		//traza("39");
			datosDesglose.setMarca(new Long(dato));
		}
		// -> datosDesglose.canal = oidCanal de pantalla 
				//traza("40");
		dato = conectorParametroLimpia("oidCanal", "", true);
				//traza("41");
		//traza("oidCanal: " + dato);
				//traza("42");
		if( !dato.equals("") ){
				//traza("43");
			datosDesglose.setCanal(new Long(dato));
		}
		// -> datosDesglose.zona = oidZona de pantalla 
				//traza("44");
		dato = conectorParametroLimpia("oidZona", "", true);
		//traza("oidZona: " + dato);
				//traza("45");
		if( !dato.equals("") ){
				//traza("46");
			datosDesglose.setZona(new Long(dato));
		}
		// -> datosDesglose.grupoProcesos = oidGrupoProcesos de pantalla 
				//traza("47");
		dato = conectorParametroLimpia("oidGrupoProcesos", "", true);
				//traza("48");
		//traza("oidGrupoProcesos: " + dato);
				//traza("49");
		if( !dato.equals("") ){
				//traza("50");
			datosDesglose.setGrupoProcesos(new Long(dato));
		}
		// -> datosDesglose.acceso = oidAcceso de la línea seleccionada en la lista "detalle" 
				//traza("51");
		dato = conectorParametroLimpia("oidAcceso", "", true);
				//traza("52");
		//traza("oidAcceso: " + dato);
				//traza("53");
		if( !dato.equals("") ){
				//traza("54");
			datosDesglose.setAcceso(new Long(dato));
		}
		// -> Poner "datosDesglose" en la sesión en una variable con el mismo nombre 
		//traza("Datos obtenidos en la pantalla: " + datosDesglose);
		//traza("Seteado en sesion.");
		conectorParametroSesion("datosDesglose", datosDesglose);
		// -> Llamar a la lp "LPDesgloseNumeroSolicitud"
		//traza("Llamando a LP");
		conectorAction("LPDesgloseNumeroSolicitud");
		conectorActionParametro("accion", "acceso");
	}
}
