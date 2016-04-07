/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaLPStartUp.java,v 1.1 2009/12/03 18:42:09 pecbazalar Exp $
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
public class CobEtapaDeudaLPStartUp extends MMGDruidaBase{
	//Constantes que definen la altura de los formularios según el modo
	public static final short QUERYFORM_SIZE = 231;
	public static final short CREATEFORM_SIZE = 791;
	public static final short UPDATEFORM_SIZE = 791;
	public static final short VIEWFORM_SIZE = 791;

	//Cosntantes que definen elementos de la logica de negocio de las entidades
	//y de los elementos asociados a la entidad
	public static final String BUSINESSID_QUERY = "MMGCobEtapaDeudaQueryFromToUserPage";
	
	
				public static final String BUSINESSID_MENSOIDMENS_QUERY ="MMGMsgMensaQueryFromToUser";
				public static final String MENSOIDMENS_COMBO_CONNECTOR = "MsgMensaConectorCombo";
	
				public static final String BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY ="MMGCobMetodLiquiViewQueryFromToUser";
				public static final String MELCOIDMETOLIQUCOBR_COMBO_CONNECTOR = "CobMetodLiquiViewConectorCombo";
	
				public static final String BUSINESSID_TBALOIDTIPOBALA_QUERY ="MMGCobTipoBalanQueryFromToUser";
				public static final String TBALOIDTIPOBALA_COMBO_CONNECTOR = "CobTipoBalanConectorCombo";
	
				public static final String BUSINESSID_GACAOIDGUIOARGUCABE_QUERY ="MMGCobGuionArgumCabecViewQueryFromToUser";
				public static final String GACAOIDGUIOARGUCABE_COMBO_CONNECTOR = "CobGuionArgumCabecViewConectorCombo";
	
				public static final String BUSINESSID_PAISOIDPAIS_QUERY ="MMGSegPaisViewQueryFromToUser";
				public static final String PAISOIDPAIS_COMBO_CONNECTOR = "SegPaisViewConectorCombo";
	
				public static final String BUSINESSID_OREDOIDETAPDEU1_QUERY ="MMGCobOrdenEtapaDeudaQueryFromToUser";
				public static final String OREDOIDETAPDEU1_COMBO_CONNECTOR = "CobOrdenEtapaDeudaConectorCombo";
	
				public static final String BUSINESSID_OREDOIDETAPDEU2_QUERY ="MMGCobOrdenEtapaDeudaQueryFromToUser";
				public static final String OREDOIDETAPDEU2_COMBO_CONNECTOR = "CobOrdenEtapaDeudaConectorCombo";
	
				public static final String BUSINESSID_OREDOIDETAPDEU3_QUERY ="MMGCobOrdenEtapaDeudaQueryFromToUser";
				public static final String OREDOIDETAPDEU3_COMBO_CONNECTOR = "CobOrdenEtapaDeudaConectorCombo";
	
		
	//Hashtables con los valores estáticos de radiobuttons y combos
	protected static Hashtable indExclValues = new Hashtable();
	static{
		indExclValues.put(new java.lang.Long(1), "Si");
		indExclValues.put(new java.lang.Long(0), "No");
	}
	protected static Hashtable indTelfValues = new Hashtable();
	static{
		indTelfValues.put(new java.lang.Long(1), "Si");
		indTelfValues.put(new java.lang.Long(0), "No");
	}
	
	
	// Definicion del constructor
	public CobEtapaDeudaLPStartUp(){
		super();
	}

