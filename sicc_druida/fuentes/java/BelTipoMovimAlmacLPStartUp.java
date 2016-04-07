/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacLPStartUp.java,v 1.1 2009/12/03 18:42:23 pecbazalar Exp $
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
public class BelTipoMovimAlmacLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 483;
	public static final short CREATEFORM_SIZE = 477;
	public static final short UPDATEFORM_SIZE = 477;
	public static final short VIEWFORM_SIZE = 477;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimAlmacQueryFromToUserPage";
	
	
				public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY ="MMGSegMonedQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY ="MMGSegMonedQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY ="MMGBelFormaPagoTaponQueryFromToUser";
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisQueryFromToUser";
				public static final String PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR = "SegMonedConectorCombo";
	
				public static final String PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR = "BelFormaPagoTaponConectorCombo";
	
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisConectorCombo";
	
				public static final String BUSINESSID_ESMEOIDESTAMERC1_QUERY ="MMGBelEstadMercaQueryFromToUser";
				public static final String ESMEOIDESTAMERC1_COMBO_CONNECTOR = "BelEstadMercaConectorCombo";
	
				public static final String BUSINESSID_ESMEOIDESTAMERC2_QUERY ="MMGBelEstadMercaQueryFromToUser";
				public static final String ESMEOIDESTAMERC2_COMBO_CONNECTOR = "BelEstadMercaConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	
	
	// Definicion del constructor
	public BelTipoMovimAlmacLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("BelTipoMovimAlmacPage");
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
			buildJsPageSize("BelTipoMovimAlmac");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "BelTipoMovimAlmacPage", "cod", "BelTipoMovimAlmac." + accion + ".label");
			
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
			limpiarBotoneraLista("belTipoMovimAlmac", accion);
			
			
			
			
			
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
		
		asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "belTipoMovimAlmacLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "BelTipoMovimAlmacPage", "onblur", "window.focus();");
		
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
		conectorAction("BelTipoMovimAlmacLPStartUp");
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
		BelTipoMovimAlmacData belTipoMovimAlmacQuery= new BelTipoMovimAlmacData();
		belTipoMovimAlmacQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		BelTipoMovimAlmacData datosResult = (BelTipoMovimAlmacData)getSingleObject(BUSINESSID_QUERY, belTipoMovimAlmacQuery, 
			belTipoMovimAlmacQuery.clone(), "belTipoMovimAlmac");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		BelTipoMovimAlmacData belTipoMovimAlmac = datosResult;
		es.indra.belcorp.mso.SegPaisData paisOidPais = belTipoMovimAlmac.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codTipoMovi", FormatUtils.formatObject(belTipoMovimAlmac.getCodTipoMovi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codMoviSap", FormatUtils.formatObject(belTipoMovimAlmac.getCodMoviSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indMoviEntrAlma", FormatUtils.formatObject(belTipoMovimAlmac.getIndMoviEntrAlma(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indMantMovi", FormatUtils.formatObject(belTipoMovimAlmac.getIndMantMovi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indSap", FormatUtils.formatObject(belTipoMovimAlmac.getIndSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc1 = belTipoMovimAlmac.getEsmeOidEstaMerc1();
		if(esmeOidEstaMerc1 != null && esmeOidEstaMerc1.getId() != null) checkCombo("esmeOidEstaMerc1" , esmeOidEstaMerc1.getId().toString());
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc2 = belTipoMovimAlmac.getEsmeOidEstaMerc2();
		if(esmeOidEstaMerc2 != null && esmeOidEstaMerc2.getId() != null) checkCombo("esmeOidEstaMerc2" , esmeOidEstaMerc2.getId().toString());
		asignar("TEXT", "codOper1", FormatUtils.formatObject(belTipoMovimAlmac.getCodOper1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codOper2", FormatUtils.formatObject(belTipoMovimAlmac.getCodOper2(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		
									asignarAtributo("COMBO", "paisOidPais_moneOidMoneAlt", "disabled", "S");

									asignarAtributo("COMBO", "paisOidPais_moneOidMone", "disabled", "S");

									asignarAtributo("COMBO", "paisOidPais_fopaOidFormPago", "disabled", "S");

					asignarAtributo("COMBO", "paisOidPais", "disabled", "S");asignarAtributo("TEXT", "codTipoMovi", "disabled", "S");
		asignarAtributo("TEXT", "codMoviSap", "disabled", "S");
		asignarAtributo("TEXT", "indMoviEntrAlma", "disabled", "S");
		asignarAtributo("TEXT", "indMantMovi", "disabled", "S");
		asignarAtributo("TEXT", "indSap", "disabled", "S");
		
					asignarAtributo("COMBO", "esmeOidEstaMerc1", "disabled", "S");
					asignarAtributo("COMBO", "esmeOidEstaMerc2", "disabled", "S");asignarAtributo("TEXT", "codOper1", "disabled", "S");
		asignarAtributo("TEXT", "codOper2", "disabled", "S");
		
		
	
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
		asignarAtributo("TEXT", "codTipoMovi", "req", "S");
		asignarAtributo("TEXT", "indMoviEntrAlma", "req", "S");
		asignarAtributo("TEXT", "indMantMovi", "req", "S");
		asignarAtributo("TEXT", "indSap", "req", "S");
		
		
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
		
		asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		
		
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
		
		asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		
		
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
		
		asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		
		
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
		
		asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
		asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
		asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
		
		
		asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
		
		
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
		conectorAction("BelTipoMovimAlmacLPStartUp");
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
		//asignarAtributo("FORMULARIO", "belTipoMovimAlmacFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("COMBO", "paisOidPais", "req", "S");
				asignarAtributo("TEXT", "codTipoMovi", "req", "S");
				asignarAtributo("TEXT", "indMoviEntrAlma", "req", "S");
				asignarAtributo("TEXT", "indMantMovi", "req", "S");
				asignarAtributo("TEXT", "indSap", "req", "S");
		
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
		
			
			asignarAtributo("TEXT", "codTipoMovi", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 3);");
			asignarAtributo("TEXT", "codMoviSap", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 18);");
			asignarAtributo("TEXT", "indMoviEntrAlma", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indMantMovi", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			asignarAtributo("TEXT", "indSap", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 1, 0, 9);");
			
			
			asignarAtributo("TEXT", "codOper1", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");
			asignarAtributo("TEXT", "codOper2", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 1);");

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando BelTipoMovimAlmac");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		BelTipoMovimAlmacData belTipoMovimAlmacQuery= new BelTipoMovimAlmacData();
		belTipoMovimAlmacQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		BelTipoMovimAlmacData  datosResult = (BelTipoMovimAlmacData)getSingleObject(BUSINESSID_QUERY, belTipoMovimAlmacQuery, 
			belTipoMovimAlmacQuery.clone(), "belTipoMovimAlmac");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		BelTipoMovimAlmacData belTipoMovimAlmac = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		es.indra.belcorp.mso.SegPaisData paisOidPais = belTipoMovimAlmac.getPaisOidPais();
		if(paisOidPais != null && paisOidPais.getId() != null) checkCombo("paisOidPais" , paisOidPais.getId().toString());
		asignar("TEXT", "codTipoMovi", FormatUtils.formatObject(belTipoMovimAlmac.getCodTipoMovi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codMoviSap", FormatUtils.formatObject(belTipoMovimAlmac.getCodMoviSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indMoviEntrAlma", FormatUtils.formatObject(belTipoMovimAlmac.getIndMoviEntrAlma(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indMantMovi", FormatUtils.formatObject(belTipoMovimAlmac.getIndMantMovi(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "indSap", FormatUtils.formatObject(belTipoMovimAlmac.getIndSap(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc1 = belTipoMovimAlmac.getEsmeOidEstaMerc1();
		if(esmeOidEstaMerc1 != null && esmeOidEstaMerc1.getId() != null) checkCombo("esmeOidEstaMerc1" , esmeOidEstaMerc1.getId().toString());
		es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc2 = belTipoMovimAlmac.getEsmeOidEstaMerc2();
		if(esmeOidEstaMerc2 != null && esmeOidEstaMerc2.getId() != null) checkCombo("esmeOidEstaMerc2" , esmeOidEstaMerc2.getId().toString());
		asignar("TEXT", "codOper1", FormatUtils.formatObject(belTipoMovimAlmac.getCodOper1(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "codOper2", FormatUtils.formatObject(belTipoMovimAlmac.getCodOper2(), 
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
		//asignar("VAR","timestamp",Long.toString(belTipoMovimAlmac.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",1, false)");
					asignarAtributo("COMBO","paisOidPais_moneOidMoneAlt", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais_moneOidMoneAlt", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, false)");
					asignarAtributo("COMBO","paisOidPais_moneOidMone", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais_moneOidMone", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, false)");
					asignarAtributo("COMBO","paisOidPais_fopaOidFormPago", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais_fopaOidFormPago", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",2, false)");
				asignarAtributo("AREATEXTO", "codTipoMovi", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",3, true)");
				asignarAtributo("AREATEXTO", "codTipoMovi", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",3, false)");
				asignarAtributo("AREATEXTO", "codMoviSap", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",4, true)");
				asignarAtributo("AREATEXTO", "codMoviSap", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",4, false)");
				asignarAtributo("AREATEXTO", "indMoviEntrAlma", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",5, true)");
				asignarAtributo("AREATEXTO", "indMoviEntrAlma", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",5, false)");
				asignarAtributo("AREATEXTO", "indMantMovi", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",6, true)");
				asignarAtributo("AREATEXTO", "indMantMovi", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",6, false)");
				asignarAtributo("AREATEXTO", "indSap", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",7, true)");
				asignarAtributo("AREATEXTO", "indSap", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",7, false)");
					asignarAtributo("COMBO","esmeOidEstaMerc1", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",8, true)");
					asignarAtributo("COMBO","esmeOidEstaMerc1", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",8, false)");
					asignarAtributo("COMBO","esmeOidEstaMerc2", "ontab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",9, true)");
					asignarAtributo("COMBO","esmeOidEstaMerc2", "onshtab", "ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",9, false)");
				asignarAtributo("AREATEXTO", "codOper1", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",10, true)");
				asignarAtributo("AREATEXTO", "codOper1", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",10, false)");
				asignarAtributo("AREATEXTO", "codOper2", "ontab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",11, true)");
				asignarAtributo("AREATEXTO", "codOper2", "onshtab","ejecutarAccionFocoModificacion(\"belTipoMovimAlmacFrm\",11, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","belTipoMovimAlmacTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","belTipoMovimAlmacTrButtons");

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
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es codTipoMovi...");		
				
				traza("MMG: el atributo es codMoviSap...");		
				
				traza("MMG: el atributo es indMoviEntrAlma...");		
				
				traza("MMG: el atributo es indMantMovi...");		
				
				traza("MMG: el atributo es indSap...");		
				
				traza("MMG: el atributo es esmeOidEstaMerc1...");		
				
				traza("MMG: el atributo es esmeOidEstaMerc2...");		
				
				traza("MMG: el atributo es codOper1...");		
				
				traza("MMG: el atributo es codOper2...");		
				
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
		asignarAtributo("CAPA","belTipoMovimAlmacFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","belTipoMovimAlmacListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","belTipoMovimAlmacListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(BelTipoMovimAlmacData belTipoMovimAlmac) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMonedData paisOidPais_moneOidMoneAlt = new SegMonedData();
		SegMonedData paisOidPais_moneOidMone = new SegMonedData();
		BelFormaPagoTaponData paisOidPais_fopaOidFormPago = new BelFormaPagoTaponData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONEALT_QUERY,PAISOIDPAIS_MONEOIDMONEALT_COMBO_CONNECTOR, 
			paisOidPais_moneOidMoneAlt, paisOidPais_moneOidMoneAlt.clone(), "segMoned", "paisOidPais_moneOidMoneAlt", "result_ROWSET" );
		if(belTipoMovimAlmac != null && belTipoMovimAlmac.getPaisOidPais().getMoneOidMoneAlt() != null){
				checkCombo("paisOidPais_moneOidMoneAlt" , belTipoMovimAlmac.getPaisOidPais().getMoneOidMoneAlt().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_MONEOIDMONE_QUERY,PAISOIDPAIS_MONEOIDMONE_COMBO_CONNECTOR, 
			paisOidPais_moneOidMone, paisOidPais_moneOidMone.clone(), "segMoned", "paisOidPais_moneOidMone", "result_ROWSET" );
		if(belTipoMovimAlmac != null && belTipoMovimAlmac.getPaisOidPais().getMoneOidMone() != null){
				checkCombo("paisOidPais_moneOidMone" , belTipoMovimAlmac.getPaisOidPais().getMoneOidMone().getId().toString());
			}
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_FOPAOIDFORMPAGO_QUERY,PAISOIDPAIS_FOPAOIDFORMPAGO_COMBO_CONNECTOR, 
			paisOidPais_fopaOidFormPago, paisOidPais_fopaOidFormPago.clone(), "belFormaPagoTapon", "paisOidPais_fopaOidFormPago", "result_ROWSET" );
		if(belTipoMovimAlmac != null && belTipoMovimAlmac.getPaisOidPais().getFopaOidFormPago() != null){
				checkCombo("paisOidPais_fopaOidFormPago" , belTipoMovimAlmac.getPaisOidPais().getFopaOidFormPago().getId().toString());
			}
		BelEstadMercaData esmeOidEstaMerc1 = new BelEstadMercaData();
		
						asignarComboResultados(BUSINESSID_ESMEOIDESTAMERC1_QUERY,ESMEOIDESTAMERC1_COMBO_CONNECTOR, 
			esmeOidEstaMerc1, esmeOidEstaMerc1.clone(), "belEstadMerca", "esmeOidEstaMerc1", "result_ROWSET" );
		if(belTipoMovimAlmac != null && belTipoMovimAlmac.getEsmeOidEstaMerc1() != null){
				checkCombo("esmeOidEstaMerc1" , belTipoMovimAlmac.getEsmeOidEstaMerc1().getId().toString());
			}
		BelEstadMercaData esmeOidEstaMerc2 = new BelEstadMercaData();
		
						asignarComboResultados(BUSINESSID_ESMEOIDESTAMERC2_QUERY,ESMEOIDESTAMERC2_COMBO_CONNECTOR, 
			esmeOidEstaMerc2, esmeOidEstaMerc2.clone(), "belEstadMerca", "esmeOidEstaMerc2", "result_ROWSET" );
		if(belTipoMovimAlmac != null && belTipoMovimAlmac.getEsmeOidEstaMerc2() != null){
				checkCombo("esmeOidEstaMerc2" , belTipoMovimAlmac.getEsmeOidEstaMerc2().getId().toString());
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

	}
	
	/**
	* Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	* se realiza en función de los datos de un mso del mantenimiento. 
	* @param belTipoMovimAlmac La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(BelTipoMovimAlmacData belTipoMovimAlmac) 
		throws Exception{
		
						if(belTipoMovimAlmac.getPaisOidPais() != null){
			
						SegPaisData paisOidPais = new SegPaisData();
			paisOidPais.setMoneOidMoneAlt(belTipoMovimAlmac.getPaisOidPais().getMoneOidMoneAlt());
			paisOidPais.setMoneOidMone(belTipoMovimAlmac.getPaisOidPais().getMoneOidMone());
			paisOidPais.setFopaOidFormPago(belTipoMovimAlmac.getPaisOidPais().getFopaOidFormPago());
			asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, paisOidPais, paisOidPais.clone(), "segPais", "paisOidPais", "result_ROWSET");
			checkCombo("paisOidPais" , belTipoMovimAlmac.getPaisOidPais().getId().toString());
			
						}
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		BelTipoMovimAlmacData belTipoMovimAlmac = 
			(BelTipoMovimAlmacData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(belTipoMovimAlmac.getPaisOidPais() != null){
			belTipoMovimAlmac.setPaisOidPais((es.indra.belcorp.mso.SegPaisData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			belTipoMovimAlmac.getPaisOidPais(),
			belTipoMovimAlmac.getPaisOidPais().clone(),
			"segPais"));
		}
		if(belTipoMovimAlmac.getEsmeOidEstaMerc1() != null){
			belTipoMovimAlmac.setEsmeOidEstaMerc1((es.indra.belcorp.mso.BelEstadMercaData)
			getSingleObject(BUSINESSID_ESMEOIDESTAMERC1_QUERY, 
			belTipoMovimAlmac.getEsmeOidEstaMerc1(),
			belTipoMovimAlmac.getEsmeOidEstaMerc1().clone(),
			"belEstadMerca"));
		}
		if(belTipoMovimAlmac.getEsmeOidEstaMerc2() != null){
			belTipoMovimAlmac.setEsmeOidEstaMerc2((es.indra.belcorp.mso.BelEstadMercaData)
			getSingleObject(BUSINESSID_ESMEOIDESTAMERC2_QUERY, 
			belTipoMovimAlmac.getEsmeOidEstaMerc2(),
			belTipoMovimAlmac.getEsmeOidEstaMerc2().clone(),
			"belEstadMerca"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(belTipoMovimAlmac);
		loadLeafDependenceCombos(belTipoMovimAlmac);
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





