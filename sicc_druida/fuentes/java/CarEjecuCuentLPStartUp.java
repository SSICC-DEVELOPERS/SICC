/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentLPStartUp.java,v 1.1 2009/12/03 18:35:03 pecbazalar Exp $
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
public class CarEjecuCuentLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 188;
	public static final short CREATEFORM_SIZE = 188;
	public static final short UPDATEFORM_SIZE = 188;
	public static final short VIEWFORM_SIZE = 188;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCarEjecuCuentQueryFromToUserPage";
	public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	public static final String BUSINESSID_JERAOIDJERA_QUERY ="MMGCarJerarQueryFromToUser";public static final String JERAOIDJERA_COMBO_CONNECTOR = "CarJerarConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CarEjecuCuentLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CarEjecuCuentPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("CarEjecuCuent");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CarEjecuCuentPage", "cod", "CarEjecuCuent." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("carEjecuCuent", accion);
			
			
			
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
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "carEjecuCuentLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CarEjecuCuentPage", "onblur", "window.focus();");
		
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
		conectorAction("CarEjecuCuentLPStartUp");
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
		CarEjecuCuentData carEjecuCuentQuery= new CarEjecuCuentData();
		carEjecuCuentQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CarEjecuCuentData datosResult = (CarEjecuCuentData)getSingleObject(BUSINESSID_QUERY, carEjecuCuentQuery, 
			carEjecuCuentQuery.clone(), "carEjecuCuent");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		CarEjecuCuentData carEjecuCuent = datosResult;
	
		asignarAtributo("LABELC", "lblViewCodEjecCuen", "valor", 
				FormatUtils.formatObject(carEjecuCuent.getCodEjecCuen(), 
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
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("TEXT", "codEjecCuen", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		
		
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
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		
		
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
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		
		
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
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		
		
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
		conectorAction("CarEjecuCuentLPStartUp");
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
		//asignarAtributo("FORMULARIO", "carEjecuCuentFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("TEXT", "codEjecCuen", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		asignarAtributo("TEXT", "codEjecCuen", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 20)");
		
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CarEjecuCuent");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CarEjecuCuentData carEjecuCuentQuery= new CarEjecuCuentData();
		carEjecuCuentQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		CarEjecuCuentData  datosResult = (CarEjecuCuentData)getSingleObject(BUSINESSID_QUERY, carEjecuCuentQuery, 
			carEjecuCuentQuery.clone(), "carEjecuCuent");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CarEjecuCuentData carEjecuCuent = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegPaisData paisOidPais = carEjecuCuent.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
	
		asignar("TEXT", "codEjecCuen", FormatUtils.formatObject(carEjecuCuent.getCodEjecCuen(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		es.indra.belcorp.mso.CarJerarData jeraOidJera = carEjecuCuent.getJeraOidJera();
		if(jeraOidJera != null && jeraOidJera.getId() != null) checkCombo("jeraOidJera" , jeraOidJera.getId().toString());
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(carEjecuCuent.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","carEjecuCuentTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","carEjecuCuentTrButtons");

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
		asignarAtributo("CAPA","carEjecuCuentFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","carEjecuCuentPreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","carEjecuCuentListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","carEjecuCuentListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, new BelFormaPagoTaponData(), new BelFormaPagoTaponData(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_JERAOIDJERA_QUERY,JERAOIDJERA_COMBO_CONNECTOR, new CarJerarData(), new CarJerarData(), "carJerar", "jeraOidJera", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String paisOidPais = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais");
		if(paisOidPais != null && !paisOidPais.trim().equals("")) checkCombo("paisOidPais", paisOidPais);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param carEjecuCuent La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CarEjecuCuentData carEjecuCuent) 
		throws Exception{
		if(carEjecuCuent.getPaisOidPais() != null){
			SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMone(carEjecuCuent.getPaisOidPais().getMoneOidMone());
			paisOidPais.setMoneOidMoneAlt(carEjecuCuent.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setFopaOidFormPago(carEjecuCuent.getPaisOidPais().getFopaOidFormPago());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , carEjecuCuent.getPaisOidPais().getId().toString());
			checkCombo("paisOidPais_moneOidMone" , carEjecuCuent.getPaisOidPais().getMoneOidMone().getId().toString());
			checkCombo("paisOidPais_moneOidMoneAlt" , carEjecuCuent.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			checkCombo("paisOidPais_fopaOidFormPago" , carEjecuCuent.getPaisOidPais().getFopaOidFormPago().getId().toString());
			}
		if(carEjecuCuent.getJeraOidJera() != null){
			checkCombo("jeraOidJera" , carEjecuCuent.getJeraOidJera().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(CarEjecuCuentData carEjecuCuent) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMone", "valor",FormatUtils.formatObject(carEjecuCuent.getPaisOidPais().getMoneOidMone()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMoneAlt", "valor",FormatUtils.formatObject(carEjecuCuent.getPaisOidPais().getMoneOidMoneAlt()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_fopaOidFormPago", "valor",FormatUtils.formatObject(carEjecuCuent.getPaisOidPais().getFopaOidFormPago()));
		asignarAtributo("LABELC", "lblViewPaisOidPais", "valor",FormatUtils.formatObject(carEjecuCuent.getPaisOidPais()));
		asignarAtributo("LABELC", "lblViewJeraOidJera", "valor",FormatUtils.formatObject(carEjecuCuent.getJeraOidJera()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CarEjecuCuentData carEjecuCuent = 
			(CarEjecuCuentData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(carEjecuCuent.getPaisOidPais() != null){
			carEjecuCuent.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			carEjecuCuent.getPaisOidPais(),
			carEjecuCuent.getPaisOidPais().clone(),
			"segPais"));
		}
		if(carEjecuCuent.getJeraOidJera() != null){
			carEjecuCuent.setJeraOidJera((es.indra.belcorp.mso.CarJerarData)
			getSingleObject(BUSINESSID_JERAOIDJERA_QUERY, 
			carEjecuCuent.getJeraOidJera(),
			carEjecuCuent.getJeraOidJera().clone(),
			"carJerar"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(carEjecuCuent);
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
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPaisViewLabelTrId");
		borrarNodo("TR", "nombre", "codEjecCuenViewLabelTrId");
		borrarNodo("TR", "nombre", "jeraOidJeraViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPaisWidgetTrId");
		borrarNodo("TR", "nombre", "codEjecCuenWidgetTrId");
		borrarNodo("TR", "nombre", "jeraOidJeraWidgetTrId");
		
	}
}







