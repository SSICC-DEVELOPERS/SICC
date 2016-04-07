/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraDetalLPStartUp.java,v 1.1 2009/12/03 18:41:44 pecbazalar Exp $
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
public class CobUsuarEtapaCobraDetalLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 357;
	public static final short CREATEFORM_SIZE = 511;
	public static final short UPDATEFORM_SIZE = 511;
	public static final short VIEWFORM_SIZE = 511;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCobUsuarEtapaCobraDetalQueryFromToUserPage";
	
	
				public static final String BUSINESSID_UECCOIDUSUAETAPCOBR_QUERY ="MMGCobUsuarEtapaCobraCabecQueryFromToUser";
				public static final String UECCOIDUSUAETAPCOBR_COMBO_CONNECTOR = "CobUsuarEtapaCobraCabecConectorCombo";
	
				public static final String BUSINESSID_EDTCOIDETAPDEUDTIPOCARG_QUERY ="MMGCobEtapaDeudaTipoCargoQueryFromToUser";
				public static final String EDTCOIDETAPDEUDTIPOCARG_COMBO_CONNECTOR = "CobEtapaDeudaTipoCargoConectorCombo";
	
				public static final String BUSINESSID_ZSGVOIDSUBGVENT_QUERY ="MMGZonSubGerenVentaViewQueryFromToUser";
				public static final String ZSGVOIDSUBGVENT_COMBO_CONNECTOR = "ZonSubGerenVentaViewConectorCombo";
	
				public static final String BUSINESSID_ZORGOIDREGI_QUERY ="MMGZonRegioViewQueryFromToUser";
				public static final String ZORGOIDREGI_COMBO_CONNECTOR = "ZonRegioViewConectorCombo";
	
				public static final String BUSINESSID_ZZONOIDZONA_QUERY ="MMGZonZonaViewQueryFromToUser";
				public static final String ZZONOIDZONA_COMBO_CONNECTOR = "ZonZonaViewConectorCombo";
	
				public static final String BUSINESSID_ZSCCOIDSECC_QUERY ="MMGZonSecciViewQueryFromToUser";
				public static final String ZSCCOIDSECC_COMBO_CONNECTOR = "ZonSecciViewConectorCombo";
	
				public static final String BUSINESSID_TERROIDTERR_QUERY ="MMGZonTerriViewQueryFromToUser";
				public static final String TERROIDTERR_COMBO_CONNECTOR = "ZonTerriViewConectorCombo";
	
				public static final String BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY ="MMGCobMetodLiquiViewQueryFromToUser";
				public static final String MELCOIDMETOLIQUCOBR_COMBO_CONNECTOR = "CobMetodLiquiViewConectorCombo";
	
				public static final String BUSINESSID_EUCOOIDESTAUSUAETAPCOBR_QUERY ="MMGCobEstadUsuarEtapaCobraQueryFromToUser";
				public static final String EUCOOIDESTAUSUAETAPCOBR_COMBO_CONNECTOR = "CobEstadUsuarEtapaCobraConectorCombo";
	
				public static final String BUSINESSID_GACAOIDGUIOARGUCABE_QUERY ="MMGCobGuionArgumCabecViewQueryFromToUser";
				public static final String GACAOIDGUIOARGUCABE_COMBO_CONNECTOR = "CobGuionArgumCabecViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CobUsuarEtapaCobraDetalLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CobUsuarEtapaCobraDetalPage");
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
			buildJsPageSize("CobUsuarEtapaCobraDetal");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CobUsuarEtapaCobraDetalPage", "cod", "CobUsuarEtapaCobraDetal." + accion + ".label");
			
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
			limpiarBotoneraLista("cobUsuarEtapaCobraDetal", accion);
			
			
			
			
			
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
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		
		
		
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cobUsuarEtapaCobraDetalLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CobUsuarEtapaCobraDetalPage", "onblur", "window.focus();");
		
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
		conectorAction("CobUsuarEtapaCobraDetalLPStartUp");
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
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalQuery= new CobUsuarEtapaCobraDetalData();
		cobUsuarEtapaCobraDetalQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CobUsuarEtapaCobraDetalData datosResult = (CobUsuarEtapaCobraDetalData)getSingleObject(BUSINESSID_QUERY, cobUsuarEtapaCobraDetalQuery, 
			cobUsuarEtapaCobraDetalQuery.clone(), "cobUsuarEtapaCobraDetal");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal = datosResult;
		es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobr = cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr();
		if(ueccOidUsuaEtapCobr != null && ueccOidUsuaEtapCobr.getId() != null) checkCombo("ueccOidUsuaEtapCobr" , ueccOidUsuaEtapCobr.getId().toString());
		es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCarg = cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg();
		if(edtcOidEtapDeudTipoCarg != null && edtcOidEtapDeudTipoCarg.getId() != null) checkCombo("edtcOidEtapDeudTipoCarg" , edtcOidEtapDeudTipoCarg.getId().toString());
		es.indra.belcorp.mso.ZonSubGerenVentaViewData zsgvOidSubgVent = cobUsuarEtapaCobraDetal.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
		es.indra.belcorp.mso.ZonRegioViewData zorgOidRegi = cobUsuarEtapaCobraDetal.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZona = cobUsuarEtapaCobraDetal.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
		es.indra.belcorp.mso.ZonSecciViewData zsccOidSecc = cobUsuarEtapaCobraDetal.getZsccOidSecc();
		if(zsccOidSecc != null && zsccOidSecc.getId() != null) checkCombo("zsccOidSecc" , zsccOidSecc.getId().toString());
		es.indra.belcorp.mso.ZonTerriViewData terrOidTerr = cobUsuarEtapaCobraDetal.getTerrOidTerr();
		if(terrOidTerr != null && terrOidTerr.getId() != null) checkCombo("terrOidTerr" , terrOidTerr.getId().toString());
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobr = cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr();
		if(melcOidMetoLiquCobr != null && melcOidMetoLiquCobr.getId() != null) checkCombo("melcOidMetoLiquCobr" , melcOidMetoLiquCobr.getId().toString());
		es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData eucoOidEstaUsuaEtapCobr = cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr();
		if(eucoOidEstaUsuaEtapCobr != null && eucoOidEstaUsuaEtapCobr.getId() != null) checkCombo("eucoOidEstaUsuaEtapCobr" , eucoOidEstaUsuaEtapCobr.getId().toString());
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabe = cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe();
		if(gacaOidGuioArguCabe != null && gacaOidGuioArguCabe.getId() != null) checkCombo("gacaOidGuioArguCabe" , gacaOidGuioArguCabe.getId().toString());
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobUsuarEtapaCobraDetal.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
					asignarAtributo("COMBO", "ueccOidUsuaEtapCobr", "disabled", "S");
					asignarAtributo("COMBO", "edtcOidEtapDeudTipoCarg", "disabled", "S");
					asignarAtributo("COMBO", "zsgvOidSubgVent", "disabled", "S");
					asignarAtributo("COMBO", "zorgOidRegi", "disabled", "S");
					asignarAtributo("COMBO", "zzonOidZona", "disabled", "S");
					asignarAtributo("COMBO", "zsccOidSecc", "disabled", "S");
					asignarAtributo("COMBO", "terrOidTerr", "disabled", "S");
					asignarAtributo("COMBO", "melcOidMetoLiquCobr", "disabled", "S");
					asignarAtributo("COMBO", "eucoOidEstaUsuaEtapCobr", "disabled", "S");
					asignarAtributo("COMBO", "gacaOidGuioArguCabe", "disabled", "S");asignarAtributo("TEXT", "valObse", "disabled", "S");
		
		
	
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
		asignarAtributo("COMBO", "ueccOidUsuaEtapCobr", "req", "S");
		asignarAtributo("COMBO", "edtcOidEtapDeudTipoCarg", "req", "S");
		asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		
		
		
		
		
		
		
		
		
		asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");
		
		
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
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		
		
		
		
		
		
		
		
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
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		
		
		
		
		
		
		
		
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
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		
		
		
		
		
		
		
		
		
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
		conectorAction("CobUsuarEtapaCobraDetalLPStartUp");
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
		//asignarAtributo("FORMULARIO", "cobUsuarEtapaCobraDetalFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "ueccOidUsuaEtapCobr", "req", "S");
				asignarAtributo("COMBO", "edtcOidEtapDeudTipoCarg", "req", "S");
				asignarAtributo("COMBO", "zsgvOidSubgVent", "req", "S");
		
		//Asignamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = UtilidadesSession.getFormatoFecha(this);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			
			
			
			
			
			
			
			
			
			
			asignarAtributo("TEXT", "valObse", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 100);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CobUsuarEtapaCobraDetal");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalQuery= new CobUsuarEtapaCobraDetalData();
		cobUsuarEtapaCobraDetalQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CobUsuarEtapaCobraDetalData  datosResult = (CobUsuarEtapaCobraDetalData)getSingleObject(BUSINESSID_QUERY, cobUsuarEtapaCobraDetalQuery, 
			cobUsuarEtapaCobraDetalQuery.clone(), "cobUsuarEtapaCobraDetal");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobr = cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr();
		if(ueccOidUsuaEtapCobr != null && ueccOidUsuaEtapCobr.getId() != null) checkCombo("ueccOidUsuaEtapCobr" , ueccOidUsuaEtapCobr.getId().toString());
		es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCarg = cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg();
		if(edtcOidEtapDeudTipoCarg != null && edtcOidEtapDeudTipoCarg.getId() != null) checkCombo("edtcOidEtapDeudTipoCarg" , edtcOidEtapDeudTipoCarg.getId().toString());
		es.indra.belcorp.mso.ZonSubGerenVentaViewData zsgvOidSubgVent = cobUsuarEtapaCobraDetal.getZsgvOidSubgVent();
		if(zsgvOidSubgVent != null && zsgvOidSubgVent.getId() != null) checkCombo("zsgvOidSubgVent" , zsgvOidSubgVent.getId().toString());
		es.indra.belcorp.mso.ZonRegioViewData zorgOidRegi = cobUsuarEtapaCobraDetal.getZorgOidRegi();
		if(zorgOidRegi != null && zorgOidRegi.getId() != null) checkCombo("zorgOidRegi" , zorgOidRegi.getId().toString());
		es.indra.belcorp.mso.ZonZonaViewData zzonOidZona = cobUsuarEtapaCobraDetal.getZzonOidZona();
		if(zzonOidZona != null && zzonOidZona.getId() != null) checkCombo("zzonOidZona" , zzonOidZona.getId().toString());
		es.indra.belcorp.mso.ZonSecciViewData zsccOidSecc = cobUsuarEtapaCobraDetal.getZsccOidSecc();
		if(zsccOidSecc != null && zsccOidSecc.getId() != null) checkCombo("zsccOidSecc" , zsccOidSecc.getId().toString());
		es.indra.belcorp.mso.ZonTerriViewData terrOidTerr = cobUsuarEtapaCobraDetal.getTerrOidTerr();
		if(terrOidTerr != null && terrOidTerr.getId() != null) checkCombo("terrOidTerr" , terrOidTerr.getId().toString());
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobr = cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr();
		if(melcOidMetoLiquCobr != null && melcOidMetoLiquCobr.getId() != null) checkCombo("melcOidMetoLiquCobr" , melcOidMetoLiquCobr.getId().toString());
		es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData eucoOidEstaUsuaEtapCobr = cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr();
		if(eucoOidEstaUsuaEtapCobr != null && eucoOidEstaUsuaEtapCobr.getId() != null) checkCombo("eucoOidEstaUsuaEtapCobr" , eucoOidEstaUsuaEtapCobr.getId().toString());
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabe = cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe();
		if(gacaOidGuioArguCabe != null && gacaOidGuioArguCabe.getId() != null) checkCombo("gacaOidGuioArguCabe" , gacaOidGuioArguCabe.getId().toString());
		asignar("TEXT", "valObse", FormatUtils.formatObject(cobUsuarEtapaCobraDetal.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(cobUsuarEtapaCobraDetal.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",1, false)");
					asignarAtributo("COMBO","ueccOidUsuaEtapCobr", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",2, true)");
					asignarAtributo("COMBO","ueccOidUsuaEtapCobr", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",2, false)");
					asignarAtributo("COMBO","edtcOidEtapDeudTipoCarg", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",3, true)");
					asignarAtributo("COMBO","edtcOidEtapDeudTipoCarg", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",3, false)");
					asignarAtributo("COMBO","zsgvOidSubgVent", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",4, true)");
					asignarAtributo("COMBO","zsgvOidSubgVent", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",4, false)");
					asignarAtributo("COMBO","zorgOidRegi", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",5, true)");
					asignarAtributo("COMBO","zorgOidRegi", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",5, false)");
					asignarAtributo("COMBO","zzonOidZona", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",6, true)");
					asignarAtributo("COMBO","zzonOidZona", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",6, false)");
					asignarAtributo("COMBO","zsccOidSecc", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",7, true)");
					asignarAtributo("COMBO","zsccOidSecc", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",7, false)");
					asignarAtributo("COMBO","terrOidTerr", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",8, true)");
					asignarAtributo("COMBO","terrOidTerr", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",8, false)");
					asignarAtributo("COMBO","melcOidMetoLiquCobr", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",9, true)");
					asignarAtributo("COMBO","melcOidMetoLiquCobr", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",9, false)");
					asignarAtributo("COMBO","eucoOidEstaUsuaEtapCobr", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",10, true)");
					asignarAtributo("COMBO","eucoOidEstaUsuaEtapCobr", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",10, false)");
					asignarAtributo("COMBO","gacaOidGuioArguCabe", "ontab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",11, true)");
					asignarAtributo("COMBO","gacaOidGuioArguCabe", "onshtab", "ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",11, false)");
				asignarAtributo("AREATEXTO", "valObse", "ontab","ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",12, true)");
				asignarAtributo("AREATEXTO", "valObse", "onshtab","ejecutarAccionFocoModificacion(\"cobUsuarEtapaCobraDetalFrm\",12, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","cobUsuarEtapaCobraDetalTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","cobUsuarEtapaCobraDetalTrButtons");

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
		borrarCampo("melcOidMetoLiquCobr");
		borrarCampo("eucoOidEstaUsuaEtapCobr");
		borrarCampo("gacaOidGuioArguCabe");
		borrarCampo("valObse");
		
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
				
				traza("MMG: el atributo es ueccOidUsuaEtapCobr...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "ueccOidUsuaEtapCobr", "disabled", "S");
				traza("MMG: el atributo es edtcOidEtapDeudTipoCarg...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						asignarAtributo("COMBO", "edtcOidEtapDeudTipoCarg", "disabled", "S");
				traza("MMG: el atributo es zsgvOidSubgVent...");		
				
				traza("MMG: el atributo es zorgOidRegi...");		
				
				traza("MMG: el atributo es zzonOidZona...");		
				
				traza("MMG: el atributo es zsccOidSecc...");		
				
				traza("MMG: el atributo es terrOidTerr...");		
				
				traza("MMG: el atributo es melcOidMetoLiquCobr...");		
				
				traza("MMG: el atributo es eucoOidEstaUsuaEtapCobr...");		
				
				traza("MMG: el atributo es gacaOidGuioArguCabe...");		
				
				traza("MMG: el atributo es valObse...");		
				
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
		asignarAtributo("CAPA","cobUsuarEtapaCobraDetalFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cobUsuarEtapaCobraDetalListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","cobUsuarEtapaCobraDetalListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal) throws Exception{
		HashMap checkedCombos = new HashMap();
		CobUsuarEtapaCobraCabecData ueccOidUsuaEtapCobr = new CobUsuarEtapaCobraCabecData();
		
						asignarComboResultados(BUSINESSID_UECCOIDUSUAETAPCOBR_QUERY,UECCOIDUSUAETAPCOBR_COMBO_CONNECTOR, 
			ueccOidUsuaEtapCobr, ueccOidUsuaEtapCobr.clone(), "cobUsuarEtapaCobraCabec", "ueccOidUsuaEtapCobr", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr() != null){
				checkCombo("ueccOidUsuaEtapCobr" , cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr().getId().toString());
			}
		CobEtapaDeudaTipoCargoData edtcOidEtapDeudTipoCarg = new CobEtapaDeudaTipoCargoData();
		
						asignarComboResultados(BUSINESSID_EDTCOIDETAPDEUDTIPOCARG_QUERY,EDTCOIDETAPDEUDTIPOCARG_COMBO_CONNECTOR, 
			edtcOidEtapDeudTipoCarg, edtcOidEtapDeudTipoCarg.clone(), "cobEtapaDeudaTipoCargo", "edtcOidEtapDeudTipoCarg", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg() != null){
				checkCombo("edtcOidEtapDeudTipoCarg" , cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg().getId().toString());
			}
		ZonSubGerenVentaViewData zsgvOidSubgVent = new ZonSubGerenVentaViewData();
		
						asignarComboResultados(BUSINESSID_ZSGVOIDSUBGVENT_QUERY,ZSGVOIDSUBGVENT_COMBO_CONNECTOR, 
			zsgvOidSubgVent, zsgvOidSubgVent.clone(), "zonSubGerenVentaView", "zsgvOidSubgVent", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getZsgvOidSubgVent() != null){
				checkCombo("zsgvOidSubgVent" , cobUsuarEtapaCobraDetal.getZsgvOidSubgVent().getId().toString());
			}
		ZonRegioViewData zorgOidRegi = new ZonRegioViewData();
		
						asignarComboResultados(BUSINESSID_ZORGOIDREGI_QUERY,ZORGOIDREGI_COMBO_CONNECTOR, 
			zorgOidRegi, zorgOidRegi.clone(), "zonRegioView", "zorgOidRegi", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getZorgOidRegi() != null){
				checkCombo("zorgOidRegi" , cobUsuarEtapaCobraDetal.getZorgOidRegi().getId().toString());
			}
		ZonZonaViewData zzonOidZona = new ZonZonaViewData();
		
						asignarComboResultados(BUSINESSID_ZZONOIDZONA_QUERY,ZZONOIDZONA_COMBO_CONNECTOR, 
			zzonOidZona, zzonOidZona.clone(), "zonZonaView", "zzonOidZona", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getZzonOidZona() != null){
				checkCombo("zzonOidZona" , cobUsuarEtapaCobraDetal.getZzonOidZona().getId().toString());
			}
		ZonSecciViewData zsccOidSecc = new ZonSecciViewData();
		
						asignarComboResultados(BUSINESSID_ZSCCOIDSECC_QUERY,ZSCCOIDSECC_COMBO_CONNECTOR, 
			zsccOidSecc, zsccOidSecc.clone(), "zonSecciView", "zsccOidSecc", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getZsccOidSecc() != null){
				checkCombo("zsccOidSecc" , cobUsuarEtapaCobraDetal.getZsccOidSecc().getId().toString());
			}
		ZonTerriViewData terrOidTerr = new ZonTerriViewData();
		
						asignarComboResultados(BUSINESSID_TERROIDTERR_QUERY,TERROIDTERR_COMBO_CONNECTOR, 
			terrOidTerr, terrOidTerr.clone(), "zonTerriView", "terrOidTerr", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getTerrOidTerr() != null){
				checkCombo("terrOidTerr" , cobUsuarEtapaCobraDetal.getTerrOidTerr().getId().toString());
			}
		CobMetodLiquiViewData melcOidMetoLiquCobr = new CobMetodLiquiViewData();
		
						asignarComboResultados(BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY,MELCOIDMETOLIQUCOBR_COMBO_CONNECTOR, 
			melcOidMetoLiquCobr, melcOidMetoLiquCobr.clone(), "cobMetodLiquiView", "melcOidMetoLiquCobr", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr() != null){
				checkCombo("melcOidMetoLiquCobr" , cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr().getId().toString());
			}
		CobEstadUsuarEtapaCobraData eucoOidEstaUsuaEtapCobr = new CobEstadUsuarEtapaCobraData();
		
						asignarComboResultados(BUSINESSID_EUCOOIDESTAUSUAETAPCOBR_QUERY,EUCOOIDESTAUSUAETAPCOBR_COMBO_CONNECTOR, 
			eucoOidEstaUsuaEtapCobr, eucoOidEstaUsuaEtapCobr.clone(), "cobEstadUsuarEtapaCobra", "eucoOidEstaUsuaEtapCobr", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr() != null){
				checkCombo("eucoOidEstaUsuaEtapCobr" , cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr().getId().toString());
			}
		CobGuionArgumCabecViewData gacaOidGuioArguCabe = new CobGuionArgumCabecViewData();
		
						asignarComboResultados(BUSINESSID_GACAOIDGUIOARGUCABE_QUERY,GACAOIDGUIOARGUCABE_COMBO_CONNECTOR, 
			gacaOidGuioArguCabe, gacaOidGuioArguCabe.clone(), "cobGuionArgumCabecView", "gacaOidGuioArguCabe", "result_ROWSET" );
		if(cobUsuarEtapaCobraDetal != null && cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe() != null){
				checkCombo("gacaOidGuioArguCabe" , cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe().getId().toString());
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
	* @param cobUsuarEtapaCobraDetal La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetal = 
			(CobUsuarEtapaCobraDetalData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr() != null){
			cobUsuarEtapaCobraDetal.setUeccOidUsuaEtapCobr((es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData)
			getSingleObject(BUSINESSID_UECCOIDUSUAETAPCOBR_QUERY, 
			cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr(),
			cobUsuarEtapaCobraDetal.getUeccOidUsuaEtapCobr().clone(),
			"cobUsuarEtapaCobraCabec"));
		}
		if(cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg() != null){
			cobUsuarEtapaCobraDetal.setEdtcOidEtapDeudTipoCarg((es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData)
			getSingleObject(BUSINESSID_EDTCOIDETAPDEUDTIPOCARG_QUERY, 
			cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg(),
			cobUsuarEtapaCobraDetal.getEdtcOidEtapDeudTipoCarg().clone(),
			"cobEtapaDeudaTipoCargo"));
		}
		if(cobUsuarEtapaCobraDetal.getZsgvOidSubgVent() != null){
			cobUsuarEtapaCobraDetal.setZsgvOidSubgVent((es.indra.belcorp.mso.ZonSubGerenVentaViewData)
			getSingleObject(BUSINESSID_ZSGVOIDSUBGVENT_QUERY, 
			cobUsuarEtapaCobraDetal.getZsgvOidSubgVent(),
			cobUsuarEtapaCobraDetal.getZsgvOidSubgVent().clone(),
			"zonSubGerenVentaView"));
		}
		if(cobUsuarEtapaCobraDetal.getZorgOidRegi() != null){
			cobUsuarEtapaCobraDetal.setZorgOidRegi((es.indra.belcorp.mso.ZonRegioViewData)
			getSingleObject(BUSINESSID_ZORGOIDREGI_QUERY, 
			cobUsuarEtapaCobraDetal.getZorgOidRegi(),
			cobUsuarEtapaCobraDetal.getZorgOidRegi().clone(),
			"zonRegioView"));
		}
		if(cobUsuarEtapaCobraDetal.getZzonOidZona() != null){
			cobUsuarEtapaCobraDetal.setZzonOidZona((es.indra.belcorp.mso.ZonZonaViewData)
			getSingleObject(BUSINESSID_ZZONOIDZONA_QUERY, 
			cobUsuarEtapaCobraDetal.getZzonOidZona(),
			cobUsuarEtapaCobraDetal.getZzonOidZona().clone(),
			"zonZonaView"));
		}
		if(cobUsuarEtapaCobraDetal.getZsccOidSecc() != null){
			cobUsuarEtapaCobraDetal.setZsccOidSecc((es.indra.belcorp.mso.ZonSecciViewData)
			getSingleObject(BUSINESSID_ZSCCOIDSECC_QUERY, 
			cobUsuarEtapaCobraDetal.getZsccOidSecc(),
			cobUsuarEtapaCobraDetal.getZsccOidSecc().clone(),
			"zonSecciView"));
		}
		if(cobUsuarEtapaCobraDetal.getTerrOidTerr() != null){
			cobUsuarEtapaCobraDetal.setTerrOidTerr((es.indra.belcorp.mso.ZonTerriViewData)
			getSingleObject(BUSINESSID_TERROIDTERR_QUERY, 
			cobUsuarEtapaCobraDetal.getTerrOidTerr(),
			cobUsuarEtapaCobraDetal.getTerrOidTerr().clone(),
			"zonTerriView"));
		}
		if(cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr() != null){
			cobUsuarEtapaCobraDetal.setMelcOidMetoLiquCobr((es.indra.belcorp.mso.CobMetodLiquiViewData)
			getSingleObject(BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY, 
			cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr(),
			cobUsuarEtapaCobraDetal.getMelcOidMetoLiquCobr().clone(),
			"cobMetodLiquiView"));
		}
		if(cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr() != null){
			cobUsuarEtapaCobraDetal.setEucoOidEstaUsuaEtapCobr((es.indra.belcorp.mso.CobEstadUsuarEtapaCobraData)
			getSingleObject(BUSINESSID_EUCOOIDESTAUSUAETAPCOBR_QUERY, 
			cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr(),
			cobUsuarEtapaCobraDetal.getEucoOidEstaUsuaEtapCobr().clone(),
			"cobEstadUsuarEtapaCobra"));
		}
		if(cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe() != null){
			cobUsuarEtapaCobraDetal.setGacaOidGuioArguCabe((es.indra.belcorp.mso.CobGuionArgumCabecViewData)
			getSingleObject(BUSINESSID_GACAOIDGUIOARGUCABE_QUERY, 
			cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe(),
			cobUsuarEtapaCobraDetal.getGacaOidGuioArguCabe().clone(),
			"cobGuionArgumCabecView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cobUsuarEtapaCobraDetal);
		loadLeafDependenceCombos(cobUsuarEtapaCobraDetal);
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
			borrarNodo("TR","nombre","formTr8");
			borrarNodo("TR","nombre","formGapTr8");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			borrarNodo("TR","nombre","formTr10");
			borrarNodo("TR","nombre","formGapTr10");
			borrarNodo("TR","nombre","formTr11");
			borrarNodo("TR","nombre","formGapTr11");
			
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





