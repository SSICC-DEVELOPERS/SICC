/*
    INDRA/CAR/mmg
    $Id: PreEstraLPStartUp.java,v 1.1 2009/12/03 18:38:25 pecbazalar Exp $
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
public class PreEstraLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 105;
	public static final short CREATEFORM_SIZE = 255;
	public static final short UPDATEFORM_SIZE = 255;
	public static final short VIEWFORM_SIZE = 255;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGPreEstraQueryFromToUserPage";
	
	public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	public static final String BUSINESSID_TIESOIDTIPOESTR_QUERY ="MMGPreTipoEstraQueryFromToUser";
	public static final String TIESOIDTIPOESTR_COMBO_CONNECTOR = "PreTipoEstraConectorCombo";
	public static final String BUSINESSID_TIPROIDTIPOPROD_QUERY ="MMGPreTipoProduQueryFromToUser";
	public static final String TIPROIDTIPOPROD_COMBO_CONNECTOR = "PreTipoProduConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public PreEstraLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("PreEstraPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("PreEstra");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "PreEstraPage", "cod", "PreEstra." + accion + ".label");
			
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
			limpiarBotoneraLista("preEstra", accion);
			
			
			
			
			
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codEstr", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "preEstraLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "PreEstraPage", "onblur", "window.focus();");
		
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
		conectorAction("PreEstraLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro(PARAMETRO_GENERICO_ACCION)!= null?  
			conectorParametro(PARAMETRO_GENERICO_ACCION): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Acciones que se realizan cunado la pantalla se arranca en modo view*/
	protected void cmdView() throws Exception{
		//Construimos el mso con los elementos de la búsqueda a partir del id que
		//lo sacamos de la request
		PreEstraData preEstraQuery= new PreEstraData();
		preEstraQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		PreEstraData datosResult = (PreEstraData)getSingleObject(BUSINESSID_QUERY, preEstraQuery, 
			preEstraQuery.clone(), "preEstra");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalización
		preservaHiddensI18n(new Integer(1), "PRE_ESTRA", "preEstraFrm", "Descripcion", true);
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		PreEstraData preEstra = datosResult;
		asignar("TEXT", "codEstr", FormatUtils.formatObject(preEstra.getCodEstr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "Descripcion", FormatUtils.formatObject(preEstra.getDescripcion(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.PreTipoEstraData tiesOidTipoEstr = preEstra.getTiesOidTipoEstr();
		if(tiesOidTipoEstr != null && tiesOidTipoEstr.getId() != null) checkCombo("tiesOidTipoEstr" , tiesOidTipoEstr.getId().toString());
		asignar("TEXT", "numMaxiGrup", FormatUtils.formatObject(preEstra.getNumMaxiGrup(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "numMaxiGrupCndt", FormatUtils.formatObject(preEstra.getNumMaxiGrupCndt(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "numMaxiGrupCndo", FormatUtils.formatObject(preEstra.getNumMaxiGrupCndo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignarAtributo("CHECKBOX", "indListRank" , "check", FormatUtils.formatObject(
			preEstra.getIndListRank(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCuadGrup" , "check", FormatUtils.formatObject(
			preEstra.getIndCuadGrup(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		es.indra.belcorp.mso.PreTipoProduData tiprOidTipoProd = preEstra.getTiprOidTipoProd();
		if(tiprOidTipoProd != null && tiprOidTipoProd.getId() != null) checkCombo("tiprOidTipoProd" , tiprOidTipoProd.getId().toString());
		asignarAtributo("CHECKBOX", "indCvImpr" , "check", FormatUtils.formatObject(
			preEstra.getIndCvImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiImpr" , "check", FormatUtils.formatObject(
			preEstra.getIndModiImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCvDespAuto" , "check", FormatUtils.formatObject(
			preEstra.getIndCvDespAuto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiDesp" , "check", FormatUtils.formatObject(
			preEstra.getIndModiDesp(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCvDigi" , "check", FormatUtils.formatObject(
			preEstra.getIndCvDigi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiDigi" , "check", FormatUtils.formatObject(
			preEstra.getIndModiDigi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		loadLocalizationVars(preEstra);
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codEstr", "disabled", "S");
		asignarAtributo("TEXT", "Descripcion", "disabled", "S");
		asignarAtributo("COMBO", "tiesOidTipoEstr", "disabled", "S");
		asignarAtributo("TEXT", "numMaxiGrup", "disabled", "S");
		asignarAtributo("TEXT", "numMaxiGrupCndt", "disabled", "S");
		asignarAtributo("TEXT", "numMaxiGrupCndo", "disabled", "S");
		asignarAtributo("CHECKBOX", "indListRank", "disabled", "S");
		asignarAtributo("CHECKBOX", "indCuadGrup", "disabled", "S");
		asignarAtributo("COMBO", "tiprOidTipoProd", "disabled", "S");
		asignarAtributo("CHECKBOX", "indCvImpr", "disabled", "S");
		asignarAtributo("CHECKBOX", "indModiImpr", "disabled", "S");
		asignarAtributo("CHECKBOX", "indCvDespAuto", "disabled", "S");
		asignarAtributo("CHECKBOX", "indModiDesp", "disabled", "S");
		asignarAtributo("CHECKBOX", "indCvDigi", "disabled", "S");
		asignarAtributo("CHECKBOX", "indModiDigi", "disabled", "S");
		
		
	
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
		//Creamos los campos ocultos para la internacionalización
		preservaHiddensI18n(new Integer(1), "PRE_ESTRA", "preEstraFrm", "Descripcion", false);
		

		//Cargamos las combos finales de las jerarquías de herencia
		loadLeafDependenceCombos(null);
	
		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "codEstr", "req", "S");
		asignarAtributo("TEXT", "Descripcion", "req", "S");
		asignarAtributo("COMBO", "tiesOidTipoEstr", "req", "S");
		asignarAtributo("COMBO", "tiprOidTipoProd", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('preEstraFrm.Descripcion'))");
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codEstr", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		
		asignarAtributo("TEXT", "numMaxiGrup", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numMaxiGrupCndt", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numMaxiGrupCndo", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		
		
		
		
		
		
		
		
		
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codEstr", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codEstr", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		
		
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
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		asignarAtributo("TEXT", "codEstr", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 3)");
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		
		
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
		conectorAction("PreEstraLPStartUp");
		conectorActionParametro("idSelection", conectorParametro("idSelection"));
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, conectorParametro("accion") != null?
			conectorParametro("accion"): "");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
		conectorActionParametro(VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR) != null?
			conectorParametro(VAR_ACCION_ANTERIOR): "");
		conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY));
			
	}
	
	/**Prepara el formualrio para mostrar los datos de un elemento de la entidad
	y estos puedan ser modificados*/  
	protected void cmdUpdateForm() throws Exception{
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));

		//Actualizamos el valor de enviar de forma oculta el formulario. 
		//asignarAtributo("FORMULARIO", "preEstraFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("TEXT", "Descripcion", "req", "S");
		asignarAtributo("COMBO", "tiprOidTipoProd", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		asignarAtributo("TEXT", "Descripcion", "onblur", "setDefaultLanguageValue('Descripcion', get('preEstraFrm.Descripcion'))");
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		asignarAtributo("TEXT", "Descripcion", "validacion", "ValidaLongitud(cdos_trim(valor), 1, 30)");
		asignarAtributo("TEXT", "numMaxiGrup", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numMaxiGrupCndt", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		asignarAtributo("TEXT", "numMaxiGrupCndo", "validacion", "ValidaInt(cdos_trim(valor), 2, 0, 99)");
		
		
		
		
		
		
		
		
		
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando PreEstra");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		PreEstraData preEstraQuery= new PreEstraData();
		preEstraQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		PreEstraData  datosResult = (PreEstraData)getSingleObject(BUSINESSID_QUERY, preEstraQuery, 
			preEstraQuery.clone(), "preEstra");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Creamos los campos ocultos para la internacionalización
		preservaHiddensI18n(new Integer(1), "PRE_ESTRA", "preEstraFrm", "Descripcion", false);
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		PreEstraData preEstra = datosResult;
		asignar("VAR", "idSelection", id);
		asignar("TEXT", "Descripcion", FormatUtils.formatObject(preEstra.getDescripcion(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "numMaxiGrup", FormatUtils.formatObject(preEstra.getNumMaxiGrup(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "numMaxiGrupCndt", FormatUtils.formatObject(preEstra.getNumMaxiGrupCndt(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "numMaxiGrupCndo", FormatUtils.formatObject(preEstra.getNumMaxiGrupCndo(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignarAtributo("CHECKBOX", "indListRank" , "check", FormatUtils.formatObject(
			preEstra.getIndListRank(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCuadGrup" , "check", FormatUtils.formatObject(
			preEstra.getIndCuadGrup(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		es.indra.belcorp.mso.PreTipoProduData tiprOidTipoProd = preEstra.getTiprOidTipoProd();
		if(tiprOidTipoProd != null && tiprOidTipoProd.getId() != null) checkCombo("tiprOidTipoProd" , tiprOidTipoProd.getId().toString());
		asignarAtributo("CHECKBOX", "indCvImpr" , "check", FormatUtils.formatObject(
			preEstra.getIndCvImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiImpr" , "check", FormatUtils.formatObject(
			preEstra.getIndModiImpr(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCvDespAuto" , "check", FormatUtils.formatObject(
			preEstra.getIndCvDespAuto(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiDesp" , "check", FormatUtils.formatObject(
			preEstra.getIndModiDesp(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indCvDigi" , "check", FormatUtils.formatObject(
			preEstra.getIndCvDigi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		asignarAtributo("CHECKBOX", "indModiDigi" , "check", FormatUtils.formatObject(
			preEstra.getIndModiDigi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)).equals("true")? "S": "N");
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		loadLocalizationVars(preEstra);
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(preEstra.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGap");
		borrarNodo("TD","nombre","DescripcionTdLocalizationButtonGapHeader");
		borrarNodo("TD","nombre","DescripcionTdLocalizationButton");			
		
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","preEstraTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","preEstraTrButtons");

		//Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
		//por intervalo
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de view
	*/
	protected void removeNonViewElements() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}

	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		borrarCampo("tiesOidTipoEstr");
		borrarCampo("numMaxiGrup");
		borrarCampo("numMaxiGrupCndt");
		borrarCampo("numMaxiGrupCndo");
		borrarCampo("indListRank");
		borrarCampo("indCuadGrup");
		borrarCampo("tiprOidTipoProd");
		borrarCampo("indCvImpr");
		borrarCampo("indModiImpr");
		borrarCampo("indCvDespAuto");
		borrarCampo("indModiDesp");
		borrarCampo("indCvDigi");
		borrarCampo("indModiDigi");
		
	}
	
	/**
	* Nos permite elimnar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		borrarCampo("codEstr");
		borrarCampo("tiesOidTipoEstr");
		
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
		asignarAtributo("CAPA","preEstraFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","preEstraListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","preEstraListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(PreEstraData preEstra) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegPaisViewData paisOidPais = new SegPaisViewData();
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(preEstra != null && preEstra.getPaisOidPais() != null){
				checkCombo("paisOidPais" , preEstra.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		PreTipoEstraData tiesOidTipoEstr = new PreTipoEstraData();
		asignarComboResultados(BUSINESSID_TIESOIDTIPOESTR_QUERY,TIESOIDTIPOESTR_COMBO_CONNECTOR, 
			tiesOidTipoEstr, tiesOidTipoEstr.clone(), "preTipoEstra", "tiesOidTipoEstr", "result_ROWSET" );
		if(preEstra != null && preEstra.getTiesOidTipoEstr() != null){
				checkCombo("tiesOidTipoEstr" , preEstra.getTiesOidTipoEstr().getId().toString());
			}
		PreTipoProduData tiprOidTipoProd = new PreTipoProduData();
		asignarComboResultados(BUSINESSID_TIPROIDTIPOPROD_QUERY,TIPROIDTIPOPROD_COMBO_CONNECTOR, 
			tiprOidTipoProd, tiprOidTipoProd.clone(), "preTipoProdu", "tiprOidTipoProd", "result_ROWSET" );
		if(preEstra != null && preEstra.getTiprOidTipoProd() != null){
				checkCombo("tiprOidTipoProd" , preEstra.getTiprOidTipoProd().getId().toString());
			}
		
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param preEstra La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(PreEstraData preEstra) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		PreEstraData preEstra = 
			(PreEstraData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(preEstra.getPaisOidPais() != null){
			preEstra.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			preEstra.getPaisOidPais(),
			preEstra.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(preEstra.getTiesOidTipoEstr() != null){
			preEstra.setTiesOidTipoEstr((es.indra.belcorp.mso.PreTipoEstraData)
			getSingleObject(BUSINESSID_TIESOIDTIPOESTR_QUERY, 
			preEstra.getTiesOidTipoEstr(),
			preEstra.getTiesOidTipoEstr().clone(),
			"preTipoEstra"));
		}
		if(preEstra.getTiprOidTipoProd() != null){
			preEstra.setTiprOidTipoProd((es.indra.belcorp.mso.PreTipoProduData)
			getSingleObject(BUSINESSID_TIPROIDTIPOPROD_QUERY, 
			preEstra.getTiprOidTipoProd(),
			preEstra.getTiprOidTipoProd().clone(),
			"preTipoProdu"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(preEstra);
		loadLeafDependenceCombos(preEstra);
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
			borrarNodo("TR","nombre","formTr2");
			borrarNodo("TR","nombre","formGapTr2");
			borrarNodo("TR","nombre","formTr3");
			borrarNodo("TR","nombre","formGapTr3");
			borrarNodo("TR","nombre","formTr4");
			borrarNodo("TR","nombre","formGapTr4");
			borrarNodo("TR","nombre","formTr5");
			borrarNodo("TR","nombre","formGapTr5");
			
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
	
	
	protected void loadLocalizationVars(PreEstraData preEstra) throws Exception{
		GenDetaSiccData mmgLocalizationQuery = null;
		Vector mmgLocalizationDatosResult = null;
		mmgLocalizationQuery = new GenDetaSiccData();
		mmgLocalizationQuery.setEnti("PRE_ESTRA");
		mmgLocalizationQuery.setEntiPk(preEstra.getId());
		mmgLocalizationQuery.setAtri(new Integer(1));
		mmgLocalizationDatosResult = getCollectionObjects(BUSINESID_GENDETASICC, mmgLocalizationQuery, 
			mmgLocalizationQuery.clone(), "genDetaSicc");		
		for(Iterator it = mmgLocalizationDatosResult.iterator(); it.hasNext();){
			GenDetaSiccData description = (GenDetaSiccData)it.next();
			if(description.getDeta() != null && !description.getDeta().trim().equals("")){
				asignar("VAR", "hi18NTraduccion_1_" + 
					description.getIdioOidIdio().getId().toString() , description.getDeta());
			}
		}
		
	}
	
	
	
	
		
}







