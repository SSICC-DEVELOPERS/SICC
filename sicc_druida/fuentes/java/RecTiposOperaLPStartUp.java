/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaLPStartUp.java,v 1.1 2009/12/03 18:41:26 pecbazalar Exp $
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
public class RecTiposOperaLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 567;
	public static final short CREATEFORM_SIZE = 557;
	public static final short UPDATEFORM_SIZE = 557;
	public static final short VIEWFORM_SIZE = 557;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGRecTiposOperaQueryFromToUserPage";
	
	
				public static final String BUSINESSID_ROPEOIDOPER_QUERY ="MMGRecOperaQueryFromToUser";
				public static final String ROPEOIDOPER_COMBO_CONNECTOR = "RecOperaConectorCombo";
	
				public static final String BUSINESSID_MRDBOIDMOTIRECHDESB_QUERY ="MMGRecMotivRechaDesblQueryFromToUser";
				public static final String MRDBOIDMOTIRECHDESB_COMBO_CONNECTOR = "RecMotivRechaDesblConectorCombo";
	
				public static final String BUSINESSID_MOBLOIDBLOQDIFE_QUERY ="MMGRecMotivBloquQueryFromToUser";
				public static final String MOBLOIDBLOQDIFE_COMBO_CONNECTOR = "RecMotivBloquConectorCombo";
	
				public static final String BUSINESSID_MOBLOIDRECLANTE_QUERY ="MMGRecMotivBloquQueryFromToUser";
				public static final String MOBLOIDRECLANTE_COMBO_CONNECTOR = "RecMotivBloquConectorCombo";
	
				public static final String BUSINESSID_MOBLOIDBLOQIMPO_QUERY ="MMGRecMotivBloquQueryFromToUser";
				public static final String MOBLOIDBLOQIMPO_COMBO_CONNECTOR = "RecMotivBloquConectorCombo";
	
				public static final String BUSINESSID_MOBLOIDBLOQUNID_QUERY ="MMGRecMotivBloquQueryFromToUser";
				public static final String MOBLOIDBLOQUNID_COMBO_CONNECTOR = "RecMotivBloquConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public RecTiposOperaLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("RecTiposOperaPage");
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
			buildJsPageSize("RecTiposOpera");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "RecTiposOperaPage", "cod", "RecTiposOpera." + accion + ".label");
			
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
			limpiarBotoneraLista("recTiposOpera", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "recTiposOperaLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "RecTiposOperaPage", "onblur", "window.focus();");
		
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
		conectorAction("RecTiposOperaLPStartUp");
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
		RecTiposOperaData recTiposOperaQuery= new RecTiposOperaData();
		recTiposOperaQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		RecTiposOperaData datosResult = (RecTiposOperaData)getSingleObject(BUSINESSID_QUERY, recTiposOperaQuery, 
			recTiposOperaQuery.clone(), "recTiposOpera");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		RecTiposOperaData recTiposOpera = datosResult;
		asignar("TEXT", "valTipoOper", FormatUtils.formatObject(recTiposOpera.getValTipoOper(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indCampRefeUnic", FormatUtils.formatObject(recTiposOpera.getIndCampRefeUnic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasHaciAtra", FormatUtils.formatObject(recTiposOpera.getNumDiasHaciAtra(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valInfoEbelNoti", FormatUtils.formatObject(recTiposOpera.getValInfoEbelNoti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuEstaFact", FormatUtils.formatObject(recTiposOpera.getIndDevuEstaFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEnviEstaFact", FormatUtils.formatObject(recTiposOpera.getIndEnviEstaFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.RecOperaData ropeOidOper = recTiposOpera.getRopeOidOper();
		if(ropeOidOper != null && ropeOidOper.getId() != null) checkCombo("ropeOidOper" , ropeOidOper.getId().toString());
		es.indra.belcorp.mso.RecMotivRechaDesblData mrdbOidMotiRechDesb = recTiposOpera.getMrdbOidMotiRechDesb();
		if(mrdbOidMotiRechDesb != null && mrdbOidMotiRechDesb.getId() != null) checkCombo("mrdbOidMotiRechDesb" , mrdbOidMotiRechDesb.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqDife = recTiposOpera.getMoblOidBloqDife();
		if(moblOidBloqDife != null && moblOidBloqDife.getId() != null) checkCombo("moblOidBloqDife" , moblOidBloqDife.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidReclAnte = recTiposOpera.getMoblOidReclAnte();
		if(moblOidReclAnte != null && moblOidReclAnte.getId() != null) checkCombo("moblOidReclAnte" , moblOidReclAnte.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqImpo = recTiposOpera.getMoblOidBloqImpo();
		if(moblOidBloqImpo != null && moblOidBloqImpo.getId() != null) checkCombo("moblOidBloqImpo" , moblOidBloqImpo.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqUnid = recTiposOpera.getMoblOidBloqUnid();
		if(moblOidBloqUnid != null && moblOidBloqUnid.getId() != null) checkCombo("moblOidBloqUnid" , moblOidBloqUnid.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "valTipoOper", "disabled", "S");
		asignarAtributo("TEXT", "indCampRefeUnic", "disabled", "S");
		asignarAtributo("TEXT", "numDiasHaciAtra", "disabled", "S");
		asignarAtributo("TEXT", "valInfoEbelNoti", "disabled", "S");
		asignarAtributo("TEXT", "indDevuEstaFact", "disabled", "S");
		asignarAtributo("TEXT", "indEnviEstaFact", "disabled", "S");
		
					asignarAtributo("COMBO", "ropeOidOper", "disabled", "S");
					asignarAtributo("COMBO", "mrdbOidMotiRechDesb", "disabled", "S");
					asignarAtributo("COMBO", "moblOidBloqDife", "disabled", "S");
					asignarAtributo("COMBO", "moblOidReclAnte", "disabled", "S");
					asignarAtributo("COMBO", "moblOidBloqImpo", "disabled", "S");
					asignarAtributo("COMBO", "moblOidBloqUnid", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "valTipoOper", "req", "S");
		asignarAtributo("TEXT", "indCampRefeUnic", "req", "S");
		asignarAtributo("COMBO", "ropeOidOper", "req", "S");
		asignarAtributo("COMBO", "mrdbOidMotiRechDesb", "req", "S");
		
		
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
		asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
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
		asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
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
		asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
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
		asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
		asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
		asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		
		
		
		
		
		
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
		conectorAction("RecTiposOperaLPStartUp");
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
		//asignarAtributo("FORMULARIO", "recTiposOperaFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "valTipoOper", "req", "S");
				asignarAtributo("TEXT", "indCampRefeUnic", "req", "S");
				asignarAtributo("COMBO", "ropeOidOper", "req", "S");
				asignarAtributo("COMBO", "mrdbOidMotiRechDesb", "req", "S");
		
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
		
			asignarAtributo("TEXT", "valTipoOper", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			asignarAtributo("TEXT", "indCampRefeUnic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "numDiasHaciAtra", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 2, 0, 99);");
			asignarAtributo("TEXT", "valInfoEbelNoti", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indDevuEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indEnviEstaFact", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			
			
			
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando RecTiposOpera");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		RecTiposOperaData recTiposOperaQuery= new RecTiposOperaData();
		recTiposOperaQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		RecTiposOperaData  datosResult = (RecTiposOperaData)getSingleObject(BUSINESSID_QUERY, recTiposOperaQuery, 
			recTiposOperaQuery.clone(), "recTiposOpera");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		RecTiposOperaData recTiposOpera = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "valTipoOper", FormatUtils.formatObject(recTiposOpera.getValTipoOper(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indCampRefeUnic", FormatUtils.formatObject(recTiposOpera.getIndCampRefeUnic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasHaciAtra", FormatUtils.formatObject(recTiposOpera.getNumDiasHaciAtra(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valInfoEbelNoti", FormatUtils.formatObject(recTiposOpera.getValInfoEbelNoti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indDevuEstaFact", FormatUtils.formatObject(recTiposOpera.getIndDevuEstaFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indEnviEstaFact", FormatUtils.formatObject(recTiposOpera.getIndEnviEstaFact(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.RecOperaData ropeOidOper = recTiposOpera.getRopeOidOper();
		if(ropeOidOper != null && ropeOidOper.getId() != null) checkCombo("ropeOidOper" , ropeOidOper.getId().toString());
		es.indra.belcorp.mso.RecMotivRechaDesblData mrdbOidMotiRechDesb = recTiposOpera.getMrdbOidMotiRechDesb();
		if(mrdbOidMotiRechDesb != null && mrdbOidMotiRechDesb.getId() != null) checkCombo("mrdbOidMotiRechDesb" , mrdbOidMotiRechDesb.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqDife = recTiposOpera.getMoblOidBloqDife();
		if(moblOidBloqDife != null && moblOidBloqDife.getId() != null) checkCombo("moblOidBloqDife" , moblOidBloqDife.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidReclAnte = recTiposOpera.getMoblOidReclAnte();
		if(moblOidReclAnte != null && moblOidReclAnte.getId() != null) checkCombo("moblOidReclAnte" , moblOidReclAnte.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqImpo = recTiposOpera.getMoblOidBloqImpo();
		if(moblOidBloqImpo != null && moblOidBloqImpo.getId() != null) checkCombo("moblOidBloqImpo" , moblOidBloqImpo.getId().toString());
		es.indra.belcorp.mso.RecMotivBloquData moblOidBloqUnid = recTiposOpera.getMoblOidBloqUnid();
		if(moblOidBloqUnid != null && moblOidBloqUnid.getId() != null) checkCombo("moblOidBloqUnid" , moblOidBloqUnid.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(recTiposOpera.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",1, false)");
				asignarAtributo("AREATEXTO", "valTipoOper", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",2, true)");
				asignarAtributo("AREATEXTO", "valTipoOper", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",2, false)");
				asignarAtributo("AREATEXTO", "indCampRefeUnic", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",3, true)");
				asignarAtributo("AREATEXTO", "indCampRefeUnic", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",3, false)");
				asignarAtributo("AREATEXTO", "numDiasHaciAtra", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",4, true)");
				asignarAtributo("AREATEXTO", "numDiasHaciAtra", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",4, false)");
				asignarAtributo("AREATEXTO", "valInfoEbelNoti", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",5, true)");
				asignarAtributo("AREATEXTO", "valInfoEbelNoti", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",5, false)");
				asignarAtributo("AREATEXTO", "indDevuEstaFact", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",6, true)");
				asignarAtributo("AREATEXTO", "indDevuEstaFact", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",6, false)");
				asignarAtributo("AREATEXTO", "indEnviEstaFact", "ontab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",7, true)");
				asignarAtributo("AREATEXTO", "indEnviEstaFact", "onshtab","ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",7, false)");
					asignarAtributo("COMBO","ropeOidOper", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",8, true)");
					asignarAtributo("COMBO","ropeOidOper", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",8, false)");
					asignarAtributo("COMBO","mrdbOidMotiRechDesb", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",9, true)");
					asignarAtributo("COMBO","mrdbOidMotiRechDesb", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",9, false)");
					asignarAtributo("COMBO","moblOidBloqDife", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",10, true)");
					asignarAtributo("COMBO","moblOidBloqDife", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",10, false)");
					asignarAtributo("COMBO","moblOidReclAnte", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",11, true)");
					asignarAtributo("COMBO","moblOidReclAnte", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",11, false)");
					asignarAtributo("COMBO","moblOidBloqImpo", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",12, true)");
					asignarAtributo("COMBO","moblOidBloqImpo", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",12, false)");
					asignarAtributo("COMBO","moblOidBloqUnid", "ontab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",13, true)");
					asignarAtributo("COMBO","moblOidBloqUnid", "onshtab", "ejecutarAccionFocoModificacion(\"recTiposOperaFrm\",13, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","recTiposOperaTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","recTiposOperaTrButtons");

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
				
				traza("MMG: el atributo es valTipoOper...");		
				
				traza("MMG: el atributo es indCampRefeUnic...");		
				
				traza("MMG: el atributo es numDiasHaciAtra...");		
				
				traza("MMG: el atributo es valInfoEbelNoti...");		
				
				traza("MMG: el atributo es indDevuEstaFact...");		
				
				traza("MMG: el atributo es indEnviEstaFact...");		
				
				traza("MMG: el atributo es ropeOidOper...");		
				
				traza("MMG: el atributo es mrdbOidMotiRechDesb...");		
				
				traza("MMG: el atributo es moblOidBloqDife...");		
				
				traza("MMG: el atributo es moblOidReclAnte...");		
				
				traza("MMG: el atributo es moblOidBloqImpo...");		
				
				traza("MMG: el atributo es moblOidBloqUnid...");		
				
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
		asignarAtributo("CAPA","recTiposOperaFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","recTiposOperaListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","recTiposOperaListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(RecTiposOperaData recTiposOpera) throws Exception{
		HashMap checkedCombos = new HashMap();
		RecOperaData ropeOidOper = new RecOperaData();
		
						asignarComboResultados(BUSINESSID_ROPEOIDOPER_QUERY,ROPEOIDOPER_COMBO_CONNECTOR, 
			ropeOidOper, ropeOidOper.clone(), "recOpera", "ropeOidOper", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getRopeOidOper() != null){
				checkCombo("ropeOidOper" , recTiposOpera.getRopeOidOper().getId().toString());
			}
		RecMotivRechaDesblData mrdbOidMotiRechDesb = new RecMotivRechaDesblData();
		
						asignarComboResultados(BUSINESSID_MRDBOIDMOTIRECHDESB_QUERY,MRDBOIDMOTIRECHDESB_COMBO_CONNECTOR, 
			mrdbOidMotiRechDesb, mrdbOidMotiRechDesb.clone(), "recMotivRechaDesbl", "mrdbOidMotiRechDesb", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getMrdbOidMotiRechDesb() != null){
				checkCombo("mrdbOidMotiRechDesb" , recTiposOpera.getMrdbOidMotiRechDesb().getId().toString());
			}
		RecMotivBloquData moblOidBloqDife = new RecMotivBloquData();
		
						asignarComboResultados(BUSINESSID_MOBLOIDBLOQDIFE_QUERY,MOBLOIDBLOQDIFE_COMBO_CONNECTOR, 
			moblOidBloqDife, moblOidBloqDife.clone(), "recMotivBloqu", "moblOidBloqDife", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getMoblOidBloqDife() != null){
				checkCombo("moblOidBloqDife" , recTiposOpera.getMoblOidBloqDife().getId().toString());
			}
		RecMotivBloquData moblOidReclAnte = new RecMotivBloquData();
		
						asignarComboResultados(BUSINESSID_MOBLOIDRECLANTE_QUERY,MOBLOIDRECLANTE_COMBO_CONNECTOR, 
			moblOidReclAnte, moblOidReclAnte.clone(), "recMotivBloqu", "moblOidReclAnte", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getMoblOidReclAnte() != null){
				checkCombo("moblOidReclAnte" , recTiposOpera.getMoblOidReclAnte().getId().toString());
			}
		RecMotivBloquData moblOidBloqImpo = new RecMotivBloquData();
		
						asignarComboResultados(BUSINESSID_MOBLOIDBLOQIMPO_QUERY,MOBLOIDBLOQIMPO_COMBO_CONNECTOR, 
			moblOidBloqImpo, moblOidBloqImpo.clone(), "recMotivBloqu", "moblOidBloqImpo", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getMoblOidBloqImpo() != null){
				checkCombo("moblOidBloqImpo" , recTiposOpera.getMoblOidBloqImpo().getId().toString());
			}
		RecMotivBloquData moblOidBloqUnid = new RecMotivBloquData();
		
						asignarComboResultados(BUSINESSID_MOBLOIDBLOQUNID_QUERY,MOBLOIDBLOQUNID_COMBO_CONNECTOR, 
			moblOidBloqUnid, moblOidBloqUnid.clone(), "recMotivBloqu", "moblOidBloqUnid", "result_ROWSET" );
		if(recTiposOpera != null && recTiposOpera.getMoblOidBloqUnid() != null){
				checkCombo("moblOidBloqUnid" , recTiposOpera.getMoblOidBloqUnid().getId().toString());
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
	* @param recTiposOpera La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(RecTiposOperaData recTiposOpera) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		RecTiposOperaData recTiposOpera = 
			(RecTiposOperaData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(recTiposOpera.getRopeOidOper() != null){
			recTiposOpera.setRopeOidOper((es.indra.belcorp.mso.RecOperaData)
			getSingleObject(BUSINESSID_ROPEOIDOPER_QUERY, 
			recTiposOpera.getRopeOidOper(),
			recTiposOpera.getRopeOidOper().clone(),
			"recOpera"));
		}
		if(recTiposOpera.getMrdbOidMotiRechDesb() != null){
			recTiposOpera.setMrdbOidMotiRechDesb((es.indra.belcorp.mso.RecMotivRechaDesblData)
			getSingleObject(BUSINESSID_MRDBOIDMOTIRECHDESB_QUERY, 
			recTiposOpera.getMrdbOidMotiRechDesb(),
			recTiposOpera.getMrdbOidMotiRechDesb().clone(),
			"recMotivRechaDesbl"));
		}
		if(recTiposOpera.getMoblOidBloqDife() != null){
			recTiposOpera.setMoblOidBloqDife((es.indra.belcorp.mso.RecMotivBloquData)
			getSingleObject(BUSINESSID_MOBLOIDBLOQDIFE_QUERY, 
			recTiposOpera.getMoblOidBloqDife(),
			recTiposOpera.getMoblOidBloqDife().clone(),
			"recMotivBloqu"));
		}
		if(recTiposOpera.getMoblOidReclAnte() != null){
			recTiposOpera.setMoblOidReclAnte((es.indra.belcorp.mso.RecMotivBloquData)
			getSingleObject(BUSINESSID_MOBLOIDRECLANTE_QUERY, 
			recTiposOpera.getMoblOidReclAnte(),
			recTiposOpera.getMoblOidReclAnte().clone(),
			"recMotivBloqu"));
		}
		if(recTiposOpera.getMoblOidBloqImpo() != null){
			recTiposOpera.setMoblOidBloqImpo((es.indra.belcorp.mso.RecMotivBloquData)
			getSingleObject(BUSINESSID_MOBLOIDBLOQIMPO_QUERY, 
			recTiposOpera.getMoblOidBloqImpo(),
			recTiposOpera.getMoblOidBloqImpo().clone(),
			"recMotivBloqu"));
		}
		if(recTiposOpera.getMoblOidBloqUnid() != null){
			recTiposOpera.setMoblOidBloqUnid((es.indra.belcorp.mso.RecMotivBloquData)
			getSingleObject(BUSINESSID_MOBLOIDBLOQUNID_QUERY, 
			recTiposOpera.getMoblOidBloqUnid(),
			recTiposOpera.getMoblOidBloqUnid().clone(),
			"recMotivBloqu"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(recTiposOpera);
		loadLeafDependenceCombos(recTiposOpera);
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





