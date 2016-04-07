/*
    INDRA/CAR/mmg
    $Id: MaeConfiCampoLPStartUp.java,v 1.1 2009/12/03 18:35:46 pecbazalar Exp $
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
public class MaeConfiCampoLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 315;
	public static final short CREATEFORM_SIZE = 305;
	public static final short UPDATEFORM_SIZE = 305;
	public static final short VIEWFORM_SIZE = 305;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGMaeConfiCampoQueryFromToUserPage";
	
	public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";
	public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";
	public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";
	public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";
	public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	public static final String BUSINESSID_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY ="MMGMaeTipoClienViewQueryFromToUser";
	public static final String BUSINESSID_SBTIOIDSUBTCLIE_QUERY ="MMGMaeSubtiClienQueryFromToUser";
	public static final String SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR = "MaeTipoClienViewConectorCombo";
	public static final String SBTIOIDSUBTCLIE_COMBO_CONNECTOR = "MaeSubtiClienConectorCombo";
	public static final String BUSINESSID_ATREOIDATRIESPE_MODUOIDMODU_QUERY ="MMGSegModulQueryFromToUser";
	public static final String BUSINESSID_ATREOIDATRIESPE_QUERY ="MMGPedAtribEspecQueryFromToUser";
	public static final String ATREOIDATRIESPE_MODUOIDMODU_COMBO_CONNECTOR = "SegModulConectorCombo";
	public static final String ATREOIDATRIESPE_COMBO_CONNECTOR = "PedAtribEspecConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public MaeConfiCampoLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("MaeConfiCampoPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("MaeConfiCampo");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "MaeConfiCampoPage", "cod", "MaeConfiCampo." + accion + ".label");
			
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
			limpiarBotoneraLista("maeConfiCampo", accion);
			
			
			
			
			
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
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "maeConfiCampoLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "MaeConfiCampoPage", "onblur", "window.focus();");
		
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
		conectorAction("MaeConfiCampoLPStartUp");
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
		MaeConfiCampoData maeConfiCampoQuery= new MaeConfiCampoData();
		maeConfiCampoQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		MaeConfiCampoData datosResult = (MaeConfiCampoData)getSingleObject(BUSINESSID_QUERY, maeConfiCampoQuery, 
			maeConfiCampoQuery.clone(), "maeConfiCampo");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		MaeConfiCampoData maeConfiCampo = datosResult;
		es.indra.belcorp.mso.SegPaisData paisOidPais = maeConfiCampo.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClie = maeConfiCampo.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEspe = maeConfiCampo.getAtreOidAtriEspe();
		if(atreOidAtriEspe != null && atreOidAtriEspe.getId() != null) checkCombo("atreOidAtriEspe" , atreOidAtriEspe.getId().toString());
		asignar("TEXT", "valDefe", FormatUtils.formatObject(maeConfiCampo.getValDefe(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indObli", FormatUtils.formatObject(maeConfiCampo.getIndObli(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indModi", FormatUtils.formatObject(maeConfiCampo.getIndModi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
				asignarAtributo("COMBO", "paisOidPais_moneOidMoneAlt", "disabled", "S");

				asignarAtributo("COMBO", "paisOidPais_moneOidMone", "disabled", "S");

				asignarAtributo("COMBO", "paisOidPais_fopaOidFormPago", "disabled", "S");

		asignarAtributo("COMBO", "paisOidPais", "disabled", "S");
				asignarAtributo("COMBO", "sbtiOidSubtClie_ticlOidTipoClie", "disabled", "S");

		asignarAtributo("COMBO", "sbtiOidSubtClie", "disabled", "S");
				asignarAtributo("COMBO", "atreOidAtriEspe_moduOidModu", "disabled", "S");

		asignarAtributo("COMBO", "atreOidAtriEspe", "disabled", "S");
		asignarAtributo("TEXT", "valDefe", "disabled", "S");
		asignarAtributo("TEXT", "indObli", "disabled", "S");
		asignarAtributo("TEXT", "indModi", "disabled", "S");
		
		
	
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
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "atreOidAtriEspe", "req", "S");
		asignarAtributo("TEXT", "indObli", "req", "S");
		asignarAtributo("TEXT", "indModi", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
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
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
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
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
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
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		
		
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
		conectorAction("MaeConfiCampoLPStartUp");
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
		//asignarAtributo("FORMULARIO", "maeConfiCampoFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "atreOidAtriEspe", "req", "S");
		asignarAtributo("TEXT", "indObli", "req", "S");
		asignarAtributo("TEXT", "indModi", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		
		asignarAtributo("TEXT", "valDefe", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 40)");
		asignarAtributo("TEXT", "indObli", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indModi", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando MaeConfiCampo");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		MaeConfiCampoData maeConfiCampoQuery= new MaeConfiCampoData();
		maeConfiCampoQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		MaeConfiCampoData  datosResult = (MaeConfiCampoData)getSingleObject(BUSINESSID_QUERY, maeConfiCampoQuery, 
			maeConfiCampoQuery.clone(), "maeConfiCampo");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		MaeConfiCampoData maeConfiCampo = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegPaisData paisOidPais = maeConfiCampo.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		es.indra.belcorp.mso.MaeSubtiClienData sbtiOidSubtClie = maeConfiCampo.getSbtiOidSubtClie();
		if(sbtiOidSubtClie != null && sbtiOidSubtClie.getId() != null) checkCombo("sbtiOidSubtClie" , sbtiOidSubtClie.getId().toString());
		es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEspe = maeConfiCampo.getAtreOidAtriEspe();
		if(atreOidAtriEspe != null && atreOidAtriEspe.getId() != null) checkCombo("atreOidAtriEspe" , atreOidAtriEspe.getId().toString());
		asignar("TEXT", "valDefe", FormatUtils.formatObject(maeConfiCampo.getValDefe(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indObli", FormatUtils.formatObject(maeConfiCampo.getIndObli(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		asignar("TEXT", "indModi", FormatUtils.formatObject(maeConfiCampo.getIndModi(), 
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
		//asignar("VAR","timestamp",Long.toString(maeConfiCampo.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","maeConfiCampoTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","maeConfiCampoTrButtons");

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
		asignarAtributo("CAPA","maeConfiCampoFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","maeConfiCampoListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","maeConfiCampoListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(MaeConfiCampoData maeConfiCampo) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMonedData paisOidPais_moneOidMoneAlt = new SegMonedData();
		SegMonedData paisOidPais_moneOidMone = new SegMonedData();
		BelFormaPagoTaponData paisOidPais_fopaOidFormPago = new BelFormaPagoTaponData();
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, 
			paisOidPais_moneOidMoneAlt, paisOidPais_moneOidMoneAlt.clone(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		if(maeConfiCampo != null && maeConfiCampo.getPaisOidPais().getMoneOidMoneAlt() != null){
				checkCombo("paisOidPais_moneOidMoneAlt" , maeConfiCampo.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			}
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, 
			paisOidPais_moneOidMone, paisOidPais_moneOidMone.clone(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		if(maeConfiCampo != null && maeConfiCampo.getPaisOidPais().getMoneOidMone() != null){
				checkCombo("paisOidPais_moneOidMone" , maeConfiCampo.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			paisOidPais_fopaOidFormPago, paisOidPais_fopaOidFormPago.clone(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		if(maeConfiCampo != null && maeConfiCampo.getPaisOidPais().getFopaOidFormPago() != null){
				checkCombo("paisOidPais_fopaOidFormPago" , maeConfiCampo.getPaisOidPais().getFopaOidFormPago().getId().toString());
			}
		MaeTipoClienViewData sbtiOidSubtClie_ticlOidTipoClie = new MaeTipoClienViewData();
		asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_QUERY,SBTIOIDSUBTCLIE_TICLOIDTIPOCLIE_COMBO_CONNECTOR, 
			sbtiOidSubtClie_ticlOidTipoClie, sbtiOidSubtClie_ticlOidTipoClie.clone(), "maeTipoClienView", "sbtiOidSubtClie_ticlOidTipoClie", "result_ROWSET" );
		if(maeConfiCampo != null && maeConfiCampo.getSbtiOidSubtClie().getTiclOidTipoClie() != null){
				checkCombo("sbtiOidSubtClie_ticlOidTipoClie" , maeConfiCampo.getSbtiOidSubtClie().getTiclOidTipoClie().getId().toString());
			}
		SegModulData atreOidAtriEspe_moduOidModu = new SegModulData();
		asignarComboResultados(BUSINESSID_ATREOIDATRIESPE_MODUOIDMODU_QUERY,ATREOIDATRIESPE_MODUOIDMODU_COMBO_CONNECTOR, 
			atreOidAtriEspe_moduOidModu, atreOidAtriEspe_moduOidModu.clone(), "segModul", "atreOidAtriEspe_moduOidModu", "result_ROWSET" );
		if(maeConfiCampo != null && maeConfiCampo.getAtreOidAtriEspe().getModuOidModu() != null){
				checkCombo("atreOidAtriEspe_moduOidModu" , maeConfiCampo.getAtreOidAtriEspe().getModuOidModu().getId().toString());
			}
		
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		if(comboName.trim().equals("paisOidPais_moneOidMoneAlt")  || comboName.trim().equals("paisOidPais_moneOidMone")  || comboName.trim().equals("paisOidPais_fopaOidFormPago") ){
			String paisOidPais_moneOidMoneAltDefaultValue = (String)checkedCombos.get("paisOidPais_moneOidMoneAlt");
			String paisOidPais_moneOidMoneDefaultValue = (String)checkedCombos.get("paisOidPais_moneOidMone");
			String paisOidPais_fopaOidFormPagoDefaultValue = (String)checkedCombos.get("paisOidPais_fopaOidFormPago");
			if(paisOidPais_moneOidMoneAltDefaultValue != null &&paisOidPais_moneOidMoneDefaultValue != null &&paisOidPais_fopaOidFormPagoDefaultValue != null){
				SegPaisData paisOidPais= new SegPaisData();
				es.indra.belcorp.mso.SegMonedData paisOidPaisMoneOidMoneAlt = new es.indra.belcorp.mso.SegMonedData();
				paisOidPaisMoneOidMoneAlt.setId(new Integer(paisOidPais_moneOidMoneAltDefaultValue ));
				paisOidPais.setMoneOidMoneAlt(paisOidPaisMoneOidMoneAlt);
				es.indra.belcorp.mso.SegMonedData paisOidPaisMoneOidMone = new es.indra.belcorp.mso.SegMonedData();
				paisOidPaisMoneOidMone.setId(new Integer(paisOidPais_moneOidMoneDefaultValue ));
				paisOidPais.setMoneOidMone(paisOidPaisMoneOidMone);
				es.indra.belcorp.mso.BelFormaPagoTaponData paisOidPaisFopaOidFormPago = new es.indra.belcorp.mso.BelFormaPagoTaponData();
				paisOidPaisFopaOidFormPago.setId(new Integer(paisOidPais_fopaOidFormPagoDefaultValue ));
				paisOidPais.setFopaOidFormPago(paisOidPaisFopaOidFormPago);
				asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
					paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET",true );
				String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais");
				if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
					checkCombo("paisOidPais",paisOidPaisDefaultValue);
					checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
					cascadeComboLoad(checkedCombos, "paisOidPais");
				}
			}
		}

		if(comboName.trim().equals("sbtiOidSubtClie_ticlOidTipoClie") ){
			String sbtiOidSubtClie_ticlOidTipoClieDefaultValue = (String)checkedCombos.get("sbtiOidSubtClie_ticlOidTipoClie");
			if(sbtiOidSubtClie_ticlOidTipoClieDefaultValue != null){
				MaeSubtiClienData sbtiOidSubtClie= new MaeSubtiClienData();
				es.indra.belcorp.mso.MaeTipoClienViewData sbtiOidSubtClieTiclOidTipoClie = new es.indra.belcorp.mso.MaeTipoClienViewData();
				sbtiOidSubtClieTiclOidTipoClie.setId(new Integer(sbtiOidSubtClie_ticlOidTipoClieDefaultValue ));
				sbtiOidSubtClie.setTiclOidTipoClie(sbtiOidSubtClieTiclOidTipoClie);
				asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_QUERY,SBTIOIDSUBTCLIE_COMBO_CONNECTOR, 
					sbtiOidSubtClie, sbtiOidSubtClie.clone(), "maeSubtiClien", "sbtiOidSubtClie", "result_ROWSET",false );
			}
		}

		if(comboName.trim().equals("atreOidAtriEspe_moduOidModu") ){
			String atreOidAtriEspe_moduOidModuDefaultValue = (String)checkedCombos.get("atreOidAtriEspe_moduOidModu");
			if(atreOidAtriEspe_moduOidModuDefaultValue != null){
				PedAtribEspecData atreOidAtriEspe= new PedAtribEspecData();
				es.indra.belcorp.mso.SegModulData atreOidAtriEspeModuOidModu = new es.indra.belcorp.mso.SegModulData();
				atreOidAtriEspeModuOidModu.setId(new Integer(atreOidAtriEspe_moduOidModuDefaultValue ));
				atreOidAtriEspe.setModuOidModu(atreOidAtriEspeModuOidModu);
				asignarComboResultados(BUSINESSID_ATREOIDATRIESPE_QUERY,ATREOIDATRIESPE_COMBO_CONNECTOR, 
					atreOidAtriEspe, atreOidAtriEspe.clone(), "pedAtribEspec", "atreOidAtriEspe", "result_ROWSET",false );
			}
		}

		
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param maeConfiCampo La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(MaeConfiCampoData maeConfiCampo) 
		throws Exception{
		if(maeConfiCampo.getPaisOidPais() != null){
			SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMoneAlt(maeConfiCampo.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setMoneOidMone(maeConfiCampo.getPaisOidPais().getMoneOidMone());
			paisOidPais.setFopaOidFormPago(maeConfiCampo.getPaisOidPais().getFopaOidFormPago());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , maeConfiCampo.getPaisOidPais().getId().toString());
			}
		if(maeConfiCampo.getSbtiOidSubtClie() != null){
			MaeSubtiClienData sbtiOidSubtClie = new MaeSubtiClienData();
			sbtiOidSubtClie.setTiclOidTipoClie(maeConfiCampo.getSbtiOidSubtClie().getTiclOidTipoClie());
			asignarComboResultados(BUSINESSID_SBTIOIDSUBTCLIE_QUERY,SBTIOIDSUBTCLIE_COMBO_CONNECTOR, sbtiOidSubtClie, sbtiOidSubtClie.clone(), "maeSubtiClien", "sbtiOidSubtClie", "result_ROWSET");
			checkCombo("sbtiOidSubtClie" , maeConfiCampo.getSbtiOidSubtClie().getId().toString());
			}
		if(maeConfiCampo.getAtreOidAtriEspe() != null){
			PedAtribEspecData atreOidAtriEspe = new PedAtribEspecData();
			atreOidAtriEspe.setModuOidModu(maeConfiCampo.getAtreOidAtriEspe().getModuOidModu());
			asignarComboResultados(BUSINESSID_ATREOIDATRIESPE_QUERY,ATREOIDATRIESPE_COMBO_CONNECTOR, atreOidAtriEspe, atreOidAtriEspe.clone(), "pedAtribEspec", "atreOidAtriEspe", "result_ROWSET");
			checkCombo("atreOidAtriEspe" , maeConfiCampo.getAtreOidAtriEspe().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		MaeConfiCampoData maeConfiCampo = 
			(MaeConfiCampoData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(maeConfiCampo.getPaisOidPais() != null){
			maeConfiCampo.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			maeConfiCampo.getPaisOidPais(),
			maeConfiCampo.getPaisOidPais().clone(),
			"segPais"));
		}
		if(maeConfiCampo.getSbtiOidSubtClie() != null){
			maeConfiCampo.setSbtiOidSubtClie((es.indra.belcorp.mso.MaeSubtiClienData)
			getSingleObject(BUSINESSID_SBTIOIDSUBTCLIE_QUERY, 
			maeConfiCampo.getSbtiOidSubtClie(),
			maeConfiCampo.getSbtiOidSubtClie().clone(),
			"maeSubtiClien"));
		}
		if(maeConfiCampo.getAtreOidAtriEspe() != null){
			maeConfiCampo.setAtreOidAtriEspe((es.indra.belcorp.mso.PedAtribEspecData)
			getSingleObject(BUSINESSID_ATREOIDATRIESPE_QUERY, 
			maeConfiCampo.getAtreOidAtriEspe(),
			maeConfiCampo.getAtreOidAtriEspe().clone(),
			"pedAtribEspec"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(maeConfiCampo);
		loadLeafDependenceCombos(maeConfiCampo);
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







