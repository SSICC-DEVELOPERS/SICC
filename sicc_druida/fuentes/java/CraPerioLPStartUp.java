/*
    INDRA/CAR/mmg
    $Id: CraPerioLPStartUp.java,v 1.1 2009/12/03 18:42:21 pecbazalar Exp $
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
public class CraPerioLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 525;
	public static final short CREATEFORM_SIZE = 531;
	public static final short UPDATEFORM_SIZE = 531;
	public static final short VIEWFORM_SIZE = 531;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCraPerioQueryFromToUserPage";
	
	
				public static final String BUSINESSID_MARCOIDMARC_QUERY ="MMGSegMarcaQueryFromToUser";
				public static final String MARCOIDMARC_COMBO_CONNECTOR = "SegMarcaConectorCombo";
	
				public static final String BUSINESSID_CANAOIDCANA_TIPEOIDTIPOPERI_QUERY ="MMGSegTipoPerioQueryFromToUser";
				public static final String BUSINESSID_CANAOIDCANA_QUERY ="MMGSegCanalQueryFromToUser";
				public static final String CANAOIDCANA_TIPEOIDTIPOPERI_COMBO_CONNECTOR = "SegTipoPerioConectorCombo";
	
				public static final String CANAOIDCANA_COMBO_CONNECTOR = "SegCanalConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";
				public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	
				public static final String BUSINESSID_ACCEOIDACCE_CANAOIDCANA_QUERY ="MMGSegCanalViewQueryFromToUser";
				public static final String BUSINESSID_ACCEOIDACCE_QUERY ="MMGSegAccesQueryFromToUser";
				public static final String ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR = "SegCanalViewConectorCombo";
	
				public static final String ACCEOIDACCE_COMBO_CONNECTOR = "SegAccesConectorCombo";
	
				public static final String BUSINESSID_PERIOIDPERI_TIPEOIDTIPOPERI_QUERY ="MMGSegTipoPerioQueryFromToUser";
				public static final String BUSINESSID_PERIOIDPERI_QUERY ="MMGSegPerioCorpoQueryFromToUser";
				public static final String PERIOIDPERI_TIPEOIDTIPOPERI_COMBO_CONNECTOR = "SegTipoPerioConectorCombo";
	
				public static final String PERIOIDPERI_COMBO_CONNECTOR = "SegPerioCorpoConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public CraPerioLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CraPerioPage");
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
			buildJsPageSize("CraPerio");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CraPerioPage", "cod", "CraPerio." + accion + ".label");
			
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
			limpiarBotoneraLista("craPerio", accion);
			
			
			
			
			
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
		
		
		
		
		
		asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "craPerioLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CraPerioPage", "onblur", "window.focus();");
		
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
		conectorAction("CraPerioLPStartUp");
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
		CraPerioData craPerioQuery= new CraPerioData();
		craPerioQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CraPerioData datosResult = (CraPerioData)getSingleObject(BUSINESSID_QUERY, craPerioQuery, 
			craPerioQuery.clone(), "craPerio");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CraPerioData craPerio = datosResult;
		es.indra.belcorp.mso.SegMarcaData marcOidMarc = craPerio.getMarcOidMarc();
		if(marcOidMarc != null && marcOidMarc.getId() != null) checkCombo("marcOidMarc" , marcOidMarc.getId().toString());
		es.indra.belcorp.mso.SegCanalData canaOidCana = craPerio.getCanaOidCana();
		if(canaOidCana != null && canaOidCana.getId() != null) checkCombo("canaOidCana" , canaOidCana.getId().toString());
		es.indra.belcorp.mso.SegPaisData paisOidPais = craPerio.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		es.indra.belcorp.mso.SegAccesData acceOidAcce = craPerio.getAcceOidAcce();
		if(acceOidAcce != null && acceOidAcce.getId() != null) checkCombo("acceOidAcce" , acceOidAcce.getId().toString());
		es.indra.belcorp.mso.SegPerioCorpoData periOidPeri = craPerio.getPeriOidPeri();
		if(periOidPeri != null && periOidPeri.getId() != null) checkCombo("periOidPeri" , periOidPeri.getId().toString());
		asignar("TEXT", "fecInic", FormatUtils.formatObject(craPerio.getFecInic(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		asignar("TEXT", "fecFina", FormatUtils.formatObject(craPerio.getFecFina(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		asignar("TEXT", "valEsta", FormatUtils.formatObject(craPerio.getValEsta(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valNombPeri", FormatUtils.formatObject(craPerio.getValNombPeri(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPeriCort", FormatUtils.formatObject(craPerio.getIndPeriCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPeriCruc", FormatUtils.formatObject(craPerio.getIndPeriCruc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
					asignarAtributo("COMBO", "marcOidMarc", "disabled", "S");
									asignarAtributo("COMBO", "canaOidCana_tipeOidTipoPeri", "disabled", "S");

					asignarAtributo("COMBO", "canaOidCana", "disabled", "S");
									asignarAtributo("COMBO", "paisOidPais_moneOidMoneAlt", "disabled", "S");

									asignarAtributo("COMBO", "paisOidPais_moneOidMone", "disabled", "S");

									asignarAtributo("COMBO", "paisOidPais_fopaOidFormPago", "disabled", "S");

					asignarAtributo("COMBO", "paisOidPais", "disabled", "S");
									asignarAtributo("COMBO", "acceOidAcce_canaOidCana", "disabled", "S");

					asignarAtributo("COMBO", "acceOidAcce", "disabled", "S");
									asignarAtributo("COMBO", "periOidPeri_tipeOidTipoPeri", "disabled", "S");

					asignarAtributo("COMBO", "periOidPeri", "disabled", "S");asignarAtributo("TEXT", "fecInic", "disabled", "S");
		asignarAtributo("TEXT", "fecFina", "disabled", "S");
		asignarAtributo("TEXT", "valEsta", "disabled", "S");
		asignarAtributo("TEXT", "valNombPeri", "disabled", "S");
		asignarAtributo("TEXT", "indPeriCort", "disabled", "S");
		asignarAtributo("TEXT", "indPeriCruc", "disabled", "S");
		
		
	
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
		asignarAtributo("COMBO", "marcOidMarc", "req", "S");
		asignarAtributo("COMBO", "canaOidCana", "req", "S");
		asignarAtributo("COMBO", "paisOidPais", "req", "S");
		asignarAtributo("COMBO", "periOidPeri", "req", "S");
		asignarAtributo("TEXT", "fecInic", "req", "S");
		asignarAtributo("TEXT", "fecFina", "req", "S");
		asignarAtributo("TEXT", "valEsta", "req", "S");
		asignarAtributo("TEXT", "valNombPeri", "req", "S");
		
		
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
		
		
		
		
		
		asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
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
		
		
		
		
		
		asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
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
		
		
		
		
		
		asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
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
		
		
		
		
		
		asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
		asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
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
		conectorAction("CraPerioLPStartUp");
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
		//asignarAtributo("FORMULARIO", "craPerioFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "marcOidMarc", "req", "S");
				asignarAtributo("COMBO", "canaOidCana", "req", "S");
				asignarAtributo("COMBO", "paisOidPais", "req", "S");
				asignarAtributo("COMBO", "periOidPeri", "req", "S");
				asignarAtributo("TEXT", "fecInic", "req", "S");
				asignarAtributo("TEXT", "fecFina", "req", "S");
				asignarAtributo("TEXT", "valEsta", "req", "S");
				asignarAtributo("TEXT", "valNombPeri", "req", "S");
		
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
		
			
			
			
			
			
			asignarAtributo("TEXT", "fecInic", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
			asignarAtributo("TEXT", "fecFina", "validacion", "mensaje = ValidaFechaMMG(cdos_trim(valor), '" + datePattern + "');");
			asignarAtributo("TEXT", "valEsta", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "valNombPeri", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			asignarAtributo("TEXT", "indPeriCort", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indPeriCruc", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CraPerio");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CraPerioData craPerioQuery= new CraPerioData();
		craPerioQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CraPerioData  datosResult = (CraPerioData)getSingleObject(BUSINESSID_QUERY, craPerioQuery, 
			craPerioQuery.clone(), "craPerio");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CraPerioData craPerio = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.SegMarcaData marcOidMarc = craPerio.getMarcOidMarc();
		if(marcOidMarc != null && marcOidMarc.getId() != null) checkCombo("marcOidMarc" , marcOidMarc.getId().toString());
		es.indra.belcorp.mso.SegCanalData canaOidCana = craPerio.getCanaOidCana();
		if(canaOidCana != null && canaOidCana.getId() != null) checkCombo("canaOidCana" , canaOidCana.getId().toString());
		es.indra.belcorp.mso.SegPaisData paisOidPais = craPerio.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		es.indra.belcorp.mso.SegAccesData acceOidAcce = craPerio.getAcceOidAcce();
		if(acceOidAcce != null && acceOidAcce.getId() != null) checkCombo("acceOidAcce" , acceOidAcce.getId().toString());
		es.indra.belcorp.mso.SegPerioCorpoData periOidPeri = craPerio.getPeriOidPeri();
		if(periOidPeri != null && periOidPeri.getId() != null) checkCombo("periOidPeri" , periOidPeri.getId().toString());
		asignar("TEXT", "fecInic", FormatUtils.formatObject(craPerio.getFecInic(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		asignar("TEXT", "fecFina", FormatUtils.formatObject(craPerio.getFecFina(), 
			 UtilidadesSession.getFormatoFecha(this), decimalFormatSymbols));
		asignar("TEXT", "valEsta", FormatUtils.formatObject(craPerio.getValEsta(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valNombPeri", FormatUtils.formatObject(craPerio.getValNombPeri(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPeriCort", FormatUtils.formatObject(craPerio.getIndPeriCort(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indPeriCruc", FormatUtils.formatObject(craPerio.getIndPeriCruc(), 
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
		//asignar("VAR","timestamp",Long.toString(craPerio.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","marcOidMarc", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","marcOidMarc", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","canaOidCana_tipeOidTipoPeri", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","canaOidCana_tipeOidTipoPeri", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","canaOidCana", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","canaOidCana", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais_moneOidMoneAlt", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais_moneOidMoneAlt", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais_moneOidMone", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais_moneOidMone", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais_fopaOidFormPago", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais_fopaOidFormPago", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","acceOidAcce_canaOidCana", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","acceOidAcce_canaOidCana", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","acceOidAcce", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","acceOidAcce", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","periOidPeri_tipeOidTipoPeri", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","periOidPeri_tipeOidTipoPeri", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
					asignarAtributo("COMBO","periOidPeri", "ontab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
					asignarAtributo("COMBO","periOidPeri", "onshtab", "ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "fecInic", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "fecInic", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "fecFina", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "fecFina", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valEsta", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valEsta", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "valNombPeri", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "valNombPeri", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indPeriCort", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indPeriCort", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
				asignarAtributo("AREATEXTO", "indPeriCruc", "ontab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, true)");
				asignarAtributo("AREATEXTO", "indPeriCruc", "onshtab","ejecutarAccionFocoModificacion(\"craPerioFrm\",0, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","craPerioTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","craPerioTrButtons");

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
				
				traza("MMG: el atributo es marcOidMarc...");		
				
				traza("MMG: el atributo es canaOidCana...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es acceOidAcce...");		
				
				traza("MMG: el atributo es periOidPeri...");		
				
				traza("MMG: el atributo es fecInic...");		
				
				traza("MMG: el atributo es fecFina...");		
				
				traza("MMG: el atributo es valEsta...");		
				
				traza("MMG: el atributo es valNombPeri...");		
				
				traza("MMG: el atributo es indPeriCort...");		
				
				traza("MMG: el atributo es indPeriCruc...");		
				
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
		asignarAtributo("CAPA","craPerioFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","craPerioListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","craPerioListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(CraPerioData craPerio) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMarcaData marcOidMarc = new SegMarcaData();
		
						asignarComboResultados(BUSINESSID_MARCOIDMARC_QUERY,MARCOIDMARC_COMBO_CONNECTOR, 
			marcOidMarc, marcOidMarc.clone(), "segMarca", "marcOidMarc", "result_ROWSET" );
		if(craPerio != null && craPerio.getMarcOidMarc() != null){
				checkCombo("marcOidMarc" , craPerio.getMarcOidMarc().getId().toString());
			}
		String marcOidMarcDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegMarca");
		if(marcOidMarcDefaultValue != null && !marcOidMarcDefaultValue.trim().equals("")){
			checkCombo("marcOidMarc", marcOidMarcDefaultValue);
			checkedCombos.put("marcOidMarc",marcOidMarcDefaultValue);
			cascadeComboLoad(checkedCombos, "marcOidMarc");
		}						 
		SegTipoPerioData canaOidCana_tipeOidTipoPeri = new SegTipoPerioData();
		
						asignarComboResultados(BUSINESSID_CANAOIDCANA_TIPEOIDTIPOPERI_QUERY,CANAOIDCANA_TIPEOIDTIPOPERI_COMBO_CONNECTOR, 
			canaOidCana_tipeOidTipoPeri, canaOidCana_tipeOidTipoPeri.clone(), "segTipoPerio", "canaOidCana_tipeOidTipoPeri", "result_ROWSET" );
		if(craPerio != null && craPerio.getCanaOidCana().getTipeOidTipoPeri() != null){
				checkCombo("canaOidCana_tipeOidTipoPeri" , craPerio.getCanaOidCana().getTipeOidTipoPeri().getId().toString());
			}
		SegMonedData paisOidPais_moneOidMoneAlt = new SegMonedData();
		SegMonedData paisOidPais_moneOidMone = new SegMonedData();
		BelFormaPagoTaponData paisOidPais_fopaOidFormPago = new BelFormaPagoTaponData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, 
			paisOidPais_moneOidMoneAlt, paisOidPais_moneOidMoneAlt.clone(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		if(craPerio != null && craPerio.getPaisOidPais().getMoneOidMoneAlt() != null){
				checkCombo("paisOidPais_moneOidMoneAlt" , craPerio.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, 
			paisOidPais_moneOidMone, paisOidPais_moneOidMone.clone(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		if(craPerio != null && craPerio.getPaisOidPais().getMoneOidMone() != null){
				checkCombo("paisOidPais_moneOidMone" , craPerio.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			paisOidPais_fopaOidFormPago, paisOidPais_fopaOidFormPago.clone(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		if(craPerio != null && craPerio.getPaisOidPais().getFopaOidFormPago() != null){
				checkCombo("paisOidPais_fopaOidFormPago" , craPerio.getPaisOidPais().getFopaOidFormPago().getId().toString());
			}
		SegCanalViewData acceOidAcce_canaOidCana = new SegCanalViewData();
		
						asignarComboResultados(BUSINESSID_ACCEOIDACCE_CANAOIDCANA_QUERY,ACCEOIDACCE_CANAOIDCANA_COMBO_CONNECTOR, 
			acceOidAcce_canaOidCana, acceOidAcce_canaOidCana.clone(), "segCanalView", "acceOidAcce_canaOidCana", "result_ROWSET" );
		if(craPerio != null && craPerio.getAcceOidAcce().getCanaOidCana() != null){
				checkCombo("acceOidAcce_canaOidCana" , craPerio.getAcceOidAcce().getCanaOidCana().getId().toString());
			}
		String acceOidAcce_canaOidCanaDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanalView");
		if(acceOidAcce_canaOidCanaDefaultValue != null && !acceOidAcce_canaOidCanaDefaultValue.trim().equals("")){
			checkCombo("acceOidAcce_canaOidCana", acceOidAcce_canaOidCanaDefaultValue);
			checkedCombos.put("acceOidAcce_canaOidCana",acceOidAcce_canaOidCanaDefaultValue);
			cascadeComboLoad(checkedCombos, "acceOidAcce_canaOidCana");
		}						 
		SegTipoPerioData periOidPeri_tipeOidTipoPeri = new SegTipoPerioData();
		
						asignarComboResultados(BUSINESSID_PERIOIDPERI_TIPEOIDTIPOPERI_QUERY,PERIOIDPERI_TIPEOIDTIPOPERI_COMBO_CONNECTOR, 
			periOidPeri_tipeOidTipoPeri, periOidPeri_tipeOidTipoPeri.clone(), "segTipoPerio", "periOidPeri_tipeOidTipoPeri", "result_ROWSET" );
		if(craPerio != null && craPerio.getPeriOidPeri().getTipeOidTipoPeri() != null){
				checkCombo("periOidPeri_tipeOidTipoPeri" , craPerio.getPeriOidPeri().getTipeOidTipoPeri().getId().toString());
			}
		
	}
	
	/**
	* Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	*/
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) throws Exception{
		
						if(comboName.trim().equals("canaOidCana_tipeOidTipoPeri") ){
			String canaOidCana_tipeOidTipoPeriDefaultValue = (String)checkedCombos.get("canaOidCana_tipeOidTipoPeri");
			if(canaOidCana_tipeOidTipoPeriDefaultValue != null){
				SegCanalData canaOidCana= new SegCanalData();
				es.indra.belcorp.mso.SegTipoPerioData canaOidCanaTipeOidTipoPeri = new es.indra.belcorp.mso.SegTipoPerioData();
				canaOidCanaTipeOidTipoPeri.setId(new Long(canaOidCana_tipeOidTipoPeriDefaultValue ));
				canaOidCana.setTipeOidTipoPeri(canaOidCanaTipeOidTipoPeri);
				asignarComboResultados(BUSINESSID_CANAOIDCANA_QUERY,CANAOIDCANA_COMBO_CONNECTOR, 
					canaOidCana, canaOidCana.clone(), "segCanal", "canaOidCana", "result_ROWSET",true );
				String canaOidCanaDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanal");
				if(canaOidCanaDefaultValue != null && !canaOidCanaDefaultValue.trim().equals("")){
					checkCombo("canaOidCana",canaOidCanaDefaultValue);
					checkedCombos.put("canaOidCana",canaOidCanaDefaultValue);
					cascadeComboLoad(checkedCombos, "canaOidCana");
				}
			}
		}

						if(comboName.trim().equals("paisOidPais_moneOidMoneAlt")  || comboName.trim().equals("paisOidPais_moneOidMone")  || comboName.trim().equals("paisOidPais_fopaOidFormPago") ){
			String paisOidPais_moneOidMoneAltDefaultValue = (String)checkedCombos.get("paisOidPais_moneOidMoneAlt");
			String paisOidPais_moneOidMoneDefaultValue = (String)checkedCombos.get("paisOidPais_moneOidMone");
			String paisOidPais_fopaOidFormPagoDefaultValue = (String)checkedCombos.get("paisOidPais_fopaOidFormPago");
			if(paisOidPais_moneOidMoneAltDefaultValue != null &&paisOidPais_moneOidMoneDefaultValue != null &&paisOidPais_fopaOidFormPagoDefaultValue != null){
				SegPaisData paisOidPais= new SegPaisData();
				es.indra.belcorp.mso.SegMonedData paisOidPaisMoneOidMoneAlt = new es.indra.belcorp.mso.SegMonedData();
				paisOidPaisMoneOidMoneAlt.setId(new Long(paisOidPais_moneOidMoneAltDefaultValue ));
				paisOidPais.setMoneOidMoneAlt(paisOidPaisMoneOidMoneAlt);
				es.indra.belcorp.mso.SegMonedData paisOidPaisMoneOidMone = new es.indra.belcorp.mso.SegMonedData();
				paisOidPaisMoneOidMone.setId(new Long(paisOidPais_moneOidMoneDefaultValue ));
				paisOidPais.setMoneOidMone(paisOidPaisMoneOidMone);
				es.indra.belcorp.mso.BelFormaPagoTaponData paisOidPaisFopaOidFormPago = new es.indra.belcorp.mso.BelFormaPagoTaponData();
				paisOidPaisFopaOidFormPago.setId(new Long(paisOidPais_fopaOidFormPagoDefaultValue ));
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

						if(comboName.trim().equals("acceOidAcce_canaOidCana") ){
			String acceOidAcce_canaOidCanaDefaultValue = (String)checkedCombos.get("acceOidAcce_canaOidCana");
			if(acceOidAcce_canaOidCanaDefaultValue != null){
				SegAccesData acceOidAcce= new SegAccesData();
				es.indra.belcorp.mso.SegCanalViewData acceOidAcceCanaOidCana = new es.indra.belcorp.mso.SegCanalViewData();
				acceOidAcceCanaOidCana.setId(new Long(acceOidAcce_canaOidCanaDefaultValue ));
				acceOidAcce.setCanaOidCana(acceOidAcceCanaOidCana);
				asignarComboResultados(BUSINESSID_ACCEOIDACCE_QUERY,ACCEOIDACCE_COMBO_CONNECTOR, 
					acceOidAcce, acceOidAcce.clone(), "segAcces", "acceOidAcce", "result_ROWSET",true );
				String acceOidAcceDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegAcces");
				if(acceOidAcceDefaultValue != null && !acceOidAcceDefaultValue.trim().equals("")){
					checkCombo("acceOidAcce",acceOidAcceDefaultValue);
					checkedCombos.put("acceOidAcce",acceOidAcceDefaultValue);
					cascadeComboLoad(checkedCombos, "acceOidAcce");
				}
			}
		}

						if(comboName.trim().equals("periOidPeri_tipeOidTipoPeri") ){
			String periOidPeri_tipeOidTipoPeriDefaultValue = (String)checkedCombos.get("periOidPeri_tipeOidTipoPeri");
			if(periOidPeri_tipeOidTipoPeriDefaultValue != null){
				SegPerioCorpoData periOidPeri= new SegPerioCorpoData();
				es.indra.belcorp.mso.SegTipoPerioData periOidPeriTipeOidTipoPeri = new es.indra.belcorp.mso.SegTipoPerioData();
				periOidPeriTipeOidTipoPeri.setId(new Long(periOidPeri_tipeOidTipoPeriDefaultValue ));
				periOidPeri.setTipeOidTipoPeri(periOidPeriTipeOidTipoPeri);
				asignarComboResultados(BUSINESSID_PERIOIDPERI_QUERY,PERIOIDPERI_COMBO_CONNECTOR, 
					periOidPeri, periOidPeri.clone(), "segPerioCorpo", "periOidPeri", "result_ROWSET",false );
			}
		}

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param craPerio La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CraPerioData craPerio) 
		throws Exception{
		
						if(craPerio.getCanaOidCana() != null){
			
						SegCanalData canaOidCana = new SegCanalData();
			canaOidCana.setTipeOidTipoPeri(craPerio.getCanaOidCana().getTipeOidTipoPeri());
			asignarComboResultados(BUSINESSID_CANAOIDCANA_QUERY,CANAOIDCANA_COMBO_CONNECTOR, canaOidCana, canaOidCana.clone(), "segCanal", "canaOidCana", "result_ROWSET");
			checkCombo("canaOidCana" , craPerio.getCanaOidCana().getId().toString());
			
						}
		
						if(craPerio.getPaisOidPais() != null){
			
						SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMoneAlt(craPerio.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setMoneOidMone(craPerio.getPaisOidPais().getMoneOidMone());
			paisOidPais.setFopaOidFormPago(craPerio.getPaisOidPais().getFopaOidFormPago());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , craPerio.getPaisOidPais().getId().toString());
			
						}
		
						if(craPerio.getAcceOidAcce() != null){
			
						SegAccesData acceOidAcce = new SegAccesData();
			acceOidAcce.setCanaOidCana(craPerio.getAcceOidAcce().getCanaOidCana());
			asignarComboResultados(BUSINESSID_ACCEOIDACCE_QUERY,ACCEOIDACCE_COMBO_CONNECTOR, acceOidAcce, acceOidAcce.clone(), "segAcces", "acceOidAcce", "result_ROWSET");
			checkCombo("acceOidAcce" , craPerio.getAcceOidAcce().getId().toString());
			
						}
		
						if(craPerio.getPeriOidPeri() != null){
			
						SegPerioCorpoData periOidPeri = new SegPerioCorpoData();
			periOidPeri.setTipeOidTipoPeri(craPerio.getPeriOidPeri().getTipeOidTipoPeri());
			asignarComboResultados(BUSINESSID_PERIOIDPERI_QUERY,PERIOIDPERI_COMBO_CONNECTOR, periOidPeri, periOidPeri.clone(), "segPerioCorpo", "periOidPeri", "result_ROWSET");
			checkCombo("periOidPeri" , craPerio.getPeriOidPeri().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CraPerioData craPerio = 
			(CraPerioData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(craPerio.getMarcOidMarc() != null){
			craPerio.setMarcOidMarc((es.indra.belcorp.mso.SegMarcaData)
			getSingleObject(BUSINESSID_MARCOIDMARC_QUERY, 
			craPerio.getMarcOidMarc(),
			craPerio.getMarcOidMarc().clone(),
			"segMarca"));
		}
		if(craPerio.getCanaOidCana() != null){
			craPerio.setCanaOidCana((es.indra.belcorp.mso.SegCanalData)
			getSingleObject(BUSINESSID_CANAOIDCANA_QUERY, 
			craPerio.getCanaOidCana(),
			craPerio.getCanaOidCana().clone(),
			"segCanal"));
		}
		if(craPerio.getPaisOidPais() != null){
			craPerio.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			craPerio.getPaisOidPais(),
			craPerio.getPaisOidPais().clone(),
			"segPais"));
		}
		if(craPerio.getAcceOidAcce() != null){
			craPerio.setAcceOidAcce((es.indra.belcorp.mso.SegAccesData)
			getSingleObject(BUSINESSID_ACCEOIDACCE_QUERY, 
			craPerio.getAcceOidAcce(),
			craPerio.getAcceOidAcce().clone(),
			"segAcces"));
		}
		if(craPerio.getPeriOidPeri() != null){
			craPerio.setPeriOidPeri((es.indra.belcorp.mso.SegPerioCorpoData)
			getSingleObject(BUSINESSID_PERIOIDPERI_QUERY, 
			craPerio.getPeriOidPeri(),
			craPerio.getPeriOidPeri().clone(),
			"segPerioCorpo"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(craPerio);
		loadLeafDependenceCombos(craPerio);
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





