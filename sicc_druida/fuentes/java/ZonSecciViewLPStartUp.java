/*
    INDRA/CAR/mmg
    $Id: ZonSecciViewLPStartUp.java,v 1.1 2009/12/03 18:35:31 pecbazalar Exp $
    DESC
*/
import java.util.*;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;

import es.indra.utils.*;
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.belcorp.MMGNoLanguageException;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import java.text.DecimalFormatSymbols;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class ZonSecciViewLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 399;
	public static final short CREATEFORM_SIZE = 381;
	public static final short UPDATEFORM_SIZE = 381;
	public static final short VIEWFORM_SIZE = 381;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGZonSecciViewQueryFromToUserPage";
	
	
				public static final String BUSINESSID_ZZONOIDZONA_CANAOIDCANA_QUERY ="MMGSegCanalViewQueryFromToUser";
				public static final String BUSINESSID_ZZONOIDZONA_MARCOIDMARC_QUERY ="MMGSegMarcaQueryFromToUser";
				public static final String BUSINESSID_ZZONOIDZONA_QUERY ="MMGZonZonaViewQueryFromToUser";
				public static final String ZZONOIDZONA_CANAOIDCANA_COMBO_CONNECTOR = "SegCanalViewConectorCombo";
	
				public static final String ZZONOIDZONA_MARCOIDMARC_COMBO_CONNECTOR = "SegMarcaConectorCombo";
	
				public static final String ZZONOIDZONA_COMBO_CONNECTOR = "ZonZonaViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public ZonSecciViewLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("ZonSecciViewPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			this.getFormatosValidaciones();

			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("ZonSecciView");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "ZonSecciViewPage", "cod", "ZonSecciView." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Establecemos los valores por defecto de la entidades estructurales
			setDefaultStructuralValues();
			
			//Limpiamos la botonera
			limpiarBotoneraLista("zonSecciView", accion);
			
			
			
			
			
			//Ejecutanos la acción solicitada		
			System.out.println("accion " + accion + " origen " + origen);
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los TRs del formulario que no tengan campos
			eliminarTrsVacios(accion, origen);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo lov*/
	protected void cmdLov() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
	
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
		asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "zonSecciViewLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "ZonSecciViewPage", "onblur", "window.focus();");
		
		//Borramos los elementos de internacionalización()
		removeLocalizationElements();
		removeNonSearchElements();
	}

	/**Acción previa para poder permitir la carga de datos en el formulario 
	de view con ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreView() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos a la acción de view pasando la accion, y la acción anterior y actulizando el origen
		conectorAction("ZonSecciViewLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view
	*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		ZonSecciViewData zonSecciViewQuery= new ZonSecciViewData();
		zonSecciViewQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		ZonSecciViewData datosResult = (ZonSecciViewData)getSingleObject(BUSINESSID_QUERY, zonSecciViewQuery, 
			zonSecciViewQuery.clone(), "zonSecciView");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		ZonSecciViewData zonSecciView = datosResult;
		asignar("TEXT", "codSecc", FormatUtils.formatObject(zonSecciView.getCodSecc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indActi", FormatUtils.formatObject(zonSecciView.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indBorr", FormatUtils.formatObject(zonSecciView.getIndBorr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse1", FormatUtils.formatObject(zonSecciView.getCodNse1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse2", FormatUtils.formatObject(zonSecciView.getCodNse2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse3", FormatUtils.formatObject(zonSecciView.getCodNse3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desSecci", FormatUtils.formatObject(zonSecciView.getDesSecci(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZona = zonSecciView.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codSecc", "disabled", "S");
		asignarAtributo("TEXT", "indActi", "disabled", "S");
		asignarAtributo("TEXT", "indBorr", "disabled", "S");
		asignarAtributo("TEXT", "codNse1", "disabled", "S");
		asignarAtributo("TEXT", "codNse2", "disabled", "S");
		asignarAtributo("TEXT", "codNse3", "disabled", "S");
		asignarAtributo("TEXT", "desSecci", "disabled", "S");
		
									asignarAtributo("COMBO", "zzonOidZona_canaOidCana", "disabled", "S");

									asignarAtributo("COMBO", "zzonOidZona_marcOidMarc", "disabled", "S");

					asignarAtributo("COMBO", "zzonOidZona", "disabled", "S");
		
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeNonViewElements();
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codSecc", "req", "S");
		asignarAtributo("COMBO", "zzonOidZona", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
		asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		
		//Ponemos la pagina en modo view: 
		//Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		removeLovElements();
		removeQueryElements();
		removeNonInsertElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo remove*/
	protected void cmdRemove() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
		asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		//Cargamos las combos finales de las jerarquías de herencia
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}else loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
		asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
		asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
		
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Cargamos las combos finales de las jerarquías de herencia
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}loadLeafDependenceCombos(null);

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("ZonSecciViewLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Prepara el formulario para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "zonSecciViewFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codSecc", "req", "S");
				asignarAtributo("COMBO", "zzonOidZona", "req", "S");
		
		//Asignamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
		userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			asignarAtributo("TEXT", "codSecc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
			asignarAtributo("TEXT", "indActi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indBorr", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "codNse1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			asignarAtributo("TEXT", "codNse2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			asignarAtributo("TEXT", "codNse3", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			asignarAtributo("TEXT", "desSecci", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 40);");
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando ZonSecciView");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		ZonSecciViewData zonSecciViewQuery= new ZonSecciViewData();
		zonSecciViewQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		ZonSecciViewData  datosResult = (ZonSecciViewData)getSingleObject(BUSINESSID_QUERY, zonSecciViewQuery, 
			zonSecciViewQuery.clone(), "zonSecciView");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		ZonSecciViewData zonSecciView = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codSecc", FormatUtils.formatObject(zonSecciView.getCodSecc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indActi", FormatUtils.formatObject(zonSecciView.getIndActi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indBorr", FormatUtils.formatObject(zonSecciView.getIndBorr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse1", FormatUtils.formatObject(zonSecciView.getCodNse1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse2", FormatUtils.formatObject(zonSecciView.getCodNse2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codNse3", FormatUtils.formatObject(zonSecciView.getCodNse3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "desSecci", FormatUtils.formatObject(zonSecciView.getDesSecci(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZona = zonSecciView.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(zonSecciView.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
		/** por eloy mier pérez para agregar funcionalidad de desactivacion de campos */
		traza("MMG: antes de llamar a desactivateNonModifyFields .....");
		desactivateNonModifyFields();
		traza("MMG: despues de llamar a desactivateNonModifyFields ......");
		/** 
			por eloy mier pérez para agregar funcionalidad de desactivacion de campos
			para reescribir funciones ontab y onshtab.
		 */
		cambiarAcciones();
	}

	/**
		Por EMP.
		Nos permite cambiar el evento ontab y onshtab de los objetos druida necesarios en el modo
		de modificación.
	*/
	protected void cambiarAcciones() throws Exception{
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codSecc", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codSecc", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indActi", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indActi", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indBorr", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indBorr", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codNse1", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codNse1", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codNse2", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codNse2", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "codNse3", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "codNse3", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
				asignarAtributo("AREATEXTO", "desSecci", "ontab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
				asignarAtributo("AREATEXTO", "desSecci", "onshtab","ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
					asignarAtributo("COMBO","zzonOidZona_canaOidCana", "ontab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
					asignarAtributo("COMBO","zzonOidZona_canaOidCana", "onshtab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
					asignarAtributo("COMBO","zzonOidZona_marcOidMarc", "ontab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
					asignarAtributo("COMBO","zzonOidZona_marcOidMarc", "onshtab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
					asignarAtributo("COMBO","zzonOidZona", "ontab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, true)");
					asignarAtributo("COMBO","zzonOidZona", "onshtab", "ejecutarAccionFocoModificacion(\"zonSecciViewFrm\",0, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","zonSecciViewTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","zonSecciViewTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es codSecc...");		
				
				traza("MMG: el atributo es indActi...");		
				
				traza("MMG: el atributo es indBorr...");		
				
				traza("MMG: el atributo es codNse1...");		
				
				traza("MMG: el atributo es codNse2...");		
				
				traza("MMG: el atributo es codNse3...");		
				
				traza("MMG: el atributo es desSecci...");		
				
				traza("MMG: el atributo es zzonOidZona...");		
				
		}

	/**
	* Nos permite establecer el tamaño de las capas de la pantalla según el modo
	* Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	*/
	protected void establecerSizeCapas(String accion, String origen) throws Exception{
		//Dependiendo del modo el tamaño del formualrio será uno u otro
		int sizeForm = 0;
		if(accion.equals(ACCION_LOV)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_VIEW)) sizeForm = VIEWFORM_SIZE;
		else if(accion.equals(ACCION_CREATE)) sizeForm = CREATEFORM_SIZE;
		else if(accion.equals(ACCION_REMOVE)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_QUERY)) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) sizeForm = QUERYFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) sizeForm = UPDATEFORM_SIZE;
		else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) sizeForm = UPDATEFORM_SIZE;
		
		//Establecemos el tamaño de la capa del formulario
		asignarAtributo("CAPA","zonSecciViewFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","zonSecciViewListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","zonSecciViewListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(ZonSecciViewData zonSecciView) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegCanalViewData zzonOidZona_canaOidCana = new SegCanalViewData();
		SegMarcaData zzonOidZona_marcOidMarc = new SegMarcaData();
		
						asignarComboResultados(BUSINESSID_ZZONOIDZONA_CANAOIDCANA_QUERY,ZZONOIDZONA_CANAOIDCANA_COMBO_CONNECTOR, 
			zzonOidZona_canaOidCana, zzonOidZona_canaOidCana.clone(), "segCanalView", "zzonOidZona_canaOidCana", "result_ROWSET" );
		if(zonSecciView != null && zonSecciView.getZzonOidZona().getCanaOidCana() != null){
				checkCombo("zzonOidZona_canaOidCana" , zonSecciView.getZzonOidZona().getCanaOidCana().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_ZZONOIDZONA_MARCOIDMARC_QUERY,ZZONOIDZONA_MARCOIDMARC_COMBO_CONNECTOR, 
			zzonOidZona_marcOidMarc, zzonOidZona_marcOidMarc.clone(), "segMarca", "zzonOidZona_marcOidMarc", "result_ROWSET" );
		if(zonSecciView != null && zonSecciView.getZzonOidZona().getMarcOidMarc() != null){
				checkCombo("zzonOidZona_marcOidMarc" , zonSecciView.getZzonOidZona().getMarcOidMarc().getId().toString());
			}
		String zzonOidZona_canaOidCanaDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanalView");
		if(zzonOidZona_canaOidCanaDefaultValue != null && !zzonOidZona_canaOidCanaDefaultValue.trim().equals("")){
			checkCombo("zzonOidZona_canaOidCana", zzonOidZona_canaOidCanaDefaultValue);
			checkedCombos.put("zzonOidZona_canaOidCana",zzonOidZona_canaOidCanaDefaultValue);
			cascadeComboLoad(checkedCombos, "zzonOidZona_canaOidCana");
		}						 
		String zzonOidZona_marcOidMarcDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegMarca");
		if(zzonOidZona_marcOidMarcDefaultValue != null && !zzonOidZona_marcOidMarcDefaultValue.trim().equals("")){
			checkCombo("zzonOidZona_marcOidMarc", zzonOidZona_marcOidMarcDefaultValue);
			checkedCombos.put("zzonOidZona_marcOidMarc",zzonOidZona_marcOidMarcDefaultValue);
			cascadeComboLoad(checkedCombos, "zzonOidZona_marcOidMarc");
		}						 
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("zzonOidZona_canaOidCana")  || comboName.trim().equals("zzonOidZona_marcOidMarc") ){
			String zzonOidZona_canaOidCanaDefaultValue = (String)checkedCombos.get("zzonOidZona_canaOidCana");
			String zzonOidZona_marcOidMarcDefaultValue = (String)checkedCombos.get("zzonOidZona_marcOidMarc");
			if(zzonOidZona_canaOidCanaDefaultValue != null &&zzonOidZona_marcOidMarcDefaultValue != null){
				ZonZonaViewData zzonOidZona= new ZonZonaViewData();
				es.indra.belcorp.mso.SegCanalViewData zzonOidZonaCanaOidCana = new es.indra.belcorp.mso.SegCanalViewData();
				zzonOidZonaCanaOidCana.setId(new Long(zzonOidZona_canaOidCanaDefaultValue ));
				zzonOidZona.setCanaOidCana(zzonOidZonaCanaOidCana);
				es.indra.belcorp.mso.SegMarcaData zzonOidZonaMarcOidMarc = new es.indra.belcorp.mso.SegMarcaData();
				zzonOidZonaMarcOidMarc.setId(new Long(zzonOidZona_marcOidMarcDefaultValue ));
				zzonOidZona.setMarcOidMarc(zzonOidZonaMarcOidMarc);
				asignarComboResultados(BUSINESSID_ZZONOIDZONA_QUERY,ZZONOIDZONA_COMBO_CONNECTOR, 
					zzonOidZona, zzonOidZona.clone(), "zonZonaView", "zzonOidZona", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param zonSecciView La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(ZonSecciViewData zonSecciView) 
		throws Exception{
		
						if(zonSecciView.getZzonOidZona() != null){
			
						ZonZonaViewData zzonOidZona = new ZonZonaViewData();
			zzonOidZona.setCanaOidCana(zonSecciView.getZzonOidZona().getCanaOidCana());
			zzonOidZona.setMarcOidMarc(zonSecciView.getZzonOidZona().getMarcOidMarc());
			asignarComboResultados(BUSINESSID_ZZONOIDZONA_QUERY,ZZONOIDZONA_COMBO_CONNECTOR, zzonOidZona, zzonOidZona.clone(), "zonZonaView", "zzonOidZona", "result_ROWSET");
			checkCombo("zzonOidZona" , zonSecciView.getZzonOidZona().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		ZonSecciViewData zonSecciView = 
			(ZonSecciViewData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(zonSecciView.getZzonOidZona() != null){
			zonSecciView.setZzonOidZona((es.indra.belcorp.mso.ZonZonaViewData)
			getSingleObject(BUSINESSID_ZZONOIDZONA_QUERY, 
			zonSecciView.getZzonOidZona(),
			zonSecciView.getZzonOidZona().clone(),
			"zonZonaView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(zonSecciView);
		loadLeafDependenceCombos(zonSecciView);
	}
	
	/**
	*	Por defecto en los campos que tienen la búsqueda por intervalo el label del campo es el label
	*	correspondiente a campos normal (como si no fuera un campo con intervalor). En los modos de busqueda 
	*	(search, update search y remove search) tendremos que poner el label a la búsqueda "desde"
	*/
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/**
	*	Metodo que nos elimina los trs que quedan vacíos por no aparecer sus campos por el modo
	*/
	protected void eliminarTrsVacios(String accion, String origen) throws Exception{
		if(accion.equals(ACCION_QUERY) || accion.equals(ACCION_LOV) ||
			(accion.equals(ACCION_UPDATE) && origen.equals("menu")) ||
			(accion.equals(ACCION_REMOVE) && origen.equals("menu"))){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			
		}
	}
	
	
	
		
}





