/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiLPStartUp.java,v 1.1 2009/12/03 18:33:24 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CarAsignCodigConfiLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 363;
	public static final short CREATEFORM_SIZE = 363;
	public static final short UPDATEFORM_SIZE = 363;
	public static final short VIEWFORM_SIZE = 363;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCarAsignCodigConfiQueryFromToUserPage";
	public static final String BUSINESSID_ZSGVOIDSUBGVENT_QUERY ="MMGZonSubGerenVentaQueryFromToUser";public static final String ZSGVOIDSUBGVENT_COMBO_CONNECTOR = "ZonSubGerenVentaConectorCombo";
	public static final String BUSINESSID_ZORGOIDREGI_QUERY ="MMGZonRegioQueryFromToUser";public static final String ZORGOIDREGI_COMBO_CONNECTOR = "ZonRegioConectorCombo";
	public static final String BUSINESSID_ZZONOIDZONA_QUERY ="MMGZonZonaQueryFromToUser";public static final String ZZONOIDZONA_COMBO_CONNECTOR = "ZonZonaConectorCombo";
	public static final String BUSINESSID_GRSOOIDGRUPSOLI_QUERY ="MMGCarGrupoSolicQueryFromToUser";public static final String GRSOOIDGRUPSOLI_COMBO_CONNECTOR = "CarGrupoSolicConectorCombo";
	public static final String BUSINESSID_NIRIOIDNIVERIES_QUERY ="MMGCarNivelRiesgQueryFromToUser";public static final String NIRIOIDNIVERIES_COMBO_CONNECTOR = "CarNivelRiesgConectorCombo";
	public static final String BUSINESSID_NIRIOIDNIVERIESINICI_QUERY ="MMGCarNivelRiesgQueryFromToUser";public static final String NIRIOIDNIVERIESINICI_COMBO_CONNECTOR = "CarNivelRiesgConectorCombo";
	public static final String BUSINESSID_PACAOIDPARACART_QUERY ="MMGCarParamCarteQueryFromToUser";public static final String PACAOIDPARACART_COMBO_CONNECTOR = "CarParamCarteConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CarAsignCodigConfiLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CarAsignCodigConfiPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("CarAsignCodigConfi");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CarAsignCodigConfiPage", "cod", "CarAsignCodigConfi." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("carAsignCodigConfi", accion);
			
			
			
			//Ejecutanos la acción solicitada		
			if(accion.equals(ACCION_LOV)) cmdLov();
			else if(accion.equals(ACCION_QUERY)) cmdQuery();
			else if(accion.equals(ACCION_CREATE)) cmdCreate();
			else if(accion.equals(ACCION_REMOVE)) cmdRemove();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("menu")) cmdUpdate();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("pagina")) cmdPreUpdateForm();
			else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) cmdUpdateForm();
			else if(accion.equals(ACCION_VIEW) && origen.equals("pagina")) cmdPreView();
			else if(accion.equals(ACCION_VIEW) && origen.equals("preview")) cmdView();
			
			//Eliminamos los labels del modo view si no estamos en dicho modo. 
			//Si lo estamos, eliminamos los widgets
			if(!accion.equals(ACCION_VIEW)) removeViewLabels();
			else removeWidgets();
			
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
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "carAsignCodigConfiLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CarAsignCodigConfiPage", "onblur", "window.focus();");
		
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
		conectorAction("CarAsignCodigConfiLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		CarAsignCodigConfiData carAsignCodigConfiQuery= new CarAsignCodigConfiData();
		carAsignCodigConfiQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CarAsignCodigConfiData datosResult = (CarAsignCodigConfiData)getSingleObject(BUSINESSID_QUERY, carAsignCodigConfiQuery, 
			carAsignCodigConfiQuery.clone(), "carAsignCodigConfi");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		CarAsignCodigConfiData carAsignCodigConfi = datosResult;
	
	
	
	
	
	
	
		asignarAtributo("LABELC", "lblViewValLineCredInic", "valor", 
				FormatUtils.formatObject(carAsignCodigConfi.getValLineCredInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
	
	
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Eliminamos los elementos correspondientes a la internacionalizacion
		removeLovElements();
		removeQueryElements();
		removeLocalizationElements();
		removeNonViewElements();
		
		
		
		
		
		
		
		
		
		
	}
	
	/**Acciones que se realizan cuando la pantalla se arranca en modo create*/
	protected void cmdCreate() throws Exception{
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
	
		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		asignarAtributo("COMBO", "zorgOidRegi", "req", "S");
		asignarAtributo("COMBO", "zzonOidZona", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRiesInici", "req", "S");
		asignarAtributo("COMBO", "pacaOidParaCart", "req", "S");
		asignarAtributo("TEXT", "valLineCredInic", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		
		
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

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion y lov
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	/**Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();
		
		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Eliminamos los elementos correspondientes a la internacionalizacion
		//elimnamos el botón lov de null selection
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
			
	}
	
	/**Acciones a ejecutar cuando la ventana se abre en modo update*/
	protected void cmdUpdate() throws Exception{
		//Establecemos los codigos de internacionalización para las etiquetas de los campos con búsqueda por intervalo
		setIntervalSearchFromLavels();

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos();
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		
		
		//Actualizamos el legend del formulario para indicar criterios de búsqueda
		asignarAtributo("LABEL", "legendLbl", "cod", "MMGGlobal.legend.searchcriteria.label");

		//Simplemente elimnamos el botón lov de null selection y la internacionalización
		removeLocalizationElements();
		removeLovElements();
		removeNonSearchElements();
		
		//Si hay que hacer requery por volver hacia a tras lo marcamos en las variables de la página
		if(isPerformRequery()){
			loadNonLeafDependenceCombosForRequery();
			performActionForRequery();
		}
	}

	
	/**Acción previa para poder permitir la carga de datos en el formulario 
	de updatecon ventana oculta. Para ello simplemente redireccionamos al método*/
	protected void cmdPreUpdateForm() throws Exception{
		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION) != null?
			conectorParametro(VAR_LAST_QUERY_TO_SESSION): "");

		//Redirigimos al update form
		conectorAction("CarAsignCodigConfiLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
	}
	
	/**Prepara el formualrio para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "carAsignCodigConfiFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		asignarAtributo("COMBO", "zorgOidRegi", "req", "S");
		asignarAtributo("COMBO", "zzonOidZona", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRiesInici", "req", "S");
		asignarAtributo("COMBO", "pacaOidParaCart", "req", "S");
		asignarAtributo("TEXT", "valLineCredInic", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valLineCredInic", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CarAsignCodigConfi");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CarAsignCodigConfiData carAsignCodigConfiQuery= new CarAsignCodigConfiData();
		carAsignCodigConfiQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		CarAsignCodigConfiData  datosResult = (CarAsignCodigConfiData)getSingleObject(BUSINESSID_QUERY, carAsignCodigConfiQuery, 
			carAsignCodigConfiQuery.clone(), "carAsignCodigConfi");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CarAsignCodigConfiData carAsignCodigConfi = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.ZonSubGerenVentaData zsgvOidSubgVent = carAsignCodigConfi.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
	
		es.indra.belcorp.mso.ZonRegioData zorgOidRegi = carAsignCodigConfi.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
	
		es.indra.belcorp.mso.ZonZonaData zzonOidZona = carAsignCodigConfi.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
	
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoli = carAsignCodigConfi.getGrsoOidGrupSoli();
		if(grsoOidGrupSoli != null && grsoOidGrupSoli.getId() != null) checkCombo("grsoOidGrupSoli" , grsoOidGrupSoli.getId().toString());
	
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRies = carAsignCodigConfi.getNiriOidNiveRies();
		if(niriOidNiveRies != null && niriOidNiveRies.getId() != null) checkCombo("niriOidNiveRies" , niriOidNiveRies.getId().toString());
	
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesInici = carAsignCodigConfi.getNiriOidNiveRiesInici();
		if(niriOidNiveRiesInici != null && niriOidNiveRiesInici.getId() != null) checkCombo("niriOidNiveRiesInici" , niriOidNiveRiesInici.getId().toString());
	
		es.indra.belcorp.mso.CarParamCarteData pacaOidParaCart = carAsignCodigConfi.getPacaOidParaCart();
		if(pacaOidParaCart != null && pacaOidParaCart.getId() != null) checkCombo("pacaOidParaCart" , pacaOidParaCart.getId().toString());
	
		asignar("TEXT", "valLineCredInic", FormatUtils.formatObject(carAsignCodigConfi.getValLineCredInic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(carAsignCodigConfi.jdoGetTimeStamp()));
		
		//Ponemos la pagina en modo view: Eliminamos el botón de buscar
		//Borramos tambien las celdas con los botones
		//borramos tambien todos los elementos de from y to dejando sólo el campo simple
		//Borramos los elementos correspondientes a la internacionalización
		removeLovElements();
		removeQueryElements();
		removeNonModifyFields();
	}
	
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
		
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","carAsignCodigConfiTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","carAsignCodigConfiTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonViewElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		borrarCampo("id");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		
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
		asignarAtributo("CAPA","carAsignCodigConfiFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","carAsignCodigConfiPreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","carAsignCodigConfiListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","carAsignCodigConfiListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_ZSGVOIDSUBGVENT_QUERY,ZSGVOIDSUBGVENT_COMBO_CONNECTOR, new ZonSubGerenVentaData(), new ZonSubGerenVentaData(), "zonSubGerenVenta", "zsgvOidSubgVent", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZORGOIDREGI_QUERY,ZORGOIDREGI_COMBO_CONNECTOR, new ZonRegioData(), new ZonRegioData(), "zonRegio", "zorgOidRegi", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ZZONOIDZONA_QUERY,ZZONOIDZONA_COMBO_CONNECTOR, new ZonZonaData(), new ZonZonaData(), "zonZona", "zzonOidZona", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_GRSOOIDGRUPSOLI_QUERY,GRSOOIDGRUPSOLI_COMBO_CONNECTOR, new CarGrupoSolicData(), new CarGrupoSolicData(), "carGrupoSolic", "grsoOidGrupSoli", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_NIRIOIDNIVERIES_QUERY,NIRIOIDNIVERIES_COMBO_CONNECTOR, new CarNivelRiesgData(), new CarNivelRiesgData(), "carNivelRiesg", "niriOidNiveRies", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_NIRIOIDNIVERIESINICI_QUERY,NIRIOIDNIVERIESINICI_COMBO_CONNECTOR, new CarNivelRiesgData(), new CarNivelRiesgData(), "carNivelRiesg", "niriOidNiveRiesInici", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PACAOIDPARACART_QUERY,PACAOIDPARACART_COMBO_CONNECTOR, new CarParamCarteData(), new CarParamCarteData(), "carParamCarte", "pacaOidParaCart", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String zorgOidRegi = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonRegio");
		if(zorgOidRegi != null && !zorgOidRegi.trim().equals("")) checkCombo("zorgOidRegi", zorgOidRegi);
		String zzonOidZona = MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonZona");
		if(zzonOidZona != null && !zzonOidZona.trim().equals("")) checkCombo("zzonOidZona", zzonOidZona);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param carAsignCodigConfi La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CarAsignCodigConfiData carAsignCodigConfi) 
		throws Exception{
		if(carAsignCodigConfi.getZsgvOidSubgVent() != null){
			checkCombo("zsgvOidSubgVent" , carAsignCodigConfi.getZsgvOidSubgVent().getId().toString());
			}
		if(carAsignCodigConfi.getZorgOidRegi() != null){
			checkCombo("zorgOidRegi" , carAsignCodigConfi.getZorgOidRegi().getId().toString());
			}
		if(carAsignCodigConfi.getZzonOidZona() != null){
			checkCombo("zzonOidZona" , carAsignCodigConfi.getZzonOidZona().getId().toString());
			}
		if(carAsignCodigConfi.getGrsoOidGrupSoli() != null){
			checkCombo("grsoOidGrupSoli" , carAsignCodigConfi.getGrsoOidGrupSoli().getId().toString());
			}
		if(carAsignCodigConfi.getNiriOidNiveRies() != null){
			checkCombo("niriOidNiveRies" , carAsignCodigConfi.getNiriOidNiveRies().getId().toString());
			}
		if(carAsignCodigConfi.getNiriOidNiveRiesInici() != null){
			checkCombo("niriOidNiveRiesInici" , carAsignCodigConfi.getNiriOidNiveRiesInici().getId().toString());
			}
		if(carAsignCodigConfi.getPacaOidParaCart() != null){
			checkCombo("pacaOidParaCart" , carAsignCodigConfi.getPacaOidParaCart().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(CarAsignCodigConfiData carAsignCodigConfi) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewZsgvOidSubgVent", "valor",FormatUtils.formatObject(carAsignCodigConfi.getZsgvOidSubgVent()));
		asignarAtributo("LABELC", "lblViewZorgOidRegi", "valor",FormatUtils.formatObject(carAsignCodigConfi.getZorgOidRegi()));
		asignarAtributo("LABELC", "lblViewZzonOidZona", "valor",FormatUtils.formatObject(carAsignCodigConfi.getZzonOidZona()));
		asignarAtributo("LABELC", "lblViewGrsoOidGrupSoli", "valor",FormatUtils.formatObject(carAsignCodigConfi.getGrsoOidGrupSoli()));
		asignarAtributo("LABELC", "lblViewNiriOidNiveRies", "valor",FormatUtils.formatObject(carAsignCodigConfi.getNiriOidNiveRies()));
		asignarAtributo("LABELC", "lblViewNiriOidNiveRiesInici", "valor",FormatUtils.formatObject(carAsignCodigConfi.getNiriOidNiveRiesInici()));
		asignarAtributo("LABELC", "lblViewPacaOidParaCart", "valor",FormatUtils.formatObject(carAsignCodigConfi.getPacaOidParaCart()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CarAsignCodigConfiData carAsignCodigConfi = 
			(CarAsignCodigConfiData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(carAsignCodigConfi.getZsgvOidSubgVent() != null){
			carAsignCodigConfi.setZsgvOidSubgVent((es.indra.belcorp.mso.ZonSubGerenVentaData)
			getSingleObject(BUSINESSID_ZSGVOIDSUBGVENT_QUERY, 
			carAsignCodigConfi.getZsgvOidSubgVent(),
			carAsignCodigConfi.getZsgvOidSubgVent().clone(),
			"zonSubGerenVenta"));
		}
		if(carAsignCodigConfi.getZorgOidRegi() != null){
			carAsignCodigConfi.setZorgOidRegi((es.indra.belcorp.mso.ZonRegioData)
			getSingleObject(BUSINESSID_ZORGOIDREGI_QUERY, 
			carAsignCodigConfi.getZorgOidRegi(),
			carAsignCodigConfi.getZorgOidRegi().clone(),
			"zonRegio"));
		}
		if(carAsignCodigConfi.getZzonOidZona() != null){
			carAsignCodigConfi.setZzonOidZona((es.indra.belcorp.mso.ZonZonaData)
			getSingleObject(BUSINESSID_ZZONOIDZONA_QUERY, 
			carAsignCodigConfi.getZzonOidZona(),
			carAsignCodigConfi.getZzonOidZona().clone(),
			"zonZona"));
		}
		if(carAsignCodigConfi.getGrsoOidGrupSoli() != null){
			carAsignCodigConfi.setGrsoOidGrupSoli((es.indra.belcorp.mso.CarGrupoSolicData)
			getSingleObject(BUSINESSID_GRSOOIDGRUPSOLI_QUERY, 
			carAsignCodigConfi.getGrsoOidGrupSoli(),
			carAsignCodigConfi.getGrsoOidGrupSoli().clone(),
			"carGrupoSolic"));
		}
		if(carAsignCodigConfi.getNiriOidNiveRies() != null){
			carAsignCodigConfi.setNiriOidNiveRies((es.indra.belcorp.mso.CarNivelRiesgData)
			getSingleObject(BUSINESSID_NIRIOIDNIVERIES_QUERY, 
			carAsignCodigConfi.getNiriOidNiveRies(),
			carAsignCodigConfi.getNiriOidNiveRies().clone(),
			"carNivelRiesg"));
		}
		if(carAsignCodigConfi.getNiriOidNiveRiesInici() != null){
			carAsignCodigConfi.setNiriOidNiveRiesInici((es.indra.belcorp.mso.CarNivelRiesgData)
			getSingleObject(BUSINESSID_NIRIOIDNIVERIESINICI_QUERY, 
			carAsignCodigConfi.getNiriOidNiveRiesInici(),
			carAsignCodigConfi.getNiriOidNiveRiesInici().clone(),
			"carNivelRiesg"));
		}
		if(carAsignCodigConfi.getPacaOidParaCart() != null){
			carAsignCodigConfi.setPacaOidParaCart((es.indra.belcorp.mso.CarParamCarteData)
			getSingleObject(BUSINESSID_PACAOIDPARACART_QUERY, 
			carAsignCodigConfi.getPacaOidParaCart(),
			carAsignCodigConfi.getPacaOidParaCart().clone(),
			"carParamCarte"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(carAsignCodigConfi);
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
	
	/**
	*	Este método nos permite eliminar los labels del modo view de la pantalla
	*/
	protected void removeViewLabels() throws Exception{
		borrarNodo("TR", "nombre", "idViewLabelTrId");
		borrarNodo("TR", "nombre", "zsgvOidSubgVentViewLabelTrId");
		borrarNodo("TR", "nombre", "zorgOidRegiViewLabelTrId");
		borrarNodo("TR", "nombre", "zzonOidZonaViewLabelTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliViewLabelTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesViewLabelTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesIniciViewLabelTrId");
		borrarNodo("TR", "nombre", "pacaOidParaCartViewLabelTrId");
		borrarNodo("TR", "nombre", "valLineCredInicViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "zsgvOidSubgVentWidgetTrId");
		borrarNodo("TR", "nombre", "zorgOidRegiWidgetTrId");
		borrarNodo("TR", "nombre", "zzonOidZonaWidgetTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliWidgetTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesWidgetTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesIniciWidgetTrId");
		borrarNodo("TR", "nombre", "pacaOidParaCartWidgetTrId");
		borrarNodo("TR", "nombre", "valLineCredInicWidgetTrId");
		
	}
}







