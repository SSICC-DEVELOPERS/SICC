/*
    INDRA/CAR/mmg
    $Id: CarSoliEntrBloqLPStartUp.java,v 1.1 2009/12/03 18:40:12 pecbazalar Exp $
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
public class CarSoliEntrBloqLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 958;
	public static final short CREATEFORM_SIZE = 958;
	public static final short UPDATEFORM_SIZE = 958;
	public static final short VIEWFORM_SIZE = 958;

	//Cosntantes que definene elementos de la lçogica de negocio de las entidada
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCarSoliEntrBloqQueryFromToUserPage";
	public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	public static final String BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_QUERY ="MMGSegCanalViewQueryFromToUser";public static final String BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_QUERY ="MMGSegAccesQueryFromToUser";public static final String BUSINESSID_SBACOIDSBAC_QUERY ="MMGSegSubacQueryFromToUser";public static final String SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR = "SegCanalViewConectorCombo";
	public static final String SBACOIDSBAC_ACCEOIDACCE_COMBO_CONNECTOR = "SegAccesConectorCombo";
	public static final String SBACOIDSBAC_COMBO_CONNECTOR = "SegSubacConectorCombo";
	public static final String BUSINESSID_TSOLOIDTIPOSOLI_QUERY ="MMGPedTipoSolicQueryFromToUser";public static final String TSOLOIDTIPOSOLI_COMBO_CONNECTOR = "PedTipoSolicConectorCombo";
	public static final String BUSINESSID_SOCAOIDSOLICABE_QUERY ="MMGPedSolicCabecQueryFromToUser";public static final String SOCAOIDSOLICABE_COMBO_CONNECTOR = "PedSolicCabecConectorCombo";
	public static final String BUSINESSID_JERAOIDJERA_QUERY ="MMGCarJerarQueryFromToUser";public static final String JERAOIDJERA_COMBO_CONNECTOR = "CarJerarConectorCombo";
	public static final String BUSINESSID_ESPEOIDESTAPEDI_QUERY ="MMGCarEstatPedidQueryFromToUser";public static final String ESPEOIDESTAPEDI_COMBO_CONNECTOR = "CarEstatPedidConectorCombo";
	public static final String BUSINESSID_PERDOIDPERI_QUERY ="MMGCraPerioQueryFromToUser";public static final String PERDOIDPERI_COMBO_CONNECTOR = "CraPerioConectorCombo";
	public static final String BUSINESSID_CLIEOIDCLIE_QUERY ="MMGMaeClienQueryFromToUser";public static final String CLIEOIDCLIE_COMBO_CONNECTOR = "MaeClienConectorCombo";
	public static final String BUSINESSID_CLIEOIDGEREZONA_QUERY ="MMGMaeClienQueryFromToUser";public static final String CLIEOIDGEREZONA_COMBO_CONNECTOR = "MaeClienConectorCombo";
	public static final String BUSINESSID_CUADOIDCLIEUNIDADMI_QUERY ="MMGMaeClienUnidaAdminQueryFromToUser";public static final String CUADOIDCLIEUNIDADMI_COMBO_CONNECTOR = "MaeClienUnidaAdminConectorCombo";
	public static final String BUSINESSID_COAPOIDCODIAPRO_QUERY ="MMGCarCodigAprobQueryFromToUser";public static final String COAPOIDCODIAPRO_COMBO_CONNECTOR = "CarCodigAprobConectorCombo";
	public static final String BUSINESSID_EJCUOIDEJECCUEN_QUERY ="MMGCarEjecuCuentQueryFromToUser";public static final String EJCUOIDEJECCUEN_COMBO_CONNECTOR = "CarEjecuCuentConectorCombo";
	public static final String BUSINESSID_EJCUOIDUSUALIBE_QUERY ="MMGCarEjecuCuentQueryFromToUser";public static final String EJCUOIDUSUALIBE_COMBO_CONNECTOR = "CarEjecuCuentConectorCombo";
	public static final String BUSINESSID_NIRIOIDNIVERIES_QUERY ="MMGCarNivelRiesgQueryFromToUser";public static final String NIRIOIDNIVERIES_COMBO_CONNECTOR = "CarNivelRiesgConectorCombo";
	public static final String BUSINESSID_GRSOOIDGRUPSOLI_QUERY ="MMGCarGrupoSolicQueryFromToUser";public static final String GRSOOIDGRUPSOLI_COMBO_CONNECTOR = "CarGrupoSolicConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CarSoliEntrBloqLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CarSoliEntrBloqPage");
	}

	public void ejecucion() throws Exception {
		try{
			//Llamamos al metodo sobresctrito de la clase padre para ejecutar las acciones comunes:
			//obtener configuración del mantenimiento
			super.ejecucion();
		
			//Activamos las trazas
			setTrazaFichero();
			
			//Establecemos el tamaño de la página
			buildJsPageSize("CarSoliEntrBloq");
			
			
		
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CarSoliEntrBloqPage", "cod", "CarSoliEntrBloq." + accion + ".label");
			
			//Ponemos en la página el idioma de usuario, el idioma de la pagina para mostrar los errores, 
			//y el codigo del idioma por defecto
			asignar("VAR", VAR_IDIOMA, MMGDruidaHelper.getUserDefaultLanguage(this));
			asignar("VAR", VAR_IDIOMA_XML, MMGDruidaHelper.getIdioma(this));
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Establecemos los tamaños y posiciones de la capas de la pantalla
			establecerSizeCapas(accion, origen);
			
			//Limpiamos la botonera
			limpiarBotoneraLista("carSoliEntrBloq", accion);
			
			
			
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
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		

		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "carSoliEntrBloqLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CarSoliEntrBloqPage", "onblur", "window.focus();");
		
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
		conectorAction("CarSoliEntrBloqLPStartUp");
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
		CarSoliEntrBloqData carSoliEntrBloqQuery= new CarSoliEntrBloqData();
		carSoliEntrBloqQuery.setId(new Integer(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CarSoliEntrBloqData datosResult = (CarSoliEntrBloqData)getSingleObject(BUSINESSID_QUERY, carSoliEntrBloqQuery, 
			carSoliEntrBloqQuery.clone(), "carSoliEntrBloq");
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		setDependenceComboLabels(datosResult);
		
		//Damos los valores a los labels del modo view
		CarSoliEntrBloqData carSoliEntrBloq = datosResult;
	
	
	
	
		asignarAtributo("LABELC", "lblViewFecDocu", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getFecDocu(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndNoti", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getIndNoti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValMontOrde", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getValMontOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValMontDeudVenc", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getValMontDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndVali1", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getIndVali1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndVali2", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getIndVali2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndVali3", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getIndVali3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewIndVali4", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getIndVali4(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewFecHoraLibe", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getFecHoraLibe(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));			
	
		asignarAtributo("LABELC", "lblViewValObse", "valor", 
				FormatUtils.formatObject(carSoliEntrBloq.getValObse(), 
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
		asignarAtributo("COMBO", "sbacOidSbac", "req", "S");
		asignarAtributo("COMBO", "tsolOidTipoSoli", "req", "S");
		asignarAtributo("COMBO", "socaOidSoliCabe", "req", "S");
		asignarAtributo("TEXT", "fecDocu", "req", "S");
		asignarAtributo("TEXT", "indNoti", "req", "S");
		asignarAtributo("TEXT", "valMontOrde", "req", "S");
		asignarAtributo("TEXT", "valMontDeudVenc", "req", "S");
		asignarAtributo("COMBO", "jeraOidJera", "req", "S");
		asignarAtributo("COMBO", "espeOidEstaPedi", "req", "S");
		asignarAtributo("COMBO", "perdOidPeri", "req", "S");
		asignarAtributo("COMBO", "clieOidClie", "req", "S");
		asignarAtributo("COMBO", "cuadOidClieUnidAdmi", "req", "S");
		asignarAtributo("COMBO", "ejcuOidEjecCuen", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el 
		//valor del idioma por defecto
		
		
		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		conectorAction("CarSoliEntrBloqLPStartUp");
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
		//asignarAtributo("FORMULARIO", "carSoliEntrBloqFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "sbacOidSbac", "req", "S");
		asignarAtributo("COMBO", "tsolOidTipoSoli", "req", "S");
		asignarAtributo("COMBO", "socaOidSoliCabe", "req", "S");
		asignarAtributo("TEXT", "fecDocu", "req", "S");
		asignarAtributo("TEXT", "indNoti", "req", "S");
		asignarAtributo("TEXT", "valMontOrde", "req", "S");
		asignarAtributo("TEXT", "valMontDeudVenc", "req", "S");
		asignarAtributo("COMBO", "jeraOidJera", "req", "S");
		asignarAtributo("COMBO", "espeOidEstaPedi", "req", "S");
		asignarAtributo("COMBO", "perdOidPeri", "req", "S");
		asignarAtributo("COMBO", "clieOidClie", "req", "S");
		asignarAtributo("COMBO", "cuadOidClieUnidAdmi", "req", "S");
		asignarAtributo("COMBO", "ejcuOidEjecCuen", "req", "S");
		asignarAtributo("COMBO", "niriOidNiveRies", "req", "S");
		asignarAtributo("COMBO", "grsoOidGrupSoli", "req", "S");
		
		
		//Asiganamos a los campos internacionalizables la función de onblur para actualizar el valor
		//para el idioma por defecto
		
		

		//Asignamos las validaciones
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		String datePattern = MMGDruidaHelper.getUserDatePattern(this);
		String decimalSeparator = MMGDruidaHelper.getUserDecimalSeparator(this);
		String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
		
		
		
		asignarAtributo("TEXT", "fecDocu", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "indNoti", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "valMontOrde", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "valMontDeudVenc", "validacion", "ValidaFloat(Decimal2(cdos_trim(valor), entornoV(',')), " +(12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", true, 0, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ")");
		asignarAtributo("TEXT", "indVali1", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali2", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali3", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "indVali4", "validacion", "ValidaInt(cdos_trim(valor), 1, 0, 9)");
		asignarAtributo("TEXT", "fecHoraLibe", "validacion", "ValidaFecha(cdos_trim(valor), '" + datePattern + "')");
		asignarAtributo("TEXT", "valObse", "validacion", "ValidaLongitud(cdos_trim(valor), 0, 100)");
		
		
		
		
		
		
		
		
		
		
		
		

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CarSoliEntrBloq");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CarSoliEntrBloqData carSoliEntrBloqQuery= new CarSoliEntrBloqData();
		carSoliEntrBloqQuery.setId(new Integer(id));

		//Sacamos de la base de datos la entidad a modificar
		CarSoliEntrBloqData  datosResult = (CarSoliEntrBloqData)getSingleObject(BUSINESSID_QUERY, carSoliEntrBloqQuery, 
			carSoliEntrBloqQuery.clone(), "carSoliEntrBloq");

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos();
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CarSoliEntrBloqData carSoliEntrBloq = datosResult;
		asignar("VAR", "idSelection", id);
		es.indra.belcorp.mso.SegPaisData paisOidPais = carSoliEntrBloq.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
	
		es.indra.belcorp.mso.SegSubacData sbacOidSbac = carSoliEntrBloq.getSbacOidSbac();
		if(sbacOidSbac != null && sbacOidSbac.getId() != null) checkCombo("sbacOidSbac" , sbacOidSbac.getId().toString());
	
		es.indra.belcorp.mso.PedTipoSolicData tsolOidTipoSoli = carSoliEntrBloq.getTsolOidTipoSoli();
		if(tsolOidTipoSoli != null && tsolOidTipoSoli.getId() != null) checkCombo("tsolOidTipoSoli" , tsolOidTipoSoli.getId().toString());
	
		es.indra.belcorp.mso.PedSolicCabecData socaOidSoliCabe = carSoliEntrBloq.getSocaOidSoliCabe();
		if(socaOidSoliCabe != null && socaOidSoliCabe.getId() != null) checkCombo("socaOidSoliCabe" , socaOidSoliCabe.getId().toString());
	
		asignar("TEXT", "fecDocu", FormatUtils.formatObject(carSoliEntrBloq.getFecDocu(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indNoti", FormatUtils.formatObject(carSoliEntrBloq.getIndNoti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valMontOrde", FormatUtils.formatObject(carSoliEntrBloq.getValMontOrde(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valMontDeudVenc", FormatUtils.formatObject(carSoliEntrBloq.getValMontDeudVenc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indVali1", FormatUtils.formatObject(carSoliEntrBloq.getIndVali1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indVali2", FormatUtils.formatObject(carSoliEntrBloq.getIndVali2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indVali3", FormatUtils.formatObject(carSoliEntrBloq.getIndVali3(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "indVali4", FormatUtils.formatObject(carSoliEntrBloq.getIndVali4(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "fecHoraLibe", FormatUtils.formatObject(carSoliEntrBloq.getFecHoraLibe(), 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		asignar("TEXT", "valObse", FormatUtils.formatObject(carSoliEntrBloq.getValObse(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
	
		es.indra.belcorp.mso.CarJerarData jeraOidJera = carSoliEntrBloq.getJeraOidJera();
		if(jeraOidJera != null && jeraOidJera.getId() != null) checkCombo("jeraOidJera" , jeraOidJera.getId().toString());
	
		es.indra.belcorp.mso.CarEstatPedidData espeOidEstaPedi = carSoliEntrBloq.getEspeOidEstaPedi();
		if(espeOidEstaPedi != null && espeOidEstaPedi.getId() != null) checkCombo("espeOidEstaPedi" , espeOidEstaPedi.getId().toString());
	
		es.indra.belcorp.mso.CraPerioData perdOidPeri = carSoliEntrBloq.getPerdOidPeri();
		if(perdOidPeri != null && perdOidPeri.getId() != null) checkCombo("perdOidPeri" , perdOidPeri.getId().toString());
	
		es.indra.belcorp.mso.MaeClienData clieOidClie = carSoliEntrBloq.getClieOidClie();
		if(clieOidClie != null && clieOidClie.getId() != null) checkCombo("clieOidClie" , clieOidClie.getId().toString());
	
		es.indra.belcorp.mso.MaeClienData clieOidGereZona = carSoliEntrBloq.getClieOidGereZona();
		if(clieOidGereZona != null && clieOidGereZona.getId() != null) checkCombo("clieOidGereZona" , clieOidGereZona.getId().toString());
	
		es.indra.belcorp.mso.MaeClienUnidaAdminData cuadOidClieUnidAdmi = carSoliEntrBloq.getCuadOidClieUnidAdmi();
		if(cuadOidClieUnidAdmi != null && cuadOidClieUnidAdmi.getId() != null) checkCombo("cuadOidClieUnidAdmi" , cuadOidClieUnidAdmi.getId().toString());
	
		es.indra.belcorp.mso.CarCodigAprobData coapOidCodiApro = carSoliEntrBloq.getCoapOidCodiApro();
		if(coapOidCodiApro != null && coapOidCodiApro.getId() != null) checkCombo("coapOidCodiApro" , coapOidCodiApro.getId().toString());
	
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuen = carSoliEntrBloq.getEjcuOidEjecCuen();
		if(ejcuOidEjecCuen != null && ejcuOidEjecCuen.getId() != null) checkCombo("ejcuOidEjecCuen" , ejcuOidEjecCuen.getId().toString());
	
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidUsuaLibe = carSoliEntrBloq.getEjcuOidUsuaLibe();
		if(ejcuOidUsuaLibe != null && ejcuOidUsuaLibe.getId() != null) checkCombo("ejcuOidUsuaLibe" , ejcuOidUsuaLibe.getId().toString());
	
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRies = carSoliEntrBloq.getNiriOidNiveRies();
		if(niriOidNiveRies != null && niriOidNiveRies.getId() != null) checkCombo("niriOidNiveRies" , niriOidNiveRies.getId().toString());
	
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoli = carSoliEntrBloq.getGrsoOidGrupSoli();
		if(grsoOidGrupSoli != null && grsoOidGrupSoli.getId() != null) checkCombo("grsoOidGrupSoli" , grsoOidGrupSoli.getId().toString());
	
	

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(carSoliEntrBloq.jdoGetTimeStamp()));
		
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
		borrarNodo("TD","nombre","carSoliEntrBloqTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","carSoliEntrBloqTrButtons");

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
		asignarAtributo("CAPA","carSoliEntrBloqFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","carSoliEntrBloqPreListLayer", "y", String.valueOf(sizeForm + 24));
		asignarAtributo("CAPA","carSoliEntrBloqListLayer", "y", String.valueOf(sizeForm + 46));		
		asignarAtributo("CAPA","carSoliEntrBloqListButtonsLayer", "y", String.valueOf(sizeForm + 299));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos() throws Exception{
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, new BelFormaPagoTaponData(), new BelFormaPagoTaponData(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, new SegMonedData(), new SegMonedData(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_QUERY,SBACOIDSBAC_ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR, new SegCanalViewData(), new SegCanalViewData(), "segCanalView", "sbacOidSbac_acceOidAcce_canaOidCana", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_TSOLOIDTIPOSOLI_QUERY,TSOLOIDTIPOSOLI_COMBO_CONNECTOR, new PedTipoSolicData(), new PedTipoSolicData(), "pedTipoSolic", "tsolOidTipoSoli", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_SOCAOIDSOLICABE_QUERY,SOCAOIDSOLICABE_COMBO_CONNECTOR, new PedSolicCabecData(), new PedSolicCabecData(), "pedSolicCabec", "socaOidSoliCabe", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_JERAOIDJERA_QUERY,JERAOIDJERA_COMBO_CONNECTOR, new CarJerarData(), new CarJerarData(), "carJerar", "jeraOidJera", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_ESPEOIDESTAPEDI_QUERY,ESPEOIDESTAPEDI_COMBO_CONNECTOR, new CarEstatPedidData(), new CarEstatPedidData(), "carEstatPedid", "espeOidEstaPedi", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_PERDOIDPERI_QUERY,PERDOIDPERI_COMBO_CONNECTOR, new CraPerioData(), new CraPerioData(), "craPerio", "perdOidPeri", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CLIEOIDCLIE_QUERY,CLIEOIDCLIE_COMBO_CONNECTOR, new MaeClienData(), new MaeClienData(), "maeClien", "clieOidClie", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CLIEOIDGEREZONA_QUERY,CLIEOIDGEREZONA_COMBO_CONNECTOR, new MaeClienData(), new MaeClienData(), "maeClien", "clieOidGereZona", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_CUADOIDCLIEUNIDADMI_QUERY,CUADOIDCLIEUNIDADMI_COMBO_CONNECTOR, new MaeClienUnidaAdminData(), new MaeClienUnidaAdminData(), "maeClienUnidaAdmin", "cuadOidClieUnidAdmi", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_COAPOIDCODIAPRO_QUERY,COAPOIDCODIAPRO_COMBO_CONNECTOR, new CarCodigAprobData(), new CarCodigAprobData(), "carCodigAprob", "coapOidCodiApro", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_EJCUOIDEJECCUEN_QUERY,EJCUOIDEJECCUEN_COMBO_CONNECTOR, new CarEjecuCuentData(), new CarEjecuCuentData(), "carEjecuCuent", "ejcuOidEjecCuen", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_EJCUOIDUSUALIBE_QUERY,EJCUOIDUSUALIBE_COMBO_CONNECTOR, new CarEjecuCuentData(), new CarEjecuCuentData(), "carEjecuCuent", "ejcuOidUsuaLibe", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_NIRIOIDNIVERIES_QUERY,NIRIOIDNIVERIES_COMBO_CONNECTOR, new CarNivelRiesgData(), new CarNivelRiesgData(), "carNivelRiesg", "niriOidNiveRies", "result_ROWSET" );
		asignarComboResultados(BUSINESSID_GRSOOIDGRUPSOLI_QUERY,GRSOOIDGRUPSOLI_COMBO_CONNECTOR, new CarGrupoSolicData(), new CarGrupoSolicData(), "carGrupoSolic", "grsoOidGrupSoli", "result_ROWSET" );
		
			
		//Seleccionamos en los combos de enitdades estructurales el valor asociado al usuario
		/*String paisOidPais = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais");
		if(paisOidPais != null && !paisOidPais.trim().equals("")) checkCombo("paisOidPais", paisOidPais);
		String sbacOidSbac = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSubac");
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")) checkCombo("sbacOidSbac", sbacOidSbac);
		
		*/
	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param carSoliEntrBloq La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CarSoliEntrBloqData carSoliEntrBloq) 
		throws Exception{
		if(carSoliEntrBloq.getPaisOidPais() != null){
			SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMoneAlt(carSoliEntrBloq.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setFopaOidFormPago(carSoliEntrBloq.getPaisOidPais().getFopaOidFormPago());
			paisOidPais.setMoneOidMone(carSoliEntrBloq.getPaisOidPais().getMoneOidMone());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , carSoliEntrBloq.getPaisOidPais().getId().toString());
			checkCombo("paisOidPais_moneOidMoneAlt" , carSoliEntrBloq.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			checkCombo("paisOidPais_fopaOidFormPago" , carSoliEntrBloq.getPaisOidPais().getFopaOidFormPago().getId().toString());
			checkCombo("paisOidPais_moneOidMone" , carSoliEntrBloq.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		if(carSoliEntrBloq.getSbacOidSbac() != null){
			SegSubacData sbacOidSbac = new SegSubacData();
			sbacOidSbac.setAcceOidAcce(carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce());
			asignarComboResultados(BUSINESSID_SBACOIDSBAC_QUERY,SBACOIDSBAC_COMBO_CONNECTOR, sbacOidSbac, sbacOidSbac.clone(), "segSubac", "sbacOidSbac", "result_ROWSET");
			checkCombo("sbacOidSbac" , carSoliEntrBloq.getSbacOidSbac().getId().toString());
			SegAccesData sbacOidSbac_acceOidAcce = new SegAccesData();
			sbacOidSbac_acceOidAcce.setCanaOidCana(carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce().getCanaOidCana());
			asignarComboResultados(BUSINESSID_SBACOIDSBAC_ACCEOIDACCE_QUERY,SBACOIDSBAC_ACCEOIDACCE_COMBO_CONNECTOR, sbacOidSbac_acceOidAcce, sbacOidSbac_acceOidAcce.clone(), "segAcces", "sbacOidSbac_acceOidAcce", "result_ROWSET");
			checkCombo("sbacOidSbac_acceOidAcce" , carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce().getId().toString());
			checkCombo("sbacOidSbac_acceOidAcce_canaOidCana" , carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce().getCanaOidCana().getId().toString());
			}
		if(carSoliEntrBloq.getTsolOidTipoSoli() != null){
			checkCombo("tsolOidTipoSoli" , carSoliEntrBloq.getTsolOidTipoSoli().getId().toString());
			}
		if(carSoliEntrBloq.getSocaOidSoliCabe() != null){
			checkCombo("socaOidSoliCabe" , carSoliEntrBloq.getSocaOidSoliCabe().getId().toString());
			}
		if(carSoliEntrBloq.getJeraOidJera() != null){
			checkCombo("jeraOidJera" , carSoliEntrBloq.getJeraOidJera().getId().toString());
			}
		if(carSoliEntrBloq.getEspeOidEstaPedi() != null){
			checkCombo("espeOidEstaPedi" , carSoliEntrBloq.getEspeOidEstaPedi().getId().toString());
			}
		if(carSoliEntrBloq.getPerdOidPeri() != null){
			checkCombo("perdOidPeri" , carSoliEntrBloq.getPerdOidPeri().getId().toString());
			}
		if(carSoliEntrBloq.getClieOidClie() != null){
			checkCombo("clieOidClie" , carSoliEntrBloq.getClieOidClie().getId().toString());
			}
		if(carSoliEntrBloq.getClieOidGereZona() != null){
			checkCombo("clieOidGereZona" , carSoliEntrBloq.getClieOidGereZona().getId().toString());
			}
		if(carSoliEntrBloq.getCuadOidClieUnidAdmi() != null){
			checkCombo("cuadOidClieUnidAdmi" , carSoliEntrBloq.getCuadOidClieUnidAdmi().getId().toString());
			}
		if(carSoliEntrBloq.getCoapOidCodiApro() != null){
			checkCombo("coapOidCodiApro" , carSoliEntrBloq.getCoapOidCodiApro().getId().toString());
			}
		if(carSoliEntrBloq.getEjcuOidEjecCuen() != null){
			checkCombo("ejcuOidEjecCuen" , carSoliEntrBloq.getEjcuOidEjecCuen().getId().toString());
			}
		if(carSoliEntrBloq.getEjcuOidUsuaLibe() != null){
			checkCombo("ejcuOidUsuaLibe" , carSoliEntrBloq.getEjcuOidUsuaLibe().getId().toString());
			}
		if(carSoliEntrBloq.getNiriOidNiveRies() != null){
			checkCombo("niriOidNiveRies" , carSoliEntrBloq.getNiriOidNiveRies().getId().toString());
			}
		if(carSoliEntrBloq.getGrsoOidGrupSoli() != null){
			checkCombo("grsoOidGrupSoli" , carSoliEntrBloq.getGrsoOidGrupSoli().getId().toString());
			}
		
	}
	
	/**
	* Este método nos permite establecer el valor de los labels de una jerarquái de dependencia
	*/
	protected void setDependenceComboLabels(CarSoliEntrBloqData carSoliEntrBloq) 
		throws Exception{
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMoneAlt", "valor",FormatUtils.formatObject(carSoliEntrBloq.getPaisOidPais().getMoneOidMoneAlt()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_fopaOidFormPago", "valor",FormatUtils.formatObject(carSoliEntrBloq.getPaisOidPais().getFopaOidFormPago()));
		asignarAtributo("LABELC", "lblViewPaisOidPais_moneOidMone", "valor",FormatUtils.formatObject(carSoliEntrBloq.getPaisOidPais().getMoneOidMone()));
		asignarAtributo("LABELC", "lblViewPaisOidPais", "valor",FormatUtils.formatObject(carSoliEntrBloq.getPaisOidPais()));
		asignarAtributo("LABELC", "lblViewSbacOidSbac_acceOidAcce_canaOidCana", "valor",FormatUtils.formatObject(carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce().getCanaOidCana()));
		asignarAtributo("LABELC", "lblViewSbacOidSbac_acceOidAcce", "valor",FormatUtils.formatObject(carSoliEntrBloq.getSbacOidSbac().getAcceOidAcce()));
		asignarAtributo("LABELC", "lblViewSbacOidSbac", "valor",FormatUtils.formatObject(carSoliEntrBloq.getSbacOidSbac()));
		asignarAtributo("LABELC", "lblViewTsolOidTipoSoli", "valor",FormatUtils.formatObject(carSoliEntrBloq.getTsolOidTipoSoli()));
		asignarAtributo("LABELC", "lblViewSocaOidSoliCabe", "valor",FormatUtils.formatObject(carSoliEntrBloq.getSocaOidSoliCabe()));
		asignarAtributo("LABELC", "lblViewJeraOidJera", "valor",FormatUtils.formatObject(carSoliEntrBloq.getJeraOidJera()));
		asignarAtributo("LABELC", "lblViewEspeOidEstaPedi", "valor",FormatUtils.formatObject(carSoliEntrBloq.getEspeOidEstaPedi()));
		asignarAtributo("LABELC", "lblViewPerdOidPeri", "valor",FormatUtils.formatObject(carSoliEntrBloq.getPerdOidPeri()));
		asignarAtributo("LABELC", "lblViewClieOidClie", "valor",FormatUtils.formatObject(carSoliEntrBloq.getClieOidClie()));
		asignarAtributo("LABELC", "lblViewClieOidGereZona", "valor",FormatUtils.formatObject(carSoliEntrBloq.getClieOidGereZona()));
		asignarAtributo("LABELC", "lblViewCuadOidClieUnidAdmi", "valor",FormatUtils.formatObject(carSoliEntrBloq.getCuadOidClieUnidAdmi()));
		asignarAtributo("LABELC", "lblViewCoapOidCodiApro", "valor",FormatUtils.formatObject(carSoliEntrBloq.getCoapOidCodiApro()));
		asignarAtributo("LABELC", "lblViewEjcuOidEjecCuen", "valor",FormatUtils.formatObject(carSoliEntrBloq.getEjcuOidEjecCuen()));
		asignarAtributo("LABELC", "lblViewEjcuOidUsuaLibe", "valor",FormatUtils.formatObject(carSoliEntrBloq.getEjcuOidUsuaLibe()));
		asignarAtributo("LABELC", "lblViewNiriOidNiveRies", "valor",FormatUtils.formatObject(carSoliEntrBloq.getNiriOidNiveRies()));
		asignarAtributo("LABELC", "lblViewGrsoOidGrupSoli", "valor",FormatUtils.formatObject(carSoliEntrBloq.getGrsoOidGrupSoli()));
		
			
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CarSoliEntrBloqData carSoliEntrBloq = 
			(CarSoliEntrBloqData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(carSoliEntrBloq.getPaisOidPais() != null){
			carSoliEntrBloq.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			carSoliEntrBloq.getPaisOidPais(),
			carSoliEntrBloq.getPaisOidPais().clone(),
			"segPais"));
		}
		if(carSoliEntrBloq.getSbacOidSbac() != null){
			carSoliEntrBloq.setSbacOidSbac((es.indra.belcorp.mso.SegSubacData)
			getSingleObject(BUSINESSID_SBACOIDSBAC_QUERY, 
			carSoliEntrBloq.getSbacOidSbac(),
			carSoliEntrBloq.getSbacOidSbac().clone(),
			"segSubac"));
		}
		if(carSoliEntrBloq.getTsolOidTipoSoli() != null){
			carSoliEntrBloq.setTsolOidTipoSoli((es.indra.belcorp.mso.PedTipoSolicData)
			getSingleObject(BUSINESSID_TSOLOIDTIPOSOLI_QUERY, 
			carSoliEntrBloq.getTsolOidTipoSoli(),
			carSoliEntrBloq.getTsolOidTipoSoli().clone(),
			"pedTipoSolic"));
		}
		if(carSoliEntrBloq.getSocaOidSoliCabe() != null){
			carSoliEntrBloq.setSocaOidSoliCabe((es.indra.belcorp.mso.PedSolicCabecData)
			getSingleObject(BUSINESSID_SOCAOIDSOLICABE_QUERY, 
			carSoliEntrBloq.getSocaOidSoliCabe(),
			carSoliEntrBloq.getSocaOidSoliCabe().clone(),
			"pedSolicCabec"));
		}
		if(carSoliEntrBloq.getJeraOidJera() != null){
			carSoliEntrBloq.setJeraOidJera((es.indra.belcorp.mso.CarJerarData)
			getSingleObject(BUSINESSID_JERAOIDJERA_QUERY, 
			carSoliEntrBloq.getJeraOidJera(),
			carSoliEntrBloq.getJeraOidJera().clone(),
			"carJerar"));
		}
		if(carSoliEntrBloq.getEspeOidEstaPedi() != null){
			carSoliEntrBloq.setEspeOidEstaPedi((es.indra.belcorp.mso.CarEstatPedidData)
			getSingleObject(BUSINESSID_ESPEOIDESTAPEDI_QUERY, 
			carSoliEntrBloq.getEspeOidEstaPedi(),
			carSoliEntrBloq.getEspeOidEstaPedi().clone(),
			"carEstatPedid"));
		}
		if(carSoliEntrBloq.getPerdOidPeri() != null){
			carSoliEntrBloq.setPerdOidPeri((es.indra.belcorp.mso.CraPerioData)
			getSingleObject(BUSINESSID_PERDOIDPERI_QUERY, 
			carSoliEntrBloq.getPerdOidPeri(),
			carSoliEntrBloq.getPerdOidPeri().clone(),
			"craPerio"));
		}
		if(carSoliEntrBloq.getClieOidClie() != null){
			carSoliEntrBloq.setClieOidClie((es.indra.belcorp.mso.MaeClienData)
			getSingleObject(BUSINESSID_CLIEOIDCLIE_QUERY, 
			carSoliEntrBloq.getClieOidClie(),
			carSoliEntrBloq.getClieOidClie().clone(),
			"maeClien"));
		}
		if(carSoliEntrBloq.getClieOidGereZona() != null){
			carSoliEntrBloq.setClieOidGereZona((es.indra.belcorp.mso.MaeClienData)
			getSingleObject(BUSINESSID_CLIEOIDGEREZONA_QUERY, 
			carSoliEntrBloq.getClieOidGereZona(),
			carSoliEntrBloq.getClieOidGereZona().clone(),
			"maeClien"));
		}
		if(carSoliEntrBloq.getCuadOidClieUnidAdmi() != null){
			carSoliEntrBloq.setCuadOidClieUnidAdmi((es.indra.belcorp.mso.MaeClienUnidaAdminData)
			getSingleObject(BUSINESSID_CUADOIDCLIEUNIDADMI_QUERY, 
			carSoliEntrBloq.getCuadOidClieUnidAdmi(),
			carSoliEntrBloq.getCuadOidClieUnidAdmi().clone(),
			"maeClienUnidaAdmin"));
		}
		if(carSoliEntrBloq.getCoapOidCodiApro() != null){
			carSoliEntrBloq.setCoapOidCodiApro((es.indra.belcorp.mso.CarCodigAprobData)
			getSingleObject(BUSINESSID_COAPOIDCODIAPRO_QUERY, 
			carSoliEntrBloq.getCoapOidCodiApro(),
			carSoliEntrBloq.getCoapOidCodiApro().clone(),
			"carCodigAprob"));
		}
		if(carSoliEntrBloq.getEjcuOidEjecCuen() != null){
			carSoliEntrBloq.setEjcuOidEjecCuen((es.indra.belcorp.mso.CarEjecuCuentData)
			getSingleObject(BUSINESSID_EJCUOIDEJECCUEN_QUERY, 
			carSoliEntrBloq.getEjcuOidEjecCuen(),
			carSoliEntrBloq.getEjcuOidEjecCuen().clone(),
			"carEjecuCuent"));
		}
		if(carSoliEntrBloq.getEjcuOidUsuaLibe() != null){
			carSoliEntrBloq.setEjcuOidUsuaLibe((es.indra.belcorp.mso.CarEjecuCuentData)
			getSingleObject(BUSINESSID_EJCUOIDUSUALIBE_QUERY, 
			carSoliEntrBloq.getEjcuOidUsuaLibe(),
			carSoliEntrBloq.getEjcuOidUsuaLibe().clone(),
			"carEjecuCuent"));
		}
		if(carSoliEntrBloq.getNiriOidNiveRies() != null){
			carSoliEntrBloq.setNiriOidNiveRies((es.indra.belcorp.mso.CarNivelRiesgData)
			getSingleObject(BUSINESSID_NIRIOIDNIVERIES_QUERY, 
			carSoliEntrBloq.getNiriOidNiveRies(),
			carSoliEntrBloq.getNiriOidNiveRies().clone(),
			"carNivelRiesg"));
		}
		if(carSoliEntrBloq.getGrsoOidGrupSoli() != null){
			carSoliEntrBloq.setGrsoOidGrupSoli((es.indra.belcorp.mso.CarGrupoSolicData)
			getSingleObject(BUSINESSID_GRSOOIDGRUPSOLI_QUERY, 
			carSoliEntrBloq.getGrsoOidGrupSoli(),
			carSoliEntrBloq.getGrsoOidGrupSoli().clone(),
			"carGrupoSolic"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(carSoliEntrBloq);
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
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneViewLabelTrId");
		borrarNodo("TR", "nombre", "paisOidPaisViewLabelTrId");
		borrarNodo("TR", "nombre", "sbacOidSbac_acceOidAcce_canaOidCanaViewLabelTrId");
		borrarNodo("TR", "nombre", "sbacOidSbac_acceOidAcceViewLabelTrId");
		borrarNodo("TR", "nombre", "sbacOidSbacViewLabelTrId");
		borrarNodo("TR", "nombre", "tsolOidTipoSoliViewLabelTrId");
		borrarNodo("TR", "nombre", "socaOidSoliCabeViewLabelTrId");
		borrarNodo("TR", "nombre", "fecDocuViewLabelTrId");
		borrarNodo("TR", "nombre", "indNotiViewLabelTrId");
		borrarNodo("TR", "nombre", "valMontOrdeViewLabelTrId");
		borrarNodo("TR", "nombre", "valMontDeudVencViewLabelTrId");
		borrarNodo("TR", "nombre", "indVali1ViewLabelTrId");
		borrarNodo("TR", "nombre", "indVali2ViewLabelTrId");
		borrarNodo("TR", "nombre", "indVali3ViewLabelTrId");
		borrarNodo("TR", "nombre", "indVali4ViewLabelTrId");
		borrarNodo("TR", "nombre", "fecHoraLibeViewLabelTrId");
		borrarNodo("TR", "nombre", "valObseViewLabelTrId");
		borrarNodo("TR", "nombre", "jeraOidJeraViewLabelTrId");
		borrarNodo("TR", "nombre", "espeOidEstaPediViewLabelTrId");
		borrarNodo("TR", "nombre", "perdOidPeriViewLabelTrId");
		borrarNodo("TR", "nombre", "clieOidClieViewLabelTrId");
		borrarNodo("TR", "nombre", "clieOidGereZonaViewLabelTrId");
		borrarNodo("TR", "nombre", "cuadOidClieUnidAdmiViewLabelTrId");
		borrarNodo("TR", "nombre", "coapOidCodiAproViewLabelTrId");
		borrarNodo("TR", "nombre", "ejcuOidEjecCuenViewLabelTrId");
		borrarNodo("TR", "nombre", "ejcuOidUsuaLibeViewLabelTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesViewLabelTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliViewLabelTrId");
		
	}

	/**
	*	Nos permite borrar los TR que contienen los widgets de los campos
	*/
	protected void removeWidgets() throws Exception{
		borrarNodo("TR", "nombre", "idWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneAltWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_fopaOidFormPagoWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPais_moneOidMoneWidgetTrId");
		borrarNodo("TR", "nombre", "paisOidPaisWidgetTrId");
		borrarNodo("TR", "nombre", "sbacOidSbac_acceOidAcce_canaOidCanaWidgetTrId");
		borrarNodo("TR", "nombre", "sbacOidSbac_acceOidAcceWidgetTrId");
		borrarNodo("TR", "nombre", "sbacOidSbacWidgetTrId");
		borrarNodo("TR", "nombre", "tsolOidTipoSoliWidgetTrId");
		borrarNodo("TR", "nombre", "socaOidSoliCabeWidgetTrId");
		borrarNodo("TR", "nombre", "fecDocuWidgetTrId");
		borrarNodo("TR", "nombre", "indNotiWidgetTrId");
		borrarNodo("TR", "nombre", "valMontOrdeWidgetTrId");
		borrarNodo("TR", "nombre", "valMontDeudVencWidgetTrId");
		borrarNodo("TR", "nombre", "indVali1WidgetTrId");
		borrarNodo("TR", "nombre", "indVali2WidgetTrId");
		borrarNodo("TR", "nombre", "indVali3WidgetTrId");
		borrarNodo("TR", "nombre", "indVali4WidgetTrId");
		borrarNodo("TR", "nombre", "fecHoraLibeWidgetTrId");
		borrarNodo("TR", "nombre", "valObseWidgetTrId");
		borrarNodo("TR", "nombre", "jeraOidJeraWidgetTrId");
		borrarNodo("TR", "nombre", "espeOidEstaPediWidgetTrId");
		borrarNodo("TR", "nombre", "perdOidPeriWidgetTrId");
		borrarNodo("TR", "nombre", "clieOidClieWidgetTrId");
		borrarNodo("TR", "nombre", "clieOidGereZonaWidgetTrId");
		borrarNodo("TR", "nombre", "cuadOidClieUnidAdmiWidgetTrId");
		borrarNodo("TR", "nombre", "coapOidCodiAproWidgetTrId");
		borrarNodo("TR", "nombre", "ejcuOidEjecCuenWidgetTrId");
		borrarNodo("TR", "nombre", "ejcuOidUsuaLibeWidgetTrId");
		borrarNodo("TR", "nombre", "niriOidNiveRiesWidgetTrId");
		borrarNodo("TR", "nombre", "grsoOidGrupSoliWidgetTrId");
		
	}
}