	public void inicio() throws Exception {
		pagina("CobEtapaDeudaPage");
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
			buildJsPageSize("CobEtapaDeuda");
			
			//Determinamos la acción y el origen
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
			
			//Establecemos el valor del atributro cod de la pagina para que ponga el título i18nalizado
			//y para que funcione de forma correcta la configuración del menú secundario
			asignarAtributo("PAGINA", "CobEtapaDeudaPage", "cod", "CobEtapaDeuda." + accion + ".label");
			
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
			limpiarBotoneraLista("cobEtapaDeuda", accion);
			
			
			
			
			
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
		asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
		asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
		
		//Primero determianmos el nombre del campo en la entidad de oriegen donde se van a cargar los datos
		asignar("VAR", "idAttributeLovOpener", conectorParametro(PARAMETRO_LOV_ATTRIBUTO));
		asignar("VAR", "idEntityLovOpener", conectorParametro(PARAMETRO_LOV_ENTIDAD));
		//asignarAtributo("CAPA", "cobEtapaDeudaLovLayer", "visibilidad", "visible");
		asignarAtributo("PAGINA", "CobEtapaDeudaPage", "onblur", "window.focus();");
		
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
		conectorAction("CobEtapaDeudaLPStartUp");
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
		CobEtapaDeudaData cobEtapaDeudaQuery= new CobEtapaDeudaData();
		cobEtapaDeudaQuery.setId(new Long(conectorParametro("idSelection")));
		
		//Asiganmos el valor a la variable de acción anterior para poder volver hacia atras y hacer requery
		asignar("VAR", VAR_ACCION_ANTERIOR, conectorParametro(VAR_ACCION_ANTERIOR));
		
		//Sacamos de la base de datos la entidad a visualizar
		CobEtapaDeudaData datosResult = (CobEtapaDeudaData)getSingleObject(BUSINESSID_QUERY, cobEtapaDeudaQuery, 
			cobEtapaDeudaQuery.clone(), "cobEtapaDeuda");
		
		
		//Comprobamos que haya datos. Si no indicamos la situación
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndExcl() != null)
			asignar("VAR", "indExclCheckValue", datosResult.getIndExcl().toString());
		if(datosResult.getIndTelf() != null)
			asignar("VAR", "indTelfCheckValue", datosResult.getIndTelf().toString());
		
		
		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Damos los valores a los labels del modo view
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		CobEtapaDeudaData cobEtapaDeuda = datosResult;
		asignar("TEXT", "codEtapDeud", FormatUtils.formatObject(cobEtapaDeuda.getCodEtapDeud(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobEtapaDeuda.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indExcl" , "valor", FormatUtils.formatObject(
			cobEtapaDeuda.getIndExcl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valEdadInic", FormatUtils.formatObject(cobEtapaDeuda.getValEdadInic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valEdadFina", FormatUtils.formatObject(cobEtapaDeuda.getValEdadFina(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTelf" , "valor", FormatUtils.formatObject(
			cobEtapaDeuda.getIndTelf(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "impDesd", FormatUtils.formatObject(cobEtapaDeuda.getImpDesd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "impHast", FormatUtils.formatObject(cobEtapaDeuda.getImpHast(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasGracCompPago", FormatUtils.formatObject(cobEtapaDeuda.getNumDiasGracCompPago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPorcIncu", FormatUtils.formatObject(cobEtapaDeuda.getValPorcIncu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MsgMensaData mensOidMens = cobEtapaDeuda.getMensOidMens();
		if(mensOidMens != null && mensOidMens.getId() != null) checkCombo("mensOidMens" , mensOidMens.getId().toString());
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobr = cobEtapaDeuda.getMelcOidMetoLiquCobr();
		if(melcOidMetoLiquCobr != null && melcOidMetoLiquCobr.getId() != null) checkCombo("melcOidMetoLiquCobr" , melcOidMetoLiquCobr.getId().toString());
		es.indra.belcorp.mso.CobTipoBalanData tbalOidTipoBala = cobEtapaDeuda.getTbalOidTipoBala();
		if(tbalOidTipoBala != null && tbalOidTipoBala.getId() != null) checkCombo("tbalOidTipoBala" , tbalOidTipoBala.getId().toString());
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabe = cobEtapaDeuda.getGacaOidGuioArguCabe();
		if(gacaOidGuioArguCabe != null && gacaOidGuioArguCabe.getId() != null) checkCombo("gacaOidGuioArguCabe" , gacaOidGuioArguCabe.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu1 = cobEtapaDeuda.getOredOidEtapDeu1();
		if(oredOidEtapDeu1 != null && oredOidEtapDeu1.getId() != null) checkCombo("oredOidEtapDeu1" , oredOidEtapDeu1.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu2 = cobEtapaDeuda.getOredOidEtapDeu2();
		if(oredOidEtapDeu2 != null && oredOidEtapDeu2.getId() != null) checkCombo("oredOidEtapDeu2" , oredOidEtapDeu2.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu3 = cobEtapaDeuda.getOredOidEtapDeu3();
		if(oredOidEtapDeu3 != null && oredOidEtapDeu3.getId() != null) checkCombo("oredOidEtapDeu3" , oredOidEtapDeu3.getId().toString());
		
			
		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
			
		//Deshabilitamos todos los campos para que no se editen
		asignarAtributo("TEXT", "codEtapDeud", "disabled", "S");
		asignarAtributo("TEXT", "valDesc", "disabled", "S");
		
					asignarAtributo("RADIOB", "indExcl", "disabled", "S");
		asignarAtributo("TEXT", "valEdadInic", "disabled", "S");
		asignarAtributo("TEXT", "valEdadFina", "disabled", "S");
		
					asignarAtributo("RADIOB", "indTelf", "disabled", "S");
		asignarAtributo("TEXT", "impDesd", "disabled", "S");
		asignarAtributo("TEXT", "impHast", "disabled", "S");
		asignarAtributo("TEXT", "numDiasGracCompPago", "disabled", "S");
		asignarAtributo("TEXT", "valPorcIncu", "disabled", "S");
		
					asignarAtributo("COMBO", "mensOidMens", "disabled", "S");
					asignarAtributo("COMBO", "melcOidMetoLiquCobr", "disabled", "S");
					asignarAtributo("COMBO", "tbalOidTipoBala", "disabled", "S");
					asignarAtributo("COMBO", "gacaOidGuioArguCabe", "disabled", "S");
					asignarAtributo("COMBO", "oredOidEtapDeu1", "disabled", "S");
					asignarAtributo("COMBO", "oredOidEtapDeu2", "disabled", "S");
					asignarAtributo("COMBO", "oredOidEtapDeu3", "disabled", "S");
		
	
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
		asignarAtributo("TEXT", "codEtapDeud", "req", "S");
		asignarAtributo("TEXT", "valDesc", "req", "S");
		asignarAtributo("TEXT", "valEdadInic", "req", "S");
		asignarAtributo("TEXT", "valEdadFina", "req", "S");
		asignarAtributo("RADIOB", "indTelf", "req", "S");
		asignarAtributo("TEXT", "impDesd", "req", "S");
		asignarAtributo("TEXT", "impHast", "req", "S");
		asignarAtributo("TEXT", "numDiasGracCompPago", "req", "S");
		asignarAtributo("TEXT", "valPorcIncu", "req", "S");
		asignarAtributo("COMBO", "oredOidEtapDeu1", "req", "S");
		
		
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
		asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		
		asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
		asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
		
		asignarAtributo("TEXT", "impDesd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impDesd', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");
        
        /*
         * Fue modificada la siguiente línea debido a la incidencia DBLG500000832.
         * Ver archivo DBLG500000832.doc adjunto a la incidencia.
         * Línea original: asignarAtributo("TEXT", "impHast", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impHast', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");if (mensaje=='OK') validacionimpHastimpDesd(); else muestraMsgError(mensaje);");
         */        
        asignarAtributo("TEXT", "impHast", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impHast', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");if (mensaje=='OK') validacionimpHastimpDesd();");

        asignarAtributo("TEXT", "numDiasGracCompPago", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
		asignarAtributo("TEXT", "valPorcIncu", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.valPorcIncu', 0.0, " + 100.0 + ");");
		
		
		
		
		
		
		
		
		
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
		asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
		asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
		
		
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
		asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
		asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
		
		
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
		asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
		asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
		asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
		asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
		
		
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
		conectorAction("CobEtapaDeudaLPStartUp");
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
		//asignarAtributo("FORMULARIO", "cobEtapaDeudaFrm", "oculto", "N");

		//Ponemos los campos requeridos a true
		
				asignarAtributo("TEXT", "codEtapDeud", "req", "S");
				asignarAtributo("TEXT", "valDesc", "req", "S");
				asignarAtributo("TEXT", "valEdadInic", "req", "S");
				asignarAtributo("TEXT", "valEdadFina", "req", "S");
				asignarAtributo("RADIOB", "indTelf", "req", "S");
				asignarAtributo("TEXT", "impDesd", "req", "S");
				asignarAtributo("TEXT", "impHast", "req", "S");
				asignarAtributo("TEXT", "numDiasGracCompPago", "req", "S");
				asignarAtributo("TEXT", "valPorcIncu", "req", "S");
				asignarAtributo("COMBO", "oredOidEtapDeu1", "req", "S");
		
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
		
			asignarAtributo("TEXT", "codEtapDeud", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 4);");
			asignarAtributo("TEXT", "valDesc", "validacion", "mensaje = ValidaLongitud(cdos_trim(valor), 1, 40);");
			
			asignarAtributo("TEXT", "valEdadInic", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);");
			asignarAtributo("TEXT", "valEdadFina", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 4, 0, 9999);if (mensaje=='OK') validacionvalEdadFinavalEdadInic(); else muestraMsgError(mensaje);");
			
			asignarAtributo("TEXT", "impDesd", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impDesd', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");");

            /*
             * Fue modificada la siguiente línea debido a la incidencia DBLG500000832.
             * Ver archivo DBLG500000832.doc adjunto a la incidencia.
             * Línea original: asignarAtributo("TEXT", "impHast", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impHast', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");if (mensaje=='OK') validacionimpHastimpDesd(); else muestraMsgError(mensaje);");
             */
            asignarAtributo("TEXT", "impHast", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (12 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.impHast', -9.99999999999E11, " + MMGDruidaHelper.getMaxValueForDruidaValidaFloat((12 - MMGDruidaHelper.getUserDecimalPrecision(this)), this) + ");if (mensaje=='OK') validacionimpHastimpDesd();");
			asignarAtributo("TEXT", "numDiasGracCompPago", "validacion", "mensaje = ValidaInt(cdos_trim(valor), 3, 0, 999);");
			asignarAtributo("TEXT", "valPorcIncu", "validacion", "mensaje = ValidaNumeroMMG(cdos_trim(valor), " + (5 - MMGDruidaHelper.getUserDecimalPrecision(this)) + ", " + MMGDruidaHelper.getUserDecimalPrecision(this)+ ", 'CobEtapaDeuda.valPorcIncu', 0.0, " + 100.0 + ");");
			
			
			
			
			
			
			

		//Obtenemos el id del elemento a seleccionar
		traza("MMG::Creando CobEtapaDeuda");
		String id = conectorParametro("idSelection");
		traza("MMG:: id del atributo a modificar: " + id);
	
		//Construimos el mso con los elementos de la búsqueda
		CobEtapaDeudaData cobEtapaDeudaQuery= new CobEtapaDeudaData();
		cobEtapaDeudaQuery.setId(new Long(id));

		//Sacamos de la base de datos la entidad a modificar
		CobEtapaDeudaData  datosResult = (CobEtapaDeudaData)getSingleObject(BUSINESSID_QUERY, cobEtapaDeudaQuery, 
			cobEtapaDeudaQuery.clone(), "cobEtapaDeuda");
		

		//Comprobamos que haya datos. Si no indicamos la situaciópn
		if(datosResult == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		
		
		//Guardamos los valores de los radiobuttons
		if(datosResult.getIndExcl() != null)
			asignar("VAR", "indExclCheckValue", datosResult.getIndExcl().toString());
		if(datosResult.getIndTelf() != null)
			asignar("VAR", "indTelfCheckValue", datosResult.getIndTelf().toString());
		

		//Cargamos los combos y seleccionamos en los combos los valores correspondientes
		loadLeafDependenceCombos(datosResult);
		loadNonLeafDependenceCombos(datosResult);
		
		//Vamos cargamos los datos en el formulario. Muy importante es establecer id del elemento que estamos modificando
		CobEtapaDeudaData cobEtapaDeuda = datosResult;
		asignar("VAR", "idSelection", id);
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(UtilidadesSession.getSeparadorDecimales(this).charAt(0));
		decimalFormatSymbols.setGroupingSeparator(UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
		asignar("TEXT", "codEtapDeud", FormatUtils.formatObject(cobEtapaDeuda.getCodEtapDeud(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valDesc", FormatUtils.formatObject(cobEtapaDeuda.getValDesc(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indExcl" , "valor", FormatUtils.formatObject(
			cobEtapaDeuda.getIndExcl(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valEdadInic", FormatUtils.formatObject(cobEtapaDeuda.getValEdadInic(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valEdadFina", FormatUtils.formatObject(cobEtapaDeuda.getValEdadFina(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignarAtributo("RADIOB", "indTelf" , "valor", FormatUtils.formatObject(
			cobEtapaDeuda.getIndTelf(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "impDesd", FormatUtils.formatObject(cobEtapaDeuda.getImpDesd(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "impHast", FormatUtils.formatObject(cobEtapaDeuda.getImpHast(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "numDiasGracCompPago", FormatUtils.formatObject(cobEtapaDeuda.getNumDiasGracCompPago(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		asignar("TEXT", "valPorcIncu", FormatUtils.formatObject(cobEtapaDeuda.getValPorcIncu(), 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), decimalFormatSymbols));
		es.indra.belcorp.mso.MsgMensaData mensOidMens = cobEtapaDeuda.getMensOidMens();
		if(mensOidMens != null && mensOidMens.getId() != null) checkCombo("mensOidMens" , mensOidMens.getId().toString());
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobr = cobEtapaDeuda.getMelcOidMetoLiquCobr();
		if(melcOidMetoLiquCobr != null && melcOidMetoLiquCobr.getId() != null) checkCombo("melcOidMetoLiquCobr" , melcOidMetoLiquCobr.getId().toString());
		es.indra.belcorp.mso.CobTipoBalanData tbalOidTipoBala = cobEtapaDeuda.getTbalOidTipoBala();
		if(tbalOidTipoBala != null && tbalOidTipoBala.getId() != null) checkCombo("tbalOidTipoBala" , tbalOidTipoBala.getId().toString());
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabe = cobEtapaDeuda.getGacaOidGuioArguCabe();
		if(gacaOidGuioArguCabe != null && gacaOidGuioArguCabe.getId() != null) checkCombo("gacaOidGuioArguCabe" , gacaOidGuioArguCabe.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu1 = cobEtapaDeuda.getOredOidEtapDeu1();
		if(oredOidEtapDeu1 != null && oredOidEtapDeu1.getId() != null) checkCombo("oredOidEtapDeu1" , oredOidEtapDeu1.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu2 = cobEtapaDeuda.getOredOidEtapDeu2();
		if(oredOidEtapDeu2 != null && oredOidEtapDeu2.getId() != null) checkCombo("oredOidEtapDeu2" , oredOidEtapDeu2.getId().toString());
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu3 = cobEtapaDeuda.getOredOidEtapDeu3();
		if(oredOidEtapDeu3 != null && oredOidEtapDeu3.getId() != null) checkCombo("oredOidEtapDeu3" , oredOidEtapDeu3.getId().toString());
		

		//Sacamos la información de los campos internacionalizables. Para cada campo internacionalizable
		//	Construimos el mso con los elementos de la búsqueda
		//	Creamos el dto y metemos la información necesaria para ejecutar la query
		//	Invocamos la lógica de negocio
		
		
		//Sobreescribimos el valor de origen para que en la siguiente llamada de la acción
		//vaya directamente al metodo que realmente modifica
		asignar("VAR",PARAMETRO_GENERICO_ORIGEN,"pagina");
		
		//Guardamos el timestamp del elemento que se está modificando
		//Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
		//asignar("VAR","timestamp",Long.toString(cobEtapaDeuda.jdoGetTimeStamp()));
		
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
				asignarAtributo("AREATEXTO", "id", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",1, true)");
				asignarAtributo("AREATEXTO", "id", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",1, false)");
				asignarAtributo("AREATEXTO", "codEtapDeud", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",2, true)");
				asignarAtributo("AREATEXTO", "codEtapDeud", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",2, false)");
				asignarAtributo("AREATEXTO", "valDesc", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",3, true)");
				asignarAtributo("AREATEXTO", "valDesc", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",3, false)");
				asignarAtributo("TEXT", "indExcl", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",4, true)");
				asignarAtributo("TEXT", "indExcl", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",4, false)");
				asignarAtributo("AREATEXTO", "valEdadInic", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",5, true)");
				asignarAtributo("AREATEXTO", "valEdadInic", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",5, false)");
				asignarAtributo("AREATEXTO", "valEdadFina", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",6, true)");
				asignarAtributo("AREATEXTO", "valEdadFina", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",6, false)");
				asignarAtributo("TEXT", "indTelf", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",7, true)");
				asignarAtributo("TEXT", "indTelf", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",7, false)");
				asignarAtributo("AREATEXTO", "impDesd", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",8, true)");
				asignarAtributo("AREATEXTO", "impDesd", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",8, false)");
				asignarAtributo("AREATEXTO", "impHast", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",9, true)");
				asignarAtributo("AREATEXTO", "impHast", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",9, false)");
				asignarAtributo("AREATEXTO", "numDiasGracCompPago", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",10, true)");
				asignarAtributo("AREATEXTO", "numDiasGracCompPago", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",10, false)");
				asignarAtributo("AREATEXTO", "valPorcIncu", "ontab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",11, true)");
				asignarAtributo("AREATEXTO", "valPorcIncu", "onshtab","ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",11, false)");
					asignarAtributo("COMBO","mensOidMens", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",12, true)");
					asignarAtributo("COMBO","mensOidMens", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",12, false)");
					asignarAtributo("COMBO","melcOidMetoLiquCobr", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",13, true)");
					asignarAtributo("COMBO","melcOidMetoLiquCobr", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",13, false)");
					asignarAtributo("COMBO","tbalOidTipoBala", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",14, true)");
					asignarAtributo("COMBO","tbalOidTipoBala", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",14, false)");
					asignarAtributo("COMBO","gacaOidGuioArguCabe", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",15, true)");
					asignarAtributo("COMBO","gacaOidGuioArguCabe", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",15, false)");
					asignarAtributo("COMBO","paisOidPais", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",16, true)");
					asignarAtributo("COMBO","paisOidPais", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",16, false)");
					asignarAtributo("COMBO","oredOidEtapDeu1", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",17, true)");
					asignarAtributo("COMBO","oredOidEtapDeu1", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",17, false)");
					asignarAtributo("COMBO","oredOidEtapDeu2", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",18, true)");
					asignarAtributo("COMBO","oredOidEtapDeu2", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",18, false)");
					asignarAtributo("COMBO","oredOidEtapDeu3", "ontab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",19, true)");
					asignarAtributo("COMBO","oredOidEtapDeu3", "onshtab", "ejecutarAccionFocoModificacion(\"cobEtapaDeudaFrm\",19, false)");
	}
	
	/**Nos permite eliminar de la página todos los elementos correspondiente
	a las internacionalizacion*/
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		borrarNodo("TD","nombre","cobEtapaDeudaTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		//Borramos los botones para realizar la búsuqeda
		borrarNodo("TR","nombre","cobEtapaDeudaTrButtons");

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
		borrarCampo("indExcl");
		borrarCampo("indTelf");
		borrarCampo("impDesd");
		borrarCampo("impHast");
		borrarCampo("numDiasGracCompPago");
		borrarCampo("valPorcIncu");
		borrarCampo("mensOidMens");
		borrarCampo("melcOidMetoLiquCobr");
		borrarCampo("tbalOidTipoBala");
		borrarCampo("gacaOidGuioArguCabe");
		borrarCampo("paisOidPais");
		borrarCampo("oredOidEtapDeu1");
		borrarCampo("oredOidEtapDeu2");
		borrarCampo("oredOidEtapDeu3");
		
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
				
				traza("MMG: el atributo es codEtapDeud...");		
				
					traza("MMG: en desactivateNonModifyFields encontrado atributo no editable...");
				
						// borrarCampo("codEtapDeud");
						asignarAtributo ("TEXT", "codEtapDeud", "disabled", "S");
				traza("MMG: el atributo es valDesc...");		
				
				traza("MMG: el atributo es indExcl...");		
				
				traza("MMG: el atributo es valEdadInic...");		
				
				traza("MMG: el atributo es valEdadFina...");		
				
				traza("MMG: el atributo es indTelf...");		
				
				traza("MMG: el atributo es impDesd...");		
				
				traza("MMG: el atributo es impHast...");		
				
				traza("MMG: el atributo es numDiasGracCompPago...");		
				
				traza("MMG: el atributo es valPorcIncu...");		
				
				traza("MMG: el atributo es mensOidMens...");		
				
				traza("MMG: el atributo es melcOidMetoLiquCobr...");		
				
				traza("MMG: el atributo es tbalOidTipoBala...");		
				
				traza("MMG: el atributo es gacaOidGuioArguCabe...");		
				
				traza("MMG: el atributo es paisOidPais...");		
				
				traza("MMG: el atributo es oredOidEtapDeu1...");		
				
				traza("MMG: el atributo es oredOidEtapDeu2...");		
				
				traza("MMG: el atributo es oredOidEtapDeu3...");		
				
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
		asignarAtributo("CAPA","cobEtapaDeudaFormLayer", "alto", String.valueOf(sizeForm));		
		
		//Estabelcemos la posicion y de la capa correspondiente a la lista y de su botonera
		asignarAtributo("CAPA","cobEtapaDeudaListLayer", "y", String.valueOf(sizeForm + 26));		
		asignarAtributo("CAPA","cobEtapaDeudaListButtonsLayer", "y", String.valueOf(sizeForm + 278));		
	}

	/**
	* Nos permite cargar las combos finales de la jerarquías de dependencia
	*/
	protected void loadLeafDependenceCombos(CobEtapaDeudaData cobEtapaDeuda) throws Exception{
		HashMap checkedCombos = new HashMap();
		MsgMensaData mensOidMens = new MsgMensaData();
		
						asignarComboResultados(BUSINESSID_MENSOIDMENS_QUERY,MENSOIDMENS_COMBO_CONNECTOR, 
			mensOidMens, mensOidMens.clone(), "msgMensa", "mensOidMens", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getMensOidMens() != null){
				checkCombo("mensOidMens" , cobEtapaDeuda.getMensOidMens().getId().toString());
			}
		CobMetodLiquiViewData melcOidMetoLiquCobr = new CobMetodLiquiViewData();
		
						asignarComboResultados(BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY,MELCOIDMETOLIQUCOBR_COMBO_CONNECTOR, 
			melcOidMetoLiquCobr, melcOidMetoLiquCobr.clone(), "cobMetodLiquiView", "melcOidMetoLiquCobr", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getMelcOidMetoLiquCobr() != null){
				checkCombo("melcOidMetoLiquCobr" , cobEtapaDeuda.getMelcOidMetoLiquCobr().getId().toString());
			}
		CobTipoBalanData tbalOidTipoBala = new CobTipoBalanData();
		
						asignarComboResultados(BUSINESSID_TBALOIDTIPOBALA_QUERY,TBALOIDTIPOBALA_COMBO_CONNECTOR, 
			tbalOidTipoBala, tbalOidTipoBala.clone(), "cobTipoBalan", "tbalOidTipoBala", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getTbalOidTipoBala() != null){
				checkCombo("tbalOidTipoBala" , cobEtapaDeuda.getTbalOidTipoBala().getId().toString());
			}
		CobGuionArgumCabecViewData gacaOidGuioArguCabe = new CobGuionArgumCabecViewData();
		
						asignarComboResultados(BUSINESSID_GACAOIDGUIOARGUCABE_QUERY,GACAOIDGUIOARGUCABE_COMBO_CONNECTOR, 
			gacaOidGuioArguCabe, gacaOidGuioArguCabe.clone(), "cobGuionArgumCabecView", "gacaOidGuioArguCabe", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getGacaOidGuioArguCabe() != null){
				checkCombo("gacaOidGuioArguCabe" , cobEtapaDeuda.getGacaOidGuioArguCabe().getId().toString());
			}
		SegPaisViewData paisOidPais = new SegPaisViewData();
		
						asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,PAISOIDPAIS_COMBO_CONNECTOR, 
			paisOidPais, paisOidPais.clone(), "segPaisView", "paisOidPais", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getPaisOidPais() != null){
				checkCombo("paisOidPais" , cobEtapaDeuda.getPaisOidPais().getId().toString());
			}
		String paisOidPaisDefaultValue = MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
		if(paisOidPaisDefaultValue != null && !paisOidPaisDefaultValue.trim().equals("")){
			checkCombo("paisOidPais", paisOidPaisDefaultValue);
			checkedCombos.put("paisOidPais",paisOidPaisDefaultValue);
			cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		CobOrdenEtapaDeudaData oredOidEtapDeu1 = new CobOrdenEtapaDeudaData();
		
						asignarComboResultados(BUSINESSID_OREDOIDETAPDEU1_QUERY,OREDOIDETAPDEU1_COMBO_CONNECTOR, 
			oredOidEtapDeu1, oredOidEtapDeu1.clone(), "cobOrdenEtapaDeuda", "oredOidEtapDeu1", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getOredOidEtapDeu1() != null){
				checkCombo("oredOidEtapDeu1" , cobEtapaDeuda.getOredOidEtapDeu1().getId().toString());
			}
		CobOrdenEtapaDeudaData oredOidEtapDeu2 = new CobOrdenEtapaDeudaData();
		
						asignarComboResultados(BUSINESSID_OREDOIDETAPDEU2_QUERY,OREDOIDETAPDEU2_COMBO_CONNECTOR, 
			oredOidEtapDeu2, oredOidEtapDeu2.clone(), "cobOrdenEtapaDeuda", "oredOidEtapDeu2", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getOredOidEtapDeu2() != null){
				checkCombo("oredOidEtapDeu2" , cobEtapaDeuda.getOredOidEtapDeu2().getId().toString());
			}
		CobOrdenEtapaDeudaData oredOidEtapDeu3 = new CobOrdenEtapaDeudaData();
		
						asignarComboResultados(BUSINESSID_OREDOIDETAPDEU3_QUERY,OREDOIDETAPDEU3_COMBO_CONNECTOR, 
			oredOidEtapDeu3, oredOidEtapDeu3.clone(), "cobOrdenEtapaDeuda", "oredOidEtapDeu3", "result_ROWSET" );
		if(cobEtapaDeuda != null && cobEtapaDeuda.getOredOidEtapDeu3() != null){
				checkCombo("oredOidEtapDeu3" , cobEtapaDeuda.getOredOidEtapDeu3().getId().toString());
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
	* @param cobEtapaDeuda La el objetopar la cual se va a realizar la carga
	*/
	protected void loadNonLeafDependenceCombos(CobEtapaDeudaData cobEtapaDeuda) 
		throws Exception{
		
	}
	
	/**
	* Nos permite cargar los combos y seleccionar los elementos tal como estaban en la última query
	*/
	protected void loadNonLeafDependenceCombosForRequery() throws Exception{
		//Priemero obtenemos lso objetos from y to con todos los datos de la búsqueda
		CobEtapaDeudaData cobEtapaDeuda = 
			(CobEtapaDeudaData) conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
		//Cargamos todos los objetos completos correspodnientes a los valores de los
		//Campos que sean raiz de una jerarquía de combos dependientes
		if(cobEtapaDeuda.getMensOidMens() != null){
			cobEtapaDeuda.setMensOidMens((es.indra.belcorp.mso.MsgMensaData)
			getSingleObject(BUSINESSID_MENSOIDMENS_QUERY, 
			cobEtapaDeuda.getMensOidMens(),
			cobEtapaDeuda.getMensOidMens().clone(),
			"msgMensa"));
		}
		if(cobEtapaDeuda.getMelcOidMetoLiquCobr() != null){
			cobEtapaDeuda.setMelcOidMetoLiquCobr((es.indra.belcorp.mso.CobMetodLiquiViewData)
			getSingleObject(BUSINESSID_MELCOIDMETOLIQUCOBR_QUERY, 
			cobEtapaDeuda.getMelcOidMetoLiquCobr(),
			cobEtapaDeuda.getMelcOidMetoLiquCobr().clone(),
			"cobMetodLiquiView"));
		}
		if(cobEtapaDeuda.getTbalOidTipoBala() != null){
			cobEtapaDeuda.setTbalOidTipoBala((es.indra.belcorp.mso.CobTipoBalanData)
			getSingleObject(BUSINESSID_TBALOIDTIPOBALA_QUERY, 
			cobEtapaDeuda.getTbalOidTipoBala(),
			cobEtapaDeuda.getTbalOidTipoBala().clone(),
			"cobTipoBalan"));
		}
		if(cobEtapaDeuda.getGacaOidGuioArguCabe() != null){
			cobEtapaDeuda.setGacaOidGuioArguCabe((es.indra.belcorp.mso.CobGuionArgumCabecViewData)
			getSingleObject(BUSINESSID_GACAOIDGUIOARGUCABE_QUERY, 
			cobEtapaDeuda.getGacaOidGuioArguCabe(),
			cobEtapaDeuda.getGacaOidGuioArguCabe().clone(),
			"cobGuionArgumCabecView"));
		}
		if(cobEtapaDeuda.getPaisOidPais() != null){
			cobEtapaDeuda.setPaisOidPais((es.indra.belcorp.mso.SegPaisViewData)
			getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
			cobEtapaDeuda.getPaisOidPais(),
			cobEtapaDeuda.getPaisOidPais().clone(),
			"segPaisView"));
		}
		if(cobEtapaDeuda.getOredOidEtapDeu1() != null){
			cobEtapaDeuda.setOredOidEtapDeu1((es.indra.belcorp.mso.CobOrdenEtapaDeudaData)
			getSingleObject(BUSINESSID_OREDOIDETAPDEU1_QUERY, 
			cobEtapaDeuda.getOredOidEtapDeu1(),
			cobEtapaDeuda.getOredOidEtapDeu1().clone(),
			"cobOrdenEtapaDeuda"));
		}
		if(cobEtapaDeuda.getOredOidEtapDeu2() != null){
			cobEtapaDeuda.setOredOidEtapDeu2((es.indra.belcorp.mso.CobOrdenEtapaDeudaData)
			getSingleObject(BUSINESSID_OREDOIDETAPDEU2_QUERY, 
			cobEtapaDeuda.getOredOidEtapDeu2(),
			cobEtapaDeuda.getOredOidEtapDeu2().clone(),
			"cobOrdenEtapaDeuda"));
		}
		if(cobEtapaDeuda.getOredOidEtapDeu3() != null){
			cobEtapaDeuda.setOredOidEtapDeu3((es.indra.belcorp.mso.CobOrdenEtapaDeudaData)
			getSingleObject(BUSINESSID_OREDOIDETAPDEU3_QUERY, 
			cobEtapaDeuda.getOredOidEtapDeu3(),
			cobEtapaDeuda.getOredOidEtapDeu3().clone(),
			"cobOrdenEtapaDeuda"));
		}
		
		//Una vez que tenemos completo los datos de los atributos raices de jerarquías de dependencias
		//cargamos las combos y seleccionamos elementos
		loadNonLeafDependenceCombos(cobEtapaDeuda);
		loadLeafDependenceCombos(cobEtapaDeuda);
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
			borrarNodo("TR","nombre","formTr3");
			borrarNodo("TR","nombre","formGapTr3");
			borrarNodo("TR","nombre","formTr6");
			borrarNodo("TR","nombre","formGapTr6");
			borrarNodo("TR","nombre","formTr7");
			borrarNodo("TR","nombre","formGapTr7");
			borrarNodo("TR","nombre","formTr8");
			borrarNodo("TR","nombre","formGapTr8");
			borrarNodo("TR","nombre","formTr9");
			borrarNodo("TR","nombre","formGapTr9");
			borrarNodo("TR","nombre","formTr10");
			borrarNodo("TR","nombre","formGapTr10");
			borrarNodo("TR","nombre","formTr11");
			borrarNodo("TR","nombre","formGapTr11");
			borrarNodo("TR","nombre","formTr12");
			borrarNodo("TR","nombre","formGapTr12");
			borrarNodo("TR","nombre","formTr13");
			borrarNodo("TR","nombre","formGapTr13");
			borrarNodo("TR","nombre","formTr14");
			borrarNodo("TR","nombre","formGapTr14");
			borrarNodo("TR","nombre","formTr15");
			borrarNodo("TR","nombre","formGapTr15");
			borrarNodo("TR","nombre","formTr16");
			borrarNodo("TR","nombre","formGapTr16");
			borrarNodo("TR","nombre","formTr17");
			borrarNodo("TR","nombre","formGapTr17");
			
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





