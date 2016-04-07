/*
    INDRA/CAR/mmg
    $Id: IntParamContaFactuLPStartUp.java,v 1.1 2009/12/03 18:38:01 pecbazalar Exp $
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
public class IntParamContaFactuLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 525;
	public static final short CREATEFORM_SIZE = 531;
	public static final short UPDATEFORM_SIZE = 531;
	public static final short VIEWFORM_SIZE = 531;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGIntParamContaFactuQueryFromToUserPage";
	
	
				public static final String BUSINESSID_MAPROIDMARCPROD_QUERY ="MMGSegMarcaProduQueryFromToUser";
				public static final String MAPROIDMARCPROD_COMBO_CONNECTOR = "SegMarcaProduConectorCombo";
	
				public static final String BUSINESSID_NEGOOIDNEGO_QUERY ="MMGMaeNegocViewQueryFromToUser";
				public static final String NEGOOIDNEGO_COMBO_CONNECTOR = "MaeNegocViewConectorCombo";
	
				public static final String BUSINESSID_CUCOOIDCUENCONT_QUERY ="MMGCccCuentContaViewQueryFromToUser";
				public static final String CUCOOIDCUENCONT_COMBO_CONNECTOR = "CccCuentContaViewConectorCombo";
	
				public static final String BUSINESSID_IMCFOIDIMPOCONTFACT_QUERY ="MMGIntImporContaFactuQueryFromToUser";
				public static final String IMCFOIDIMPOCONTFACT_COMBO_CONNECTOR = "IntImporContaFactuConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable valTipoAsieValues = new Hashtable();
	static{
		valTipoAsieValues.put(new java.lang.String("VN"), "VN");
		valTipoAsieValues.put(new java.lang.String("AB"), "AB");
		valTipoAsieValues.put(new java.lang.String("TN"), "TN");
	}
	protected static Hashtable valIdenCabeDetaValues = new Hashtable();
	static{
		valIdenCabeDetaValues.put(new java.lang.String("C"), "C");
		valIdenCabeDetaValues.put(new java.lang.String("D"), "D");
	}
	protected static Hashtable valIndiDebeHabeValues = new Hashtable();
	static{
		valIndiDebeHabeValues.put(new java.lang.String("D"), "D");
		valIndiDebeHabeValues.put(new java.lang.String("H"), "H");
	}
	
	
	// Definicion del constructor
	public IntParamContaFactuLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("IntParamContaFactuPage");
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
			buildJsPageSize("IntParamContaFactu");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "IntParamContaFactuPage", "cod", "IntParamContaFactu." + accion + ".label");
			
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
			limpiarBotoneraLista("intParamContaFactu", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
		asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "intParamContaFactuLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "IntParamContaFactuPage", "onblur", "window.focus();");
		
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
		conectorAction("IntParamContaFactuLPStartUp");
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
		IntParamContaFactuData intParamContaFactuQuery= new IntParamContaFactuData();
		intParamContaFactuQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		IntParamContaFactuData datosResult = (IntParamContaFactuData)getSingleObject(BUSINESSID_QUERY, intParamContaFactuQuery, 
			intParamContaFactuQuery.clone(), "intParamContaFactu");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		IntParamContaFactuData intParamContaFactu = datosResult;
		asignar("TEXT", "codApun", FormatUtils.formatObject(intParamContaFactu.getCodApun(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(intParamContaFactu.getValTipoAsie() != null){	
			checkCombo("valTipoAsie", FormatUtils.formatObject(intParamContaFactu.getValTipoAsie(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(intParamContaFactu.getValIdenCabeDeta() != null){	
			checkCombo("valIdenCabeDeta", FormatUtils.formatObject(intParamContaFactu.getValIdenCabeDeta(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "valDesc", FormatUtils.formatObject(intParamContaFactu.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(intParamContaFactu.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProd = intParamContaFactu.getMaprOidMarcProd();
		if(maprOidMarcProd != null && maprOidMarcProd.getId() != null) checkCombo("maprOidMarcProd" , maprOidMarcProd.getId().toString());
		es.indra.belcorp.mso.MaeNegocViewData negoOidNego = intParamContaFactu.getNegoOidNego();
		if(negoOidNego != null && negoOidNego.getId() != null) checkCombo("negoOidNego" , negoOidNego.getId().toString());
		asignar("TEXT", "prodOidProd", FormatUtils.formatObject(intParamContaFactu.getProdOidProd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccCuentContaViewData cucoOidCuenCont = intParamContaFactu.getCucoOidCuenCont();
		if(cucoOidCuenCont != null && cucoOidCuenCont.getId() != null) checkCombo("cucoOidCuenCont" , cucoOidCuenCont.getId().toString());
		if(intParamContaFactu.getValIndiDebeHabe() != null){	
			checkCombo("valIndiDebeHabe", FormatUtils.formatObject(intParamContaFactu.getValIndiDebeHabe(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		es.indra.belcorp.mso.IntImporContaFactuData imcfOidImpoContFact = intParamContaFactu.getImcfOidImpoContFact();
		if(imcfOidImpoContFact != null && imcfOidImpoContFact.getId() != null) checkCombo("imcfOidImpoContFact" , imcfOidImpoContFact.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codApun", "disabled", "S");
		
					asignarAtributo("COMBO", "valTipoAsie", "disabled", "S");
					asignarAtributo("COMBO", "valIdenCabeDeta", "disabled", "S");asignarAtributo("TEXT", "valDesc", "disabled", "S");
		asignarAtributo("TEXT", "valGrupArti", "disabled", "S");
		
					asignarAtributo("COMBO", "maprOidMarcProd", "disabled", "S");
					asignarAtributo("COMBO", "negoOidNego", "disabled", "S");asignarAtributo("TEXT", "prodOidProd", "disabled", "S");
		
					asignarAtributo("COMBO", "cucoOidCuenCont", "disabled", "S");
					asignarAtributo("COMBO", "valIndiDebeHabe", "disabled", "S");
					asignarAtributo("COMBO", "imcfOidImpoContFact", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "codApun", "req", "S");
		asignarAtributo("COMBO", "valTipoAsie", "req", "S");
		asignarAtributo("COMBO", "valIdenCabeDeta", "req", "S");
		asignarAtributo("TEXT", "valDesc", "req", "S");
		asignarAtributo("TEXT", "prodOidProd", "req", "S");
		asignarAtributo("COMBO", "cucoOidCuenCont", "req", "S");
		asignarAtributo("COMBO", "valIndiDebeHabe", "req", "S");
		asignarAtributo("COMBO", "imcfOidImpoContFact", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
		asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
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
		asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
		asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
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
		asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
		asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
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
		asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		
		
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
		
		
		asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
		
		
		
		
		
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
		conectorAction("IntParamContaFactuLPStartUp");
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
		//asignarAtributo("FORMULARIO", "intParamContaFactuFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codApun", "req", "S");
				asignarAtributo("COMBO", "valTipoAsie", "req", "S");
				asignarAtributo("COMBO", "valIdenCabeDeta", "req", "S");
				asignarAtributo("TEXT", "valDesc", "req", "S");
				asignarAtributo("TEXT", "prodOidProd", "req", "S");
				asignarAtributo("COMBO", "cucoOidCuenCont", "req", "S");
				asignarAtributo("COMBO", "valIndiDebeHabe", "req", "S");
				asignarAtributo("COMBO", "imcfOidImpoContFact", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codApun", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
			
			
			asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			asignarAtributo("TEXT", "valGrupArti", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 0, 9);");
			
			
			asignarAtributo("TEXT", "prodOidProd", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 20);");
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando IntParamContaFactu");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		IntParamContaFactuData intParamContaFactuQuery= new IntParamContaFactuData();
		intParamContaFactuQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		IntParamContaFactuData  datosResult = (IntParamContaFactuData)getSingleObject(BUSINESSID_QUERY, intParamContaFactuQuery, 
			intParamContaFactuQuery.clone(), "intParamContaFactu");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		IntParamContaFactuData intParamContaFactu = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codApun", FormatUtils.formatObject(intParamContaFactu.getCodApun(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		if(intParamContaFactu.getValTipoAsie() != null){	
			checkCombo("valTipoAsie", FormatUtils.formatObject(intParamContaFactu.getValTipoAsie(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		if(intParamContaFactu.getValIdenCabeDeta() != null){	
			checkCombo("valIdenCabeDeta", FormatUtils.formatObject(intParamContaFactu.getValIdenCabeDeta(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		asignar("TEXT", "valDesc", FormatUtils.formatObject(intParamContaFactu.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valGrupArti", FormatUtils.formatObject(intParamContaFactu.getValGrupArti(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProd = intParamContaFactu.getMaprOidMarcProd();
		if(maprOidMarcProd != null && maprOidMarcProd.getId() != null) checkCombo("maprOidMarcProd" , maprOidMarcProd.getId().toString());
		es.indra.belcorp.mso.MaeNegocViewData negoOidNego = intParamContaFactu.getNegoOidNego();
		if(negoOidNego != null && negoOidNego.getId() != null) checkCombo("negoOidNego" , negoOidNego.getId().toString());
		asignar("TEXT", "prodOidProd", FormatUtils.formatObject(intParamContaFactu.getProdOidProd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.CccCuentContaViewData cucoOidCuenCont = intParamContaFactu.getCucoOidCuenCont();
		if(cucoOidCuenCont != null && cucoOidCuenCont.getId() != null) checkCombo("cucoOidCuenCont" , cucoOidCuenCont.getId().toString());
		if(intParamContaFactu.getValIndiDebeHabe() != null){	
			checkCombo("valIndiDebeHabe", FormatUtils.formatObject(intParamContaFactu.getValIndiDebeHabe(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		}
		es.indra.belcorp.mso.IntImporContaFactuData imcfOidImpoContFact = intParamContaFactu.getImcfOidImpoContFact();
		if(imcfOidImpoContFact != null && imcfOidImpoContFact.getId() != null) checkCombo("imcfOidImpoContFact" , imcfOidImpoContFact.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(intParamContaFactu.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codApun", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codApun", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",2, false)");
				asignarAtributo("TEXT", "valTipoAsie", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",3, true)");
				asignarAtributo("TEXT", "valTipoAsie", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",3, false)");
				asignarAtributo("TEXT", "valIdenCabeDeta", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",4, true)");
				asignarAtributo("TEXT", "valIdenCabeDeta", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",4, false)");
				asignarAtributo("AREATEXTO", "valDesc", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",5, true)");
				asignarAtributo("AREATEXTO", "valDesc", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valGrupArti", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valGrupArti", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",6, false)");
					asignarAtributo("COMBO","maprOidMarcProd", "ontab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",7, true)");
					asignarAtributo("COMBO","maprOidMarcProd", "onshtab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",7, false)");
					asignarAtributo("COMBO","negoOidNego", "ontab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",8, true)");
					asignarAtributo("COMBO","negoOidNego", "onshtab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",8, false)");
				asignarAtributo("AREATEXTO", "prodOidProd", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",9, true)");
				asignarAtributo("AREATEXTO", "prodOidProd", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",9, false)");
					asignarAtributo("COMBO","cucoOidCuenCont", "ontab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",10, true)");
					asignarAtributo("COMBO","cucoOidCuenCont", "onshtab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",10, false)");
				asignarAtributo("TEXT", "valIndiDebeHabe", "ontab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",11, true)");
				asignarAtributo("TEXT", "valIndiDebeHabe", "onshtab","ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",11, false)");
					asignarAtributo("COMBO","imcfOidImpoContFact", "ontab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",12, true)");
					asignarAtributo("COMBO","imcfOidImpoContFact", "onshtab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",12, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",13, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"intParamContaFactuFrm\",13, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","intParamContaFactuTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","intParamContaFactuTrButtons");

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
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de inserción
	*/
	protected void removeNonInsertElements() throws Exception{
		
						borrarCampo("id");
							borrarCampo("paisOidPais");
	}

	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario en el
	* modo de remove
	*/
	protected void removeNonSearchElements() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite eliminar los campos del formulario que no deben aparecer en el formulario 
	* de modificación
	*/
	protected void removeNonModifyFields() throws Exception{
		borrarCampo("id");
		borrarCampo("paisOidPais");
		
	}
	
	/**
	* Nos permite desactivar los campos del formulario que no deben aparecer en el formulario 
	* para modificación
	*/
	protected void desactivateNonModifyFields() throws Exception{
			traza("MMG: en desactivateNonModifyFields ");		
		
				traza("MMG: el atributo es id...");		
				
				traza("MMG: el atributo es codApun...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codApun");
						asignarAtributo ("TEXT", "codApun", "disabled", "S");
				traza("MMG: el atributo es valTipoAsie...");		
				
				traza("MMG: el atributo es valIdenCabeDeta...");		
				
				traza("MMG: el atributo es valDesc...");		
				
				traza("MMG: el atributo es valGrupArti...");		
				
				traza("MMG: el atributo es maprOidMarcProd...");		
				
				traza("MMG: el atributo es negoOidNego...");		
				
				traza("MMG: el atributo es prodOidProd...");		
				
				traza("MMG: el atributo es cucoOidCuenCont...");		
				
				traza("MMG: el atributo es valIndiDebeHabe...");		
				
				traza("MMG: el atributo es imcfOidImpoContFact...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
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
		asignarAtributo("CAPA","intParamContaFactuFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","intParamContaFactuListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","intParamContaFactuListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(IntParamContaFactuData intParamContaFactu) throws Exception{
		HashMap checkedCombos = new HashMap();
		SegMarcaProduData maprOidMarcProd = new SegMarcaProduData();
		
						asignarComboResultados(BUSINESSID_MAPROIDMARCPROD_QUERY,MAPROIDMARCPROD_COMBO_CONNECTOR, 
			maprOidMarcProd, maprOidMarcProd.clone(), "segMarcaProdu", "maprOidMarcProd", "result_ROWSET" );
		if(intParamContaFactu != null && intParamContaFactu.getMaprOidMarcProd() != null){
				checkCombo("maprOidMarcProd" , intParamContaFactu.getMaprOidMarcProd().getId().toString());
			}
		MaeNegocViewData negoOidNego = new MaeNegocViewData();
		
						asignarComboResultados(BUSINESSID_NEGOOIDNEGO_QUERY,NEGOOIDNEGO_COMBO_CONNECTOR, 
			negoOidNego, negoOidNego.clone(), "maeNegocView", "negoOidNego", "result_ROWSET" );
		if(intParamContaFactu != null && intParamContaFactu.getNegoOidNego() != null){
				checkCombo("negoOidNego" , intParamContaFactu.getNegoOidNego().getId().toString());
			}
		CccCuentContaViewData cucoOidCuenCont = new CccCuentContaViewData();
		
						asignarComboResultados(BUSINESSID_CUCOOIDCUENCONT_QUERY,CUCOOIDCUENCONT_COMBO_CONNECTOR, 
			cucoOidCuenCont, cucoOidCuenCont.clone(), "cccCuentContaView", "cucoOidCuenCont", "result_ROWSET" );
		if(intParamContaFactu != null && intParamContaFactu.getCucoOidCuenCont() != null){
				checkCombo("cucoOidCuenCont" , intParamContaFactu.getCucoOidCuenCont().getId().toString());
			}
		IntImporContaFactuData imcfOidImpoContFact = new IntImporContaFactuData();
		
						asignarComboResultados(BUSINESSID_IMCFOIDIMPOCONTFACT_QUERY,IMCFOIDIMPOCONTFACT_COMBO_CONNECTOR, 
			imcfOidImpoContFact, imcfOidImpoContFact.clone(), "intImporContaFactu", "imcfOidImpoContFact", "result_ROWSET" );
		if(intParamContaFactu != null && intParamContaFactu.getImcfOidImpoContFact() != null){
				checkCombo("imcfOidImpoContFact" , intParamContaFactu.getImcfOidImpoContFact().getId().toString());
			}
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(intParamContaFactu != null && intParamContaFactu.getPaisOidPais() != null){
				checkCombo("paisOidPais" , intParamContaFactu.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
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
	* @param intParamContaFactu La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(IntParamContaFactuData intParamContaFactu) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		IntParamContaFactuData intParamContaFactu = 
			(IntParamContaFactuData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(intParamContaFactu.getMaprOidMarcProd() != null){
			intParamContaFactu.setMaprOidMarcProd((es.indra.belcorp.mso.SegMarcaProduData)
			getSingleObject(BUSINESSID_MAPROIDMARCPROD_QUERY, 
			intParamContaFactu.getMaprOidMarcProd(),
			intParamContaFactu.getMaprOidMarcProd().clone(),
			"segMarcaProdu"));
		}
		if(intParamContaFactu.getNegoOidNego() != null){
			intParamContaFactu.setNegoOidNego((es.indra.belcorp.mso.MaeNegocViewData)
			getSingleObject(BUSINESSID_NEGOOIDNEGO_QUERY, 
			intParamContaFactu.getNegoOidNego(),
			intParamContaFactu.getNegoOidNego().clone(),
			"maeNegocView"));
		}
		if(intParamContaFactu.getCucoOidCuenCont() != null){
			intParamContaFactu.setCucoOidCuenCont((es.indra.belcorp.mso.CccCuentContaViewData)
			getSingleObject(BUSINESSID_CUCOOIDCUENCONT_QUERY, 
			intParamContaFactu.getCucoOidCuenCont(),
			intParamContaFactu.getCucoOidCuenCont().clone(),
			"cccCuentContaView"));
		}
		if(intParamContaFactu.getImcfOidImpoContFact() != null){
			intParamContaFactu.setImcfOidImpoContFact((es.indra.belcorp.mso.IntImporContaFactuData)
			getSingleObject(BUSINESSID_IMCFOIDIMPOCONTFACT_QUERY, 
			intParamContaFactu.getImcfOidImpoContFact(),
			intParamContaFactu.getImcfOidImpoContFact().clone(),
			"intImporContaFactu"));
		}
		if(intParamContaFactu.getPaisOidPais() != null){
			intParamContaFactu.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			intParamContaFactu.getPaisOidPais(),
			intParamContaFactu.getPaisOidPais().clone(),
			"segPaisView"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(intParamContaFactu);
		loadLeafDependenceCombos(intParamContaFactu);
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
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			
		}else if(accion.equals(ACCION_VIEW) && origen.equals("preview")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			
		}else if(accion.equals(ACCION_CREATE)){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			
		}else if(accion.equals(ACCION_UPDATE) && origen.equals("preupdate")){
			borrarNodo("TR","nombre","formTr0");
			borrarNodo("TR","nombre","formGapTr0");
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			
		}
	}
	
	
	
		
}





